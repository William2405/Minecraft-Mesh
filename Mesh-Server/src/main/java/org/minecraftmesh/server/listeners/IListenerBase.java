package org.minecraftmesh.server.listeners;

public interface IListenerBase {

	public static final int PLUGIN = 1;
	public static final int MOD = 2;
	
	public abstract String getListenerName();
	public abstract boolean canBeRegistedBy(int registerType);
	
}
