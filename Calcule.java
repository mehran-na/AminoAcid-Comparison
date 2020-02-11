import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Calcule{
    //fields :
    private String acidesA;
    private String acidesB;

    private  ArrayList<String> s;
    private  ArrayList<String> t;

    public Calcule(String acidesA, String acidesB) {
        this.acidesA = acidesA;
        this.acidesB = acidesB;
    }

    public void AjouterDansArrayList(){
        String [] arrAcidesA = acidesA.split("\\s");
        String [] arrAcidesB = acidesB.split("\\s");

        this.s = new ArrayList<>(Arrays.asList(arrAcidesA));
        this.t = new ArrayList<>(Arrays.asList(arrAcidesB));
    }


}
