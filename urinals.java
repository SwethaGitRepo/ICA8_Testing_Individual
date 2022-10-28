//Author - Swetha Ganapathy
import java.io.*;
import java.util.Scanner;

public class urinals {
    public static void main(String[] args) throws Exception {
        System.out.println("Enter your choice : 1.Keyboard Input 2.File Input");
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        if(choice.equals("1"))
        {
            System.out.println("Enter the string");
            Scanner strSc = new Scanner(System.in);
            String str = strSc.nextLine();
            int count = findMaxNumOfFreeUrinals(String.valueOf(str));
            System.out.println("Number of free urinals : "+count);
        }
        else if(choice.equals("2"))
        {
            readFileAndFindMaxNumOfFreeUrinals();
        }
    }

    public static void readFileAndFindMaxNumOfFreeUrinals() throws Exception {
        BufferedReader inputFile;
        inputFile = new BufferedReader(new FileReader("urinal.dat"));
        String str;
        String outputFile = getOutputFile();
        while ((str = inputFile.readLine()) != null && !str.equals("-1"))
        {
            int count = findMaxNumOfFreeUrinals(str);
            writeIntoFile(outputFile, count);
        }
    }

    public static String getOutputFile() throws Exception{
            File counterFile = new File("counter.txt");
            Scanner ctr = new Scanner(counterFile);
            int counter = Integer.parseInt(ctr.nextLine());
            String outputFile = "rule.txt";
            if (counter != 0) {
                outputFile = "rule" + counter + ".txt";
            }
            incrementCounter(counter);
            System.out.println("Successfully written output to " + outputFile);
            return outputFile;
    }
    public static Integer findMaxNumOfFreeUrinals(String str)
    {
        int count = 0;
        if(goodString(str)) {
            count = maxNumOfFreeUrinals(str);
            System.out.println("Number of free urinals :" + count);
        }
        else
        {
            count = -1;
        }
        return count;
    }
    public static void writeIntoFile(String outputFile,Integer count) throws Exception
    {
        BufferedWriter outputFileBW = new BufferedWriter(new FileWriter(outputFile,true));
        outputFileBW.write(String.valueOf(count));
        outputFileBW.newLine();
        outputFileBW.close();
    }

    public static void incrementCounter(int counter) throws Exception
    {
        FileWriter counterFile = new FileWriter("counter.txt");
        counterFile.write(Integer.toString(counter + 1));
        counterFile.close();
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

