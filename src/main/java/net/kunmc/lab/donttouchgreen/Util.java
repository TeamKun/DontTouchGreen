package net.kunmc.lab.donttouchgreen;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;
import java.util.stream.Collectors;

public class Util {
    public static List<Player> getPlayerList() {
        return Bukkit.getOnlinePlayers().stream()
                .filter(p -> !p.isDead())
                .filter(p -> p.getGameMode().equals(GameMode.SURVIVAL) || p.getGameMode().equals(GameMode.ADVENTURE))
                .collect(Collectors.toList());
    }

    public static void kill(Player p) {
        new BukkitRunnable() {
            @Override
            public void run() {
                p.damage(p.getHealthScale());
            }
        }.runTask(DontTouchGreen.instance);
    }
}
