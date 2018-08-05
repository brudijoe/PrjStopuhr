
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;

public class Test4 extends TimerTask {
	
	static JFrame mainWindow = new JFrame();
	static JPanel tfPanel = new JPanel();
	static JPanel btPanel = new JPanel();
	static JLabel lblTime = new JLabel("Zeit: ");
	static JTextField tfHour = new JTextField("" + 0);
	static JTextField tfMinute = new JTextField("" + 0);
	static JTextField tfSecond = new JTextField("" + 0);
	static JButton btStart = new JButton("Starte Timer");
	static JButton btStop = new JButton("Stoppe Timer");
	
	static int seconds = 0;
	static int minutes = 0;
	static int hours = 0;
	static int count = 0;
    static Timer timer;

    @Override
    public void run(){

    	for(count = seconds + (minutes*60) + (hours*3600); count >= 0; count--) {
		
			tfSecond.setText(""+seconds--);
		
			
			if(count % 3600 == 0) {
				tfHour.setText(""+(hours-1));
				tfMinute.setText(""+(minutes=60));
				tfSecond.setText(""+(seconds=60));
    			hours--;
    			seconds--;
			}
    
    		//Wechsel von Minuten auf Sekunden
    		if(count % 60 == 0 && minutes != 0) {
    			tfMinute.setText(""+(minutes-1));
    			tfSecond.setText(""+(seconds=60));
    			minutes--;
    			seconds--;
    		}
			
			String test = Integer.toString(count);
			System.out.println(count);
		
			if(count == 0) {
				tfHour.setText(""+0);
				tfMinute.setText(""+0);
				tfSecond.setText(""+0);
				System.out.println("Timer beendet.");
				timer.cancel();
				try {
					//wieder aktivieren bei Vollständigen Programm
					//testSound();
				} catch (Exception e) {
					System.out.println("Konnte Sound nicht abspielen.");
				}
				}
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}		
    	}

    }
	
	public static void main(String[] args) {
		
		mainWindow.add(tfPanel, BorderLayout.NORTH);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		tfPanel.add(lblTime);
		lblTime.setFont(new Font("Consolas", Font.PLAIN, 20));
		tfPanel.add(tfHour);
		tfHour.setPreferredSize(new Dimension(30,40));
		tfHour.setFont(new Font("Consolas", Font.PLAIN, 20));
		tfPanel.add(tfMinute);
		tfMinute.setPreferredSize(new Dimension(30,40));
		tfMinute.setFont(new Font("Consolas", Font.PLAIN, 20));
		tfPanel.add(tfSecond);
		tfSecond.setPreferredSize(new Dimension(30,40));
		tfSecond.setFont(new Font("Consolas", Font.PLAIN, 20));
		
		mainWindow.add(btPanel, FlowLayout.CENTER);
		btPanel.add(btStart);
		btStart.setFont(new Font("Consolas", Font.PLAIN, 20));
		btPanel.add(btStop);
		btStop.setFont(new Font("Consolas", Font.PLAIN, 20));
		
		btStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				hours = Integer.parseInt(tfHour.getText()); 
				minutes = Integer.parseInt(tfMinute.getText()); 
				seconds = Integer.parseInt(tfSecond.getText());  
				TimerTask timerTask = new Test4();
			    timer = new Timer(false);
			    timer.scheduleAtFixedRate(timerTask, 0, 1 * 1000);
			}
			
		});
		
		btStop.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				tfHour.setText(""+0);
				tfMinute.setText(""+0);
				tfSecond.setText(""+0);
				count = 0;
				timer.cancel();	
			}
		});
		
		mainWindow.pack();
		mainWindow.setVisible(true);
		
		Dimension d = mainWindow.getSize();
		mainWindow.setMinimumSize(d);
		
	}

}
