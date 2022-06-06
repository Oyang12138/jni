#include <jni.h>
#include "com_example_learnjni_HelloJNI.h"

JNIEXPORT jstring JNICALL Java_com_example_learnjni_HelloJNI_getString
        (JNIEnv *env, jobject){
    return (env)->NewStringUTF("I am from c");
}
