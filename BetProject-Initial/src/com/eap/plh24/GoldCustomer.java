package com.eap.plh24;



public class GoldCustomer extends Customer{

    public GoldCustomer(String n) { // καλεί τον constructor της κλάσης Customer
        super(n);
    }

    public int getMaxStake(){ //μέγιστο ποντάρισμα 1000
        return 1000;
    }




}
