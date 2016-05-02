package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DanhSachBenhForm;
import model.bean.Benh;
import model.bean.LoaiBenh;
import model.bo.BenhBO;
import model.bo.ThongBaoBO;

public class DanhSachBenhAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		DanhSachBenhForm danhSachBenhForm  = (DanhSachBenhForm)form;
		BenhBO benhBO = new BenhBO();
		
		ThongBaoBO thongBaoBO = new ThongBaoBO();
		int maLoaiDanhSach = danhSachBenhForm.getMaLoaiDanhSach();
		ArrayList<Benh> listBenh  = new ArrayList<Benh>();
		ArrayList<LoaiBenh> listLoaiBenh = new ArrayList<LoaiBenh>();
		
		listLoaiBenh=thongBaoBO.getListLoaiBenh();
		listBenh = benhBO.getListBenhDanhSach(maLoaiDanhSach);
		
		Variable.getTB(mapping,form,request,response);
		
		danhSachBenhForm.setListBenh(listBenh);
		danhSachBenhForm.setListLoaiBenh(listLoaiBenh);
		danhSachBenhForm.setSoLuongBenh(listBenh.size());

		return mapping.findForward("danhSachBenh");
	}

}
