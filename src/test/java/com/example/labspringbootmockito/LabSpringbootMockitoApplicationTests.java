package com.example.labspringbootmockito;

import com.example.labspringbootmockito.Controller.Bank;
import com.example.labspringbootmockito.Controller.Calculator;
import com.example.labspringbootmockito.Service.BankService;
import com.example.labspringbootmockito.Service.CalculatorService;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LabSpringbootMockitoApplicationTests {

	@Mock
	private CalculatorService calculatorService;

	@InjectMocks
	private Calculator calculator;

	private BankService bankService;

	private Bank bank;

	@Before
	public void setUp() throws Exception {
		// Mock without using annotations
		bankService = mock(BankService.class);
		bank = new Bank(bankService);
	}

	@Test
	public void whenAddTwoNumbersTest(){

		// arrange
		int x = 4;
		int y = 4;
		int result = 8;

		// act
		when(calculatorService.Add(x,y)).thenReturn(result);

		// assert
		assertThat(calculator.Add(x, y), is(equalTo(result)));
		verify(calculatorService).Add(x,y);
	}

	@Test
	public void verifyBalanceAfterDepositTest() {

		//arrange
		long account = 12345678;
		double amount = 1000.23;
		double balance = 2000.23;

		//act
		when(bankService.Deposit(account, amount)).thenReturn(balance);

		//assert
		assertThat(bank.Deposit(account, amount), is(equalTo(balance)));
		verify(bankService).Deposit(account, amount);
	}
}
