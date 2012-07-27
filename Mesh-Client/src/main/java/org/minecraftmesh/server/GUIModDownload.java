package org.minecraftmesh.server;

import java.util.List;

import org.minecraftmesh.server.mod.ModLoader;
import org.minecraftmesh.server.mod.ServerMod;

import net.minecraft.src.GuiScreen;
import net.minecraft.src.NetClientHandler;


class GUIModDownload extends GuiScreen
{
	private static NetClientHandler localClientHandler;
	private static List<ServerMod> modlist;
	private static List<ServerMod> ourMods;
	private static List<ServerMod> modsToUpdate;
	private static List<ServerMod> newMods;
	
	public GUIModDownload(NetClientHandler netclienthandler, List<ServerMod> serverMods)
	{
		modlist = serverMods;
		ourMods = ModLoader.getModsList();
		
		boolean finished = false;
		
		for(int i = 0; i < modlist.size(); i++)
		{
			finished = false;
			
			for(int j = 0; j < ourMods.size(); j++)
			{
				/*if(!finished)
					if(modlist.get(i).getModName() == ourMods.get(j).getModName())
						if(modlist.get(i).getVersion() == ourMods.get(j).getVersion())
						{
							modsToUpdate
							
						} else {
							
							
						}*/
			}
		}
	}
}