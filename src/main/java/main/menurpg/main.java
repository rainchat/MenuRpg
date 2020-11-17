package main.menurpg;

import main.menurpg.commands.FontCommand;
import main.menurpg.events.actionbar;
import main.menurpg.filemenager.FileManager;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {

            Bukkit.getPluginManager().registerEvents(this, this);
        } else {

            getLogger().warning("Could not find PlaceholderAPI! This plugin is required.");
            Bukkit.getPluginManager().disablePlugin(this);
        }


        FileManager fileManager = new FileManager(this);
        fileManager.getConfig("config.yml").copyDefaults(true).save();
        this.getCommand("rpgmenu").setExecutor(new FontCommand());
        getServer().getPluginManager().registerEvents(new actionbar(),this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
