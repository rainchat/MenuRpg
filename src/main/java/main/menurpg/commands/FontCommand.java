package main.menurpg.commands;

import main.menurpg.api.Messages;
import main.menurpg.menagers.ActionbarMenager;
import main.menurpg.menagers.FileManager;
import main.menurpg.menagers.PlayerData;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class FontCommand implements CommandExecutor {
    private final FileManager fileManager = FileManager.getInstance();
    static private HashMap<Player, PlayerData> test = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }

        Player player = (Player) sender;

        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("reload")) {
                if (player.hasPermission("rpgmenu.admin")) {
                    fileManager.reloadAllFiles();
                    sender.sendMessage(Messages.RELOAD.getmassage());
                    return true;
                } else {
                    sender.sendMessage(Messages.NO_PERMISSION.getmassage());
                    return true;
                }
            }
        }

        if (args.length == 2) {
            if (args[0].equalsIgnoreCase("openmenu")) {
                if (player.hasPermission("rpgmenu.admin")) {
                    ActionbarMenager.addPlayer(player, args[1]);

                    //ActionbarEvents.start();
                } else {
                    sender.sendMessage(Messages.NO_PERMISSION.getmassage());
                }

            }
        }

        return true;
    }
}

