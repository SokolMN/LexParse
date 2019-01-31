import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    static String stroka;


    public static void main(String args[]) throws IOException {

        ArrayList<Token> tokens;

        BufferedReader reader = new BufferedReader(new FileReader(
                "C:/Program Files/my.txt"));

        while ((stroka = reader.readLine()) != null) {
            tokens = Lexer.lex(stroka);



            if( Parser.parser(tokens)){
                Exec.exec();

            }
            else
                System.out.println("ERROR");


        }

    }
}
