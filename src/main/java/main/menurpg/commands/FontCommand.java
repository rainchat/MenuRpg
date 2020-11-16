package main.menurpg.commands;

import main.menurpg.filemenager.FileManager;
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


        FileManager fileManager = new FileManager(main.getPlugin(main.class));
        fileManager.reloadConfig("config.yml");
        player.sendMessage(ChatColor.GREEN+"Конфиг перезагружен");


        return true;
    }
}

