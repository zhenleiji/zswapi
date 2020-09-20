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
        const val ktlintPlugin = "org.jlleitschuh.gradle.ktlint"
        const val detektPlugin = "io.gitlab.arturbosch.detekt"
        const val jacocoPlugin = "com.vanniktech.android.junit.jacoco"
    }

    object Versions {
        const val ktlintPlugin = "9.4.0"
        const val detektPlugin = "1.13.1"
        const val jacocoPlugin = "0.16.0"
    }
}
