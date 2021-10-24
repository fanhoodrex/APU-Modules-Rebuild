package aplc.assignment_f;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/* @author fang */
public class FileReader {
    private FileInputStream fis;
    private XSSFWorkbook wb;
    public FileReader(String filepath) {
        try {
            fis = new FileInputStream(filepath);
            wb = new XSSFWorkbook(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<List<String>> getData() {
        List<List<String>> list = new ArrayList<>();
        try {
            XSSFSheet sheet = wb.getSheetAt(0);
            for(Row row : sheet) {
                int rowNum = row.getRowNum();
                if(rowNum >=1 && rowNum <=51) {
                    List<String> record = new ArrayList<>();
                    record.add(Double.toString(row.getCell(0).getNumericCellValue()));
                    record.add(row.getCell(1).getStringCellValue());
                    record.add(row.getCell(2).getStringCellValue());
                    record.add(Double.toString(row.getCell(3).getNumericCellValue()));
                    list.add(record);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}