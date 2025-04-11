package org.symphony.arcaria.global.world.time.data;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TimeData {
    private int day;
    private int seconds;

    public TimeData() {
        this(1, 0);
    }

    public TimeData(int day, int seconds) {
        this.day = day;
        this.seconds = seconds;
    }
}