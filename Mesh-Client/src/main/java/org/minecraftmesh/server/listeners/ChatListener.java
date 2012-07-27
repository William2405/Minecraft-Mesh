package org.minecraftmesh.server.listeners;

import org.minecraftmesh.server.EntityMeshPlayerMP;
import org.minecraftmesh.server.MeshCommand;

public abstract class ChatListener implements IListenerBase
{
	public final String getListenerName()
	{
		return "ChatListener";
	}
	
	public final boolean canBeRegistedBy(int registerType) {
		return (registerType == PLUGIN || registerType == MOD);
	}
	
	public abstract void onCommand(MeshCommand meshcommand);
	
	public abstract void onChat(String message, EntityMeshPlayerMP player);
}