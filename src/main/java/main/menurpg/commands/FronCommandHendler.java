package main.menurpg.commands;

import main.menurpg.filemenager.FileManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.util.StringUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FronCommandHendler implements TabCompleter {
    private static final FileManager fileManager = FileManager.getInstance();


    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        List<String> completions = new ArrayList<>();
        List<String> commands = new ArrayList<>();
        if (args.length == 1) {
            commands.add("title");
            commands.add("reload");
            commands.add("openmenu");
            StringUtil.copyPartialMatches(args[0], commands, completions);
        } else if (args.length == 2) {
            if (args[0].equals("title")) {
                commands.add("notready");
            } else if (args[0].equals("openmenu")) {
                commands.addAll(fileManager.getAllMenu());
            }
            StringUtil.copyPartialMatches(args[1], commands, completions);
        }

        Collections.sort(completions);
        return completions;
    }
}
