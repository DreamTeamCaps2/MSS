package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Thuoc;
import model.bo.ThuocBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DanhSachGiaForm;

public class DanhSachBanThuocAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		DanhSachGiaForm danhSachGiaForm = (DanhSachGiaForm) form;

		ThuocBO thuocBO = new ThuocBO();
		int mathuoc = danhSachGiaForm.getMaThuoc();
		Thuoc thuoc = thuocBO.getThuoc(mathuoc);
		ArrayList<Thuoc> list;
		String kc = danhSachGiaForm.getKhoangCach();
		// set nhomThuoc, LoaiThuoc
		danhSachGiaForm.setMaLoaiThuoc(thuoc.getMaLoaiThuoc());
		danhSachGiaForm.setTenLoaiThuoc(thuoc.getTenLoaiThuoc());
		danhSachGiaForm.setMaNhomThuoc(thuoc.getMaNhomThuoc());
		danhSachGiaForm.setTenNhomThuoc(thuoc.getTenNhomThuoc());
		danhSachGiaForm.setHinhAnh(thuoc.getHinhAnh());
		danhSachGiaForm.setTenThuoc(thuoc.getTenThuoc());

		try {
			String[] akc = null;
			if (kc != null) {
				akc = kc.split(",");
			}

			String sapXep = danhSachGiaForm.getLoaiDiaDiem();
			System.out.println(sapXep + "  " + mathuoc);
			if (sapXep == null || sapXep.length() == 0) {
				list = thuocBO.getGiaListThuocTheoTen(mathuoc);
				danhSachGiaForm.setListGiaThuoc(list);
			} else if (sapXep.equals("1")) {
				list = thuocBO.getGiaListThuocTheoTen(mathuoc);

				danhSachGiaForm.setListGiaThuoc(list);
			} else if (sapXep.equals("2")) {
				list = thuocBO.getGiaListThuocTheoGia(mathuoc);
				danhSachGiaForm.setListGiaThuoc(list);

			} else {
				list = thuocBO.getGiaListThuoc(mathuoc);
				System.out.println(akc.length + "ppp" + list.size());
				int t = 0;
				for (int i = 0; i < akc.length; i++) {
					for (int j = 0; j < list.size(); j++) {

						if (list.get(j).getMaTiem().equals(akc[i])) {
							Thuoc temp = new Thuoc();
							temp = list.get(j);
							list.set(j, list.get(t));
							list.set(t, temp);
							t++;
						}
					}
				}
				danhSachGiaForm.setListGiaThuoc(list);
			}
		} catch (NullPointerException e) {
		}
		return mapping.findForward("suaSV");
	}
}
