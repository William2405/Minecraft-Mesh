package org.minecraftmesh.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.minecraftmesh.server.mod.Packet300ModPayload;

import net.minecraft.src.Block;
import net.minecraft.src.CraftingManager;
import net.minecraft.src.Item;
import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;
import net.minecraft.src.NetClientHandler;
import net.minecraft.src.Packet250CustomPayload;


public class MinecraftMeshModHooks
{
	protected static boolean init = false;
	
	protected static ArrayList<Block> moddedBlocks = new ArrayList<Block>();
	protected static ArrayList<Item> moddedItems = new ArrayList<Item>();
	
	protected static boolean blockTextures[] = new boolean[256];
	protected static boolean itemSprites[] = new boolean[256];
	protected static int blockTexturesLeft = 0;
	protected static int itemSpritesLeft = 0;
	
	private static final HashMap spriteMap = new HashMap();
	
	public static void init()
	{
		if(init)
			return;
		
		init = true;
		
		String items = "--------------------------------------_---------------------------------------------------------------_---------------___-------------_---------_______-_-------_______-_-_-----______________--________________________________________________----------------";
        String blocks = "------------------------------------------------------------------------------------------------------------------------------------------------------------------------______----------________--------_____----------_______---------______-------------------";
        
        for(int i = 0; i < 256; i++)
        {
        	if(blockTextures[i] = items.charAt(i) == '-')
        		blockTexturesLeft++;
        	
        	if(itemSprites[i] = items.charAt(i) == '-')
        		itemSpritesLeft++;
        }
	}
	
	public static void addRecipe(ItemStack itemstack, Object o[])
    {
        CraftingManager.getInstance().addRecipe(itemstack, o);
    }

    public static void addShapelessRecipe(ItemStack itemstack, Object o[])
    {
        CraftingManager.getInstance().addShapelessRecipe(itemstack, o);
    }
    
    public static void registerItemSprite()
    {
    	init();
    }
    
    public static void registerBlockTexture()
    {
    	init();
    }
    
    public static void addBlock(MeshBlock block, String name)
    {
    	try
		{
			if(block == null)
			{
				MinecraftMesh.getLogger().severe("Block could't be registered because it was null.");
				return;
				
			} else if(block.blockID >= Block.blocksList.length || block.blockID <= 0)
			{
				MinecraftMesh.getLogger().severe("Block: \"" + block.getBlockName() + "\" (" + block.blockID + ") couldn't be registered because the ID was out of range.");
				return;
				
			} else if(block.blocksList[block.blockID] == null)
			{
				MinecraftMesh.getLogger().severe("Block couldn't be registered because the BlockID was already in use.");
				return;
			}
			
			ItemBlock item = new ItemBlock(block.blockID - 256);
			
			moddedBlocks.add(block);
			moddedItems.add(item);
			Item.itemsList[block.blockID] = item;
			Block.blocksList[block.blockID] = block;
			
		} catch(Exception e) {	e.printStackTrace();	}
    }
	
	public static void addBlockWithSpecialBlockItem(MeshBlock block, ItemBlock itemblock, String name)
	{
		try
		{
			if(block == null)
			{
				MinecraftMesh.getLogger().severe("Block could't be registered because it was null.");
				return;
				
			} else if(block.blockID >= Block.blocksList.length)
			{
				MinecraftMesh.getLogger().severe("Block: \"" + block.getBlockName() + "\" (" + block.blockID + ") couldn't be registered because the ID was out of range.");
				return;
				
			} else if(block.blocksList[block.blockID] == null)
			{
				MinecraftMesh.getLogger().severe("Block couldn't be registered because the BlockID was already in use.");
				return;
			}
			
			moddedBlocks.add(block);
			moddedItems.add(itemblock);
			Item.itemsList[block.blockID] = itemblock;
			Block.blocksList[block.blockID] = block;
		
		} catch(Exception e) {	e.printStackTrace();	}
	}
	
	public static void addBlockWithItem(MeshBlock block, String name)
	{
		try
		{
			if(block == null)
			{
				MinecraftMesh.getLogger().severe("Block could't be registered because it was null.");
				return;
				
			} else if(block.blockID >= Block.blocksList.length)
			{
				MinecraftMesh.getLogger().severe("Block: \"" + block.getBlockName() + "\" (" + block.blockID + ") couldn't be registered because the ID was out of range.");
				return;
			
			}
			
			ItemBlock item = new ItemBlock(block.blockID - 256);
			
			moddedBlocks.add(block);
			moddedItems.add(item);
			Item.itemsList[block.blockID] = item;
			Block.blocksList[block.blockID] = block;
			
		} catch(Exception e) {	e.printStackTrace();	}
	}
	
	public void setItemName(Item item, String name)
	{
		
	}
	
	public void setItemName(Item item, String language, String name)
	{
		
	}
	
	public void setItemName(ItemStack itemstack, String name)
	{
		
	}
	
	public void setItemName(ItemStack itemstack, String language, String name)
	{
		
	}
	
	public int getBlockTextureIndex(String path)
	{
		int index = 0;
		
		for(boolean breaking = false; index < blockTextures.length; index++)
			if(!blockTextures[index])
			{
				blockTextures[index] = true;
				blockTexturesLeft--;
				breaking = true;
				index++;
			}
		
		MinecraftMesh.getLogger().info("Adding BlockTexture: " + blockTexturesLeft + " BlockTextures left.");
		
		return index;
	}
	
	public int getItemSpriteIndex(String path)
	{
		int index = 0;
		
		for(boolean breaking = false; index < itemSprites.length; index++)
			if(!itemSprites[index])
			{
				itemSprites[index] = true;
				itemSpritesLeft--;
				breaking = true;
				index++;
			}
		
		//Object obj = (Map)spriteMap.get(Integer.valueOf(j));
		
		MinecraftMesh.getLogger().info("Adding ItemSprite: " + itemSpritesLeft + " ItemSprites left.");
		
		updateSprites();
		
		return index;
	}
	
	public static void updateAll()
	{
		updateAnimations();
		updateSprites();
		updateSpriteAnimations();
	}
	
	
	// ModLoader REGISTERALLTEXTUREOVERRIDES
	public static void updateSprites()
	{
		/*for(Iterator iterator = spriteMap.entrySet().iterator(); iterator.hasNext();)
		{
			Entry e = (Entry)iterator.next();
			
			int key = ((Integer) e.getKey()).intValue();
		}*/
	}
	
	public static void updateAnimations()
	{
		
	}
	
	public static void updateSpriteAnimations()
	{
		
	}
	
	public static void processPacket(Packet300ModPayload packet300ModPayload)
	{
		
	}
}