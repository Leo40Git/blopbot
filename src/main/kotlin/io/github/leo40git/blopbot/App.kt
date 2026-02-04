package io.github.leo40git.blopbot

import dev.kordex.core.ExtensibleBot
import dev.kordex.core.utils.env
import io.github.leo40git.blopbot.extensions.ShutdownExtension
import io.github.leo40git.blopbot.extensions.eventlog.EventLogExtension
import java.io.File

private val TOKEN = env("TOKEN")   // Get the bot's token from the env vars or a .env file

suspend fun main() {
    val bot = ExtensibleBot(TOKEN) {
        chatCommands {
            defaultPrefix = "b!"
            enabled = true
        }

        extensions {
            add(::EventLogExtension)
        }

        if (devMode) {
            extensions {
                add(::ShutdownExtension)
            }

            // In development mode, load any plugins from `src/main/dist/plugin` if it exists.
            plugins {
                if (File("src/main/dist/plugins").isDirectory) {
                    pluginPath("src/main/dist/plugins")
                }
            }
        }
    }

    bot.start()
}
