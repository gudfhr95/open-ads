plugins {
    kotlin("plugin.spring")
    id("org.springframework.boot")
    id("io.spring.dependency-management")

    id("com.google.cloud.tools.jib")
}

group = "io.openads.adsmanager"
version = "0.0.1"

dependencies {
    implementation(Spring.boot.webflux)

    testImplementation(Spring.boot.test)
}

val koverExcludedClasses = listOf("*AdsManagerApplication*")
extra["koverExcludedClasses"] = koverExcludedClasses
kover {
    reports {
        filters {
            excludes {
                classes(koverExcludedClasses)
            }
        }
    }
}

tasks.jar {
    enabled = false
}

jib {
    dockerClient {
        executable = dockerClientPath
    }

    from {
        image = javaDockerImage
    }

    to {
        image = "${project.name}:latest"
    }
}
