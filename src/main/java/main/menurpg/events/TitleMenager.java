package main.menurpg.events;

import org.bukkit.entity.Player;

public class TitleMenager {


    public void sendTitle(Player player) {
        char y = '\uC000';
        player.sendTitle("" + y, "");
    }
}
