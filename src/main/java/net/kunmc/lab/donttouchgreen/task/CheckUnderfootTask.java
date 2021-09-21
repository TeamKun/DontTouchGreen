package net.kunmc.lab.donttouchgreen.task;

import net.kunmc.lab.donttouchgreen.DontTouchGreen;
import net.kunmc.lab.donttouchgreen.Util;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.scheduler.BukkitRunnable;

public class CheckUnderfootTask extends BukkitRunnable {
    @Override
    public void run() {
        Util.getPlayerList().forEach(p -> {
            Location loc = p.getLocation();
            if (p.isInsideVehicle()) {
                loc.add(0, 0.45, 0);
            }
            Block overlapping = loc.getBlock();
            if (DontTouchGreen.greenMaterialList.contains(overlapping.getType())) {
                if (overlapping.getBoundingBox().overlaps(p.getBoundingBox())) {
                    Util.kill(p);
                    return;
                }
            }

            Location footLoc = loc.clone().add(0, -0.15, 0);
            Block foot = footLoc.getBlock();
            if (!foot.getBoundingBox().overlaps(p.getBoundingBox().shift(0, -0.15, 0))) {
                return;
            }

            if (p.isInsideVehicle()) {
                return;
            }

            if (DontTouchGreen.greenMaterialList.contains(foot.getType()) && !foot.isPassable()) {
                Util.kill(p);
            }
        });
    }
}
