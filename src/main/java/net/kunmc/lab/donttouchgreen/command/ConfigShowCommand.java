package net.kunmc.lab.donttouchgreen.command;

import dev.kotx.flylib.command.Command;
import dev.kotx.flylib.command.CommandContext;
import net.kunmc.lab.donttouchgreen.Config;

import java.lang.reflect.Field;

public class ConfigShowCommand extends Command {
    public ConfigShowCommand() {
        super("show");
    }

    @Override
    public void execute(CommandContext ctx) {
        try {
            for (Field field : Config.class.getDeclaredFields()) {
                Object value = field.get(null);
                ctx.success(field.getName() + ": " + value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
