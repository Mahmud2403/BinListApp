plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kapt)
    alias(libs.plugins.ksp)
    alias(libs.plugins.androidx.room)
    id("kotlinx-serialization")
}

android {
    namespace = "com.example.binlistapp"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.binlistapp"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    room {
        schemaDirectory("$projectDir/schemas")
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core.ktx)
    implementation(libs.kotlinx.collections.immutable)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.xmlutil.serialization)
    implementation(libs.xmlutil.serialization.jvm)
    implementation(libs.androidx.navigation.runtime.android)
    debugImplementation(libs.tooling)
    debugImplementation(libs.test.manifest)

    //Compose
    val composeBom = platform(libs.androidx.compose.bom)
    androidTestImplementation(composeBom)
    implementation(composeBom)
    implementation(libs.material3)
    implementation(libs.material)
    implementation(libs.animation)
    implementation(libs.ui)
    implementation(libs.activity)
    implementation(libs.graphics)
    implementation(libs.tooling.preview)
    implementation(libs.material.icons.extended)
    implementation(libs.util)
    implementation(libs.navigation)

    //ViewModel
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)


    //Koin
    implementation(libs.koin.android)
    implementation(libs.koin.core)
    implementation(libs.koin.compose)

    //OkHttps
    implementation(libs.logging.interceptor)
    implementation(libs.okhttp)

    //Retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.retrofit2.kotlinx.serialization.converter)

    //Flow
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.coroutines.play.services)

    //Room
    ksp(libs.androidx.room.compiler)
    implementation(libs.androidx.room.ktx)
}