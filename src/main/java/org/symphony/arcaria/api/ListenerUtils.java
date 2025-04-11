package org.symphony.arcaria.api;

import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.symphony.arcaria.Arcaria;
import org.jetbrains.annotations.NotNull;

public class ListenerUtils {
    private static final Plugin plugin = Arcaria.getInstance();

    public static void registerListener(Listener listener) {
        Bukkit.getPluginManager().registerEvents(listener, plugin);
    }

    public static void registerListeners(Listener @NotNull ... listeners) {
        for (Listener listener : listeners) {
            Bukkit.getPluginManager().registerEvents(listener, plugin);
        }
    }

    public static void unregisterListeners(Listener @NotNull ... listeners) {
        for (Listener listener : listeners) {
            HandlerList.unregisterAll(listener);
        }
    }

    public static void unregisterListener(Listener listener) {
        HandlerList.unregisterAll(listener);
    }
}