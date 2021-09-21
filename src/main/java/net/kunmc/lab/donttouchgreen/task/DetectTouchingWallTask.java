package net.kunmc.lab.donttouchgreen.task;

import net.kunmc.lab.donttouchgreen.DontTouchGreen;
import net.kunmc.lab.donttouchgreen.Util;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.scheduler.BukkitRunnable;

public class DetectTouchingWallTask extends BukkitRunnable {
    @Override
    public void run() {
        Util.getPlayerList().forEach(p -> {
            for (int y = 0; y < 2; y++) {
                for (int x = -1; x < 2; x++) {
                    for (int z = -1; z < 2; z++) {
                        Location playerLoc = p.getLocation();
                        if (p.isInsideVehicle()) {
                            playerLoc.add(0, 0.45, 0);
                        }
                        Location blockLoc = playerLoc.clone().add(x, y, z);
                        Block b = blockLoc.getBlock();
                        if (DontTouchGreen.greenMaterialList.contains(b.getType()) && !b.isPassable()) {
                            if (calcPlaneDistance(playerLoc, b.getBoundingBox().getCenter().toLocation(b.getWorld())) <= 1.0) {
                                Util.kill(p);
                            }
                        }
                    }
                }
            }
        });
    }

    private double calcPlaneDistance(Location loc1, Location loc2) {
        Location a = loc1.clone();
        a.setY(0.0);
        Location b = loc2.clone();
        b.setY(0.0);
        return a.distance(b);
    }
}
