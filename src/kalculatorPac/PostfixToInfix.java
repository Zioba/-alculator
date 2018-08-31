package kalculatorPac;

import java.util.Stack;

public class PostfixToInfix {

	private String test="";
	
	private int isOperator(char c) {
		if (c == '+' || c == '-' || c == '*' || c == '/' || c == '%')
			return 1;
		else if (c=='S' || c=='Q' || c=='C'|| c=='T'|| c=='G') return 2;
		else return 3;
	}

	public String convert(String postfix) {
		Stack<String> s = new Stack<>();
		for (int i = 0; i < postfix.length(); i++) {
			char c = postfix.charAt(i);
			switch (isOperator(c)) {
			case 1:
				String b = s.pop();
				String a = s.pop();
				s.push("(" + a + c + b + ")");
				test="";
				break;
			case 2:
				if (postfix.charAt(i-1)!=c) {
					String d = s.pop();
					if (c=='S') s.push("sin("+d+")");
					if (c=='C') s.push("cos("+d+")");
					if (c=='T') s.push("tg("+d+")");
					if (c=='G') s.push("ctg("+d+")");
					if (c=='Q') s.push("√("+d+")");
				}
				break;
			default:
				if (c != ' ') {
					test += c;
				}
				else {
					s.push(test);
					test="";
				}
			}
		}
		return s.pop();
	}
}
