package form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import model.bean.AutoComplete;
import model.bean.Benh;
import model.bean.Thuoc;

public class AutoCompleteForm extends ActionForm {
	private ArrayList<AutoComplete> listBenh;
	private ArrayList<AutoComplete> listThuoc;

	public ArrayList<AutoComplete> getListThuoc() {
		return listThuoc;
	}

	public void setListThuoc(ArrayList<AutoComplete> listThuoc) {
		this.listThuoc = listThuoc;
	}

	public ArrayList<AutoComplete> getListBenh() {
		return listBenh;
	}

	public void setListBenh(ArrayList<AutoComplete> listBenh) {
		this.listBenh = listBenh;
	}
	

}
