package kalculatorPac;

import java.util.ArrayList;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

public class InToPost {
	protected StackKalk theStack;
	protected String input;
	protected String input2;
	protected String output;
	protected ArrayList<Double> numbers;
	public ArrayList<String> steps = new ArrayList<String>();
	protected int curr;
	protected JTree jTree;
	protected ArrayList<Box> spisok;

	// (55-sin(32))*√(6/3)
	public InToPost(String in) {
		input = in;
		input2 = input;
		int stackSize = input.length();
		theStack = new StackKalk(stackSize);
		spisok= new ArrayList<Box>();
		output="";
	}

	public String doTrans() {
		numbers = new ArrayList<Double>();
		input = obrabotka(input);
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
		/*for (int i=0;i<numbers.size();i++) {
			System.out.println(numbers.get(i));
		}*/
		// numbers - список чисел
		//spisok - все элементы дерева
		String chernovik="";
		curr = -1;
		String test = "";
		for (int i = 0; i < output.length(); i++) {
			char ch = output.charAt(i);
			chernovik+=ch;
			switch (ch) {
			case '+':
			case '-':
			case '*':
			case '/':
			case '%':
			case 'Q':
			case 'S':
			case 'C':
			case 'T':
			case 'G':
				break;
			default:
				test += ch;
				if (output.charAt(i + 1) != '.' && output.charAt(i)!='.') {
					if (Double.parseDouble(test) == numbers.get(curr + 1)) {
						curr++;
						test = "";
						chernovik += " ";
					}
				}
			}
		}
		steps.add(chernovik);
		output=chernovik;/**/
		test="";
		curr = -1;
		for (int i = 0; i < output.length(); i++) {
			double x;
			char ch = output.charAt(i);
			switch (ch) {
			case '+':
				x=numbers.get(curr - 1) + numbers.get(curr);
				addOper(x, numbers.get(curr - 1), numbers.get(curr), '+');
				numbers.set(curr - 1, x);
				numbers.remove(curr);
				curr--;
				chernovik="";
				for (int j = 0; j <= curr; j++)
					chernovik+=Double.toString(numbers.get(j))+" ";
				for (int j=i+1;j<output.length();j++)
					chernovik+=output.charAt(j);
				steps.add(chernovik);
				break;
			case '-':
				x=numbers.get(curr - 1) - numbers.get(curr);
				addOper(x, numbers.get(curr - 1), numbers.get(curr), '-');
				numbers.set(curr - 1, x);
				numbers.remove(curr);
				curr--;
				chernovik="";
				for (int j = 0; j <= curr; j++)
					chernovik+=Double.toString(numbers.get(j))+" ";
				for (int j=i+1;j<output.length();j++)
					chernovik+=output.charAt(j);
				steps.add(chernovik);
				break;
			case '*':
				x=numbers.get(curr - 1) * numbers.get(curr);
				addOper(x, numbers.get(curr - 1), numbers.get(curr), '*');
				numbers.set(curr - 1, x);
				numbers.remove(curr);
				curr--;
				chernovik="";
				for (int j = 0; j <= curr; j++)
					chernovik+=Double.toString(numbers.get(j))+" ";
				for (int j=i+1;j<output.length();j++)
					chernovik+=output.charAt(j);
				steps.add(chernovik);
				break;
			case '/':
				x=numbers.get(curr - 1) / numbers.get(curr);
				addOper(x, numbers.get(curr - 1), numbers.get(curr), '/');
				numbers.set(curr - 1, x);
				numbers.remove(curr);
				curr--;
				chernovik="";
				for (int j = 0; j <= curr; j++)
					chernovik+=Double.toString(numbers.get(j))+" ";
				for (int j=i+1;j<output.length();j++)
					chernovik+=output.charAt(j);
				steps.add(chernovik);
				break;
			case '%':
				x=numbers.get(curr - 1) % numbers.get(curr);
				addOper(x, numbers.get(curr - 1), numbers.get(curr), '%');
				numbers.set(curr - 1, x);
				numbers.remove(curr);
				curr--;
				chernovik="";
				for (int j = 0; j <= curr; j++)
					chernovik+=Double.toString(numbers.get(j))+" ";
				for (int j=i+1;j<output.length();j++)
					chernovik+=output.charAt(j);
				steps.add(chernovik);
				break;
			case 'Q':
				if (output.charAt(i - 1) == 'Q') {
					x=Math.sqrt(numbers.get(curr));
					addOper(x, numbers.get(curr), 'Q');
					numbers.set(curr, x);
					chernovik="";
					for (int j = 0; j <= curr; j++)
						chernovik+=Double.toString(numbers.get(j))+" ";
					for (int j=i+1;j<output.length();j++)
						chernovik+=output.charAt(j);
					steps.add(chernovik);
				}
				break;
			case 'S':
				if (output.charAt(i - 1) == 'S') {
					x=Math.sin(numbers.get(curr));
					addOper(x, numbers.get(curr), 'S');
					numbers.set(curr, x);
					chernovik="";
					for (int j = 0; j <= curr; j++)
						chernovik+=Double.toString(numbers.get(j))+" ";
					for (int j=i+1;j<output.length();j++)
						chernovik+=output.charAt(j);
					steps.add(chernovik);
				}
				break;
			case 'C':
				if (output.charAt(i - 1) == 'C') {
					x=Math.cos(numbers.get(curr));
					addOper(x, numbers.get(curr), 'C');
					numbers.set(curr, x);
					chernovik="";
					for (int j = 0; j <= curr; j++)
						chernovik+=Double.toString(numbers.get(j))+" ";
					for (int j=i+1;j<output.length();j++)
						chernovik+=output.charAt(j);
					steps.add(chernovik);
				}
				break;
			case 'T':
				if (output.charAt(i - 1) == 'T') {
					x=Math.tan(numbers.get(curr));
					addOper(x, numbers.get(curr), 'T');
					numbers.set(curr, x);
					chernovik="";
					for (int j = 0; j <= curr; j++)
						chernovik+=Double.toString(numbers.get(j))+" ";
					for (int j=i+1;j<output.length();j++)
						chernovik+=output.charAt(j);
					steps.add(chernovik);
					}
				break;
			case 'G':
				if (output.charAt(i - 1) == 'G') {
					x=1/Math.tan(numbers.get(curr));
					addOper(x, numbers.get(curr), 'G');
					numbers.set(curr, x);
					chernovik="";
					for (int j = 0; j <= curr; j++)
						chernovik+=Double.toString(numbers.get(j))+" ";
					for (int j=i+1;j<output.length();j++)
						chernovik+=output.charAt(j);
					steps.add(chernovik);
				}
				break;
			default:
				test += ch;
				if (output.charAt(i + 1) == ' ') {
					if (Double.parseDouble(test) == numbers.get(curr + 1)) {
						curr++;
						test = "";
						i++;/**/
					}
				}
			}
		}
		
		/*for (int i=0;i<steps.size();i++)
		{
			System.out.println(steps.get(i));
		}*/
		DefaultMutableTreeNode top;
		switch (spisok.get(spisok.size()-1).tip) {
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
			top = new DefaultMutableTreeNode(spisok.get(spisok.size()-1).tip);
			break;
		}
		jTree = new JTree(top);
		addNewItem(top, spisok.size()-1,jTree);
		return Double.toString(numbers.get(0));
	}
	
	public void addNewItem(Object obj, int x, JTree jTree) {
		if (spisok.get(x).firstChild!=-1) {
			DefaultTreeModel model = (DefaultTreeModel) jTree.getModel();
			DefaultMutableTreeNode sel = (DefaultMutableTreeNode) obj;
			String name="";
			if (spisok.get(spisok.get(x).firstChild).tip=='n') {
				name = Double.toString(spisok.get(spisok.get(x).firstChild).core);
			}
			else {
				switch (spisok.get(spisok.get(x).firstChild).tip) {
				case 'Q':
					name += "√";
					break;
				case 'S':
					name += "sin";
					break;
				case 'C':
					name += "cos";
					break;
				case 'T':
					name += "tg";
					break;
				case 'G':
					name += "ctg";
					break;
				default:
					name += spisok.get(spisok.get(x).firstChild).tip;
					break;
				}
			}
			DefaultMutableTreeNode tmp = new DefaultMutableTreeNode(name);
			model.insertNodeInto(tmp, sel, sel.getChildCount());
			jTree.expandPath(new TreePath(sel.getPath()));
			addNewItem(tmp, spisok.get(x).firstChild,jTree);
		}
		if (spisok.get(x).secondChild!=-1) {
			DefaultTreeModel model = (DefaultTreeModel) jTree.getModel();
			DefaultMutableTreeNode sel = (DefaultMutableTreeNode) obj;
			String name="";
			if (spisok.get(spisok.get(x).secondChild).tip=='n') {
				name = Double.toString(spisok.get(spisok.get(x).secondChild).core);
			}
			else {
				switch (spisok.get(spisok.get(x).secondChild).tip) {
				case 'Q':
					name += "√";
					break;
				case 'S':
					name += "sin";
					break;
				case 'C':
					name += "cos";
					break;
				case 'T':
					name += "tg";
					break;
				case 'G':
					name += "ctg";
					break;
				default:
					name += spisok.get(spisok.get(x).secondChild).tip;
					break;
				}
			}
			DefaultMutableTreeNode tmp = new DefaultMutableTreeNode(name);
			model.insertNodeInto(tmp, sel, sel.getChildCount());
			jTree.expandPath(new TreePath(sel.getPath()));
			addNewItem(tmp, spisok.get(x).secondChild,jTree);
		}
	}
	
	public JTree getTree()
	{
		return jTree;
	}
	
	public ArrayList<String> getSteps()
	{
		return steps;
	}
 	
	public void gotOper(char opThis, int prec1) {
		while (!theStack.isEmpty()) {
			char opTop = theStack.pop();
			if (opTop == '(') {
				theStack.push(opTop);
				break;
			} else {
				int prec2;
				if (opTop == '+' || opTop == '-')
					prec2 = 1;
				else
					prec2 = 2;
				if (prec2 < prec1) {
					theStack.push(opTop);
					break;
				} else
					output = output + opTop;
			}
		}
		if (opThis != '√')
			theStack.push(opThis);
		else
			theStack.push('Q');
	}

	public void gotParen(char ch) {
		while (!theStack.isEmpty()) {
			char chx = theStack.pop();
			if (chx == '(')
				break;
			else
				output = output + chx;
		}
	}

	public String obrabotka(String input) {
		String output = "";
		for (int i = 0; i < input.length()-1; i++) {
			if (input.charAt(i) == 's' && input.charAt(i + 1) == 'i') {
				output += 'S';
				i += 2;
				continue;
			}
			if (input.charAt(i) == 'c' && input.charAt(i + 1) == 'o') {
				output += 'C';
				i += 2;
				continue;
			}
			if (input.charAt(i) == 't' && input.charAt(i + 1) == 'g') {
				output += 'T';
				i++;
				continue;
			}
			if (input.charAt(i) == 'c' && input.charAt(i + 1) == 't') {
				output += 'G';
				i += 2;
				continue;
			}
			output += input.charAt(i);
		}
		output += input.charAt(input.length()-1);
		return output;
	}
 
	public void addOper(double operation, double fNumb, double sNumb,char znak) {
		int num1=0;
		int num2=0;
		boolean tf1=false;
		for (int i=0;i<spisok.size();i++)
		{
			if (spisok.get(i).core == fNumb && spisok.get(i).parent==-1) {
				tf1=true;
				num1=i;
				break;
				
			}
		}
		boolean tf2=false;
		for (int i=0;i<spisok.size();i++)
		{
			if (spisok.get(i).core==sNumb && spisok.get(i).parent==-1) {
				if (tf1 == true && i == num1 && sNumb == fNumb) {
				} else {
					tf2 = true;
					num2 = i;
					break;
				}
			}
		}
		if (tf1==false) {
			Box test=new Box();
			test.core=fNumb;
			test.firstChild=-1;
			test.secondChild=-1;
			test.tip='n';
			if (tf2==false) test.parent=spisok.size()+2;
			else test.parent=spisok.size()+1;
			spisok.add(test);
		}
		if (tf2==false) {
			Box test=new Box();
			test.core=sNumb;
			test.firstChild=-1;
			test.secondChild=-1;
			test.tip='n';
			test.parent=spisok.size()+1;
			spisok.add(test);
		}
		
		Box test=new Box();
		test.core=operation;
		if (tf1 == false) {
			if (tf2 == false) {
				test.firstChild = spisok.size() - 2;
			}
			else test.firstChild = spisok.size() - 1;
		} else {
			test.firstChild = num1;
			spisok.get(num1).parent=spisok.size();
		}
		if (tf2==false) {
				test.secondChild=spisok.size()-1;
		}
		else {
			test.secondChild=num2;
			spisok.get(num2).parent=spisok.size();
		}
		test.tip=znak;
		test.parent=-1;
		spisok.add(test);
	}
	
	public void addOper(double operation, double fNumb, char znak) {
		boolean tf1=false;
		int num1=0;
		for (int i=0;i<spisok.size();i++)
		{
			if (spisok.get(i).core == fNumb && spisok.get(i).parent==-1) {
				tf1=true;
				num1=i;
				break;
				
			}
		}
		if (tf1==false) {
			Box test=new Box();
			test.core=fNumb;
			test.firstChild=-1;
			test.secondChild=-1;
			test.tip='n';
			test.parent=spisok.size()+1;
			spisok.add(test);
		}
		Box test=new Box();
		test.core=operation;
		if (tf1 == false) {
			test.firstChild = spisok.size() - 1;
		} else {
			test.firstChild = num1;
			spisok.get(num1).parent=spisok.size();
		}
		test.secondChild=-1;
		test.tip=znak;
		test.parent=-1;
		spisok.add(test);
	}
}