package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.BenhTrieuChungForm;
import model.bean.TrieuChung;
import model.bo.TrieuChungBO;

public class QuanLy_DanhSachBenh_SuaTrieuChungAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		BenhTrieuChungForm benhTrieuChungForm = (BenhTrieuChungForm) form;
		TrieuChungBO trieuChungBO = new TrieuChungBO();
//		HttpSession session = request.getSession();
		int maTrieuChungXoa = benhTrieuChungForm.getMaTrieuChungXoa();
		int maTrieuChungChon = benhTrieuChungForm.getMaTrieuChungChon();
		
		if(!"".equals(benhTrieuChungForm.getTimTrieuChung()) && benhTrieuChungForm.getTimTrieuChung() != null)
			benhTrieuChungForm.setTimTrieuChung(new String(benhTrieuChungForm.getTimTrieuChung().getBytes("ISO-8859-1"),"UTF-8"));
		else
			benhTrieuChungForm.setTimTrieuChung("");
		benhTrieuChungForm.setListTrieuChungTim(trieuChungBO.getListTrieuChung(benhTrieuChungForm.getTimTrieuChung()));
		// luc dau vao chua chon ji ca
		benhTrieuChungForm.setListTrieuChungChon((ArrayList<TrieuChung>) request.getSession().getAttribute("listTrieuChung"));
			// luc chon them thuoc vao	
			if(maTrieuChungChon != 0 )		// neu click vo chon 1 thuoc nao do
			{
				if(kt(maTrieuChungChon, benhTrieuChungForm.getListTrieuChungChon()) == 1)			// kt xem thuoc nay da co trong danh sach chon hay chua
					benhTrieuChungForm.getListTrieuChungChon().add(trieuChungBO.getTrieuChung(maTrieuChungChon));							// them thuoc vao list thuoc chon
			}
			if(maTrieuChungXoa != 0)
			{
				benhTrieuChungForm.getListTrieuChungChon().remove(viTri(maTrieuChungXoa,  benhTrieuChungForm.getListTrieuChungChon()));
			}
		
			request.getSession().setAttribute("listTrieuChung", benhTrieuChungForm.getListTrieuChungChon());
		return mapping.findForward("suaTrieuChung");
		
	}
	
	public int kt(int maTrieuChungChon, ArrayList<TrieuChung> listTrieuChungChon)
	{
		for(int i=0;i<listTrieuChungChon.size();i++)
			if(listTrieuChungChon.get(i).getMaTrieuChung() == maTrieuChungChon)
				return 0;
		return 1;
	}
	public int viTri(int maTrieuChungXoa, ArrayList<TrieuChung> listTrieuChungChon)
	{
		for(int i=0;i<listTrieuChungChon.size();i++)
			if(listTrieuChungChon.get(i).getMaTrieuChung() == maTrieuChungXoa)
				return i;
		return 0;
	}

}
