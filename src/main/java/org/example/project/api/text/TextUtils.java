package org.example.project.api.text;

import org.jetbrains.annotations.NotNull;

public class TextUtils {
    public static @NotNull String convertTicksToTimeFormat(int ticks) {
        int totalMilliseconds = ticks * 50;

        int minutes = totalMilliseconds / 60000;
        int seconds = (totalMilliseconds % 60000) / 1000;
        int milliseconds = (totalMilliseconds % 1000) / 10;

        return String.format("%d:%02d.%02d", minutes, seconds, milliseconds);
    }

    public static @NotNull String formatSeconds(int time) {
        int hours = time/3600;
        int minutes = (time/60) % 60;
        int seconds = time % 60;

        boolean displayHours = hours != 0;
        boolean displayMinutes = minutes != 0;

        StringBuilder builder = new StringBuilder();

        if (displayHours) builder.append(hours).append("ʜ ");
        if (displayMinutes) builder.append(minutes).append("ᴍ ");
        builder.append(seconds).append("s");

        return builder.toString();
    }
}