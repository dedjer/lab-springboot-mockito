package com.example.labspringbootmockito.Service;

public interface BankService {
    public double Deposit(long account, double amount);
    public double Withdraw(long account, double amount);
}
