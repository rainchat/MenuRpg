package main.menurpg.events;

import main.menurpg.filemenager.FileManager;
import main.menurpg.filemenager.PlayerMenu;
import main.menurpg.fontmenu.FontMenu;
import main.menurpg.main;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class actionbar implements Listener {
    private int tusk;
    private FontMenu MenuText = new FontMenu();
    private FileManager fileManager = new FileManager(main.getPlugin(main.class));


    @EventHandler
    public void onF(PlayerSwapHandItemsEvent e){
        if (e.getPlayer().isSneaking()){
            if (MenuText.isConteinPlayer(e.getPlayer())){
                MenuText.removePlayer(e.getPlayer());
                e.getPlayer().sendMessage("Меню выключено!");
                e.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(""));
            }
            else {
                e.getPlayer().sendMessage("Меню актевировано!");
                MenuText.addPlayer(e.getPlayer());
                start();
            }

        }
    }

    @EventHandler
    public void onClick(PlayerInteractEvent e){
        if (!MenuText.isConteinPlayer(e.getPlayer())){
            return;
        }

        Player player = e.getPlayer();
        e.setCancelled(true);

        MenuText.activateCommand(player);


    }

    @EventHandler

    public void onScroll(PlayerItemHeldEvent e){
        if (!MenuText.isConteinPlayer(e.getPlayer())){
            return;
        }

        if (e.getNewSlot() == 8 && e.getPreviousSlot() == 0){
            MenuText.changePos(-1,e.getPlayer());
        }
        else if (e.getNewSlot() == 0 && e.getPreviousSlot() == 8){
            MenuText.changePos(1,e.getPlayer());
        }
        else if (e.getNewSlot() > e.getPreviousSlot()){
            MenuText.changePos(1,e.getPlayer());
        }
        else {
            MenuText.changePos(-1,e.getPlayer());
        }

        start();
    }

    public void start(){
        if (tusk != -1){
            Bukkit.getScheduler().cancelTask(tusk);
        }


        tusk = Bukkit.getScheduler().scheduleAsyncRepeatingTask(main.getPlugin(main.class), new Runnable() {
            @Override
            public void run() {
                for (Player p : MenuText.getActivePlayers()){
                    FontMenu text = new FontMenu();
                    p.spigot().sendMessage(ChatMessageType.ACTION_BAR, text.getText(p));
                }

            }
        },0,20);


    }


}