package net.minecraft.src;

import java.awt.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.MinecraftApplet;

public final class MinecraftImpl extends Minecraft
{
    /** Reference to the main frame. */
    final Frame mcFrame;

    public MinecraftImpl(Component par1Component, Canvas par2Canvas, MinecraftApplet par3MinecraftApplet, int par4, int par5, boolean par6, Frame par7Frame)
    {
        super(par1Component, par2Canvas, par3MinecraftApplet, par4, par5, par6);
        mcFrame = par7Frame;
    }

    /**
     * Displays an unexpected error that has come up during the game.
     */
    public void displayUnexpectedThrowable(UnexpectedThrowable par1UnexpectedThrowable)
    {
        mcFrame.removeAll();
        mcFrame.add(new PanelCrashReport(par1UnexpectedThrowable), "Center");
        mcFrame.validate();
    }
}
