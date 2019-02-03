import java.util.HashSet;

public class Exec{

    private static HashSet<Perem> hashPerem = new HashSet<Perem>(); //Тут хранятся переменные и их значения (A=7, B=11 ..) поэтому переменная статичная, чтобы хранила значения на протяжении всего жизенного цикла программы

    public static void exec(){
        if (Parser.listToken1.get(0).getName() == "VAR"){
            boolean f = false;
            Perem per = new Perem("tmp", 0);
            for (Perem p : hashPerem){
                if (p.getName().equals(Parser.listToken1.get(0).getValue())){
                    f = true;
                    per = p;
                    break;
                }
            }
            if (Parser.listToken1.get(2).getName() == "VAR"){
                for (Perem p : hashPerem){
                    if (p.getName().equals(Parser.listToken1.get(2).getValue())){
                        per.setValue(p.getValue());
                        break;
                    }
                }
            }
            else{
                per.setValue(Integer.parseInt(Parser.listToken1.get(2).getValue()));
            }
            int i = 3;
            while(i < Parser.listToken1.size()){
                if (Parser.listToken1.get(i).getValue().equals("*")){
                    per.setValue(mul(per, Parser.listToken1.get(i+1)));
                }
                if (Parser.listToken1.get(i).getValue().equals("/")){
                    per.setValue(div(per, Parser.listToken1.get(i+1)));
                }
                if (Parser.listToken1.get(i).getValue().equals("+")){
                    per.setValue(plus(per, Parser.listToken1.get(i+1)));
                }
                if (Parser.listToken1.get(i).getValue().equals("-")){
                    per.setValue(minus(per, Parser.listToken1.get(i+1)));
                }
                i++;
            }
            if (f == false){
                per.setName(Parser.listToken1.get(0).getValue());
                hashPerem.add(per);
            }
            else{
                for (Perem p : hashPerem){
                    if (p.getName().equals(Parser.listToken1.get(0).getValue())){
                        p = per;
                        break;
                    }
                }
            }
        }
        else{
            for (Perem p : hashPerem){
                if (p.getName().equals(Parser.listToken1.get(1).getValue())){
                    System.out.println(p.getName() + " = " + p.getValue());
                }
            }
        }
    }


    //Арифметические операции. В каждой из них идет сначала поиск перменных, если на вход подается переменная типа VAR. Если переменная не типа VAR, то идет простая рафиметическая операция с соседними числами

    private static int mul(Perem per, Token token) {
        if (token.getName() == "VAR"){
            for (Perem p : hashPerem){
                if (p.getName().equals(token.getValue())){
                    return per.getValue()*p.getValue();
                }
            }
        }
        else{
            return per.getValue() * Integer.parseInt(token.getValue());
        }
        return 0;
    }
    private static int div(Perem per, Token token) {
        if (token.getName() == "VAR"){
            for (Perem p : hashPerem){
                if (p.getName().equals(token.getValue())){
                    return per.getValue()/p.getValue();
                }
            }
        }
        else{
            return per.getValue()  / Integer.parseInt(token.getValue());
        }
        return 0;
    }
    private static int minus(Perem per, Token token) {
        if (token.getName() == "VAR"){
            for (Perem p : hashPerem){
                if (p.getName().equals(token.getValue())){
                    return per.getValue() - p.getValue();
                }
            }
        }
        else{
            return per.getValue() - Integer.parseInt(token.getValue());
        }
        return 0;
    }
    private static int plus(Perem per, Token token) {
        if (token.getName() == "VAR"){
            for (Perem p : hashPerem){
                if (p.getName().equals(token.getValue())){
                    return per.getValue() + p.getValue();
                }
            }
        }
        else{
            return per.getValue() + Integer.parseInt(token.getValue());
        }
        return 0;
    }
}
