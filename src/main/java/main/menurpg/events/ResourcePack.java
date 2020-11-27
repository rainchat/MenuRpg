package main.menurpg.events;

import main.menurpg.api.Messages;
import main.menurpg.filemenager.FileManager;
import main.menurpg.main;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerResourcePackStatusEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class ResourcePack implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        if (FileManager.Files.CONFIG.getFile().getBoolean("Resoursepack.download-when-join")){
            Player p = e.getPlayer();
            if (!FileManager.Files.CONFIG.getFile().getString("Resoursepack.download-link").isEmpty()) {
                p.setResourcePack(FileManager.Files.CONFIG.getFile().getString("Resoursepack.download-link"));
            }
            else {
                p.setResourcePack("https://www.dropbox.com/s/ywwga4qk6q3lki5/rpgmenu.rar?dl=1");
            }
        }

    }


    @EventHandler
    public void ResEvent(PlayerResourcePackStatusEvent e) {
        Player p = e.getPlayer();

        if (e.getStatus() == PlayerResourcePackStatusEvent.Status.SUCCESSFULLY_LOADED) {
            p.sendMessage(Messages.RESOURSEPACK_LOAD.getmassage());
        } else {
            if (e.getStatus() == PlayerResourcePackStatusEvent.Status.DECLINED) {
                if (FileManager.Files.CONFIG.getFile().getBoolean("Resoursepack.kick-on-deny")){
                    p.kickPlayer(Messages.RESOURSEPACK_KICK.getmassage(true));
                }
                p.sendMessage(Messages.RESOURSEPACK_CANCEL.getmassage());
            }

            if (e.getStatus() == PlayerResourcePackStatusEvent.Status.FAILED_DOWNLOAD) {
                p.sendMessage(Messages.RESOURSEPACK_ERROR.getmassage());
            }

        }
    }




}
