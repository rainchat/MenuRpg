package main.menurpg.api;

import main.menurpg.menagers.FileManager;
import main.menurpg.utility.Color;

public enum Messages {

    NO_PERMISSION("Message.No-Permissions", "&cYou do not have permission to use this command"),
    MENU_ALREADY_OPEN("Message.Menu-Already-open", "&cThe menu is already open"),
    MENU_OPEN("Message.Menu-Open", "&7Menu is open"),
    MENU_CLOSE("Message.Menu-Close", "&7Menu is closed"),
    NOT_A_MENU("Message.Not-A-Menu", "&7This menu does not exist.."),
    PLAYERS_NOT_ONLINE("Message.Player-Not-Online", "&cThe selected player is offline.."),
    RESOURSEPACK_ERROR("Message.Resoursepack-err-download", "&7Download error.."),
    RESOURSEPACK_LOAD("Message.Resoursepack-load", "&7Resourcepack was loaded successfully.."),
    RESOURSEPACK_CANCEL("Message.Resoursepack-cancel", "&7You canceled downloading the resource pack.."),
    RESOURSEPACK_KICK("Message.Resoursepack-kick", "&7You were kicked, because you did not\n&7download our&6 Server Resource Pack&c!\n\n&aActivate&6 Resourcepacks&a in your Server-Settings to play!"),
    RELOAD("Message.Reload", "&7All configs have been reloaded..");

    private final String path;
    private final String defaultMessage;

    Messages(String path, String defaultMessage) {
        this.path = path;
        this.defaultMessage = defaultMessage;
    }


    public String getmassage(Boolean preffix) {
        if (FileManager.Files.LANGUAGE.getFile().getString(path) == null) {
            return Color.parseHexString(defaultMessage);
        } else {
            return Color.parseHexString(FileManager.Files.LANGUAGE.getFile().getString(path));
        }
    }

    public String getmassage() {
        return Color.parseHexString(FileManager.Files.LANGUAGE.getFile().getString("Preffix") + FileManager.Files.LANGUAGE.getFile().getString(path, defaultMessage));

    }
}
