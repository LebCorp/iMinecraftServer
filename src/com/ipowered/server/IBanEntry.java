package com.ipowered.server;

import java.util.Date;

import javax.swing.Icon;

import org.bukkit.BanEntry;

public class IBanEntry implements BanEntry {

	private String target;
	
	private Date created;
	
	private Date expiration;
	
	private String source;
	
	private String reason;
	
	public IBanEntry(String target, String reason, Date expires, String source, Date created) {
		this.target = target;
		this.reason = reason;
		this.expiration = expires;
		this.source = source;
		this.created = created;
	}

	@Override
	public String getTarget() {
		return this.target;
	}

	@Override
	public Date getCreated() {
		return this.created;
	}

	@Override
	public void setCreated(Date created) {
		this.created = created;
	}

	@Override
	public String getSource() {
		return this.source;
	}

	@Override
	public void setSource(String source) {
		this.source = source;
	}

	@Override
	public Date getExpiration() {
		return this.expiration;
	}

	@Override
	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

	@Override
	public String getReason() {
		return this.reason;
	}

	@Override
	public void setReason(String reason) {
		this.reason = reason;
	}

	private void writeAll() {
		IConfig.getBanEntries().set("ban." + getTarget() + ".posted", getCreated().toString());
		IConfig.getBanEntries().set("ban." + getTarget() + ".expiration", getExpiration().toString());
		IConfig.getBanEntries().set("ban." + getTarget() + ".source", getSource());
		IConfig.getBanEntries().set("ban." + getTarget() + ".reason", getReason());
	}
	
	@Override
	public void save() {
		
		if(!IConfig.getBanEntries().contains("ban." + getTarget())) {
			IConfig.getBanEntries().createSection("ban." + getTarget());
			writeAll();
		} else 
			
		if(IConfig.getBanEntries().contains("ban." + getTarget())) {
			writeAll();
		}
	}
}
