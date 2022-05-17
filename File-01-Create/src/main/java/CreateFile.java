import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class CreateFile {
    public CreateFile() {
    }

    public static void main(String[] args) {
        CreateFile createFile = new CreateFile();
        createFile.createIoFile();
        System.out.println("Second file with FileOutputStream Classes");
        //createFile.fileOutputStream();
        System.out.println("Third File with java.nio.file.Files package");
        createFile.javaNioFileCreateMethod();

    }

    public void createIoFile() {
        ///Users/math/IdeaProjects/Learning_Files/Annotation.txt when we create file with getAbsoluteFile
        File file = new File("Annotation.txt").getAbsoluteFile(); //initialize File object and passing path as argument
        boolean result;
        try {
            result = file.createNewFile();  //creates a new file
            if (result)      // test if successfully created a new file
            {
                System.out.println("new file created " + file.getCanonicalPath()); //returns the path string
            } else {
                System.out.println("File already exist at location: " + file.getCanonicalPath());
            }
        } catch (IOException e) {
            e.printStackTrace();    //prints exception if any
        }

    }

    public void fileOutputStream() {
        try {
            Scanner sc = new Scanner(System.in);         //object of Scanner class
            System.out.print("Enter the file name: ");
            String name = sc.nextLine();              //variable name to store the file name
            FileOutputStream fos = new FileOutputStream(name, true);  // true for append mode
            System.out.print("Enter file content: ");
            String str = sc.nextLine() + "\n";      //str stores the string which we have entered
            byte[] b = str.getBytes();       //converts string into bytes
            fos.write(b);           //writes bytes into file
            fos.close();            //close the file
            System.out.println("file saved.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void javaNioFileCreateMethod(){
        Path path = Paths.get("C:\\Users\\math\\IdeaProjects\\Learning_Files\\javaprogram.txt"); //creates Path instance
        try
        {
            Path p= Files.createFile(path);     //creates file at specified location
            System.out.println("File Created at Path: "+ p);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

/*
IOFILE Method
canRead()	Boolean	Tests whether the file is readable or not
canWrite()	Boolean	Tests whether the file is writable or not
createNewFile()	Boolean	Creates an empty file
delete()	Boolean	Deletes a file
exists()	Boolean	Tests whether the file exists
getName()	String	Returns the name of the file
getAbsolutePath()	String	Returns the absolute pathname of the file
length()	Long	Returns the size of the file in bytes
list()	String[]	Returns an array of the files in the directory
mkdir()	Boolean	Creates a directory*/



