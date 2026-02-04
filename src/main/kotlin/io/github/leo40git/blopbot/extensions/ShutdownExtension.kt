package io.github.leo40git.blopbot.extensions

import dev.kordex.core.checks.isBotOwner
import dev.kordex.core.extensions.Extension
import dev.kordex.core.extensions.chatCommand
import dev.kordex.core.i18n.withContext
import dev.kordex.core.utils.respond
import io.github.leo40git.blopbot.i18n.Translations
import kotlin.system.exitProcess

class ShutdownExtension : Extension() {
    override val name = "shutdown"

    override suspend fun setup() {
        chatCommand {
            name = Translations.Commands.Shutdown.name
            description = Translations.Commands.Shutdown.description

            check {
                isBotOwner()
            }

            action {
                message.respond {
                    content = Translations.Commands.Shutdown.response
                        .withContext(this@action)
                        .translate()
                }

                this@ShutdownExtension.bot.close()
                exitProcess(0)
            }
        }
    }
}