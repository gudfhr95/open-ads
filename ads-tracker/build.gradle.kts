plugins {
    id("org.jetbrains.kotlinx.kover")

    kotlin("plugin.spring")
    id("org.springframework.boot")
    id("io.spring.dependency-management")
}

group = "io.openads.adstracker"
version = "0.0.1"

dependencies {
    implementation(Spring.boot.webflux)

    testImplementation(Spring.boot.test)
}

val koverExcludedClasses = listOf("*AdsTrackerApplication*")
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
