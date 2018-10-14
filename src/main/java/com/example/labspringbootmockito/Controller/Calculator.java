package com.example.labspringbootmockito.Controller;

import com.example.labspringbootmockito.Service.CalculatorService;

public class Calculator {
    private CalculatorService calculatorService;

    public Calculator(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public int Add(int x, int y) {

        //Using this return will ensure my "verify" test passes
        return calculatorService.Add(x, y);

        //Using this return will force my "verify" test to fail
//        return x+y;
    }
}
