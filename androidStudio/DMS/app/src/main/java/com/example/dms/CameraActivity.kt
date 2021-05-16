package com.example.dms
// CameraX stuff
import androidx.appcompat.app.AppCompatActivity

class CameraActivity : AppCompatActivity() {
    private var cameraProviderFuture: ListenableFuture<ProcessCameraProvider>? = null
    @Override
    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // User permission handling
        // Source: https://www.geeksforgeeks.org/android-how-to-request-permissions-in-android-application/
        checkPermission(Manifest.permission.CAMERA, CAMERA_PERMISSION_CODE)

        // CameraX: Request a CameraProvider
        cameraProviderFuture = ProcessCameraProvider.getInstance(this)


        // Create an instance of Camera
        val mCamera: Camera? = cameraInstance

        // Create our Preview view and set it as the content of our activity.
        val mPreview = CameraPreview(this, mCamera)
        val preview: FrameLayout = findViewById(R.id.camera_preview)
        preview.addView(mPreview)
    }

    // This function is called when user accept or decline the permission.
    // Request Code is used to check which permission called this function.
    // This request code is provided when user is prompt for permission.
    @Override
    fun onRequestPermissionsResult(requestCode: Int,
                                   @NonNull permissions: Array<String?>?,
                                   @NonNull grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == CAMERA_PERMISSION_CODE) {

            // Checking whether user granted the permission or not.
            if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                // Showing the toast message
                Toast.makeText(this, "Camera Permission Granted", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Camera Permission Denied", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Function to check and request permission
    fun checkPermission(permission: String, requestCode: Int) {
        // Checking if permission is not granted
        if (ContextCompat.checkSelfPermission(this, permission) === PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this, arrayOf(permission), requestCode)
        } else {
            Toast.makeText(this, "Permission already granted", Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        private const val CAMERA_PERMISSION_CODE = 101// Camera is not available (in use or does not exist)
        // returns null if camera is unavailable
// If called with '1', it will open the front facing camera
        // TODO: do this more elegantly, using Camera.getNumberofCameras()
        // attempt to get a Camera instance
        /** A safe way to get an instance of the Camera object.  */
        val cameraInstance: Camera?
            get() {
                var c: Camera? = null
                try {
                    // If called with '1', it will open the front facing camera
                    // TODO: do this more elegantly, using Camera.getNumberofCameras()
                    c = Camera.open(1) // attempt to get a Camera instance
                } catch (e: Exception) {
                    // Camera is not available (in use or does not exist)
                }
                return c // returns null if camera is unavailable
            }
    }
}