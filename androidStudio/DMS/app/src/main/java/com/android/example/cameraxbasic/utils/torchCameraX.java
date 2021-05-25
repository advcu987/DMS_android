//package com.android.example.cameraxbasic.utils;
//
//import android.os.SystemClock;
//import android.util.Size;
//import android.view.TextureView;
//
//import androidx.camera.core.CameraX;
//import androidx.camera.core.ImageAnalysis;
//import androidx.camera.core.Preview;
//import androidx.camera.core.impl.ImageAnalysisConfig;
//import androidx.camera.core.impl.PreviewConfig;
//
//import com.android.example.cameraxbasic.R;
//
//public class torchCameraX {
//
//    private void setupCameraX() {
////        final TextureView textureView = getCameraPreviewTextureView();
////        final PreviewConfig previewConfig = new PreviewConfig.Builder().build();
////        final Preview preview = new Preview(previewConfig);
////        preview.setOnPreviewOutputUpdateListener(output -> textureView.setSurfaceTexture(output.getSurfaceTexture()));
//
//        final ImageAnalysisConfig imageAnalysisConfig =
//                new ImageAnalysisConfig.Builder()
//                        .setTargetResolution(new Size(480, 640))
//                        .setCallbackHandler(mBackgroundHandler)
//                        .setImageReaderMode(ImageAnalysis.ImageReaderMode.ACQUIRE_LATEST_IMAGE)
//                        .build();
//        final ImageAnalysis imageAnalysis = new ImageAnalysis(imageAnalysisConfig);
//        imageAnalysis.setAnalyzer((image, rotationDegrees) -> {
//            if (SystemClock.elapsedRealtime() - mLastAnalysisResultTime < 500) {
//                return;
//            }
//
//            final R result = analyzeImage(image, rotationDegrees);
//            if (result != null) {
//                mLastAnalysisResultTime = SystemClock.elapsedRealtime();
//                runOnUiThread(() -> applyToUiAnalyzeImageResult(result));
//            }
//        });
//
//        CameraX.bindToLifecycle(this, preview, imageAnalysis);
//    }
//}
