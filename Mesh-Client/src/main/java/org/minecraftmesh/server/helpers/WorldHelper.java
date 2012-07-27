package org.minecraftmesh.server.helpers;

import java.util.List;

import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.Block;
import net.minecraft.src.ChunkCoordinates;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Material;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;
import net.minecraft.src.WorldChunkManager;
import net.minecraft.src.WorldInfo;

import org.minecraftmesh.server.EntityMeshPlayerMP;
import org.minecraftmesh.server.MinecraftMesh;

public class WorldHelper
{
	public static World getWorld(int dimension)
	{
		return null;
	}
	
	public static void addToTime(int dimension, long extraInGameTime)
	{
		getWorld(dimension).setWorldTime(getWorld(dimension).getWorldTime() + extraInGameTime);
	}
	
	public static boolean blockExists(int dimension, int x, int y, int z)
	{
		return getWorld(dimension).blockExists(x, y, z);
	}
	
	public static boolean canBlockBePlacedAt(int dimension, int blockID, int x, int y, int z, boolean ignoreEntities, int damage)
	{
		return getWorld(dimension).canBlockBePlacedAt(blockID, x, y, z, ignoreEntities, damage);
	}
	
	public static boolean canBlockSeeSky(int dimension, int x, int y, int z)
	{
		return getWorld(dimension).canBlockSeeTheSky(x, y, z);
	}
	
	public static boolean canLightningStrikeAt(int dimension, int x, int y, int z)
	{
		return getWorld(dimension).canLightningStrikeAt(x, y, z);
	}
	
	public static boolean canMineBlock(int dimension, EntityMeshPlayerMP player, int x, int y, int z)
	{
		return getWorld(dimension).canMineBlock(player, x, y, z);
	}
	
	public static boolean canSnowAt(int dimension, int x, int y, int z)
	{
		return getWorld(dimension).canSnowAt(x, y, z);
	}
	
	// ChunkExists needs to be placed here
	
	public static void toggleDownfall(int dimension)
	{
		if(getWorld(dimension).getRainStrength() > 0F)
			getWorld(dimension).setRainStrength(0F);
		else
			getWorld(dimension).setRainStrength(1F);
	}
	
	public static int amtEntitiesOf_entity_InThisWorld(int dimension, Entity entity)
	{
		return getWorld(dimension).countEntities(entity.getClass());
	}
	
	public static void createExplosion(int dimension, Entity entity, double x, double y, double z, float explosionStrength)
	{
		getWorld(dimension).createExplosion(entity, x, y, z, explosionStrength);
	}
	
	// FindClosestStructure needs to be placed here
	
	public static BiomeGenBase kaas(int dimension, int chunkX, int chunkY)
	{
		return getWorld(dimension).getBiomeGenForCoords(chunkX, chunkY);
	}
	
	public static int getBlockID(int dimension, int x, int y, int z)
	{
		return getWorld(dimension).getBlockId(x, y, z);
	}
	
	public static int getBlockLightValue(int dimension, int x, int y, int z)
	{
		return getWorld(dimension).getBlockLightValue(x, y, z);
	}
	
	public static Material getBlockMaterial(int dimension, int x, int y, int z)
	{
		return getWorld(dimension).getBlockMaterial(x, y, z);
	}
	
	public static int getBlockMetadata(int dimension, int x, int y, int z)
	{
		return getWorld(dimension).getBlockMetadata(x, y, z);
	}
	
	public static TileEntity getBlockTileEntity(int dimension, int x, int y, int z)
	{
		return getWorld(dimension).getBlockTileEntity(x, y, z);
	}
	
	public static EntityPlayer getClosestPlayer(int dimension, double x, double y, double z, double maxDistance)
	{
		return getWorld(dimension).getClosestPlayer(x, y, z, maxDistance);
	}
	
	public static int a(int dimension, int x, int z)
	{
		return getWorld(dimension).getFirstUncoveredBlock(x, z);
	}
	
	// GetPathEntityToEntity
	
	public static EntityMeshPlayerMP getPlayerByName(int dimension, String playername)
	{
		return (EntityMeshPlayerMP) getWorld(dimension).getPlayerEntityByName(playername);
	}
	
	public static long seed(int dimension)
	{
		return getWorld(dimension).getSeed();
	}
	
	public static ChunkCoordinates getSpawnPoint(int dimension)
	{
		return getWorld(dimension).getSpawnPoint();
	}
	
	public static WorldChunkManager getWorldChunkManager(int dimension)
	{
		return getWorld(dimension).getWorldChunkManager();
	}
	
	public static WorldInfo getWorldInfo(int dimension)
	{
		return getWorld(dimension).getWorldInfo();
	}
	
	public static long getWorldTime(int dimension)
	{
		return getWorld(dimension).getWorldTime();
	}
	
	// IsBlock((in)directly)Hydrated
	
	public static void isAirBlock(int dimension, int x, int y, int z)
	{
		getWorld(dimension).isAirBlock(x, y, z);
	}
	
	public static boolean areAllPlayersAsleep(int dimension)
	{
		return getWorld(dimension).isAllPlayersFullyAsleep();
	}
	
	public static boolean isDaytime(int dimension)
	{
		return getWorld(dimension).isDaytime();
	}
	
	public static boolean isRaining(int dimension)
	{
		return getWorld(dimension).isRaining();
	}
	
	public static boolean isThundering(int dimension)
	{
		return getWorld(dimension).isThundering();
	}
	
	public static void setBlock(int dimension, int x, int y, int z, int blockID)
	{
		getWorld(dimension).setBlock(x, y, z, blockID);
	}
	
	// Set block and metadata
	
	public static void setTime(int dimension, long time)
	{
		getWorld(dimension).setWorldTime(time);
	}
	
	// Spawnparticle
	
	public static void markNeedsUpdate(int dimension, int x, int y, int z)
	{
		getWorld(dimension).markBlockAsNeedsUpdate(x, y, z);
	}
	
	public static void markNeedsRenderUpdate(int dimension, int x, int y, int z)
	{
		getWorld(dimension).markBlockNeedsUpdate(x, y, z);
	}
	
	public static void markTileEntityForDespawn(int dimension, TileEntity tileEntity)
	{
		getWorld(dimension).markTileEntityForDespawn(tileEntity);
	}
	
	public static void notify(int dimension)
	{
		getWorld(dimension).notify();
	}
	
	public static void notifyAll(int dimension)
	{
		getWorld(dimension).notifyAll();
	}
	
	// Play Sounds
	
	public static void removeBlockTileEntity(int dimension, int x, int y, int z)
	{
		getWorld(dimension).removeBlockTileEntity(x, y, z);
	}
	
	// Schedule block updates
	
	public static void setBlockTileEntity(int dimension, int x, int y, int z, TileEntity tileEntity)
	{
		getWorld(dimension).setBlockTileEntity(x, y, z, tileEntity);
	}
	
	public static void setBlockWithNotify(int dimension, int x, int y, int z, int l)
	{
		getWorld(dimension).setBlockWithNotify(x, y, z, l);
	}
	
	public static void setEntityDead(int dimension, Entity entity)
	{
		getWorld(dimension).setEntityDead(entity);
	}
	
	public static void setEntityState(int dimension, Entity entity, byte byte0)
	{
		getWorld(dimension).setEntityState(entity, byte0);
	}
	
	public static void spawnEntity(int dimension, Entity entity)
	{
		getWorld(dimension).spawnEntityInWorld(entity);
	}
	
	public static void tick(int dimension)
	{
		getWorld(dimension).tick();
	}
	
	public static void unloadEntitiesInList(int dimension, List list)
	{
		getWorld(dimension).unloadEntities(list);
	}
	
	public static void updateSleepingPlayers(int dimension)
	{
		getWorld(dimension).updateAllPlayersSleepingFlag();
	}
	
	public static void updateAllEntities(int dimension)
	{
		getWorld(dimension).updateEntities();
	}
	
	public static void updateEntity(int dimension, Entity entity)
	{
		getWorld(dimension).updateEntity(entity);
	}
	
	public static void updateEntityWithOptionalForce(int dimension, Entity entity, boolean forced)
	{
		getWorld(dimension).updateEntityWithOptionalForce(entity, forced);
	}
	
	public static boolean updateLighting(int dimension)
	{
		return getWorld(dimension).updatingLighting();
	}
	
	public static double getDistanceBetweenEntityAndCoordinates(int dimension, Entity entity, double x, double y, double z)
	{
		return entity.getDistanceSq(x, y, z);
	}
	
	public static double getDistanceBetweenEntities(Entity e0, Entity e1)
	{
		return e0.getDistanceSqToEntity(e1);
	}
	
	public static List getPlayers(int dimension)
	{
		return getWorld(dimension).playerEntities;
	}
	
	public static List getLoadedEntities(int dimension)
	{
		return getWorld(dimension).loadedEntityList;
	}
}