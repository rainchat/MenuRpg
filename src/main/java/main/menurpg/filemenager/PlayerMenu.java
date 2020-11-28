package main.menurpg.filemenager;

import java.util.List;

public class PlayerMenu {
    private int number;
    private int startLine;
    private final int cursortext;
    private int cursor;
    private final int textSize;
    private List<String> text;
    private final String menu;

    public PlayerMenu(int number, int textSize, String menu, List<String> text) {
        this.number = number;
        this.startLine = 0;
        this.cursor = 1;
        this.cursortext = 1;
        this.textSize = textSize;
        this.text = text;
        this.menu = menu;
    }

    public int getNumber() {
        return number;
    }


    public void setNumber(int number) {
        this.number = number;
    }


    public void addEnd(int plus) {
        if (cursor == this.number && plus == 1) {
            if (startLine + this.number < textSize) {
                startLine++;
            }
            return;
        } else if (cursor == 1 && plus == -1) {
            if (startLine >= 1) {
                startLine--;
            }
            return;
        }
        this.cursor += plus;

    }

    public String getMenu() {
        return menu;
    }

    public String getLine(int x) {
        return text.get(startLine + x);
    }

    public int getLine() {
        return cursor + startLine;
    }

    public int getStartLine() {
        return startLine;
    }

    public int getCursor() {
        return cursor;
    }


}