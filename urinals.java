//Author - Swetha Ganapathy
import java.io.BufferedWriter;
import java.util.Scanner;

public class urinals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        if(goodString(String.valueOf(sc))) {
            System.out.println("Valid String");
            int count = maxNumOfFreeUrinals(String.valueOf(sc));
        }
    }

    public static Integer maxNumOfFreeUrinals(String str){
        int count =0;
        if(goodString(str)) {
            for (int i = 1; i < str.length() - 1; i++) {
                if (str.charAt(i - 1) == '0' && str.charAt(i) == '0' && str.charAt(i + 1) == '0') {
                    count++;
                }
            }
        }
        else {
            return -1;
        }
    return count;
    }

    public static Boolean goodString(String str)
    {
        // checks to see if valid string
        int len = str.length();
        for(int i=0; i<len; i++) {
            if (str.charAt(i) != '0' && str.charAt(i) != '1') {
                return false;
            }
            if(i < len-1 && str.charAt(i) == str.charAt(i+1) && str.charAt(i) == '1')
            {
                return false;
            }
        }
        return true;
    }
}

