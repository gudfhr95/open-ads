plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    id("org.jetbrains.kotlin.plugin.spring")

    id("com.google.cloud.tools.jib")
}

group = "io.openads.adsmanager"
version = "0.0.1"

dependencies {
    implementation(KotlinX.coroutines.core)
    implementation(KotlinX.coroutines.reactor)

    implementation(Spring.boot.web)
    implementation(Spring.boot.validation)

    implementation(Spring.boot.security)
    implementation(Spring.boot.oauth2ResourceServer)

    implementation(Spring.boot.data.jdbc)
    runtimeOnly("com.mysql:mysql-connector-j")
    implementation("org.flywaydb:flyway-core")
    implementation("org.flywaydb:flyway-mysql")

    implementation(Spring.kafka)

    testImplementation(Spring.boot.test)
    testImplementation(Spring.boot.webflux)
    testImplementation(Testing.Kotest.extensions.spring)

    testImplementation(Spring.security.spring_security_test)

    testImplementation("org.springframework.boot:spring-boot-testcontainers")
    testImplementation("org.testcontainers:mysql:_")
    testImplementation(Testing.Kotest.extensions.testContainers)
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
    from {
        image = javaDockerImage
    }

    to {
        image = "${project.name}:latest"
    }
}
