#include <jni.h>
#include "com_example_learnjni_ControlSwitch.h"

JNIEXPORT jint

JNICALL Java_com_example_learnjni_ControlSwitch_getSwitchStatus
        (JNIEnv *env, jobject obj) {
    //获取类
    jclass jClass = (*env)->FindClass(env, "com/example/learnjni/ControlSwitch");
    //获取方法ID
    jmethodID methodID = (*env)->GetMethodID(env,jClass, "getStatus", "()I");
   //3.得到要调用的方法
    jint val = (*env)->CallIntMethod(env,obj, methodID);
    return val;
}
