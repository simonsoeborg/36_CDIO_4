package Entity;

public class PlayerList {
    private static  final PlayerList INSTANCE = new PlayerList();

    private String players[];
    private int playerNumber;
    Player player = new Player();

    public int getPlayerNumber(int number) {
        int playerNumber;
        for(int i = 0; i < players.length; i++) {
            playerNumber = Integer.parseInt(players[i]);
            if(playerNumber == number) {
                this.playerNumber = playerNumber;
            }
        }
        return this.playerNumber;
    }


    public void setPlayerName(int playerNumber, String newName) {
        player.setPlayerName(newName);
    }



    public static PlayerList getINSTANCE(){
        return INSTANCE;
    }
}
