package org.minecraftmesh.server;

import net.minecraft.client.Minecraft;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntityPlayerSP;
import net.minecraft.src.EnumStatus;
import net.minecraft.src.ItemInWorldManager;
import net.minecraft.src.Session;
import net.minecraft.src.World;

public abstract class EntityMeshPlayerMP extends EntityPlayerSP {
	
	public EntityMeshPlayerMP(Minecraft minecraft, World world,
			Session session, int dimension) {
		super(minecraft, world, session, dimension);
	}

	public String getUsername() {
		return this.getUsername();
	}
	
	public double getX() {
		return this.getX();
	}
	
	public double getY() {
		return this.getY();
	}
	
	public double getZ() {
		return this.getZ();
	}
	
	public int getHealth() {
		return this.getHealth();
	}
}
