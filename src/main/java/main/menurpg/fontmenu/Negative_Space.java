package main.menurpg.fontmenu;

public class Negative_Space {

    /*
\uF801 to \uF808: -1 to -8 pixels
\uF809 to \uF80F: -16, -32, -64, -128, -256, -512 and -1024 pixels

\uF821 to \uF828: 1 to 8 pixels
\uF829 to \uF82F: 16, 32, 64, 128, 256, 512 and 1024 pixels

\uF800 and \uF820: -max and max, maximally negative and positive
     */

    static public String getSpase(int light){
        char x = '1';
        StringBuilder space = new StringBuilder();

        while (light != 0){
            if (light >= 1024){
                light-=1024;
                x = '\uF80F';
                space.append(x);
            }
            else if (light >= 256){
                light-=256;
                x = '\uF80D';
                space.append(x);
            }
            else if (light >= 64){
                light-=64;
                x = '\uF80B';
                space.append(x);
            }
            else if (light >= 16){
                light-=16;
                x = '\uF809';
                space.append(x);
            }
            else if (light >= 4){
                light-=4;
                x = '\uF804';
                space.append(x);
            }
            else if (light >= 1){
                light-=1;
                x = '\uF801';
                space.append(x);
            }


        }


        return space.toString();
    }
}
