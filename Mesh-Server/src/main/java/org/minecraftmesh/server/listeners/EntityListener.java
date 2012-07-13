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

public class EntityListener implements IListenerBase
{
	public void onDeath(Entity entity) {	}

	public void onSetSize(Entity entity, float par1, float par2) {	}

	public void onSetRotation(Entity entity, float par1, float par2) {	}

	public void onSetPosition(Entity entity, double i, double j, double k) {	}

	public void onSetFire(Entity entity, int seconds) {	}
	
	public void onFall(Entity entity, float damage) {	}

	public void onSetWorld(Entity entity, World world) {	}

	public void onCollideWithPlayer(Entity entity, EntityPlayer entityplayer) {	}

	public void onAttacked(Entity entity, DamageSource damagesource, int damage) {	}

	public void changeSprinting(Entity entity, boolean sprinting) {	}

	public void changeEating(Entity entity, boolean eating) {	}

	public void onStruckByLightning(Entity entity, EntityLightningBolt lightningBolt) {	}

	public void onKillEntity(Entity entity, EntityLiving entityliving) {	}

	public void onSetInWeb(Entity entity) {	}

	public void onDamageEntity(EntityLiving EL, DamageSource damagesource, int damage) {	}

	public void onKnockBack(EntityLiving EL, Entity source, int i1, double d1, double d2) {	}

	public void onDeath(EntityLiving EL, DamageSource damagesource) {	}

	public void onSetJumping(EntityLiving EL, boolean jumping) {	}

	public void onJump(EntityLiving EL) {	}

	public void onDespawn(EntityLiving EL) {	}

	public void onInteract(Entity entity, EntityPlayer player) {	}

	public void onAnimalTamed(EntityTameable tameableCreature) {	}
	
	public void changeSneaking(Entity entity, boolean sneaking) {	}
	
	public void onExplode(Entity bomb, float size) {	}
	
	public void onImpact(Entity entity, MovingObjectPosition MOP) {	}
	
	public void onAttackOtherEntity(Entity attacker, Entity defender, DamageSource damagesource, int damage) {	}

	public String getListenerName() {
		return "EntityListener";
	}

	public boolean canBeRegistedBy(int registerType) {
		return (registerType == 1 || registerType == 2);
	}
}