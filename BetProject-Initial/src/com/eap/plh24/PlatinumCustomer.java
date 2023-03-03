package com.eap.plh24;



public class PlatinumCustomer extends Customer{

    public PlatinumCustomer(String n) { // καλεί τον constructor της κλάσης Customer
        super(n);
    }
    public int getMaxStake(){ //μέγιστο ποντάρισμα 2000
        return 2000;
    }
}

