package kalculatorPac;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTree;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JTextField textField;
	private ArrayList<String> steps;
	private JTree jTree;
	private JTree jTree2;

 	public MainFrame() {
		this.setSize(345, 280);
		this.setLocationRelativeTo(null);
		this.setTitle("Калькулятор");
		this.setResizable(false);
		this.setLayout(null);
		panel = new JPanel();
		JMenuBar menuBar = new JMenuBar();
		JMenu searchMenu = new JMenu("Вид");
		JMenu menuAbout = new JMenu("Справка");
		JMenuItem first = new JMenuItem("Обычный");
		JMenuItem second = new JMenuItem("Инженерный");
		JMenuItem third = new JMenuItem("О программе");
		searchMenu.add(first);
		searchMenu.add(second);
		menuAbout.add(third);
		menuBar.add(searchMenu);
		menuBar.add(menuAbout);
		this.setJMenuBar(menuBar);
		setFirstContent();
		this.setContentPane(panel);
		first.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				setFirstContent();
				setContentPane(panel);
			}
		});
		second.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				setSecondContent();
				setContentPane(panel);
			}
		});
		third.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"ХУЙ ПИЗДА СКОВОРОДА НАШ НАСТАВНИК ДЖИГУРДА! "
						+ "НАХУЙ ТЫ ЗАЛЕЗ СЮДА, ВОЛОСАТАЯ ПИЗДА???");
			}
		});
	}

	public void setFirstContent() {
		this.setSize(345, 270);
		panel.setLayout(null);
		textField = new JTextField("");
		textField.setBounds(5, 10, 330, 30);
		JButton butShowTree = new JButton("показать дерево вычислений");
		JButton showActions = new JButton("показать по действиям");
		butShowTree.setBounds(5, 200, 330, 30);
		showActions.setBounds(5, 235, 330, 30);
		JButton but1 = new JButton("1");
		JButton but2 = new JButton("2");
		JButton but3 = new JButton("3");
		JButton but4 = new JButton("4");
		JButton but5 = new JButton("5");
		JButton but6 = new JButton("6");
		JButton but7 = new JButton("7");
		JButton but8 = new JButton("8");
		JButton but9 = new JButton("9");
		JButton but0 = new JButton("0");
		JButton butDrob = new JButton(".");
		JButton butPlus = new JButton("+");
		JButton butMinus = new JButton("-");
		JButton butProiz = new JButton("*");
		JButton butDel = new JButton("/");
		JButton butSqrt = new JButton("√");	
		JButton butOneNaX = new JButton("1/x");	
		JButton butOstatok = new JButton("%");	
		JButton butRavno = new JButton("=");
		JButton clear = new JButton("C");
		JButton skobaF = new JButton("(");
		JButton skobaL = new JButton(")");
		but7.setBounds(5, 60, 45, 30);
		but8.setBounds(60, 60, 45, 30);
		but9.setBounds(115, 60, 45, 30);
		but4.setBounds(5, 95, 45, 30);
		but5.setBounds(60, 95, 45, 30);
		but6.setBounds(115, 95, 45, 30);
		but1.setBounds(5, 130, 45, 30);
		but2.setBounds(60, 130, 45, 30);
		but3.setBounds(115, 130, 45, 30);
		but0.setBounds(5, 165, 100, 30);
		butDrob.setBounds(115, 165, 45, 30);
		butPlus.setBounds(170, 130, 45, 30);
		butMinus.setBounds(170, 165, 45, 30);
		butDel.setBounds(170, 60, 45, 30);
		butProiz.setBounds(170, 95, 45, 30);
		butRavno.setBounds(225, 130, 45, 65);
		butSqrt.setBounds(225, 60, 45, 30);
		butOstatok.setBounds(225, 95, 45, 30);
		butOneNaX.setBounds(280, 165, 55, 30);
		skobaF.setBounds(280, 95, 55, 30);
		skobaL.setBounds(280, 130, 55, 30);
		clear.setBounds(280, 60, 55, 30);
		panel.add(textField);
		panel.add(but7);
		panel.add(but8);
		panel.add(but9);
		panel.add(but4);
		panel.add(but5);
		panel.add(but6);
		panel.add(but1);
		panel.add(but2);
		panel.add(but3);
		panel.add(but0);
		panel.add(butDrob);
		panel.add(butPlus);
		panel.add(butMinus);
		panel.add(butProiz);
		panel.add(butDel);
		panel.add(butRavno);
		panel.add(butSqrt);
		panel.add(butOstatok);
		panel.add(butOneNaX);
		panel.add(clear);
		panel.add(skobaF);
		panel.add(skobaL);
		but1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add("1");
			}
		});
		but2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add("2");
			}
		});
		but3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add("3");
			}
		});
		but4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add("4");
			}
		});
		but5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add("5");
			}
		});
		but6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add("6");
			}
		});
		but7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add("7");
			}
		});
		but8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add("8");
			}
		});
		but9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add("9");
			}
		});
		but0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add("0");
			}
		});
		butDrob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add(".");
			}
		});
		butPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add("+");
			}
		});
		butMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add("-");
			}
		});
		butProiz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add("*");
			}
		});
		butDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add("/");
			}
		});
		butOstatok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add("%");
			}
		});
		skobaF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add("(");
			}
		});
		skobaL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add(")");
			}
		});
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
			}
		});
		butRavno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				makeThis();
				panel.add(butShowTree);
				panel.add(showActions);
			}
		});
		butSqrt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add("√");
			}
		});
		butOneNaX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add("1/(");
			}
		});
		butShowTree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showTree();
			}
		});
		showActions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				makeForActions();
			}
		});
	}
	
	public void setSecondContent() {
		this.setSize(345, 300);
		panel.setLayout(null);
		textField = new JTextField("");
		textField.setBounds(5, 10, 330, 30);
		JButton butShowTree = new JButton("показать дерево вычислений");
		JButton showActions = new JButton("показать по действиям");
		butShowTree.setBounds(5, 235, 330, 30);
		showActions.setBounds(5, 270, 330, 30);
		JButton butSin = new JButton("sin");
		JButton butCos = new JButton("cos");
		JButton butTan = new JButton("tg");
		JButton butCot = new JButton("ctg");
		JButton but1 = new JButton("1");
		JButton but2 = new JButton("2");
		JButton but3 = new JButton("3");
		JButton but4 = new JButton("4");
		JButton but5 = new JButton("5");
		JButton but6 = new JButton("6");
		JButton but7 = new JButton("7");
		JButton but8 = new JButton("8");
		JButton but9 = new JButton("9");
		JButton but0 = new JButton("0");
		JButton butDrob = new JButton(".");
		JButton butPlus = new JButton("+");
		JButton butMinus = new JButton("-");
		JButton butProiz = new JButton("*");
		JButton butDel = new JButton("/");
		JButton butSqrt = new JButton("√");	
		JButton butOneNaX = new JButton("1/x");	
		JButton butOstatok = new JButton("%");	
		JButton butRavno = new JButton("=");
		JButton clear = new JButton("C");
		JButton skobaF = new JButton("(");
		JButton skobaL = new JButton(")");
		but7.setBounds(5, 60, 45, 30);
		but8.setBounds(60, 60, 45, 30);
		but9.setBounds(115, 60, 45, 30);
		but4.setBounds(5, 95, 45, 30);
		but5.setBounds(60, 95, 45, 30);
		but6.setBounds(115, 95, 45, 30);
		but1.setBounds(5, 130, 45, 30);
		but2.setBounds(60, 130, 45, 30);
		but3.setBounds(115, 130, 45, 30);
		but0.setBounds(5, 165, 100, 30);
		butDrob.setBounds(115, 165, 45, 30);
		butPlus.setBounds(170, 130, 45, 30);
		butMinus.setBounds(170, 165, 45, 30);
		butDel.setBounds(170, 60, 45, 30);
		butProiz.setBounds(170, 95, 45, 30);
		butRavno.setBounds(225, 130, 45, 65);
		butSqrt.setBounds(225, 60, 45, 30);
		butOstatok.setBounds(225, 95, 45, 30);
		butOneNaX.setBounds(280, 165, 55, 30);
		skobaF.setBounds(280, 95, 55, 30);
		skobaL.setBounds(280, 130, 55, 30);
		clear.setBounds(280, 60, 55, 30);
		butSin.setBounds(5, 200, 55, 30);
		butCos.setBounds(65, 200, 55, 30);
		butTan.setBounds(125, 200, 55, 30);
		butCot.setBounds(185, 200, 55, 30);
		panel.add(textField);
		panel.add(but7);
		panel.add(but8);
		panel.add(but9);
		panel.add(but4);
		panel.add(but5);
		panel.add(but6);
		panel.add(but1);
		panel.add(but2);
		panel.add(but3);
		panel.add(but0);
		panel.add(butDrob);
		panel.add(butPlus);
		panel.add(butMinus);
		panel.add(butProiz);
		panel.add(butDel);
		panel.add(butRavno);
		panel.add(butSqrt);
		panel.add(butOstatok);
		panel.add(butOneNaX);
		panel.add(clear);
		panel.add(skobaF);
		panel.add(skobaL);
		panel.add(butSin);
		panel.add(butCos);
		panel.add(butTan);
		panel.add(butCot);
		but1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add("1");
			}
		});
		but2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add("2");
			}
		});
		but3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add("3");
			}
		});
		but4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add("4");
			}
		});
		but5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add("5");
			}
		});
		but6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add("6");
			}
		});
		but7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add("7");
			}
		});
		but8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add("8");
			}
		});
		but9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add("9");
			}
		});
		but0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add("0");
			}
		});
		butDrob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add(".");
			}
		});
		butPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add("+");
			}
		});
		butMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add("-");
			}
		});
		butProiz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add("*");
			}
		});
		butDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add("/");
			}
		});
		butOstatok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add("%");
			}
		});
		skobaF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add("(");
			}
		});
		skobaL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add(")");
			}
		});
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
			}
		});
		butRavno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				makeThis();
				panel.add(butShowTree);
				panel.add(showActions);
			}
		});
		butSqrt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add("√");
			}
		});
		butOneNaX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add("1/(");
			}
		});
		butSin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add("sin(");
			}
		});
		butCos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add("cos(");
			}
		});
		butTan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add("tg(");
			}
		});
		butCot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add("ctg(");
			}
		});
		butShowTree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showTree();
			}
		});
		showActions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				makeForActions();
			}
		});
	}

	private void add(String s) {
		textField.setText(textField.getText()+s);
	}
	
	private void makeThis()
	{
		String input=textField.getText();
		String output;
		InToPost theTrans = new InToPost(input);
		output = theTrans.doTrans();
		jTree=theTrans.getTree();
		steps=theTrans.getSteps();
		int x=this.getHeight();
		if (x==270) this.setSize(345, x+60);
		if (x==300) this.setSize(345, x+60);
		textField.setText(output);
	}

	private void makeForActions()
	{
		JFrame actionsFrame = new JFrame();
		JPanel treePanel = new JPanel();
		JTextField treeTextField=new JTextField();
		treePanel.setBounds(1, 1, 399, 348);
		actionsFrame.setSize(400, 350);
		actionsFrame.setLocation(700, 200);
		actionsFrame.setVisible(true);
		actionsFrame.setLayout(null);
		ForActions forActions = new ForActions(steps);
		jTree2=forActions.getTree();
		treeTextField.setText(forActions.getText());
		JButton but1 = new JButton("Свернуть");
		JButton but2 = new JButton("Развернуть");
		treePanel.add(treeTextField);
		treePanel.add(jTree2);
		treePanel.add(but1);
		treePanel.add(but2);
		actionsFrame.setContentPane(treePanel);
		but1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				forActions.actionDown();
				actionsFrame.getContentPane().removeAll();
				jTree2=forActions.getTree();
				treeTextField.setText(forActions.getText());
				treePanel.add(treeTextField);
				treePanel.add(jTree2);
				treePanel.add(but1);
				treePanel.add(but2);
				actionsFrame.setContentPane(treePanel);
			}
		});
		but2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				forActions.actionUp();
				actionsFrame.getContentPane().removeAll();
				jTree=forActions.getTree();
				treeTextField.setText(forActions.getText());
				treePanel.add(treeTextField);
				treePanel.add(jTree);
				treePanel.add(but1);
				treePanel.add(but2);
				actionsFrame.setContentPane(treePanel);
			}
		});
	}
	
	private void showTree()
	{
		JFrame treeFrame = new JFrame();
		treeFrame.setSize(400, 350);
		treeFrame.setLocation(700, 200);
		treeFrame.setVisible(true);
		treeFrame.add(jTree);
	}
}