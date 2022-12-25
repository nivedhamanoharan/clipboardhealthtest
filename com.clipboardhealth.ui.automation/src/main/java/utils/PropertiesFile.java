package utils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class PropertiesFile {
    private Properties properties = new Properties();
    private FileInputStream fileInputStream;

    public PropertiesFile(String filePath) throws IOException {
        fileInputStream = new FileInputStream(filePath);
        properties.load(fileInputStream);
        fileInputStream.close();
    }

    public PropertiesFile(File file) throws IOException {
        fileInputStream = new FileInputStream(file);
        properties.load(fileInputStream);
        fileInputStream.close();
    }

    public PropertiesFile(InputStream inputStream) throws IOException {
        properties.load(inputStream);
        inputStream.close();
    }

    public void setProperty(String key, String value) {
        properties.setProperty(key, value);
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public long getPropertyAsLong(String key) {
        return Long.parseLong(properties.getProperty(key), 10);
    }

    public Map<String, String> getProperties(String delimiter) throws IOException {
        HashMap<String, String> propertiesMap = new HashMap();
        for (String key : getAllPropertyNames())
            propertiesMap.put(key, getProperty(key));

        return propertiesMap;
    }

    public Set<String> getAllPropertyNames() {
        return properties.stringPropertyNames();
    }

    public boolean containsKey(String key) {
        return properties.containsKey(key);
    }

    public boolean isEmpty() {
        return properties.isEmpty();
    }
}
