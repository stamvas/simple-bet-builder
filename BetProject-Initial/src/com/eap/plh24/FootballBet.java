package com.eap.plh24;

import java.util.ArrayList;
import java.util.List;

public class FootballBet extends Bet{
    private static List<String> choices = new ArrayList<>();
    private static String homeWin = "1";
    private static String awayWin = "2";
    private static String draw = "X";

    //Η κλάση περιέχει τις διαθέσιμες εκβάσεις ενός αγώνα ποδοσφαίρου.
	//1:Νικήτρια η πρώτη ομάδα, Χ:Ισοπαλία, 2:Νικήτρια η δεύτερη ομάδα
    public FootballBet(String game, double odd) { // καλεί τον constructor της κλάσης Bet
        super(game, odd);
        choices.add(homeWin);
        choices.add(awayWin);
        choices.add(draw);
    }

    //Η μέθοδος επιστρέφει τη λίστα των διαθέσιμων επιλογών για έναν αγώνα ποδοσφαίρου
	public static List<String> getChoices() {
        return choices;
    }
}
