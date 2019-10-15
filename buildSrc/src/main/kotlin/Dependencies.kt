import org.gradle.api.JavaVersion

const val kotlinVersion = "1.3.50"

object BuildPlugins {
    object Versions {
        const val buildToolsVersion = "3.5.1"
    }

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.buildToolsVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "android"
    const val kotlinAndroidExtensions = "android.extensions"
    const val kotlinKapt = "kapt"
}

object AndroidSdk {
    const val min = 21
    const val compile = 28
    const val target = compile
}

object JavaVersion {
    val targetCompatibility = JavaVersion.VERSION_1_8
    val sourceCompatibility = JavaVersion.VERSION_1_8
}

object Libraries {
    private object Versions {
        const val jUnit = "4.12"
        const val testRunner = "1.2.0"
        const val espressoCore = "3.2.0"
        const val constraintLayout = "1.1.3"
        const val ktx = "1.1.0"
        const val room = "2.2.0-rc01"
        const val timber = "4.7.1"
        const val coroutine = "1.3.0"
        const val lifecycle = "2.1.0"
        const val moshi = "1.9.0-SNAPSHOT"
        const val koin = "2.0.1"
        const val anko = "0.10.8"
        const val material = "1.1.0-beta01"
    }

    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"
    const val appCompat = "androidx.appcompat:appcompat:1.1.0"
    const val ktxCore = "androidx.core:core-ktx:${Versions.ktx}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

    const val jUnit = "junit:junit:${Versions.jUnit}"
    const val testRunner = "androidx.test:runner:${Versions.testRunner}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"

    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"

    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    const val coroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine}"
    const val coroutineAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine}"

    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val lifecycleCommon = "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycle}"

    const val moshi = "com.squareup.moshi:moshi:${Versions.moshi}"
    const val moshiCodegen = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}"

    const val koinAndroid = "org.koin:koin-android:${Versions.koin}"
    const val koinViewModel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"
    const val koinScope = "org.koin:koin-androidx-scope:${Versions.koin}"

    const val anko = "org.jetbrains.anko:anko-commons:${Versions.anko}"

    const val materialComponents = "com.google.android.material:material:${Versions.material}"

}