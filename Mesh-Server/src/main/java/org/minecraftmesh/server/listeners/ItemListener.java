package org.minecraftmesh.server.listeners;

import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

public class ItemListener implements IListenerBase
{
	public void onItemUse(ItemStack itemstack, EntityPlayer player, World world, int i, int j, int k, int l) {	}
	
	public void onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {	}
	
	public void onFoodEaten(ItemStack itemstack, World world, EntityPlayer player) {	}
	
	public void onHitEntityWith(ItemStack itemstack, EntityLiving itemUser, EntityLiving enemy) {	}
	
	public void onBlockDestroyedWith(ItemStack itemstack, int par2, int par3, int i, int j, EntityLiving entityliving) {	}
	
	public void useItemOnEntity(ItemStack itemstack, EntityLiving entityliving) {	}
	
	public void onCreated(ItemStack itemstack, World world, EntityPlayer entityplayer) {	}
	
	public void onPlayerStoppedUsing(ItemStack itemstack, World world, EntityPlayer entityplayer, int i) {	}

	public String getListenerName() {
		return "ItemListener";
	}

	public boolean canBeRegistedBy(int registerType) {
		return (registerType == 1 || registerType == 2);
	}
}