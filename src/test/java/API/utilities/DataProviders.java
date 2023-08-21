package API.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name="Data")
	public String[][] getAllData() throws IOException{
		
			
			String path= System.getProperty("user.dir")+"//testData//uti.xlsx";
		XLUtility xl=new XLUtility(path);
		    int rownum =xl.getRowCount("Sheet");
		    int colnum = xl.getCellCount("Sheet1",1);
			String apidata[][] = new String [rownum][colnum];
			
			for(int i=1; i<=rownum;i++)
			{
				for(int j = 0; j<=colnum; j++)
				{
			      apidata[i-1][j]=xl.getCellCount("Sheet1", i, j);
			}
			
		}
			return apidata;
		}

	@DataProvider(name="UserNames")
	public String[] getUserNames() throws Exception {
		
		String path= System.getProperty("user.dir")+"//testData//uti.xlsx";
		XLUtility xl =new XLUtility(path);
		
		int rownum=xl.getRowCount("sheet1");
		 
		String apidata[]=new String[rownum];
		
		for (int i=1;i<=rownum;i++)
		{
			apidata[i-1]=xl.getCellCount("Sheet1", i, 1);
		}
		
		return apidata;
	}
	
	
	
	
	
	
	}
	
	
	
	
	

