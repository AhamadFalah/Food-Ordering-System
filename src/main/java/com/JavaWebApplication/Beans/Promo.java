package com.JavaWebApplication.Beans;

public class Promo {
	private int PromoID;
	private String PromoCodeName;
	private String PromoDesc;
	private double value;
	private String PromoImage;
	public int getPromoID() {
		return PromoID;
	}
	public void setPromoID(int promoID) {
		PromoID = promoID;
	}
	public String getPromoDesc() {
		return PromoDesc;
	}
	public void setPromoDesc(String promoDesc) {
		PromoDesc = promoDesc;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public String getPromoImage() {
		return PromoImage;
	}
	public void setPromoImage(String promoImage) {
		PromoImage = promoImage;
	}
	public String getPromoCodeName() {
		return PromoCodeName;
	}
	public void setPromoCodeName(String promoCodeName) {
		PromoCodeName = promoCodeName;
	}
	
	
}
