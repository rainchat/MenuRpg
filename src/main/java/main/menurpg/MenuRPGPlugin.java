package main.menurpg;

import main.menurpg.commands.FontCommand;
import main.menurpg.commands.FronCommandHendler;
import main.menurpg.commands.ResourseCommand;
import main.menurpg.events.ResourcePack;
import main.menurpg.events.ActionbarEvents;
import main.menurpg.menagers.ActionbarMenager;
import main.menurpg.menagers.FileManager;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public final class MenuRPGPlugin extends JavaPlugin implements @NotNull Listener {

    private final FileManager fileManager = FileManager.getInstance();
    public static MenuRPGPlugin INSTANCE;

    @Override
    public void onEnable() {
        INSTANCE = this;
        System.out.println("§2================================================");
        System.out.println("");

        boolean papi = Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI");
        String prefix = "§2[" + INSTANCE.getName() + "]§r ";
        String mainfolder = "/menus";
        fileManager.logInfo(true)
                .registerDefaultGenerateFiles("mainmenu.yml", "/menus", mainfolder)
                .registerDefaultGenerateFiles("teleports.yml", "/menus", mainfolder)
                .registerCustomFilesFolder("/menus")
                .setup(this);


        this.getCommand("rpgmenu").setExecutor(new FontCommand());
        this.getCommand("rpgresourse").setExecutor(new ResourseCommand());
        this.getCommand("rpgmenu").setTabCompleter(new FronCommandHendler());
        getServer().getPluginManager().registerEvents(new ActionbarEvents(), this);
        getServer().getPluginManager().registerEvents(new ResourcePack(), this);
        if (papi) {
            System.out.println(prefix + "Successfully loaded §aPlaceholderAPI");
        } else {
            System.out.println(prefix + "Failed to load §aPlaceholderAPI");
        }

        System.out.println("");
        System.out.println("§2================================================");
    }

    @Override
    public void onDisable() {
        ActionbarMenager.close();
    }
}
