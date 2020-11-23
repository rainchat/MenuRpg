package main.menurpg.events;

import net.md_5.bungee.api.ChatMessageType;
import org.bukkit.entity.Player;

public class TitleMenager {



    public void sendTitle(Player player){
        char y = '\uC000';
        player.sendTitle(""+y,"");
    }
}
