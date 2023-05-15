package com.NamTQ;

import com.NamTQ.Models.*;

import java.util.*;

public class Asm3 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final DigitalBank activeBank = new DigitalBank();
    private static final String CUSTOMER_ID = "001225000001";
    private static final String CUSTOMER_NAME = "FUNIX";
//ham main
    public static void main(String[] args) {
        menu();
        select();
        showCustomer();
        addSaving();
        addLoan();
        withdraw();
        history();
    }
//menu chương trinh
    public static void menu() {
        String AUTHOR = "FX20225";
        String VERSION = "V3.0.0";
        System.out.println("+----------+--------------------+----------+");
        System.out.println("|  NGAN HANG SO  |  " + AUTHOR + "@" + VERSION + "         |");
        System.out.println("+----------+--------------------+----------+");
        System.out.println("   1. Thong tin khach hang ");
        System.out.println("   2. Them tai khoan ATM ");
        System.out.println("   3. Them tai khoan tin dung ");
        System.out.println("   4. Rut tien ");
        System.out.println("   5. Lich su giao dich ");
        System.out.println("   0. Thoat ");
        System.out.println("+----------+--------------------+----------+");
        Customer customer = new Customer(CUSTOMER_NAME, CUSTOMER_ID);
        activeBank.addCustomer(customer);
    }

//lua chon cac option
    public static void select() {
        System.out.print("Chuc nang: ");
        Scanner scanner = new Scanner(System.in);
        int n;
        try {
            while (true) {
                n = scanner.nextInt();
                switch (n) {
                    case 0:
                        System.out.println("Chuong trinh ket thuc !!!");
                        System.exit(0);
                    case 1:
                        showCustomer();
                        break;
                    case 2:
                        addSaving();
                        break;
                    case 3:
                        addLoan();
                        break;
                    case 4:
                        withdraw();
                        break;
                    case 5:
                        history();
                        break;
                    default:
                        System.out.println("Vui long nhap so tu 0 toi 5");
                }
            }
        }
        catch (Exception InputMismatchException) {
            System.out.println("Vui long nhap so tu 0 toi 5");
            select();
        }
    }
//    thong tin khach hang
    public static void showCustomer() {
        Customer customer = activeBank.getCustomerById(CUSTOMER_ID);
        if (customer != null)
            customer.displayInformation();
        System.out.print("Chuc nang: ");
    }
//    them tai khoan ATM
    public static void addSaving(){
        String accountNumber;
        double balance;
        System.out.println("Nhap STK gom 6 chu so ");
        accountNumber = scanner.next();
//        kiem tra dieu kien STK
        while (accountNumber.length() != 6 || !accountNumber.matches("\\d+")) {
            System.out.println("STK khong hop le. Vui long nhap lai STK gom 6 chu so ");
            accountNumber = scanner.next();
        }
//        kiem tra STK bi trung
        boolean isExistedAccount = activeBank.isAccountExisted(accountNumber);
        while (isExistedAccount) {
            System.out.println("STK bi trung. Vui long nhap STK khac");
            accountNumber = scanner.next();
            while (accountNumber.length() != 6 || !accountNumber.matches("\\d+")) {
                System.out.println("STK khong hop le. Vui long nhap lai STK");
                accountNumber = scanner.next();
            }
            isExistedAccount = activeBank.isAccountExisted(accountNumber);
        }
        System.out.println("Nhap so du ");
//        kiem tra dieu kien so du
        while (true) {
            try {
                balance = scanner.nextDouble();
                if (balance < 50000) {
                    System.out.println("So du toi thieu la 50000. Vui long nhap lai");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Vui long nhap so");
                scanner.next();
            }
        }
        System.out.println("Da them tai khoan ATM thanh cong");
        System.out.print("Chuc nang: ");
        Account savingAccount = new SavingAccount(accountNumber, balance);
        activeBank.addAccount(CUSTOMER_ID, savingAccount);
    }
//    them tai khoan tin dung
    public static void addLoan(){
        String accountNumber;
        double balance;
        System.out.println("Nhap STK gom 6 chu so ");
        accountNumber = scanner.next();
//     kiem tra dieu kien STK
        while (accountNumber.length() != 6 || !accountNumber.matches("\\d+")) {
            System.out.println("STK khong hop le. Vui long nhap lai STK gom 6 chu so ");
            accountNumber = scanner.next();
        }
//        kiem tra STK bi trung
        boolean isExistedAccount = activeBank.isAccountExisted(accountNumber);
        while (isExistedAccount) {
            System.out.println("STK bi trung. Vui long nhap STK khac");
            accountNumber = scanner.next();
            while (accountNumber.length() != 6 || !accountNumber.matches("\\d+")) {
                System.out.println("STK khong hop le. Vui long nhap lai STK");
                accountNumber = scanner.next();
            }
            isExistedAccount = activeBank.isAccountExisted(accountNumber);
        }
        System.out.println("Nhap han muc: ");
//        kiem tra dieu kien han muc
        while (true) {
            try {
                balance = scanner.nextDouble();
                if (balance < 50000) {
                    System.out.println("Han muc toi thieu la 50000. Vui long nhap lai");
                }
                else  if (balance > 100000000){
                    System.out.println("Han muc toi da la 100000000. Vui long nhap lai");
                }
                else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Vui long nhap han muc");
                scanner.next();
            }
        }
        System.out.println("Da them tai khoan tin dung thanh cong");
        System.out.print("Chuc nang: ");
        Account loanAccount = new LoanAccount(accountNumber, balance);
        activeBank.addAccount(CUSTOMER_ID, loanAccount);
    }
//    ham rut tien
    public static void withdraw(){
        Scanner sc = new Scanner(System.in);
        String accountNumber;
        double moneyWithdraw;
        System.out.println("Nhap STK can rut");
        accountNumber = sc.next();
        while (accountNumber.length() != 6 || !accountNumber.matches("\\d+")) {
            System.out.println("STK khong hop le. Vui long nhap lai STK gom 6 chu so ");
            accountNumber = scanner.next();
        }
        System.out.println("Nhap so tien can rut");
        moneyWithdraw = sc.nextDouble();
        activeBank.withdraw(CUSTOMER_ID, accountNumber, moneyWithdraw);
        System.out.print("Chuc nang: ");
    }
    public static void history(){
    }
}

































