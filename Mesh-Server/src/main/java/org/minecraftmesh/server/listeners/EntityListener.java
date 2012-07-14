package org.minecraftmesh.server.listeners;

import net.minecraft.src.DamageSource;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityAnimal;
import net.minecraft.src.EntityLightningBolt;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntityTameable;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.World;

public abstract class EntityListener
{
	public abstract void onDeath(Entity entity);

	public abstract void onSetSize(Entity entity, float par1, float par2);

	public abstract void onSetRotation(Entity entity, float par1, float par2);

	public abstract void onSetPosition(Entity entity, double i, double j, double k);

	public abstract void onSetFire(Entity entity, int seconds);
	
	public abstract void onFall(Entity entity, float damage);

	public abstract void onSetWorld(Entity entity, World world);

	public abstract void onCollideWithPlayer(Entity entity, EntityPlayer entityplayer);

	public abstract void onAttacked(Entity entity, DamageSource damagesource, int damage);

	public abstract void changeSprinting(Entity entity, boolean sprinting);

	public abstract void changeEating(Entity entity, boolean eating);

	public abstract void onStruckByLightning(Entity entity, EntityLightningBolt lightningBolt);

	public abstract void onKillEntity(Entity entity, EntityLiving entityliving);

	public abstract void onSetInWeb(Entity entity);

	public abstract void onDamageEntity(EntityLiving EL, DamageSource damagesource, int damage);

	public abstract void onKnockBack(EntityLiving EL, Entity source, int i1, double d1, double d2);

	public abstract void onDeath(EntityLiving EL, DamageSource damagesource);

	public abstract void onSetJumping(EntityLiving EL, boolean jumping);

	public abstract void onJump(EntityLiving EL);

	public abstract void onDespawn(EntityLiving EL);

	public abstract void onInteract(Entity entity, EntityPlayer player);

	public abstract void onAnimalTamed(EntityTameable tameableCreature);
	
	public abstract void changeSneaking(Entity entity, boolean sneaking);
	
	public abstract void onExplode(Entity bomb, float size);
	
	public abstract void onImpact(Entity entity, MovingObjectPosition MOP);
	
	public abstract void onAttackOtherEntity(Entity attacker, Entity defender, DamageSource damagesource, int damage);

}