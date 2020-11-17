package main.menurpg.commands;

import main.menurpg.filemenager.FileManager;
import main.menurpg.fontmenu.fontlevels.*;
import main.menurpg.main;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

public class FontCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;



        //FileManager fileManager = new FileManager(main.getPlugin(main.class));
        //fileManager.reloadConfig("config.yml");
        //player.sendMessage(ChatColor.GREEN+"Конфиг перезагружен");
        char y;
        BaseComponent textcopy = new TextComponent("");
        if (args[1].equalsIgnoreCase("1")){
            for (char s : args[2].toCharArray()) {
                FrontLevel1 dFI = FrontLevel1.getDefaultFontInfo(s);
                y = dFI.getfont();
                textcopy.addExtra(y + "");
            }
        }
        if (args[1].equalsIgnoreCase("2")){
            for (char s : args[2].toCharArray()) {
                FrontLevel2 dFI = FrontLevel2.getDefaultFontInfo(s);
                y = dFI.getfont();
                textcopy.addExtra(y + "");
            }
        }
        if (args[1].equalsIgnoreCase("3")){
            for (char s : args[2].toCharArray()) {
                FrontLevel3 dFI = FrontLevel3.getDefaultFontInfo(s);
                y = dFI.getfont();
                textcopy.addExtra(y + "");
            }
        }
        if (args[1].equalsIgnoreCase("4")){
            for (char s : args[2].toCharArray()) {
                FrontLevel4 dFI = FrontLevel4.getDefaultFontInfo(s);
                y = dFI.getfont();
                textcopy.addExtra(y + "");
            }
        }
        if (args[1].equalsIgnoreCase("5")){
            for (char s : args[2].toCharArray()) {
                FrontLevel5 dFI = FrontLevel5.getDefaultFontInfo(s);
                y = dFI.getfont();
                textcopy.addExtra(y + "");
            }
        }
        if (args[1].equalsIgnoreCase("6")){
            for (char s : args[2].toCharArray()) {
                FrontLevel6 dFI = FrontLevel6.getDefaultFontInfo(s);
                y = dFI.getfont();
                textcopy.addExtra(y + "");
            }
        }
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, textcopy);


        return true;
    }
}

