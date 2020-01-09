package Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFieldDescription {
    private String selectLine = "";


    public String ReadFieldDescription(String language, int line) {
        try {
            String textFile = "";
            if(language.equals("da") || language.equals("DA")) {
                textFile = "src/Textfiles/FieldDescription_da.txt";
            } else if (language.equals("en") || language.equals("EN")) {
                textFile = "src/Textfiles/FieldDescription_en.txt";
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

            for (int i = 0; i < arrFieldDescription.toArray().length; i++) {
                if(i == line) {
                    selectLine = arrFieldDescription.get(i);
                }
            }

            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return selectLine;
    }
}
