package main.menurpg;

import main.menurpg.commands.FontCommand;
import main.menurpg.events.actionbar;
import main.menurpg.filemenager.FileManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class main extends JavaPlugin {

    @Override
    public void onEnable() {

        FileManager fileManager = new FileManager(this);
        fileManager.getConfig("config.yml").copyDefaults(true).save();
        this.getCommand("font").setExecutor(new FontCommand());
        getServer().getPluginManager().registerEvents(new actionbar(),this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
