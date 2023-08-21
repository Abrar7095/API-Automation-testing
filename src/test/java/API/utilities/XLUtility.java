package API.utilities;

import java.awt.image.IndexColorModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtility {

	
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	String path;
	

	
	
	public  XLUtility(String path) {
		this.path=path;
	}


	


	public int getRowCount(String SheetName) throws IOException {
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(SheetName);
		int rowcount = sheet.getLastRowNum();
		workbook.close();
		fi.close();
		return rowcount;
		
		
		
	}
	
	public int getCellCount(String SheetName,int rownum) throws IOException {
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(SheetName);
		int cellcount = row.getLastCellNum();
		workbook.close();
		fi.close();
		return cellcount;
		
		
		
	}
	
	public String getCellCount(String SheetName,int rownum,int colnum) throws IOException {
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(SheetName);
		row= sheet.getRow(rownum);
		cell=row.getCell(colnum);
		
		DataFormatter formatter = new DataFormatter();
		String data;
		try {
			data= formatter.formatCellValue(cell);
		}catch(Exception e) {
			data="";
		}
		workbook.close(); 
		fi.close();
		return data;
				
	}
	
	public void setCellData(String SheetName,int rownum,int colnum ,String data) throws IOException {

		
		File xlfile =new File(path);
		if(!xlfile.exists());
		{
			workbook=new XSSFWorkbook();
			fo= new FileOutputStream(path);
			workbook.write(fo);
			
		}
		fi =new FileInputStream(path);
		workbook= new XSSFWorkbook(fi);
		
		if(workbook.getSheetIndex(SheetName)==-1)
			workbook.createSheet(SheetName);
			sheet=workbook.getSheet(SheetName);
		
		if(sheet.getRow(rownum)==null)
		sheet.createRow(rownum);
		row=sheet.getRow(rownum);
		
		cell = row.createCell(colnum);
		cell.setCellValue(data);
		fo = new FileOutputStream(path);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
		
		
		
	}
	public void fillGreenColour(String SheetName,int rownum,int colnum ,String Data) throws IOException {
	
		fi =new FileInputStream(path);
		workbook= new XSSFWorkbook(fi);
		sheet=workbook.getSheet(SheetName);
	
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		
		style= workbook.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex()); 
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(style);
		workbook.write(fo);
        fi.close();
        fo.close();
        
		
	}
	
	public void fillRedColour(String SheetName,int rownum,int colnum ,String Data) throws IOException {
		
		fi =new FileInputStream(path);
		workbook= new XSSFWorkbook(fi);
		sheet=workbook.getSheet(SheetName);
	
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		
		style= workbook.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.RED.getIndex()); 
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(style);
		workbook.write(fo);
        fi.close();
        fo.close();
        
		
	}


	
}
