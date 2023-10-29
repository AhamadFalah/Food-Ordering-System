package com.JavaWebApplication.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.JavaWebApplication.Beans.Promo;

public class PromoCodeHandler {
	
	//insert new promocode
	public boolean InsertNewPromocode(Promo p) {
		boolean result=false;
		MyDB db=new MyDB();
		Connection con=db.getCon();
		try {
			PreparedStatement stmt=con.prepareStatement("INSERT INTO promo(name,promoDesc,promovalue) VALUES(?,?,?)");
			stmt.setString(1, p.getPromoCodeName());
			stmt.setString(2, p.getPromoDesc());
			stmt.setDouble(3, p.getValue());
			result=stmt.executeUpdate()>0;
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	//ListAllPromoCodes
	public List<Promo> ListAllPromocodes(){
		List<Promo>ListAllPromos=new ArrayList<>();
		MyDB db=new MyDB();
		Connection con=db.getCon();
		ResultSet rs=null;
		try {
			PreparedStatement stmt=con.prepareStatement("SELECT * FROM promo");
			rs=stmt.executeQuery();
			while(rs.next()) {
				int promoID=rs.getInt("promoID");
				String name=rs.getString("name");
				String promoDesc=rs.getString("promoDesc");
				double value=rs.getDouble("promovalue");
				Promo p=new Promo();
				p.setPromoID(promoID);
				p.setPromoCodeName(name);
				p.setPromoDesc(promoDesc);
				p.setValue(value);
				ListAllPromos.add(p);
			}
			return ListAllPromos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ListAllPromos;
	}
	
	
	//delete promocode
	public boolean DeletePromoCode(Promo p) {
		boolean result = false;
		MyDB db=new MyDB();
		Connection con=db.getCon();
		try {
			PreparedStatement stmt=con.prepareStatement("DELETE FROM promo WHERE promoID=?");
			stmt.setInt(1, p.getPromoID());
			result=stmt.executeUpdate()>0;
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	
	//check promo code
	public ResultSet checkPromoCode(Promo p) {
		ResultSet rs = null;
		MyDB db=new MyDB();
		Connection con=db.getCon();
		try {
			PreparedStatement stmt=con.prepareStatement("SELECT * FROM promo WHERE name=?");
			stmt.setString(1, p.getPromoCodeName());
			rs=stmt.executeQuery();
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	//update promo code
	public boolean promocodeUpdate(Promo p) {
		boolean result=false;
		MyDB db=new MyDB();
		Connection con=db.getCon();
		try {
			PreparedStatement stmt=con.prepareStatement("UPDATE promo SET name=?,promoDesc=?,promovalue=? WHERE promoID=?");
			stmt.setString(1, p.getPromoCodeName());
			stmt.setString(2, p.getPromoDesc());
			stmt.setDouble(3, p.getValue());
			stmt.setInt(4, p.getPromoID());
			result=stmt.executeUpdate()>0;
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
