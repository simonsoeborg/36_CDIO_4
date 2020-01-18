package Entity;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Reads from a number of five specified textfiles.
 * @author David
 * @version 1.0.0
 */
public class FileReader {

    private String file1 = "src/TextFiles/1FieldName_da.txt";
    private String file2 = "src/TextFiles/2FieldDescription_da.txt";
    private String file3 = "src/TextFiles/3ActionDescriptions_da.txt";
    private String file4 = "src/TextFiles/4SameColoredFieldsInfo.txt";
    private String file5 = "src/TextFiles/5ChanceCards.txt";

    /**
     * Reads a specific line (String) from a specific textfile
     * @param filenumber - The number of the file you want to read from
     * @param line - the line you want to be read
     * @return - The content of the line that was read
     */
    public String read(int filenumber, int line){

        String contentOfLine = "";
        String file = "";

        // Tjekker filenumber inputtet. alt efter hvad det er, bliver den lokale variabel "file" sat lig en fil-sti (path)
        switch (filenumber){
            case 1: file = file1;
                break;
            case 2: file = file2;
                break;
            case 3: file = file3;
                break;
            case 4: file = file4;
                break;
            case 5: file = file5;
                break;
            default: System.out.println("Filen findes ikke");
        }

        // Dette er vores fejlhåndtering. vi prøver at gøre det der i i Try, hvis det ikke kan lade sig gøre,
        // så gør vi det der står i catch
        try{
            //Stream
            //Laver en stream af Strings som kaldes text. Derefter specificeres at de Strings vores Stream kommer til at
            //bestå af, skal være linjer i en fil, hvis sti pliver specifiseret af file stringen.
            // til sidst bedes text om at skippe et vis antal linjer fra tekstdokumentet og derefter konvaterer det til
            // en string. Dette sættes lig contentofline
            Stream<String> text = Files.lines(Paths.get(file));
            contentOfLine = text.skip(line-1).findFirst().get();

        }catch (IOException e){

            System.out.println("Filen kunne ikke findes");
        }

        return contentOfLine;
    }
}
