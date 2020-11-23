package main.menurpg;

import main.menurpg.commands.FontCommand;
import main.menurpg.commands.FronCommandHendler;
import main.menurpg.events.actionbar;
import main.menurpg.filemenager.FileManager;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class main extends JavaPlugin implements Listener {

    private FileManager fileManager = FileManager.getInstance();

    @Override
    public void onEnable() {
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {

            Bukkit.getPluginManager().registerEvents(this, this);
        } else {

            getLogger().warning("Could not find PlaceholderAPI! This plugin is required.");
            Bukkit.getPluginManager().disablePlugin(this);
        }


        String mainfolder = "/menus";
        fileManager.logInfo(true)
                .registerDefaultGenerateFiles("mainmenu.yml", "/menus", mainfolder)
                .registerDefaultGenerateFiles("teleports.yml", "/menus", mainfolder)
                .registerCustomFilesFolder("/menus")
                .setup(this);



        this.getCommand("rpgmenu").setExecutor(new FontCommand());
        this.getCommand("rpgmenu").setTabCompleter(new FronCommandHendler());
        getServer().getPluginManager().registerEvents(new actionbar(),this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
