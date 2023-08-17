#include <jni.h>
#include <string>
#include "json/json.h"


extern "C" JNIEXPORT jstring JNICALL
Java_com_gradle_tasks_android_MainActivity_stringFromJNI(JNIEnv* env,jobject /* this */) {
    Json::Value json;
    json["test"] = "hello";
    json["value"] = "world";
    json["ret"] = 10;
    Json::StreamWriterBuilder fastWriter;
    std::string jsonStr=writeString(fastWriter, json);
    return env->NewStringUTF(jsonStr.c_str());
}