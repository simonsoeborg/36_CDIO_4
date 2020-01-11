package Entity;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.LineNumberReader;

//todo Formål at konstruere en klasse som kan læse fra flere filer... (researh lineoperator)

/**
 * Class that makes it posible to read from a file.
 * @author  Simon, David
 * @version 1.0
 */
public class ReadTextFiles {
    String textfile = "";
    String currentLine = "";
    int lineNumber = 0;


    /**
     * @param textfile    : The textfile you want to use.
     * @param currentLine : The currentline of the specific document.
     */
    public ReadTextFiles(String textfile, String currentLine) {
        this.textfile = textfile;
        this.currentLine = currentLine;
    }

    public String Read() throws FileNotFoundException {
        try {
            LineNumberReader reader = new LineNumberReader(new java.io.FileReader(textfile));
            currentLine = reader.readLine();
        } catch (IOException exception) {
            System.out.println("Fejl i filen");
        }
        return currentLine;
    }

    public void setLine(int line){
        lineNumber = line;
    }
}
