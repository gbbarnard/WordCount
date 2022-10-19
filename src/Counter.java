import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Counter { 

    public static void writeArrayToFile(int[] array, String fileName) throws Exception {
        try {
            FileWriter filewriter = new FileWriter(fileName);
            for (int a : array) {
                filewriter.write(a + " ");
            }
            filewriter.close();
        } catch (IOException e) {
            System.out.println("Encounter an IOException");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException{
       FileInputStream file = new FileInputStream("src//words.txt");
       Scanner fileInput = new Scanner(file);

       ArrayList<String> words = new ArrayList<String>();
       ArrayList<Integer> count = new ArrayList<Integer>();

       while (fileInput.hasNext()){
        String nextWord = fileInput.next();
        if(words.contains(nextWord)){
            int index = words.indexOf(nextWord);
            count.set(index, count.get(index) +1);
        } else{
            words.add(nextWord);
            count.add(1);
        }
       }
       fileInput.close();
       file.close();

       FileOutputStream fileStream = null;
       PrintWriter Output = null;
  
       fileStream = new FileOutputStream("src//output.txt");
       Output = new PrintWriter(fileStream);
  
      for(int i = 0; i < words.size(); i++){
    Output.println(words.get(i));
       Output.println(count.get(i));
    }
    Output.close();
    
    }
}


