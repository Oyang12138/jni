#include <jni.h>
#include "com_example_learnjni_MyTest.h"
//JNIEXPORT jstring JNICALL Java_com_example_learnjni_MyTest_getString
//        (JNIEnv *env, jobject){
//    return (env)->NewStringUTF("CCCCCCCCC");
//}
JNIEXPORT jstring JNICALL Java_com_example_learnjni_MyTest_WifiButton
        (JNIEnv *env, jobject instance){//实现WifiButton
    int type = 0;//开启
    //c语言调java方法，java反射机制
    //1.获得想调用的java方法的类
    jclass jClass = (*env)->FindClass(env,"com/example/learnjni/MyTest");
    //2.实例化
    jobject jObject = (*env)->AllocObject(env,jClass);
    //3.得到要调用的方法
    jmethodID jMethodId = (*env)->GetMethodID(env,jClass,"returnTypeWife", " (I)V");
    (*env)->CallIntMethod(env,jObject,jMethodId,type);//调用void returnTypeWife(int) 方法
     return (*env)->NewStringUTF(env,"开");

}