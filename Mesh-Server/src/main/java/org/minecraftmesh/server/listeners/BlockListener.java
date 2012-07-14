package org.minecraftmesh.server.listeners;

import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.World;

public abstract class BlockListener implements IListenerBase
{
	public abstract void onBlockFallenUpon(World world, int i, int j, int k, Entity entity, float f);
	
	public abstract void powerBlock(World world, int i, int j, int k, int l, int i1);
	
	public abstract void onBlockPlacedBy(World world, int i, int j, int k, EntityLiving entityliving);
	
	public abstract void onEntityCollidedWithBlock(World world, int i, int j, int k, Entity entity);
	
	public abstract void harvestBlock(World world, EntityPlayer player, int i, int j, int k, int damage);
	
	public abstract void onBlockClicked(World world, int i, int j, int k, EntityPlayer entityplayer);
	
	public abstract void onBlockPlaced(World world, int i, int j, int k, int l);
	
	public abstract void onEntityWalking(World world, int i, int j, int k, Entity entity);
	
	public abstract void onBlockDestroyedByExplosion(World world, int i, int j, int k);
	
	public abstract void onNeighborBlockChange(World world, int i, int j, int k, int l);
	
	public abstract void onBlockDestroyedByPlayer(World world, int i, int j, int k, int l);
	
	public abstract void onBlockActivated(World world, int i, int j, int k, EntityPlayer player);
	
	public abstract void onPoweredBlockChange(World world, int i, int j, int k, boolean bool);

	public String getListenerName() {
		return "BlockListener";
	}

	public final boolean canBeRegistedBy(int registerType) {
		return (registerType == 1 || registerType == 2);
	}
}