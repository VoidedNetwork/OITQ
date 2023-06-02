package gg.voided.oitq.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public class ArrowHitListener implements Listener {

    @EventHandler
    public void onArrowHit(EntityDamageByEntityEvent event) {
        if(!(event.getDamager() instanceof Arrow)) return;
        if(!(event.getEntity() instanceof Player)) return;

        Arrow arrow = (Arrow) event.getDamager();

        if(!arrow.hasMetadata("oitq")) return;
        if(!(arrow.getShooter() instanceof Player)) return;

        Player player = (Player) event.getEntity();
        Player shooter = (Player) arrow.getShooter();

        player.setHealth(0);

        shooter.getInventory().setItem(8, new ItemStack(Material.ARROW));
    }
}
