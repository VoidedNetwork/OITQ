package gg.voided.oitq;

import gg.voided.oitq.listeners.ArrowHitListener;
import gg.voided.oitq.listeners.ClickListener;
import gg.voided.oitq.listeners.ShootListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new ClickListener(this), this);
        getServer().getPluginManager().registerEvents(new ShootListener(this), this);
        getServer().getPluginManager().registerEvents(new ArrowHitListener(), this);
    }

}
