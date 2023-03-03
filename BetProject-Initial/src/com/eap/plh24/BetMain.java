package com.eap.plh24;												//*****************//
																	//ΕΡΓΑΣΙΑ 2η ΠΛΗ 24//
																	//ΒΑΣΙΛΗΣ ΣΤΑΜΑΤΗΣ //
																	//*****************//

public class BetMain {

	public static void main(String[] args) {
		BetOrganization bo = BetOrganization.getInstance();
		//Κατά την προσομοίωση ΔΕ ζητούνται δεδομένα εισόδου στο πρόγραμμα
		//Όλα τα δεδομένα είναι hardcoded μέσα στον κώδικά σας
		//1.Δημιουργία διαθέσιμων στοιχημάτων για το ποδόσφαιρο
		Bet betOne = new FootballBet("AEK-PAO",1.75);// δημιουργία bet ποδοσφαίρου
		bo.addBet(betOne);// προσθήκη bet ποδοσφαίρου
		Bet betTwo = new FootballBet("LAMIA-PAOK",1.50);// δημιουργία bet ποδοσφαίρου
		bo.addBet(betTwo);// προσθήκη bet ποδοσφαίρου
		Bet betThree = new FootballBet("VOLOS-OSFP",1.15);// δημιουργία bet ποδοσφαίρου
		bo.addBet(betThree);// προσθήκη bet ποδοσφαίρου

		//2.Δημιουργία διαθέσιμων στοιχημάτων για το μπάσκετ
		Bet betFour = new BasketballBet("PAO-PERISTERI",1.75);// δημιουργία bet μπάσκετ
		bo.addBet(betFour);// προσθήκη bet μπάσκετ
		Bet betFive = new BasketballBet("OSFP-AEK",1.20);// δημιουργία bet μπάσκετ
		bo.addBet(betFive);// προσθήκη bet μπάσκετ
		Bet betSix = new BasketballBet("PROMITHEAS-ARIS",1.84);// δημιουργία bet μπάσκετ
		bo.addBet(betSix);// προσθήκη bet μπάσκετ

		//3.Δημιουργία παιχτών
		Customer customerOne = new Customer("Tony di Naples");
		Customer customerTwo = new Customer("Babis Sougias");

		//4.Δημιουργία στοιχημάτων των παιχτών
		CustomerBet tonyBet1 = new CustomerBet("AEK-PAO","Football",100,"2"); //δημιουργία bet
		customerOne.addCustomerBet(tonyBet1); // προσθήκη bet
		CustomerBet tonyBet2 = new CustomerBet("LAMIA-PAOK","Football",10,"2");//δημιουργία bet
		customerOne.addCustomerBet(tonyBet2);// προσθήκη bet
		CustomerBet tonyBet3 = new CustomerBet("PAO-PERISTERI","Basketball",50,"1");//δημιουργία bet
		customerOne.addCustomerBet(tonyBet3);// προσθήκη bet

		CustomerBet babisBet1 = new CustomerBet("VOLOS-OSFP","Football",100,"2"); //δημιουργία bet
		customerTwo.addCustomerBet(babisBet1); // προσθήκη bet
		CustomerBet babisBet2 = new CustomerBet("AEK-PAO","Football",1000,"X"); //δημιουργία bet
		customerTwo.addCustomerBet(babisBet2); // προσθήκη bet
		CustomerBet babisBet3 = new CustomerBet("PROMITHEAS-ARIS","Basketball",400,"2"); //δημιουργία bet
		customerTwo.addCustomerBet(babisBet3); // προσθήκη bet

		//5.Προσθήκη παιχτών στο σύστημα
		bo.addCustomer(customerOne);
		bo.addCustomer(customerTwo);

		//6.Προσομοίωση αγώνων
		GameEmulator game = GameEmulator.getInstance(); //δημιουργία game
		//game.doGameEmulation(bo);

		//7.Προβολή συνολικών αποτελεσμάτων παιχτών
		bo.showCustomersResults();

		//8.Και εγγραφή αυτών σε αρχείο κειμένου
		bo.printCustomersResultsToTextFile();

	}
}
