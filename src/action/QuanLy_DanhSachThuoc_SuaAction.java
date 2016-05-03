package action;

import java.io.PrintWriter;
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

import form.ThuocForm;
import model.bean.Benh;
import model.bean.Thuoc;
import model.bo.BenhBO;
import model.bo.ThuocBO;

public class QuanLy_DanhSachThuoc_SuaAction extends Action{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		PrintWriter printWriter = response.getWriter();
		int maThuoc;
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
		
		maThuoc = thuocForm.getMaThuoc();
		
		// list loai thuoc
		thuocForm.setListLoaiThuoc(thuocBO.getListLoaiThuoc());
		//list nhom thuoc
		thuocForm.setListNhomThuoc(thuocBO.getListNhomThuoc(thuocForm.getMaLoaiThuoc()));
//		if(thuocForm.getKt() == 0)
//			thuocForm.setKt((int)session.getAttribute("kt"));
		System.out.println("kt ++  "+thuocForm.getKt());
		System.out.println("kt ==  "+(int)session.getAttribute("kt"));
		if((thuocForm.getKt() == 0))
		{
			thuocForm.setListBenh((ArrayList<Benh>) session.getAttribute("listBenh"));
			
			if(!"".equals(thuocForm.getTenThuoc()) && thuocForm.getTenThuoc() != null)
				thuocForm.setTenThuoc(thuocForm.getTenThuoc());
			if(!"".equals(thuocForm.getCongThuc()) && thuocForm.getCongThuc() != null)
				thuocForm.setCongThuc(thuocForm.getCongThuc());
			if(!"".equals(thuocForm.getTenKhoaHoc()) && thuocForm.getTenKhoaHoc() != null)
				thuocForm.setTenKhoaHoc(thuocForm.getTenKhoaHoc());
			if(!"".equals(thuocForm.getDieuChe()) && thuocForm.getDieuChe() != null)
				thuocForm.setDieuChe(thuocForm.getDieuChe());
			if(!"".equals(thuocForm.getTinhChat()) && thuocForm.getTinhChat() != null)
				thuocForm.setTinhChat(thuocForm.getTinhChat());
			if(!"".equals(thuocForm.getTacDung()) && thuocForm.getTacDung() != null)
				thuocForm.setTacDung(thuocForm.getTacDung());
			if(!"".equals(thuocForm.getChiDinh()) && thuocForm.getChiDinh() != null)
				thuocForm.setChiDinh(thuocForm.getChiDinh());
			if(!"".equals(thuocForm.getBaoQuan()) && thuocForm.getBaoQuan() != null)
				thuocForm.setBaoQuan(thuocForm.getBaoQuan());
			if(!"".equals(thuocForm.getThanTrong()) && thuocForm.getThanTrong() != null)
				thuocForm.setThanTrong(thuocForm.getThanTrong());
			if(!"".equals(thuocForm.getDDH()) && thuocForm.getDDH() != null)
				thuocForm.setDDH(thuocForm.getDDH());
			
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
			
			session.setAttribute("maThuoc", maThuoc);
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
			
//			session.setAttribute("kt", 1);
		}
		else
		{
			thuocForm.setListBenh((ArrayList<Benh>) session.getAttribute("listBenh"));
			thuocForm.setMaThuoc((int) session.getAttribute("maThuoc"));
			
			if (thuocForm.getTenThuoc() == null || "".equals(thuocForm.getTenThuoc()))

				thuocForm.setTenThuoc((String) session.getAttribute("tenThuoc"));
			else {
				thuocForm.setTenThuoc(thuocForm.getTenThuoc());
				session.setAttribute("tenThuoc", thuocForm.getTenThuoc());
			}

			if (thuocForm.getCongThuc() == null || "".equals(thuocForm.getCongThuc()))

				thuocForm.setCongThuc((String) session.getAttribute("congThuc"));
			else {
				thuocForm.setCongThuc(thuocForm.getCongThuc());
				session.setAttribute("congThuc", thuocForm.getCongThuc());
			}

			if (thuocForm.getTenKhoaHoc() == null || "".equals(thuocForm.getTenKhoaHoc()))

				thuocForm.setTenKhoaHoc((String) session.getAttribute("tenKhoaHoc"));
			else {
				thuocForm.setTenKhoaHoc(thuocForm.getTenKhoaHoc());
				session.setAttribute("tenKhoaHoc", thuocForm.getTenKhoaHoc());
			}

			if (thuocForm.getDieuChe() == null || "".equals(thuocForm.getDieuChe()))

				thuocForm.setDieuChe((String) session.getAttribute("dieuChe"));
			else {
				thuocForm.setDieuChe(thuocForm.getDieuChe());
				session.setAttribute("dieuChe", thuocForm.getDieuChe());
			}

			if (thuocForm.getTinhChat() == null || "".equals(thuocForm.getTinhChat()))
				thuocForm.setTinhChat((String) session.getAttribute("tinhChat"));
			else {
				thuocForm.setTinhChat(thuocForm.getTinhChat());
				session.setAttribute("tinhChat", thuocForm.getTinhChat());
			}

			if (thuocForm.getTacDung() == null || "".equals(thuocForm.getTacDung()))
				thuocForm.setTacDung((String) session.getAttribute("tacDung"));
			else {
				thuocForm.setTacDung(thuocForm.getTacDung());
				session.setAttribute("tacDung", thuocForm.getTacDung());
			}

			if (thuocForm.getChiDinh() == null || "".equals(thuocForm.getChiDinh()))
				thuocForm.setChiDinh((String) session.getAttribute("chiDinh"));
			else {
				thuocForm.setChiDinh(thuocForm.getChiDinh());
				session.setAttribute("chiDinh", thuocForm.getChiDinh());
			}

			if (thuocForm.getBaoQuan() == null || "".equals(thuocForm.getBaoQuan()))
				thuocForm.setBaoQuan((String) session.getAttribute("baoQuan"));
			else {
				thuocForm.setBaoQuan(thuocForm.getBaoQuan());
				session.setAttribute("baoQuan", thuocForm.getBaoQuan());
			}

			if (thuocForm.getThanTrong() == null || "".equals(thuocForm.getThanTrong()))
				thuocForm.setThanTrong((String) session.getAttribute("thanTrong"));
			else {
				thuocForm.setThanTrong(thuocForm.getThanTrong());
				session.setAttribute("thanTrong", thuocForm.getThanTrong());
			}

			if (thuocForm.getDDH() == null || "".equals(thuocForm.getDDH()))
				thuocForm.setDDH((String) session.getAttribute("DDH"));
			else {
				thuocForm.setDDH(thuocForm.getDDH());
				session.setAttribute("DDH", thuocForm.getDDH());
			}

			if (thuocForm.getMaNhomThuoc() == 0) {
				thuocForm.setMaNhomThuoc((int) session.getAttribute("maNhomThuoc"));
			} else
				session.setAttribute("maNhomThuoc", thuocForm.getMaNhomThuoc());

			if (thuocForm.getMaLoaiThuoc() == 0) {
				thuocForm.setMaLoaiThuoc((int) session.getAttribute("maLoaiThuoc"));
				thuocForm.setListNhomThuoc(thuocBO.getListNhomThuoc((int) session.getAttribute("maLoaiThuoc")));
			} else
				session.setAttribute("maLoaiThuoc", thuocForm.getMaLoaiThuoc());

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

			// session.setAttribute("kt", 1);
		}
		
		
		if("submit".equals(thuocForm.getSubmit()))
		{
			ActionErrors actionErrors=new ActionErrors();
			
			if(tenThuoc == null || "".equals(tenThuoc))
				actionErrors.add("tenThuocError",new ActionMessage("error.notNull"));
			else if(thuocBO.ktTenThuoc(tenThuoc,maThuoc)==0)
				actionErrors.add("tenThuocError",new ActionMessage("error.exists"));
			else if(tenThuoc.length() >= 50)
					actionErrors.add("tenThuocError",new ActionMessage("error.ten"));
			
			if(maNhomThuoc == 0)
				actionErrors.add("maNhomThuocError",new ActionMessage("error.notNull"));
			
			saveErrors(request, actionErrors);
			if(actionErrors.size()>0)
				return mapping.findForward("suaThuoc");
			else
			{
				thuocBO.xoaThuocBenh(maThuoc);
				thuocBO.suaThuoc(maThuoc,tenThuoc,congThuc,tenKhoaHoc,dieuChe,tinhChat,tacDung,chiDinh,baoQuan,thanTrong,DDH,maNhomThuoc);
				thuocBO.themThuocBenh(tenThuoc,thuocForm.getListBenh());
				return mapping.findForward("suaThuocXong");
			}
		}
		else if("change".equals(thuocForm.getChange()))
		{
			return mapping.findForward("suaThuocChange");
		}
		else
		{
			if(thuocForm.getKt() == 0)
			{
				Thuoc thuoc = thuocBO.getThuoc(maThuoc);
				
				thuocForm.setTenThuoc(thuoc.getTenThuoc());
				thuocForm.setCongThuc(thuoc.getCongThuc());
				thuocForm.setTenKhoaHoc(thuoc.getTenKhoaHoc());
				thuocForm.setDieuChe(thuoc.getDieuChe());
				thuocForm.setTinhChat(thuoc.getTinhChat());
				thuocForm.setTacDung(thuoc.getTacDung());
				thuocForm.setChiDinh(thuoc.getChiDinh());
				thuocForm.setBaoQuan(thuoc.getBaoQuan());
				thuocForm.setThanTrong(thuoc.getThanTrong());
				thuocForm.setDDH(thuoc.getDDH());
				thuocForm.setMaLoaiThuoc(thuoc.getMaLoaiThuoc());
				thuocForm.setMaNhomThuoc(thuoc.getMaNhomThuoc());
				thuocForm.setListBenh(benhBO.getListBenh(maThuoc));
				
				session.setAttribute("maThuoc", maThuoc);
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
			if(request.getParameter("check")!=null){
				System.out.println("Maloai :"+request.getParameter("maLoaiThuoc"));
				System.out.println("MaNHOm: "+request.getParameter("maNhomThuoc"));
				session.setAttribute("tenThuoc", request.getParameter("tenThuoc"));
				session.setAttribute("congThuc", request.getParameter("congThuc"));
				session.setAttribute("tenKhoaHoc", request.getParameter("tenKhoaHoc"));
				session.setAttribute("dieuChe", request.getParameter("dieuChe"));
				session.setAttribute("tinhChat", request.getParameter("tinhChat"));
				session.setAttribute("tacDung", request.getParameter("tacDung"));
				session.setAttribute("chiDinh", request.getParameter("chiDinh"));
				session.setAttribute("baoQuan", request.getParameter("baoQuan"));
				session.setAttribute("thanTrong", request.getParameter("thanTrong"));
				session.setAttribute("DDH", request.getParameter("DDH"));
				session.setAttribute("maLoaiThuoc", Integer.parseInt(request.getParameter("maLoaiThuoc")));
				session.setAttribute("listBenh", thuocForm.getListBenh());
				session.setAttribute("kt", 1);
				
				printWriter.write(request.getParameter("tenThuoc")+"");
				printWriter.flush();
				return null;
			}
			return mapping.findForward("suaThuoc");
		}
		
	}
}
