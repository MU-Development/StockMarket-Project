package org.stock.project;

import java.util.ArrayList;

public abstract class ComputeMethods {
	private MarketData[] smdata;
	private int days=0;
	private ArrayList <Double> smaAverages = new ArrayList <Double>();
	private ArrayList<Double> holdStdDev = new ArrayList<Double>();
	
	
	
	public abstract void computeUpperLowerBands(int days);
	
	
	public ArrayList getSmaAverages() {
		return smaAverages;
	}
	
	public ArrayList getStdDev() {
		return holdStdDev;
	}
	
	ComputeMethods(MarketData[] data){
			smdata = data;
		}

		void computeData(int days) {
			double close = 0;
			double smaAvg =0;
			double value=0, xvalue=0;
			int count = 0;
			
			ArrayList<Double> holdValues = new ArrayList<Double>();
			ArrayList<Double> tempValues = new ArrayList<Double>();
			smaAverages.clear();
			holdStdDev.clear();
			
			for(int x=0;x < smdata.length; x++) {
				if(count == days) {
					/*Hold the Simple Moving Average*/
					smaAvg = close/days;
					smaAverages.add(smaAvg);
					
					/*To compute the Std deviation need to subtract the 
					 * initial value from the SMA and square it.  Hold
					 * these values because you need to take the avg of them.
					 */
					 for (int z=0; z < holdValues.size(); z++) {
						 value = holdValues.get(z) - smaAvg;
						 tempValues.add(Math.pow(value, 2));
					 }
					 
					 for (Double tval : tempValues) {
						 value = value + tval;
					 }
					 
					 xvalue = value / tempValues.size();
					 holdStdDev.add(Math.sqrt(xvalue));
					 
					count = 0;
					close = 0;
					tempValues.clear();
					
					close = close + smdata[x].close; }
				else {
					close = close + smdata[x].close; 
					holdValues.add(smdata[x].close);
					}
				count++; 
			  }
			System.out.println(smaAverages);
		}
	    
		
		void averageClosePrice(){
			
			double close=0,open=0;
			double avgClose=0,avgOpen=0;
			double avgIncrease=0;
			int size = smdata.length;
			
				for(int x=0; x < size; x++){
					close = close + smdata[x].close;
					open = open + smdata[x].open;
				}
		
				avgClose = close / size;
				avgOpen = open / size;
			
				avgIncrease = avgClose - avgOpen;	
			
			System.out.printf("Average Open %.2f \t Average Close: %.2f \n", avgOpen, avgClose);
			System.out.printf("Market moves up on Average: %.2f per day! Better get in now!\n",avgIncrease);
			
		}	
}
