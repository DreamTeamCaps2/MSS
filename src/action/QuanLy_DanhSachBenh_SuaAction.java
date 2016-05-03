package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import form.BenhForm;
import model.bean.Benh;
import model.bean.Thuoc;
import model.bean.TrieuChung;
import model.bo.BenhBO;
import model.bo.ThuocBO;
import model.bo.TrieuChungBO;

public class QuanLy_DanhSachBenh_SuaAction extends Action{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		int maBenh;
		String tenBenh ;
		String nguyenNhan;
		String chanDoan;
		String bienChung ;
		String dieuTri;
		String cheDoDinhDuong ;
		int maLoaiBenh;
		int trangThai = 1;
		
		BenhForm benhForm = (BenhForm) form;
		BenhBO benhBO = new BenhBO();
		ThuocBO thuocBO = new ThuocBO();
		TrieuChungBO trieuChungBO = new TrieuChungBO();
		
		HttpSession session = request.getSession();
		
		maBenh = benhForm.getMaBenh();
		
		// list loai benh
		benhForm.setListLoaiBenh(benhBO.getListLoaiBenh());
		
		if(benhForm.getKt() == 0)
			benhForm.setKt((int)session.getAttribute("kt"));
		if((benhForm.getKt() == 0))
		{
			benhForm.setListThuoc((ArrayList<Thuoc>) session.getAttribute("listThuoc"));
			benhForm.setListTrieuChung((ArrayList<TrieuChung>) session.getAttribute("listTrieuChung"));
			
//			if(!"".equals(benhForm.getTenBenh()) && benhForm.getTenBenh() != null)
//				benhForm.setTenBenh(new String(benhForm.getTenBenh().getBytes("ISO-8859-1"),"UTF-8"));
//			if(!"".equals(benhForm.getNguyenNhan()) && benhForm.getNguyenNhan() != null)
//				benhForm.setNguyenNhan(new String(benhForm.getNguyenNhan().getBytes("ISO-8859-1"),"UTF-8"));
//			if(!"".equals(benhForm.getChanDoan()) && benhForm.getChanDoan() != null)
//				benhForm.setChanDoan(new String(benhForm.getChanDoan().getBytes("ISO-8859-1"),"UTF-8"));
//			if(!"".equals(benhForm.getBienChung()) && benhForm.getBienChung() != null)
//				benhForm.setBienChung(new String(benhForm.getBienChung().getBytes("ISO-8859-1"),"UTF-8"));
//			if(!"".equals(benhForm.getDieuTri()) && benhForm.getDieuTri() != null)
//				benhForm.setDieuTri(new String(benhForm.getDieuTri().getBytes("ISO-8859-1"),"UTF-8"));
//			if(!"".equals(benhForm.getCheDoDinhDuong()) && benhForm.getCheDoDinhDuong() != null)
//				benhForm.setCheDoDinhDuong(new String(benhForm.getCheDoDinhDuong().getBytes("ISO-8859-1"),"UTF-8"));
			
			 tenBenh = benhForm.getTenBenh();
			 nguyenNhan = benhForm.getNguyenNhan();
			 chanDoan = benhForm.getChanDoan();
			 bienChung = benhForm.getBienChung();
			 dieuTri = benhForm.getDieuTri();
			 cheDoDinhDuong = benhForm.getCheDoDinhDuong();
			 maLoaiBenh = benhForm.getMaLoaiBenh();
			 
			session.setAttribute("maBenh", maBenh);
			session.setAttribute("tenBenh", tenBenh);
			session.setAttribute("nguyenNhan", nguyenNhan);
			session.setAttribute("chanDoan", chanDoan);
			session.setAttribute("bienChung", bienChung);
			session.setAttribute("dieuTri", dieuTri);
			session.setAttribute("cheDoDinhDuong", cheDoDinhDuong);
			session.setAttribute("maLoaiBenh", maLoaiBenh);
			session.setAttribute("listThuoc", benhForm.getListThuoc());
			session.setAttribute("listTrieuChung", benhForm.getListTrieuChung());
		}
		else
		{
			
			benhForm.setListThuoc((ArrayList<Thuoc>) session.getAttribute("listThuoc"));
			benhForm.setListTrieuChung((ArrayList<TrieuChung>) session.getAttribute("listTrieuChung"));
			benhForm.setMaBenh((int) session.getAttribute("maBenh")); 
			if (benhForm.getTenBenh() == null || "".equals(benhForm.getTenBenh()))

				benhForm.setTenBenh((String) session.getAttribute("tenBenh"));
			else {
				// benhForm.setTenBenh(new
				// String(benhForm.getTenBenh().getBytes("ISO-8859-1"),"UTF-8"));
				session.setAttribute("tenBenh", benhForm.getTenBenh());
			}
			if (benhForm.getNguyenNhan() == null || "".equals(benhForm.getNguyenNhan()))

				benhForm.setNguyenNhan((String) session.getAttribute("nguyenNhan"));
			else {
				// benhForm.setNguyenNhan(new
				// String(benhForm.getNguyenNhan().getBytes("ISO-8859-1"),"UTF-8"));
				session.setAttribute("nguyenNhan", benhForm.getNguyenNhan());
			}

			if (benhForm.getChanDoan() == null || "".equals(benhForm.getChanDoan()))

				benhForm.setChanDoan((String) session.getAttribute("chanDoan"));
			else {
				// benhForm.setChanDoan(new
				// String(benhForm.getChanDoan().getBytes("ISO-8859-1"),"UTF-8"));
				session.setAttribute("chanDoan", benhForm.getChanDoan());
			}

			if (benhForm.getBienChung() == null || "".equals(benhForm.getBienChung()))

				benhForm.setBienChung((String) session.getAttribute("bienChung"));
			else {
				// benhForm.setBienChung(new
				// String(benhForm.getBienChung().getBytes("ISO-8859-1"),"UTF-8"));
				session.setAttribute("bienChung", benhForm.getBienChung());
			}

			if (benhForm.getDieuTri() == null || "".equals(benhForm.getDieuTri()))
				benhForm.setDieuTri((String) session.getAttribute("dieuTri"));
			else {
				// benhForm.setDieuTri(new
				// String(benhForm.getDieuTri().getBytes("ISO-8859-1"),"UTF-8"));
				session.setAttribute("dieuTri", benhForm.getDieuTri());
			}

			if (benhForm.getCheDoDinhDuong() == null || "".equals(benhForm.getCheDoDinhDuong()))
				benhForm.setCheDoDinhDuong((String) session.getAttribute("cheDoDinhDuong"));
			else {
				// benhForm.setCheDoDinhDuong(new
				// String(benhForm.getCheDoDinhDuong().getBytes("ISO-8859-1"),"UTF-8"));
				session.setAttribute("cheDoDinhDuong", benhForm.getCheDoDinhDuong());
			}

			if (benhForm.getMaLoaiBenh() == 0) {
				benhForm.setMaLoaiBenh((int) session.getAttribute("maLoaiBenh"));
			} else
				session.setAttribute("maLoaiBenh", benhForm.getMaLoaiBenh());

			tenBenh = benhForm.getTenBenh();
			nguyenNhan = benhForm.getNguyenNhan();
			chanDoan = benhForm.getChanDoan();
			bienChung = benhForm.getBienChung();
			dieuTri = benhForm.getDieuTri();
			cheDoDinhDuong = benhForm.getCheDoDinhDuong();
			maLoaiBenh = benhForm.getMaLoaiBenh();

			session.setAttribute("kt", 1);
		}
		
		
		if("submit".equals(benhForm.getSubmit()))
		{
			ActionErrors actionErrors=new ActionErrors();
			
			if(tenBenh == null || "".equals(tenBenh))
				actionErrors.add("tenBenhError",new ActionMessage("error.notNull"));
			else if(benhBO.ktTenBenh(tenBenh,maBenh)==0)
				actionErrors.add("tenBenhError",new ActionMessage("error.exists"));
			else if(tenBenh.length() >= 50)
					actionErrors.add("tenBenhError",new ActionMessage("error.ten"));
			
			if(maLoaiBenh == 0)
				actionErrors.add("maLoaiBenhError",new ActionMessage("error.notNull"));
			
			saveErrors(request, actionErrors);
			if(actionErrors.size()>0)
				return mapping.findForward("suaBenh");
			else
			{
				benhBO.suaBenh(maBenh,tenBenh,nguyenNhan,chanDoan,bienChung,dieuTri,cheDoDinhDuong,maLoaiBenh);
				benhBO.xoaThuocBenh(maBenh);
				trieuChungBO.xoaTrieuChungBenh(maBenh);
				for(int i=0; i< benhForm.getListThuoc().size(); i++)
					benhBO.themBenhThuoc(tenBenh,benhForm.getListThuoc().get(i).getMaThuoc());
				for(int i=0; i< benhForm.getListTrieuChung().size(); i++)
					benhBO.themBenhTrieuChung(tenBenh,benhForm.getListTrieuChung().get(i).getMaTrieuChung());
				return mapping.findForward("suaBenhXong");
			}
		}
		else if("changeThuoc".equals(benhForm.getChangeThuoc()))
		{
			return mapping.findForward("suaBenhChangeThuoc");
		}
		else if("changeTrieuChung".equals(benhForm.getChangeTrieuChung()))
		{
			return mapping.findForward("suaBenhChangeTrieuChung");
		}
		else
		{
			if((benhForm.getKt() == 0))
			{
				Benh benh = benhBO.getBenh(maBenh);
				
				benhForm.setTenBenh(benh.getTenBenh());
				benhForm.setNguyenNhan(benh.getNguyenNhan());
				benhForm.setChanDoan(benh.getChanDoan());
				benhForm.setBienChung(benh.getBienChung());
				benhForm.setDieuTri(benh.getDieuTri());
				benhForm.setCheDoDinhDuong(benh.getCheDoDinhDuong());
				benhForm.setMaLoaiBenh(benh.getMaLoaiBenh());
				benhForm.setListThuoc(thuocBO.getListThuoc(maBenh));
				benhForm.setListTrieuChung(trieuChungBO.getListTrieuChung(maBenh));
				
				session.setAttribute("maBenh", benhForm.getMaBenh());
				session.setAttribute("tenBenh", benhForm.getTenBenh());
				session.setAttribute("nguyenNhan", benhForm.getNguyenNhan());
				session.setAttribute("chanDoan", benhForm.getChanDoan());
				session.setAttribute("bienChung", benhForm.getBienChung());
				session.setAttribute("dieuTri", benhForm.getDieuTri());
				session.setAttribute("cheDoDinhDuong", benhForm.getCheDoDinhDuong());
				session.setAttribute("maLoaiBenh", benhForm.getMaLoaiBenh());
				session.setAttribute("listThuoc", benhForm.getListThuoc());
				session.setAttribute("listTrieuChung", benhForm.getListTrieuChung());
			}
			 
			return mapping.findForward("suaBenh");
		}
		
	}
	

}
