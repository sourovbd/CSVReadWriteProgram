package com.sv.service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.sv.model.AdjDiv;
import com.sv.model.AdjRight;
import com.sv.model.CDividend;
import com.sv.model.IndexVol;
import com.sv.model.InputCalculation;
import com.sv.model.InterMediateCalculation;
import com.sv.model.MCap;
import com.sv.model.Multiplier;
import com.sv.model.Price;
import com.sv.model.RightP;
import com.sv.model.ShareNumber;
import com.sv.util.*;

public class CSVFileRWFileHandler {

	public static List<InterMediateCalculation> imCalculationList = new ArrayList<InterMediateCalculation>();
	//public static List<InputCalculation> inputCalculationList = new ArrayList<InputCalculation>();
	public static List<ShareNumber> shareNumberList = new ArrayList<ShareNumber>();
	public static List<CDividend> cDividendList = new ArrayList<CDividend>();
	public static List<AdjDiv> adjDivList = new ArrayList<AdjDiv>();
	public static List<AdjRight> adjRightList = new ArrayList<AdjRight>();
	public static List<MCap> mCapList = new ArrayList<MCap>();
	public static List<Multiplier> multiplierList = new ArrayList<Multiplier>();
	public static List<Price> priceList = new ArrayList<Price>();
	public static List<RightP> rightPList = new ArrayList<RightP>();
	public static List<IndexVol> indexVolList = new ArrayList<IndexVol>();
	public static InterMediateCalculation imCalculation = new InterMediateCalculation();
	public static InputCalculation inputCalculation = new InputCalculation();
    
	public static void readCsvFile(String fileName) {

		ReadFilesForCalcImpl rfc = new ReadFilesForCalcImpl();
		rfc.readShareNumberSheet(Constant.readShareNunmerFileLocation, shareNumberList); 
		rfc.readMultiplierSheet(Constant.readMultiplierFileLocation, multiplierList);
		rfc.readCDividendSheet(Constant.readCDividendFileLocation, cDividendList);
		rfc.readRightPSheet(Constant.readRightPFileLocation, rightPList);
		rfc.readPriceSheet(Constant.readPriceFileLocation, priceList);
		rfc.readMCapSheet(Constant.readMCapFileLocation, mCapList);	
		rfc.readAdjDivSheet(Constant.readAdjDivFileLocation, adjDivList); 
		rfc.readAdjRightSheet(Constant.readAdjRightFileLocation, adjRightList);	
		rfc.readIndexVolSheet(Constant.readIndexVolFileLocation, indexVolList);
	}	
	
	@SuppressWarnings("unused")
	public static void writeCsvFile(String fileName) {
		
		FileWriter fileWriter = null;
				
		try {
			fileWriter = new FileWriter(fileName);

			//Write the CSV file header
			fileWriter.append(Constant.FILE_HEADER.toString());
			
			//Add a new line separator after the header
			fileWriter.append(Constant.NEW_LINE_SEPARATOR);
			
			//Write a new student object list to the CSV file
			System.out.println("\n\nFrom CSV write method: \n");
			System.out.println("total no. of rows: "+shareNumberList.size());
			double val,ShareNumberAW, ShareNumberAX, MultiplierAW, MultiplierAX3, CDividendAX, PriceCGJ, RightPAX, AdjDivAX, 
			  AdjRightAX, MCapAX, sumMCapAX = 0, IndexVolAW2, IndexVolAW3, IndexVolAW7, MCapAY, MCapAX2, IndexVolAW, IndexVolAX, BankMarketCapValue, NBFIMarketCapValue, PharmaceuticalsMarketCapValue;
			String MCapB, AdjRightB, AdjDivB, IndexVolA = null, IndexVolA8, IndexVolA16, IndexVolA24,
					Divisor;
			for(int index = 0; index < shareNumberList.size(); index++){
				
				  inputCalculation.setMultiplierAW( multiplierList.get(index).getMultiplierAW());
				  inputCalculation.setShareNumberAW( shareNumberList.get(index).getShareNumberAW());  
				  //inputCalculationList.add(inputCalculation);
				  
				  //calculation for input sheet ShareNumber AX				 
				  ShareNumberAW = Double.parseDouble(inputCalculation.getShareNumberAW());
				  MultiplierAW = Double.parseDouble(inputCalculation.getMultiplierAW());
				  val = ShareNumberAW * (1 + MultiplierAW);			  
				  if(inputCalculation.getMultiplierAW() == "") {
					  imCalculation.setShareNumberAX(inputCalculation.getShareNumberAW());
				  }else {
					  imCalculation.setShareNumberAX(String.valueOf(val));
				  }
				  imCalculation.setCDividendAX(cDividendList.get(index).getcDividendAX());
		
				  //Intermediate calculations: AdjDivAX
				  ShareNumberAX = Double.parseDouble(imCalculation.getShareNumberAX());
				  CDividendAX = Double.parseDouble(imCalculation.getCDividendAX());				  
				  
				  if(String.valueOf(ShareNumberAX) != "" && String.valueOf(CDividendAX) != "") {
					  AdjDivAX = ShareNumberAX * CDividendAX;
				  }else {
					  AdjDivAX = 0;
				  }
				  
				  
				  //Intermediate calculations: AdjRightAX
				  MultiplierAX3 = Double.parseDouble(multiplierList.get(index).getMultiplierAX());
				  RightPAX = Double.parseDouble(rightPList.get(index).getRightPAX());
				  
				  if(String.valueOf(ShareNumberAX) != "" && String.valueOf(MultiplierAX3) != "" && String.valueOf(RightPAX) != "") {
					  AdjRightAX = ShareNumberAX * MultiplierAX3 * RightPAX;
				  }else {
					  AdjRightAX = 0;
				  }
				  
				  //Intermediate calculations: MCapAX
				  PriceCGJ = Double.parseDouble(priceList.get(index).getPriceCGJ());
				  if(String.valueOf(ShareNumberAX) != "" && String.valueOf(PriceCGJ) != "") {
					  MCapAX = PriceCGJ * ShareNumberAX ;
				  }else {
					  MCapAX = 0;
				  }
				   
				  //Final calculations: MCapAX
				  MCapB = mCapList.get(index).getmCapB();
			      MCapAY = Double.parseDouble(mCapList.get(index).getmCapAY());

			      IndexVolA8 = indexVolList.get(6).getIndexVolA();
			      IndexVolA16 = indexVolList.get(13).getIndexVolA();
			      IndexVolA24 = indexVolList.get(20).getIndexVolA();
			      	 
				  if(MCapB.equalsIgnoreCase(IndexVolA8)) {
					  sumMCapAX = sumMCapAX + MCapAX; 
				  }
				 
				  AdjDivB = adjDivList.get(index).getAdjDivB();
				  AdjRightB =adjRightList.get(index).getAdjRightB();
					  
				  IndexVolAW2 = Double.parseDouble(indexVolList.get(0).getIndexVolAW());
				  IndexVolAW3 = Double.parseDouble(indexVolList.get(1).getIndexVolAW());
				  IndexVolAW7 = Double.parseDouble(indexVolList.get(5).getIndexVolAW());
				  Divisor = String.valueOf(IndexVolAW3 * ((IndexVolAW2 + IndexVolAW7)/IndexVolAW2));
				  //System.out.println("IndexVolAW2, IndexVolAW3, IndexVolAW2, Divisor: "+IndexVolAW2+" "+IndexVolAW3+" "+IndexVolAW7+" "+Divisor);
				  fileWriter.append(inputCalculation.getShareNumberAW());
				  fileWriter.append(Constant.COMMA_DELIMITER);
				  fileWriter.append(inputCalculation.getMultiplierAW());
				  fileWriter.append(Constant.COMMA_DELIMITER);
				  fileWriter.append(imCalculation.getShareNumberAX());
				  fileWriter.append(Constant.COMMA_DELIMITER);
				  fileWriter.append(imCalculation.getCDividendAX());
				  fileWriter.append(Constant.COMMA_DELIMITER);
				  fileWriter.append(String.valueOf(AdjRightAX));
				  fileWriter.append(Constant.COMMA_DELIMITER);
				  fileWriter.append(String.valueOf(AdjDivAX));
				  fileWriter.append(Constant.COMMA_DELIMITER);
				  fileWriter.append(String.valueOf(MCapAX));
				  fileWriter.append(Constant.COMMA_DELIMITER);
				  fileWriter.append(String.valueOf(MCapB));
				  fileWriter.append(Constant.COMMA_DELIMITER);
				  fileWriter.append(String.valueOf(MCapAY));
				  fileWriter.append(Constant.COMMA_DELIMITER);
				  fileWriter.append(String.valueOf(AdjRightB));
				  fileWriter.append(Constant.COMMA_DELIMITER);
				  fileWriter.append(String.valueOf(AdjDivB));
				  if(index<21) {
					  fileWriter.append(Constant.COMMA_DELIMITER);
					  fileWriter.append(String.valueOf(IndexVolA));
				  }				  
				  fileWriter.append(Constant.NEW_LINE_SEPARATOR);	
			}

			System.out.println("CSV file was created successfully !!!");
			
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Array Index out of bound."+e);
			
		} catch (Exception e) {
			System.out.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		} finally {
			
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
			}
			
		}
	}

}


/*for (ShareNumber shareNumber : shareNumberList) {
System.out.println(shareNumber.getShareNumberAW()+" ---- ");
inputCalculation.setShareNumberAW(shareNumber.getShareNumberAW());	
System.out.println(inputCalculation.getShareNumberAW()+" --- ");
inputCalculationList.add(inputCalculation);				
}
for (Multiplier multiplier : multiplierList) {
System.out.println(multiplier.getMultiplierAW()+"--");
inputCalculation.setMultiplierAW(multiplier.getMultiplierAW());
System.out.println(inputCalculation.getMultiplierAW()+" - ");
inputCalculationList.add(inputCalculation);				
}
for (InputCalculation inputCalculation : inputCalculationList) {
System.out.println(inputCalculation.getShareNumberAW()+"  ");	
System.out.println(inputCalculation.getMultiplierAW()+"  ");
fileWriter.append(inputCalculation.getShareNumberAW());
fileWriter.append(Constant.COMMA_DELIMITER);
fileWriter.append(inputCalculation.getMultiplierAW());
fileWriter.append(Constant.NEW_LINE_SEPARATOR);			
}*/