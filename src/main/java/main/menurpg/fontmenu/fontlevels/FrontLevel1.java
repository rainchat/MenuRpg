package main.menurpg.fontmenu.fontlevels;

public enum FrontLevel1 {
    а('а', '\uEf01'),
    б('б', '\uEf02'),
    в('в', '\uEf03'),
    г('г', '\uEf04'),
    д('д', '\uEf05'),
    е('е', '\uEf06'),
    ж('ж', '\uEf07'),
    з('з', '\uEf08'),
    и('и', '\uEf09'),
    й('й', '\uEf10'),
    к('к', '\uEf11'),
    л('л', '\uEf12'),
    м('м', '\uEf13'),
    н('н', '\uEf14'),
    о('о', '\uEf15'),
    п('п', '\uEf16'),
    р('р', '\uEf17'),
    с('с', '\uEf18'),
    т('т', '\uEf19'),
    у('у', '\uEf20'),
    ф('ф', '\uEf21'),
    х('х', '\uEf22'),
    ц('ц', '\uEf23'),
    ч('ч', '\uEf24'),
    ш('ш', '\uEf25'),
    щ('щ', '\uEf26'),
    ъ('ъ', '\uEf27'),
    ы('ы', '\uEf28'),
    ь('ь', '\uEf29'),
    э('э', '\uEf30'),
    ю('ю', '\uEf31'),
    я('я', '\uEf32'),
    DEFAULT('z', '\uEf00');


    private char character;
    private char font;

    FrontLevel1(char character, char font) {
        this.character = character;
        this.font = font;
    }

    public char getfont() {
        return this.font;
    }

    public char getCharacter() {
        return this.character;
    }


    public static FrontLevel1 getDefaultFontInfo(char c) {
        for (FrontLevel1 dFI : FrontLevel1.values()) {
            if (dFI.getCharacter() == c) return dFI;
        }
        return FrontLevel1.DEFAULT;
    }



}