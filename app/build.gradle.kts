import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    with(BuildPlugins.Ids) {
        id(androidApplication)
        id(kotlinAndroid)
    }
}

android {
    compileSdkVersion(AndroidConfig.compileSdk)
    buildToolsVersion(AndroidConfig.buildToolsVersion)

    defaultConfig {
        applicationId = AndroidConfig.applicationId
        minSdkVersion(AndroidConfig.minSdk)
        targetSdkVersion(AndroidConfig.targetSdk)
        testInstrumentationRunner = AndroidConfig.instrumentationTestRunner
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        viewBinding = true
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = KotlinConfig.targetJVM
    }
}

dependencies {

    with(Dependencies.Libraries) {
        implementation(kotlinStdLib)
        implementation(androidKtx)
        implementation(androidLifecycleCommonJava)
        implementation(androidLifecycleLivedataKtx)
        implementation(androidAppCompat)
        implementation(androidMaterialDesign)
        implementation(androidConstraintLayout)
    }

    with(Dependencies.Tests) {
        testImplementation(junit)
        testImplementation(junitEngine)
        testImplementation(junitParam)
        testImplementation(mockitoKotlin)
        testImplementation(mockWebServer)
    }

    with(Dependencies.AndroidTests) {
        androidTestImplementation(junit)
        androidTestImplementation(espressoCore)
    }
}
