import java.io.*;
import java.util.ArrayList;

//import static jdk.internal. net.http.common.Utils.close;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        try{
            BufferedReader reader = new BufferedReader(new  FileReader("file1.txt"));
            String str;
            ArrayList<String> arr = new ArrayList<>();

            // Reading the line and adding to an arraylist to copy it to a new file
            while((str = reader.readLine()) != null){
                arr.add(str);
                System.out.println(str);
            }
            reader.close();

            //Creating a new file using BufferedWriter (**FileReader/FileWriter returns in integer)
            BufferedWriter writer = new BufferedWriter(new FileWriter("file2.txt"));
            for (String line: arr){
                writer.write(line+"\n");
            }
            writer.close();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}