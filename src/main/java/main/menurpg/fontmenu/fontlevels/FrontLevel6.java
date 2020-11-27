package main.menurpg.fontmenu.fontlevels;

@SuppressWarnings("NonAsciiCharacters")
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
    a('a', '\uD501'),
    b('b', '\uD502'),
    c('c', '\uD503'),
    d('d', '\uD504'),
    e('e', '\uD505'),
    f('f', '\uD506'),
    g('g', '\uD507'),
    h('h', '\uD508'),
    i('i', '\uD509'),
    j('j', '\uD510'),
    k('k', '\uD511'),
    l('l', '\uD512'),
    m('m', '\uD513'),
    n('n', '\uD514'),
    o('o', '\uD515'),
    p('p', '\uD516'),
    q('q', '\uD517'),
    r('r', '\uD518'),
    s('s', '\uD519'),
    t('t', '\uD520'),
    u('u', '\uD521'),
    v('v', '\uD522'),
    w('w', '\uD523'),
    x('x', '\uD524'),
    y('y', '\uD525'),
    z('z', '\uD526'),
    DEFAULT('z', '\uE500');


    private final char character;
    private final char font;

    FrontLevel6(char character, char font) {
        this.character = character;
        this.font = font;
    }

    public static FrontLevel6 getDefaultFontInfo(char c) {
        for (FrontLevel6 dFI : FrontLevel6.values()) {
            if (dFI.getCharacter() == c) return dFI;
        }
        return FrontLevel6.DEFAULT;
    }

    public char getfont() {
        return this.font;
    }

    public char getCharacter() {
        return this.character;
    }


}

