package main.menurpg.events;

import main.menurpg.api.Messages;
import main.menurpg.filemenager.FileManager;
import main.menurpg.fontmenu.FontMenu;
import main.menurpg.MenuRPGPlugin;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.scheduler.BukkitTask;

public class ActionBar implements Listener {
    static private BukkitTask tusk;
    static private final FontMenu MenuText = new FontMenu();
    private static final FileManager fileManager = FileManager.getInstance();

    static public void start() {
        if (!tusk.isCancelled()) {
            tusk.cancel();
        }

        tusk = Bukkit.getScheduler().runTaskTimerAsynchronously(MenuRPGPlugin.getPlugin(MenuRPGPlugin.class), () -> {
            for (Player p : MenuText.getActivePlayers()) {
                FontMenu text = new FontMenu();
                p.spigot().sendMessage(ChatMessageType.ACTION_BAR, text.getText(p));
            }
        }, 0, 40);


    }

    @EventHandler
    public void onF(PlayerSwapHandItemsEvent e) {
        if (e.getPlayer().isSneaking()) {
            e.setCancelled(true);
            if (MenuText.containsPlayer(e.getPlayer())) {
                MenuText.removePlayer(e.getPlayer());
                e.getPlayer().sendMessage(Messages.MENU_CLOSE.getmassage());
                e.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(""));
            } else if (e.getPlayer().hasPermission("rpgmenu.use")) {

                e.getPlayer().sendMessage(Messages.MENU_OPEN.getmassage());
                e.getPlayer().getInventory().setHeldItemSlot(1);
                MenuText.addPlayer(e.getPlayer(), FileManager.Files.CONFIG.getFile().getString("MainMenu"));
                start();
            }

        }
    }

    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        if (!MenuText.containsPlayer(e.getPlayer())) {
            return;
        }

        Player player = e.getPlayer();
        e.setCancelled(true);

        MenuText.activateCommand(player);


    }

    @EventHandler
    public void onScroll(PlayerItemHeldEvent e) {
        if (!MenuText.containsPlayer(e.getPlayer())) {
            return;
        }

        if (!(e.getPlayer().getInventory().getHeldItemSlot() == 1)) {
            e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_HAT, 1.0F, 1.0F);
            if (e.getPreviousSlot() >= 6 || e.getPreviousSlot() == 0) {
                MenuText.changePos(-1, e.getPlayer());
            } else if (e.getPreviousSlot() >= 2) {
                MenuText.changePos(1, e.getPlayer());
            }
        }

        e.getPlayer().getInventory().setHeldItemSlot(1);


        start();
    }


}