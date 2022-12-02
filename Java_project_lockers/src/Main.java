import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //ArrayList<String> results = new ArrayList<String>();
        System.out.println("Hello, and Welcome to Lockers pvt. My name is Abdulrahman Alamar,");
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        char user_option = '0';
        FileNames fileNames = new FileNames();
        //File[] files = new File("/Users/abdulrahmanalamar/Desktop/Files_Project1").listFiles(); //If this pathname does not denote a directory, then listFiles() returns null.
        File[] files = new File("./Files_Project1").listFiles();
        for (File file : files) { // advanced for loop to read the file names and store them in an array list
            if (file.isFile() && !file.isHidden()) {
                fileNames.getResults().add(file.getName());
            }
        }
    }
}

class FileNames{
    private ArrayList<String> results;
    public FileNames() {
        this.results = new ArrayList<>();
    }
    public ArrayList<String> getResults() {
        return results;
    }
    public void setResults(ArrayList<String> results) {
        this.results = results;
    }

}

