package com.ipowered.server.inventory.meta;

import java.util.Collections;
import java.util.List;

import org.bukkit.inventory.meta.BookMeta;

import com.google.common.collect.Lists;

public class IBookMeta extends IItemMeta implements BookMeta {

	private String title;
	private String author;
	private List<String> pages;
	
	public IBookMeta() {
	}
	
	@Override
	public boolean hasTitle() {
		return this.title != null;
	}

	@Override
	public String getTitle() {
		return this.title;
	}

	@Override
	public boolean setTitle(String title) {
		this.title = title;
		return this.title.length() <= 16;
	}

	@Override
	public boolean hasAuthor() {
		return this.author != null;
	}

	@Override
	public String getAuthor() {
		return this.author;
	}

	@Override
	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public boolean hasPages() {
		return pages.size() != 0;
	}

	@Override
	public String getPage(int page) {
		return pages.get(page);
	}

	@Override
	public void setPage(int page, String data) {
		pages.set(page, data);
	}

	@Override
	public List<String> getPages() {
		return this.pages;
	}

	@Override
	public void setPages(List<String> pages) {
		this.pages = pages;
	}

	@Override
	public void setPages(String... pages) {
		this.pages = Lists.newArrayList(pages);
	}

	@Override
	public void addPage(String... pages) {
		if(pages.length == 0) {
			throw new IllegalArgumentException("You can't add 0 page !");
		} else {
			Collections.addAll(this.pages, pages);
		}
	}

	@Override
	public int getPageCount() {
		return this.pages.size();
	}

	@Override
	public BookMeta clone() {
		
		IBookMeta result = new IBookMeta();
		result.author = this.author;
		result.pages = this.pages;
		result.title = this.title;
		
		return result;
	}
}
