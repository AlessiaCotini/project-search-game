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
    }
    public void cercaPerId(Long idGioco) {
        collection.stream()
                .filter(games -> games.getIdGame().equals(idGioco))
                .findFirst()
                .ifPresentOrElse(
                        gioco -> System.out.println("We match : " + gioco),
                        () -> System.out.println("Gioco non presente in archivio")
                );
    }
    public List<StartingForAll> cercaPrezziMinori(double price) {
        List<StartingForAll> giochiFiltrati = collection.stream()
                .filter(gioco -> gioco.getPrice() < price)
                .toList();
        System.out.println(giochiFiltrati);
        return giochiFiltrati;
    }
    public List<Games> cercaGiocatori(Integer number) {
       List<Games> giocatoriFiltrati = collection.stream()
                .filter(gioco -> gioco instanceof Games)
                .map(gioco -> (Games) gioco)
                .filter(games -> games.getNumberOfPlayers().equals(number))
                .toList();
        System.out.println(giocatoriFiltrati);
        return giocatoriFiltrati;
    }
    public boolean eliminaPerID (Long idGioco){
       return collection.removeIf(gioco-> gioco.getIdGame().equals(idGioco));
    }
    public void modificaTramiteID(Long idGioco, String newTitle, LocalDate newYearOfRelease, double newPrice) {
        StartingForAll giocoDaModificare = collection.stream()
                .filter(games -> games.getIdGame().equals(idGioco))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Out of Collections"));
        if (newPrice < 0)throw new IllegalArgumentException("Not today");
        giocoDaModificare.setPrice(newPrice);
        giocoDaModificare.setTitle(newTitle);
        giocoDaModificare.setYearOfRelease(newYearOfRelease);
        System.out.println("We can : " + giocoDaModificare);
    }
    public void stampaStatistiche() {
        if (collection.isEmpty()) {
            System.out.println("Se la collezione è vuota non è possibile calcolare le statistiche.");
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
        System.out.println("---Statistiche Collezione---");
        System.out.println("Numero totale di Videogiochi: " + totaleVideogiochi);
        System.out.println("Numero totale di Giochi da Tavolo: " + totaleGiochiTavolo);
        System.out.println("Gioco con il prezzo più alto : " + giocoPiuCaro.getTitle() + giocoPiuCaro.getPrice() +" $" );
        System.out.printf("Media dei prezzi di tutti gli elementi: "+ mediaPrezzi);
    }


    @Override
    public String toString() {
        return "Ecco il tuo carrello : " + collection.toString();
    }


}
