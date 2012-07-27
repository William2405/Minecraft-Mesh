package org.minecraftmesh.server.mod;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.minecraftmesh.server.EntityMeshPlayerMP;
import org.minecraftmesh.server.MinecraftMesh;
import org.minecraftmesh.server.MinecraftMeshModHooks;

import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet300ModPayload extends Packet {

	public String modName;
	public int payloadId;
	public int[] intData;
	public byte[] byteData;
	public String[] stringData;
	
	public void readPacketData(DataInputStream data) throws IOException {
		modName = data.readUTF();
		payloadId = data.readInt();
		
		intData = new int[data.readInt()];
		for(int i = 0; i < intData.length; i++)
		{
			intData[i] = data.readInt();
		}
		
		byteData = new byte[data.readInt()];
		for(int i = 0; i < byteData.length; i++)
		{
			byteData[i] = data.readByte();
		}
		
		stringData = new String[data.readInt()];
		for(int i = 0; i < stringData.length; i++)
		{
			stringData[i] = data.readUTF();
		}
	}

	@Override
	public void writePacketData(DataOutputStream data) throws IOException {
		data.writeUTF(modName);
		data.writeInt(payloadId);
		
		data.writeInt(intData.length);
		for(int i: intData)
		{
			data.writeInt(i);
		}
		
		data.writeInt(byteData.length);
		for(byte b: byteData)
		{
			data.writeByte(b);
		}
		
		data.writeInt(stringData.length);
		for(String string: stringData)
		{
			data.writeUTF(string);
		}
	}
	
	public void processPacket(NetHandler nethandler)
	{
		MinecraftMeshModHooks.processPacket(this);
	}
	
	public int getPacketSize()
	{
		return 5 + intData.length + byteData.length + stringData.length;
	}

	public void processPacket(EntityMeshPlayerMP playerEntity) 
	{
		//MinecraftMesh.handlePacket300(this, playerEntity);
	}
}
