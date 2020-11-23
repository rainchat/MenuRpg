package main.menurpg.filemenager;

import java.util.ArrayList;
import java.util.List;

public class PlayerMenu {
    private int number;
    private int startline;
    private int cursortext;
    private int cursor;
    private int textSize;
    private List<String> text = new ArrayList<>();
    private String menu;

    public PlayerMenu(int number, int textSize, String menu, List<String> text){
        this.number = number;
        this.startline = 0;
        this.cursor = 1;
        this.cursortext = 1;
        this.textSize = textSize;
        this.text = text;
        this.menu = menu;
    }

    public int getNumber(){
        return number;
    }


    public void setNumber(int number){
        this.number = number;
    }


    public void addEnd(int plus){
        if (cursor==this.number && plus == 1){
            if (startline+this.number<textSize){
                startline++;
            }
            return;
        }
        else if (cursor==1 && plus == -1){
            if (startline>=1){
                startline--;
            }
            return;
        }
        this.cursor+=plus;

    }

    public String getMenu(){
        return menu;
    }

    public String getLine(int x){
        return text.get(startline+x);
    }

    public int getLine(){
        return cursor+startline;
    }

    public int getStartline(){
        return startline;
    }

    public int getCursor(){
        return cursor;
    }




}