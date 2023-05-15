package com.NamTQ.Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DigitalBank extends Bank{
    private List<Customer> customers = new ArrayList<>();
    public Customer getCustomerById (String customerId){
        for (int i =0; i< getCustomers().size(); i++){
            if(getCustomers().get(i).getCustomerID().equals(customerId)){
                return getCustomers().get(i);
            }
        }
        return null;
    }
    @Override
    public void addCustomer(Customer newCustomer) {
        for (int i = 0; i < getCustomers().size(); i++) {
            if (newCustomer.getCustomerID().equals(getCustomers().get(i).getCustomerID())) {
                System.out.println("Khach hang da ton tai");
                return;
            }
        }
        getCustomers().add(newCustomer);
        System.out.println("Da them khach hang " + newCustomer.getCustomerID());
    }
    public boolean isCustomerExisted(String customerId){
        for (int i =0; i<customers.size(); i++){
            if(Objects.equals(customerId,customers.get(i).getCustomerID())){
                return true;
            }
        }
        return false;
    }
//    ham rut tien, xac dinh STK va loai TK can rut
    public boolean withdraw(String customerId, String accountNumber, double amount) {
        Customer customer = getCustomerById(customerId);
        if (customer != null) {
            Account account = customer.getAccountByAccounNumber(accountNumber);
            if (account != null) {
                if (account.getAccountType().equals(Account.TYPE_SAVING)) {
                    SavingAccount save = (SavingAccount) account;
                    return save.withdraw(amount);
                } else {
                    LoanAccount loan = (LoanAccount) account;
                    return loan.withdraw(amount);
                }
            } else {
                System.out.println("Khong tim thay STK nay");
                return false;
            }
        } else {
            System.out.println("Khong tim thay khach hang nay");
            return false;
        }
    }
}
