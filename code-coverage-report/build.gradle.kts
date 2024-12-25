dependencies {
    kover(project(":ads-manager"))
    kover(project(":ads-tracker"))
}

kover {
    reports {
        filters {
            excludes {
                classes(project(":ads-manager").extra["koverExcludedClasses"] as List<String>)
                classes(project(":ads-tracker").extra["koverExcludedClasses"] as List<String>)
            }
        }
    }
}
