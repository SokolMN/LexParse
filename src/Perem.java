public class Perem {
    private String name;
    private int value;

    public Perem(String name, int value){
        this.name = name;
        this.value = value;
    }

    public String getName(){
        return this.name;
    }

    public int getValue(){
        return this.value;
    }

    public void setValue(int value){
        this.value = value;
    }

    public void setName(String name){
        this.name = name;
    }
}
