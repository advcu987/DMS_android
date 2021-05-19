# DMS_android
basic Driver Monitoring System for Android, running on PyTorch


## TODO

[x] run Pytorch Android demo on Moto

[X] basic Android **GUI** \
[x] camera permission in Manifest

[X] live stream Moto camera in GUI

[x] use CameraX instead of deprecated Camera

[ ] run basic **face detection** pytorch model (eg. facenet) on Moto live camera feed \

[ ] objectDetection -> CameraXActivity.java -> setupCameraX() ---> DMS -> CameraFragment.kt -> bindCameraUseCases -> imageAnalyzer

**face recognition model** (label driver/user): \
[ ] get labeled samples \
[ ] train model \
[ ] greet user with audio when detection successfull \
    
**driver attention model**: \
[ ] pretrained/train from scratch (?) \
[ ] samples for training \
[ ] warn driver when attention is off (distracted driver) with audio/video signal \
