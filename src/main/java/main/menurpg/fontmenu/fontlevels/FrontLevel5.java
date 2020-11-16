package main.menurpg.fontmenu.fontlevels;

public enum FrontLevel5 {
    а('а', '\uE401'),
    б('б', '\uE402'),
    в('в', '\uE403'),
    г('г', '\uE404'),
    д('д', '\uE405'),
    е('е', '\uE406'),
    ж('ж', '\uE407'),
    з('з', '\uE408'),
    и('и', '\uE409'),
    й('й', '\uE410'),
    к('к', '\uE411'),
    л('л', '\uE412'),
    м('м', '\uE413'),
    н('н', '\uE414'),
    о('о', '\uE415'),
    п('п', '\uE416'),
    р('р', '\uE417'),
    с('с', '\uE418'),
    т('т', '\uE419'),
    у('у', '\uE420'),
    ф('ф', '\uE421'),
    х('х', '\uE422'),
    ц('ц', '\uE423'),
    ч('ч', '\uE424'),
    ш('ш', '\uE425'),
    щ('щ', '\uE426'),
    ъ('ъ', '\uE427'),
    ы('ы', '\uE428'),
    ь('ь', '\uE429'),
    э('э', '\uE430'),
    ю('ю', '\uE431'),
    я('я', '\uE432'),
    DEFAULT('z', '\uE400');


    private char character;
    private char font;

    FrontLevel5(char character, char font) {
        this.character = character;
        this.font = font;
    }

    public char getfont() {
        return this.font;
    }

    public char getCharacter() {
        return this.character;
    }


    public static FrontLevel5 getDefaultFontInfo(char c) {
        for (FrontLevel5 dFI : FrontLevel5.values()) {
            if (dFI.getCharacter() == c) return dFI;
        }
        return FrontLevel5.DEFAULT;
    }



}
