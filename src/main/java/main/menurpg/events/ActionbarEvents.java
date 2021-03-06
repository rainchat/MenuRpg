package main.menurpg.events;

import main.menurpg.api.Messages;
import main.menurpg.menagers.ActionbarManager;
import main.menurpg.menagers.FileManager;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

public class ActionbarEvents implements Listener {

    private static final FileManager fileManager = FileManager.getInstance();

    public static void update(Player p) {
    }


    @EventHandler
    public void onF(PlayerSwapHandItemsEvent e) {
        if (e.getPlayer().isSneaking()) {
            e.setCancelled(true);
            if (ActionbarManager.containsPlayer(e.getPlayer())) {
                ActionbarManager.removePlayer(e.getPlayer());
                e.getPlayer().sendMessage(Messages.MENU_CLOSE.getmessage());
                e.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(""));
            } else if (e.getPlayer().hasPermission("rpgmenu.use")) {

                e.getPlayer().sendMessage(Messages.MENU_OPEN.getmessage());
                e.getPlayer().getInventory().setHeldItemSlot(1);
                ActionbarManager.addPlayer(e.getPlayer(), FileManager.Files.CONFIG.getFile().getString("MainMenu"));
            }

        }
    }

    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        if (!ActionbarManager.containsPlayer(e.getPlayer())) {
            return;
        }

        Player player = e.getPlayer();
        e.setCancelled(true);

        ActionbarManager.runcommand(player);


    }

    @EventHandler
    public void onScroll(PlayerItemHeldEvent e) {
        if (!ActionbarManager.containsPlayer(e.getPlayer())) {
            return;
        }

        if (!(e.getPlayer().getInventory().getHeldItemSlot() == 1)) {
            e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_HAT, 1.0F, 1.0F);
            if (e.getPreviousSlot() >= 6 || e.getPreviousSlot() == 0) {
                ActionbarManager.changePos(-1, e.getPlayer());
            } else if (e.getPreviousSlot() >= 2) {
                ActionbarManager.changePos(1, e.getPlayer());
            }
        }

        e.getPlayer().getInventory().setHeldItemSlot(1);


        ActionbarManager.update(e.getPlayer());
    }


}