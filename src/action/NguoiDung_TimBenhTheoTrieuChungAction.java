package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.BenhForm;
import form.BenhTrieuChungForm;
import model.bean.Thuoc;
import model.bean.TrieuChung;
import model.bo.BenhBO;
import model.bo.ThuocBO;
import model.bo.TrieuChungBO;

public class NguoiDung_TimBenhTheoTrieuChungAction extends Action{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		BenhTrieuChungForm benhTrieuChungForm = (BenhTrieuChungForm) form;
		BenhBO benhBO = new BenhBO();
		TrieuChungBO trieuChungBO = new TrieuChungBO();
		HttpSession session = request.getSession();
		
		int kiemTra = 0;
		try {
			kiemTra = (int) session.getAttribute("kiemTra");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		int maTrieuChungXoa = benhTrieuChungForm.getMaTrieuChungXoa();
		int maTrieuChungChon = benhTrieuChungForm.getMaTrieuChungChon();
		
		if(!"".equals(benhTrieuChungForm.getTimTrieuChung()) && benhTrieuChungForm.getTimTrieuChung() != null)
			benhTrieuChungForm.setTimTrieuChung(new String(benhTrieuChungForm.getTimTrieuChung().getBytes("ISO-8859-1"),"UTF-8"));
		else
			benhTrieuChungForm.setTimTrieuChung("");
		benhTrieuChungForm.setListTrieuChungTim(trieuChungBO.getListTrieuChung(benhTrieuChungForm.getTimTrieuChung()));
		
		// luc dau vao chua chon ji ca
		if(maTrieuChungChon == 0 && maTrieuChungXoa == 0 && (benhTrieuChungForm.getTimTrieuChung()==null || "".equals(benhTrieuChungForm.getTimTrieuChung())) && kiemTra == 0)
		{
			System.out.println("Moi vo");
			benhTrieuChungForm.setListTrieuChungChon(trieuChungBO.getListTrieuChung("xxxxxxxxx"));		// moi vo chua co thuoc nao dc chon
		}
		else
		{
			benhTrieuChungForm.setListTrieuChungChon((ArrayList<TrieuChung>) session.getAttribute("listTrieuChungChon"));
			// luc chon them thuoc vao	
			if(maTrieuChungChon != 0 )		// neu click vo chon 1 thuoc nao do
			{
				System.out.println("Ban da chon : "+maTrieuChungChon);
				if(kt(maTrieuChungChon, benhTrieuChungForm.getListTrieuChungChon()) == 1)			// kt xem thuoc nay da co trong danh sach chon hay chua
					benhTrieuChungForm.getListTrieuChungChon().add(trieuChungBO.getTrieuChung(maTrieuChungChon));							// them thuoc vao list thuoc chon
				System.out.println(" list da chon : "+benhTrieuChungForm.getListTrieuChungChon().get(0).getTenTrieuChung());		
			}
			// luc chon xoa thuoc
			if(maTrieuChungXoa != 0)
			{
				benhTrieuChungForm.getListTrieuChungChon().remove(viTri(maTrieuChungXoa,  benhTrieuChungForm.getListTrieuChungChon()));
			}
		}
		
		session.setAttribute("listTrieuChungChon", benhTrieuChungForm.getListTrieuChungChon());
		session.setAttribute("kiemTra", 1);
		
		benhTrieuChungForm.setListBenh(benhBO.getListBenh(benhTrieuChungForm.getListTrieuChungChon()));
			
		return mapping.findForward("timBenh");
		
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
