#include <jni.h>
#include "com_example_learnjni_ControlSwitch.h"

JNIEXPORT jint

JNICALL Java_com_example_learnjni_ControlSwitch_getSwitchStatus
        (JNIEnv *env, jobject obj) {
//    jclass jClass = (*env)->FindClass(env, "com/example/learnjni/ControlSwitch");
//    //2.实例化
//    jobject jObject = (*env)->AllocObject(env, jClass);
//    //3.得到要调用的方法
//    jmethodID jMethodId = (*env)->GetMethodID(env, jClass, "getStatus", " ()I");
//    jint jInt = (*env)->CallIntMethod(env,jObject,jMethodId);
    return 1;
}
