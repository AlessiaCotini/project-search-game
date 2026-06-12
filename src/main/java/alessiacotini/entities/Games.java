package alessiacotini.entities;

import java.time.Duration;
import java.time.LocalDate;

public class Games extends StartingForAll{
    private byte numberOfPlayers;
    private final Duration duration;

    public Games(String title, LocalDate yearOfRelease, double price) {
        super(title, yearOfRelease, price);
        this.duration = Duration.ofMinutes(getDuration());
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
