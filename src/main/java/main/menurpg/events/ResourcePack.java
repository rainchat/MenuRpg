package main.menurpg.events;

import main.menurpg.api.Messages;
import main.menurpg.menagers.FileManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerResourcePackStatusEvent;

import java.math.BigInteger;

public class ResourcePack implements Listener {

    public byte[] decodeUsingBigInteger(String hexString) {
        byte[] byteArray = new BigInteger(hexString, 16)
                .toByteArray();
        if (byteArray[0] == 0) {
            byte[] output = new byte[byteArray.length - 1];
            System.arraycopy(
                    byteArray, 1, output,
                    0, output.length);
            return output;
        }
        return byteArray;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if (FileManager.Files.CONFIG.getFile().getBoolean("Resoursepack.download-when-join")) {
            String hex = "e33f8630887e3ad7d6111371c063665f17cbc7c6";
            Player p = e.getPlayer();
            p.setResourcePack(FileManager.Files.CONFIG.getFile().getString("Resoursepack.download-link", "https://www.dropbox.com/s/gocd9c433rk2m34/RpgMenu.zip?dl=1"), decodeUsingBigInteger(FileManager.Files.CONFIG.getFile().getString("Resoursepack.hash-sha1", "e33f8630887e3ad7d6111371c063665f17cbc7c6")));
        }

    }


    @EventHandler
    public void ResEvent(PlayerResourcePackStatusEvent e) {
        Player p = e.getPlayer();

        switch (e.getStatus()) {
            case SUCCESSFULLY_LOADED:
                p.sendMessage(Messages.RESOURSEPACK_LOAD.getmessage());
                break;
            case FAILED_DOWNLOAD:
                p.sendMessage(Messages.RESOURSEPACK_ERROR.getmessage());
                break;
            case DECLINED:
                if (FileManager.Files.CONFIG.getFile().getBoolean("Resoursepack.kick-on-deny")) {
                    p.kickPlayer(Messages.RESOURSEPACK_KICK.getmessage(true));
                } else {
                    p.sendMessage(Messages.RESOURSEPACK_CANCEL.getmessage());
                }
        }
    }

}
