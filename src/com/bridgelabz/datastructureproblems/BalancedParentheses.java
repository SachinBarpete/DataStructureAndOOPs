package com.bridgelabz.datastructureproblems;

import com.bridgelabz.datastructure.stack.*;

public class BalancedParentheses {

	static boolean balancedParenthensies(String s) {
		Stack stack = new Stack();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				stack.push(c);
			} else if (c == ')') {
				if (stack.isEmpty())
					return false;
				else
					stack.pop();
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		String input = "((5+6)*(7+8)/(4+3)(5+6)*(7+8))";
		System.out.println(balancedParenthensies(input));
	}
}