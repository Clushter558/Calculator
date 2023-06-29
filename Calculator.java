import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class Calculator implements ActionListener
{
    String str1="";
    String str2="";
    JTextField jt1 = new JTextField();
    JTextField jt2 = new JTextField();
    JButton numbutton[] = new JButton[10];
    JButton plus = new JButton("+");
    JButton subtract = new JButton("-");
    JButton divide = new JButton("/");
    JButton multiply = new JButton("*");
    JButton clear = new JButton("Clear");
    JButton total = new JButton("=");
    JButton zero = new JButton("0");
    Calculator()
    {
        JFrame frame = new JFrame();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel row0 = new JPanel();
        JPanel row1 = new JPanel();
        JPanel row2 = new JPanel();
        JPanel row3 = new JPanel();
        JPanel row4 = new JPanel();
        JPanel row5 = new JPanel();
        
        
        for(int i=9;i>0;i--)
        {
            numbutton[i]=new JButton(Integer.toString(i));
        }
        
        
        for(int i=9;i>0;i--)
        {
            if(i<=9 && i>=7)
            row2.add(numbutton[i]);
            if(i<=6 && i>=4)
            row3.add(numbutton[i]);
            if(i<=3 && i>=1)
            row4.add(numbutton[i]);
        }
        row2.add(divide);
        row3.add(multiply);
        row4.add(subtract);
        row5.add(zero);
        row5.add(clear);
        row5.add(total);
        row5.add(plus);
        row1.add(jt1,BorderLayout.CENTER);
        row0.add(jt2,BorderLayout.CENTER);
        
        
        jt1.setText("0");
        jt2.setText("0 \t \t \t \t \t \t \t ");
        panel2.add(row0);
        panel2.add(row1);
        panel1.add(row2);
        panel1.add(row3);
        panel1.add(row4);
        panel1.add(row5);
        frame.add(panel2);
        frame.add(panel1);
        
        
        row1.setLayout(new GridLayout(1,4));
        row2.setLayout(new GridLayout(1,4));
        row3.setLayout(new GridLayout(1,4));
        row4.setLayout(new GridLayout(1,4));
        row5.setLayout(new GridLayout(1,4));
        panel1.setLayout(new GridLayout(4,1));
        panel2.setLayout(new GridLayout(2,1));
        frame.setLayout(new GridLayout(2,1));
        
        frame.setSize(600,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        
        plus.addActionListener(this);
        multiply.addActionListener(this);
        subtract.addActionListener(this);
        divide.addActionListener(this);
        clear.addActionListener(this);
        total.addActionListener(this);
        for(int i=9;i>0;i--)
        {
            numbutton[i].addActionListener(this);
        }
    }
    public double calculate(String str)
    {
        double sum=0;
        double num1=0;
        char ch='a';
        StringTokenizer st=new StringTokenizer(str," ");
        num1=Double.valueOf(st.nextToken());
        ch=st.nextToken().charAt(0);
        {
            if(ch == '+')
            sum=num1+Double.valueOf(st.nextToken());
            if(ch == '*')
            sum=num1*Double.valueOf(st.nextToken());
            if(ch == '-')
            sum=num1-Double.valueOf(st.nextToken());
            if(ch == '/')
            sum=num1/Double.valueOf(st.nextToken());
        }
        return sum;
    }
    public void actionPerformed(ActionEvent e)
    {
        int ct=0;
        for(int i=1;i<10;i++)
        {
            if(e.getSource() == numbutton[i])
            {
                str1 = str1 + Integer.toString(i);
                ct=1;
            }
        }
        if(ct==0)
        {
            if(e.getSource() == plus)
            str1 = str1 + " + ";
            if(e.getSource() == multiply)
            str1 = str1 + " * ";
            if(e.getSource() == divide)
            str1 = str1 + " / ";
            if(e.getSource() == subtract)
            str1 = str1 + " - ";
            if(e.getSource() == zero)
            str1 = str1 + "0";
            if(e.getSource() == clear)
            {
                str1="";
                str2="0 \t \t \t \t \t \t \t ";
            }
            if(e.getSource() == total)
            {
                str2=str1;
                str1 = calculate(str1) + "";
            }
        }
        jt1.setText(str1);
        jt2.setText(str2);
    }
    public static void main(String args[])
    {
        Calculator obj = new Calculator();
    }
}