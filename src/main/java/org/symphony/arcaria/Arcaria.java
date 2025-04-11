package org.symphony.arcaria;

import co.aikar.commands.PaperCommandManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.symphony.arcaria.api.CommandUtils;
import org.symphony.arcaria.global.commands.ArcariaCommand;
import org.symphony.arcaria.global.commands.StaffCommand;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public final class Arcaria extends JavaPlugin {
    private static @Getter Gson gson;

    private static @Getter Plugin instance;

    private static @Getter ScheduledExecutorService service;

    public @Getter int day;

    @Override
    public void onEnable() {
        instance = this;

        service = Executors.newSingleThreadScheduledExecutor();

        gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();

        CommandUtils.registerCommands(new PaperCommandManager(this),
                new StaffCommand(),
                new ArcariaCommand()
        );

        //ListenerUtils.registerListeners([listeners]);

        Bukkit.getConsoleSender().sendMessage("");
    }

    @Override
    public void onDisable() {
    }
}