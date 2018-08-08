#include <jni.h>
#include <string>
#include <sstream>
using namespace std;
extern "C"




JNIEXPORT jdouble

JNICALL

Java_com_onurakcay_myapplication_MainActivity_Calculator(
        JNIEnv *, jobject, jdouble num,jdouble num2,jint act, jobjectArray ) {

    if(act==0)
    {

        return num+num2 ;
    }
    if(act==1){

        return   num-num2;
    }
    if(act==2){

        return num*num2;
    }
   if(act==3){

        return num/num2;
    }




}



