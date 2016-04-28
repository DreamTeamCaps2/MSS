package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DanhSachThuocForm;
import model.bean.LoaiThuoc;
import model.bean.NhomThuoc;
import model.bean.Thuoc;
import model.bo.ThongBaoBO;
import model.bo.ThuocBO;

public class DanhSachThuocAction extends Action{
	

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		DanhSachThuocForm danhSachThuocForm = (DanhSachThuocForm)form;
		ThuocBO thuocBO = new ThuocBO();
		ThongBaoBO thongBaoBO = new ThongBaoBO();
		int maLoaiThuoc = danhSachThuocForm.getMaLoaiThuoc();
		int maNhomThuoc = danhSachThuocForm.getMaNhomThuoc();
		System.out.println("loai thuoc"+maLoaiThuoc);
		System.out.println("nhomThuoc"+maNhomThuoc);
		ArrayList<LoaiThuoc> listLoaiThuoc = new ArrayList<LoaiThuoc>();
		ArrayList<NhomThuoc> listNhomThuoc = new ArrayList<NhomThuoc>();
		ArrayList<Thuoc> listThuoc = new ArrayList<Thuoc>();
		
		listNhomThuoc=thongBaoBO.getListNhomThuoc();
		listLoaiThuoc=thuocBO.getListLoaiThuoc();
		
		if(maLoaiThuoc==0){
			listThuoc=thuocBO.getListThuocNhomThuoc(maNhomThuoc);
		}
		else{
			listThuoc=thuocBO.getListThuocLoaiThuoc(maLoaiThuoc);
		}
		
		danhSachThuocForm.setListLoaiThuoc(listLoaiThuoc);
		danhSachThuocForm.setListNhomThuoc(listNhomThuoc);
		danhSachThuocForm.setListThuoc(listThuoc);
		danhSachThuocForm.setSoLuongThuoc(listThuoc.size());
		
		return mapping.findForward("danhSachThuoc");
	}
}
