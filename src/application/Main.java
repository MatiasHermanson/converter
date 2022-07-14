package application;

import javafx.application.Application;
import javafx.stage.Stage;
import java.awt.event.*;
import javax.swing.*;

public class Main extends Application {
	static class A{

	   public static double round(double value, int places) {
	   if (places < 0) throw new IllegalArgumentException();

	   long factor = (long) Math.pow(10, places);
	   value = value * factor;
	   long tmp = Math.round(value);
	   return (double) tmp / factor;
	   }
	   public static void main(String[] args) {
	       JFrame f = new JFrame();
	       JLabel label1 = new JLabel("Miles");
	       JLabel label2 = new JLabel("KiloMeters");
	       JTextField text1 = new JTextField(10);
	       JTextField text2 = new JTextField(10);
	       JRadioButton radio1=new JRadioButton("Miles - KiloMeters");
	       radio1.setSelected(true);   
	       JRadioButton radio2=new JRadioButton("Celsius and Fahrenheit");
	       JRadioButton radio3=new JRadioButton("Pounds and Kilograms");   
	       ButtonGroup b = new ButtonGroup();
	       b.add(radio1);b.add(radio2);b.add(radio3);
	       Action action1 = new AbstractAction()
	       {
	       @Override
	       public void actionPerformed(ActionEvent e)
	       {
	       double input1 = Integer.parseInt(text1.getText());
	       double input2=0.0;
	       if(radio1.isSelected()){
	           input2 = input1 * 1.609344;
	       }
	       else if(radio2.isSelected()){
	           input2 = (input1 * (1.8) + 32) ;
	       }
	       else if(radio3.isSelected()){
	           input2 = input1 * 0.45359237;
	       }
	       input2 = round(input2,2);
	       text2.setText(input2+"");
	       }
	       };
	       Action action2 = new AbstractAction()
	       {
	       @Override
	       public void actionPerformed(ActionEvent e)
	       {
	       double label1 = Integer.parseInt(text2.getText());
	       double label2=0.0;
	       if(radio1.isSelected()){
	           label2 = label1 / 1.609344;
	       }
	       else if(radio2.isSelected()){
	           label2 = (label1 * (1.8)) + 32;
	       }
	       else if(radio3.isSelected()){
	           label1 = label1 / 0.45359237;
	       }
	       label2 = round(label2,2);
	       text1.setText(label2+"");
	       }
	       };
	       text1.addActionListener( action1 );
	       text2.addActionListener( action2 );
	       JPanel p = new JPanel();
	       p.add(label1);
	       p.add(text1);
	       p.add(label2);
	       p.add(text2);
	       p.add(radio1);
	       p.add(radio2);
	       p.add(radio3);
	       f.add(p);
	       radio1.addItemListener(new ItemListener()
	       {
	       public void itemStateChanged(ItemEvent e)
	       {
	       if(radio1.isSelected()){
	           label1.setText("Miles");
	           label2.setText("KiloMeters");
	       }
	       }
	       });

	       radio2.addItemListener(new ItemListener()
	       {
	       public void itemStateChanged(ItemEvent e)
	       {
	       if(radio2.isSelected()){
	           label1.setText("Celsius");
	           label2.setText("Fahrenheit");
	       }
	       }
	       });

	       radio3.addItemListener(new ItemListener()
	       {
	       public void itemStateChanged(ItemEvent e)
	       {
	       if(radio3.isSelected()){
	           label1.setText("Pounds");
	           label2.setText("Kilograms");
	       }
	       }
	       });
	       f.setSize(500,500);
	       f.setVisible(true);
	   }
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}
}