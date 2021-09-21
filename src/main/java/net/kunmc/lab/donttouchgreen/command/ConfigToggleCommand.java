package net.kunmc.lab.donttouchgreen.command;

import dev.kotx.flylib.command.Command;
import dev.kotx.flylib.command.CommandContext;

import java.lang.reflect.Field;

public class ConfigToggleCommand extends Command {
    private final Field configField;

    public ConfigToggleCommand(Field configField) {
        super(configField.getName());
        this.configField = configField;
    }

    @Override
    public void execute(CommandContext ctx) {
        try {
            boolean flag = configField.getBoolean(null);
            configField.set(null, !flag);
            ctx.success(configField.getName() + "の値を" + !flag + "に設定しました.");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
