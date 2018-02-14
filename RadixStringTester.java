import java.util.*;
public class RadixStringTester {
    public static void main(String args[]) {
        String theArray[] = {"DELL","HELP","ALSO","BEAR","BACK","IPAD","IPOD","AGRO"};
        sort(theArray);
        for(int j = 0; j < theArray.length; j++) {
            System.out.print(theArray[j] + " ");
        }
        System.out.println(" ");
    }
    public static void sort(String ary[]) { //ascending order Radix Sort
        ArrayList<String>[] chars = (ArrayList<String>[])new ArrayList[26];
        for(int i = 0; i < chars.length; i++) {
            chars[i] = new ArrayList<String>();
        }
        int mask = 3; //Initially looks at the LSB.
        for(int i = 0; i < 4; i ++) {
            //Cycle through all 4 letters of the Strings starting with
            //the last.
            for(int k = 0; k < chars.length; k++) {
                System.out.println(k);
                chars[k].clear();
            }
            int zerosArrayCount = 0, onesArrayCount = 0;
            for(int j = 0; j < ary.length; j++) {
                //Cycle through each item in the array to be sorted
                char test = ary[j].charAt(mask); //Apply mask to test a particular character.
                chars[test-65].add(ary[j]);
            }

            //Copy latest progress back to the array. For descending sort, switch the
            //two loops below.
            int indx = 0;
            for(int j = chars.length - 1; j >= 0; j--) {
                for(int k = 0; k < chars[j].size(); k++) {
                    ary[indx++] = chars[j].get(k);
                }
            }
            /*for(int j = 0; j < zerosArrayCount; j++)
            ary[indx++] = zeroes.get(j);
            for(int j = 0; j < onesArrayCount; j++)
            ary[indx++] = ones.get(j);*/
            mask--; //Advance the mask to the next bit
        }
    }
}