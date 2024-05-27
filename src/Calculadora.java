import javax.swing.*;
import java.awt.*;
import java.awt.event.*;





public class Calculadora implements ActionListener {
	
	JFrame frame;
	JTextField textfield;
	JButton[] numberButtons= new JButton[10];
	JButton[] operatorButtons= new JButton[9];
	JButton sumBtn,restaBtn,multBtn,divBtn;
	JButton decBtn,igualBtn,delBtn,clrBtn,negBtn;
	JPanel panel;
	
	Font font = new Font("Calibri",Font.BOLD,30);
	
	double num1=0,num2=0,result=0;
	char operator;
	
	
	
	
	Calculadora(){
		
		//botones
		sumBtn= new JButton("+");
		restaBtn= new JButton("-");
		multBtn= new JButton("x");
		divBtn= new JButton("÷");
		decBtn= new JButton(".");
		igualBtn= new JButton("=");
		delBtn= new JButton("Delete");
		clrBtn= new JButton("Clear");
		operatorButtons[0]=sumBtn;
		operatorButtons[1]=restaBtn;
		operatorButtons[2]=multBtn;
		operatorButtons[3]=divBtn;
		operatorButtons[4]=decBtn;
		operatorButtons[5]=igualBtn;
		operatorButtons[6]=delBtn;
		operatorButtons[7]=clrBtn;		
		negBtn= new JButton("(-)");
		operatorButtons[8]=negBtn;
		
		for(int i=0;i<9;i++) {
			operatorButtons[i].addActionListener(this);
			operatorButtons[i].setFont(font);
			operatorButtons[i].setFocusable(false);
		}
		for(int i =0;i<=9;i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(font);
			numberButtons[i].setFocusable(false);

		}
		negBtn.setBounds(50,430,100,50);
		delBtn.setBounds(150,430,100,50);
		clrBtn.setBounds(250,430,100,50);
		
		//panel
		panel = new JPanel();
		panel.setBounds(50,100,300,300);
		panel.setLayout(new GridLayout(4,4,0,0));
		panel.setBackground(Color.GRAY);
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(sumBtn);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(restaBtn);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(multBtn);
		panel.add(decBtn);
		panel.add(numberButtons[0]);
		panel.add(igualBtn);
		panel.add(divBtn);		
		
		
		//calculadora
		frame = new JFrame();
		frame.setSize(420,550);
		frame.setTitle("Calculadora");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		textfield = new JTextField();
		textfield.setSize(300,50);
		textfield.setLocation(53,10);
		textfield.setEditable(false);
		textfield.setFont(font);
		
		frame.add(panel);
		frame.add(textfield);
		frame.add(delBtn);
		frame.add(negBtn);
		frame.add(clrBtn);
		frame.setVisible(true);

	}
	
	
	public static void main(String[] args) {
		
		Calculadora calc = new Calculadora();
		
	}


	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i =0; i<=9;i++) {
			if(e.getSource()==numberButtons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		
		if(e.getSource()==clrBtn) {
			textfield.setText("");
		}
		if(e.getSource()==sumBtn) {
			num1= Double.parseDouble(textfield.getText());
			operator ='+';
			textfield.setText("");
			
		}
		if(e.getSource()==restaBtn) {
			num1= Double.parseDouble(textfield.getText());
			operator ='-';
			textfield.setText("");
			
		}
		if(e.getSource()==multBtn) {
			num1= Double.parseDouble(textfield.getText());
			operator ='x';
			textfield.setText("");
			
		}
		if(e.getSource()==divBtn) {
			num1= Double.parseDouble(textfield.getText());
			operator ='÷';
			textfield.setText("");
			
		}
		
		if(e.getSource()==igualBtn) {
			num2= Double.parseDouble(textfield.getText());
			switch(operator) {
			case '+':
				result=num1+num2;
				break;
			case '-':
				result=num1-num2;
				break;
			case 'x':
				result=num1*num2;
				break;
			case '÷':
				result= num1/num2;
				break;
			}
			
			textfield.setText(String.valueOf(result));	
			num1=result;
		}
		
		if(e.getSource()==delBtn) {
			String st =textfield.getText();
			st = st.substring(0,st.length()-1);
			textfield.setText(st);
		}
		
		if(e.getSource()==decBtn) {
			textfield.setText(textfield.getText().concat("."));
		}
		
		if(e.getSource()==negBtn) {
			textfield.setText(textfield.getText().concat("-"));
		}
		
		
		
		
		
	}
		
		
	}


