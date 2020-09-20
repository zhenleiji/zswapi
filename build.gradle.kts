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
}

tasks.register("clean").configure {
    delete("build")
}
