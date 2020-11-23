package main.menurpg.fontmenu.fontlevels;

public enum FrontLevel3 {
    а('а', '\uE201'),
    б('б', '\uE202'),
    в('в', '\uE203'),
    г('г', '\uE204'),
    д('д', '\uE205'),
    е('е', '\uE206'),
    ж('ж', '\uE207'),
    з('з', '\uE208'),
    и('и', '\uE209'),
    й('й', '\uE210'),
    к('к', '\uE211'),
    л('л', '\uE212'),
    м('м', '\uE213'),
    н('н', '\uE214'),
    о('о', '\uE215'),
    п('п', '\uE216'),
    р('р', '\uE217'),
    с('с', '\uE218'),
    т('т', '\uE219'),
    у('у', '\uE220'),
    ф('ф', '\uE221'),
    х('х', '\uE222'),
    ц('ц', '\uE223'),
    ч('ч', '\uE224'),
    ш('ш', '\uE225'),
    щ('щ', '\uE226'),
    ъ('ъ', '\uE227'),
    ы('ы', '\uE228'),
    ь('ь', '\uE229'),
    э('э', '\uE230'),
    ю('ю', '\uE231'),
    я('я', '\uE232'),
    a('a', '\uD201'),
    b('b', '\uD202'),
    c('c', '\uD203'),
    d('d', '\uD204'),
    e('e', '\uD205'),
    f('f', '\uD206'),
    g('g', '\uD207'),
    h('h', '\uD208'),
    i('i', '\uD209'),
    j('j', '\uD210'),
    k('k', '\uD211'),
    l('l', '\uD212'),
    m('m', '\uD213'),
    n('n', '\uD214'),
    o('o', '\uD215'),
    p('p', '\uD216'),
    q('q', '\uD217'),
    r('r', '\uD218'),
    s('s', '\uD219'),
    t('t', '\uD220'),
    u('u', '\uD221'),
    v('v', '\uD222'),
    w('w', '\uD223'),
    x('x', '\uD224'),
    y('y', '\uD225'),
    z('z', '\uD226'),
    DEFAULT('z', '\uE200');


    private char character;
    private char font;

    FrontLevel3(char character, char font) {
        this.character = character;
        this.font = font;
    }

    public char getfont() {
        return this.font;
    }

    public char getCharacter() {
        return this.character;
    }


    public static FrontLevel3 getDefaultFontInfo(char c) {
        for (FrontLevel3 dFI : FrontLevel3.values()) {
            if (dFI.getCharacter() == c) return dFI;
        }
        return FrontLevel3.DEFAULT;
    }



}

