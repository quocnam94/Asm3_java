package com.NamTQ.Models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {
    Customer customer = new Customer("Nam", "123456789123");
    Customer customer2 = new Customer("FunIX", "123456123456");

    @Before
    public void setup(){
        customer.addAccount(new Account("111111", 11000000, "SAVINGS"));
        customer.addAccount(new Account("222222", 500000, "LOAN"));
        customer2.addAccount(new Account("333333", 500000, "SAVINGS"));
    }
    @Test
    public void getBalance() {
        double balance1 = customer.getAccountByAccounNumber("111111").getBalance();
        double balance2 = customer.getAccountByAccounNumber("222222").getBalance();
        assertEquals(customer.getBalance(),balance1 + balance2, 0 );
    }
    @Test
    public void isAccountPremium(){
        assertTrue(customer.isPremium());
    }
    @Test
    public void isAccountPremium2(){
        assertTrue(customer2.isPremium());
    }
}