package com.NamTQ.Models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoanAccountTest {
    private LoanAccount loan;
    private LoanAccount loan2;
    private LoanAccount loan3;

@Before
public void setup(){
    loan = new LoanAccount("111111", 11000000);
    loan2 = new LoanAccount("222222", 6000000);
    loan3 = new LoanAccount("333333", 12000000);
}

    @Test
    public void isAccepted() {
        assertFalse(loan.isAccepted(10000));//so tien rut nho hon 50000
        assertFalse(loan.isAccepted(12000000));//so tien rut lon hon han muc
        assertFalse(loan.isAccepted(11000000));//han muc con lai nho hon 50000
        assertFalse(loan.isAccepted(123123));//so tien rut khong la boi so cua 10000
        assertTrue(loan.isAccepted(10000000));//rut tien hop le
    }

    @Test
    public void withdraw() {
        loan2.withdraw(1000000);
        assertEquals(4950000, 6000000 - 1000000 - 1000000 * 0.05, 0);//true
        loan2.withdraw(1000000);
        assertEquals(3900000, 4950000 - 1000000, 0);//false vi chua tinh phi rut tien
    }

    @Test
    public void getFee() {
        assertEquals(loan3.getFee(),0.01,0);
    }
    @Test
    public void isPremium(){
        assertFalse(loan2.isPremium());//true vi loan2 co han muc 6000000
        assertTrue(loan.isPremium());//true vi loan co han muc 11000000
    }
}