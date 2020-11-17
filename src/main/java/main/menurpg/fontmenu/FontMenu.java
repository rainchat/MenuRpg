package main.menurpg.fontmenu;


import main.menurpg.filemenager.FileManager;
import main.menurpg.filemenager.PlayerMenu;
import main.menurpg.fontmenu.fontlevels.*;
import main.menurpg.main;
import main.menurpg.utility.Executor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class FontMenu {
    private FileManager fileManager = new FileManager(main.getPlugin(main.class));
    private BaseComponent textcopy = new TextComponent("");
    static HashMap<Player, PlayerMenu> Pmenu = new HashMap<>();


    public void addPlayer(Player player){
        List<String> text = new ArrayList<>();
        for (String s : fileManager.getConfig("config.yml").get().getConfigurationSection("menu").getKeys(false)){
            text.add(fileManager.getConfig("config.yml").get().getString("menu."+s+".name"));
        }
        Pmenu.put(player,new PlayerMenu(6,text));
    }

    public void changePos(int operator, Player player){
        PlayerMenu temp  = Pmenu.get(player);
        temp.addEnd(operator);
        Pmenu.put(player,temp);
    }

    public void activateCommand(Player player){
        int x = Pmenu.get(player).getLine();
        int z = 0;
        for (String s : fileManager.getConfig("config.yml").get().getConfigurationSection("menu").getKeys(false)){
            z++;
            if (z==x){
                List<String> command = new ArrayList<>();
                command = fileManager.getConfig("config.yml").get().getStringList("menu."+s+".actions");
                Executor test = new Executor(command,player);
                return;
            }

        }
    }

    public BaseComponent getText(Player player){
        setStartSpace();
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
        textcopy.addExtra(Negative_Space.getSpase(8 * 14));
        for (char s : z.toCharArray()) {
            FrontLevel1 dFI = FrontLevel1.getDefaultFontInfo(s);
            y = dFI.getfont();
            textcopy.addExtra(y + "");
        }
        for (int i = 0; i < (13 - z.length()); i++) {
            y = '\uEf00';
            textcopy.addExtra(y + "");
        }

    }

    public void setLine2(Player player){
        String z = Pmenu.get(player).getLine(1);
        char y;
        textcopy.addExtra(Negative_Space.getSpase(8*14));
        if (Pmenu.get(player).getCursor() == 2){
            y = '\uE904';
        }
        else {
            y = '\uE903';
        }
        textcopy.addExtra(y+"");
        textcopy.addExtra(Negative_Space.getSpase(8*14));
        for (char s : z.toCharArray()){
            FrontLevel2 dFI = FrontLevel2.getDefaultFontInfo(s);
            y = dFI.getfont();
            textcopy.addExtra(y+"");
        }
        for (int i = 0; i < (13-z.length()); i++){
            y = '\uE100';
            textcopy.addExtra(y+"");
        }
    }

    public void setLine3(Player player){
        String z = Pmenu.get(player).getLine(2);
        char y;
        textcopy.addExtra(Negative_Space.getSpase(8*14));
        if (Pmenu.get(player).getCursor() == 3){
            y = '\uE906';
        }
        else {
            y = '\uE905';
        }
        textcopy.addExtra(y+"");
        textcopy.addExtra(Negative_Space.getSpase(8*14));
        for (char s : z.toCharArray()){
            FrontLevel3 dFI = FrontLevel3.getDefaultFontInfo(s);
            y = dFI.getfont();
            textcopy.addExtra(y+"");
        }
        for (int i = 0; i < (13-z.length()); i++){
            y = '\uE200';
            textcopy.addExtra(y+"");
        }
    }

    public void setLine4(Player player){
        String z = Pmenu.get(player).getLine(3);
        char y;
        textcopy.addExtra(Negative_Space.getSpase(8*14));
        if (Pmenu.get(player).getCursor() == 4){
            y = '\uE908';
        }
        else {
            y = '\uE907';
        }
        textcopy.addExtra(y+"");
        textcopy.addExtra(Negative_Space.getSpase(8*14));
        for (char s : z.toCharArray()){
            FrontLevel4 dFI = FrontLevel4.getDefaultFontInfo(s);
            y = dFI.getfont();
            textcopy.addExtra(y+"");
        }
        for (int i = 0; i < (13-z.length()); i++){
            y = '\uE300';
            textcopy.addExtra(y+"");
        }
    }

    public void setLine5(Player player){
        String z = Pmenu.get(player).getLine(4);
        char y;
        textcopy.addExtra(Negative_Space.getSpase(8*14));
        if (Pmenu.get(player).getCursor() == 5){
            y = '\uE910';
        }
        else {
            y = '\uE909';
        }
        textcopy.addExtra(y+"");
        textcopy.addExtra(Negative_Space.getSpase(8*14));
        for (char s : z.toCharArray()){
            FrontLevel5 dFI = FrontLevel5.getDefaultFontInfo(s);
            y = dFI.getfont();
            textcopy.addExtra(y+"");
        }
        for (int i = 0; i < (13-z.length()); i++){
            y = '\uE400';
            textcopy.addExtra(y+"");
        }
    }

    public void setLine6(Player player){
        String z = Pmenu.get(player).getLine(5);
        char y;
        textcopy.addExtra(Negative_Space.getSpase(8*14));
        if (Pmenu.get(player).getCursor() == 6){
            y = '\uE912';
        }
        else {
            y = '\uE911';
        }
        textcopy.addExtra(y+"");
        textcopy.addExtra(Negative_Space.getSpase(8*14));
        for (char s : z.toCharArray()){
            FrontLevel6 dFI = FrontLevel6.getDefaultFontInfo(s);
            y = dFI.getfont();
            textcopy.addExtra(y+"");
        }
        for (int i = 0; i < (13-z.length()); i++){
            y = '\uE500';
            textcopy.addExtra(y+"");
        }
    }
}


