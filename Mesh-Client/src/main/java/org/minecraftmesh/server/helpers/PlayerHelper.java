package org.minecraftmesh.server.helpers;

import java.util.Collection;

import org.minecraftmesh.server.MinecraftMesh;

import net.minecraft.src.Block;
import net.minecraft.src.ChunkCoordinates;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityJumpHelper;
import net.minecraft.src.EntityLiving;
import org.minecraftmesh.server.EntityMeshPlayerMP;
import net.minecraft.src.FoodStats;
import net.minecraft.src.IInventory;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.Packet3Chat;
import net.minecraft.src.Potion;
import net.minecraft.src.PotionEffect;
import net.minecraft.src.TileEntityBrewingStand;
import net.minecraft.src.TileEntityDispenser;
import net.minecraft.src.TileEntityFurnace;
import net.minecraft.src.TileEntitySign;
import net.minecraft.src.World;

public class PlayerHelper
{
	public static void addMessage(EntityMeshPlayerMP player, String message)
	{
		player.addChatMessage(message);
	}
	
	public static void addExhaustion(EntityMeshPlayerMP player, float exhaust)
	{
		player.addExhaustion(exhaust);
	}
	
	public static void addExperience(EntityMeshPlayerMP player, int experience)
	{
		player.addExperience(experience);
	}
	
	public static void addPotionEffect(EntityMeshPlayerMP player, PotionEffect potioneffect)
	{
		player.addPotionEffect(potioneffect);
	}
	
	public static float getFallDistance(EntityMeshPlayerMP player)
	{
		return player.fallDistance;
	}
	
	public static void destroyCurrentEquippedItem(EntityMeshPlayerMP player)
	{
		player.destroyCurrentEquippedItem();
	}
	
	public static void detachHome(EntityMeshPlayerMP player)
	{
		player.detachHome();
	}
	
	public static void dropItemAtPosition(EntityMeshPlayerMP player, int itemID, int amt)
	{
		player.dropItem(itemID, amt);
	}
	
	public static void dropItemWithOffset(EntityMeshPlayerMP player, int itemID, int amt, float yOffset)
	{
		player.dropItemWithOffset(itemID, amt, yOffset);
	}
	
	public static void dropOneItem(EntityMeshPlayerMP player)
	{
		player.dropOneItem();
	}
	
	public static void displayGUIBrewingStand(EntityMeshPlayerMP player, TileEntityBrewingStand tileentitybrewingstand)
	{
		player.displayGUIBrewingStand(tileentitybrewingstand);
	}
	
	public static void displayGUIChest(EntityMeshPlayerMP player, IInventory iinventory)
	{
		player.displayGUIChest(iinventory);
	}
	
	public static void displayGUIDispenser(EntityMeshPlayerMP player, TileEntityDispenser tileentitydispenser)
	{
		player.displayGUIDispenser(tileentitydispenser);
	}
	
	public static void displayGUIEditSign(EntityMeshPlayerMP player, TileEntitySign tileentitysign)
	{
		player.displayGUIEditSign(tileentitysign);
	}
	
	public static void displayGUIEnchantment(EntityMeshPlayerMP player, int x, int y, int z)
	{
		player.displayGUIEnchantment(x, y, z);
	}
	
	public static void displayGUIFurnace(EntityMeshPlayerMP player, TileEntityFurnace tileentityfurnace)
	{
		player.displayGUIFurnace(tileentityfurnace);
	}
	
	public static void displayWorkbenchGUI(EntityMeshPlayerMP player, int x, int y, int z)
	{
		player.displayWorkbenchGUI(x, y, z);
	}
	
	public static void removeFire(EntityMeshPlayerMP player)
	{
		player.extinguish();
	}
	
	public static PotionEffect getActivePotionEffect(EntityMeshPlayerMP player, Potion potion)
	{
		return player.getActivePotionEffect(potion);
	}
	
	public static Collection getActivePotionEffects(EntityMeshPlayerMP player)
	{
		return player.getActivePotionEffects();
	}
	
	public static int getAge(EntityMeshPlayerMP player)
	{
		return player.getAge();
	}
	
	public static boolean canGetSpawnHere(EntityMeshPlayerMP player)
	{
		return player.getCanSpawnHere();
	}
	
	public static ItemStack getCurrentEquippedItem(EntityMeshPlayerMP player)
	{
		return player.getCurrentEquippedItem();
	}
	
	public static float getCurrentPlayerStrVsBlock(EntityMeshPlayerMP player, Block block)
	{
		return player.getCurrentPlayerStrVsBlock(block);
	}
	
	public static double getDistance(EntityMeshPlayerMP player, double x, double y, double z)
	{
		return player.getDistance(x, y, z);
	}
	
	public static double getDistanceSq(EntityMeshPlayerMP player, double x, double y, double z)
	{
		return player.getDistanceSq(x, y, z);
	}
	
	public static double getDistanceSqToEntity(EntityMeshPlayerMP player, Entity entity)
	{
		return player.getDistanceSqToEntity(entity);
	}
	
	public static float getDistanceToEntity(EntityMeshPlayerMP player, Entity entity)
	{
		return player.getDistanceToEntity(entity);
	}
	
	public static float getEyeHeight(EntityMeshPlayerMP player)
	{
		return player.getEyeHeight();
	}
	
	public static FoodStats getFoodStats(EntityMeshPlayerMP player)
	{
		return player.getFoodStats();
	}
	
	public static int getHealth(EntityMeshPlayerMP player)
	{
		return player.getHealth();
	}
	
	public static ChunkCoordinates getHomePosition(EntityMeshPlayerMP player)
	{
		return player.getHomePosition();
	}
	
	public static InventoryPlayer getInventory(EntityMeshPlayerMP player)
	{
		return player.inventory;
	}
	
	public static EntityJumpHelper getJumpHelper(EntityMeshPlayerMP player)
	{
		return player.getJumpHelper();
	}
	
	public static EntityLiving getLastAttackingEntity(EntityMeshPlayerMP player)
	{
		return player.getLastAttackingEntity();
	}
	
	public static int getMaxHealth(EntityMeshPlayerMP player)
	{
		return player.getMaxHealth();
	}
	
	public static float getMaximumHomeDistance(EntityMeshPlayerMP player)
	{
		return player.getMaximumHomeDistance();
	}
	
	public static int getTotalArmorValue(EntityMeshPlayerMP player)
	{
		return player.getTotalArmorValue();
	}
	
	public static String getUsername(EntityMeshPlayerMP player)
	{
		return player.username;
	}
	
	public static void heal(EntityMeshPlayerMP player, int health)
	{
		player.heal(health);
	}
	
	public static boolean isBlocking(EntityMeshPlayerMP player)
	{
		return player.isBlocking();
	}
	
	public static boolean isBurning(EntityMeshPlayerMP player)
	{
		return player.isBurning();
	}
	
	public static boolean isEntityAlive(EntityMeshPlayerMP player)
	{
		return player.isEntityAlive();
	}
	
	public static boolean isEntityEqual(EntityMeshPlayerMP player, Entity entity)
	{
		return player.isEntityEqual(entity);
	}
	
	public static boolean isEntityInsideOpaqueBlock(EntityMeshPlayerMP player)
	{
		return player.isEntityInsideOpaqueBlock();
	}
	
	public static boolean isImmuneToFire(EntityMeshPlayerMP player)
	{
		return player.isImmuneToFire();
	}
	
	public static boolean isInsideOfMaterial(EntityMeshPlayerMP player, Material material)
	{
		return player.isInsideOfMaterial(material);
	}
	
	public static boolean isInWater(EntityMeshPlayerMP player)
	{
		return player.isInWater();
	}
	
	public static boolean isOffsetPositionInLiquid(EntityMeshPlayerMP player, double x, double y, double z)
	{
		return player.isOffsetPositionInLiquid(x, y, z);
	}
	
	public static boolean isOnLadder(EntityMeshPlayerMP player)
	{
		return player.isOnLadder();
	}
	
	public static boolean isPlayerFullyAsleep(EntityMeshPlayerMP player)
	{
		return player.isPlayerFullyAsleep();
	}
	
	public static boolean isPlayerSleeping(EntityMeshPlayerMP player)
	{
		return player.isPlayerSleeping();
	}
	
	public static boolean isSneaking(EntityMeshPlayerMP player)
	{
		return player.isSneaking();
	}
	
	public static boolean isSprinting(EntityMeshPlayerMP player)
	{
		return player.isSprinting();
	}
	
	public static boolean isUsingItem(EntityMeshPlayerMP player)
	{
		return player.isUsingItem();
	}
	
	public static boolean isWet(EntityMeshPlayerMP player)
	{
		return player.isWet();
	}
	
	public static boolean isWithinHomeDistance(EntityMeshPlayerMP player, int x, int y, int z)
	{
		return player.isWithinHomeDistance(x, y, z);
	}
	
	public static boolean isWithinHomeDistanceCurrentPosition(EntityMeshPlayerMP player)
	{
		return player.isWithinHomeDistanceCurrentPosition();
	}
	
	public static void mountEntity(EntityMeshPlayerMP player, Entity entity)
	{
		player.mountEntity(entity);
	}
	
	public static void removeExperience(EntityMeshPlayerMP player, int experience)
	{
		player.removeExperience(experience);
	}
	
	public static boolean canHeal(EntityMeshPlayerMP player)
	{
		return player.shouldHeal();
	}
	
	public static void setDead(EntityMeshPlayerMP player)
	{
		player.setDead();
	}
	
	public static void setEating(EntityMeshPlayerMP player, boolean eating)
	{
		player.setEating(eating);
	}
	
	public static void setEntityHealth(EntityMeshPlayerMP player, int health)
	{
		player.setEntityHealth(health);
	}
	
	public static void setOnFire(EntityMeshPlayerMP player, int seconds)
	{
		player.setFire(seconds);
	}
	
	public static void setInPortal(EntityMeshPlayerMP player)
	{
		player.setInPortal();
	}
	
	public static void setInWeb(EntityMeshPlayerMP player)
	{
		player.setInWeb();
	}
	
	public static void setItemInUse(EntityMeshPlayerMP player, ItemStack itemstack, int duration)
	{
		player.setItemInUse(itemstack, duration);
	}
	
	public static void setJumping(EntityMeshPlayerMP player, boolean jumping)
	{
		player.setJumping(jumping);
	}
	
	public static void setLastAttackingEntity(EntityMeshPlayerMP player, Entity entity)
	{
		player.setLastAttackingEntity(entity);
	}
	
	public static void setLocationAndAngles(EntityMeshPlayerMP player, double x, double y, double z, float yaw, float pitch)
	{
		player.setLocationAndAngles(x, y, z, yaw, pitch);
	}
	
	public static void setMoveForward(EntityMeshPlayerMP player, float blocks)
	{
		player.setMoveForward(blocks);
	}
	
	public static void setPosition(EntityMeshPlayerMP player, double x, double y, double z)
	{
		player.setPosition(x, y, z);
	}
	
	public static void setPositionAndRotation(EntityMeshPlayerMP player, double x, double y, double z, float yaw, float pitch)
	{
		player.setPositionAndRotation(x, y, z, yaw, pitch);
	}
	
	public static void setSpawnChunk(EntityMeshPlayerMP player, double x, double y, double z)
	{
		player.setPositionAndUpdate(x, y, z);
	}
	
	public static void setSpawnChunk(EntityMeshPlayerMP player, EntityLiving entityLiving)
	{
		player.setRevengeTarget(entityLiving);
	}
	
	public static void setSneaking(EntityMeshPlayerMP player, boolean sneaking)
	{
		player.setSneaking(sneaking);
	}
	
	public static void setSpawnChunk(EntityMeshPlayerMP player, ChunkCoordinates chunkCoordinates)
	{
		player.setSpawnChunk(chunkCoordinates);
	}
	
	public static void setSprinting(EntityMeshPlayerMP player, boolean sprinting)
	{
		player.setSprinting(sprinting);
	}
	
	public static void setWorld(EntityMeshPlayerMP player, World world)
	{
		player.setWorld(world);
	}
	
	// If dimension == 1
	public static void travelToOrFromTheEnd(EntityMeshPlayerMP player, int dimension)
	{
		player.travelToTheEnd(dimension);
	}
	
	public static void kickPlayer(EntityMeshPlayerMP player, String reason) {	}
	
	public static void teleportTo(EntityMeshPlayerMP player, double x, double y, double z, float yaw, float pitch)
	{
		player.setLocationAndAngles(x, y, z, yaw, pitch);
	}
	
	public static void teleportTo(EntityMeshPlayerMP player, double x, double y, double z)
	{
		player.setLocationAndAngles(x, y, z, player.rotationYaw, player.rotationPitch);
	}
	
	public static void teleportTo(EntityMeshPlayerMP player, Entity entity)
	{
		
	}
	
	public static int getDimension(EntityMeshPlayerMP player)
	{
		return player.dimension;
	}
	
	public static int tickOfFireResistance(EntityMeshPlayerMP player)
	{
		return player.fireResistance;
	}
	
	public static void setFireResistance(EntityMeshPlayerMP player, int ticks)
	{
		player.fireResistance = ticks;
	}
	
	public static void setFireResistanceSeconds(EntityMeshPlayerMP player, int seconds)
	{
		player.fireResistance = (seconds * 20);
	}
	
	public static void increaseFireResistance(EntityMeshPlayerMP player, int ticks)
	{
		player.fireResistance += ticks;
	}
	
	public static void increaseFireResistanceSeconds(EntityMeshPlayerMP player, int seconds)
	{
		player.fireResistance += (seconds * 20);
	}
	
	public static void decreaseFireResistance(EntityMeshPlayerMP player, int ticks)
	{
		player.fireResistance -= ticks;
	}
	
	public static void decreaseFireResistanceSeconds(EntityMeshPlayerMP player, int seconds)
	{
		player.fireResistance -= (seconds * 20);
	}
	
	public static InventoryPlayer getIPInventory(EntityMeshPlayerMP player)
	{
		return player.inventory;
	}
	
	public static void setInventory(EntityMeshPlayerMP player, InventoryPlayer inventory)
	{
		player.inventory = inventory;
	}
	
	public static int getPing(EntityMeshPlayerMP player)
	{
		return 0; //return player.ping;
	}
	
	public static void sendMessageToPlayer(String playername, String message)
	{
		MinecraftMesh.getMeshedMinecraft().thePlayer.sendChatMessage(message);
	}
	
	public static void sendMessageToPlayer(EntityMeshPlayerMP player, String message)
	{
		MinecraftMesh.getMeshedMinecraft().thePlayer.sendChatMessage(message);
	}
	
	public static void sendMessageToAllOPs(String message)
	{
		MinecraftMesh.getMeshedMinecraft().thePlayer.sendChatMessage(message);
	}
	
	public static void sendPlayerToDimension(EntityMeshPlayerMP player, int dimension)
	{
		MinecraftMesh.getMeshedMinecraft().thePlayer.dimension = dimension;
	}
	
	public static void addOP(String playername) {	}
	
	public static void addOP(EntityMeshPlayerMP player) {	}
	
	public static EntityMeshPlayerMP getPlayerByUsername(String playername)
	{
		return (EntityMeshPlayerMP) MinecraftMesh.getMeshedMinecraft().thePlayer;
	}
}