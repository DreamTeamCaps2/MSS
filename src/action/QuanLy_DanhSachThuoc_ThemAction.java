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
import form.ThuocForm;
import model.bean.Benh;
import model.bo.BenhBO;
import model.bo.ThuocBO;

public class QuanLy_DanhSachThuoc_ThemAction extends Action{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String tenThuoc ;
		String congThuc;
		String tenKhoaHoc;
		String dieuChe ;
		String tinhChat;
		String tacDung ;
		String chiDinh ;
		String baoQuan;
		String thanTrong ;
		String DDH ;
		int maLoaiThuoc;
		int maNhomThuoc ;
		int trangThai = 1;
		
		ThuocForm thuocForm = (ThuocForm) form;
		ThuocBO thuocBO = new ThuocBO();
		BenhBO benhBO = new BenhBO();
		
		HttpSession session = request.getSession();
		
		// list loai thuoc
		thuocForm.setListLoaiThuoc(thuocBO.getListLoaiThuoc());
		//list nhom thuoc
		thuocForm.setListNhomThuoc(thuocBO.getListNhomThuoc(thuocForm.getMaLoaiThuoc()));
		if(thuocForm.getKt() == 0)
			thuocForm.setKt((int)session.getAttribute("kt"));
		System.out.println("kt = "+thuocForm.getKt());
		if((thuocForm.getKt() == 0))
		{
			thuocForm.setListBenh(benhBO.getListBenh("xxxxxxxxxxxxxxx", 1));
			
			if(!"".equals(thuocForm.getTenThuoc()) && thuocForm.getTenThuoc() != null)
				thuocForm.setTenThuoc(new String(thuocForm.getTenThuoc().getBytes("ISO-8859-1"),"UTF-8"));
			if(!"".equals(thuocForm.getCongThuc()) && thuocForm.getCongThuc() != null)
				thuocForm.setCongThuc(new String(thuocForm.getCongThuc().getBytes("ISO-8859-1"),"UTF-8"));
			if(!"".equals(thuocForm.getTenKhoaHoc()) && thuocForm.getTenKhoaHoc() != null)
				thuocForm.setTenKhoaHoc(new String(thuocForm.getTenKhoaHoc().getBytes("ISO-8859-1"),"UTF-8"));
			if(!"".equals(thuocForm.getDieuChe()) && thuocForm.getDieuChe() != null)
				thuocForm.setDieuChe(new String(thuocForm.getDieuChe().getBytes("ISO-8859-1"),"UTF-8"));
			if(!"".equals(thuocForm.getTinhChat()) && thuocForm.getTinhChat() != null)
				thuocForm.setTinhChat(new String(thuocForm.getTinhChat().getBytes("ISO-8859-1"),"UTF-8"));
			if(!"".equals(thuocForm.getTacDung()) && thuocForm.getTacDung() != null)
				thuocForm.setTacDung(new String(thuocForm.getTacDung().getBytes("ISO-8859-1"),"UTF-8"));
			if(!"".equals(thuocForm.getChiDinh()) && thuocForm.getChiDinh() != null)
				thuocForm.setChiDinh(new String(thuocForm.getChiDinh().getBytes("ISO-8859-1"),"UTF-8"));
			if(!"".equals(thuocForm.getBaoQuan()) && thuocForm.getBaoQuan() != null)
				thuocForm.setBaoQuan(new String(thuocForm.getBaoQuan().getBytes("ISO-8859-1"),"UTF-8"));
			if(!"".equals(thuocForm.getThanTrong()) && thuocForm.getThanTrong() != null)
				thuocForm.setThanTrong(new String(thuocForm.getThanTrong().getBytes("ISO-8859-1"),"UTF-8"));
			if(!"".equals(thuocForm.getDDH()) && thuocForm.getDDH() != null)
				thuocForm.setDDH(new String(thuocForm.getDDH().getBytes("ISO-8859-1"),"UTF-8"));
			
			 tenThuoc = thuocForm.getTenThuoc();
			 congThuc = thuocForm.getCongThuc();
			 tenKhoaHoc = thuocForm.getTenKhoaHoc();
			 dieuChe = thuocForm.getDieuChe();
			 tinhChat = thuocForm.getTinhChat();
			 tacDung = thuocForm.getTacDung();
			 chiDinh = thuocForm.getChiDinh();
			 baoQuan = thuocForm.getBaoQuan();
			 thanTrong = thuocForm.getThanTrong();
			 DDH = thuocForm.getDDH();
			 maNhomThuoc = thuocForm.getMaNhomThuoc();
			 maLoaiThuoc = thuocForm.getMaLoaiThuoc();
			 
			session.setAttribute("tenThuoc", tenThuoc);
			session.setAttribute("congThuc", congThuc);
			session.setAttribute("tenKhoaHoc", tenKhoaHoc);
			session.setAttribute("dieuChe", dieuChe);
			session.setAttribute("tinhChat", tinhChat);
			session.setAttribute("tacDung", tacDung);
			session.setAttribute("chiDinh", chiDinh);
			session.setAttribute("baoQuan", baoQuan);
			session.setAttribute("thanTrong", thanTrong);
			session.setAttribute("DDH", DDH);
			session.setAttribute("maLoaiThuoc", maLoaiThuoc);
			session.setAttribute("maNhomThuoc", maNhomThuoc);
			session.setAttribute("listBenh", thuocForm.getListBenh());
		}
		else
		{
			thuocForm.setListBenh((ArrayList<Benh>) session.getAttribute("listBenh"));
			
			if(thuocForm.getTenThuoc() == null || "".equals(thuocForm.getTenThuoc()) )
			
				thuocForm.setTenThuoc((String) session.getAttribute("tenThuoc"));
			else 
			{
				thuocForm.setTenThuoc(new String(thuocForm.getTenThuoc().getBytes("ISO-8859-1"),"UTF-8"));
				session.setAttribute("tenThuoc", thuocForm.getTenThuoc());
			}
			
				if(thuocForm.getCongThuc() == null || "".equals(thuocForm.getCongThuc()) )
				
					thuocForm.setCongThuc((String) session.getAttribute("congThuc"));
				else 
				{
					thuocForm.setCongThuc(new String(thuocForm.getCongThuc().getBytes("ISO-8859-1"),"UTF-8"));
					session.setAttribute("congThuc", thuocForm.getCongThuc());
				}
				
				if(thuocForm.getTenKhoaHoc() == null || "".equals(thuocForm.getTenKhoaHoc()) )
				
					thuocForm.setTenKhoaHoc((String) session.getAttribute("tenKhoaHoc"));
				else 
				{
					thuocForm.setTenKhoaHoc(new String(thuocForm.getTenKhoaHoc().getBytes("ISO-8859-1"),"UTF-8"));
					session.setAttribute("tenKhoaHoc", thuocForm.getTenKhoaHoc());
				}
				
				if(thuocForm.getDieuChe() == null || "".equals(thuocForm.getDieuChe()) )
				
					thuocForm.setDieuChe((String) session.getAttribute("dieuChe"));
				else 
				{
					thuocForm.setDieuChe(new String(thuocForm.getDieuChe().getBytes("ISO-8859-1"),"UTF-8"));
					session.setAttribute("dieuChe", thuocForm.getDieuChe());
				}
				
				if(thuocForm.getTinhChat() == null || "".equals(thuocForm.getTinhChat()) )
					thuocForm.setTinhChat((String) session.getAttribute("tinhChat"));
				else 
				{
					thuocForm.setTinhChat(new String(thuocForm.getTinhChat().getBytes("ISO-8859-1"),"UTF-8"));
					session.setAttribute("tinhChat", thuocForm.getTinhChat());
				}
				
				if(thuocForm.getTacDung() == null || "".equals(thuocForm.getTacDung()) )
					thuocForm.setTacDung((String) session.getAttribute("tacDung"));
				else 
				{
					thuocForm.setTacDung(new String(thuocForm.getTacDung().getBytes("ISO-8859-1"),"UTF-8"));
					session.setAttribute("tacDung", thuocForm.getTacDung());
				}
				
				if(thuocForm.getChiDinh() == null || "".equals(thuocForm.getChiDinh()) )
					thuocForm.setChiDinh((String) session.getAttribute("chiDinh"));
				else 
				{
					thuocForm.setChiDinh(new String(thuocForm.getChiDinh().getBytes("ISO-8859-1"),"UTF-8"));
					session.setAttribute("chiDinh", thuocForm.getChiDinh());
				}
				
				if(thuocForm.getBaoQuan() == null || "".equals(thuocForm.getBaoQuan()) )
					thuocForm.setBaoQuan((String) session.getAttribute("baoQuan"));
				else 
				{
					thuocForm.setBaoQuan(new String(thuocForm.getBaoQuan().getBytes("ISO-8859-1"),"UTF-8"));
					session.setAttribute("baoQuan", thuocForm.getBaoQuan());
				}
				
				if(thuocForm.getThanTrong() == null || "".equals(thuocForm.getThanTrong()) )
					thuocForm.setThanTrong((String) session.getAttribute("thanTrong"));
				else 
				{
					thuocForm.setThanTrong(new String(thuocForm.getThanTrong().getBytes("ISO-8859-1"),"UTF-8"));
					session.setAttribute("thanTrong", thuocForm.getThanTrong());
				}
				
				if(thuocForm.getDDH() == null || "".equals(thuocForm.getDDH()) )
					thuocForm.setDDH((String) session.getAttribute("DDH"));
				else 
				{
					thuocForm.setDDH(new String(thuocForm.getDDH().getBytes("ISO-8859-1"),"UTF-8"));
					session.setAttribute("DDH", thuocForm.getDDH());
				}
				
				if(thuocForm.getMaNhomThuoc() == 0 )
				{
					thuocForm.setMaNhomThuoc((int) session.getAttribute("maNhomThuoc"));
				}
				else session.setAttribute("maNhomThuoc", thuocForm.getMaNhomThuoc());
				
				if(thuocForm.getMaLoaiThuoc() == 0 )
				{
					thuocForm.setMaLoaiThuoc((int) session.getAttribute("maLoaiThuoc")); 
				}
				else session.setAttribute("maLoaiThuoc", thuocForm.getMaLoaiThuoc());
				
				
				
				
				 tenThuoc = thuocForm.getTenThuoc();
				 congThuc = thuocForm.getCongThuc();
				 tenKhoaHoc = thuocForm.getTenKhoaHoc();
				 dieuChe = thuocForm.getDieuChe();
				 tinhChat = thuocForm.getTinhChat();
				 tacDung = thuocForm.getTacDung();
				 chiDinh = thuocForm.getChiDinh();
				 baoQuan = thuocForm.getBaoQuan();
				 thanTrong = thuocForm.getThanTrong();
				 DDH = thuocForm.getDDH();
				 maNhomThuoc = thuocForm.getMaNhomThuoc();
				 maLoaiThuoc = thuocForm.getMaLoaiThuoc();
				 
				 System.out.println(" aaa "+tenThuoc);
				 
				 session.setAttribute("kt", 1);
		}
		
		
		if("submit".equals(thuocForm.getSubmit()))
		{
			ActionErrors actionErrors=new ActionErrors();
			
			if(tenThuoc == null || "".equals(tenThuoc))
				actionErrors.add("tenThuocError",new ActionMessage("error.notNull"));
			else if(thuocBO.ktTenThuoc(tenThuoc)==0)
				actionErrors.add("tenThuocError",new ActionMessage("error.exists"));
			else if(tenThuoc.length() >= 50)
					actionErrors.add("tenThuocError",new ActionMessage("error.ten"));
			
			if(maNhomThuoc == 0)
				actionErrors.add("maNhomThuocError",new ActionMessage("error.notNull"));
			
			saveErrors(request, actionErrors);
			if(actionErrors.size()>0)
				return mapping.findForward("themThuoc");
			else
			{
				thuocBO.themThuoc(tenThuoc,congThuc,tenKhoaHoc,dieuChe,tinhChat,tacDung,chiDinh,baoQuan,thanTrong,DDH,maNhomThuoc,trangThai);
				thuocBO.themThuocBenh(tenThuoc,thuocForm.getListBenh());
				return mapping.findForward("themThuocXong");
			}
		}
		else if("change".equals(thuocForm.getChange()))
		{
			return mapping.findForward("themThuocChange");
		}
		else
			return mapping.findForward("themThuoc");
		
	}


}
