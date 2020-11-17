package main.menurpg.filemenager;

import java.util.List;

public class PlayerMenu {
    private int number;
    private int startline;
    private int cursortext;
    private int cursor;
    private List<String> text;

    public PlayerMenu(int number, List<String> text){
        this.number = number;
        this.startline = 0;
        this.cursor = 1;
        this.cursortext = 1;
        this.text = text;
    }

    public int getNumber(){
        return number;
    }



    public void setNumber(int number){
        this.number = number;
    }


    public void addEnd(int plus){
        if (cursor==this.number && plus == 1){
            if (startline+this.number<text.size()){
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