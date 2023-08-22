package accountCreation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class reusableComponents {

    // method to generate random String only with lower case alphabets
    public static String randomStringWithAlphabets(int targetedStringLength )
    {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetedStringLength);
        for (int i = 0; i < targetedStringLength ; i++) {
            int randomLimitedInt = leftLimit + (int) 
            (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }

        String generatedString = buffer.toString();
        return generatedString;
    }

    // method to generaterandom integer within a given range
    public static int randomNumber(int min, int max)
    {
      int random_int = (int)Math.floor(Math.random() * (max - min + 1) + min);
      return random_int;
    }

    // method to generate alphanumeric random string
    public static String randomAlphanumericString(int targetedStringLength)
    {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
        .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
        .limit(targetStringLength)
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        .toString();

        return generatedString;
        
    }


    // method to take screenshot
    public static void takeSnapShot(WebDriver driver, String fileWithPath) throws IOException
    {
        TakesScreenshot scrShot = ((TakesScreenshot)driver);
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(fileWithPath);
        FileUtils.copyFile(srcFile, destFile);


    }

    //method to write to a excel file
    public static void writeToExcel(String sheetName, Map<String, Object[]> map) throws FileNotFoundException, IOException
    {
        try (//Writing details into a excel file
          XSSFWorkbook workbook = new XSSFWorkbook()) {
            XSSFSheet sheet = workbook.createSheet(sheetName);
            XSSFRow row;
            Set<String> keyid = map.keySet();
 
    int rowid = 0;
 
    // writing the data into the sheets...
 
    for (String key : keyid) {
 
              row = sheet.createRow(rowid++);
              Object[] objectArr = map.get(key);
              int cellid = 0;
 
              for (Object obj : objectArr) {
                  Cell cell = row.createCell(cellid++);
                  cell.setCellValue((String)obj);
              }
    }
 
    // .xlsx is the format for Excel Sheets...
    // writing the workbook into the file...
    FileOutputStream out = new FileOutputStream(
              new File("src\\accountCreation\\User Details.xlsx"));
 
    workbook.write(out);
    out.close();
          }
    }
    
}
