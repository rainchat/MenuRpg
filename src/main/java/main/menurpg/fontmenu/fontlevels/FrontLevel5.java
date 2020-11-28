package main.menurpg.fontmenu.fontlevels;

@SuppressWarnings("NonAsciiCharacters")
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
    a('a', '\uD401'),
    b('b', '\uD402'),
    c('c', '\uD403'),
    d('d', '\uD404'),
    e('e', '\uD405'),
    f('f', '\uD406'),
    g('g', '\uD407'),
    h('h', '\uD408'),
    i('i', '\uD409'),
    j('j', '\uD410'),
    k('k', '\uD411'),
    l('l', '\uD412'),
    m('m', '\uD413'),
    n('n', '\uD414'),
    o('o', '\uD415'),
    p('p', '\uD416'),
    q('q', '\uD417'),
    r('r', '\uD418'),
    s('s', '\uD419'),
    t('t', '\uD420'),
    u('u', '\uD421'),
    v('v', '\uD422'),
    w('w', '\uD423'),
    x('x', '\uD424'),
    y('y', '\uD425'),
    z('z', '\uD426'),
    DEFAULT('z', '\uE400');


    private final char character;
    private final char font;

    FrontLevel5(char character, char font) {
        this.character = character;
        this.font = font;
    }

    public static FrontLevel5 getDefaultFontInfo(char c) {
        for (FrontLevel5 dFI : FrontLevel5.values()) {
            if (dFI.getCharacter() == c) return dFI;
        }
        return FrontLevel5.DEFAULT;
    }

    public char getfont() {
        return this.font;
    }

    public char getCharacter() {
        return this.character;
    }


}
