package com.sv.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.sv.model.AdjDiv;
import com.sv.model.AdjRight;
import com.sv.model.CDividend;
import com.sv.model.IndexVol;
import com.sv.model.MCap;
import com.sv.model.Multiplier;
import com.sv.model.Price;
import com.sv.model.RightP;
import com.sv.model.ShareNumber;
import com.sv.model.TDivisor;
import com.sv.util.Constant;

public class ReadFilesForCalcImpl  {
	
	////@Override
	public void readShareNumberSheet(String readfileName,List<ShareNumber> shareNumberList) {
		
		BufferedReader fileReader = null;       
        try {
            String line = "";
            //Create the file reader
            fileReader = new BufferedReader(new FileReader(readfileName));
            //Read the CSV file header to skip it
            fileReader.readLine();
            //Read the file line by line starting from the second line
            while ((line = fileReader.readLine()) != null) {
                //Get all tokens available in line
                String[] tokens = line.split(Constant.COMMA_DELIMITER);   
                if (tokens.length > 0) {
                    //Create a new student object and fill his  data
                	ShareNumber shareNumber = new ShareNumber(tokens[Constant.Cell_INDEX_OF_AW]); 
                	shareNumberList.add(shareNumber);
                }
            }
        }
        catch (Exception e) {
            System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Error while closing fileReader !!!");
                e.printStackTrace();
            }
        }	
	}

	////@Override
	public void readCDividendSheet(String readfileName, List<CDividend> cDividendList) {
		BufferedReader fileReader = null;       
        try {
            String line = "";
            fileReader = new BufferedReader(new FileReader(readfileName));
            fileReader.readLine();
            while ((line = fileReader.readLine()) != null) {
                String[] tokens = line.split(Constant.COMMA_DELIMITER);   
                if (tokens.length > 0) {
                	CDividend cDividend = new CDividend(((tokens[Constant.Cell_INDEX_OF_AX])));
                	cDividendList.add(cDividend);
                }
            }
        }
        catch (Exception e) {
            System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Error while closing fileReader !!!");
                e.printStackTrace();
            }
        }	
	}

	//@Override
	public void readMultiplierSheet(String readfileName, List<Multiplier> multiplierList) {
		BufferedReader fileReader = null;       
        try {
            String line = "";
            fileReader = new BufferedReader(new FileReader(readfileName));
            fileReader.readLine();
            while ((line = fileReader.readLine()) != null) {
                String[] tokens = line.split(Constant.COMMA_DELIMITER);   
                if (tokens.length > 0) {
                	Multiplier multiplier = new Multiplier(tokens[Constant.Cell_INDEX_OF_AW], tokens[Constant.Cell_INDEX_OF_AX]);
                	multiplierList.add(multiplier);
                }
            }
        }
        catch (Exception e) {
            System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Error while closing fileReader !!!");
                e.printStackTrace();
            }
        }	
	}

	//@Override
	public void readRightPSheet(String readfileName, List<RightP> rightPList) {
		BufferedReader fileReader = null;       
        try {
            String line = "";
            fileReader = new BufferedReader(new FileReader(readfileName));
            fileReader.readLine();
            while ((line = fileReader.readLine()) != null) {
                String[] tokens = line.split(Constant.COMMA_DELIMITER);   
                if (tokens.length > 0) {
                	RightP rightP = new RightP(((tokens[Constant.Cell_INDEX_OF_AX])));
                	rightPList.add(rightP);
                }
            }
        }
        catch (Exception e) {
            System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Error while closing fileReader !!!");
                e.printStackTrace();
            }
        }		
	}

	//@Override
	public void readPriceSheet(String readfileName, List<Price> priceList) {
		BufferedReader fileReader = null;       
        try {
            String line = "";
            fileReader = new BufferedReader(new FileReader(readfileName));
            fileReader.readLine();
            while ((line = fileReader.readLine()) != null) {
                String[] tokens = line.split(Constant.COMMA_DELIMITER);   
                if (tokens.length > 0) {
                	Price price = new Price(((tokens[Constant.Cell_INDEX_OF_CGJ])));
                	priceList.add(price);
                }
            }
        }
        catch (Exception e) {
            System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Error while closing fileReader !!!");
                e.printStackTrace();
            }
        }	
	}

	//@Override
	public void readMCapSheet(String readfileName, List<MCap> mCapList) {
		BufferedReader fileReader = null;    
        try {
            String line = "";
            fileReader = new BufferedReader(new FileReader(readfileName));
            fileReader.readLine();
            while ((line = fileReader.readLine()) != null) {
                String[] tokens = line.split(Constant.COMMA_DELIMITER);  
                if (tokens.length > 0) {
                	MCap mCap = new MCap(tokens[Constant.Cell_INDEX_OF_B],(tokens[Constant.Cell_INDEX_OF_AW]),tokens[Constant.Cell_INDEX_OF_AX],tokens[Constant.Cell_INDEX_OF_AY]);
                	//MCap mCap = new MCap(String.valueOf(tokens[1]),String.valueOf(tokens[2]),String.valueOf(tokens[3]),String.valueOf(tokens[4]));
                	mCapList.add(mCap);
                }
            }
        }
        catch (Exception e) {
            System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Error while closing fileReader !!!");
                e.printStackTrace();
            }
        }
        //System.out.println("mCapList size: "+mCapList.size());
	}

	//@Override
	public void readAdjDivSheet(String readfileName, List<AdjDiv> adjDivList) {
		BufferedReader fileReader = null;       
        try {
            String line = "";
            fileReader = new BufferedReader(new FileReader(readfileName));
            fileReader.readLine();
            while ((line = fileReader.readLine()) != null) {
                String[] tokens = line.split(Constant.COMMA_DELIMITER);   
                if (tokens.length > 0) {
                	AdjDiv adjDiv = new AdjDiv(tokens[Constant.Cell_INDEX_OF_B],tokens[Constant.Cell_INDEX_OF_AW],tokens[Constant.Cell_INDEX_OF_AX]);
                	adjDivList.add(adjDiv);
                }
            }
        }
        catch (Exception e) {
            System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Error while closing fileReader !!!");
                e.printStackTrace();
            }
        }
	}

	//@Override
	public void readAdjRightSheet(String readfileName, List<AdjRight> adjRightList) {
		BufferedReader fileReader = null;       
        try {
            String line = "";
            fileReader = new BufferedReader(new FileReader(readfileName));
            fileReader.readLine();
            while ((line = fileReader.readLine()) != null) {
                String[] tokens = line.split(Constant.COMMA_DELIMITER);   
                if (tokens.length > 0) {
                	AdjRight adjRight = new AdjRight(tokens[Constant.Cell_INDEX_OF_B],tokens[Constant.Cell_INDEX_OF_AW],tokens[Constant.Cell_INDEX_OF_AX]);
                	adjRightList.add(adjRight);
                }
            }
        }
        catch (Exception e) {
            System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Error while closing fileReader !!!");
                e.printStackTrace();
            }
        }
	}

	//@Override
	public void readIndexVolSheet(String readfileName, List<IndexVol> indexVolList) {
		BufferedReader fileReader = null;       
        try {
            String line = "";
            fileReader = new BufferedReader(new FileReader(readfileName));
            fileReader.readLine();
            while ((line = fileReader.readLine()) != null) {
                String[] tokens = line.split(Constant.COMMA_DELIMITER);   
                if (tokens.length > 0) {
                	IndexVol indexVol = new IndexVol(tokens[Constant.Cell_INDEX_OF_A],tokens[Constant.Cell_INDEX_OF_AX],tokens[Constant.Cell_INDEX_OF_AW]);
                	indexVolList.add(indexVol);
                }
            }
        }
        catch (Exception e) {
            System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Error while closing fileReader !!!");
                e.printStackTrace();
            }
        }
	}

}
