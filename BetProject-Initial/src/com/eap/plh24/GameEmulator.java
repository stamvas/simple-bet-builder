package com.eap.plh24;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

//Η συγκεκριμένη κλάση χρησιμοποιείται κατά την εκτέλεση του προγράμματος, για την τυχαία παραγωγή των αποτελεσμάτων των αγώνων.
public class GameEmulator {
	//Αντικείμενο που μπορεί να χρησιμοποιηθεί για την παραγωγή τυχαίων αριθμών
    Random r = new Random();
	//Η συγκεκριμένη δομή HashMap θα μας βοηθήσει να αντιστοιχήσουμε κάθε αγώνα με ένα αποτέλεσμα.
	//Συγκεκριμένα, για κάθε μοναδικό όνομα αγώνα (πρώτη παράμετρος String),
	//θα αντιστοιχούμε ένα μονάδικο αποτέλεσμα (1-Χ-2) ή (1-2), ανάλογα με το είδος του αγώνα (ποδόσφαιρο ή μπάσκετ)
    private final Map<String,String> emulatedGamesResults = new HashMap<>();
    //Διαθέσιμες επιλογές για ποδόσφαιρο
    private final String[] footballChoices = FootballBet.getChoices().toArray(new String[0]);
    //Διαθέσιμες επιλογές για μπάσκετ
    private final String[] basketballChoices = BasketballBet.getChoices().toArray(new String[0]);

    private static GameEmulator instance;

    public static GameEmulator getInstance() { // μέθοδος για δημιουργία αντικειμένου GameEmulator λόγο singleton
        if (instance == null) {
            instance = new GameEmulator();
        }
        return instance;
    }
	//Η μέθοδος αυτή παράγει τα δεδομένα του HashMap "emulatedGamesResults"
	//π.χ. ότι στον αγώνα ποδοσφαίρου "Βραζιλία-Ν.Κορέα" αντιστοιχεί το αποτέλεσμα "1"
    public void doGameEmulation(BetOrganization bo){
        for (Bet game : bo.getBetList()){ //διαπέραση λίστας
            int randomNum = r.nextInt(footballChoices.length); // μεταβλητή για αποθήκευση τυχαίου αριθμού
            if (game instanceof FootballBet) //έλεγχος αν είναι αγώνας ποδοσφαίρου
                emulatedGamesResults.put(game.getGame(), footballChoices[randomNum]); //προσθήκη αγώνα
            else if (game instanceof BasketballBet) { //έλεγχος αν είναι αγώνας μπάσκετ
                emulatedGamesResults.put(game.getGame(), basketballChoices[randomNum]);//προσθήκη αγώνα
            }

        }

    }

    public Map<String, String> getEmulatedGamesResults() {
        return emulatedGamesResults;
    }
}
