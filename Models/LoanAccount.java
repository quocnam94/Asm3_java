package com.NamTQ.Models;

public class LoanAccount extends Account implements ReportService, Withdraw{

    private static final double LOAN_ACCOUNT_WITHDRAW_FEE =0.05;
    private static final double LOAN_ACCOUNT_WITHDRAW_PREMIUM_FEE = 0.01;
    private static final double LOAN_ACCOUNT_MAX_BALANCE = 100000000;

    public LoanAccount(String accountNumber, double balance) {
        super(accountNumber, balance, TYPE_LOAN);
    }
//    phi rut tien
    public double getFee() {
        if (!isPremium()) {
            return LOAN_ACCOUNT_WITHDRAW_FEE;
        } else {
            return LOAN_ACCOUNT_WITHDRAW_PREMIUM_FEE;
        }
    }
//    kiem tra dieu kien rut tien
    @Override
    public boolean isAccepted(double amount) {
        double newBalance = getBalance() - amount - getFee()*amount;
        if (amount < 50000){
            System.out.println("So tien rut phai lon hon hoac bang 50000");
            return false;
        }
        if (amount > getBalance()) {
            System.out.println("So tien rut lon hon so du");
            return false;
        }
        if (amount % 10000 != 0) {
            System.out.println("So tien rut phai la boi so cua 10000");
            return false;
        }
        if (newBalance <50000) {
            System.out.println("Han muc con lai phai lon hon hoac bang 50000");
            return false;
        }
        return true;
    }
//    rut tien
    @Override
    public boolean withdraw(double amount){
        if (isAccepted(amount)) {
            double newBalance = getBalance() - amount - getFee()*amount;
            log(amount);
            setBalance(newBalance);
            return true;
        }
        System.out.println("Giao dich khong thanh cong");
        return false;
    }
//    ham log
    @Override
    public void log (double amount){
        long millis = System.currentTimeMillis();
        java.util.Date date = new java.util.Date(millis);
        System.out.println("+------+-----------------------+------+");
        System.out.println("      BIEN LAI GIAO DICH LOAN       ");
        System.out.printf("NGAY G/D: %28s%n", date);
        System.out.printf("ATM ID: %30s%n", "DIGITAL-BANK-ATM 2023");
        System.out.printf("SO TK: %31s%n", getAccountNumber());
        System.out.printf("SO TIEN: %29s%n", String.format("%.1f", amount));
        System.out.printf("SO DU: %31s%n", String.format("%.1f", getBalance() - amount - getFee()*amount));
        System.out.printf("PHI + VAT: %27s%n", String.format("%.1f", getFee()*amount));
        System.out.println("+------+-----------------------+------+");
    }
}
