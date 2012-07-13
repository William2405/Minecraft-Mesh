package org.minecraftmesh.server.plugin;

public abstract class Plugin {

	protected PluginLoader pluginManager;
	
	public abstract void onLoad();
	public abstract String getPluginName();
	public abstract float getVersion();
	
	public void onWorldTick() {
		
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "-" + this.getVersion();
	}
	
}
