package Entity;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReader {

    private String file1, file2, file3;

    /**
     * @param file1 : First file to read from
     * @param file2 : Second file to read from
     * @param file3 : Third file to read from
     */
    public FileReader(String file1, String file2, String file3){
    //hvis vi vil have flere filer så skal vi tilføje flere parametre til konstruktøren
        this.file1 = file1;
        this.file2 = file2;
        this.file3 = file3;
    }

    /**
     * @param line: The specific line to read
     * @return the content of the line
     */
    public String read(int filenumber, int line){

        String contentOfLine = "";
        String file = "";

        //Hvis vi vil have flere filer skal vi tilfæje flere cases i switch-casen
        switch (filenumber){
            case 1: file = file1;
                break;
            case 2: file = file2;
                break;
            case 3: file = file3;
                break;
            default: System.out.println("Filen findes ikke");
        }


        try{
            Stream<String> text = Files.lines(Paths.get(file));
            contentOfLine = text.skip(line-1).findFirst().get();

        }catch (IOException e){

            System.out.println("Filen kunne ikke findes");
        }

        return contentOfLine;
    }
}
