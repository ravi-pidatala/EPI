package com.chapter18;

import java.util.List;

public class Q6 {
	
	final int mpg = 20;

	public static void main(String[] args) {
		
		
		
		
	}
	
	/*
	 * Gas up problem. This can be solved by visualizing graph.
	 * Start from any city and check where there will be minimum gas. (theoretically gas can be negative).
	 * So if i start from the minimum gas city, this will be ample City. 
	 * 
	 */
	public int getAmpleCity(List<Integer> gallons, List<Integer> distances) {
		CityAndRemainingGas min = new CityAndRemainingGas(0, 0);
		int remainingGas = 0;
		//gallons [0] is for the a city
		for (int i = 1; i < gallons.size(); i++) {
			// check the gas remaining in the current city after reaching it.
			remainingGas += gallons.get(i - 1) - (distances.get(i - 1) / mpg);
			
			if (remainingGas < min.gas) {
				min = new CityAndRemainingGas(i, remainingGas);
			}
			
		}
		return min.city;
		
		
	}

}

class CityAndRemainingGas {
	int gas;
	int city;
	
	CityAndRemainingGas(int city, int gas) {
		this.city = city;
		this.gas = gas;
	}
}
