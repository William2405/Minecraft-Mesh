package org.minecraftmesh.server;

public class MeshCommand
{
	private EntityMeshPlayerMP P;
	private String fullCommand;
	private String commandWithoutSign;
	private String[] commandArguments;
	
	public MeshCommand(String cmd, EntityMeshPlayerMP player)
	{
		fullCommand = cmd;
		commandWithoutSign = fullCommand.substring(1);
		commandArguments = commandWithoutSign.split(" ");
		P = player;
	}
	
	public EntityMeshPlayerMP getPlayer()
	{
		return P;
	}
	
	public String[] getCommandArguments()
	{
		return commandArguments;
	}
	
	public String commandWithoutSign()
	{
		return commandWithoutSign;
	}
	
	public String getFullCommand()
	{
		return fullCommand;
	}
}
