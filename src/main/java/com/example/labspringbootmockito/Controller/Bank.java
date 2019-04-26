package com.example.labspringbootmockito.Controller;

import com.example.labspringbootmockito.Service.BankService;

public class Bank {
    private double balance;
    private BankService bankService;

    public Bank(BankService bankService) {
        this.bankService = bankService;
    }

    public double Deposit(long account, double amount) {
        balance = bankService.Deposit(account, amount);
        return balance;
    }
}
