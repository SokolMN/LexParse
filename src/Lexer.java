import java.util.ArrayList;
import java.util.regex.Pattern;

public class Lexer {


    public static  ArrayList<Token>  lex(String stroka) {


        ArrayList<Token> tokenlist = new ArrayList<Token>();
        Token temp = null;
        String NewStr = "";
        int i=0;
        boolean book;
        boolean chislo;
        boolean ravno;
        boolean op;
        boolean print;
        boolean lexerror = true;


        while (stroka.length() != 0) {
            chislo = Pattern.matches("[1-9]{1}[0-9]*.*", stroka);
            book = Pattern.matches("^[A-Za-z].*", stroka);
            ravno = Pattern.matches("^={1}.*", stroka);
            op = Pattern.matches("^[+-/*]{1}.*", stroka);
            print = Pattern.matches("^print{1}.*", stroka);
            System.out.println(stroka);

            if (ravno || book || op || print) {
                if (ravno) {
                    NewStr = stroka.substring(0, 1);
                    temp = new Token("ASSIGN", NewStr);

                }
                if (book) {
                    NewStr = stroka.substring(0, 1);
                    temp = new Token("VAR", NewStr);
                }
                if (op) {
                    NewStr = stroka.substring(0, 1);
                    temp = new Token("OP", NewStr);
                }
                if (print) {
                    NewStr = stroka.substring(0,5);
                    temp = new Token("PRINT", NewStr );
                    stroka = stroka.substring(NewStr.length()-1);
                }
                NewStr = "";
                stroka = stroka.substring(1);
            } else if (chislo) {

                while (chislo) {

                    NewStr = NewStr + stroka.substring(0, 1);
                    stroka = stroka.substring(1);
                    chislo = Pattern.matches("[0-9]{1}[0-9]*.*", stroka);

                }
                temp = new Token("INTEGER", NewStr);
                NewStr = "";
            } else {
                System.out.println("LEXER ERROR");
                temp = null;
                tokenlist.clear();
                stroka = "";
                lexerror = false;
            }
            i = i +1 ;

            if(temp != null)
                tokenlist.add(temp);
        }

        return tokenlist;
    }


}
