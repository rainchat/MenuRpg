package main.menurpg;

import main.menurpg.commands.FontCommand;
import main.menurpg.commands.FronCommandHendler;
import main.menurpg.commands.ResourseCommand;
import main.menurpg.events.ResourcePack;
import main.menurpg.events.ActionBar;
import main.menurpg.filemenager.FileManager;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class MenuRPGPlugin extends JavaPlugin {

    private final FileManager fileManager = FileManager.getInstance();

    @Override
    public void onEnable() {
        String mainfolder = "/menus";
        fileManager.logInfo(true)
                .registerDefaultGenerateFiles("mainmenu.yml", "/menus", mainfolder)
                .registerDefaultGenerateFiles("teleports.yml", "/menus", mainfolder)
                .registerCustomFilesFolder("/menus")
                .setup(this);


        this.getCommand("rpgmenu").setExecutor(new FontCommand());
        this.getCommand("rpgresourse").setExecutor(new ResourseCommand());
        this.getCommand("rpgmenu").setTabCompleter(new FronCommandHendler());
        getServer().getPluginManager().registerEvents(new ActionBar(), this);
        getServer().getPluginManager().registerEvents(new ResourcePack(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
