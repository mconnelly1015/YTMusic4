plugins {
    id("com.android.application")
}

android {
    namespace = "com.ytmusic.launcher"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.ytmusic.launcher"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}
