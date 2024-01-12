package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders
{
	@DataProvider(name="LoginData")

	public String [][]getdata() throws IOException
	{
		String path = ".\\testData\\Opencart_LoginData.xlsx";
		ExcelUtility exc = new ExcelUtility(path);
		
		int rowcount = exc.getRowCount("Sheet1");
		int colcount = exc.getCellCount("Sheet1", 1);
		
		String logindata[][]= new String[rowcount][colcount];
		for(int i=1;i<=rowcount;i++)
		{
			for (int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=exc.getCellData("Sheet1", i, j);
			}
		}
		return logindata;
	}
}
