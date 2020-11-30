package main.menurpg.commands;

import main.menurpg.menagers.FileManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ResourseCommand implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length == 0 && p.hasPermission("rpgmenu.rp.command")) {
                p.setResourcePack(FileManager.Files.CONFIG.getFile().getString("Resoursepack.download-link"));
            }

        }
        return true;
    }
}
