package org.nercepot.socketEvent.Config

import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File

abstract class ConfigManager {

    protected lateinit var configFile: File
    protected lateinit var config: FileConfiguration

    protected fun localConfig(){
        createConfig()
        config = YamlConfiguration.loadConfiguration(configFile)
        updateProperties()
    }

    protected abstract fun createConfig()

    protected abstract fun updateProperties()


}