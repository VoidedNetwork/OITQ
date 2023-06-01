package gg.voided.oitq.listeners;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;

public class ClickListener implements Listener {

    private final FileConfiguration config;

    public ClickListener(Plugin plugin) {
        this.config = plugin.getConfig();
    }

    @EventHandler
    public void onClick(PlayerInteractEvent event) {
        if(!event.hasItem()) return;
        if(!event.getAction().equals(Action.RIGHT_CLICK_AIR) && !event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) return;
        if(!event.getItem().getItemMeta().getDisplayName().contains("Winged Iron Axe")) return;

        Player player = event.getPlayer();

        if(!player.isOnGround()) return;

        player.setVelocity(player.getEyeLocation().getDirection().multiply(config.getDouble("axe-multiplier")).setY(2));
    }
}
