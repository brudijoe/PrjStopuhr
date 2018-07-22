import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import edu.princeton.cs.introcs.StdIn;

public class StopuhrGUI {
	
	//Anzeige tfTime
	static String display = "00:00:00";
	
	static JFrame mainWindow = new JFrame("Stopuhr");
	static JPanel btPanel = new JPanel();
	static JPanel clPanel = new JPanel(); //cl = calculate
	static JPanel tfPanel = new JPanel();
	static JLabel lblTime = new JLabel("Time: ");
	static JTextField tfTime = new JTextField("00:00:00");
	static JButton btStartTimer = new JButton("Start");
	static JButton btClearTimer = new JButton("Clear");
	static JButton btStopTimer = new JButton("Stop");
	
	//Buttons 0-9
	static JButton btZero = new JButton("0");
	static JButton btOne = new JButton("1");
	static JButton btTwo = new JButton("2");
	static JButton btThree = new JButton("3");
	static JButton btFour = new JButton("4");
	static JButton btFive = new JButton("5");
	static JButton btSix = new JButton("6");
	static JButton btSeven = new JButton("7");
	static JButton btEight = new JButton("8");
	static JButton btNine = new JButton("9");
	
	public static void main(String[] args) throws InterruptedException {
		
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//HauptGridbagLayout
		mainWindow.add(btPanel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		btPanel.setLayout(gbl_panel);
		
		//Button Zero
		GridBagConstraints gbc_btZero = new GridBagConstraints();
		gbc_btZero.insets = new Insets(0, 0, 0, 0);
		gbc_btZero.anchor = GridBagConstraints.EAST;
		gbc_btZero.gridx = 0;
		gbc_btZero.gridy = 0;
		btPanel.add(btZero, gbc_btZero);
		
		//Button One
		GridBagConstraints gbc_btOne = new GridBagConstraints();
		gbc_btOne.insets = new Insets(0, 0, 0, 0);
		gbc_btOne.anchor = GridBagConstraints.EAST;
		gbc_btOne.gridx = 1;
		gbc_btOne.gridy = 0;
		btPanel.add(btOne, gbc_btOne);
		
		//Button Two
		GridBagConstraints gbc_btTwo = new GridBagConstraints();
		gbc_btTwo.insets = new Insets(0, 0, 0, 0);
		gbc_btTwo.anchor = GridBagConstraints.EAST;
		gbc_btTwo.gridx = 2;
		gbc_btTwo.gridy = 0;
		btPanel.add(btTwo, gbc_btTwo);
		
		//Button Three
		GridBagConstraints gbc_btThree = new GridBagConstraints();
		gbc_btThree.insets = new Insets(0, 0, 0, 0);
		gbc_btThree.anchor = GridBagConstraints.EAST;
		gbc_btThree.gridx = 3;
		gbc_btThree.gridy = 0;
		btPanel.add(btThree, gbc_btThree);
		
		//Button Four
		GridBagConstraints gbc_btFour = new GridBagConstraints();
		gbc_btFour.insets = new Insets(0, 0, 0, 0);
		gbc_btFour.anchor = GridBagConstraints.EAST;
		gbc_btFour.gridx = 4;
		gbc_btFour.gridy = 0;
		btPanel.add(btFour, gbc_btFour);
		
		//Button Five
		GridBagConstraints gbc_btFive = new GridBagConstraints();
		gbc_btFive.insets = new Insets(0, 0, 0, 0);
		gbc_btFive.anchor = GridBagConstraints.EAST;
		gbc_btFive.gridx = 0;
		gbc_btFive.gridy = 1;
		btPanel.add(btFive, gbc_btFive);
		
		//Button Six
		GridBagConstraints gbc_btSix = new GridBagConstraints();
		gbc_btSix.insets = new Insets(0, 0, 0, 0);
		gbc_btSix.anchor = GridBagConstraints.EAST;
		gbc_btSix.gridx = 1;
		gbc_btSix.gridy = 1;
		btPanel.add(btSix, gbc_btSix);
		
		//Button Seven
		GridBagConstraints gbc_btSeven = new GridBagConstraints();
		gbc_btSeven.insets = new Insets(0, 0, 0, 0);
		gbc_btSeven.anchor = GridBagConstraints.EAST;
		gbc_btSeven.gridx = 2;
		gbc_btSeven.gridy = 1;
		btPanel.add(btSeven, gbc_btSeven);
		
		//Button Eight
		GridBagConstraints gbc_btEight = new GridBagConstraints();
		gbc_btEight.insets = new Insets(0, 0, 0, 0);
		gbc_btEight.anchor = GridBagConstraints.EAST;
		gbc_btEight.gridx = 3;
		gbc_btEight.gridy = 1;
		btPanel.add(btEight, gbc_btEight);
		
		//Button Nine
		GridBagConstraints gbc_btNine = new GridBagConstraints();
		gbc_btNine.insets = new Insets(0, 0, 0, 0);
		gbc_btNine.anchor = GridBagConstraints.EAST;
		gbc_btNine.gridx = 4;
		gbc_btNine.gridy = 1;
		btPanel.add(btNine, gbc_btNine);
		
		//Buttons Start, Clear, Stop
		mainWindow.add(clPanel, BorderLayout.CENTER);
		clPanel.add(btStartTimer);
		clPanel.add(btClearTimer);
		clPanel.add(btStopTimer);
		
		mainWindow.add(tfPanel, BorderLayout.SOUTH);
		tfPanel.add(lblTime);
		tfPanel.add(tfTime);
		tfTime.setPreferredSize(new Dimension(80,20));
		
		btZero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				display = tfTime.getText();
				tfTime.setText(display + "0");
			}	
		});
		
		btOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				display = tfTime.getText();
				tfTime.setText(display + "1");
			}	
		});
		
		btTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				display = tfTime.getText();
				tfTime.setText(display + "2");
			}	
		});
		
		btThree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				display = tfTime.getText();
				tfTime.setText(display + "3");
			}	
		});
		
		btFour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				display = tfTime.getText();
				tfTime.setText(display + "4");
			}	
		});
		
		btFive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				display = tfTime.getText();
				tfTime.setText(display + "5");
			}	
		});
		
		btSix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				display = tfTime.getText();
				tfTime.setText(display + "6");
			}	
		});
		
		btSeven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				display = tfTime.getText();
				tfTime.setText(display + "7");
			}	
		});
		
		btEight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				display = tfTime.getText();
				tfTime.setText(display + "8");
			}	
		});
		
		btNine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				display = tfTime.getText();
				tfTime.setText(display + "9");
			}	
		});
		
		btStartTimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int seconds = Integer.parseInt(tfTime.getText());
//				int minutes = Integer.parseInt(tfTime.getText());
//				int hours = Integer.parseInt(tfTime.getText());
				
				for(int count = 1; count <= seconds /*+ (minutes*60) + (hours*3600)*/; count++) {
					System.out.println(count);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}		
				}
			}	
		});
		
		btClearTimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tfTime.setText("");
			}	
		});
		
		mainWindow.pack();
		mainWindow.setVisible(true);
		
		Dimension d = mainWindow.getSize();
		mainWindow.setMinimumSize(d);
		
	}

}
