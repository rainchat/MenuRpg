package main.menurpg.events;

import main.menurpg.api.Messages;
import main.menurpg.menagers.FileManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerResourcePackStatusEvent;

public class ResourcePack implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if (FileManager.Files.CONFIG.getFile().getBoolean("Resoursepack.download-when-join")) {
            Player p = e.getPlayer();
            p.setResourcePack(FileManager.Files.CONFIG.getFile().getString("Resoursepack.download-link", "https://www.dropbox.com/s/ywwga4qk6q3lki5/rpgmenu.rar?dl=1"));
        }

    }


    @EventHandler
    public void ResEvent(PlayerResourcePackStatusEvent e) {
        Player p = e.getPlayer();

        switch (e.getStatus()) {
            case SUCCESSFULLY_LOADED:
                p.sendMessage(Messages.RESOURSEPACK_LOAD.getmassage());
                break;
            case FAILED_DOWNLOAD:
                p.sendMessage(Messages.RESOURSEPACK_ERROR.getmassage());
                break;
            case DECLINED:
                if (FileManager.Files.CONFIG.getFile().getBoolean("Resoursepack.kick-on-deny")) {
                    p.kickPlayer(Messages.RESOURSEPACK_KICK.getmassage(true));
                } else {
                    p.sendMessage(Messages.RESOURSEPACK_CANCEL.getmassage());
                }
        }
    }

}
