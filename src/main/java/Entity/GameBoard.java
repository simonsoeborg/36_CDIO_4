package Entity;

import Entity.Fields.*;

import java.awt.*;

public class GameBoard {

    /**
     * This class makes our field array, with all the logial properties that the individual field contains.
     */

    private static final GameBoard INSTANCE = new GameBoard();
    private Field[] fields = new Field[40];
    private FileReader reader = new FileReader();
    private int fieldNum;

    public GameBoard() {

        fields[0] = new Field(reader.read(1, 1));
        fields[1] = new Street(reader.read(1, 2), 1200, 50, 600, 1000, 250, 750,2250, 4000, 6000);
        fields[2] = new ChanceCard(reader.read(1, 3));
        fields[3] = new Street(reader.read(1, 4), 1200, 50, 600, 1000, 250, 750,2250, 4000, 6000);
        fields[4] = new IncomeTax(reader.read(1, 5), 4000, 10);
        fields[5] = new Ferry(reader.read(1, 6), 4000, 500, 2000);
        fields[6] = new Street(reader.read(1, 7), 2000, 100, 1000, 1000, 600, 1800,5400, 8000, 11000);
        fields[7] = new ChanceCard(reader.read(1, 8));
        fields[8] = new Street(reader.read(1, 9), 2000, 100, 1000, 1000, 600, 1800,5400, 8000, 11000);
        fields[9] = new Street(reader.read(1, 10), 2400, 150, 1200, 1000, 800, 2000,6000, 9000, 12000);
        fields[10] = new Field(reader.read(1, 11));
        fields[11] = new Street(reader.read(1, 12), 2800, 200, 1400, 2000, 1000, 3000,9000, 12500, 15000);
        fields[12] = new Brewery(reader.read(1, 13), 3000, 100, 1500);
        fields[13] = new Street(reader.read(1, 14), 2800, 200, 1400, 2000, 1000, 3000,9000, 12500, 15000);
        fields[14] = new Street(reader.read(1, 15), 3200, 250, 1600, 2000, 1250, 3750,10000, 14000, 18000);
        fields[15] = new Ferry(reader.read(1, 16), 4000, 500, 2000);
        fields[16] = new Street(reader.read(1, 17), 3600, 300, 1800, 2000, 1400, 4000,11000, 15000, 19000);
        fields[17] = new ChanceCard(reader.read(1, 18));
        fields[18] = new Street(reader.read(1, 19), 3600, 300, 1800, 2000,1400, 4000,11000, 15000, 19000);
        fields[19] = new Street(reader.read(1, 20), 4000, 350, 2000, 2000, 1600, 4400,12000, 16000, 22000);
        fields[20] = new Field(reader.read(1, 21));
        fields[21] = new Street(reader.read(1, 22), 4400, 350, 2200, 3000,1800, 5000,14000, 17500, 21000);
        fields[22] = new ChanceCard(reader.read(1, 23));
        fields[23] = new Street(reader.read(1, 24), 4400, 350, 2200, 3000, 1800, 5000,14000, 17500, 21000);
        fields[24] = new Street(reader.read(1, 25), 4800, 400, 2400, 3000, 2000, 6000,15000, 18500, 22000);
        fields[25] = new Ferry(reader.read(1, 26), 4000, 500, 2000);
        fields[26] = new Street(reader.read(1, 27), 5200, 450, 2600, 3000, 2200, 6600,16000, 19500, 23000);
        fields[27] = new Street(reader.read(1, 28), 5200, 450, 2600, 3000, 2200, 6600,16000, 19500, 23000);
        fields[28] = new Brewery(reader.read(1, 29), 3000, 100, 1500);
        fields[29] = new Street(reader.read(1, 30), 5600, 500, 2800, 3000, 2400, 7200,17000, 20500, 24000);
        fields[30] = new Field(reader.read(1, 31));
        fields[31] = new Street(reader.read(1, 32), 6000, 550, 3000, 4000, 2600, 7800,18000, 22000, 25000);
        fields[32] = new Street(reader.read(1, 33), 6000, 550, 3000, 4000, 2600, 7800,18000, 22000, 25000);
        fields[33] = new ChanceCard(reader.read(1, 34));
        fields[34] = new Street(reader.read(1, 35), 6400, 600, 3200, 4000, 3000, 9000,20000, 24000, 28000);
        fields[35] = new Ferry(reader.read(1, 36), 4000, 500, 2000);
        fields[36] = new ChanceCard(reader.read(1, 37));
        fields[37] = new Street(reader.read(1, 38), 7000, 700, 3500, 4000, 3500, 10000,22000, 26000, 30000);
        fields[38] = new StateTax(reader.read(1, 39), 2000);
        fields[39] = new Street(reader.read(1, 40), 8000, 1000, 4000, 4000, 4000, 12000,28000, 34000, 40000);
    }


    public String getFieldName(int fieldNumber) {

        return fields[fieldNumber].getFieldName();
    }

    public int getSize() {
        return fields.length;
    }

    public Field[] getFields() {
        return fields;
    }

    public String getField(int fieldNumber) {
        String selectField = "";
        for (int i = 0; i <getSize(); i++) {
          if (fieldNumber == i){
              selectField = fields[i].toString();
          }
        }
        return selectField;
    }



    public static GameBoard getInstance() {
        return INSTANCE;
    }

}
