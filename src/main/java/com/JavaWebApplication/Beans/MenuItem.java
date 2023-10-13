package com.JavaWebApplication.Beans;

public class MenuItem {
	private int MenuItemID;
	private String MenuItemName;
	private String MenuItemCategory;
	private String MenuItemImageUrl;
	private double MenuItemPrice;
	
	
	public MenuItem(String menuItemName, String menuItemCategory, double menuItemPrice) {
		super();
		MenuItemName = menuItemName;
		MenuItemCategory = menuItemCategory;
		MenuItemPrice = menuItemPrice;
	}
	
	public MenuItem() {
		this.MenuItemName="";
		this.MenuItemCategory="";
		this.MenuItemPrice=0;
	}
	public String getMenuItemName() {
		return MenuItemName;
	}
	public int getMenuItemID() {
		return MenuItemID;
	}

	public void setMenuItemID(int menuItemID) {
		MenuItemID = menuItemID;
	}

	public void setMenuItemName(String menuItemName) {
		MenuItemName = menuItemName;
	}
	public String getMenuItemCategory() {
		return MenuItemCategory;
	}
	public void setMenuItemCategory(String menuItemCategory) {
		MenuItemCategory = menuItemCategory;
	}
	public String getMenuItemImageUrl() {
		return MenuItemImageUrl;
	}

	public void setMenuItemImageUrl(String menuItemImageUrl) {
		MenuItemImageUrl = menuItemImageUrl;
	}
	public double getMenuItemPrice() {
		return MenuItemPrice;
	}
	public void setMenuItemPrice(double menuItemPrice) {
		MenuItemPrice = menuItemPrice;
	}

	
}
