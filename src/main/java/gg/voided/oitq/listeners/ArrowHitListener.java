package gg.voided.oitq.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public class ArrowHitListener implements Listener {

    @EventHandler
    public void onArrowHit(EntityDamageByEntityEvent event) {
        if(!(event.getDamager() instanceof Arrow)) return;
        if(!event.getDamager().hasMetadata("oitq")) return;

        Player player = (Player) event.getEntity();

        player.setHealth(0);

        player.getInventory().setItem(8, new ItemStack(Material.ARROW));
    }
}
