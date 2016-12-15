package com.chapter7;
/*
 * Rabin karp or sliding window algorithm
 */
public class Q13 {

	public static void main(String[] args) {
		Q13 q = new Q13();
		String textString = "aabcabcdancjdnjdncjdnc cdjncjdncjdnjcnjdncjdncdn";
		String searchString = "cdn";
		
		
		System.out.println(q.getSearchIndex(searchString, textString));
		System.out.println(q.getHashCode(textString));
		System.out.println(textString.hashCode());
		
	}
	
	public int getSearchIndex(String s, String t) {
		int sCode = getHashCode(s);
		int tsCode = getHashCode(t.substring(0, s.length())); // search window in t
		
		final int firstHash = (int)Math.pow(31, s.length() - 1);
		
		for (int i = 0; i <= t.length() - s.length() - 1; i++) {
			if (sCode == tsCode && s.equals(t.substring(i, i + s.length()))) {
				return i;
			}
			System.out.println("removing  " + t.charAt(i) + "  and adding " + t.charAt(i + s.length()));
			tsCode -= firstHash * t.charAt(i);
			tsCode = tsCode * 31 + t.charAt(i + s.length());
		}
		
		// check for last one
		if ( sCode == tsCode && s.equals(t.substring(t.length() - s.length(), t.length()))) {
			return t.length() - s.length();
		}
		return -1;
		
	}
	
	private int getHashCode(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		char[] a = s.toCharArray();
		int h = 0;
		for (int i = 0; i < a.length; i++) {
			h = 31 * h + a[i];
		}
		return h;
	}
}

