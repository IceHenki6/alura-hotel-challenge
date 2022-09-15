package com.federico.alurahotel.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Money {
	
	
	public static double Round(double number, int decimalPlaces) {
		BigDecimal bigDecimal = BigDecimal.valueOf(number);
		bigDecimal = bigDecimal.setScale(decimalPlaces, RoundingMode.HALF_UP);
		
		return bigDecimal.doubleValue();
	}
}
