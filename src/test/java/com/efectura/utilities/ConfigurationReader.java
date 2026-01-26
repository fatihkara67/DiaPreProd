package com.efectura.utilities;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties configFile;
    static {

        try {
            // Özelliklerin konumu
            String path = System.getProperty("user.dir") + "/Configuration.properties";
            // Bu dosyayı akış olarak alıyoruz
            FileInputStream input = new FileInputStream(path);
            // Properties sınıfından bir nesne oluşturuluyor
            configFile = new Properties();
            // FileInputStream nesnesindeki bilgilerin, load yöntemiyle Properties nesnesine yüklenmesi.
            configFile.load(input);

            input.close();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load properties file!");
        }
    }
    /**
     * Bu yöntem, yapılandırma.properties dosyasından özellik değerini döndürür
     *
     * @param keyName özellik adı
     * @return özellik değeri
     */
    public static String getProperty(String keyName) {
        return configFile.getProperty(keyName);
    }

    public static void setProperty(String key, String value) {
        configFile.setProperty(key, value);
    }

    public static void updateProperty(String key, String value) {
        Properties properties = new Properties();
        String path = System.getProperty("user.dir") + "/Configuration.properties";
        properties.setProperty(key, value);

//        try (FileInputStream fis = new FileInputStream(path)) {
//            properties.load(fis);
//        } catch (IOException e) {
//            throw new RuntimeException("Config okunamadı", e);
//        }
//
//        try (FileOutputStream fos = new FileOutputStream(path)) {
//            properties.setProperty(key, value);
//            properties.store(fos, "Updated by automation");
//        } catch (IOException e) {
//            throw new RuntimeException("Config yazılamadı", e);
//        }
    }

}
