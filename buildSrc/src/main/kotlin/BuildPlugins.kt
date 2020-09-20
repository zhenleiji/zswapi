object BuildPlugins {
    object Classpaths {
        const val androidTools = "com.android.tools.build:gradle:${Versions.androidTools}"
        const val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${KotlinConfig.version}"

        private object Versions {
            const val androidTools = "4.1.0-rc03"
        }
    }

    object Ids {
        const val androidApplication = "com.android.application"
        const val kotlinAndroid = "kotlin-android"
    }
}
