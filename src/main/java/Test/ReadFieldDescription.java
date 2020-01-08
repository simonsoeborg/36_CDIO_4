package Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFieldDescription {

    public ReadFieldDescription(String language) {
        try {
            String textFile = "";
            if(language.equals("da") || language.equals("DA")) {
                textFile = "P:\\3Ugers\\36_CDIO_4\\Textfiles\\FieldDescription_da";
            } else if (language.equals("en") || language.equals("EN")) {
                textFile = "P:\\3Ugers\\36_CDIO_4\\Textfiles\\FieldDescription_en";
            } else {
                System.out.println("Language selection is invalid: No such Language available");
            }

            BufferedReader fileReader = new BufferedReader(new FileReader(textFile));
            String currentLine = fileReader.readLine();
            List<String> arrFieldDescription = new ArrayList<String>();


            while (currentLine != null) {
                arrFieldDescription.add(currentLine);
                currentLine = fileReader.readLine();
            }

            fileReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
