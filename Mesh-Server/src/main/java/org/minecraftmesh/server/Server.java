package org.minecraftmesh.server;

import net.minecraft.server.MinecraftServer;

public class Server extends MinecraftServer {

	public Server() {
	}
	
	public boolean isFlightAlowed() {
		return this.allowFlight;
	}
	
	public int getMapHeightLimit() {
		return this.buildLimit;
	}

	public int getNumberOfPlayersOnline() {
		return this.getNumberOfPlayersOnline();
	}
}
