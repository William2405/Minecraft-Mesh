package org.minecraftmesh.server.plugin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.minecraftmesh.server.ILoader;
import org.minecraftmesh.server.MinecraftMesh;
import org.minecraftmesh.server.listeners.IListenerBase;

public class PluginLoader implements ILoader
{
	private static File pluginsDir = new File("plugins");
	private static List<Plugin> pluginList = new ArrayList<Plugin>();
	
	public void loadPluginsFromFolder()
	{
		MinecraftMesh.getLogger().info("Loading plugins from \"" + pluginsDir.getName() + "\"...");
		if(pluginsDir.exists() || pluginsDir.mkdir())
			for(File plugin : pluginsDir.listFiles())
				if(plugin.isFile() && (plugin.getName().endsWith(".zip") || plugin.getName().endsWith(".jar")))
				{
					MinecraftMesh.getLogger().info("Found archive: " + plugin.getName());
					loadPluginFromFile(plugin);
				}
		
		int numberLoaded = pluginList.size();
		MinecraftMesh.getLogger().info("Finished loading plugins! " + numberLoaded + ((numberLoaded > 1 || numberLoaded == 0) ? " plugins" : " plugin") + " loaded!");
	}
	
	private static void loadPluginFromFile(File plugin) 
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
						pl.onLoad();
						pluginList.add(pl);
						MinecraftMesh.getLogger().info("Loaded Plugin: " + pl.getPluginName() + " V" + pl.getVersion());
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
	
	public List<Plugin> getPluginList()
	{
		return pluginList;
	}

	public int getLoaderType()
	{
		return IListenerBase.PLUGIN;
	}
}