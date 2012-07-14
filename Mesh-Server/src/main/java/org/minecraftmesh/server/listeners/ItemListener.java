package org.minecraftmesh.server.listeners;

import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

public abstract class ItemListener
{
	public abstract void onItemUse(ItemStack itemstack, EntityPlayer player, World world, int i, int j, int k, int l);
	
	public abstract void onItemRightClick(ItemStack itemstack, World world, EntityPlayer player);
	
	public abstract void onFoodEaten(ItemStack itemstack, World world, EntityPlayer player);
	
	public abstract void onHitEntityWith(ItemStack itemstack, EntityLiving itemUser, EntityLiving enemy);
	
	public abstract void onBlockDestroyedWith(ItemStack itemstack, int par2, int par3, int i, int j, EntityLiving entityliving);
	
	public abstract void useItemOnEntity(ItemStack itemstack, EntityLiving entityliving);
	
	public abstract void onCreated(ItemStack itemstack, World world, EntityPlayer entityplayer);
	
	public abstract void onPlayerStoppedUsing(ItemStack itemstack, World world, EntityPlayer entityplayer, int i);

}