package alessiacotini.entities;

import java.time.Duration;
import java.time.LocalDate;

public class Games extends StartingForAll{
    private byte numberOfPlayers;
    private final Duration duration;

    public Games(String title, LocalDate yearOfRelease, double price, byte numberOfPlayers, int duration) {
        super(title, yearOfRelease, price);
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

    @Override
    public String toString() {
        return "TIPO -> GIOCO DA TAVOLA :" +
                super.toString()+
        "numero di giocatori :" + numberOfPlayers +
                ", durata :" + duration +" ."
                ;
    }
}
