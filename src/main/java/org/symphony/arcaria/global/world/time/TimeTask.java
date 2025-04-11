package org.symphony.arcaria.global.world.time;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;
import org.symphony.arcaria.Arcaria;
import org.symphony.arcaria.global.world.time.data.TimeData;

public class TimeTask {
    private final TimeManager timeManager;
    private final TimeData data;

    public TimeTask(@NotNull TimeManager timeManager) {
        this.timeManager = timeManager;
        this.data = timeManager.getData();
    }

    private @Getter int taskID;

    public void runTick() {
        this.taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Arcaria.getInstance(), () -> {
            int seconds = this.data.getSeconds();

            this.data.setSeconds(seconds + 1);

            if (seconds >= 1440) {
                this.timeManager.elapseDay();
                this.data.setSeconds(0);
            }
        }, 0, 20);
    }
}