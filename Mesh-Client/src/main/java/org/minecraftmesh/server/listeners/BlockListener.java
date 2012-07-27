package org.minecraftmesh.server.listeners;

import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.World;

public abstract class BlockListener implements IListenerBase
{
	public abstract void onBlockFallenUpon(World world, int x, int y, int z, Entity entity, float f);
	
	public abstract void powerBlock(World world, int x, int y, int z, int damage, int i1);
	
	public abstract void onBlockPlacedBy(World world, int x, int y, int z, EntityLiving entityliving);
	
	public abstract void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity);
	
	public abstract void harvestBlock(World world, EntityPlayer player, int x, int y, int z, int damage);
	
	public abstract void onBlockClicked(World world, int x, int y, int z, EntityPlayer entityplayer);
	
	public abstract void onBlockPlaced(World world, int x, int y, int z, int damage);
	
	public abstract void onEntityWalking(World world, int x, int y, int z, Entity entity);
	
	public abstract void onBlockDestroyedByExplosion(World world, int x, int y, int z);
	
	public abstract void onNeighborBlockChange(World world, int x, int y, int z, int damage);
	
	public abstract void onBlockDestroyedByPlayer(World world, int x, int y, int z, int damage);
	
	public abstract void onBlockActivated(World world, int x, int y, int z, EntityPlayer player);
	
	public abstract void onPoweredBlockChange(World world, int x, int y, int z, boolean bool);

	public final String getListenerName() {
		return "BlockListener";
	}

	public final boolean canBeRegistedBy(int registerType) {
		return (registerType == PLUGIN || registerType == MOD);
	}
}