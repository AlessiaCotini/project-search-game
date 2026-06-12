package alessiacotini;

import alessiacotini.entities.Collection;
import alessiacotini.entities.Games;
import alessiacotini.entities.VideoGames;
import alessiacotini.entities.forgeneres.Generes;

import java.time.LocalDate;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VideoGames primoGioco = new VideoGames("GTA", LocalDate.of(2001, 12, 2), 19, 12, Generes.ACTION, "PC");
        VideoGames secondoGioco = new VideoGames("Tetris", LocalDate.of(2002, 5, 13), 17.38, 58, Generes.PUZZLE, "XBOX");
        VideoGames terzoGioco = new VideoGames("Giulia passione veterinaria", LocalDate.of(1996, 7, 12), 6.99, 1, Generes.FIGHTING, "GAMEBOY");
        VideoGames quartoGioco = new VideoGames("Snake", LocalDate.of(1200, 1, 24), 170.99, 5, Generes.ADVENTURE, "NOKIA 3310");
        VideoGames quintoGioco = new VideoGames("Prato Fiorito", LocalDate.of(2021, 8, 9), 19.99, 32, Generes.MMO, "COMPUTER");
        Games sestoGioco = new Games("Gioco dell'oca", LocalDate.of(1978, 10, 1), 23.0, 2, 13);
        Games settimoGioco = new Games("Cluedo", LocalDate.of(1989, 9, 7), 2.0, 4, 65);
        Games ottavoGioco = new Games("Monopoli", LocalDate.of(1997, 2, 28), 24.0, 6, 4);
        Games nonoGioco = new Games("Underscore", LocalDate.of(2016, 6, 26), 65.0, 8, 5);
        Games decimoGioco = new Games("Risiko", LocalDate.of(2006, 4, 6), 95.0, 2, 1);

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

        System.out.println("----------------------------------BENTORNATO GIANGIORGIO-----------------------------------------------------------------------------");
        System.out.println("----------------------------------ECCO I TUOI GIOCHI-----------------------------------------------------------------------------");
        System.out.println(laMiaCollezione);

        boolean inputContinuo = true;
        while (inputContinuo) {
            try {
                System.out.println("--------------------------------- INSERISCI UN NUMERO CHE CORRISPONDA A UNA DI QUESTE AZIONI --------------------------------");
                System.out.println("--------------------------------- 1. RICERCA TRAMITE CODICE ID ---------------------------------");
                System.out.println("--------------------------------- 2. RICERCA TRAMITE PREZZO ---------------------------------");
                System.out.println("--------------------------------- 3. RICERCA TRAMITE NUMERO DI GIOCATORI ---------------------------------");
                System.out.println("--------------------------------- 4. RIMUOVI TRAMITE CODICE ID ---------------------------------");
                System.out.println("--------------------------------- 5. AGGIORNA TRAMITE CODICE ID ---------------------------------");
                System.out.println("--------------------------------- 6. STAMPA LE STATISTICHE DELLA TUA COLLEZIONE ---------------------------------");
                System.out.println("********************************* 0. PER USCIRE ************************************************");

                int input = scanner.nextInt();
                scanner.nextLine();
                switch (input) {
                    case 1 -> {
                        System.out.println("Se conosci il codice del gioco, inseriscilo per visualizzarlo :");
                        long numeroId = scanner.nextLong();
                        scanner.nextLine();
                        laMiaCollezione.cercaPerId(numeroId);
                    }
                    case 2 -> {
                        System.out.println("Inserisci il tuo budget :");
                        double prezzoCercato = scanner.nextDouble();
                        scanner.nextLine();
                        laMiaCollezione.cercaPrezziMinori(prezzoCercato);
                    }
                    case 3 -> {
                        System.out.println("Cerca per numero giocatori :");
                        int giocatoriCercati = scanner.nextInt();
                        scanner.nextLine();
                        laMiaCollezione.cercaGiocatori(giocatoriCercati);
                    }
                    case 4 -> {
                        System.out.println("Inserisci il codice dell'elemento che vuoi eliminare :");
                        long numeroIdDaEliminare = scanner.nextLong();
                        scanner.nextLine();
                        laMiaCollezione.eliminaPerID(numeroIdDaEliminare);
                    }
                    case 5 -> {
                        System.out.println("Se conosci il codice del gioco, inseriscilo per modificarlo :");
                        long numeroIdModifica = scanner.nextLong();
                        scanner.nextLine();

                        System.out.println("Inserisci il nuovo titolo per modificarlo :");
                        String newTitle = scanner.nextLine();

                        System.out.println("Inserisci il nuovo prezzo per modificarlo :");
                        double newPrice = scanner.nextDouble();
                        scanner.nextLine();

                        System.out.println("Anno del rilascio :");
                        int newYearOfRelease = scanner.nextInt();

                        System.out.println("Mese del rilascio :");
                        int newMonthOfRelease = scanner.nextInt();

                        System.out.println("Giorno del rilascio :");
                        int newDayOfRelease = scanner.nextInt();
                        scanner.nextLine();

                        laMiaCollezione.modificaTramiteID(numeroIdModifica, newTitle, LocalDate.of(newYearOfRelease, newMonthOfRelease, newDayOfRelease), newPrice);
                        System.out.println("Gioco modificato con successo!");
                    }
                    case 6 -> laMiaCollezione.stampaStatistiche();
                    case 0 -> {
                        System.out.println("Arrivederci Giangiorgio!");
                        inputContinuo = false;
                    }
                    default -> System.out.println("Opzione non valida. Scegli un numero da 0 a 6.");
                }

            } catch (java.util.InputMismatchException e) {
                System.out.println("HAI INSERITO UN NUMERO NON VALIDO");
                scanner.nextLine();
            } catch (java.time.DateTimeException e) {
                System.out.println("HAI INSERITO UNA DATA NON VALIDA");
            } catch (Exception e) {
                System.out.println("ERRORE : " + e.getMessage());
            }
        }
        scanner.close();
    }
}
