package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.ThongBaoForm;
import model.bo.BaiVietBO;
import model.bo.TaiKhoanBO;
import model.bo.ThongBaoBO;
import model.bo.ThuocBO;

public class HomeAction extends Action{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		/*TaiKhoanForm taiKhoanForm = (TaiKhoanForm) form;
		TaiKhoanBO taiKhoanBO = new TaiKhoanBO();
		
		ArrayList<TaiKhoan> listND = taiKhoanBO.getListNguoiDung();
		taiKhoanForm.setListND(listND);
		request.setAttribute("listND", listND);*/
		
		ThongBaoForm thongBaoForm = (ThongBaoForm) form;
		ThongBaoBO thongBaoBO = new ThongBaoBO();
		ThuocBO thuocBO = new ThuocBO();
		TaiKhoanBO taiKhoanBO = new TaiKhoanBO();
		BaiVietBO baiVietBO = new BaiVietBO();
		
		thongBaoForm.setListThongBao(thongBaoBO.getListThongBao());
		thongBaoForm.setSoLuong(thongBaoBO.getListThongBao().size());
		thongBaoForm.setListLoaiThuoc(thuocBO.getListLoaiThuoc());
		thongBaoForm.setListNhomThuoc(thongBaoBO.getListNhomThuoc());
		thongBaoForm.setListLoaiBenh(thongBaoBO.getListLoaiBenh());
		thongBaoForm.setSoLuongLoaiThuoc(thuocBO.getListLoaiThuoc().size());
		thongBaoForm.setSoLuongNhomThuoc(thongBaoBO.soLuongNhomThuoc());
		thongBaoForm.setListND(taiKhoanBO.getListNguoiDung());
		thongBaoForm.setSoLuongLoaiBenh(thongBaoBO.getListLoaiBenh().size());
		thongBaoForm.setListBaiViet(baiVietBO.getListBaiViet());
		
		request.getSession().setAttribute("thongBaoForm", thongBaoForm);
		
		return mapping.findForward("thanhCong");
	}

}
