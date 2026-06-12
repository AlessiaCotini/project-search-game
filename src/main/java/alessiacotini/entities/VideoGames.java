package alessiacotini.entities;

import alessiacotini.entities.forgeneres.Generes;

import java.time.Duration;
import java.time.LocalDate;

public class VideoGames extends StartingForAll{
    private String platform;
    private final Duration duration;
    private Generes generes;

    public VideoGames(String title, LocalDate yearOfRelease, double price, int duration, Generes generes, String platform) {
        super(title, yearOfRelease, price);
        this.platform = platform;
        this.duration = Duration.ofHours(duration);
        this.generes= generes;
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    @Override
    public LocalDate getYearOfRelease() {
        return super.getYearOfRelease();
    }

    @Override
    public String getTitle() {
        return super.getTitle();
    }

    @Override
    public Long getIdGame() {
        return super.getIdGame();
    }

    public Generes getGeneres() {
        return generes;
    }

    public Integer getDuration() {
        return Math.toIntExact(duration.toHours());
    }

    public String getPlatform() {
        return platform;
    }
    public void setPlatform(String platform) {
        this.platform = platform;
    }

    @Override
    public String toString() {
        return "TIPO -> VIDEOGIOCO :" +
                super.toString() +
        " , piattaforma : " + platform +
                ", durata : " + duration +
                ", genere : " + generes +" .";
    }
}
