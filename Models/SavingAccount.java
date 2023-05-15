package com.NamTQ.Models;

public class SavingAccount extends Account implements ReportService, Withdraw{

    private static final double SAVING_ACCOUNT_MAX_WITHDRAW = 5000000;
    private static final double FEE = 0;
    public SavingAccount(String accountNumber, double balance) {
        super(accountNumber, balance, TYPE_SAVING);
    }
//    kiem tra dieu kien rut tien
    @Override
    public boolean isAccepted(double amount) {
        double newBalance = getBalance() - amount;
        if (amount < 50000){
            System.out.println("So tien rut phai lon hon hoac bang 50000");
            return false;
        }
        if (amount % 10000 != 0) {
            System.out.println("So tien rut phai la boi so cua 10000");
            return false;
        }
        if (amount > getBalance()) {
            System.out.println("So tien rut lon hon so du");
            return false;
        }
        if (amount > SAVING_ACCOUNT_MAX_WITHDRAW && !isPremium()) {
            System.out.println("So tien rut toi da la " + SAVING_ACCOUNT_MAX_WITHDRAW);
            return false;
        }
        if (newBalance < 50000) {
            System.out.println("So du phai lon hon hoac bang 50000");
            return false;
        }
        return true;
    }
//    rut tien
    @Override
    public boolean withdraw(double amount){
        if (isAccepted(amount)) {
            double newBalance = getBalance() - amount;
            log(amount);
            setBalance(newBalance);
            return true;
        }
        System.out.println("Giao dich khong thanh cong");
        return false;
    }
//    in log
    @Override
    public void log (double amount){
        long millis = System.currentTimeMillis();
        java.util.Date date = new java.util.Date(millis);
        System.out.println("+------+-----------------------+------+");
        System.out.println("      BIEN LAI GIAO DICH SAVINGS       ");
        System.out.printf("NGAY G/D: %28s%n", date);
        System.out.printf("ATM ID: %30s%n", "DIGITAL-BANK-ATM 2023");
        System.out.printf("SO TK: %31s%n", getAccountNumber());
        System.out.printf("SO TIEN: %29s%n", String.format("%.1f", amount));
        System.out.printf("SO DU: %31s%n", String.format("%.1f", getBalance() - amount));
        System.out.printf("PHI + VAT: %27s%n", String.format("%.1f", FEE));
        System.out.println("+------+-----------------------+------+");
    }
}
