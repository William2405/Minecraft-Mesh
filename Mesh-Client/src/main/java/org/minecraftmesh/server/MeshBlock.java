package org.minecraftmesh.server;

import net.minecraft.src.Block;
import net.minecraft.src.Material;

public class MeshBlock extends Block
{
	protected MeshBlock(int blockid, int picid, Material material)
	{
		super(blockid, picid, material);
	}
	
	protected MeshBlock(int blockid, Material material)
	{
		super(blockid, material);
	}
}