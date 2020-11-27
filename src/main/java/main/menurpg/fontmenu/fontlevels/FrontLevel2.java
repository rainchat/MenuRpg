package main.menurpg.fontmenu.fontlevels;

import java.util.Optional;

@SuppressWarnings("NonAsciiCharacters")
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
    a('a', '\uD101'),
    b('b', '\uD102'),
    c('c', '\uD103'),
    d('d', '\uD104'),
    e('e', '\uD105'),
    f('f', '\uD106'),
    g('g', '\uD107'),
    h('h', '\uD108'),
    i('i', '\uD109'),
    j('j', '\uD110'),
    k('k', '\uD111'),
    l('l', '\uD112'),
    m('m', '\uD113'),
    n('n', '\uD114'),
    o('o', '\uD115'),
    p('p', '\uD116'),
    q('q', '\uD117'),
    r('r', '\uD118'),
    s('s', '\uD119'),
    t('t', '\uD120'),
    u('u', '\uD121'),
    v('v', '\uD122'),
    w('w', '\uD123'),
    x('x', '\uD124'),
    y('y', '\uD125'),
    z('z', '\uD126'),
    DEFAULT('z', '\uE100');


    private final char character;
    private final char font;

    FrontLevel2(char character, char font) {
        this.character = character;
        this.font = font;
    }

    public static FrontLevel2 getDefaultFontInfo(char c) {
        for (FrontLevel2 dFI : FrontLevel2.values()) {
            if (dFI.getCharacter() == c) return dFI;
        }
        return FrontLevel2.DEFAULT;
    }

    public char getfont() {
        return this.font;
    }

    public char getCharacter() {
        return this.character;
    }


}