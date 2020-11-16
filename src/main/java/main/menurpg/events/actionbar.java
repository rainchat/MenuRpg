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

import java.util.HashMap;
import java.util.Map;

public class actionbar implements Listener {
    private int tusk;
    private BaseComponent offmenu = new TextComponent("");
    private HashMap<Player, PlayerMenu> pMenu = new HashMap<>();
    private FileManager fileManager = new FileManager(main.getPlugin(main.class));


    @EventHandler
    public void onF(PlayerSwapHandItemsEvent e){
        if (e.getPlayer().isSneaking()){
            if (pMenu.get(e.getPlayer()) != null){
                pMenu.remove(e.getPlayer());
                e.getPlayer().sendMessage("Меню выключено!");
                e.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR, offmenu);
            }
            else {
                e.getPlayer().sendMessage("Меню актевировано!");
                pMenu.put(e.getPlayer(),new PlayerMenu(1));
                start();
            }

        }
    }

    @EventHandler
    public void onClick(PlayerInteractEvent e){
        if (pMenu.get(e.getPlayer())==null){
            return;
        }

        Player player = e.getPlayer();
        e.setCancelled(true);


        int i = pMenu.get(player).getNumber();
        switch (i){
            case 1:
                player.performCommand((String) fileManager.getConfig("config.yml").get().get("menu.line1.command"));
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, offmenu);
                break;
            case 2:
                player.performCommand((String) fileManager.getConfig("config.yml").get().get("menu.line2.command"));
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, offmenu);
                break;
            case 3:
                player.performCommand((String) fileManager.getConfig("config.yml").get().get("menu.line3.command"));
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, offmenu);
                break;
            case 4:
                player.performCommand((String) fileManager.getConfig("config.yml").get().get("menu.line4.command"));
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, offmenu);
                break;
            case 5:
                player.performCommand((String) fileManager.getConfig("config.yml").get().get("menu.line5.command"));
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, offmenu);
                break;
            case 6:
                player.performCommand((String) fileManager.getConfig("config.yml").get().get("menu.line6.command"));
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, offmenu);
                break;
        }
        pMenu.remove(player);

    }

    @EventHandler

    public void onScroll(PlayerItemHeldEvent e){
        if (pMenu.get(e.getPlayer())==null){
            return;
        }

        if (e.getNewSlot() == 8 && e.getPreviousSlot() == 0){
            pMenu.get(e.getPlayer()).setNumber(pMenu.get(e.getPlayer()).getNumber()-1);
        }
        else if (e.getNewSlot() == 0 && e.getPreviousSlot() == 8){
            pMenu.get(e.getPlayer()).setNumber(pMenu.get(e.getPlayer()).getNumber()+1);
        }
        else if (e.getNewSlot() > e.getPreviousSlot()){
            pMenu.get(e.getPlayer()).setNumber(pMenu.get(e.getPlayer()).getNumber()+1);
        }
        else {
            pMenu.get(e.getPlayer()).setNumber(pMenu.get(e.getPlayer()).getNumber()-1);
        }

        if (pMenu.get(e.getPlayer()).getNumber() > 6){
            pMenu.get(e.getPlayer()).setNumber(1);
        }
        else if (pMenu.get(e.getPlayer()).getNumber()<=0){
            pMenu.get(e.getPlayer()).setNumber(6);
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
                for (Map.Entry<Player,PlayerMenu> s : pMenu.entrySet()){
                    FontMenu text = new FontMenu();
                    s.getKey().spigot().sendMessage(ChatMessageType.ACTION_BAR, text.getText(s.getValue().getNumber()));
                }

            }
        },0,20);


    }


}