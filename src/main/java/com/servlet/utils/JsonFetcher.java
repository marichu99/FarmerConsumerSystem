package com.servlet.utils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class JsonFetcher {
    public static byte[] convertJsonToExcel(Class<?> dataClazz, List<?> dataList) {
        List<Field> fields = new ArrayList<>(Arrays.asList(dataClazz.getSuperclass().getDeclaredFields()));
        fields.addAll(Arrays.asList(dataClazz.getDeclaredFields()));

        try {

            // create a new workbook
            try (Workbook workbook = new XSSFWorkbook()) {
                // Create a sheet in the workbook
                Sheet sheet = workbook.createSheet(dataClazz.getSimpleName()+" Sheet");

                // Create header row
                Row headerRow = sheet.createRow(0);
                for (int i = 0; i < fields.size(); i++) {
                    headerRow.createCell(i).setCellValue(fields.get(i).getName());
                }

                // Populate the sheet with data from the JSON
                int rowNum = 1;
                for (Object data : dataList) {
                    Row row = sheet.createRow(rowNum++);
                    for(int i = 0; i < fields.size(); i++){
                        row.createCell(i).setCellValue((String)fields.get(i).get(data));
                    }
                }

                // Write the workbook to a file
                try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
                    workbook.write(byteArrayOutputStream);
                    return byteArrayOutputStream.toByteArray();
                }
            }


            // PARSE JSON data into
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String fetchJsonFromEndpoint(String jsonInput) {
        try {
            // create a urlobject with endpoint url
            URL url = new URL(jsonInput);

            // open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // set the request method to get
            connection.setRequestMethod("GET");

            // GET the response code
            int responseCode = connection.getResponseCode();

            // Check if the request was successful
            if (responseCode == HttpURLConnection.HTTP_OK) {
                try (BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()))) {
                    StringBuilder responseBuilder = new StringBuilder();
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        responseBuilder.append(line);
                    }

                    // Return the JSON response as a string
                    return responseBuilder.toString();
                }
            } else {
                System.out.println("Failed to fetch the JSON data: " + responseCode);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
