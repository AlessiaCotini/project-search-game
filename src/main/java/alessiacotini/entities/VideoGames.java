package alessiacotini.entities;

import alessiacotini.entities.forgeneres.Generes;

import java.time.Duration;
import java.time.LocalDate;

public class VideoGames extends StartingForAll{
    private String platform;
    private Duration duration;
    private Generes generes;

    public VideoGames(String title, LocalDate yearOfRelease, double price) {
        super(title, yearOfRelease, price);
        this.platform = platform;
        this.duration = Duration.ofHours(getDuration());
        this.generes= generes;
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

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }
}
