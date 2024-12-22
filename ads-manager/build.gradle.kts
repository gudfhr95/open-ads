plugins {
    kotlin("plugin.spring")
    id("org.springframework.boot")
    id("io.spring.dependency-management")
}

group = "io.openads.adsmanager"
version = "0.0.1"

dependencies {
    implementation(Spring.boot.webflux)

    testImplementation(Spring.boot.test)
}
