plugins {
    id(BuildPlugins.Ids.ktlintGradle) version BuildPlugins.Versions.ktlintGradle
}

buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        with(BuildPlugins.Classpaths) {
            classpath(androidTools)
            classpath(kotlinPlugin)
        }
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }

    with(BuildPlugins.Ids) {
        subprojects {
            apply(plugin = ktlintGradle)
        }
    }
}

tasks.register("clean").configure {
    delete("build")
}
