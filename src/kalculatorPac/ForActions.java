package kalculatorPac;

import java.util.ArrayList;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class ForActions extends InToPost {
	private int lvl;
	PostfixToInfix theTrans;
	private String saved;

	public ForActions(ArrayList<String> steps) {
		super("");
		this.steps = steps;
		lvl=0;
		theTrans= new PostfixToInfix();
		ggwp(theTrans.convert(steps.get(lvl)));
		doTrans();
	}

	public void ggwp (String in) {
		input=in;
		input2 = input;
		int stackSize = input.length();
		theStack = new StackKalk(stackSize);
		spisok= new ArrayList<Box>();
		output="";
	}
	
	public String getText() {
		return saved;
	}
	
	public void actionUp() {
		if (lvl>0) {
			lvl--;
			ggwp(theTrans.convert(steps.get(lvl)));
			doTrans();
		}

	}

	public void actionDown() {
		if (lvl<steps.size()-1) {
			lvl++;
			ggwp(theTrans.convert(steps.get(lvl)));
			doTrans();
		}

	}

	public String doTrans() {
		saved=input;
		input = obrabotka(input);
		numbers=new ArrayList<Double>();
		for (int j = 0; j < input.length(); j++) {
			char ch = input.charAt(j);
			switch (ch) {
			case '+':
			case '-':
				gotOper(ch, 1);
				break;
			case '*':
			case '/':
			case '%':
				gotOper(ch, 2);
				break;
			case '√':
			case 'S':
			case 'C':
			case 'T':
			case 'G':
				gotOper(ch, 3);
			case '(':
				if (ch != '√')
					theStack.push(ch);
				else
					theStack.push('Q');
				break;
			case ')':
				gotParen(ch);
				break;
			default:
				output = output + ch;
				break;
			}
		}
		while (!theStack.isEmpty()) {
			output = output + theStack.pop();
		}
		String s = "";
		for (int i = 0; i < input2.length(); i++) {
			char ch = input2.charAt(i);
			if (ch == '1' | ch == '2' | ch == '3' | ch == '4' | ch == '5'
					| ch == '6' | ch == '7' | ch == '8' | ch == '9' | ch == '0'
					| ch == '.')
				s += ch;
			else if (s != "") {
				numbers.add(Double.parseDouble(s));
				s = "";
			}
		}
		if (s != "") {
			numbers.add(Double.parseDouble(s));
			s = "";
		}
		// numbers - список чисел
		// spisok - все элементы дерева
		if (numbers.size() > 1) {
			String test = "";
			curr = -1;
			for (int i = 0; i < output.length(); i++) {
				double x;
				char ch = output.charAt(i);
				switch (ch) {
				case '+':
					x = numbers.get(curr - 1) + numbers.get(curr);
					addOper(x, numbers.get(curr - 1), numbers.get(curr), '+');
					numbers.set(curr - 1, x);
					numbers.remove(curr);
					curr--;
					break;
				case '-':
					x = numbers.get(curr - 1) - numbers.get(curr);
					addOper(x, numbers.get(curr - 1), numbers.get(curr), '-');
					numbers.set(curr - 1, x);
					numbers.remove(curr);
					curr--;
					break;
				case '*':
					x = numbers.get(curr - 1) * numbers.get(curr);
					addOper(x, numbers.get(curr - 1), numbers.get(curr), '*');
					numbers.set(curr - 1, x);
					numbers.remove(curr);
					curr--;
					break;
				case '/':
					x = numbers.get(curr - 1) / numbers.get(curr);
					addOper(x, numbers.get(curr - 1), numbers.get(curr), '/');
					numbers.set(curr - 1, x);
					numbers.remove(curr);
					curr--;
					break;
				case '%':
					x = numbers.get(curr - 1) % numbers.get(curr);
					addOper(x, numbers.get(curr - 1), numbers.get(curr), '%');
					numbers.set(curr - 1, x);
					numbers.remove(curr);
					curr--;
					break;
				case 'Q':
					if (output.charAt(i - 1) == 'Q') {
						x = Math.sqrt(numbers.get(curr));
						addOper(x, numbers.get(curr), 'Q');
						numbers.set(curr, x);
					}
					break;
				case 'S':
					if (output.charAt(i - 1) == 'S') {
						x = Math.sin(numbers.get(curr));
						addOper(x, numbers.get(curr), 'S');
						numbers.set(curr, x);
					}
					break;
				case 'C':
					if (output.charAt(i - 1) == 'C') {
						x = Math.cos(numbers.get(curr));
						addOper(x, numbers.get(curr), 'C');
						numbers.set(curr, x);
					}
					break;
				case 'T':
					if (output.charAt(i - 1) == 'T') {
						x = Math.tan(numbers.get(curr));
						addOper(x, numbers.get(curr), 'T');
						numbers.set(curr, x);
					}
					break;
				case 'G':
					if (output.charAt(i - 1) == 'G') {
						x = 1 / Math.tan(numbers.get(curr));
						addOper(x, numbers.get(curr), 'G');
						numbers.set(curr, x);
					}
					break;
				default:
					test += ch;
					if (output.charAt(i + 1) != '.' && output.charAt(i) != '.') {
						if (Double.parseDouble(test) == numbers.get(curr + 1)) {
							curr++;
							test = "";
						}
					}
				}
			}
			DefaultMutableTreeNode top;
			switch (spisok.get(spisok.size() - 1).tip) {
			case 'Q':
				top = new DefaultMutableTreeNode("√");
				break;
			case 'S':
				top = new DefaultMutableTreeNode("sin");
				break;
			case 'C':
				top = new DefaultMutableTreeNode("cos");
				break;
			case 'T':
				top = new DefaultMutableTreeNode("tg");
				break;
			case 'G':
				top = new DefaultMutableTreeNode("ctg");
				break;
			default:
				top = new DefaultMutableTreeNode(
						spisok.get(spisok.size() - 1).tip);
				break;
			}
			jTree = new JTree(top);
			addNewItem(top, spisok.size() - 1, jTree);
			return Double.toString(numbers.get(0));
		}
		else {
			jTree = new JTree(new DefaultMutableTreeNode(Double.toString(numbers.get(0))));
			return Double.toString(numbers.get(0));
		}
	}

}
