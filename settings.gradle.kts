plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
    id("de.fayard.refreshVersions") version "0.60.5"
}

rootProject.name = "open-ads"

include("code-coverage-report")

include("ads-manager")
