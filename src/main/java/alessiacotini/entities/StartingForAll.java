package alessiacotini.entities;


import java.time.LocalDate;
import java.util.Random;

public abstract class StartingForAll {
    Random random = new Random();

    private final Long idGame ;
    private String title ;
    private final LocalDate yearOfRelease;
    private double price;

    public StartingForAll(Long idGame, String title, LocalDate yearOfRelease, double price, String title1) {
        this.idGame = random.nextLong();
        this.title = title;
        this.yearOfRelease = yearOfRelease;
        this.price = price;
    }
    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Not in my business : " + price);
        }
        this.price = price;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
    public Long getIdGame() {
        return idGame;
    }
    public double getPrice() {
        return price;
    }
    public LocalDate getYearOfRelease() {
        return yearOfRelease;
    }
}
