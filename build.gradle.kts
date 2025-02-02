import kotlinx.kover.gradle.plugin.dsl.CoverageUnit

plugins {
    kotlin("jvm")

    id("org.jlleitschuh.gradle.ktlint")
    id("org.jetbrains.kotlinx.kover")
}

allprojects {
    apply(plugin = "kotlin")

    apply(plugin = "org.jlleitschuh.gradle.ktlint")
    apply(plugin = "org.jetbrains.kotlinx.kover")

    group = "io.openads"
    version = "0.0.1"

    repositories {
        mavenCentral()
    }

    dependencies {
        implementation("org.jetbrains.kotlin:kotlin-reflect")

        testImplementation(Kotlin.test.junit5)
        testImplementation(Testing.kotest.runner.junit5)
        testImplementation(Testing.mockK)
        testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    }

    java {
        toolchain {
            languageVersion = JavaLanguageVersion.of(21)
        }
    }

    kotlin {
        compilerOptions {
            freeCompilerArgs.addAll("-Xjsr305=strict")
        }
    }

    ktlint {
        version = "1.5.0"
    }

    tasks.withType<Test> {
        useJUnitPlatform()

        finalizedBy("koverHtmlReport")
    }

    kover {
        reports {
            verify {
                rule {
                    minBound(
                        minValue = 70,
                        coverageUnits = CoverageUnit.LINE,
                    )

                    minBound(
                        minValue = 70,
                        coverageUnits = CoverageUnit.BRANCH,
                    )
                }
            }
        }
    }
}
