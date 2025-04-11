package org.symphony.arcaria.global.world.time;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.symphony.arcaria.Arcaria;
import org.symphony.arcaria.api.data.json.JsonConfig;
import org.symphony.arcaria.api.data.json.interfaces.Restorable;
import org.symphony.arcaria.global.world.time.data.TimeData;
import org.symphony.arcaria.global.world.time.events.ElapseDayEvent;

public class TimeManager implements Restorable {
    private final Arcaria arcaria;

    private final @Getter TimeTask taskManager;

    public @Getter TimeData data;

    public TimeManager(final @NotNull Arcaria arcaria) {
        this.arcaria = arcaria;
        this.taskManager = new TimeTask(this);
        this.data = new TimeData();
    }

    public void elapseDay() {
        this.setDay(this.arcaria.day + 1);
        new ElapseDayEvent().callEvent();
    }

    public void setDay(int newDay) {
        this.arcaria.day = newDay;
        this.data.setDay(newDay);
    }

    @Override
    public void save(@NotNull JsonConfig jsonConfig) {
        jsonConfig.setJsonObject(Arcaria.getGson().toJsonTree(this.data).getAsJsonObject());
        try {
            jsonConfig.save();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void restore(@NotNull JsonConfig jsonConfig) {
        if (!jsonConfig.getJsonObject().entrySet().isEmpty()) {
            this.data = Arcaria.getGson().fromJson(jsonConfig.getJsonObject(), TimeData.class);
        }
    }
}