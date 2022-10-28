//Author - Swetha Ganapathy
import java.io.*;
import java.util.Scanner;

public class urinals {
    public static void main(String[] args) throws Exception {
        //get input choice from user - 1.keyboard input 2.File input
        String choice = getChoice();
        if (validateChoice(choice)) {
            if (choice.equals("1")) {
                System.out.println("Enter the string");
                Scanner strSc = new Scanner(System.in);
                String str = strSc.nextLine();
                int count = findMaxNumOfFreeUrinals(String.valueOf(str));
                System.out.println("Number of free urinals :");
                System.out.println(count);
            } else if (choice.equals("2")) {
                readFileAndFindMaxNumOfFreeUrinals();
            }
        }
    }

    public static String getChoice() {
        System.out.println("Enter your choice : ");
        System.out.println("1.Keyboard Input 2.File Input");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static Boolean validateChoice(String choice) {
        return choice.equals("1") || choice.equals("2");
    }

    public static void readFileAndFindMaxNumOfFreeUrinals() throws Exception {
        String fileName = "urinal.dat";
        BufferedReader inputFile = readFile(fileName);
        String str;
        String outputFile = getOutputFile();
        while ((str = inputFile.readLine()) != null && !str.equals("-1")) {
            int count = findMaxNumOfFreeUrinals(str);
            writeIntoFile(outputFile, count);
        }
    }

    public static BufferedReader readFile(String fileName) throws IOException {
        try {
            FileReader fr = new FileReader(fileName);
            return new BufferedReader(fr);
        } catch (Exception e) {
            return null;
        }
    }

    public static String getOutputFile() throws Exception {
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

    public static Integer findMaxNumOfFreeUrinals(String str) {
        int count;
        if (goodString(str)) {
            count = maxNumOfFreeUrinals(str);
        } else {
            count = -1;
        }
        return count;
    }

    public static void writeIntoFile(String outputFile, Integer count) throws Exception {
        BufferedWriter outputFileBW = writeFile(outputFile);
        outputFileBW.write(String.valueOf(count));
        outputFileBW.newLine();
        outputFileBW.close();
    }

    public static BufferedWriter writeFile(String fileName) throws IOException
    {
    try
        {
            FileWriter fw = new FileWriter(fileName, true);
            return new BufferedWriter(fw);
        }
        catch(Exception e)
        {
            return null;
        }
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

