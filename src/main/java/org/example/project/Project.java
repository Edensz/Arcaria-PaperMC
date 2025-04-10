package org.example.project;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public final class Project extends JavaPlugin {
    private static @Getter Plugin instance;

    private static @Getter ScheduledExecutorService service;

    @Override
    public void onEnable() {
        instance = this;

        service = Executors.newSingleThreadScheduledExecutor();

        //CommandUtils.registerCommands(new PaperCommandManager(this), [commands]);

        //ListenerUtils.registerListeners([listeners]);

        Bukkit.getConsoleSender().sendMessage("");
    }

    @Override
    public void onDisable() {
    }
}
