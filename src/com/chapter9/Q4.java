package com.chapter9;

import java.util.LinkedList;

public class Q4 {

	public static void main(String[] args) {
		Q4 q = new Q4();
		String path1 = "/usr/lib/..";
		String path2 = "usr/../../../bin/bin";
		String path3 = "/usr/../../../..";
		
		
		
		
		System.out.println(q.getNormalPath(path1));// /usr
		System.out.println(q.getNormalPath(path2));// /../../bin/bin
		System.out.println(q.getNormalPath(path3));// .
	}

	public String getNormalPath(String path) {
		//validate
		boolean isRelative = true;
		if (path.charAt(0) == '/') {
			isRelative = false;
		}

		String [] a = path.split("/");

		LinkedList<String> result = new LinkedList<>();
		for (int i = 0; i < a.length; i++) {

			switch(a[i]) {
				case "." :
				case "" :
				break;
				case "..":
					if (!result.isEmpty() && !result.peek().equals("..")) {
						result.pop();
					} else if (isRelative) {
							result.push(a[i]);
					}
				break;
				default:
					result.push(a[i]);
			}
		}
		StringBuilder sb = new StringBuilder();
		if (!isRelative) {
			sb.append("/");
		}
		while (!result.isEmpty()) {
			sb.append(result.removeLast() + "/");
		}
		return sb.substring(0, sb.length() - 1);// no need to include the last /
	}

}
