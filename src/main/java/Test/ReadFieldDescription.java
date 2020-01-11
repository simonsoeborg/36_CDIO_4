package Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFieldDescription {
    private String selectLine = "";
    private String currentLine = "";
    List<String> arrFieldDescription = new ArrayList<String>();


    public void ReadFieldDescription(String language) {
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

            while (currentLine != null) {
                arrFieldDescription.add(currentLine);
                currentLine = fileReader.readLine();
            }



            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getFieldDescription(int line) {
        for (int i = 0; i < arrFieldDescription.toArray().length; i++) {
            if(i == line) {
                selectLine = arrFieldDescription.get(i);
                currentLine = selectLine;
                currentLine.split("[\\r\\n]+");
            }
        }
        return currentLine;
    }
}
