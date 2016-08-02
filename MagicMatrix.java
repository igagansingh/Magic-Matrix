/*
* by GAGANDEEP SINGH
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class MagicMatrix implements ActionListener
{
	JFrame mainFrame;	//Main frame.
	JButton matrixButtons[][],reset; //reset to set the buttons from changed position to default.
	JTextArea selectedNumbers,sumDisplay; 
	JPanel panelOne,panelTwo;
	JLabel basicInfo;
	int sum,num=0;
	int buttonText=0;
	MagicMatrix(String s)
	{

		mainFrame = new JFrame(s);
		basicInfo = new JLabel("<html>MAGIC MATRIX IS A FAMOUS MATHEMATICAL TRICK WHICH AMAZES ANYONE WHO USES IT.CROSS OFF NUMBERS ONE BY ONE AND TRY IT MULTIPLE TIMES , YOU'LL END UP WITH SAME NUMBER EVERYTIME - 65(here). HAVE FUN ! </html>");
		panelOne  = new JPanel(new GridLayout(4,1,5,5));
		panelTwo  = new JPanel(new  GridLayout(5,5,5,5));
		matrixButtons = new JButton[5][5];
		reset=new JButton("RESET");
		reset.setFont(new Font("Serif", Font.PLAIN, 20));
		reset.addActionListener(this);
		selectedNumbers=new JTextArea("Numbers selected : ");
		selectedNumbers.setFont(new Font("Serif", Font.PLAIN, 20));
		selectedNumbers.setEditable(false);
		sumDisplay=new JTextArea("SUM");
		sumDisplay.setFont(new Font("Serif", Font.PLAIN, 20));
		sumDisplay.setEditable(false);
		panelOne.add(basicInfo);
		panelOne.add(reset);
		panelOne.add(selectedNumbers);
		panelOne.add(sumDisplay);
		for(int i=0;i<matrixButtons.length;i++)
		{
			for(int j=0;j<matrixButtons[0].length;j++)
			{
				buttonText++;
				matrixButtons[i][j]=new JButton(Integer.toString(buttonText));
				matrixButtons[i][j].addActionListener(this);
				panelTwo.add(matrixButtons[i][j]);
			}
		}
		mainFrame.add(panelOne);
		mainFrame.add(panelTwo);
		mainFrame.setLayout(new GridLayout(2,1));
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(500,500);
		mainFrame.setVisible(true);
	}
	public void setButtons()
	{
		for(int i=0;i<matrixButtons.length;i++)
		{
			for(int j=0;j<matrixButtons[0].length;j++)
			{
				matrixButtons[i][j].setEnabled(true);
			}
		}
	}
	public void actionPerformed(ActionEvent e) 
	{
		int i=0,j=0,number=0,k=0;
		int r=0;
		int c=0;
		for(i=0;i<matrixButtons.length;i++)
		{
			for(j=0;j<matrixButtons[0].length;j++)
			{
				number++;
				if(e.getSource()==matrixButtons[i][j])
					{
						num++;
						selectedNumbers.append(Integer.toString(number));
						c=i;
						r=j;
						sum+=number;
						if(num!=5)
						{
							selectedNumbers.append(" + ");
						}
						sumDisplay.setText(Integer.toString(sum));
						for(k=0;k<5;k++)
						{
							matrixButtons[c][k].setEnabled(false);
							matrixButtons[k][r].setEnabled(false);
						}
					}
			}
		}
		if(e.getSource()==reset)
		{
			setButtons();
			sum=0;
			num=0;
			selectedNumbers.setText("Numbers selected : ");
			sumDisplay.setText("SUM");
		}
	}
	public static void main(String s[])
	{
		new MagicMatrix("Magic Matrix");
	}
}