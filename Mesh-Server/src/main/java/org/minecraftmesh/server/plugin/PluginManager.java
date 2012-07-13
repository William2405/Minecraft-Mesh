package org.minecraftmesh.server.plugin;

import java.util.ArrayList;
import java.util.List;

public class PluginManager {

	private List<Plugin> pluginList = new ArrayList<Plugin>();
	
	public void addPlugin(Plugin plugin) {
		pluginList.add(plugin);
	}
	
	public boolean isPluginLoaded(String name) {
		for(Plugin plugin : pluginList)
		{
			if(plugin.getClass().getSimpleName().equals(name))
				return true;
		}
		
		return false;
	}
	
	public Plugin getPlugin(String name) {
		for(Plugin plugin : pluginList)
		{
			if(plugin.getClass().getSimpleName().equals(name))
				return plugin;
		}
		
		return null;
	}
	
	public List<Plugin> getPluginList() {
		return pluginList;
	}
}
