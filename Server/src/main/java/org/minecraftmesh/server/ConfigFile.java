package org.minecraftmesh.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigFile {

	private final File baseFile;
	private final Properties values = new Properties();
	
	public ConfigFile(File baseFile) {
		this.baseFile = baseFile;
	}
	
	public void load() throws IOException {
		if(this.baseFile.exists() || this.baseFile.createNewFile())
			values.loadFromXML(new FileInputStream(this.baseFile));
	}

	public Object getProperty(String key, Object defaultValue) {
		if(values.containsKey(key))
			return values.getProperty(key);
		else
		{
			values.put(key, defaultValue);
			return defaultValue;
		}
	}
	
	public void save() throws IOException {
		if(this.baseFile.exists() || this.baseFile.createNewFile())
			values.storeToXML(new FileOutputStream(this.baseFile), null);
	}
}
