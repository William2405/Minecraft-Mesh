package net.minecraft.src;

import java.util.Random;

import org.minecraftmesh.server.MinecraftMeshPluginHooks;


public class BlockTallGrass extends BlockFlower
{
    protected BlockTallGrass(int par1, int par2)
    {
        super(par1, par2, Material.vine);
        float f = 0.4F;
        setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.8F, 0.5F + f);
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public int getBlockTextureFromSideAndMetadata(int par1, int par2)
    {
        if (par2 == 1)
        {
            return blockIndexInTexture;
        }

        if (par2 == 2)
        {
            return blockIndexInTexture + 16 + 1;
        }

        if (par2 == 0)
        {
            return blockIndexInTexture + 16;
        }
        else
        {
            return blockIndexInTexture;
        }
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
        if (par2Random.nextInt(8) == 0)
        {
            return Item.seeds.shiftedIndex;
        }
        else
        {
            return -1;
        }
    }

    /**
     * Returns the usual quantity dropped by the block plus a bonus of 1 to 'i' (inclusive).
     */
    public int quantityDroppedWithBonus(int par1, Random par2Random)
    {
        return 1 + par2Random.nextInt(par1 * 2 + 1);
    }

    /**
     * Called when the player destroys a block with an item that can harvest it. (i, j, k) are the coordinates of the
     * block and l is the block's subtype/damage.
     */
    public void harvestBlock(World par1World, EntityPlayer par2EntityPlayer, int par3, int par4, int par5, int par6)
    {
        if (!par1World.isRemote && par2EntityPlayer.getCurrentEquippedItem() != null && par2EntityPlayer.getCurrentEquippedItem().itemID == Item.shears.shiftedIndex)
        {
        	MinecraftMeshPluginHooks.harvestBlock(par1World, par2EntityPlayer, par3, par4, par5, par6);
            par2EntityPlayer.addStat(StatList.mineBlockStatArray[blockID], 1);
            dropBlockAsItem_do(par1World, par3, par4, par5, new ItemStack(Block.tallGrass, 1, par6));
        }
        else
        {
            super.harvestBlock(par1World, par2EntityPlayer, par3, par4, par5, par6);
        }
    }
}
