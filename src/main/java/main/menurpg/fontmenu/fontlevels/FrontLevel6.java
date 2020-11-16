package main.menurpg.fontmenu.fontlevels;

public enum FrontLevel6 {
    а('а', '\uE501'),
    б('б', '\uE502'),
    в('в', '\uE503'),
    г('г', '\uE504'),
    д('д', '\uE505'),
    е('е', '\uE506'),
    ж('ж', '\uE507'),
    з('з', '\uE508'),
    и('и', '\uE509'),
    й('й', '\uE510'),
    к('к', '\uE511'),
    л('л', '\uE512'),
    м('м', '\uE513'),
    н('н', '\uE514'),
    о('о', '\uE515'),
    п('п', '\uE516'),
    р('р', '\uE517'),
    с('с', '\uE518'),
    т('т', '\uE519'),
    у('у', '\uE520'),
    ф('ф', '\uE521'),
    х('х', '\uE522'),
    ц('ц', '\uE523'),
    ч('ч', '\uE524'),
    ш('ш', '\uE525'),
    щ('щ', '\uE526'),
    ъ('ъ', '\uE527'),
    ы('ы', '\uE528'),
    ь('ь', '\uE529'),
    э('э', '\uE530'),
    ю('ю', '\uE531'),
    я('я', '\uE532'),
    DEFAULT('z', '\uE500');


    private char character;
    private char font;

    FrontLevel6(char character, char font) {
        this.character = character;
        this.font = font;
    }

    public char getfont() {
        return this.font;
    }

    public char getCharacter() {
        return this.character;
    }


    public static FrontLevel6 getDefaultFontInfo(char c) {
        for (FrontLevel6 dFI : FrontLevel6.values()) {
            if (dFI.getCharacter() == c) return dFI;
        }
        return FrontLevel6.DEFAULT;
    }



}

