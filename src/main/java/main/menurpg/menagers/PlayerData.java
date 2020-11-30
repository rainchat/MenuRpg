package main.menurpg.menagers;

public class PlayerData {
    private int number;
    private int startLine = 1;
    private int endline;
    private int cursor = 1;
    ;
    private int sizemenu;
    private String menu;


    public PlayerData(int number, String menu, int sizemenu) {
        this.number = number;
        this.menu = menu;
        this.sizemenu = sizemenu;
        endline = startLine + number - 1;
    }

    public int getCursor() {
        return cursor;
    }

    public int getEndline() {
        return startLine + number - 1;
    }

    public int getLine() {
        return cursor + startLine - 1;
    }

    public int getStartLine() {
        return startLine;
    }

    public String getMenu() {
        return menu;
    }

    public void setCursor(int plus) {
        if (cursor == this.number && plus == 1) {
            if (startLine + this.number < sizemenu) {
                startLine++;
            }
            return;
        } else if (cursor == 1 && plus == -1) {
            if (startLine > 1) {
                startLine--;
            }
            return;
        }
        this.cursor += plus;
    }

}
