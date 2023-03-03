package com.eap.plh24;

import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

public class BetOrganization {
	//Λίστα με τους διαθέσιμους παίχτες
	private final List<Customer> cList = new ArrayList<>();
	//Λίστα με τα διαθέσιμα στοιχήματα για αγώνες ποδοσφαίρου και μπάσκετ
	private final List<Bet> betList = new ArrayList<>();
	private static BetOrganization instance;

	public static BetOrganization getInstance() { // μέθοδος για δημιουργία αντικειμένου BetOrganization λόγο singleton
		if (instance == null) {
			instance = new BetOrganization();
		}
		return instance;
	}


	public boolean checkCustomerBetInList(CustomerBet customerBet){
		for (Bet bet : betList){
			if (bet.getGame().equals(customerBet.getBetName()))
				return true;
		}
		return false;
	}
	public List<Bet> getBetList() {
		return betList;
	}
	public void addCustomer(Customer customer) {
		cList.add(customer);
	}
	public void addBet(Bet bet) {
		betList.add(bet);
	}
	//Η μέθοδος υπολογίζει τα κέρδη του παίχτη που δίδεται ως παράμετρός της.
	//Πιο συγκεκριμένα, η παράμετρος αφορά στη λίστα στοιχημάτων του εκάστοτε παίχτη
	private double calculateGainsPerCustomer(IGiveBetList customer) {
		//Για κάθε ένα στοίχημα που έχει κάνει ο παίχτης
			//Ψάχνουμε να το αντιστοιχήσουμε με τη λίστα των στοιχημάτων του BetOrganization
					//Στη συνέχεια, εφόσον το βρούμε, κοιτάζουμε αν έχει κερδίσει η επιλογή του παίχτη
					//και αν ναι, προσθέτουμε το ποσό στα κέρδη (επιστρεφόμενη τιμή της μεθόδου)
		double sum = 0; //άθροισμα των κερδών
		List<CustomerBet> customerBetList = customer.getCustomerBetList();
		for (CustomerBet customerBet : customerBetList){
			if (checkCustomerBetInList(customerBet)){

			}

		}
		return sum;


	}
	public void showCustomersResults(){
		System.out.println("------------------Results-------------------");
		for (Customer customer : cList){
			System.out.println("####################################");
			System.out.println("Customer name: "+customer.getName());
			System.out.println("Customer money paid: "+customer.getMoneyPlayed());
			System.out.println("Customer gains: "+String.valueOf(calculateGainsPerCustomer(customer)));
		}
		System.out.println("--------------End-of-Results----------------");
	}
	//Εγγραφή των αποτελεσμάτων των παιχτών στο αρχείο κειμένου "bet-results.txt"
	//Το αρχείο αυτό θα αντικαθίσταται από νέο αρχείο, κάθε φορά που εκτελείται το πρόγραμμα (δεν κρατάμε τα προηγούμενα δεδομένα)
	//Το format του αρχείου να είναι ίδιο με την εκτύπωση των αποτελεσμάτων (showCustomersResults)
	public void printCustomersResultsToTextFile(){ // https://www.tutorialspoint.com/redirecting-system-out-println-output-to-a-file-in-java
		try {										//εκτύπωση σε αρχείο
			File file = new File("bet-results.txt");
			PrintStream stream = new PrintStream(file);
			System.setOut(stream);
			showCustomersResults();
		}
		catch (IOException e) {
			e.printStackTrace();

		}
	}
}
