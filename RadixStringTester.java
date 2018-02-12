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
        int mask = 1; //Initially looks at the LSB.
        for(int i = 0; i < 31; i ++) {
            //Cycle through all 31 bits of the integers (but not the sign bit) starting with
            //the LSB.
            zeroes.clear();
            ones.clear();
            int zerosArrayCount = 0, onesArrayCount = 0;
            for(int j = 0; j < ary.length; j++) {
                //Cycle through each item in the array to be sorted
                int testBit = ary[j] & mask; //Apply mask to test a particular bit.
                if(testBit == 0) {
                    zeroes.add(ary[j]);
                    zerosArrayCount++;
                } else {
                    ones.add(ary[j]);
                    onesArrayCount++;
                }
            }

            //Copy latest progress back to the array. For descending sort, switch the
            //two loops below.
            int indx = 0;
            for(int j = 0; j < zerosArrayCount; j++)
            ary[indx++] = zeroes.get(j);
            for(int j = 0; j < onesArrayCount; j++)
            ary[indx++] = ones.get(j);
            mask *= 2; //Advance the mask to the next bit
        }
    }
}