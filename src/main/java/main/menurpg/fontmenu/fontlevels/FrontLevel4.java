package main.menurpg.fontmenu.fontlevels;

public enum FrontLevel4 {
    а('а', '\uE301'),
    б('б', '\uE302'),
    в('в', '\uE303'),
    г('г', '\uE304'),
    д('д', '\uE305'),
    е('е', '\uE306'),
    ж('ж', '\uE307'),
    з('з', '\uE308'),
    и('и', '\uE309'),
    й('й', '\uE310'),
    к('к', '\uE311'),
    л('л', '\uE312'),
    м('м', '\uE313'),
    н('н', '\uE314'),
    о('о', '\uE315'),
    п('п', '\uE316'),
    р('р', '\uE317'),
    с('с', '\uE318'),
    т('т', '\uE319'),
    у('у', '\uE320'),
    ф('ф', '\uE321'),
    х('х', '\uE322'),
    ц('ц', '\uE323'),
    ч('ч', '\uE324'),
    ш('ш', '\uE325'),
    щ('щ', '\uE326'),
    ъ('ъ', '\uE327'),
    ы('ы', '\uE328'),
    ь('ь', '\uE329'),
    э('э', '\uE330'),
    ю('ю', '\uE331'),
    я('я', '\uE332'),
    DEFAULT('z', '\uE300');


    private char character;
    private char font;

    FrontLevel4(char character, char font) {
        this.character = character;
        this.font = font;
    }

    public char getfont() {
        return this.font;
    }

    public char getCharacter() {
        return this.character;
    }


    public static FrontLevel4 getDefaultFontInfo(char c) {
        for (FrontLevel4 dFI : FrontLevel4.values()) {
            if (dFI.getCharacter() == c) return dFI;
        }
        return FrontLevel4.DEFAULT;
    }



}
