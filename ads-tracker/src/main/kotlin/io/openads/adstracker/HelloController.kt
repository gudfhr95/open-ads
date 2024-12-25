package io.openads.adstracker

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {
    companion object {
        const val HELLO_WORLD = "Hello, Ads Tracker!"
    }

    @GetMapping("/hello")
    fun hello(): String = HELLO_WORLD
}
