package alessiacotini.entities;

import java.time.Duration;
import java.time.LocalDate;

public class Games extends StartingForAll{
    private byte numberOfPlayers;
    private final Duration duration;

    public Games(Long idGame, String title, LocalDate yearOfRelease, double price, String title1, byte numberOfPlayers, Integer duration) {
        super(idGame, title, yearOfRelease, price, title1);
        this.duration = Duration.ofMinutes(duration);
        this.numberOfPlayers = (numberOfPlayers >= 2 && numberOfPlayers <= 10) ? numberOfPlayers : 2;
    }
    public Integer getDuration() {
        return Math.toIntExact(duration.toMinutes());
    }
    public byte getNumberOfPlayers() {
        return numberOfPlayers;
    }
    public void setNumberOfPlayers(byte numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }
}
