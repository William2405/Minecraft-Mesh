package org.minecraftmesh.server;

import java.io.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropertyManager
{
    private static Properties clientProperties;
    private static File clientPropertiesFile;
    private static Logger logger;

    public PropertyManager(File par1File)
    {
        clientProperties = new Properties();
        clientPropertiesFile = par1File;
        
        logger = MinecraftMesh.getLogger();

        if (par1File.exists())
        {
            try
            {
                clientProperties.load(new FileInputStream(par1File));
            }
            catch (Exception exception)
            {
                logger.log(Level.WARNING, (new StringBuilder()).append("Failed to load ").append(par1File).toString(), exception);
                generateNewProperties();
            }
        }
        else
        {
            logger.log(Level.WARNING, (new StringBuilder()).append(par1File).append(" does not exist").toString());
            generateNewProperties();
        }
    }
    
    public static void generateNewProperties()
    {
        logger.log(Level.INFO, "Generating new properties file");
        saveProperties();
    }
    
    public static void saveProperties()
    {
        try
        {
            clientProperties.store(new FileOutputStream(clientPropertiesFile), "Minecraft client properties");
        }
        catch (Exception exception)
        {
            logger.log(Level.WARNING, (new StringBuilder()).append("Failed to save ").append(clientPropertiesFile).toString(), exception);
            generateNewProperties();
        }
    }
    
    public static File getPropertiesFile()
    {
        return clientPropertiesFile;
    }
    
    public static String getStringProperty(String par1Str, String par2Str)
    {
        if (!clientProperties.containsKey(par1Str))
        {
            clientProperties.setProperty(par1Str, par2Str);
            saveProperties();
        }

        return clientProperties.getProperty(par1Str, par2Str);
    }
    
    public static int getIntProperty(String par1Str, int par2)
    {
        try
        {
            return Integer.parseInt(getStringProperty(par1Str, (new StringBuilder()).append("").append(par2).toString()));
        }
        catch (Exception exception)
        {
            clientProperties.setProperty(par1Str, (new StringBuilder()).append("").append(par2).toString());
        }

        return par2;
    }
    
    public static boolean getBooleanProperty(String par1Str, boolean par2)
    {
        try
        {
            return Boolean.parseBoolean(getStringProperty(par1Str, (new StringBuilder()).append("").append(par2).toString()));
        }
        catch (Exception exception)
        {
            clientProperties.setProperty(par1Str, (new StringBuilder()).append("").append(par2).toString());
        }

        return par2;
    }
    
    public static void setProperty(String property, Object obj)
    {
        clientProperties.setProperty(property, (new StringBuilder()).append("").append(obj).toString());
    }

    public static void setProperty(String property, boolean bool)
    {
        clientProperties.setProperty(property, (new StringBuilder()).append("").append(bool).toString());
        saveProperties();
    }
}