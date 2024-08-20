package org.sayandev.sayanvanish.proxy.config

import org.sayandev.sayanvanish.api.Platform
import org.sayandev.stickynote.core.configuration.Config
import org.spongepowered.configurate.objectmapping.ConfigSerializable
import java.io.File
import java.util.UUID

public var settings: SettingsConfig = SettingsConfig.fromConfig() ?: SettingsConfig.defaultConfig()

@ConfigSerializable
class SettingsConfig(
    val general: General = General()
) : Config(
    Platform.get().rootDirectory,
    fileName
) {

    init {
        load()
    }

    @ConfigSerializable
    data class General(
        val serverId: String = "${Platform.get().id}-${UUID.randomUUID()}",
        val purgeOnlineHistoryOnStartup: Boolean = true,
        val cacheUpdatePeriodMillis: Long = 300,
        val basicCacheUpdatePeriodMillis: Long = 5000,
    )

    companion object {
        private val fileName = "settings.yml"
        val settingsFile = File(Platform.get().rootDirectory, fileName)

        @JvmStatic
        fun defaultConfig(): SettingsConfig {
            return SettingsConfig()
        }

        @JvmStatic
        fun fromConfig(): SettingsConfig? {
            return fromConfig<SettingsConfig>(settingsFile)
        }
    }
}