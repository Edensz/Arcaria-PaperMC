package org.symphony.arcaria.api;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.PaperCommandManager;
import org.jetbrains.annotations.NotNull;

public class CommandUtils {
    public static void registerCommands(PaperCommandManager manager, BaseCommand @NotNull ... commandExecutors) {
        for (BaseCommand commandExecutor : commandExecutors) {
            manager.registerCommand(commandExecutor);
        }
    }
}
