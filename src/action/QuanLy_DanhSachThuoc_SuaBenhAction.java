package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.ThuocBenhForm;
import model.bean.Benh;
import model.bo.BenhBO;

public class QuanLy_DanhSachThuoc_SuaBenhAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ThuocBenhForm thuocBenhForm = (ThuocBenhForm) form;
		BenhBO benhBO = new BenhBO();
//		HttpSession session = request.getSession();
		int maBenhXoa = thuocBenhForm.getMaBenhXoa();
		int maBenhChon = thuocBenhForm.getMaBenhChon();
		
		if(!"".equals(thuocBenhForm.getTimBenh()) && thuocBenhForm.getTimBenh() != null)
			thuocBenhForm.setTimBenh(thuocBenhForm.getTimBenh());
		else
			thuocBenhForm.setTimBenh("");
		thuocBenhForm.setListBenhTim(benhBO.getListBenh(thuocBenhForm.getTimBenh(),0));
		// luc dau vao chua chon ji ca
		thuocBenhForm.setListBenhChon((ArrayList<Benh>) request.getSession().getAttribute("listBenh"));
		
			// luc chon them benh vao	
			if(maBenhChon != 0 )		// neu click vo chon 1 benh nao do
			{
				if(kt(maBenhChon, thuocBenhForm.getListBenhChon()) == 1)			// kt xem thuoc nay da co trong danh sach chon hay chua
					thuocBenhForm.getListBenhChon().add(benhBO.getBenh(maBenhChon));							// them thuoc vao list thuoc chon
			}
			if(maBenhXoa != 0)
			{
				thuocBenhForm.getListBenhChon().remove(viTri(maBenhXoa,  thuocBenhForm.getListBenhChon()));
			}
		
			request.getSession().setAttribute("listBenh", thuocBenhForm.getListBenhChon());
		return mapping.findForward("suaBenh");
		
	}
	
	public int kt(int maBenhChon, ArrayList<Benh> listBenhChon)
	{
		for(int i=0;i<listBenhChon.size();i++)
			if(listBenhChon.get(i).getMaBenh() == maBenhChon)
				return 0;
		return 1;
	}
	public int viTri(int maBenhXoa, ArrayList<Benh> listBenhChon)
	{
		for(int i=0;i<listBenhChon.size();i++)
			if(listBenhChon.get(i).getMaBenh() == maBenhXoa)
				return i;
		return 0;
	}

}
