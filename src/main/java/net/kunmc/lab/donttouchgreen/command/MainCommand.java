package net.kunmc.lab.donttouchgreen.command;

import dev.kotx.flylib.command.Command;
import net.kunmc.lab.donttouchgreen.Config;

import java.lang.reflect.Field;

public class MainCommand extends Command {
    public MainCommand() {
        super("donttouchgreen");

        children(new ConfigShowCommand());

        try {
            for (Field field : Config.class.getDeclaredFields()) {
                field.setAccessible(true);
                children(new ConfigToggleCommand(field));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
