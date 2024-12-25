#导入cv模块
import cv2 as cv
import sys
# 获取传递给Python脚本的参数
arg1 = sys.argv[1]
arg2 = sys.argv[2]
classifier='D:/installs/opencv-4.10.0/opencv-4.10.0/data/haarcascades/haarcascade_frontalface_alt2.xml'
#检测函数
def face_detect_demo():
    img = cv.imread(arg1)
    # img = cv.imread('noface.PNG')
    gary = cv.cvtColor(img,cv.COLOR_BGR2GRAY)
    face_detect = cv.CascadeClassifier(classifier)
    face = face_detect.detectMultiScale(gary,1.01,5,0,(100,100),(300,300))
    cv.destroyAllWindows()
    # print(len(face))
    return len(face)

print(face_detect_demo())