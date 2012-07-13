package org.minecraftmesh.server.mod;

public abstract class ServerMod {

	public abstract void load();
	public abstract String getModName();
	public abstract float getVersion();
	
	public void onWorldTick() {
		
	}
	
	public boolean clientSideNeeded() {
		return true;
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "-" + this.getVersion();
	}
	
}
