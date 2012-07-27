package org.minecraftmesh.server;

import java.io.File;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.minecraftmesh.server.mod.ModLoader;
import org.minecraftmesh.server.mod.Packet300ModPayload;
import org.minecraftmesh.server.mod.ServerMod;
import org.minecraftmesh.server.plugin.Plugin;
import org.minecraftmesh.server.plugin.PluginLoader;

import net.minecraft.client.Minecraft;
import net.minecraft.src.Block;

public class MinecraftMesh {

	private static Minecraft clientInstance;
	private static final PluginLoader pluginLoader = new PluginLoader();
	private static final ModLoader modLoader = new ModLoader();
	private static boolean isModSystemOn;
	private static final Logger logger = Logger.getLogger("Minecraft");
	private static final File pluginsDir = new File("plugins");
	
	protected static PropertyManager propertymanager = new PropertyManager(new File("cheese.manwhore"));
	public static final String commandSign = propertymanager.getStringProperty("commandCharacter", "/");
	
	private static final int MAJOR = 1;
	private static final int MINOR = 0;
	private static final int RELEASE = 1;
	private static final int BUILD = 1;
	
	private static boolean loaded = false;
	
	public static void loadMCMesh(Minecraft client) {
		
		if(!loaded)
		{
			loaded = true;
			
			logger.info("Starting Minecraft Mesh " + String.format("%d.%d.%d.%d", MAJOR, MINOR, RELEASE, BUILD) + "-SERVER");
			clientInstance = client;
			pluginLoader.loadPluginsFromFolder();
			
			if((isModSystemOn = propertymanager.getBooleanProperty("useModSystem", true)))
				modLoader.loadMods();
			
			logger.info("Finished Loading Minecraft Mesh!");
		}
	}
	
	public static MeshedMinecraft getMeshedMinecraft() {
		return (MeshedMinecraft) clientInstance;
	}
	
	public static Logger getLogger() {
		return logger;
	}
	
	public static boolean isModSystemOn() {
		return isModSystemOn;
	}
	
	public void getWorld()
	{
		
	}
	
	//!INFO! All the following methods are listener hooks
	
	public static void handleWorldTick() {
		for(Plugin plugin : pluginLoader.getPluginList())
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
	/*public static void handlePacket300(Packet300ModPayload packet, EntityMeshPlayerMP player) 
	{
		if(packet.modName.equals("MinecraftMesh"))
		{
			if(packet.payloadId == MOD_LIST)
				handleModList(packet, player);
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
	
	private static void handleModList(Packet300ModPayload packet, EntityMeshPlayerMP player)
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
	}*/

	public static String getCommandSign()
	{
		return commandSign;
	}
	
	public PropertyManager getPropertyManager()
	{
		return propertymanager;
	}
}
