# DMS_android
basic Driver Monitoring System for Android, running on PyTorch


## TODO

[x] run Pytorch Android demo on Moto

[X] basic Android **GUI** \
[x] camera permission in Manifest

[X] live stream Moto camera in GUI

[x] use CameraX instead of deprecated Camera

[x] objectDetection -> CameraXActivity.java -> setupCameraX() ---> DMS -> CameraFragment.kt -> bindCameraUseCases -> imageAnalyzer

[x] fix CameraFragment.kt -> analyzeImage return type (ArrayList<Result>)

[x] fix CameraFragment.kt -> add extraction of classes (?) -> dummy

[x] fix CameraFragment.kt -> nonMaxSuppression -> Comparator -> dummy

[ ] fix CameraFragment.kt -> analyzeImage -> model inference for yolo model

[ ] modify and load other model than what's provided in the tutorial


[ ] run basic **face detection** pytorch model (eg. facenet) on Moto live camera feed \


[ ] run basic **yolov5** pytorch model (object detection) on Moto live camera feed \


**face recognition model** (label driver/user): \
[ ] get labeled samples \
[ ] train model \
[ ] greet user with audio when detection successfull \
    
**driver attention model**: \
[ ] pretrained/train from scratch (?) \
[ ] samples for training \
[ ] warn driver when attention is off (distracted driver) with audio/video signal \
