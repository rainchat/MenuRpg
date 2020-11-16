package main.menurpg.fontmenu;


import main.menurpg.filemenager.FileManager;
import main.menurpg.fontmenu.fontlevels.*;
import main.menurpg.main;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;

public class FontMenu {
    private FileManager fileManager = new FileManager(main.getPlugin(main.class));
    private BaseComponent textcopy = new TextComponent("");
    private int x = 0;


    public FontMenu(){

    }
    public BaseComponent getText(int z){
        x = z;
        setStartSpace();
        setLine1();
        setLine2();
        setLine3();
        setLine4();
        setLine5();
        setLine6();
        return textcopy;
    }

    public void setStartSpace(){
        char y;
        y = '\uf82E';
        textcopy.addExtra(y + "");
        y = '\uf82C';
        textcopy.addExtra(y + "");
        return;
    }

    public void setLine1() {
        String z = (String) fileManager.getConfig("config.yml").get().get("menu.line1.name");
        char y;
        if (x == 1){
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

    public void setLine2(){
        String z = (String) fileManager.getConfig("config.yml").get().get("menu.line2.name");
        char y;
        textcopy.addExtra(Negative_Space.getSpase(8*14));
        if (x == 2){
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

    public void setLine3(){
        String z = (String) fileManager.getConfig("config.yml").get().get("menu.line3.name");
        char y;
        textcopy.addExtra(Negative_Space.getSpase(8*14));
        if (x == 3){
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

    public void setLine4(){
        String z = (String) fileManager.getConfig("config.yml").get().get("menu.line4.name");
        char y;
        textcopy.addExtra(Negative_Space.getSpase(8*14));
        if (x == 4){
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

    public void setLine5(){
        String z = (String) fileManager.getConfig("config.yml").get().get("menu.line5.name");
        char y;
        textcopy.addExtra(Negative_Space.getSpase(8*14));
        if (x == 5){
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

    public void setLine6(){
        String z = (String) fileManager.getConfig("config.yml").get().get("menu.line6.name");
        char y;
        textcopy.addExtra(Negative_Space.getSpase(8*14));
        if (x == 6){
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


