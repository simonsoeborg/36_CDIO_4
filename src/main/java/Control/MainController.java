package Control;

import Boundary.GUISetup;
import Entity.*;
import Logic.*;

public class MainController {

    private int playerNumber;

    private GameBoard fl = GameBoard.getInstance();
    private PlayerList pl = PlayerList.getInstance();
    private Action ac = new Action();
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
        String action;
        String option = "";

        while (true) {

            p = pl.getPlayer(turn);
            name = p.getName();
            action = "Roll";

            if (p.isInJail()) {
                ac.jailCountUp(p);
                action = "InJail";
            }

            if (p.getMoney() <= 0) {
                p.setBankruptcy(true);
            }
            
            while (true) {

                option = gui.action(name, p.getFieldIndex(), action);
                gui.showGameStatus(pl.getPlayers(), fl.getFields());
                if (option.equals("Slut tur")) {
                    break;
                }
                action = ac.decideAction(option, p);
                if (option.equals("Rul") || option.equals("Prøv at slå par")) {
                    gui.showDice(dc.getDie1(), dc.getDie2());

                }
                gui.showGameStatus(pl.getPlayers(), fl.getFields());
                if (action.equals("End")) {
                    break;
                }
            }



            if (p.isInJail() && !(ac.threeRoundsInJail(p))){
                option = gui.action(name, p.getFieldIndex(), "ThreeRoundsInJail");
                gui.showGameStatus(pl.getPlayers(), fl.getFields());
            }

            turn = ++turn % playerNumber;

        }

    }

}
