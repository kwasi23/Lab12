import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;//imports the necessary classes for the program.

public class Lab12 {//declares the class

    public static void main(String[] args) {//begins the man method of the program
        // Create a file chooser dialog
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Select a text file to process");
        // Show the dialog and get the user's choice
        int result = chooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            // User chose a file, so let's process it
            File file = chooser.getSelectedFile();
            // Print the name of the file
            System.out.println("File: " + file.getName());
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {//creates a bufferedreader object to read the contents of the selected file, using a filereader object.
                String line;
                int numLines = 0;//the line int numLines = 0; initializes a variable numLines of type int and assigns it an initial value of 0.
                int numWords = 0;
                int numChars = 0;//declare variables to store the line count, word count and character count.
                // Read the file line by line and count lines, words, and characters
                while ((line = reader.readLine()) != null) {
                    numLines++;
                    numWords += line.split("\\s+").length;
                    numChars += line.length();
                }// reads the content of the slected file line by line and updates the line count and word and character count.
                // Print the summary report
                System.out.println("Number of lines: " + numLines);
                System.out.println("Number of words: " + numWords);
                System.out.println("Number of characters: " + numChars);//prints the line count, word count nd character count to the console.
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error reading file: " + e.getMessage());
            }//catches any IOException that masy be thrown while reading the selected file and display an error
        } else {//code runs if the user cancelled or closed the dialog. prints a message to console.
            // User cancelled or closed the dialog
            System.out.println("No file selected.");
        }//This line ends the definition of the Lab12 class
    }

}
