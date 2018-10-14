package com.example.labspringbootmockito;

import com.example.labspringbootmockito.Controller.Calculator;
import com.example.labspringbootmockito.Service.CalculatorService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LabSpringbootMockitoApplicationTests {

	@Mock
	private CalculatorService calculatorService;

	@InjectMocks
	private Calculator calculator;

	@Before
	public void before() {
//		calculatorService = new CalculatorService();
//		calculator = new Calculator(calculatorService);
	}

	@Test
	public void whenAddTwoNumbersTest(){

		// If anything calls the calculatorService.Add passing in 4, 4 then return 9
		Mockito.when(calculatorService.Add(4,4)).thenReturn(8);

		// Test calculator.add method
		assertThat(calculator.Add(4, 4), is(equalTo(8)));

		// Verify that my mocked calculatorService.Add method was called sometime during the test
		Mockito.verify(calculatorService).Add(4,4);
	}

}
