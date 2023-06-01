package gg.voided.oitq.listeners;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;

public class ShootListener implements Listener {

    private final Plugin plugin;

    public ShootListener(Plugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onShoot(EntityShootBowEvent event) {
        if(!event.getEntityType().equals(EntityType.PLAYER)) return;
        if(!event.getBow().getItemMeta().getDisplayName().contains("One Shot Bow")) return;

        event.getProjectile().setMetadata("oitq", new FixedMetadataValue(plugin, true));
    }
}
