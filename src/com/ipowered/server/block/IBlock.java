package com.ipowered.server.block;

import java.util.Collection;
import java.util.List;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.block.PistonMoveReaction;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.MetadataStoreBase;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

import com.ipowered.server.Position;

public class IBlock implements Block {

	public static class BlockMetadataStore extends MetadataStoreBase<Block> {
		@Override
		protected String disambiguate(Block subject, String metadataKey) {
			return "block:" + subject.getType().name() + " key:" + metadataKey;
		}
	}

	private MetadataStoreBase<Block> bukkitMetadata = new BlockMetadataStore();
	private Material blockType;
	private byte data;
	private int typeId;
	private Location location;
	private Chunk chunk;
	private Biome biome;

	public IBlock(int typeId) {
		this.typeId = typeId;
		this.blockType = getType();
	}

	@Override
	public void setMetadata(String metadataKey, MetadataValue newMetadataValue) {
		bukkitMetadata.setMetadata(this, metadataKey, newMetadataValue);
	}

	@Override
	public List<MetadataValue> getMetadata(String metadataKey) {
		return bukkitMetadata.getMetadata(this, metadataKey);
	}

	@Override
	public boolean hasMetadata(String metadataKey) {
		return bukkitMetadata.hasMetadata(this, metadataKey);
	}

	@Override
	public void removeMetadata(String metadataKey, Plugin owningPlugin) {
		bukkitMetadata.removeMetadata(this, metadataKey, owningPlugin);
	}

	@Override
	public byte getData() {
		return this.data;
	}

	@Override
	public Block getRelative(int modX, int modY, int modZ) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Block getRelative(BlockFace face) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Block getRelative(BlockFace face, int distance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Material getType() {
		return Material.getMaterial(getTypeId());
	}

	@Override
	public int getTypeId() {
		return this.typeId;
	}

	@Override
	public byte getLightLevel() {
		return 0;
	}

	@Override
	public byte getLightFromSky() {
		return 0;
	}

	@Override
	public byte getLightFromBlocks() {
		return 0;
	}

	@Override
	public World getWorld() {
		return getChunk().getWorld();
	}

	@Override
	public int getX() {
		return (int) getLocation().getBlockX();
	}

	@Override
	public int getY() {
		return (int) getLocation().getBlockY();
	}

	@Override
	public int getZ() {
		return (int) getLocation().getZ();
	}

	@Override
	public Location getLocation() {
		return this.location;
	}

	@Override
	public Location getLocation(Location loc) {
		return Position.copyOf(this.location, loc);
	}

	@Override
	public Chunk getChunk() {
		return this.chunk;
	}

	@Override
	public void setData(byte data) {
		setData(data, true);
	}

	@Override
	public void setData(byte data, boolean applyPhysics) {

	}

	@Override
	public void setType(Material type) {
		setType(type, true);
	}

	@Override
	public void setType(Material type, boolean applyPhysics) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean setTypeId(int type) {
		return setTypeId(type, true);
	}

	@Override
	public boolean setTypeId(int type, boolean applyPhysics) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setTypeIdAndData(int type, byte data, boolean applyPhysics) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BlockFace getFace(Block block) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BlockState getState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Biome getBiome() {
		return this.biome;
	}

	@Override
	public void setBiome(Biome bio) {
		this.biome = bio;
	}

	@Override
	public boolean isBlockPowered() {
		return false;
	}

	@Override
	public boolean isBlockIndirectlyPowered() {
		return false;
	}

	@Override
	public boolean isBlockFacePowered(BlockFace face) {
		return false;
	}

	@Override
	public boolean isBlockFaceIndirectlyPowered(BlockFace face) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getBlockPower(BlockFace face) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getBlockPower() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public boolean isLiquid() {
		return !blockType.isSolid();
	}

	@Override
	public double getTemperature() {
		return 0;
	}

	@Override
	public double getHumidity() {
		return 0;
	}

	@Override
	public PistonMoveReaction getPistonMoveReaction() {
		if (blockType == Material.BEDROCK || blockType == Material.OBSIDIAN)
			return PistonMoveReaction.BLOCK;
		
		else if (blockType == Material.BED)
			return PistonMoveReaction.BREAK;
		
		else
			return PistonMoveReaction.MOVE;
	}

	@Override
	public boolean breakNaturally() {
		return false;
	}

	@Override
	public boolean breakNaturally(ItemStack tool) {
		return false;
	}

	@Override
	public Collection<ItemStack> getDrops() {
		return null;
	}

	@Override
	public Collection<ItemStack> getDrops(ItemStack tool) {
		return null;
	}
}
