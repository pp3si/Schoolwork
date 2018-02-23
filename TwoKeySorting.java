import java.io.*; //necessary for File and IOException
import java.util.*; //necessary for StringTokenizer and Scanner
import java.text.*; //necessary for NumberFormat
public class TwoKeySorting {
    public static void main( String args[] ) throws IOException {
        Scanner sf = new Scanner(new File("H:\\School\\Sorting\\Names_ages.txt"));
        int maxIndx = -1; //-1 so when we increment below, the first index is 0
        ArrayList<String> textList = new ArrayList<String>(); //To be safe, declare more than we need
        while(sf.hasNext( )) {
            maxIndx++;
            textList.add(sf.nextLine());
            //System.out.println(text[maxIndx]); //Remove rem for testing
            //Stores each line as an element of a String array
        }
        String[] text = new String[textList.size()];
        for(int i = 0; i < text.length; i++) {
            text[i] = textList.get(i);
        }
        //maxIndx is now the highest index of text[]. Equals -1 if no text lines
        sf.close( ); //We opened a file above, so close it when finished.
        //System.exit(0); //Use this for testing… to temporarily end the program here
        String[] names = new String[text.length];
        int[] ages = new int[names.length];
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
        sort(text, names, ages);
        currentIndx = -1;
        for (int j = 0; j <= maxIndx; j++) {
            Scanner sc = new Scanner(text[j]);
            currentIndx++;
            names[currentIndx] = sc.next();
            ages[currentIndx] = sc.nextInt();
        }
        for(int i = 0; i < names.length; i++) {
            System.out.println(names[i] + ", " + ages[i]);
        }
    }
    public static void sort(String[] a, String[] comp1, int[] comp2) { //This will do an ascending sort
        //I will make use of the fact that this String array is all "Name age" thank you very much.
        String min;
        int minIndex;
        for(int i = 0; i < a.length; i++) {
            min = a[i];
            minIndex = i;
            for(int j = i+1; j < a.length; j++) {//find minimum
                
                /*if(a[j].compareTo(min) < 0) {//salient feature
                    min = a[j];
                    minIndex = j;
                }*/
                if(compare(comp1[j], comp2[j], comp1[minIndex], comp2[minIndex]) < 0) {//salient feature
                    min = a[j];
                    minIndex = j;
                }
            }
            a[minIndex] = a[i];
            a[i] = min;
        }
    }
    public static int compare(String name1, int age1, String name2, int age2) {
        if(name1.compareTo(name2) < 0) {
            return -1;
        } else if(name1.compareTo(name2) > 0) {
            return 1;
        } else {
            if(age1 < age2)
            return -1;
            else if(age1 > age2)
            return 1;
            return 0;
        }
    }
}