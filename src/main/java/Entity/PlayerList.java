package Entity;

public class PlayerList {
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

    public int getMoney() {
        return player.getMoney();
    }

    public void setMoney(int amount) {
        player.setMoney(amount);
    }
}
