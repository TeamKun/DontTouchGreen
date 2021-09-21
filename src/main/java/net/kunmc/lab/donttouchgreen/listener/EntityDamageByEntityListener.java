package net.kunmc.lab.donttouchgreen.listener;

import net.kunmc.lab.donttouchgreen.Config;
import net.kunmc.lab.donttouchgreen.DontTouchGreen;
import net.kunmc.lab.donttouchgreen.Util;
import org.bukkit.Material;
import org.bukkit.entity.Parrot;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamageByEntityListener implements Listener {
    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
        if (!Config.attackToMob) {
            return;
        }
       
        if (!e.getCause().equals(EntityDamageEvent.DamageCause.ENTITY_ATTACK)) {
            return;
        }

        if (!(e.getDamager() instanceof Player)) {
            return;
        }
        Player p = ((Player) e.getDamager());

        if (!p.getInventory().getItemInMainHand().getType().equals(Material.AIR)) {
            return;
        }

        if (DontTouchGreen.greenEntityList.contains(e.getEntity().getType())) {
            if (e.getEntity() instanceof Parrot && !((Parrot) e.getEntity()).getVariant().equals(Parrot.Variant.GREEN)) {
                return;
            }
            Util.kill(p);
        }
    }
}
