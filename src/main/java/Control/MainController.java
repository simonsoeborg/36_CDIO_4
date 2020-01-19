package Control;

import Entity.*;

public class MainController {

    private GameBoard gb = GameBoard.getInstance();
    private PlayerList pl = PlayerList.getInstance();
    private ActionController ac = new ActionController();

    public void playGame() {

        GUIController gui = GUIController.getInstance();

        int playerNumber = gui.askForPlayers();

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

            if (p.getBankruptcy())
                action = "IsBankrupt";

            while (true) {

                option = gui.action(name, p.getFieldIndex(), action);
                gui.showGameStatus(pl.getPlayers(), gb.getFields());
                if (option.equals("Slut tur")) {
                    break;
                }
                action = ac.decideAction(option, p);
                if (option.equals("Rul") || option.equals("Prøv at slå par")) {
                    gui.showDice(ac.getDie1(), ac.getDie2());
                }

                gui.showGameStatus(pl.getPlayers(), gb.getFields());

                if (p.getBankruptcy()) {
                    gui.action(name, p.getFieldIndex(), "Bankrupt");
                    ac.decideAction("Bankrupt", p);
                    break;
                }

                if (action.equals("End")) {
                    break;
                }
            }

            if (p.isInJail() && !(ac.threeRoundsInJail(p))){
                gui.action(name, p.getFieldIndex(), "ThreeRoundsInJail");
                gui.showGameStatus(pl.getPlayers(), gb.getFields());
                if (p.getBankruptcy()) {
                    gui.action(name, p.getFieldIndex(), "Bankrupt");
                    ac.decideAction("Bankrupt", p);
                    break;
                }
            }

            if (ac.checkGameOver()) {
                gui.winner(ac.whoWins());
                System.exit(0);
            }
            turn = ++turn % playerNumber;
        }
    }
}
