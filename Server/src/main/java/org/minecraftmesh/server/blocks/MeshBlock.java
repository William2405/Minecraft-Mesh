package org.minecraftmesh.server.blocks;

public class MeshBlock
{
	public static MeshBlock blockList[] = new MeshBlock[256];
	
	public static final MeshBlock DIRT = new Dirt(3);
	
	protected int blockID = 0;
	protected int textureID;
	
	private boolean init = false;
	protected String name;
	
	protected float minBoundsOffsetX, minBoundsOffsetY, minBoundsOffsetZ = 0F;
	protected float maxBoundsOffsetX, maxBoundsOffsetY, maxBoundsOffsetZ = 1F;
	
	protected MeshBlock(int blockid)
	{
		if(blockList[blockid] == null)
		{
			blockList[blockid] = this;
			
			blockID = blockid;
			
		} else {
			
			// getLogger.warning(message);
		}
	}
	
	protected MeshBlock(int blockid, int texture)
	{
		this(blockid);
	}
	
	public void init()
	{
		if(!init)
		{
			init = true;
			
			// Add blocks from mods
		}
	}
	
	protected void setBounds(float minboundsoffsetx, float minboundsoffsety, float minboundsoffsetz,
			float maxboundsoffsetx, float maxboundsoffsety, float maxboundsoffsetz)
	{
		minBoundsOffsetX = minboundsoffsetx;
		minBoundsOffsetY = minboundsoffsety;
		minBoundsOffsetZ = minboundsoffsetz;
		maxBoundsOffsetX = maxboundsoffsetx;
		maxBoundsOffsetY = maxboundsoffsety;
		maxBoundsOffsetZ = maxboundsoffsetz;
	}
	
	protected void setName(String blockName)
	{
		name = blockName;
	}
	
	public String getName()
	{
		return name;
	}
}