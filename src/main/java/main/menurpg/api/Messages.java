package main.menurpg.api;

import main.menurpg.filemenager.FileManager;
import main.menurpg.utility.color;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;

public enum Messages {

    NO_PERMISSION("Message.No-Permissions", "&cУ вас нет прав на использование этой команды"),
    MENU_ALREADY_OPEN("Message.Menu-Already-open", "&cМеню уже открыто"),
    MENU_OPEN("Message.Menu-Open", "&7Меню открыто"),
    MENU_CLOSE("Message.Menu-Close", "&7Меню Закрыто"),
    MENU_OPEN_ERR("Message.Menu-Open-Err", "&7Меню не может быть открыто, так как открыто &cдругое &7меню"),
    NOT_A_MENU("Message.Not-A-Menu", "&7Такого меню не существует"),
    PLAYERS_NOT_ONLINE("Message.Player-Not-Online", "&cВыбранный игрок не в сети"),
    RELOAD("Message.Reload", "&7Все конфиги перезагружены...");

    private String path;
    private String defaultMessage;

    private Messages(String path, String defaultMessage) {
        this.path = path;
        this.defaultMessage = defaultMessage;
    }



    public String getmassage(){
        if (FileManager.Files.LANGUAGE.getFile().getString(path) == null){
            return color.parseHexString(FileManager.Files.LANGUAGE.getFile().getString("Preffix") + defaultMessage);
        }
        else{
            return color.parseHexString(FileManager.Files.LANGUAGE.getFile().getString("Preffix") + FileManager.Files.LANGUAGE.getFile().getString(path));
        }
    }
}
