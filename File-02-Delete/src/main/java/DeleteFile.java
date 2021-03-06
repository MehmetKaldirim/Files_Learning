import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

public class DeleteFile {
    public DeleteFile() {
    }

    public static void main(String[] args) {


        DeleteFile d = new DeleteFile();
        d.deleteWithNio();
        d.deleteWithIOFile();
    }

    public void deleteWithNio() {
        {
            try {
                Files.deleteIfExists(
                        Paths.get("C:\\Users\\math\\IdeaProjects\\Learning_Files\\javaprogram.txt"));

            } catch (NoSuchFileException e) {
                System.out.println(
                        "No such file/directory exists");
            } catch (DirectoryNotEmptyException e) {
                System.out.println("Directory is not empty.");
            } catch (IOException e) {
                System.out.println("Invalid permissions.");
            }

            System.out.println("Deletion successful.");
        }
    }

    public void deleteWithIOFile(){
        {
            File file
                    = new File("Annotation.txt").getAbsoluteFile();

            if (file.delete()) {
                System.out.println("File deleted successfully");
            }
            else {
                System.out.println("Failed to delete the file");
            }
        }
    }
}
