package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.ThuocForm;
import model.bean.TaiKhoan;
import model.bean.Thuoc;
import model.bo.ThuocBO;

public class QuanLy_GiaThuoc extends Action{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session1 = request.getSession();
		
		TaiKhoan taiKhoan = (TaiKhoan)session1.getAttribute("taiKhoan");
		//String tenDangNhap = (String)session1.getAttribute("tenDangNhap");
		String maTKDN = (String)session1.getAttribute("maTKDN");
		
		ThuocBO thuocBO = new ThuocBO();
		ThuocForm thuocForm = (ThuocForm)form;
		
		ArrayList<Thuoc> listThuocCuaHang;
		listThuocCuaHang = thuocBO.getThuocCuaHang(maTKDN);
		
		for(int i=0;i<listThuocCuaHang.size();i++)
			System.out.println(listThuocCuaHang.get(i).getMaThuoc());
		
		thuocForm.setListThuoc(listThuocCuaHang);
		
		
		
		
		return mapping.findForward("listThuocCuaHang");
	}
	
	
	

}
