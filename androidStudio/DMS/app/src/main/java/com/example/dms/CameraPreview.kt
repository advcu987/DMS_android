package com.example.dms

import android.content.Context
import android.hardware.Camera
import android.util.Log
import android.view.SurfaceHolder
import android.view.SurfaceView
import java.io.IOException

/** A basic Camera preview class  */
class CameraPreview(context: Context?, camera: Camera) : SurfaceView(context), SurfaceHolder.Callback {
    private val mHolder: SurfaceHolder
    private val mCamera: Camera
    fun surfaceCreated(holder: SurfaceHolder?) {
        // The Surface has been created, now tell the camera where to draw the preview.
        try {
            mCamera.setPreviewDisplay(mHolder)
            mCamera.setDisplayOrientation(90)
            mCamera.startPreview()
        } catch (e: IOException) {
            Log.d(TAG, "Error setting camera preview: " + e.getMessage())
        }
    }

    fun surfaceDestroyed(holder: SurfaceHolder?) {
        // empty. Take care of releasing the Camera preview in your activity.
        mCamera.release()
    }

    fun surfaceChanged(holder: SurfaceHolder?, format: Int, w: Int, h: Int) {
        // If your preview can change or rotate, take care of those events here.
        // Make sure to stop the preview before resizing or reformatting it.
        if (mHolder.getSurface() == null) {
            // preview surface does not exist
            return
        }

        // stop preview before making changes
        try {
            mCamera.stopPreview()
        } catch (e: Exception) {
            // ignore: tried to stop a non-existent preview
        }

        // set preview size and make any resize, rotate or
        // reformatting changes here

        // start preview with new settings
        try {
            mCamera.setPreviewDisplay(mHolder)
            mCamera.startPreview()
        } catch (e: Exception) {
            Log.d(TAG, "Error starting camera preview: " + e.getMessage())
        }
    }

    companion object {
        private const val TAG = "Camera Preview"
    }

    init {
        mCamera = camera

        // Install a SurfaceHolder.Callback so we get notified when the
        // underlying surface is created and destroyed.
        mHolder = getHolder()
        mHolder.addCallback(this)
    }
}