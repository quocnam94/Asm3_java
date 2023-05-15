package com.NamTQ.Models;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class DigitalCustomer extends Customer{
    public DigitalCustomer(String name, String customerID, List<Account> accounts) {
        super(name, customerID, accounts);
    }
    public DigitalCustomer(String name, String customerID) {
        super(name, customerID);
    }
    public void withdraw (String accountNumber, double amount){

    }
    @Override
    public void displayInformation(){
        String isPre;
        String vn = NumberFormat.getCurrencyInstance(new Locale("VN","VN")).format(getBalance());
        if(isPremium())
            isPre="Premium";
        else
            isPre="Normal";
        System.out.printf("|%-10s | %-15s | %-7s |%-15s \n", getCustomerID(), getName(), isPre,vn);
        for(int i = 0; i < getAccounts().size(); i++){
            System.out.printf("|%-10s | %-15s | %-7s %n", i+1 + "     " + getAccounts().get(i).getAccountNumber(), getAccounts().get(i).getAccountType(), getAccounts().get(i).toString());
        }
    }
}
