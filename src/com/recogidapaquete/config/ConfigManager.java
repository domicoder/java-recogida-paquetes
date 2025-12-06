package com.recogidapaquete.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 * Manages application configuration loaded from external properties file.
 * Sensitive information like database credentials and email settings
 * should be stored in config.properties file (not tracked by git).
 */
public class ConfigManager {
    
    private static ConfigManager instance;
    private Properties properties;
    
    // Database configuration keys
    public static final String DB_URL = "db.url";
    public static final String DB_USER = "db.user";
    public static final String DB_PASSWORD = "db.password";
    
    // Email/SMTP configuration keys
    public static final String SMTP_HOST = "smtp.host";
    public static final String SMTP_PORT = "smtp.port";
    public static final String SMTP_USER = "smtp.user";
    public static final String SMTP_PASSWORD = "smtp.password";
    public static final String SMTP_STARTTLS = "smtp.starttls.enable";
    public static final String SMTP_AUTH = "smtp.auth";
    
    private ConfigManager() {
        properties = new Properties();
        loadProperties();
    }
    
    public static ConfigManager getInstance() {
        if (instance == null) {
            instance = new ConfigManager();
        }
        return instance;
    }
    
    private void loadProperties() {
        // Try to load from external file first (for production)
        String configPath = System.getProperty("config.file", "config.properties");
        
        try (InputStream input = new FileInputStream(configPath)) {
            properties.load(input);
            System.out.println("Configuration loaded from: " + configPath);
        } catch (IOException ex) {
            // Fallback: try to load from classpath (for development)
            try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
                if (input != null) {
                    properties.load(input);
                    System.out.println("Configuration loaded from classpath");
                } else {
                    showConfigError();
                }
            } catch (IOException e) {
                showConfigError();
            }
        }
        
        // Also check for environment variables as override
        loadFromEnvironment();
    }
    
    private void loadFromEnvironment() {
        // Environment variables take precedence over properties file
        String dbUrl = System.getenv("REPAQ_DB_URL");
        String dbUser = System.getenv("REPAQ_DB_USER");
        String dbPassword = System.getenv("REPAQ_DB_PASSWORD");
        String smtpUser = System.getenv("REPAQ_SMTP_USER");
        String smtpPassword = System.getenv("REPAQ_SMTP_PASSWORD");
        
        if (dbUrl != null) properties.setProperty(DB_URL, dbUrl);
        if (dbUser != null) properties.setProperty(DB_USER, dbUser);
        if (dbPassword != null) properties.setProperty(DB_PASSWORD, dbPassword);
        if (smtpUser != null) properties.setProperty(SMTP_USER, smtpUser);
        if (smtpPassword != null) properties.setProperty(SMTP_PASSWORD, smtpPassword);
    }
    
    private void showConfigError() {
        String message = "No se pudo cargar el archivo de configuración.\n"
                + "Por favor, cree el archivo 'config.properties' basándose en 'config.properties.template'";
        JOptionPane.showMessageDialog(null, message, "Error de Configuración", JOptionPane.ERROR_MESSAGE);
        System.err.println(message);
    }
    
    public String getProperty(String key) {
        return properties.getProperty(key);
    }
    
    public String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
    
    // Convenience methods for database configuration
    public String getDbUrl() {
        return getProperty(DB_URL);
    }
    
    public String getDbUser() {
        return getProperty(DB_USER);
    }
    
    public String getDbPassword() {
        return getProperty(DB_PASSWORD);
    }
    
    // Convenience methods for SMTP configuration
    public String getSmtpHost() {
        return getProperty(SMTP_HOST, "smtp.gmail.com");
    }
    
    public String getSmtpPort() {
        return getProperty(SMTP_PORT, "587");
    }
    
    public String getSmtpUser() {
        return getProperty(SMTP_USER);
    }
    
    public String getSmtpPassword() {
        return getProperty(SMTP_PASSWORD);
    }
    
    public String getSmtpStartTls() {
        return getProperty(SMTP_STARTTLS, "true");
    }
    
    public String getSmtpAuth() {
        return getProperty(SMTP_AUTH, "true");
    }
}

