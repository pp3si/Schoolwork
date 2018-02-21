import java.io.*;
import java.util.*;
public class Test {
    public static void main(String [] args) {
        ArrayList list = new ArrayList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        int k;
        for(k = 1; k <= 3; k++) {
            list.remove(1);
        }
        for(k=1; k <=3; k++) {
            list.add(1, new Integer(k));
        }
        for(k = 0; k < list.size(); k++) {
            System.out.print(list.get(k) + " ");
        }
    }
}