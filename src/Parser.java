import java.util.List;

public class Parser {

    public static List<Token> listToken1;

    public static boolean parser(List<Token> listToken){
        listToken1 = listToken;

        if (!listToken1.isEmpty() && prisv() || !listToken.isEmpty() && print()){
            return true;
        }
        else return false;
    }

    private static boolean prisv(){
        int i = 0;
        if (perem(listToken1.get(i)) ){
            i++;
            if (ravno(listToken1.get(i)) && !listToken1.isEmpty()){
                i++;
                if (chislo(listToken1.get(i)) || perem(listToken1.get(i))&& !listToken1.isEmpty()){
                    i++;
                    while (i < listToken1.size()){
                        if (oper(listToken1.get(i))){
                            i++;
                            if (chislo(listToken1.get(i)) || perem(listToken1.get(i))&& !listToken1.isEmpty()){
                                i++;
                            }
                            else return false;
                        }
                        else return false;
                    }
                    return true;
                }
                else return false;
            }
            else return false;
        }
        else return false;
    }

    private static boolean oper(Token token) {
        if (token.getName() == "OP"){
            return true;
        }
        else return false;
    }

    private static boolean chislo(Token token) {
        if (token.getName() == "INTEGER"){
            return true;
        }
        else return false;
    }

    private static boolean print(){
        int i = 0;
        if (print(listToken1.get(i))){
            i++;
            if (perem(listToken1.get(i))){
                return true;
            }
            else return false;
        }
        else return false;
    }

    private static boolean print(Token token) {
        if (token.getName() == "PRINT"){
            return true;
        }
        else return false;
    }

    private static boolean perem(Token t){

        if (t.getName() == "VAR"){
            return true;
        }
        else return false;
    }

    private static boolean ravno(Token t){
        if (t.getName() == "ASSIGN"){
            return true;
        }
        else return false;
    }
}
