package Control;

import Entity.*;
import Logic.*;

public class MainController {

    private int playerNumber;

    private GameBoard fl = GameBoard.getInstance();
    private PlayerList pl = PlayerList.getInstance();
    private LogicList ll = new LogicList();
    private PlayerMove pm = new PlayerMove();
    private DiceCup dc =  DiceCup.getINSTANCE();

    public void playGame() {

        GUISetup gui = GUISetup.getInstance();

        playerNumber = gui.askForPlayers();

        pl.addPlayers(playerNumber);

        pl.givePlayerNames(gui.getPlayerNames(playerNumber));

        gui.addPlayers(pl.getPlayers());


        int turn = 0;
        Player p;
        String name;
        String action = "";

        while (true) {

            p = pl.getPlayer(turn);
            name = p.getName();

            action = gui.action(name, p.getFieldIndex(), action);

            if (action.equals("Rul")) {
                dc.roll();
                gui.showDice(dc.getDie1(), dc.getDie2());
                pm.movePlayer(p,fl);
                gui.showGameStatus(pl.getPlayers(), fl.getFields());
                action = ll.checkFieldType(p.getFieldIndex(), turn);
                gui.action(name, p.getFieldIndex(), action);
            }


            turn = ++turn%playerNumber;








        }



    }





}
