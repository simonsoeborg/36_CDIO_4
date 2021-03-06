package Control;

import Entity.DiceCup;
import Entity.Fields.*;
import Entity.GameBoard;
import Entity.Player;
import Entity.PlayerList;
import Logic.*;

/**
 * This is a class, for all possible decisions in the game,
 * @author KE
 * @version 1.0.0
 */
public class LogicController {
    private DiceCup dc =  DiceCup.getINSTANCE();
    private PlayerMove mp = new PlayerMove();
    private PropertyOwnership po = new PropertyOwnership();
    private GameBoard gb = GameBoard.getInstance();
    private Field[] fl = gb.getFields();
    private PlayerList pl = PlayerList.getInstance();
    private Taxes taxes = new Taxes();
    private PropertyRent pr = new PropertyRent();
    private CheckField cf = new CheckField();
    private JailLogic jl = new JailLogic();
    private ChanceCardLogic cl = ChanceCardLogic.getInstance();
    private String option;
    private int random;
    private static final LogicController INSTANCE = new LogicController();

    /**
     * So on the button in game is a String. When you click on it, it copy that String on the button
     * and then run the switch case for that specific String.
     * @param action - action is a String
     * @param p - the Current player whose playing
     * @return a string containing an option
     */
    String decideAction(String action, Player p) {

        option = "";

        switch (action) {

            //----------------------------------------------Roll Dice------------------------------------------------------------//
            // rul terning for at bevæge spilleren.
            case "Rul":
                dc.roll(); //Test

                // hvis spilleren slår double med terningen.
                if (jl.checkNumDoubles(p, dc.isFaceValueSame()))
                    option = "3Doubles";
                else {
                    mp.movePlayer(p, gb);
                    option += cf.checkFieldType(p.getFieldIndex(), p);
                }
                break;

            //----------------------------------------------Land on a field------------------------------------------------------//

            // vil du købe feltet
            case "Køb":
                po.buyField(p, fl);
                checkForExtra(p);
                break;

            case "Køb ikke":
            case "Ok":
                // under at bygge huse
            case "Fortryd":
            case " ":
                checkForExtra(p);
                break;

            // extradordinær skat
            case "Betal 2.000kr.-":
                taxes.stateTax(p);
                checkForExtra(p);
                break;

            // inkomstaskat
            case "Betal 4.000kr.-":
                taxes.incomeTaxCash(p);
                checkForExtra(p);
                break;

            // -||-
            case "Betal 10%":
                taxes.incomeTaxPercentage(p);
                checkForExtra(p);
                break;

            // betal for renten af en spillers felt
            case "Betal":
                payRent(p);
                checkForExtra(p);
                break;

//----------------------------------------------JAIL------------------------------------------------------------------//

            case "Betal 1.000kr.-":
                jl.payOutOfJail(p);
                option = "Roll";
                break;

            case "Prøv at slå par":
                dc.roll(); // test
                if (dc.isFaceValueSame()) {
                    p.setInJail(false);
                    option = "Free";
                    p.setRoundsInJail(0);
                } else
                    option = "NotFree";
                break;

            case "Ryk i fængsel":
                p.setFieldIndex(10);
                option = "End";
                break;

//----------------------------------------------House-----------------------------------------------------------------//
// farverne på felterne og hvor mange Streets der så af på hver af farverne

            case "Byg hus":
                option = "BuildHouse";
                break;

            case "Blå":
                if (p.getBlue() == 2) {
                    int fieldIndex = po.whereToBuild(0);
                    option = po.houseBuilder(((Street)fl[fieldIndex]), p);
                } else {
                    option = "NotAllSets";
                }
                break;

            case "Pink":
                if (p.getPink() == 3) {
                    int fieldIndex = po.whereToBuild(1);
                    option = po.houseBuilder(((Street)fl[fieldIndex]), p);
                } else {
                    option = "NotAllSets";
                }
                break;

            case "Grøn":
                if (p.getGreen() == 3) {
                    int fieldIndex = po.whereToBuild(2);
                    option = po.houseBuilder(((Street)fl[fieldIndex]), p);
                } else {
                    option = "NotAllSets";
                }
                break;

            case "Grå":
                if (p.getGrey() == 3) {
                    int fieldIndex = po.whereToBuild(3);
                    option = po.houseBuilder(((Street)fl[fieldIndex]), p);
                } else {
                    option = "NotAllSets";
                }
                break;

            case "Rød":
                if (p.getRed() == 3) {
                    int fieldIndex = po.whereToBuild(4);
                    option = po.houseBuilder(((Street)fl[fieldIndex]), p);
                } else {
                    option = "NotAllSets";
                }
                break;

            case "Hvid":
                if (p.getWhite() == 3) {
                    int fieldIndex = po.whereToBuild(5);
                    option = po.houseBuilder(((Street)fl[fieldIndex]), p);
                } else {
                    option = "NotAllSets";
                }
                break;

            case "Gul":
                if (p.getYellow() == 3) {
                    int fieldIndex = po.whereToBuild(6);
                    option = po.houseBuilder(((Street)fl[fieldIndex]), p);
                } else {
                    option = "NotAllSets";
                }
                break;

            case "Lilla":
                if (p.getPurple() == 2) {
                    int fieldIndex = po.whereToBuild(7);
                    option = po.houseBuilder(((Street)fl[fieldIndex]), p);
                } else {
                    option = "NotAllSets";
                }
                break;

//-------------------------Bankrupt-----------------------------------------------------------------------------------//

            case "Bankrupt":
                removePlayerFields(gb, p);
                option = "End";
                break;

//-------------------------Chance-----------------------------------------------------------------------------------//

            case "Træk kort":
                cl.generateRandomNumber();
                random = cl.getRandomNumber();
                if ( random > 0 && random < 12)
                    option = "Pay";
                else if ( random > 11 && random < 23)
                    option = "Receive";
                else if (random > 22 && random < 33)
                    option = "Move";
                break;

            case "Betal penge":
                cl.payChanceCard(p, random);
                checkForExtra(p);
                break;

            case "Modtag penge":
                cl.receiveMoneyChanceCard(p, random);
                checkForExtra(p);
                break;

            case "Ryk":
                cl.moveChanceCard(p, random);
                option += cf.checkFieldType(p.getFieldIndex(), p);
                break;
        }
        return option;
    }

    /**
     * A method to make sure the player, can do a thing multiable times, and have a choice afterward.
     * Such as they can buy Houses X amount and after they have bought it, they can continue or end turn.
     * @param p - the current players turn
     */
    private void checkForExtra(Player p) {
        if (po.canBuildHouse(fl, p))
            option += "House";

        if (dc.isFaceValueSame())
            option += "RollAgain";

        if (!(dc.isFaceValueSame()) && !(po.canBuildHouse(fl, p)))
            option += "End";
    }

    /**
     * If the field is owned, the current player needs to pay. This method makes sure to let know what kind of thing
     * the player needs to pay for. (street, ferry, brewery)
     * @param p - the current player
     */
    private void payRent(Player p) {
        int owner = cf.whoseProperty(p.getFieldIndex());
        if (fl[p.getFieldIndex()] instanceof Street)
            pr.payRentStreet(owner, p, pl.getPlayers(), fl);

        if (fl[p.getFieldIndex()] instanceof Ferry)
            pr.payRentFerry(owner, p, pl.getPlayers(), fl);

        if (fl[p.getFieldIndex()] instanceof Brewery)
            pr.payRentBrewery(owner, p, pl.getPlayers(), fl);
    }

    /**
     * a counter for the 3 times a player can be in jail
     * @param p - current player in jail
     */
    void jailCountUp(Player p) {
        if (p.isInJail())
            p.addRoundInJail();
    }

    /**
     *  After 3 rounds in jail, where the player haven't rolled a double. they SHALL pay 1.000,- and then they are free
     * @param p - current player who's about to get out
     * @return - Returns whether or not the player have been in jail for three rounds.
     */
    boolean threeRoundsInJail(Player p) {
        if (p.getRoundsInJail() == 3) {
            p.addMoney(-1000);
            p.setInJail(false);
            return false;
        } else
            return true;
    }

    /**
     * When the player goes bankrupcty they needs to be removed from the board
     * @param gb - it check the gameboard for their ID and removes them
     * @param p - the Current player there have goes bankrupcty
     */
    private void removePlayerFields(GameBoard gb, Player p){
        // Gennemløber alle felter og setter de felter der har samme id som spilleren til 0, så han ikke ejer dem mere.
        for (Field field: gb.getFields()) {
            if (field instanceof Street) {
                if(p.getId() == ((Street) field).getOwnerID()){
                    ((Street) field).setNumberOfHouses(0);
                }
            }
            if( field instanceof Ownable){
                if(p.getId() == ((Ownable) field).getOwnerID()){
                    ((Ownable) field).setOwnerID(0);
                }
            }
        }
    }

    /**
     * a method there check if all players except one are bankrupt
     * @return - Boolean true if only one player is remaining which means Game over or false if there is more than one
     * player left
     */
    boolean checkGameOver() {
        int playersNotOut = pl.getPlayers().length;
        for (int i = 0; i < pl.getPlayers().length; i++) {
            if (pl.getPlayer(i).getBankruptcy())
                playersNotOut--;
        }

        return playersNotOut == 1;
    }

    /**
     * This method can run after the game is over
     * @return - return that the last man standing have won
     */
    int whoWins() {
        int winner = 0;
        for (int i = 0; i < pl.getPlayers().length; i++) {
            if (!(pl.getPlayer(i).getBankruptcy()))
                winner = i;
        }
        return winner;
    }

    int getDie1() {
        return dc.getDie1();
    }

    int getDie2() {
        return dc.getDie2();
    }

    public static LogicController getInstance() {
        return INSTANCE;
    }
}
