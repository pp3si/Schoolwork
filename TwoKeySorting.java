import java.io.*; //necessary for File and IOException
import java.util.*; //necessary for StringTokenizer and Scanner
import java.text.*; //necessary for NumberFormat
public class TwoKeySorting {
    public static void main( String args[] ) throws IOException {
        NumberFormat fmt = NumberFormat.getNumberInstance( );
        fmt.setMinimumFractionDigits(3); //may need to change value
        fmt.setMaximumFractionDigits(3); //may need to change value
        
        Scanner sf = new Scanner(new File("H:\\School\\Sorting\\Names_ages.txt"));
        int maxIndx = -1; //-1 so when we increment below, the first index is 0
        String text[] = new String[50]; //To be safe, declare more than we need
        while(sf.hasNext( )) {
            maxIndx++;
            text[maxIndx] = sf.nextLine( );
            //System.out.println(text[maxIndx]); //Remove rem for testing
            //Stores each line as an element of a String array
        }
        //maxIndx is now the highest index of text[]. Equals -1 if no text lines
        sf.close( ); //We opened a file above, so close it when finished.
        //System.exit(0); //Use this for testing… to temporarily end the program here
        String[] names = new String[50];
        int[] ages = new int[50];
        int currentIndx = -1;
        for (int j = 0; j <= maxIndx; j++) {
            //Typically, only one of the following two will be used.
            //StringTokenizer st = new StringTokenizer( text[j] );
            //Scanner sc = new Scanner(text[j]);

            //…code specific to the task…

            //System.out.println(text[j]); //Remove rem for testing
            
            //Gonna rely on the assumed formatting here
            Scanner sc = new Scanner(text[j]);
            names[++currentIndx] = sc.next();
            ages[currentIndx] = sc.nextInt();
        }
    }
    public static void sort(String ary[]) { //ascending order Radix Sort
        int maxLength = 0;
        for(int i = 0; i < ary.length; i++) {
            if(ary[i].length() > maxLength) {
                maxLength = ary[i].length();
            }
        }
        
        //make the array into something sortable - pad with spaces/make uppercase?
        
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
            int indx = 0;
            for(int j = 0; j < chars.length; j++) {
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