package org.minecraftmesh.server;

import java.awt.Canvas;
import java.awt.Component;

import net.minecraft.client.Minecraft;
import net.minecraft.client.MinecraftApplet;
import net.minecraft.src.UnexpectedThrowable;

public class MeshedMinecraft extends Minecraft
{
	public MeshedMinecraft(Component par1Component, Canvas par2Canvas, 
			MinecraftApplet par3MinecraftApplet, int par4, int par5, boolean par6)
	{
		super(par1Component, par2Canvas, par3MinecraftApplet, par4, par5, par6);
	}
	
	public void displayUnexpectedThrowable(UnexpectedThrowable unexpectedthrowable) {	}
	
	public boolean isFlightAlowed() {
		return true;
	}
	
	public int getMapHeightLimit() {
		return this.getMapHeightLimit();
	}

	public int getNumberOfPlayersOnline() {
		return this.getNumberOfPlayersOnline();
	}
}