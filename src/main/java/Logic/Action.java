package Logic;

import Entity.DiceCup;
import Entity.Fields.Field;
import Entity.GameBoard;
import Entity.Player;

public class Action {
    private LogicList ll = new LogicList();
    private DiceCup dc =  DiceCup.getINSTANCE();
    private PlayerMove mp = new PlayerMove();
    private PropertyOwnership po = new PropertyOwnership();
    private GameBoard gb = GameBoard.getInstance();
    private Field[] fl = gb.getFields();

    public String decideAction (String action, Player p) {

        String option = "";

        switch (action){

            case "Rul":
                dc.roll();
                mp.movePlayer(p, gb);
                option += ll.checkFieldType(p.getFieldIndex(), p);
                if (dc.isFaceValueSame())
                    option += "Roll";

                break;
            case "Køb":
                po.buyField(p, fl);
                if (dc.isFaceValueSame())
                    option += "Roll";
                else
                    option += "End";
                break;
            case "Betal 2000kr.-":




        }


        return option;
    }
}
