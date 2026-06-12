package alessiacotini.entities;

import java.time.LocalDate;

public abstract class StartingForAll {
    private final Long idGame ;
    private static long counter = 1;
    private String title ;
    private LocalDate yearOfRelease;
    private double price;

    public StartingForAll(String title, LocalDate yearOfRelease, double price) {
        if (yearOfRelease == null) {
            throw new IllegalArgumentException("Is not true, we know.");
        }
        if (yearOfRelease.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Maybe someday" + yearOfRelease);
        }
        this.idGame = counter++;
        this.title = title;
        this.yearOfRelease = yearOfRelease;
        setPrice(price);
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

    public void setYearOfRelease(LocalDate yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
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

    @Override
    public String toString() {
        return  " Titolo :'" + title + '\'' +
                ", anno di uscita : " + yearOfRelease +
                ", prezzo : " + price + "$ "+ "ID gioco : " + idGame;
    }
}
