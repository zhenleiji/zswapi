object Dependencies {

    object Projects {
        private const val featureDir = ":features"
        private const val libraryDir = ":libraries"
    }

    object Libraries {
        const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib:${KotlinConfig.version}"
        const val coroutines =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
        const val androidKtx = "androidx.core:core-ktx:${Versions.androidX}"
        const val androidAppCompat = "androidx.appcompat:appcompat:${Versions.androidX}"
        const val androidMaterialDesign =
            "com.google.android.material:material:${Versions.androidX}"
        const val androidConstraintLayout =
            "androidx.constraintlayout:constraintlayout:${Versions.androidConstraintLayout}"
        const val moshi = "com.squareup.moshi:moshi:${Versions.moshi}"
        const val moshiCompiler = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}"
        const val moshiAdapters = "com.squareup.moshi:moshi-adapters:${Versions.moshi}"
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val okhttp3Interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"

        private object Versions {
            const val coroutines = "1.3.9"
            const val retrofit = "2.9.0"
            const val okhttp = "4.9.0"
            const val moshi = "1.9.3"
            const val androidX = "1.2.0"
            const val androidConstraintLayout = "2.0.0"
        }
    }

    object Tests {
        const val junit = "org.junit.jupiter:junit-jupiter-api:${Versions.junit}"
        const val junitEngine = "org.junit.jupiter:junit-jupiter-engine:${Versions.junit}"
        const val junitParam = "org.junit.jupiter:junit-jupiter-params:${Versions.junit}"
        const val mockitoKotlin =
            "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockitoKotlin}"
        const val mockWebServer = "com.squareup.okhttp3:mockwebserver:${Versions.mockWebServer}"

        private object Versions {
            const val junit = "5.7.0"
            const val mockitoKotlin = "2.2.0"
            const val mockWebServer = "4.9.0"
        }
    }

    object AndroidTests {
        const val junit = "androidx.test.ext:junit:${Versions.junit}"
        const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"

        private object Versions {
            const val junit = "1.1.2"
            const val espressoCore = "3.3.0"
        }
    }
}
