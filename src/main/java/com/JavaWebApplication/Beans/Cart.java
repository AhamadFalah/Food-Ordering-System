package com.JavaWebApplication.Beans;

public class Cart extends MenuItem{
private int Quantity;
private int CardID;
private int userID;

public int getCardID() {
	return CardID;
}

public void setCardID(int cardID) {
	CardID = cardID;
}

public int getQuantity() {
	return Quantity;
}

public void setQuantity(int quantity) {
	Quantity = quantity;
}

public int getUserID() {
	return userID;
}

public void setUserID(int userID) {
	this.userID = userID;
}


}
