import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello, and Welcome to Lockers pvt.");
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        char user_option = '0';
        FileNames fileNames = new FileNames();
        //File[] files = new File("/Users/abdulrahmanalamar/Desktop/Files_Project1").listFiles(); //If this pathname does not denote a directory, then listFiles() returns null.
        File[] files = new File("./Files_Project1").listFiles();
        for (File file : files) { // advanced for loop to read the file names and store them in an array list
            if (file.isFile() && !file.isHidden()){
                fileNames.getResults().add(file.getName());
            }
        }
        do {
            fileNames.Menu();
            user_option = myObj.next().charAt(0);
            if(user_option!='0' && user_option!='1' && user_option!='2' && user_option!='#'){
                System.out.println("Incorrect choice!\nKindly choose one of the Three options below:\n1- Retrieving the file names in ascending order\n2-Business level operation\n0 to close and quit the application");
            }
            myObj.nextLine(); // to empty the buffer.
            if (user_option == '1') { //show files in ascending order
                fileNames.sort();
                fileNames.getResults().forEach(System.out::println); //maybe make this a for loop to display the objects content
                System.out.println("\nFiles shown in ascending order!");
                System.out.println("Enter # to go back to the available options");
            }else if (user_option == '2') {
                System.out.println("Choose one of the Business-level operations\n1-add file to application\n2- delete a user from the application\n3- search a file from the application\n4- go back to original menu\n0 to close and quit the application");
                do {
                    fileNames.Menu2();
                    user_option = myObj.next().charAt(0);
                    myObj.nextLine(); // to empty the buffer.
                    if(user_option!='1' && user_option!='2' && user_option!='3' && user_option!='4' && user_option=='#'){
                        System.out.println("Incorrect choice!\nChoose one of the Business-level operations\n1-add file to application\n2- delete a user from the application\n3- search a file from the application\n4- go back to original menu");
                    }
                    if (user_option == '1') { //create a new file
                        System.out.print("Enter file name:  ");
                        String UserFileName = myObj.nextLine();
                        fileNames.createFile(UserFileName); //use one time and throw, without creating an object
                    } else if (user_option == '2') { //delete a user file
                        System.out.println("Enter file name you wish to delete");
                        String UserFileName2 = myObj.nextLine();
                        fileNames.deleteFile(UserFileName2); //use class one time and throw without creating an object
                    } else if (user_option == '3') { // search file
                        System.out.println("Enter File name to check if it exists");
                        String UserFileName3 = myObj.nextLine();
                        fileNames.searchFile(UserFileName3); //use one time and throw, without creating an object
                    } else if (user_option == '4') {
                        fileNames.Menu();
                        break;
                    }
                    fileNames.Menu2();

                }while(user_option!='0');
            } else if (user_option=='#') {
                fileNames.Menu();

            }
        } while (user_option != '0');
        System.out.println("Thanks for using the application, Good Bye =)");
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
    void searchFile(String UserFileName3) {
        boolean exists = false;
        for (String result : results) {
            if (Objects.equals(result, UserFileName3)) {
                exists = true;
            }
        }
        if(exists){
            System.out.println("File exists in application =)");
        }
        else{
            System.out.println("File doesn't exist =(");
        }
        System.out.println("Enter # to go back to the available options or 0 to quit");
    }
    void deleteFile(String UserFileName2) {
        if(results.contains(UserFileName2)) {
            String NameWithExtension = "/Users/abdulrahmanalamar/Desktop/Files_Project1/" + UserFileName2;
            File NameWithExtension2 = new File(NameWithExtension); //create an object of type File to delete it
            NameWithExtension2.delete();
            results.remove(UserFileName2);
            System.out.println("File deleted");
        }
        else{
            System.out.println("file doesn't exist");
        }
        System.out.println("Enter # to go back to the available options or 0 to quit");
    }
    void createFile(String UserFileName) throws IOException {
        //System.out.println(results.contains(UserFileName));
        if(results.contains(UserFileName)){
            System.out.println("File already exists in the application");
        }
        else{
            String NameWithExtension = "/Users/abdulrahmanalamar/Desktop/Files_Project1/" + UserFileName;
            File file2 = new File(NameWithExtension);
            file2.createNewFile();
            results.add(UserFileName);
            //fileNames.getResults().add(UserFileName);
            System.out.println("File " + UserFileName + " Created!");
        }
        System.out.println("Enter # to go back to the available options  or 0 to quit");
    }
    void sort(){
        //results.sort((o1, o2) -> o1.compareTo(o2));
        results.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
    }
    void Menu(){
        System.out.println("\n\n\n\nKindly choose one of the Three options below:\n1- Retrieving the file names in ascending order\n2-Business level operation\n0 to close and quit the application");
    }
    void Menu2(){
        System.out.println("\n\n\n\nChoose one of the Business-level operations\n1-add file to application\n2- delete a user from the application\n3- search a file from the application\n4- go back to original menu");
    }
}