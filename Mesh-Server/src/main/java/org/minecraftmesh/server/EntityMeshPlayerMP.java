package org.minecraftmesh.server;

import net.minecraft.server.MinecraftServer;
import net.minecraft.src.EntityPlayerMP;
import net.minecraft.src.ItemInWorldManager;
import net.minecraft.src.World;

public abstract class EntityMeshPlayerMP extends EntityPlayerMP {

	public EntityMeshPlayerMP(MinecraftServer par1MinecraftServer, World par2World, String par3Str, ItemInWorldManager par4ItemInWorldManager) {
		super(par1MinecraftServer, par2World, par3Str, par4ItemInWorldManager);
	}

	public String getUsername() {
		return this.username;
	}
	
	public double getX() {
		return this.posX;
	}
	
	public double getY() {
		return this.posY;
	}
	
	public double getZ() {
		return this.posZ;
	}
	
	public int getHealth() {
		return this.health;
	}
}
