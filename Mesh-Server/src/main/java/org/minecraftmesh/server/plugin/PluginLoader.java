package org.minecraftmesh.server.plugin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.minecraftmesh.server.MinecraftMesh;


public class PluginLoader {

	public static void loadPluginsFromFolder(File folder, PluginManager pluginManager) 
	{
		MinecraftMesh.getLogger().info("Loading plugins from \"" + folder.getName() + "\"...");
		if(folder.exists() || folder.mkdir())
			for(File plugin : folder.listFiles())
				if(plugin.isFile() && (plugin.getName().endsWith(".zip") || plugin.getName().endsWith(".jar")))
				{
					MinecraftMesh.getLogger().info("Found archive: " + plugin.getName());
					loadPluginFromFile(plugin, pluginManager);
				}
		
		int numberLoaded = pluginManager.getPluginList().size();
		MinecraftMesh.getLogger().info("Finished loading plugins! " + numberLoaded + ((numberLoaded > 1 || numberLoaded == 0) ? " plugins" : " plugin") + " loaded!");
	}
	
	private static void loadPluginFromFile(File plugin, PluginManager pluginManager) 
	{
		try
		{
			URLClassLoader classLoader = URLClassLoader.newInstance(new URL[]{plugin.toURI().toURL()});
			ZipInputStream fileIn = new ZipInputStream(new FileInputStream(plugin));
			
			for(ZipEntry ze = fileIn.getNextEntry(); ze != null; ze = fileIn.getNextEntry())
			{
				String path = ze.getName().replace("\\", ".");
				String[] s = path.split("\\.");
				String name = (s[s.length - 2] + "." + s[s.length - 1]);
				
				if(!ze.isDirectory() && name.startsWith("plugin_") && !name.contains("$") && name.endsWith(".class"))
				{
					Class<?> pluginClass = classLoader.loadClass(path.split("\\.")[0]);
					if(Plugin.class.isAssignableFrom(pluginClass))
					{
						Plugin pl = (Plugin)pluginClass.newInstance();
						MinecraftMesh.getLogger().info("Loading Plugin: " + pl.getClass().getSimpleName());
						pl.onLoad();
						pluginManager.addPlugin(pl);
						pl.pluginManager = pluginManager;
					}
				}
			}
			
			fileIn.close();
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
	}
}
