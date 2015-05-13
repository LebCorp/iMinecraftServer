package com.ipowered.server.block;

import java.util.List;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.material.MaterialData;
import org.bukkit.metadata.MetadataStoreBase;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

public class IBlockState implements BlockState {

	public static class IBlockStateMetadataStore extends MetadataStoreBase<IBlockState> {

		@Override
		protected String disambiguate(IBlockState subject, String metadataKey) {
			return "subject="+ subject.getBlock().getType().toString() + " key=" + metadataKey;
		}
	}
	
	private MetadataStoreBase<IBlockState> bukkitMetadata = new IBlockStateMetadataStore();
	private Block block;
	
	@Override
	public void setMetadata(String metadataKey, MetadataValue newMetadataValue) {
		this.bukkitMetadata.setMetadata(this, metadataKey, newMetadataValue);
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
		this.bukkitMetadata.removeMetadata(this, metadataKey, owningPlugin);
	}

	@Override
	public Block getBlock() {
		return this.block;
	}

	@SuppressWarnings("deprecation")
	@Override
	public MaterialData getData() {
		return this.block.getType().getNewData(block.getData());
	}

	@Override
	public Material getType() {
		return this.block.getType();
	}

	@Override
	public int getTypeId() {
		return this.block.getTypeId();
	}

	@Override
	public byte getLightLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public World getWorld() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Location getLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Location getLocation(Location loc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Chunk getChunk() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setData(MaterialData data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setType(Material type) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean setTypeId(int type) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(boolean force) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(boolean force, boolean applyPhysics) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public byte getRawData() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setRawData(byte data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isPlaced() {
		return false;
	}
}
