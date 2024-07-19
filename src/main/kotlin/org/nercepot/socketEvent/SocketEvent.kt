package org.nercepot.socketEvent

import org.bukkit.plugin.PluginDescriptionFile
import org.nercepot.socketEvent.Logic.LogicSocket;

import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.plugin.java.JavaPluginLoader
import org.nercepot.socketEvent.Config.GeneralConfig
import org.nercepot.socketEvent.Storage.yamlStorage
import java.io.File

@Suppress("unused")
class SocketEvent : JavaPlugin {

    companion object{
        const val DISPLAY_NAME = "SocketEvent"
    }

    constructor() : super() {
        isUnitTest = false
    }


    @Suppress("removal", "DEPRECATION")
    constructor(
        loader: JavaPluginLoader,
        description: PluginDescriptionFile,
        dataFolder: File,
        file: File,
    ) : super(loader, description, dataFolder, file) {
        isUnitTest = true
    }

    private val isUnitTest: Boolean
    private lateinit var generalConfig: GeneralConfig
    private lateinit var storage: yamlStorage

    override fun onEnable() {
        if (isUnitTest) onUnitTest()
        else onPluginEnable()
    }

    override fun onDisable() {}


    private fun onUnitTest() {
        loadConfig()
        loadStorage()
    }

    private fun onPluginEnable() {
        loadConfig()
        loadStorage()
        registerEvents()
    }

    fun loadConfig() {
        generalConfig = GeneralConfig(this).apply { loadConfig() }
    }

    fun reloadConfigs() {
        generalConfig.loadConfig()
        storage.load()
    }

    private fun loadStorage(){
        storage = yamlStorage(dataFolder).apply { load() }
    }

    private fun registerEvents(){
        SocketEvent()
    }
}
