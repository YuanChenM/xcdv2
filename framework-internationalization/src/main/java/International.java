import com.framework.core.utils.StringUtils;
import com.framework.international.utils.PoiUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

/**
 * Created by dai_youcheng on 2016-12-5.
 */
public class International {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = International.class.getResourceAsStream("/configinfo.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        //模板路径   sheet名称
        readXlsx(properties.getProperty("templatePath"), properties.getProperty("generateTargetPath"));

    }

    /**
     * 读Excel模板
     *
     * @param path 模板路径
     */
    public static void readXlsx(String path, String CreatePath) {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(path);
            Workbook workbook = null;
            String[] array = path.split("\\.");
            if (array[1].equals("xlsx")) {
                workbook = new XSSFWorkbook(inputStream);
            } else {
                workbook = new HSSFWorkbook(inputStream);
            }
            for (int sheets = workbook.getNumberOfSheets() - 2; sheets < workbook.getNumberOfSheets(); sheets++) {
                Map<String, List> earMap = earnMap(workbook, sheets);
                createProperties(earMap, CreatePath, workbook.getSheetName(sheets));
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static Map<String, List> earnMap(Workbook workbook, int sheet) {
        Map<String, List> map = new LinkedHashMap<String, List>();
        Sheet hssfSheet = workbook.getSheetAt(sheet);
        if (hssfSheet == null) {
            return null;
        }
        for (int row = 2; row <= hssfSheet.getLastRowNum(); row++) {
            Row hssfRow = hssfSheet.getRow(row);
            String cellValue = PoiUtils.getCellValue(hssfSheet, row, 2);
            if (StringUtils.isEmpty(cellValue)) {
                continue;
            }
            if (hssfRow != null) {
                List<String> list = new ArrayList<String>();
                for (int i = 5; i < i + 6; i = i + 6) {
                    if (PoiUtils.getCellValue(hssfSheet, row, i) == null) {
                        break;
                    }
                    list.add(PoiUtils.getCellValue(hssfSheet, row, i));
                }
                map.put(PoiUtils.getCellValue(hssfSheet, row, 2), list);
            }
        }
        return map;
    }

    /**
     * 生成Properites
     *
     * @param map
     * @param path 生成文件路径
     */

    public static void createProperties(Map<String, List> map, String path, String sheetName) {
        List<Properties> list = new ArrayList<Properties>();
        int count = 0;
        for (Map.Entry<String, List> entry : map.entrySet()) {
            if (count == 0) {
                for (int i = 0; i < entry.getValue().size(); i++) {
                    Properties properties = new Properties();
                    list.add(properties);
                    count = entry.getValue().size();
                }
            }
            for (int i = 0; i < entry.getValue().size(); i++) {
                list.get(i).put(entry.getKey(), entry.getValue().get(i));
            }
        }
        List<String> pathList = new ArrayList<String>();
        pathList.add("resource_zh_CN.properties");
        pathList.add("resource_en_US.properties");
        pathList.add("resource_en_ps.properties");
        for (int i = 0; i < count; i++) {
            FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = new FileOutputStream(new File(path + sheetName + "-" + pathList.get(i)));
                list.get(i).store(fileOutputStream, "");
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if(fileOutputStream !=null){
                    try {
                        fileOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
