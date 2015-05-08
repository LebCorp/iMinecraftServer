package com.ipowered.server.entity;

import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.EulerAngle;

public class IArmorStand extends ILivingEntity implements ArmorStand {

	private ItemStack inHand;
	private ItemStack boots;
	private ItemStack helmet;
	private ItemStack chestplate;
	private ItemStack leggings;
	
	private EulerAngle bodyPose;
	private EulerAngle leftArmPose;
	private EulerAngle rightArmPose;
	private EulerAngle leftLegPose;
	private EulerAngle rightLegPose;
	private EulerAngle headPose;
	
	private boolean gravity;
	private boolean visible;
	private boolean arms;
	private boolean small;
	private boolean basePlate;
	
	public IArmorStand(Server server, Location location) {
		super(server, location, EntityType.ARMOR_STAND);
	}

	@Override
	public ItemStack getItemInHand() {
		return this.inHand;
	}

	@Override
	public void setItemInHand(ItemStack item) {
		this.inHand = item;
	}

	@Override
	public ItemStack getBoots() {
		return this.boots;
	}

	@Override
	public void setBoots(ItemStack item) {
		this.boots = item;
	}

	@Override
	public ItemStack getLeggings() {
		return this.leggings;
	}

	@Override
	public void setLeggings(ItemStack item) {
		this.leggings = item;
	}

	@Override
	public ItemStack getChestplate() {
		return this.chestplate;
	}

	@Override
	public void setChestplate(ItemStack item) {
		this.chestplate = item;
	}

	@Override
	public ItemStack getHelmet() {
		return this.helmet;
	}

	@Override
	public void setHelmet(ItemStack item) {
		this.helmet = item;
	}

	@Override
	public EulerAngle getBodyPose() {
		return this.bodyPose;
	}

	@Override
	public void setBodyPose(EulerAngle pose) {
		this.bodyPose = pose;
	}

	@Override
	public EulerAngle getLeftArmPose() {
		return this.leftArmPose;
	}

	@Override
	public void setLeftArmPose(EulerAngle pose) {
		this.leftArmPose = pose;
	}

	@Override
	public EulerAngle getRightArmPose() {
		return this.rightArmPose;
	}

	@Override
	public void setRightArmPose(EulerAngle pose) {
		this.rightArmPose = pose;
	}

	@Override
	public EulerAngle getLeftLegPose() {
		return this.leftLegPose;
	}

	@Override
	public void setLeftLegPose(EulerAngle pose) {
		this.leftLegPose = pose;
	}

	@Override
	public EulerAngle getRightLegPose() {
		return this.rightLegPose;
	}

	@Override
	public void setRightLegPose(EulerAngle pose) {
		this.rightLegPose = pose;
	}

	@Override
	public EulerAngle getHeadPose() {
		return this.headPose;
	}

	@Override
	public void setHeadPose(EulerAngle pose) {
		this.headPose = pose;
	}

	@Override
	public boolean hasBasePlate() {
		return this.basePlate;
	}

	@Override
	public void setBasePlate(boolean basePlate) {
		this.basePlate = basePlate;
	}

	@Override
	public boolean hasGravity() {
		return this.gravity;
	}

	@Override
	public void setGravity(boolean gravity) {
		this.gravity = gravity;
	}

	@Override
	public boolean isVisible() {
		return this.visible;
	}

	@Override
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	@Override
	public boolean hasArms() {
		return this.arms;
	}

	@Override
	public void setArms(boolean arms) {
		this.arms = arms;
	}

	@Override
	public boolean isSmall() {
		return this.small;
	}

	@Override
	public void setSmall(boolean small) {
		this.small = small;
	}

	@Override
	public Sound getHurtSound() {
		return Sound.ARMORSTAND_HIT;
	}

	@Override
	public Sound getDeathSound() {
		return Sound.ARMORSTAND_DEATH;
	}
}
