package alessiacotini;

import alessiacotini.entities.Collection;
import alessiacotini.entities.Games;
import alessiacotini.entities.VideoGames;
import alessiacotini.entities.forgeneres.Generes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        VideoGames primoGioco = new VideoGames("GTA", LocalDate.of(2001,12,2), 19,12, Generes.ACTION, "PC");
        VideoGames secondoGioco = new VideoGames("Tetris", LocalDate.of(2002, 5,13),17.38,58,Generes.PUZZLE,"XBOX");
        VideoGames terzoGioco = new VideoGames("Giulia passione veterinaria", LocalDate.of(1996, 7,12), 6.99,1, Generes.FIGHTING, "GAMEBOY");
        VideoGames quartoGioco = new VideoGames("Snake", LocalDate.of(1200,1,24), 170.99,5, Generes.ADVENTURE, "NOKIA 3310");
        VideoGames quintoGioco = new VideoGames("Prato Fiorito", LocalDate.of(2021,8,9), 19.99,32, Generes.MMO, "COMPUTER");
        Games sestoGioco = new Games("Gioco dell'oca", LocalDate.of(1978,10,1), 23.0, (byte) 2, 13);
        Games settimoGioco = new Games("Cluedo", LocalDate.of(1989,9,7), 2.0, (byte) 4, 65);
        Games ottavoGioco = new Games("Monopoli", LocalDate.of(1997,2,28), 24.0, (byte) 6, 4);
        Games nonoGioco = new Games("Underscore", LocalDate.of(2016,6,26), 65.0, (byte) 8, 5);
        Games decimoGioco = new Games("Risiko", LocalDate.of(2006,4,6), 95.0, (byte) 2, 1);
        Collection laMiaCollezione = new Collection();
        laMiaCollezione.aggiungiGioco(primoGioco);
        laMiaCollezione.aggiungiGioco(secondoGioco);
        laMiaCollezione.aggiungiGioco(terzoGioco);
        laMiaCollezione.aggiungiGioco(quartoGioco);
        laMiaCollezione.aggiungiGioco(quintoGioco);
        laMiaCollezione.aggiungiGioco(sestoGioco);
        laMiaCollezione.aggiungiGioco(settimoGioco);
        laMiaCollezione.aggiungiGioco(ottavoGioco);
        laMiaCollezione.aggiungiGioco(nonoGioco);
        laMiaCollezione.aggiungiGioco(decimoGioco);
        System.out.println(laMiaCollezione);
    }
}
