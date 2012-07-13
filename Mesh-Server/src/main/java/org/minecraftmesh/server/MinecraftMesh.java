package org.minecraftmesh.server;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.minecraftmesh.server.mod.ModLoader;
import org.minecraftmesh.server.mod.Packet300ModPayload;
import org.minecraftmesh.server.mod.ServerMod;
import org.minecraftmesh.server.plugin.Plugin;
import org.minecraftmesh.server.plugin.PluginLoader;
import org.minecraftmesh.server.plugin.PluginManager;

import net.minecraft.server.MinecraftServer;
import net.minecraft.src.EntityPlayerMP;

public class MinecraftMesh {

	private static MinecraftServer serverInstance;
	private static final PluginManager pluginManager = new PluginManager();
	private static final ModLoader modLoader = new ModLoader();
	private static boolean isModSystemOn;
	private static final Logger logger = Logger.getLogger("Minecraft");
	private static final File pluginsDir = new File("plugins");
	
	private static final int MAJOR = 1;
	private static final int MINOR = 0;
	private static final int RELEASE = 1;
	private static final int BUILD = 1;
	
	public static void loadMCMesh(MinecraftServer mcServer) {
		logger.info("Starting Minecraft Mesh " + String.format("%d.%d.%d.%d", MAJOR, MINOR, RELEASE, BUILD) + "-SERVER");
		serverInstance = mcServer;
		PluginLoader.loadPluginsFromFolder(pluginsDir, pluginManager);
		
		if((isModSystemOn = serverInstance.propertyManagerObj.getBooleanProperty("useModSystem", true)))
			modLoader.loadMods();
		
		logger.info("Finished Loading Minecraft Mesh!");
	}
	
	public static MinecraftServer getMinecraftServer() {
		return serverInstance;
	}
	
	public static Logger getLogger() {
		return logger;
	}
	
	public static boolean isModSystemOn() {
		return isModSystemOn;
	}
	
	//!INFO! All the following methods are listener hooks
	
	public static void handleWorldTick() {
		for(Plugin plugin : pluginManager.getPluginList())
		{
			plugin.onWorldTick();
		}
		
		for(ServerMod mod: modLoader.getModsList())
		{
			mod.onWorldTick();
		}
	}
	
	//Minecraft Mesh Packet ID's
	private static final int MOD_LIST = 1;
	public static void handlePacket300(Packet300ModPayload packet, EntityPlayerMP player) 
	{
		if(packet.modName.equals("MinecraftMesh"))
		{
			switch(packet.payloadId)
			{
				case MOD_LIST:
					handleModList(packet, player);
			}
		}
		else
		{
			if(!isModSystemOn)
				return;
			
			for(ServerMod mod: modLoader.getModsList())
			{
				if(mod.handlePacket(packet, ((EntityMeshPlayerMP)player)))
					return;
			}
		}
	}
	
	private static void handleModList(Packet300ModPayload packet, EntityPlayerMP player)
	{
		List<String> serverMods = new ArrayList<String>();
		for(ServerMod mod : modLoader.getModsList())
		{
			if(mod.clientSideNeeded())
				serverMods.add((mod.getModName() + "-" + mod.getVersion()));
		}
		
		List<String> clientMods = new ArrayList<String>();
		for(String modinfo: packet.stringData)
		{
			clientMods.add(modinfo);
		}
		
		List<String> neededMods = new ArrayList<String>();
		for(String mod: serverMods)
		{
			for(int i = 0; i < clientMods.size(); i++)
			{
				if(i == (clientMods.size() - 1) && !clientMods.get(i).equals(mod))
				{
					neededMods.add(mod);
				}
				
				if(clientMods.get(i).equals(mod))
					break;
			}
		}
		
		if(neededMods.size() != 0)
		{
			StringBuilder message = new StringBuilder();
			for(int i = 0; i < neededMods.size(); i++)
			{
				if(i != 0)
					message.append("\n");
				
				message.append(neededMods.get(i));
			}
			player.playerNetServerHandler.kickPlayer("Sorry but you need the following mods:\n" + message.toString());
		}
	}
}
