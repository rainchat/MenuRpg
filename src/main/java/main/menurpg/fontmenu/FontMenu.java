package main.menurpg.fontmenu;


import main.menurpg.api.Messages;
import main.menurpg.filemenager.FileManager;
import main.menurpg.filemenager.PlayerMenu;
import main.menurpg.fontmenu.fontlevels.*;
import main.menurpg.main;
import main.menurpg.utility.Executor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;

public class FontMenu {
    private static FileManager fileManager = FileManager.getInstance();
    private BaseComponent textcopy = new TextComponent("");
    static HashMap<Player, PlayerMenu> Pmenu = new HashMap<>();


    public void addPlayer(Player player, String menu){
        List<String> text = new ArrayList<>();


        for (String files : fileManager.getAllMenu()) {
            try {
                if (files.equalsIgnoreCase(menu)){
                FileConfiguration file = fileManager.getFile(files).getFile();
                for (String s: file.getConfigurationSection("scrolls").getKeys(false)) {
                    text.add(file.getString("scrolls." + s + ".name"));;
                }
                    break;
                }


            } catch (Exception e) {
                Bukkit.getLogger().log(Level.WARNING, fileManager.getPrefix() + "There was an error while loading the items");
                e.printStackTrace();
            }


        }
        if (text.isEmpty()){
            player.sendMessage(Messages.NOT_A_MENU.getmassage());
            return;
        }

        Pmenu.put(player, new PlayerMenu(6, text.size(), menu, text));
    }



    public void changePos(int operator, Player player){
        PlayerMenu temp  = Pmenu.get(player);
        temp.addEnd(operator);
        Pmenu.put(player,temp);
    }

    public void activateCommand(Player player){
        int x = Pmenu.get(player).getLine();
        int z = 0;
        FileConfiguration file = fileManager.getFile(Pmenu.get(player).getMenu()).getFile();
        for (String s : file.getConfigurationSection("scrolls").getKeys(false)){
            z++;
            if (z==x){
                List<String> command = new ArrayList<>();
                command = file.getStringList("scrolls." + s + ".actions");
                Executor test = new Executor(command,player);
                return;
            }

        }
    }

    public BaseComponent getText(Player player){
        //setStartSpace();
        textcopy.addExtra(Negative_Space.getStartSpace());
        setLine1(player);
        setLine2(player);
        setLine3(player);
        setLine4(player);
        setLine5(player);
        setLine6(player);
        return textcopy;
    }

    public List<Player> getActivePlayers(){
        List<Player> playerList = new ArrayList<>();
        for (Player p : Pmenu.keySet()){
            playerList.add(p);
        }
        return playerList;
    }

    public void removePlayer(Player p){
        Pmenu.remove(p);
    }
    public boolean isConteinPlayer(Player p){
        if (Pmenu.containsKey(p)){
            return true;
        }
        return false;
    }

    public void setStartSpace(){
        char y;
        y = '\uf82E';
        textcopy.addExtra(y + "");
        y = '\uf82C';
        textcopy.addExtra(y + "");
        return;
    }

    public void setLine1(Player player) {
        String z = Pmenu.get(player).getLine(0);
        char y;
        if (Pmenu.get(player).getCursor() == 1){
            y = '\uE902';
        }
        else {
            y = '\uE901';
        }
        textcopy.addExtra(y + "");
        textcopy.addExtra(Negative_Space.getMenuLength(-1));

        for (char s : z.toCharArray()) {
            FrontLevel1 dFI = FrontLevel1.getDefaultFontInfo(s);
            y = dFI.getfont();
            textcopy.addExtra(y + "");
        }

        if (!z.isEmpty()){
            textcopy.addExtra(Negative_Space.getCharLength(z.length()+1));
        }


    }

    public void setLine2(Player player){
        String z = Pmenu.get(player).getLine(1);
        char y;
        if (Pmenu.get(player).getCursor() == 2){
            y = '\uE904';
        }
        else {
            y = '\uE903';
        }

        textcopy.addExtra(y+"");
        textcopy.addExtra(Negative_Space.getMenuLength(-1));

        for (char s : z.toCharArray()){
            FrontLevel2 dFI = FrontLevel2.getDefaultFontInfo(s);
            y = dFI.getfont();
            textcopy.addExtra(y+"");
        }

        if (!z.isEmpty()){
            textcopy.addExtra(Negative_Space.getCharLength(z.length()+1));
        }
    }

    public void setLine3(Player player){
        String z = Pmenu.get(player).getLine(2);
        char y;
        if (Pmenu.get(player).getCursor() == 3){
            y = '\uE906';
        }
        else {
            y = '\uE905';
        }

        textcopy.addExtra(y+"");
        textcopy.addExtra(Negative_Space.getMenuLength(-1));

        for (char s : z.toCharArray()){
            FrontLevel3 dFI = FrontLevel3.getDefaultFontInfo(s);
            y = dFI.getfont();
            textcopy.addExtra(y+"");
        }

        if (!z.isEmpty()){
            textcopy.addExtra(Negative_Space.getCharLength(z.length()+1));
        }
    }

    public void setLine4(Player player){
        String z = Pmenu.get(player).getLine(3);
        char y;
        if (Pmenu.get(player).getCursor() == 4){
            y = '\uE908';
        }
        else {
            y = '\uE907';
        }

        textcopy.addExtra(y+"");
        textcopy.addExtra(Negative_Space.getMenuLength(-1));

        for (char s : z.toCharArray()){
            FrontLevel4 dFI = FrontLevel4.getDefaultFontInfo(s);
            y = dFI.getfont();
            textcopy.addExtra(y+"");
        }

        if (!z.isEmpty()){
            textcopy.addExtra(Negative_Space.getCharLength(z.length()+1));
        }
    }

    public void setLine5(Player player){
        String z = Pmenu.get(player).getLine(4);
        char y;
        if (Pmenu.get(player).getCursor() == 5){
            y = '\uE910';
        }
        else {
            y = '\uE909';
        }

        textcopy.addExtra(y+"");
        textcopy.addExtra(Negative_Space.getMenuLength(-1));

        for (char s : z.toCharArray()){
            FrontLevel5 dFI = FrontLevel5.getDefaultFontInfo(s);
            y = dFI.getfont();
            textcopy.addExtra(y+"");
        }

        if (!z.isEmpty()){
            textcopy.addExtra(Negative_Space.getCharLength(z.length()+1));
        }
    }

    public void setLine6(Player player){
        String z = Pmenu.get(player).getLine(5);
        char y;
        if (Pmenu.get(player).getCursor() == 6){
            y = '\uE912';
        }
        else {
            y = '\uE911';
        }


        textcopy.addExtra(y+"");
        textcopy.addExtra(Negative_Space.getMenuLength(-1));

        for (char s : z.toCharArray()){
            FrontLevel6 dFI = FrontLevel6.getDefaultFontInfo(s);
            y = dFI.getfont();
            textcopy.addExtra(y+"");
        }

        if (!z.isEmpty()){
            textcopy.addExtra(Negative_Space.getCharLength(z.length()+1));
        }
    }
}



