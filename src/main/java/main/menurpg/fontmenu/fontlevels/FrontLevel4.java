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
    a('a', '\uD301'),
    b('b', '\uD302'),
    c('c', '\uD303'),
    d('d', '\uD304'),
    e('e', '\uD305'),
    f('f', '\uD306'),
    g('g', '\uD307'),
    h('h', '\uD308'),
    i('i', '\uD309'),
    j('j', '\uD310'),
    k('k', '\uD311'),
    l('l', '\uD312'),
    m('m', '\uD313'),
    n('n', '\uD314'),
    o('o', '\uD315'),
    p('p', '\uD316'),
    q('q', '\uD317'),
    r('r', '\uD318'),
    s('s', '\uD319'),
    t('t', '\uD320'),
    u('u', '\uD321'),
    v('v', '\uD322'),
    w('w', '\uD323'),
    x('x', '\uD324'),
    y('y', '\uD325'),
    z('z', '\uD326'),
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
