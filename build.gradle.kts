import io.gitlab.arturbosch.detekt.Detekt

plugins {
    id(BuildPlugins.Ids.ktlintPlugin) version BuildPlugins.Versions.ktlintPlugin
    id(BuildPlugins.Ids.detektPlugin) version BuildPlugins.Versions.detektPlugin
    id(BuildPlugins.Ids.jacocoPlugin) version BuildPlugins.Versions.jacocoPlugin
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
            apply(plugin = ktlintPlugin)
            apply(plugin = detektPlugin)
        }
    }
}

tasks {
    register("clean").configure {
        delete("build")
    }

    withType<Detekt> {
        jvmTarget = KotlinConfig.targetJVM
    }
}
