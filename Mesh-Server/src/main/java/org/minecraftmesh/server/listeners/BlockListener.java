package org.minecraftmesh.server.listeners;

import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.World;

public class BlockListener implements IListenerBase
{
	public void onBlockFallenUpon(World world, int i, int j, int k, Entity entity, float f) {    }
	
	public void powerBlock(World world, int i, int j, int k, int l, int i1) {	}
	
	public void onBlockPlacedBy(World world, int i, int j, int k, EntityLiving entityliving) {	}
	
	public void onEntityCollidedWithBlock(World world, int i, int j, int k, Entity entity) {	}
	
	public void harvestBlock(World world, EntityPlayer player, int i, int j, int k, int damage) {	}
	
	public void onBlockClicked(World world, int i, int j, int k, EntityPlayer entityplayer) {	}
	
	public void onBlockPlaced(World world, int i, int j, int k, int l) {	}
	
	public void onEntityWalking(World world, int i, int j, int k, Entity entity) {	}
	
	public void onBlockDestroyedByExplosion(World world, int i, int j, int k) {	}
	
	public void onBlockAdded(World world, int i, int j, int k) {	}
	
	public void onBlockRemoval(World world, int i, int j, int k) {	}
	
	public void onNeighborBlockChange(World world, int i, int j, int k, int l) {	}
	
	public void onBlockDestroyedByPlayer(World world, int i, int j, int k, int l) {	}
	
	public void onBlockActivated(World world, int i, int j, int k, EntityPlayer player) {	}
	
	public void onPoweredBlockChange(World world, int i, int j, int k, boolean bool) {	}

	public String getListenerName() {
		return "BlockListener";
	}

	public boolean canBeRegistedBy(int registerType) {
		return (registerType == 1 || registerType == 2);
	}
}