package org.stock.project;

import java.util.ArrayList;

public class DataAnalytics extends ComputeMethods {

	private MarketData[] md;
	
	
	DataAnalytics(MarketData[] data) {
		super(data);
		md = data;
	}
	

       public void computeUpperLowerBands(int days) { 
	    	ArrayList<Double> deviation = new ArrayList<Double>();
	    	ArrayList<Double> averages = new ArrayList<Double>();
	    	ArrayList<BBands> bands = new ArrayList<BBands>();
	    	
	    	computeData(days);
	    	averages = getSmaAverages();
	    	deviation = getStdDev();
	    	
	    	System.out.println("Averages Size is: " + averages.size());
	    	System.out.println("Deviation Size is: " + deviation.size());
	    	
	    	/*Calc Upper and lower bands*/
	    	
	    	for (int i=0; i<averages.size(); i++) {
				 bands.add(new BBands());
				 bands.get(i).upperBB = averages.get(i) + (2 * deviation.get(i));
				 bands.get(i).sma = averages.get(i);
				 bands.get(i).lowerBB = averages.get(i) - (2 * deviation.get(i));
			 }
	    	
	    	for(int i = 0; i < bands.size(); i++) {
				System.out.print("Upper Band: " + bands.get(i).upperBB + " ");
				System.out.print("SMA: " + bands.get(i).sma + " "); 
				System.out.print("Lower Band: " + bands.get(i).lowerBB);
				System.out.println("Deviation was: " + deviation.get(i));
				}
	    	
	    }
 
}
