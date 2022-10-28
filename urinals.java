//Author - Swetha Ganapathy
import java.io.BufferedWriter;
import java.util.Arrays;
import java.util.Scanner;

public class urinals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a new string");
        String str = String.valueOf(sc.nextLine());
        if(goodString(str)) {
            System.out.println("Valid String");
            int count = maxNumOfFreeUrinals(str);
            System.out.println("Number of free urinals :" + count);
        }
        else {
            System.out.println("Invalid String");
        }
    }

    public static Integer maxNumOfFreeUrinals(String str){
        int count =0;
        if(goodString(str)) {
            char[] strArray = str.toCharArray();
            for (int i = 0; i < str.length() - 1; i++) {
                if(i==0)
                {
                    if(strArray[i] == '0' && strArray[i+1] == '0')
                    {
                        count++;
                    }
                }
                else if(i == str.length()-1)
                {
                    if(strArray[i] == '0' && strArray[i-1] == '0')
                    {
                        count++;
                    }
                }
                else if (strArray[i - 1] == '0' && strArray[i] == '0' && strArray[i + 1] == '0') {
                    count++;
                    strArray[i] = '1';
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
        char[] strArray = str.toCharArray();
        for(int i=0; i<len; i++) {
            if (strArray[i] != '0' && strArray[i] != '1') {
                return false;
            }
            if(i < len-1 && strArray[i] == strArray[i+1] && strArray[i] == '1')
            {
                return false;
            }
        }
        return true;
    }
}

