package alessiacotini.entities;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Collection {
    private List<StartingForAll> collection;
    public Collection() {
        this.collection = new ArrayList<>();
    }
    public void aggiungiGioco(StartingForAll gioco) {
        this.collection.add(gioco);
        if(gioco == null) throw new RuntimeException("GIOCO NON PRESENTE");
    }
    public void cercaPerId(Long idGioco) {
        collection.stream()
                .filter(games -> games.getIdGame().equals(idGioco))
                .findFirst()
                .ifPresentOrElse(
                        gioco -> System.out.println("GIOCO TROVATO : " + gioco),
                        () -> System.out.println("ID NON CORRISPONDENTE AGLI ELEMENTI DELLA TUA COLLEZIONE")
                );
    }
    public List<StartingForAll> cercaPrezziMinori(double price) {
        List<StartingForAll> giochiFiltrati = collection.stream()
                .filter(gioco -> gioco.getPrice() < price)
                .toList();
        if(giochiFiltrati.isEmpty()) throw new RuntimeException("MI DISPIACE NESSUNO DEI GIOCHI E' AL DI SOTTO DEL PREZZO INSERITO");
        else {System.out.println(giochiFiltrati);}
        return giochiFiltrati;
    }
    public List<Games> cercaGiocatori(Integer number) {
       List<Games> giocatoriFiltrati = collection.stream()
                .filter(gioco -> gioco instanceof Games)
                .map(gioco -> (Games) gioco)
                .filter(games -> games.getNumberOfPlayers().equals(number))
                .toList();
        if(giocatoriFiltrati.isEmpty()) throw new RuntimeException("NON CI SONO GIOCHI PRESENTI AL MOMENTI CON QUESTO NUMERO DI GIOCATORI");
        else {System.out.println(giocatoriFiltrati);}
        return giocatoriFiltrati;
    }
    public boolean eliminaPerID (Long idGioco){
       return collection.removeIf(gioco-> gioco.getIdGame().equals(idGioco));
    }
    public void modificaTramiteID(Long idGioco, String newTitle, LocalDate newYearOfRelease, double newPrice) {
        StartingForAll giocoDaModificare = collection.stream()
                .filter(games -> games.getIdGame().equals(idGioco))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("NON E' POSSIBILE MODIFICARE QUESTO ELEMENTO"));
        if (newPrice < 0)throw new IllegalArgumentException("NON POSSIAMO ANDARE IN ROVINA PER COLPA TUA");
        giocoDaModificare.setPrice(newPrice);
        giocoDaModificare.setTitle(newTitle);
        giocoDaModificare.setYearOfRelease(newYearOfRelease);
        System.out.println("We can : " + giocoDaModificare);
    }
    public void stampaStatistiche() {
        if (collection.isEmpty()) {
            System.out.println("LA COLLEZIONE E' VUOTA, STATISTICA NON CALCOLABILE");
            return;
        }
        long totaleVideogiochi = collection.stream()
                .filter(gioco -> gioco.getClass().getSimpleName().equalsIgnoreCase("VideoGames"))
                .count();

        long totaleGiochiTavolo = collection.stream()
                .filter(gioco -> gioco instanceof Games)
                .count();
        StartingForAll giocoPiuCaro = collection.stream()
                .max((giocouno, giocodue) -> Double.compare(giocouno.getPrice(), giocodue.getPrice()))
                .orElse(null);
        double mediaPrezzi = collection.stream()
                .mapToDouble(StartingForAll::getPrice)
                .average()
                .orElse(0.0);
        System.out.println("**********************STATISTICHE**********************");
        System.out.println("TOTALE DI VIDEOGIOCHI " + totaleVideogiochi);
        System.out.println("TOTALE DEI GIOCHI DA TAVOLA: " + totaleGiochiTavolo);
        System.out.println("GIOCO CON IL PREZZO PIU' ALTO : " + giocoPiuCaro.getTitle() + giocoPiuCaro.getPrice() +" $" );
        System.out.printf("MEDIA DEI PREZZI DELLA TUA COLLEZIONE : "+ mediaPrezzi +" $");
    }


    @Override
    public String toString() {
        return "ECCO LA TUA COLLEZIONE : " + collection.toString();
    }


}
