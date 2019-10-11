plugins {
    id(BuildPlugins.androidApplication)
    kotlin(BuildPlugins.kotlinAndroid)
    kotlin(BuildPlugins.kotlinAndroidExtensions)
    kotlin(BuildPlugins.kotlinKapt)
}

android {
    compileSdkVersion(AndroidSdk.compile)
    defaultConfig {
        applicationId = "com.dissertation"
        minSdkVersion(AndroidSdk.min)
        targetSdkVersion(AndroidSdk.target)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        javaCompileOptions {
            annotationProcessorOptions {
                arguments = mapOf("room.incremental" to "true", "room.expandProjection" to "true")
            }
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.sourceCompatibility
        targetCompatibility = JavaVersion.targetCompatibility
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libraries.kotlinStdLib)
    implementation(Libraries.appCompat)
    implementation(Libraries.ktxCore)
    implementation(Libraries.constraintLayout)
    testImplementation(Libraries.jUnit)
    androidTestImplementation(Libraries.testRunner)
    androidTestImplementation(Libraries.espressoCore)

    implementation(Libraries.roomRuntime)
    kapt(Libraries.roomCompiler)
    implementation(Libraries.roomKtx)

    implementation(Libraries.timber)

    implementation(Libraries.coroutineCore)
    implementation(Libraries.coroutineAndroid)

    implementation(Libraries.viewModel)
    implementation(Libraries.liveData)
    kapt(Libraries.lifecycleCommon)

    implementation(Libraries.moshi)
    kapt(Libraries.moshiCodegen)

    implementation(Libraries.koinAndroid)
    implementation(Libraries.koinViewModel)
    implementation(Libraries.koinScope)

    implementation(Libraries.anko)
}
