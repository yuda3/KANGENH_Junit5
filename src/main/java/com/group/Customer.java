package com.group;

public class Customer {

    private int id;
    private int age;
    private int count;
    private String address;



    public boolean checkBonus(int age, String address,int count ) {
        return age >= 20 && address.contentEquals("東京都") && count >= 1;
    }
}
