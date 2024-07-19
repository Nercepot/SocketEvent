package org.nercepot.socketEvent.Config

import org.nercepot.socketEvent.Config.ConfigManager

import org.bukkit.plugin.Plugin
import org.nercepot.socketEvent.SocketEvent
import java.io.File
import kotlin.properties.Delegates

class GeneralConfig(private val plugin: Plugin) : ConfigManager() {
    companion object{
        var SocketEventEnabled: Boolean by Delegates.notNull()
            private set
    }

    private val filePath = "config.yml"
    private val enabledKey = "enabled"

    override fun createConfig() {
        configFile = File(plugin.dataFolder, filePath)
        if (!configFile.exists()){
            plugin.saveResource(filePath, false)
        }
    }

    override fun updateProperties() {
        SocketEventEnabled = config.getBoolean(enabledKey, true)
    }

    fun isSocketEventEnable(): Boolean = SocketEventEnabled

    fun enableSocketEvent(){
        SocketEventEnabled = true
        config.set(enabledKey, true)
        config.save(configFile)
    }

    fun undisabSocketEvent(){
        SocketEventEnabled = false
        config.set(enabledKey, false)
        config.save(configFile)
    }

    fun loadConfig(){

    }
}