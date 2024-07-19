package org.nercepot.socketEvent.Storage

import org.bukkit.Bukkit.getLogger
import org.bukkit.configuration.file.YamlConfiguration
import org.yaml.snakeyaml.tokens.Token
import java.io.File

class yamlStorage(dataFolder: File) {

    private val tokenStimer: MutableSet<String> = mutableSetOf()
    private val storageFile: File
    private val config: YamlConfiguration

    init {
        require(dataFolder.isDirectory) { "provided dataFolder ($dataFolder) is not directory!" }
        storageFile = File(dataFolder, FILE_NAME)
        if(!storageFile.exists()){
            createFile()
        }
        config = YamlConfiguration.loadConfiguration(storageFile)
    }

    companion object{

        private const val TOKEN_KEY = "token"
        private const val FILE_NAME = "token.yml"
    }

    fun addToken(token: Token): Boolean{
        return tokenStimer.add(token.toString()).also {save()}
    }

    fun removeToken(token: Token): Boolean{
        return tokenStimer.remove(token.toString()).also {save()}
    }

    fun clear(token: Token): Boolean{
        tokenStimer.clear()
        return save()
    }

    fun load(): Boolean{
        return try{
            if(!storageFile.exists()){
                storageFile.parentFile.mkdirs()
                storageFile.createNewFile()
            }
            config.load(storageFile)
            tokenStimer.clear()
            tokenStimer.addAll(config.getStringList(TOKEN_KEY))
            true
        }catch (e: Exception){
            getLogger().warning(e.stackTraceToString())
            false
        }
    }

    fun save(): Boolean{
        return try{
            config.set(TOKEN_KEY, tokenStimer.toList())
            config.save(storageFile)
            true
        } catch (e: Exception){
            getLogger().warning(e.stackTraceToString())
            false
        }
    }

    private fun createFile(){
        storageFile.parentFile.mkdirs()
        storageFile.createNewFile()
    }

}