package com.chapter18;

public class CurrencyChange {

	public static void main(String[] args) {
		CurrencyChange q = new CurrencyChange();
		
		System.out.println(q.getNumberOfCoins(98));// 25, 25, 25, 10, 10, 1, 1, 1
	}

	
	int getNumberOfCoins(int count) {
		int [] coins = {100, 25, 10, 5, 1};
		int numberOfCoins = 0;
		
		for (int i: coins) {
			numberOfCoins = numberOfCoins + (count / i);
			count = count % i;
		}
		return numberOfCoins;
	}
}
