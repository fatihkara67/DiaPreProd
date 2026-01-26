package com.efectura.utilities;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CommonExcelReader {
    //excel den veri okumam gerektiği zaman
    public static void updateCellValue(String filePath, String colName, int rowIndex, String newValue) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File(filePath));
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);

        // Başlık satırını al
        Row headerRow = sheet.getRow(0);

        // Sütun adını sütun indeksine çevir
        int colIndex = -1;
        for (Cell cell : headerRow) {
            if (cell.getStringCellValue().equalsIgnoreCase(colName)) {
                colIndex = cell.getColumnIndex();
                break;
            }
        }

        // Sütun bulunamazsa hata fırlat
        if (colIndex == -1) {
            workbook.close();
            fileInputStream.close();
            throw new IllegalArgumentException("Sütun adı bulunamadı: " + colName);
        }

        // İlgili satırı al
        Row row = sheet.getRow(rowIndex);

        if (row == null) {
            row = sheet.createRow(rowIndex);
        }

        // İlgili hücreyi al veya oluştur
        Cell cell = row.getCell(colIndex);
        if (cell == null) {
            cell = row.createCell(colIndex);
        }

        // Yeni değeri ayarla
        cell.setCellValue(newValue);

        // Değişiklikleri kaydet
        fileInputStream.close();

        FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath));
        workbook.write(fileOutputStream);
        fileOutputStream.close();

        workbook.close();
    }

    public static String getCellValue(String filePath, String colName, int rowIndex) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File(filePath));
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);

        // Başlık satırını al
        Row headerRow = sheet.getRow(0);

        // Sütun adını sütun indeksine çevir
        int colIndex = -1;
        for (Cell cell : headerRow) {
            if (cell.getStringCellValue().equalsIgnoreCase(colName)) {
                colIndex = cell.getColumnIndex();
                break;
            }
        }

        // Sütun bulunamazsa hata fırlat
        if (colIndex == -1) {
            workbook.close();
            fileInputStream.close();
            throw new IllegalArgumentException("Sütun adı bulunamadı: " + colName);
        }

        // İlgili satırı al
        Row row = sheet.getRow(rowIndex);

        if (row == null) {
            workbook.close();
            fileInputStream.close();
            throw new IllegalArgumentException("Satır bulunamadı: " + rowIndex);
        }

        // İlgili hücreyi al
        Cell cell = row.getCell(colIndex);

        if (cell == null) {
            workbook.close();
            fileInputStream.close();
            throw new IllegalArgumentException("Hücre bulunamadı: " + colName + ", " + rowIndex);
        }

        // Hücre değerini oku ve doğru formatta dönüştür
        String cellValue;
        switch (cell.getCellType()) {
            case STRING:
                cellValue = cell.getStringCellValue();
                break;
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    cellValue = cell.getDateCellValue().toString();
                } else {
                    // Eğer hücredeki sayı çok büyükse, uzun (long) olarak almayı deneyin
                    double numericValue = cell.getNumericCellValue();
                    if (numericValue == (long) numericValue) {
                        cellValue = String.valueOf((long) numericValue);
                    } else {
                        cellValue = String.valueOf(numericValue);
                    }
                }
                break;
            case BOOLEAN:
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case FORMULA:
                cellValue = cell.getCellFormula();
                break;
            default:
                cellValue = "";
        }

        fileInputStream.close();
        workbook.close();

        return cellValue;
    }

    public static void updateColumnRange(String filePath, String colName, int startRowIndex, int endRowIndex, String newValue) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File(filePath));
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);

        // Başlık satırını al
        Row headerRow = sheet.getRow(0);

        // Sütun adını sütun indeksine çevir
        int colIndex = -1;
        for (Cell cell : headerRow) {
            if (cell.getStringCellValue().equalsIgnoreCase(colName)) {
                colIndex = cell.getColumnIndex();
                break;
            }
        }

        // Sütun bulunamazsa hata fırlat
        if (colIndex == -1) {
            workbook.close();
            fileInputStream.close();
            throw new IllegalArgumentException("Sütun adı bulunamadı: " + colName);
        }

        // Belirtilen aralıktaki satırları güncelle
        for (int i = startRowIndex; i <= endRowIndex; i++) {
            Row row = sheet.getRow(i);
            if (row == null) {
                row = sheet.createRow(i);
            }

            Cell cell = row.getCell(colIndex);
            if (cell == null) {
                cell = row.createCell(colIndex);
            }

            cell.setCellValue(newValue);
        }

        // Değişiklikleri kaydet
        fileInputStream.close();
        FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath));
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        workbook.close();
    }

    public static List<String> getColumnValues(String filePath, String colName) throws IOException {
        List<String> columnValues = new ArrayList<>();

        FileInputStream fileInputStream = new FileInputStream(new File(filePath));
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);

        // Başlık satırını al
        Row headerRow = sheet.getRow(0);

        // Sütun adını sütun indeksine çevir
        int colIndex = -1;
        for (Cell cell : headerRow) {
            if (cell.getStringCellValue().equalsIgnoreCase(colName)) {
                colIndex = cell.getColumnIndex();
                break;
            }
        }

        // Sütun bulunamazsa hata fırlat
        if (colIndex == -1) {
            workbook.close();
            fileInputStream.close();
            throw new IllegalArgumentException("Sütun adı bulunamadı: " + colName);
        }

        // Header dışındaki satırları gez
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row == null) continue;

            Cell cell = row.getCell(colIndex);
            if (cell == null) {
                columnValues.add(""); // Hücre boşsa boş string ekle
                continue;
            }

            String cellValue;
            switch (cell.getCellType()) {
                case STRING:
                    cellValue = cell.getStringCellValue();
                    break;
                case NUMERIC:
                    if (DateUtil.isCellDateFormatted(cell)) {
                        cellValue = cell.getDateCellValue().toString();
                    } else {
                        double numericValue = cell.getNumericCellValue();
                        if (numericValue == (long) numericValue) {
                            cellValue = String.valueOf((long) numericValue);
                        } else {
                            cellValue = String.valueOf(numericValue);
                        }
                    }
                    break;
                case BOOLEAN:
                    cellValue = String.valueOf(cell.getBooleanCellValue());
                    break;
                case FORMULA:
                    cellValue = cell.getCellFormula();
                    break;
                default:
                    cellValue = "";
            }

            columnValues.add(cellValue);
        }

        workbook.close();
        fileInputStream.close();

        return columnValues;
    }

    public static void createExcelFile(String fileNameWithoutExtension) {
        String path = "C:\\Users\\fkara\\Desktop\\workspace\\DiaPreProd\\src\\test\\resources\\testData";
        XSSFWorkbook workbook = new XSSFWorkbook();
        FileOutputStream out = null;

        try {
            // Dosya adı
            String fileName = fileNameWithoutExtension.endsWith(".xlsx")
                    ? fileNameWithoutExtension
                    : fileNameWithoutExtension + ".xlsx";

            // Klasör oluştur
            File dir = new File(path);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            // Dosya yolu
            File file = new File(path + File.separator + fileName);

            // Dosya yazma
            out = new FileOutputStream(file);
            workbook.createSheet("Sayfa1"); // Boş bir sheet ekle (Excel bozulmasın diye)
            workbook.write(out);

            System.out.println("Excel dosyası oluşturuldu: " + file.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) out.close();
                workbook.close(); // Workbook kapatılması önemli
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void setColumnHeader(String filePath, int colIndex, String headerName) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File(filePath));
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);

        // İlk satırı al veya oluştur
        Row headerRow = sheet.getRow(0);
        if (headerRow == null) {
            headerRow = sheet.createRow(0);
        }

        // Belirtilen indexteki hücreyi al veya oluştur
        Cell headerCell = headerRow.getCell(colIndex);
        if (headerCell == null) {
            headerCell = headerRow.createCell(colIndex);
        }

        // Hücreye başlık değerini yaz
        headerCell.setCellValue(headerName);

        // Kaydet ve kapat
        fileInputStream.close();
        FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath));
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        workbook.close();
    }

    public static String getExcelPath(String fileName) {
        String projectDir = System.getProperty("user.dir");
        String relativePath = "src/test/resources/testData/" + fileName + ".xlsx";
        return Paths.get(projectDir, relativePath).toString();
    }



    public static List<String> getExcelFirstRowHeaders(String excelFilePath) {
        List<String> headers = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(excelFilePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0); // ilk sheet
            Row firstRow = sheet.getRow(0);       // ilk satır

            if (firstRow == null) {
                return headers; // boş döner
            }

            int cellCount = firstRow.getLastCellNum(); // hücre sayısını al

            for (int i = 0; i < cellCount; i++) {
                Cell cell = firstRow.getCell(i);
                headers.add(cell != null ? cell.toString().trim() : "");
            }

        } catch (Exception e) {
            throw new RuntimeException("Excel okuma hatası: " + e.getMessage(), e);
        }

        return headers;
    }



}





