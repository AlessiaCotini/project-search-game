package alessiacotini.entities;

import alessiacotini.entities.forgeneres.Generes;
import java.time.LocalDate;

public class VideoGames extends StartingForAll{
    private String platform;
    private Integer duration;
    private final Generes generes;

    public VideoGames(Long idGame, String title, LocalDate yearOfRelease, double price, String title1, String platform, Integer duration, Generes generes ) {
        super(idGame, title, yearOfRelease, price, title1);
        this.platform = platform;
        this.duration = duration;
        this.generes= generes;
    }

    public Generes getGeneres() {
        return generes;
    }

    public Integer getDuration() {
        return duration;
    }

    public String getPlatform() {
        return platform;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }
}
