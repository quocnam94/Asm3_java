package com.NamTQ.Models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DigitalBankTest {
    Customer customer = new Customer("FunIX", "123456789123");
    Account account = new Account("123123", 10000000, "SAVING");
    DigitalBank activeBank = new DigitalBank();
    @Test
    public void getCustomerById() throws Exception{
        activeBank.addCustomer(customer);
        assertNotNull(activeBank.getCustomerById("123456789123"));
    }
}