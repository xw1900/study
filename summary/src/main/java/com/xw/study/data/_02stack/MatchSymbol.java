package com.xw.study.data._02stack;

public class MatchSymbol {
	
	public boolean isValid(String s) {
		java.util.Stack<Character> stack = new java.util.Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '[' || c == '{' || c == '(') {
				stack.push(c);
			} else {
				if (stack.isEmpty()) {
					return false;
				}
				Character peek = stack.peek();
				if (peek == '(' && c == ')') {
					stack.pop();
				}else if (peek == '{' && c == '}') {
					stack.pop();
				}else if (peek == '[' && c == ']') {
					stack.pop();
				} else {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		System.out.println(new MatchSymbol().isValid("(])"));
	}
}
