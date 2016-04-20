package model.bean;

import java.util.ArrayList;

public class NguoiDung {

	private ArrayList<NguoiDung> listTen;
	private String userName;
	private String passWord;
	private int id;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public ArrayList<NguoiDung> getListTen() {
		return listTen;
	}
	public void setListTen(ArrayList<NguoiDung> listTen) {
		this.listTen = listTen;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
