package main.menurpg.commands;

import main.menurpg.api.Messages;
import main.menurpg.events.TitleMenager;
import main.menurpg.events.actionbar;
import main.menurpg.filemenager.FileManager;
import main.menurpg.fontmenu.FontMenu;
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
    private FileManager fileManager = FileManager.getInstance();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            return true;
        }


        Player player = (Player) sender;

        if (args.length == 1){
            if (args[0].equalsIgnoreCase("reload")){
                if (player.hasPermission("rpgmenu.admin")){
                    fileManager.reloadAllFiles();
                    sender.sendMessage(Messages.RELOAD.getmassage());
                    return true;
                }
                else {
                    sender.sendMessage(Messages.NO_PERMISSION.getmassage());
                    return true;
                }
            }
        }
        if (args.length == 2){
            if (args[0].equalsIgnoreCase("openmenu")){
                if (player.hasPermission("rpgmenu.admin")){
                    FontMenu font = new FontMenu();
                    font.addPlayer(player, args[1]);
                    actionbar.start();
                }
                else {
                    sender.sendMessage(Messages.NO_PERMISSION.getmassage());
                }

            }
        }



        return true;
    }
}

