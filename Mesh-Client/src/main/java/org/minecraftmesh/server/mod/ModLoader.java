package org.minecraftmesh.server.mod;

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
import org.minecraftmesh.server.plugin.Plugin;


public class ModLoader implements ILoader {

	private static File modsDir = new File("mods");
	private static List<ServerMod> modsList = new ArrayList<ServerMod>();
	
	public void loadMods()
	{
		MinecraftMesh.getLogger().info("Loading mods from \"" + modsDir.getName() + "\"...");
		if(modsDir.exists() || modsDir.mkdir())
		{
			for(File mod : modsDir.listFiles())
			{
				if(mod.isFile() && (mod.getName().endsWith(".jar") || mod.getName().endsWith(".zip")))
				{
					MinecraftMesh.getLogger().info("Found archive: " + mod.getName());
					loadModFromFile(mod);
				}
				else if(mod.isDirectory())
				{
					MinecraftMesh.getLogger().info("Found folder: " + mod.getName());
					loadModFromFolder(mod);
				}
			}
		}
		MinecraftMesh.getLogger().info("Finished Loading Mods! " + modsList.size() + ((modsList.size() > 1 || modsList.size() == 0) ? " mods" : " mod") + " loaded!");
	}
	
	private void loadModFromFile(File mod)
	{
		try
		{
			URLClassLoader classLoader = URLClassLoader.newInstance(new URL[]{mod.toURI().toURL()});
			ZipInputStream fileIn = new ZipInputStream(new FileInputStream(mod));
			
			for(ZipEntry ze = fileIn.getNextEntry(); ze != null; ze = fileIn.getNextEntry())
			{
				String path = ze.getName().replace("\\", ".");
				String[] s = path.split("\\.");
				String name = (s[s.length - 2] + "." + s[s.length - 1]);
				
				if(!ze.isDirectory() && name.startsWith("mod_") && !name.contains("$") && name.endsWith(".class"))
				{
					Class<?> modClass = classLoader.loadClass(path.split("\\.")[0]);
					if(ServerMod.class.isAssignableFrom(modClass))
					{
						ServerMod serverMod = (ServerMod)modClass.newInstance();
						serverMod.load();
						modsList.add(serverMod);
						serverMod.modManager = this;
						MinecraftMesh.getLogger().info("Loaded Plugin: \"" + serverMod.getModName() + " " + serverMod.getVersion() + "\"");
					}
				}
			}
			
			fileIn.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private void loadModFromFolder(File modFolder)
	{
		try
		{
			for(File file : modFolder.listFiles())
			{
				if(file.isDirectory())
					loadModFromFolder(file);
				else if(file.isFile() && file.getName().startsWith("mod_") && !file.getName().contains("$") && file.getName().endsWith(".class"))
				{
					URLClassLoader classLoader = URLClassLoader.newInstance(new URL[]{file.toURI().toURL()});
					Class<?> modClass = classLoader.loadClass(file.getName().replace(".class", ""));
					if(ServerMod.class.isAssignableFrom(modClass))
					{
						ServerMod serverMod = (ServerMod)modClass.newInstance();
						serverMod.load();
						modsList.add(serverMod);
						MinecraftMesh.getLogger().info("Loaded Mod: " + serverMod.getModName() + " V" + serverMod.getVersion());
					}
				}
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static List<ServerMod> getModsList() {
		return modsList;
	}

	public int getLoaderType()
	{
		return IListenerBase.MOD;
	}
}
