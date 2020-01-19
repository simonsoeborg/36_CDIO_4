package Control;

import Boundary.GUI;
import Entity.*;

public class MainController {

    private GameBoard gb = GameBoard.getInstance();
    private PlayerList pl = PlayerList.getInstance();
    private LogicController lc = new LogicController();

    public void playGame() {

        GUI gui = GUI.getInstance();

        int playerNumber = gui.askForPlayers();

        pl.addPlayers(playerNumber);

        pl.givePlayerNames(gui.getPlayerNames(playerNumber));

        gui.addPlayers(pl.getPlayers());

        int turn = 0;
        Player p;
        String name;
        String action;
        String option;

        while (true) {

            p = pl.getPlayer(turn);
            name = p.getName();
            action = "Roll";

            if (p.isInJail()) {
                lc.jailCountUp(p);
                action = "InJail";
            }

            if (p.getBankruptcy())
                action = "IsBankrupt";

            while (true) {

                option = gui.action(name, p.getFieldIndex(), action);
                gui.showGameStatus(pl.getPlayers(), gb.getFields());
                if (option.equals("Slut tur")) {
                    break;
                }
                action = lc.decideAction(option, p);
                if (option.equals("Rul") || option.equals("Prøv at slå par")) {
                    gui.showDice(lc.getDie1(), lc.getDie2());
                }

                gui.showGameStatus(pl.getPlayers(), gb.getFields());

                if (p.getBankruptcy()) {
                    gui.action(name, p.getFieldIndex(), "Bankrupt");
                    lc.decideAction("Bankrupt", p);
                    break;
                }

                if (action.equals("End")) {
                    break;
                }
            }

            if (p.isInJail() && !(lc.threeRoundsInJail(p))){
                gui.action(name, p.getFieldIndex(), "ThreeRoundsInJail");
                gui.showGameStatus(pl.getPlayers(), gb.getFields());
                if (p.getBankruptcy()) {
                    gui.action(name, p.getFieldIndex(), "Bankrupt");
                    lc.decideAction("Bankrupt", p);
                    break;
                }
            }

            if (lc.checkGameOver()) {
                gui.winner(lc.whoWins());
                System.exit(0);
            }
            turn = ++turn % playerNumber;
        }
    }
}
