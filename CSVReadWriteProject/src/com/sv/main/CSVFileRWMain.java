package com.sv.main;


import com.sv.service.CSVFileRWFileHandler;
import com.sv.util.Constant;

public class CSVFileRWMain {

	public static void main(String[] args) {
		
		System.out.println("\nRead CSV file:");
		CSVFileRWFileHandler.readCsvFile(Constant.readShareNunmerFileLocation);

		System.out.println("Write CSV file:");
		CSVFileRWFileHandler.writeCsvFile(Constant.writeShareNunmerfileLocation);
		
		
		
	}

}
