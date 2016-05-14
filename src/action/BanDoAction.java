package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DiaDiemForm;
import model.bo.DiaDiemBO;

public class BanDoAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		DiaDiemBO diaDiemBO = new DiaDiemBO();
		DiaDiemForm diaDiemForm = (DiaDiemForm) form;
		diaDiemForm.setListDiaDiem(diaDiemBO.getListDiaDiem());
		String search = new String(diaDiemForm.getSearch().getBytes("ISO-8859-1"), "UTF-8");
		String loaiDiaDiem = diaDiemForm.getLoaiDiaDiem();
		if (loaiDiaDiem == null) {
			diaDiemForm.setListDiaDiem(diaDiemBO.getListDiaDiem());
			System.out.println(diaDiemBO.getListDiaDiem().get(0).getTenDangNhap() + "aaaa");
		} else if (loaiDiaDiem.equals("1")) {

			diaDiemForm.setListDiaDiem(diaDiemBO.getListBenhVienSearch(""));

		}

		else if (loaiDiaDiem.equals("2")) {
			diaDiemForm.setListDiaDiem(diaDiemBO.getListNhaThuocSearch(""));
		}

		else if (loaiDiaDiem.equals("3")) {
			diaDiemForm.setListDiaDiem(diaDiemBO.getListPhongKhamSearch(""));
		}

		if ("search".equals(diaDiemForm.getSubmit())) {
			if (loaiDiaDiem.equals("1")) {
				diaDiemForm.setListDiaDiem(diaDiemBO.getListBenhVienSearch(search));
			}

			else if (loaiDiaDiem.equals("2")) {
				diaDiemForm.setListDiaDiem(diaDiemBO.getListNhaThuocSearch(search));
			}

			else if (loaiDiaDiem.equals("3")) {

				diaDiemForm.setListDiaDiem(diaDiemBO.getListPhongKhamSearch(search));
			}

			else {
				diaDiemForm.setListDiaDiem(diaDiemBO.getListDiaDiemSearch(search));
			}
		}
		return mapping.findForward("banDo");
	}

}
