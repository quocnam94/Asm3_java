package com.NamTQ.Models;

import java.text.NumberFormat;
import java.util.Locale;

public class Account {
    public static final String TYPE_SAVING = "SAVING";
    public static final String TYPE_LOAN = "LOAN";
    private String accountNumber;
    private double balance;
    private String accountType;
    public Account(String accountNumber, double balance, String accountType) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = accountType;
    }
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
//    xác định tài khoản có là Premium không
    public boolean isPremium(){
        if (getBalance() >= 10000000) {
            return true;
        }
        return false;
    }
//hiển thị STK + số dư
    public String toString(){
        String balanceFormatted = NumberFormat.getCurrencyInstance(new Locale("VN","VN")).format(balance);
        return "         " + balanceFormatted;
    }
}
