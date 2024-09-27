import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the content for file1.txt");
        String str1 = sc.nextLine();
        System.out.println("Enter the content for file2.txt");
        String str2 = sc.nextLine();
        try{
            //Creating 2 files in write mode
            BufferedWriter wf1 = new BufferedWriter(new FileWriter("file1.txt"));
            BufferedWriter wf2 = new BufferedWriter(new FileWriter("file2.txt"));
            //writing strings to that files
            wf1.write(str1);
            wf2.write(str2);
            wf1.close();
            wf2.close();
            //open the 2 files in reader mode
            BufferedReader rf1 = new BufferedReader(new FileReader("file1.txt"));
            BufferedReader rf2 = new BufferedReader(new FileReader("file2.txt"));
            //create new file to merge two files
            BufferedWriter wf3 = new BufferedWriter(new FileWriter("output.txt"));
            String tmp1, tmp2;
            //writing first file
            while((tmp1 = rf1.readLine()) != null)
                wf3.write(tmp1+"\n");
            //writing 2nd file
            while((tmp2 = rf2.readLine()) != null)
                wf3.write(tmp2);

            rf1.close();
            rf2.close();
            wf3.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}