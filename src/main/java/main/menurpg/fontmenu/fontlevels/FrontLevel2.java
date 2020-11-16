package main.menurpg.fontmenu.fontlevels;

public enum FrontLevel2 {
    а('а', '\uE101'),
    б('б', '\uE102'),
    в('в', '\uE103'),
    г('г', '\uE104'),
    д('д', '\uE105'),
    е('е', '\uE106'),
    ж('ж', '\uE107'),
    з('з', '\uE108'),
    и('и', '\uE109'),
    й('й', '\uE110'),
    к('к', '\uE111'),
    л('л', '\uE112'),
    м('м', '\uE113'),
    н('н', '\uE114'),
    о('о', '\uE115'),
    п('п', '\uE116'),
    р('р', '\uE117'),
    с('с', '\uE118'),
    т('т', '\uE119'),
    у('у', '\uE120'),
    ф('ф', '\uE121'),
    х('х', '\uE122'),
    ц('ц', '\uE123'),
    ч('ч', '\uE124'),
    ш('ш', '\uE125'),
    щ('щ', '\uE126'),
    ъ('ъ', '\uE127'),
    ы('ы', '\uE128'),
    ь('ь', '\uE129'),
    э('э', '\uE130'),
    ю('ю', '\uE131'),
    я('я', '\uE132'),
    DEFAULT('z', '\uE100');


    private char character;
    private char font;

    FrontLevel2(char character, char font) {
        this.character = character;
        this.font = font;
    }

    public char getfont() {
        return this.font;
    }

    public char getCharacter() {
        return this.character;
    }


    public static FrontLevel2 getDefaultFontInfo(char c) {
        for (FrontLevel2 dFI : FrontLevel2.values()) {
            if (dFI.getCharacter() == c) return dFI;
        }
        return FrontLevel2.DEFAULT;
    }



}