package io.github.leo40git.blopbot.extensions.eventlog

import dev.kord.gateway.Intent
import dev.kord.gateway.PrivilegedIntent
import dev.kordex.core.extensions.Extension

class EventLogExtension : Extension() {
    override val name = "event-log"

    @OptIn(PrivilegedIntent::class)
    override suspend fun setup() {
        intents.add(Intent.MessageContent)

        // TODO
    }

}