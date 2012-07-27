package org.minecraftmesh.server;

import java.util.ArrayList;

import net.minecraft.src.Block;
import net.minecraft.src.CraftingManager;
import net.minecraft.src.DamageSource;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityAnimal;
import net.minecraft.src.EntityLightningBolt;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntityTameable;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.World;

import org.minecraftmesh.server.listeners.*;

/* check:
 * Block.canBlockStay
 * Block.quantityDroppedWithBonus
 * Block.canBlockStay
 * Block.setBlockBoundsBasedOnState ???
*/

/* check:
 * Entity.setAir
 */


public class MinecraftMeshPluginHooks
{
	protected static ArrayList<BlockListener> blockListeners = new ArrayList<BlockListener>();
	protected static ArrayList<EntityListener> entityListeners = new ArrayList<EntityListener>();
	protected static ArrayList<ItemListener> itemListeners = new ArrayList<ItemListener>();
	protected static ArrayList<ChatListener> chatListeners = new ArrayList<ChatListener>();
	
	public static void registerListener(ILoader loader, IListenerBase listener)
	{
		if(listener.canBeRegistedBy(loader.getLoaderType()))
		{
			if(listener.getListenerName().equals("BlockListener"))
			{
				for(int i = 0; i < blockListeners.size(); i++)
					if(blockListeners.get(i) == (BlockListener)listener)
						return;
				
				// register blocklistener
			}
			else if(listener.getListenerName().equals("EntityListener"))
			{
				for(int i = 0; i < entityListeners.size(); i++)
					if(entityListeners.get(i) == (EntityListener)listener)
						return;
				
				// register entitylistener
			}
			else if(listener.getListenerName().equals("ItemListener"))
			{
				for(int i = 0; i < itemListeners.size(); i++)
					if(itemListeners.get(i) == (ItemListener)listener)
						return;
				
				// register itemlistener
			}
			else if(listener.getListenerName().equals("ChatListener"))
			{
				for(int i = 0; i < itemListeners.size(); i++)
					if(itemListeners.get(i) == (ItemListener)listener)
						return;
				
				// register charlistener
			}
		}
	}
	
	/*********************/
	/* Command functions */
	/*********************/
	
	public static void onCommand(String cmd, EntityPlayer player)
    {
		for(int ii = 0; ii < blockListeners.size(); ii++)
			chatListeners.get(ii).onCommand(new MeshCommand(cmd, (EntityMeshPlayerMP) player));
    }
	
	public static void onChat(String message, EntityPlayer player)
	{
		for(int ii = 0; ii < blockListeners.size(); ii++)
			chatListeners.get(ii).onChat(message, (EntityMeshPlayerMP) player);
	}
	
	/***************************/
	/* BlockListener functions */
	/***************************/

	public static void onBlockFallenUpon(World world, int x, int y, int z, Entity entity, float height)
    {
		for(int ii = 0; ii < blockListeners.size(); ii++)
			blockListeners.get(ii).onBlockFallenUpon(world, x, y, z, entity, height);
    }

	public static void powerBlock(World world, int x, int y, int z, int damage, int i1)
	{
		for(int ii = 0; ii < blockListeners.size(); ii++)
			blockListeners.get(ii).powerBlock(world, x, y, z, damage, i1);
	}

	public static void onBlockPlacedBy(World world, int x, int y, int z, EntityLiving entityliving)
	{
		for(int ii = 0; ii < blockListeners.size(); ii++)
			blockListeners.get(ii).onBlockPlacedBy(world, x, y, z, entityliving);
	}

	public static void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
	{
		for(int ii = 0; ii < blockListeners.size(); ii++)
			blockListeners.get(ii).onEntityCollidedWithBlock(world, x, y, z, entity);
	}

	public static void harvestBlock(World world, EntityPlayer player, int x, int y, int z, int damage)
	{
		for(int ii = 0; ii < blockListeners.size(); ii++)
			blockListeners.get(ii).harvestBlock(world, ((EntityMeshPlayerMP)player), x, y, z, damage);
	}

	public static void onBlockClicked(World world, int x, int y, int z, EntityPlayer entityplayer)
	{
		for(int ii = 0; ii < blockListeners.size(); ii++)
			blockListeners.get(ii).onBlockClicked(world, x, y, z, ((EntityMeshPlayerMP)entityplayer));
	}

	public static void onBlockPlaced(World world, int x, int y, int z, int damage)
	{
		for(int ii = 0; ii < blockListeners.size(); ii++)
			blockListeners.get(ii).onBlockPlaced(world, x, y, z, damage);
	}

	public static void onEntityWalking(World world, int x, int y, int z, Entity entity)
	{
		for(int ii = 0; ii < blockListeners.size(); ii++)
			blockListeners.get(ii).onEntityWalking(world, x, y, z, entity);
	}

	public static void onBlockDestroyedByExplosion(World world, int x, int y, int z)
	{
		for(int ii = 0; ii < blockListeners.size(); ii++)
			blockListeners.get(ii).onBlockDestroyedByExplosion(world, x, y, z);
	}

	public static void onNeighborBlockChange(World world, int x, int y, int z, int damage)
	{
		for(int ii = 0; ii < blockListeners.size(); ii++)
			blockListeners.get(ii).onNeighborBlockChange(world, x, y, z, damage);
	}

	public static void onBlockDestroyedByPlayer(World world, int x, int y, int z, int damage)
	{
		for(int ii = 0; ii < blockListeners.size(); ii++)
			blockListeners.get(ii).onBlockDestroyedByPlayer(world, x, y, z, damage);
	}
	
	public static void onBlockActivated(World world, int x, int y, int z, EntityPlayer player)
	{
		for(int ii = 0; ii < blockListeners.size(); ii++)
			blockListeners.get(ii).onBlockActivated(world, x, y, z, ((EntityMeshPlayerMP)player));
	}
	
	public static void onPoweredBlockChange(World world, int x, int y, int z, boolean bool)
	{
		for(int ii = 0; ii < blockListeners.size(); ii++)
			blockListeners.get(ii).onPoweredBlockChange(world, x, y, z, bool);
	}

	/****************************/
	/* EntityListener functions */
	/****************************/

	/*************************/
	/* Bare Entity functions */
	/*************************/
	
	public static void onDeath(Entity entity)
	{
		for(int ii = 0; ii < entityListeners.size(); ii++)
			entityListeners.get(ii).onDeath(entity);
	}

	public static void onSetSize(Entity entity, float width, float height)
	{
		for(int ii = 0; ii < entityListeners.size(); ii++)
			entityListeners.get(ii).onSetSize(entity, width, height);
	}

	public static void onSetRotation(Entity entity, float yaw, float pitch)
	{
		for(int ii = 0; ii < entityListeners.size(); ii++)
			entityListeners.get(ii).onSetRotation(entity, yaw, pitch);
	}

	public static void onSetPosition(Entity entity, double x, double y, double z)
	{
		for(int ii = 0; ii < entityListeners.size(); ii++)
			entityListeners.get(ii).onSetPosition(entity, x, y, z);
	}

	public static void onSetFire(Entity entity, int seconds)
	{
		for(int ii = 0; ii < entityListeners.size(); ii++)
			entityListeners.get(ii).onSetFire(entity, seconds);
	}

	public static void onFall(Entity entity, float damage)
	{
		for(int ii = 0; ii < entityListeners.size(); ii++)
			entityListeners.get(ii).onFall(entity, damage);
	}

	public static void onSetWorld(Entity entity, World world)
	{
		for(int ii = 0; ii < entityListeners.size(); ii++)
			entityListeners.get(ii).onSetWorld(entity, world);
	}

	public static void onCollideWithPlayer(Entity entity, EntityPlayer entityplayer)
	{
		for(int ii = 0; ii < entityListeners.size(); ii++)
			entityListeners.get(ii).onCollideWithPlayer(entity, ((EntityMeshPlayerMP)entityplayer));
	}

	public static void onAttacked(Entity entity, DamageSource damagesource, int damage)
	{
		for(int ii = 0; ii < entityListeners.size(); ii++)
			entityListeners.get(ii).onAttacked(entity, damagesource, damage);
	}

	public static void changeSprinting(Entity entity, boolean sprinting)
	{
		for(int ii = 0; ii < entityListeners.size(); ii++)
			entityListeners.get(ii).changeSprinting(entity, sprinting);
	}

	public static void changeEating(Entity entity, boolean eating)
	{
		for(int ii = 0; ii < entityListeners.size(); ii++)
			entityListeners.get(ii).changeEating(entity, eating);
	}
	
	public static void changeSneaking(Entity entity, boolean sneaking)
	{
		for(int ii = 0; ii < entityListeners.size(); ii++)
			entityListeners.get(ii).changeSneaking(entity, sneaking);
	}

	public static void onStruckByLightning(Entity entity, EntityLightningBolt lightningBolt)
	{
		for(int ii = 0; ii < entityListeners.size(); ii++)
			entityListeners.get(ii).onStruckByLightning(entity, lightningBolt);
	}

	public static void onKillEntity(Entity entity, EntityLiving entityliving)
	{
		for(int ii = 0; ii < entityListeners.size(); ii++)
			entityListeners.get(ii).onKillEntity(entity, entityliving);
	}

	public static void onSetInWeb(Entity entity)
	{
		for(int ii = 0; ii < entityListeners.size(); ii++)
			entityListeners.get(ii).onSetInWeb(entity);
	}
	
	public static void onExplode(Entity bomb, float ExplosionSize)
	{
		for(int ii = 0; ii < entityListeners.size(); ii++)
			entityListeners.get(ii).onExplode(bomb, ExplosionSize);
	}
	
	public static void onImpact(Entity entity, MovingObjectPosition MOP)
	{
		for(int ii = 0; ii < entityListeners.size(); ii++)
			entityListeners.get(ii).onImpact(entity, MOP);
	}

	/**************************************/
	/* EntityLiving & EntityMob functions */
	/**************************************/

	public static void onAttackOtherEntity(Entity attacker, Entity defender, DamageSource damagesource, int damage)
	{
		for(int ii = 0; ii < entityListeners.size(); ii++)
			entityListeners.get(ii).onAttackOtherEntity(attacker, defender, damagesource, damage);
	}
	
	public static void onDamageEntity(EntityLiving EL, DamageSource damagesource, int damage)
	{
		for(int ii = 0; ii < entityListeners.size(); ii++)
			entityListeners.get(ii).onDamageEntity(EL, damagesource, damage);
	}

	public static void onKnockBack(EntityLiving EL, Entity source, int i1, double d1, double d2)
	{
		for(int ii = 0; ii < entityListeners.size(); ii++)
			entityListeners.get(ii).onKnockBack(EL, source, i1, d1, d2);
	}

	public static void onDeath(EntityLiving EL, DamageSource damagesource)
	{
		for(int ii = 0; ii < entityListeners.size(); ii++)
			entityListeners.get(ii).onDeath(EL, damagesource);
	}

	public static void onSetJumping(EntityLiving EL, boolean jumping)
	{
		for(int ii = 0; ii < entityListeners.size(); ii++)
			entityListeners.get(ii).onSetJumping(EL, jumping);
	}

	public static void onJump(EntityLiving EL)
	{
		for(int ii = 0; ii < entityListeners.size(); ii++)
			entityListeners.get(ii).onJump(EL);
	}

	public static void onDespawn(EntityLiving EL)
	{
		for(int ii = 0; ii < entityListeners.size(); ii++)
			entityListeners.get(ii).onDespawn(EL);
	}

	/**************************/
	/* EntityAnimal functions */
	/**************************/

	public static void onInteract(Entity entity, EntityPlayer player)
	{
		for(int ii = 0; ii < entityListeners.size(); ii++)
			entityListeners.get(ii).onInteract(entity, (EntityMeshPlayerMP) player);
	}

	public static void onAnimalTamed(EntityTameable tameableCreature)
	{
		for(int ii = 0; ii < entityListeners.size(); ii++)
			entityListeners.get(ii).onAnimalTamed(tameableCreature);
	}
	
	/******************/
	/* Item functions */
	/******************/
	
	public static void onItemUse(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int damage) {	
		for(int ii = 0; ii < itemListeners.size(); ii++)
			itemListeners.get(ii).onItemUse(itemstack, ((EntityMeshPlayerMP)player), world, x, y, z, damage);
	}
	
	public static void onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {	
		for(int ii = 0; ii < itemListeners.size(); ii++)
			itemListeners.get(ii).onItemRightClick(itemstack, world, ((EntityMeshPlayerMP)player));
	}
	
	public static void onFoodEaten(ItemStack itemstack, World world, EntityPlayer player) {	
		for(int ii = 0; ii < itemListeners.size(); ii++)
			itemListeners.get(ii).onFoodEaten(itemstack, world, ((EntityMeshPlayerMP)player));
	}
	
	public static void onHitEntityWith(ItemStack itemstack, EntityLiving itemUser, EntityLiving enemy) {	
		for(int ii = 0; ii < itemListeners.size(); ii++)
			itemListeners.get(ii).onHitEntityWith(itemstack, itemUser, enemy);
	}
	
	public static void onBlockDestroyedWith(ItemStack itemstack, int par2, int par3, int i, int j, EntityLiving entityliving) {	
		for(int ii = 0; ii < itemListeners.size(); ii++)
			itemListeners.get(ii).onBlockDestroyedWith(itemstack, par2, par3, i, j, entityliving);
	}
	
	public static void useItemOnEntity(ItemStack itemstack, EntityLiving entityliving) {	
		for(int ii = 0; ii < itemListeners.size(); ii++)
			itemListeners.get(ii).useItemOnEntity(itemstack, entityliving);
	}
	
	public static void onCreated(ItemStack itemstack, World world, EntityPlayer entityplayer) {	
		for(int ii = 0; ii < itemListeners.size(); ii++)
			itemListeners.get(ii).onCreated(itemstack, world, ((EntityMeshPlayerMP)entityplayer));
	}
	
	public static void onPlayerStoppedUsing(ItemStack itemstack, World world, EntityPlayer entityplayer, int amtOfItem) {	
		for(int ii = 0; ii < itemListeners.size(); ii++)
			itemListeners.get(ii).onPlayerStoppedUsing(itemstack, world, ((EntityMeshPlayerMP)entityplayer), amtOfItem);
	}
}