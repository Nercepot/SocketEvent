package org.nercepot.socketEvent

import org.nercepot.socketEvent.Logic.LogicSocket;

import org.bukkit.plugin.java.JavaPlugin

class SocketEvent : JavaPlugin() {



    override fun onEnable() {
        LogicSocket();

    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
