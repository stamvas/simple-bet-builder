package com.eap.plh24;

import java.util.ArrayList;
import java.util.List;

public class BasketballBet extends Bet{
    private static List<String> choices = new ArrayList<>();
    private static String homeWin = "1";
    private static String awayWin = "2";

    //Η κλάση περιέχει τις διαθέσιμες εκβάσεις ενός αγώνα μπάσκετ.
	//1:Νικήτρια η πρώτη ομάδα, 2:Νικήτρια η δεύτερη ομάδα
    public BasketballBet(String game, double odd) { // καλεί τον constructor της κλάσης Bet
        super(game, odd);
        choices.add(homeWin);
        choices.add(awayWin);
    }
    //Η μέθοδος επιστρέφει τη λίστα των διαθέσιμων επιλογών για έναν αγώνα μπάσκετ
	public static List<String> getChoices() {
        return choices;
    }
}
