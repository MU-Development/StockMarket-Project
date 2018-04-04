package org.stock.project;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class LineChart extends ApplicationFrame {

	public LineChart( String applicationTitle , String chartTitle ) {
		super(applicationTitle);
		
	      JFreeChart lineChart = ChartFactory.createLineChart( chartTitle,"Dates","Closing Price",
	    		  								createDataset(),PlotOrientation.VERTICAL, true,true,false);
	      
	      
	      ChartPanel chartPanel = new ChartPanel( lineChart );
	      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
	      setContentPane( chartPanel );
	}
	
	 private DefaultCategoryDataset createDataset( ) {
	      DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
	      dataset.addValue( 43.50, "SMA" , "1-5-2018" );
	      dataset.addValue( 100.45, "SMA" , "1-30-2018" );
	      dataset.addValue( 150.32, "SMA" ,  "2-7-2018" );
	      dataset.addValue( 264.11, "SMA" , "4-14-2018" );
	      dataset.addValue( 87.23, "SMA" , "4-27-2018" );
	      dataset.addValue( 300.43, "SMA" , "5-1-2018" );
	      
	      dataset.addValue( 100.00, "UpperBand" , "1-5-2018" );
	      dataset.addValue( 230.34, "UpperBand" , "1-30-2018" );
	      dataset.addValue( 270.32, "UpperBand" ,  "2-7-2018" );
	      dataset.addValue( 400.56, "UpperBand" , "4-14-2018" );
	      dataset.addValue( 210.32, "UpperBand" , "4-27-2018" );
	      dataset.addValue( 450.25, "UpperBand" , "5-1-2018" );
	      
	      dataset.addValue( 20.00, "LowerBand" , "1-5-2018" );
	      dataset.addValue( 50.34, "LowerBand" , "1-30-2018" );
	      dataset.addValue( 65.32, "LowerBand" ,  "2-7-2018" );
	      dataset.addValue( 164.56, "LowerBand" , "4-14-2018" );
	      dataset.addValue( 47.32, "LowerBand" , "4-27-2018" );
	      dataset.addValue( 150.25, "LowerBand" , "5-1-2018" );
	      return dataset;
	   }

}
