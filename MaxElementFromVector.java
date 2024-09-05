import java.util.Vector;
// import java.util.Collections;

public class MaxElementFromVector {
    public static void main(String[] args) {
        Vector<Integer> v = new Vector<Integer>();

        v.add(68);
        v.add(61);
        v.add(48);
        v.add(93);
        v.add(73);

        System.out.println(v);
        int max= v.get(0);

        for(Integer I : v){
            if(I > max){
                max = I;
            } 
        }

        System.out.println(max);

    }
}
