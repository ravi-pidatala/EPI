package com.chapter14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q10 {

	public static void main(String[] args) {
		
		
		
		
	}
	
	/*
	 * Compute salary threshold.
	 * 
	 */
	public double getSalaryThresh(List<Double> currentSalaries, double target) {
		Collections.sort(currentSalaries);
		int capIndex = -1;
	
		double unAdjustedSalary = 0;
		
		for (int i = 0; i < currentSalaries.size(); i++) {
			final double adjustedSalary = currentSalaries.get(i) * (currentSalaries.size() - i);
			
			if (adjustedSalary + unAdjustedSalary >= target) {
				return (target - unAdjustedSalary)/ (currentSalaries.size() - i);
			}
			unAdjustedSalary = unAdjustedSalary + currentSalaries.get(i);
		}
		return -1;
	}

}
