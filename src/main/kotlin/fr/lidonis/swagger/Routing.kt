package fr.lidonis.swagger

import io.ktor.server.application.*
import io.ktor.server.http.content.staticResources
import io.ktor.server.plugins.swagger.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        swaggerUI("swagger/ui")
        val workaround = isWorkaroundEnabled()
        if (workaround) {
            staticResources("/swagger/", "swagger-ui")
        }
        get("/") {
            call.respondText("OK")
        }
    }
}

fun Routing.isWorkaroundEnabled(): Boolean {
    val workaroundProperty = environment.config.propertyOrNull("workaround")
    return workaroundProperty?.getString()?.toBoolean() == true
}
