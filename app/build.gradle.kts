plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.sorianog.newsshortsapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.sorianog.newsshortsapp"
        minSdk = 24
        targetSdk = 35
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

kapt {
    correctErrorTypes = true
}

dependencies {
    implementation(project(":utilities"))

    implementation(Dependencies.androidxCoreKtx)
    implementation(Dependencies.androidLifecycleRuntimeKtx)
    implementation(Dependencies.androidxActivityCompose)
    implementation(platform(Dependencies.androidxComposeBom))
    implementation(Dependencies.androidxComposeUi)
    implementation(Dependencies.androidxComposeUiGraphics)
    implementation(Dependencies.androidxComposeUiToolingPreview)
    implementation(Dependencies.androidxComposeMaterial3)
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.retrofit)
    implementation(libs.moshi.kotlin)
    implementation(libs.converter.moshi)
    implementation(platform(libs.okhttp.bom))
    implementation(libs.okhttp)
    implementation(libs.logging.interceptor)
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.coil.compose)
    implementation(libs.coil.network.okhttp)

    androidTestImplementation(platform(Dependencies.androidxComposeBom))
    androidTestImplementation(Dependencies.androidxComposeUiTestJUnit4)

    debugImplementation(Dependencies.androidxComposeUiTooling)
    debugImplementation(Dependencies.androidxComposeUiTestManifest)

    // Maybe can rely on using libs.versions.toml instead?

//    implementation(libs.androidx.core.ktx)
//    implementation(libs.androidx.lifecycle.runtime.ktx)
//    implementation(libs.androidx.activity.compose)
//    implementation(platform(libs.androidx.compose.bom))
//    implementation(libs.androidx.ui)
//    implementation(libs.androidx.ui.graphics)
//    implementation(libs.androidx.ui.tooling.preview)
//    implementation(libs.androidx.material3)
//    testImplementation(libs.junit)
//    androidTestImplementation(libs.androidx.junit)
//    androidTestImplementation(libs.androidx.espresso.core)
//    androidTestImplementation(platform(libs.androidx.compose.bom))
//    androidTestImplementation(libs.androidx.ui.test.junit4)
//    debugImplementation(libs.androidx.ui.tooling)
//    debugImplementation(libs.androidx.ui.test.manifest)
}