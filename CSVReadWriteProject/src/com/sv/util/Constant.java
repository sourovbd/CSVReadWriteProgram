package com.sv.util;


public class Constant {
	
	//CSV file header
	public static final String FILE_HEADER = "ShareNumberAW,MultiplierAW,ShareNumberAX,CDividendAX,"
			+ "AdjRightAX,AdjDivAX,MCapAX,MCapB,MCapAY,AdjRightB, AdjDivB, IndexVolA";
    
    //Delimiter used in CSV file
    public static final String COMMA_DELIMITER = ",";
    public static final String NEW_LINE_SEPARATOR = "\n";
    
    public static final String BMC = "Bank Market Cap";
    public static final String BMC_Divisor = "Divisor";
    
    //attributes index
    public static final int Cell_INDEX_OF_A = 0;
    public static final int Cell_INDEX_OF_B = 1;
    public static final int Cell_INDEX_OF_AV = 47;
    public static final int Cell_INDEX_OF_AW = 48;
    public static final int Cell_INDEX_OF_AX = 49;
    public static final int Cell_INDEX_OF_AY = 50;
    //public static final int Cell_INDEX_OF_CGJ = 3352;
    public static final int Cell_INDEX_OF_CGJ = 2;
    
    //read file location
    public static final String readShareNunmerFileLocation = System.getProperty("user.home")+"/Desktop/CSVReadfiles/ShareNumberRead.csv";
    public static final String readPriceFileLocation = System.getProperty("user.home")+"/Desktop/CSVReadfiles/PriceRead.csv";
    public static final String readCDividendFileLocation = System.getProperty("user.home")+"/Desktop/CSVReadfiles/CDividendRead.csv";
    public static final String readMultiplierFileLocation = System.getProperty("user.home")+"/Desktop/CSVReadfiles/MultiplierRead.csv";
    public static final String readRightPFileLocation = System.getProperty("user.home")+"/Desktop/CSVReadfiles/RightPRead.csv";
    public static final String readAdjDivFileLocation = System.getProperty("user.home")+"/Desktop/CSVReadfiles/AdjDivRead.csv";
    public static final String readAdjRightFileLocation = System.getProperty("user.home")+"/Desktop/CSVReadfiles/AdjRightRead.csv";
    public static final String readMCapFileLocation = System.getProperty("user.home")+"/Desktop/CSVReadfiles/MCapRead.csv";
    public static final String readIndexVolFileLocation = System.getProperty("user.home")+"/Desktop/CSVReadfiles/IndexVolRead.csv";
    
    //write file location
    public static final String writeShareNunmerfileLocation = System.getProperty("user.home")+"/Desktop/CSVWritefiles/ShareNumberWrite.csv";
    public static final String writePriceFileLocation = System.getProperty("user.home")+"/Desktop/CSVWritefiles/PriceWrite.csv";
    public static final String writeCDividendFileLocation = System.getProperty("user.home")+"/Desktop/CSVWritefiles/CDividendWrite.csv";
    public static final String writeMultiplierFileLocation = System.getProperty("user.home")+"/Desktop/CSVWritefiles/MultiplierWrite.csv";
    public static final String writeRightPFileLocation = System.getProperty("user.home")+"/Desktop/CSVWritefiles/RightPWrite.csv";
    public static final String writeAdjDivFileLocation = System.getProperty("user.home")+"/Desktop/CSVWritefiles/AdjDivWrite.csv";
    public static final String writeAdjRightFileLocation = System.getProperty("user.home")+"/Desktop/CSVWritefiles/AdjRightWrite.csv";
    public static final String writeMCapFileLocation = System.getProperty("user.home")+"/Desktop/CSVWritefiles/MCapWrite.csv";
    public static final String writeTDivisorFileLocation = System.getProperty("user.home")+"/Desktop/CSVWritefiles/TDivisorWrite.csv";


}
