import java.util.ArrayList;
import java.util.HashSet;
// import java.util.Comparator;

public class MaxElementFromVector {
    public static void main(String[] args) {
        ArrayList<Integer> a1 = new ArrayList<Integer>();



        a1.add(68);
        a1.add(61);
        a1.add(48);
        a1.add(93);
        a1.add(73);

        

        ArrayList<Integer> a2 = new ArrayList<Integer>();

        a2.add(68);
        a2.add(61);
        
        a1.retainAll(a2);
        System.out.println(a1);


        // System.out.println(v);
        // int max= v.get(0);

        // for(Integer I : a1){
        //     if(a2.contains(a1) > max){
        //         max = I;
        //     } 
        // }

        // System.out.println(max);

    }
}
