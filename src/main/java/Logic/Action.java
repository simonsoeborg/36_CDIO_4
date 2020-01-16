package Logic;

import Entity.DiceCup;
import Entity.Fields.Field;
import Entity.Fields.Street;
import Entity.GameBoard;
import Entity.Player;

public class Action {
    private LogicList ll = new LogicList();
    private DiceCup dc =  DiceCup.getINSTANCE();
    private PlayerMove mp = new PlayerMove();
    private PropertyOwnership po = new PropertyOwnership();
    private GameBoard gb = GameBoard.getInstance();
    private Field[] fl = gb.getFields();
    private Taxes taxes = new Taxes();
    private String option;



    public String decideAction (String action, Player p) {

        option = "";

        switch (action){

            case "Rul":
                dc.roll();
                mp.movePlayer(p, gb);
                option += ll.checkFieldType(p.getFieldIndex(), p);

                //TODO fængsel efter tre ens



                break;

            case "Køb":
                po.buyField(p, fl);
                checkForExtra();
                break;

            case "Køb ikke":
            case "Ok":
                checkForExtra();
                break;

            case "Betal 2000kr.-":
                taxes.stateTax(p);
                checkForExtra();
                break;

            case "Betal 4000kr.-":
                taxes.incomeTaxCash(p);
                checkForExtra();
                break;

            case "Betal 10%":
                taxes.incomeTaxPercentage(p);
                checkForExtra();
                break;

            case "Betal":
     //           if (fl[p.getFieldIndex()] instanceof Street)
     //               pr.payRentStreet();

        }


        return option;
    }







    private void checkForExtra() {
        if (dc.isFaceValueSame())
            option += "RollAgain";
        else
            option += "End";
    }
}
