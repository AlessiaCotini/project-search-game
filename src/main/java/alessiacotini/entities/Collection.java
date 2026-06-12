package alessiacotini.entities;

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
    @Override
    public String toString() {
        return "Collection: " + collection.toString();
    }
}
