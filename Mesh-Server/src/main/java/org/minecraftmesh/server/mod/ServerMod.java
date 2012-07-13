package org.minecraftmesh.server.mod;

import org.minecraftmesh.server.EntityMeshPlayerMP;

import net.minecraft.src.Packet250CustomPayload;

public abstract class ServerMod {

	protected ModLoader modLoader;
	
	public abstract void load();
	public abstract String getModName();
	public abstract float getVersion();
	
	public void onWorldTick() {
		
	}
	
	public boolean handlePacket(Packet300ModPayload packet, EntityMeshPlayerMP player) {
		return false;
	}
	
	public boolean clientSideNeeded() {
		return true;
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "-" + this.getVersion();
	}
	
}
