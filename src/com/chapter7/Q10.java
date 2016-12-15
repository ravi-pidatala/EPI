package com.chapter7;

public class Q10 {

	public static void main(String[] args) {
		
		String s = "1234567";
		Q10 q = new Q10();
		q.printAllIp(s);
	}
	
	/*
	Time complexity = upper bound 11 C 3
	*/
	private void printAllIp(String s) {
		//validate for string. Can contiain only digits. Should not correspond to negative integer. 

		if (s.length() > 12 || s.length () < 4) {
			return;
		}
		
		// i, j, k are 1 based indices.
		for (int i = 1; i <= s.length() - 3; i++) {
			for (int j = i + 1; j <= s.length() - 2; j++) {
				for (int k = j + 1; k <= s.length() - 1; k++) {
					if (isValid(s, i, j, k)) {
						System.out.println(format(s, i, j , k));
					}
				}
			}
		}
	}

	private boolean isValid(String s, int i, int j, int k) {
		if (k >= s.length()) {
			return false;
		}

		if (s.substring(0, i).length() <= 3 && Integer.valueOf(s.substring(0, i)) < 256 
			&& s.substring(i, j).length() <= 3 && Integer.valueOf(s.substring(i, j)) < 256
			&& s.substring(j, k).length() <= 3 && Integer.valueOf(s.substring(j, k)) < 256
			&& s.substring(k, s.length()).length() <= 3 && Integer.valueOf(s.substring(k, s.length())) < 256) {
				return true;
		}
		return false;
	}

	private String format(String s, int i, int j, int k) {
		StringBuilder sb = new StringBuilder();

		sb.append(s.substring(0, i) + ".");
		sb.append(s.substring(i, j) + ".");
		sb.append(s.substring(j, k) + ".");
		sb.append(s.substring(k, s.length()));

		return sb.toString();
	}
}
