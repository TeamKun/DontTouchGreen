package net.kunmc.lab.donttouchgreen.task;

import net.kunmc.lab.donttouchgreen.Config;
import net.kunmc.lab.donttouchgreen.DontTouchGreen;
import net.kunmc.lab.donttouchgreen.Util;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Parrot;
import org.bukkit.scheduler.BukkitRunnable;

public class DetectEntityCollisionTask extends BukkitRunnable {
    @Override
    public void run() {
        if (!Config.collideWithMob) {
            return;
        }
       
        Util.getPlayerList().forEach(p -> {
            new BukkitRunnable() {
                @Override
                public void run() {
                    p.getNearbyEntities(1, 1, 1).forEach(e -> {
                        if (!DontTouchGreen.greenEntityList.contains(e.getType())) {
                            return;
                        }

                        if (e.getType().equals(EntityType.PARROT)) {
                            if (!((Parrot) e).getVariant().equals(Parrot.Variant.GREEN)) {
                                return;
                            }
                        }

                        if (e.getBoundingBox().overlaps(p.getBoundingBox())) {
                            Util.kill(p);
                        }
                    });
                }
            }.runTask(DontTouchGreen.instance);
        });
    }
}
