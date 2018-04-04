package org.stock.project;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.ui.RefineryUtilities;

/**
 * UISetup is used to setup and present a UI to the user.
 * Setting up the JFrame, Frames have layout methods.
 * @param Setting up the JFrame with GridBag Layout
 */

class CustomActionListener implements ActionListener {
	public void actionPerformed(ActionEvent e){
		//System.out.println("Button has been clicked" + e);
		
		if (e.getActionCommand().equals("Show Graph")){
			LineChart chart = new LineChart("Simple Moving Average", "S&P 500 Simple Moving Average");
				chart.pack();
				RefineryUtilities.centerFrameOnScreen(chart);
			    chart.setVisible(true);
		}
	}
}


public class UISetup implements ActionListener{
	private DataAnalytics data_functions;
	
	public UISetup(DataAnalytics dataA) {
		 data_functions = dataA;
		 
	JFrame frame = new JFrame("GridBag Layout Demo");
	
	JButton btn1 = new JButton("Average Close Price");
	JButton btn2 = new JButton("Show Bollinger Bands");
	JButton btn3 = new JButton("Show Graph");
	JButton btn4 = new JButton("3-Day Simple Moving Average");
	
	/**
	 *JPanel will use the GridBagLayout.
	 *Uses a grid system to place the components
	 *on the panel.  The constraints are used
	 *to direct where the component should placed
	 *on the grid.
	 */
	
	JPanel p = new JPanel();
	p.setLayout(new GridBagLayout());
	
	GridBagConstraints gbc = new GridBagConstraints();
	gbc.fill = GridBagConstraints.HORIZONTAL;
	
	gbc.gridx = 0;    //x-axis
	gbc.gridy = 0;	  //y-axis   Grid starts top left corner
	btn1.addActionListener(this);
	
	p.add(btn1,gbc);
	
	gbc.gridx = 1;    //Move over 1 
	gbc.gridy = 0;	
	btn2.addActionListener(this);
	p.add(btn2,gbc);
	
	gbc.gridx = 2;   // Move over 2
	gbc.gridy = 0;
	btn3.addActionListener(new CustomActionListener());
	p.add(btn3,gbc);
	
	gbc.gridwidth = 3; //Gridwidth means use 3 grid spots.
	gbc.gridx = 0;	   //Place it all they left
	gbc.gridy = 1;	   //Place it on a new row
	btn4.addActionListener(this);
	p.add(btn4,gbc);
	
	
	/**
	 * Set the size of the Frame
	 * add the panel to the Content Pane
	 * make it Visible
	 */
	frame.setSize(300,300);
	frame.getContentPane().add(p);
	frame.setVisible(true);
	
	}
	
	public void actionPerformed(ActionEvent e){
		int days=0;
		//System.out.println("Button has been clicked" + e);
		
		if (e.getActionCommand().equals("Average Close Price")){
			System.out.println("Getting Average Closing Price");
			data_functions.averageClosePrice();
		} else if (e.getActionCommand().equals("Show Bollinger Bands")){
			System.out.println("Calculating Bollinger Bands");
			days=3;
			data_functions.computeUpperLowerBands(days);
		} else if (e.getActionCommand().equals("3-Day Simple Moving Average")) {
			days=3;
			data_functions.computeData(days);
		}
	}
}
