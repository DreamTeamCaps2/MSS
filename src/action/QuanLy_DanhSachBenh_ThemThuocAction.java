package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.BenhThuocForm;
import form.ThuocBenhForm;
import model.bean.Benh;
import model.bean.Thuoc;
import model.bo.BenhBO;
import model.bo.ThuocBO;

public class QuanLy_DanhSachBenh_ThemThuocAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		BenhThuocForm benhThuocForm = (BenhThuocForm) form;
		ThuocBO thuocBO = new ThuocBO();
//		HttpSession session = request.getSession();
		int maThuocXoa = benhThuocForm.getMaThuocXoa();
		int maThuocChon = benhThuocForm.getMaThuocChon();
		
		if(!"".equals(benhThuocForm.getTimThuoc()) && benhThuocForm.getTimThuoc() != null)
			benhThuocForm.setTimThuoc(new String(benhThuocForm.getTimThuoc().getBytes("ISO-8859-1"),"UTF-8"));
		else
			benhThuocForm.setTimThuoc("");
		benhThuocForm.setListThuocTim(thuocBO.getListThuoc(benhThuocForm.getTimThuoc(),0,0));
		// luc dau vao chua chon ji ca
		benhThuocForm.setListThuocChon((ArrayList<Thuoc>) request.getSession().getAttribute("listThuoc"));
			// luc chon them thuoc vao	
			if(maThuocChon != 0 )		// neu click vo chon 1 thuoc nao do
			{
				if(kt(maThuocChon, benhThuocForm.getListThuocChon()) == 1)			// kt xem thuoc nay da co trong danh sach chon hay chua
					benhThuocForm.getListThuocChon().add(thuocBO.getThuoc(maThuocChon));							// them thuoc vao list thuoc chon
			}
			if(maThuocXoa != 0)
			{
				benhThuocForm.getListThuocChon().remove(viTri(maThuocXoa,  benhThuocForm.getListThuocChon()));
			}
		
			request.getSession().setAttribute("listThuoc", benhThuocForm.getListThuocChon());
		return mapping.findForward("themThuoc");
		
	}
	
	public int kt(int maThuocChon, ArrayList<Thuoc> listThuocChon)
	{
		for(int i=0;i<listThuocChon.size();i++)
			if(listThuocChon.get(i).getMaThuoc() == maThuocChon)
				return 0;
		return 1;
	}
	public int viTri(int maThuocXoa, ArrayList<Thuoc> listThuocChon)
	{
		for(int i=0;i<listThuocChon.size();i++)
			if(listThuocChon.get(i).getMaThuoc() == maThuocXoa)
				return i;
		return 0;
	}

}
