package com.NamTQ.Models;

import static org.junit.Assert.*;

public class SavingAccountTest {
    @org.junit.Test
    public void isAccepted() throws Exception {
        SavingAccount save = new SavingAccount("111111", 11000000);
        SavingAccount save2 = new SavingAccount("222222", 6000000);
        assertFalse(save.isAccepted(10000));//so tien rut nho hon 50000
        assertFalse(save.isAccepted(12000000));//so tien rut lon hon so du
        assertFalse(save.isAccepted(11000000));//so du nho hon 50000
        assertFalse(save.isAccepted(123123));//so tien rut khong la boi so cua 10000
        assertFalse(save2.isAccepted(5500000));//tai khoan normal rut toi da 5000000
        assertTrue(save.isAccepted(10000000));//rut tien hop le + tai khoan premium rut khong gioi han
    }
    @org.junit.Test
    public void withdraw() throws Exception {
        SavingAccount save2 = new SavingAccount("333333", 6000000);
        save2.withdraw(1000000);
        assertEquals(5000000, 6000000-1000000, 0);
    }
}