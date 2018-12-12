package com.application.bigDecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalTest {

	public static void main(String[] args) {
		
		double d1 = 23.0;
		BigDecimal bigDecimal = BigDecimal.valueOf(d1);
		System.out.println(bigDecimal.setScale(1, RoundingMode.HALF_UP));
	}
}
