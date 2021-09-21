package net.kunmc.lab.donttouchgreen.listener;

import net.kunmc.lab.donttouchgreen.DontTouchGreen;
import net.kunmc.lab.donttouchgreen.Util;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteractListener implements Listener {
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        if (!e.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
            return;
        }

        if (!e.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.AIR)) {
            return;
        }

        Block block = e.getClickedBlock();
        if (block != null && DontTouchGreen.greenMaterialList.contains(block.getType())) {
            Util.kill(e.getPlayer());
        }
    }
}
