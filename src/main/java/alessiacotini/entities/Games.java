package alessiacotini.entities;

import java.time.LocalDate;

public class Games extends StartingForAll{
    private byte numberOfPlayers;
    private final Integer duration;

    public Games(Long idGame, String title, LocalDate yearOfRelease, double price, String title1, byte numberOfPlayers, Integer duration) {
        super(idGame, title, yearOfRelease, price, title1);
        this.duration = duration;
        this.numberOfPlayers = (numberOfPlayers >= 2 && numberOfPlayers <= 10) ? numberOfPlayers : 2;
    }
    public Integer getDuration() {
        return duration;
    }
    public byte getNumberOfPlayers() {
        return numberOfPlayers;
    }
    public void setNumberOfPlayers(byte numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }
}
