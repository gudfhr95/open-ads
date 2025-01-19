package io.openads.adsmanager

import io.kotest.core.spec.style.AnnotationSpec
import org.springframework.modulith.core.ApplicationModules
import org.springframework.modulith.docs.Documenter

class ApplicationTest : AnnotationSpec() {
    @Test
    fun writeDocumentationSnippets() {
        val modules = ApplicationModules.of(Application::class.java).verify()

        Documenter(modules)
            .writeModulesAsPlantUml()
            .writeIndividualModulesAsPlantUml()
    }
}
