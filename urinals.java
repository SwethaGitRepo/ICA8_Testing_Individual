//Author - Swetha Ganapathy
import java.util.Scanner;

public class urinals {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        if(goodString(String.valueOf(sc))) {
            System.out.println("Valid String");
        }
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

