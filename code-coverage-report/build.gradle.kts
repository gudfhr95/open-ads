plugins {
    `jacoco-report-aggregation`

    id("org.springframework.boot")
    id("io.spring.dependency-management")
}

dependencies {
    jacocoAggregation(project(":ads-manager"))
}
