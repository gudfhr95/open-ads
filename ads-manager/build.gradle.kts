plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    id("org.jetbrains.kotlin.plugin.spring")

    id("com.google.cloud.tools.jib")
}

group = "io.openads.adsmanager"
version = "0.0.1"

dependencies {
    implementation(platform("org.springframework.modulith:spring-modulith-bom:_"))

    implementation(KotlinX.coroutines.core)
    implementation(KotlinX.coroutines.reactor)

    implementation("org.springframework.modulith:spring-modulith-core")
    implementation(Spring.boot.webflux)
    implementation(Spring.boot.validation)
    implementation(Spring.boot.security)
    implementation(Spring.boot.oauth2ResourceServer)
    implementation(Spring.boot.data.r2dbc)
    runtimeOnly("com.github.jasync-sql:jasync-r2dbc-mysql:_")
    implementation("org.flywaydb:flyway-core")
    implementation("org.flywaydb:flyway-mysql")
    runtimeOnly("com.mysql:mysql-connector-j")

    testImplementation("org.springframework.modulith:spring-modulith-starter-test")
    testImplementation(Spring.boot.test)
    testImplementation(Spring.security.spring_security_test)

    testImplementation(Testing.Kotest.extensions.spring)
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
