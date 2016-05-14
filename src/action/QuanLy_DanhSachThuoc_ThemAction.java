package action;

import java.io.File;
import java.io.FileOutputStream;
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
import org.apache.struts.upload.FormFile;

import common.StringProcess;
import form.ThuocForm;
import model.bean.Benh;
import model.bo.BenhBO;
import model.bo.ThuocBO;

public class QuanLy_DanhSachThuoc_ThemAction extends Action{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter printWriter = response.getWriter();
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
		int maLoaiThuoc = 0;
		int maNhomThuoc = 0;
		int trangThai = 1;

		FileOutputStream outputStream = null;
	    FormFile file = null;
		
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
			
			String ten = (String) session.getAttribute("tenThuoc");
			System.out.println("para: "+ request.getParameter("tenThuoc"));
			System.out.println("para: "+ request.getParameter("congThuc"));
			System.out.println(ten);
			
			 tenThuoc = (String) session.getAttribute("tenThuoc");
			 congThuc = (String) session.getAttribute("congThuc");
			 tenKhoaHoc = (String) session.getAttribute("tenKhoaHoc");
			 dieuChe = (String) session.getAttribute("dieuChe");
			 tinhChat = (String) session.getAttribute("tinhChat");
			 tacDung = (String) session.getAttribute("tacDung");
			 chiDinh = (String) session.getAttribute("chiDinh");
			 baoQuan = (String) session.getAttribute("baoQuan");
			 thanTrong = (String) session.getAttribute("thanTrong");
			 DDH = (String) session.getAttribute("DDH");
			 if( session.getAttribute("maNhomThuoc")!=null)
				 maNhomThuoc = (int) session.getAttribute("maNhomThuoc");
			 if( session.getAttribute("maLoaiThuoc")!=null)
				 maLoaiThuoc = (int) session.getAttribute("maLoaiThuoc");
			 
			
			thuocForm.setTenThuoc(tenThuoc);
			thuocForm.setCongThuc(congThuc);
			thuocForm.setTenKhoaHoc(tenKhoaHoc);
			thuocForm.setDieuChe(dieuChe);
			thuocForm.setTinhChat(tinhChat);
			thuocForm.setTacDung(tacDung);
			thuocForm.setChiDinh(chiDinh);
			thuocForm.setBaoQuan(baoQuan);
			thuocForm.setThanTrong(thanTrong);
			thuocForm.setDDH(DDH);
			thuocForm.setMaLoaiThuoc(maLoaiThuoc);
			thuocForm.setListNhomThuoc(thuocBO.getListNhomThuoc(maLoaiThuoc));
			
			System.out.println(ten);
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
			
			if (thuocForm.getTenThuoc() == null || "".equals(thuocForm.getTenThuoc())){
				System.out.println("NULL");
				String ten = (String) session.getAttribute("tenThuoc");
				thuocForm.setTenThuoc(ten);
			}
			else {
				System.out.println("KO NULL");
				session.setAttribute("tenThuoc", thuocForm.getTenThuoc());
			}

			if (thuocForm.getCongThuc() == null || "".equals(thuocForm.getCongThuc()))

				thuocForm.setCongThuc((String) session.getAttribute("congThuc"));
			else {
				session.setAttribute("congThuc", thuocForm.getCongThuc());
			}

			if (thuocForm.getTenKhoaHoc() == null || "".equals(thuocForm.getTenKhoaHoc()))

				thuocForm.setTenKhoaHoc((String) session.getAttribute("tenKhoaHoc"));
			else {
				session.setAttribute("tenKhoaHoc", thuocForm.getTenKhoaHoc());
			}

			if (thuocForm.getDieuChe() == null || "".equals(thuocForm.getDieuChe()))

				thuocForm.setDieuChe((String) session.getAttribute("dieuChe"));
			else {
				session.setAttribute("dieuChe", thuocForm.getDieuChe());
			}

			if (thuocForm.getTinhChat() == null || "".equals(thuocForm.getTinhChat()))
				thuocForm.setTinhChat((String) session.getAttribute("tinhChat"));
			else {
				session.setAttribute("tinhChat", thuocForm.getTinhChat());
			}

			if (thuocForm.getTacDung() == null || "".equals(thuocForm.getTacDung()))
				thuocForm.setTacDung((String) session.getAttribute("tacDung"));
			else {
				session.setAttribute("tacDung", thuocForm.getTacDung());
			}

			if (thuocForm.getChiDinh() == null || "".equals(thuocForm.getChiDinh()))
				thuocForm.setChiDinh((String) session.getAttribute("chiDinh"));
			else {
				session.setAttribute("chiDinh", thuocForm.getChiDinh());
			}

			if (thuocForm.getBaoQuan() == null || "".equals(thuocForm.getBaoQuan()))
				thuocForm.setBaoQuan((String) session.getAttribute("baoQuan"));
			else {
				session.setAttribute("baoQuan", thuocForm.getBaoQuan());
			}

			if (thuocForm.getThanTrong() == null || "".equals(thuocForm.getThanTrong()))
				thuocForm.setThanTrong((String) session.getAttribute("thanTrong"));
			else {
				session.setAttribute("thanTrong", thuocForm.getThanTrong());
			}

			if (thuocForm.getDDH() == null || "".equals(thuocForm.getDDH()))
				thuocForm.setDDH((String) session.getAttribute("DDH"));
			else {
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

			
			session.setAttribute("kt", 1);
		}
		
		
		if("submit".equals(thuocForm.getSubmit()))
		{
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
				String hinhAnh = "no_image.jpg";
				file = thuocForm.getFile();
				if(file.getFileName()!=""){
					StringProcess process = new StringProcess();
					hinhAnh = process.makeSlug(tenThuoc)+".jpg";
					try {
						String path = getServlet().getServletContext().getRealPath("/")+"img"+"/"+hinhAnh;
						//outputStream = new FileOutputStream(new File("F:/gitgit/MSS/WebContent/img/"+chuoi));
						outputStream = new FileOutputStream(new File(path));
			            outputStream.write(file.getFileData());
			            
			        } finally {
			            if (outputStream != null) {
			                outputStream.close();
			            }
			        }
				}
				
				System.out.println(hinhAnh);
				
				thuocBO.themThuoc(tenThuoc,congThuc,tenKhoaHoc,dieuChe,tinhChat,tacDung,chiDinh,baoQuan,thanTrong,DDH,maNhomThuoc,trangThai, hinhAnh);
				thuocBO.themThuocBenh(tenThuoc,thuocForm.getListBenh());
				return mapping.findForward("themThuocXong");
			}
		}
		else if("change".equals(thuocForm.getChange()))
		{
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
			System.out.println("Maloai :"+request.getParameter("maLoaiThuoc"));
			System.out.println("MaNHOm: "+request.getParameter("maNhomThuoc"));
			return mapping.findForward("themThuocChange");
		}
		else{
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
				
				printWriter.write(request.getParameter("tenThuoc")+"");
				printWriter.flush();
				return null;
			}
			return mapping.findForward("themThuoc");
		}
	}
}
