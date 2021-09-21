package net.kunmc.lab.donttouchgreen.listener;

import net.kunmc.lab.donttouchgreen.Config;
import net.kunmc.lab.donttouchgreen.DontTouchGreen;
import net.kunmc.lab.donttouchgreen.Util;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class PlayerDamagedByEntity implements Listener {
    @EventHandler
    public void onEntityDamageByDamage(EntityDamageByEntityEvent e) {
        if (!Config.attackedByMob) {
            return;
        }

        if (!e.getCause().equals(EntityDamageEvent.DamageCause.ENTITY_ATTACK)) {
            return;
        }

        if (!(e.getEntity() instanceof Player)) {
            return;
        }
        Player p = ((Player) e.getEntity());
       
        if (DontTouchGreen.greenEntityList.contains(e.getDamager().getType())) {
            Util.kill(p);
        }
    }
}
