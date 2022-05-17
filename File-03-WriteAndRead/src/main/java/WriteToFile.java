import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WriteToFile {
    public static void main(String[] args) {
        WriteToFile wf = new WriteToFile();
        //wf.writeToFile("Third line");
        // System.out.println(wf.readLineFromFile(0));
        wf.readFromFile().stream().forEach(System.out::println);
    }

    public void writeToFile(String text) {
        try {
            FileWriter myWriter = new FileWriter("Annotation.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(myWriter);
            bufferedWriter.write(text);
            bufferedWriter.newLine();
            bufferedWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public String readLineFromFile(int lineNum) {
        String line = "nothing to read";
        try {
            line = Files.readAllLines(Paths.get("Annotation.txt")).get(lineNum);
            System.out.println("Successfully read from the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return line;
    }

    //read all files from File world by world
    public List<String> readFromFile() {
        List<String> words = new ArrayList<>();
        String pathLink = "Annotation.txt";

        try {
            Scanner input = new Scanner(new File(pathLink));
            while (input.hasNext()) {
                String word = input.next();
                words.add(word);
            }
            System.out.println("Successfully read from the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return words;
    }
}