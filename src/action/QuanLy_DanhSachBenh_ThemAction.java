package action;

import java.io.File;
import java.io.FileOutputStream;
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

import form.BenhForm;
import model.bean.Thuoc;
import model.bean.TrieuChung;
import model.bo.BenhBO;
import model.bo.ThuocBO;
import model.bo.TrieuChungBO;

public class QuanLy_DanhSachBenh_ThemAction extends Action{
	
	
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
        FileOutputStream outputStream = null;
        FormFile file = null;
        
       
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
		
		// list loai benh
		benhForm.setListLoaiBenh(benhBO.getListLoaiBenh());
		
		
		if(benhForm.getKt() == 0)
			benhForm.setKt((int)session.getAttribute("kt"));
		System.out.println("kt = "+benhForm.getKt());
		if((benhForm.getKt() == 0))
		{
			benhForm.setListThuoc(thuocBO.getListThuoc("xxxxxxxxxxxxxxx", 1,1));
			benhForm.setListTrieuChung(trieuChungBO.getListTrieuChung("xxxxxxxxxxxxxxx"));
			
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
			 file = benhForm.getFile();
			 
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
			
			if(benhForm.getTenBenh() == null || "".equals(benhForm.getTenBenh()) )
			
				benhForm.setTenBenh((String) session.getAttribute("tenBenh"));
			else 
			{
//				benhForm.setTenBenh(new String(benhForm.getTenBenh().getBytes("ISO-8859-1"),"UTF-8"));
				session.setAttribute("tenBenh", benhForm.getTenBenh());
			}
			
				if(benhForm.getNguyenNhan() == null || "".equals(benhForm.getNguyenNhan()) )
				
					benhForm.setNguyenNhan((String) session.getAttribute("nguyenNhan"));
				else 
				{
//					benhForm.setNguyenNhan(new String(benhForm.getNguyenNhan().getBytes("ISO-8859-1"),"UTF-8"));
					session.setAttribute("nguyenNhan", benhForm.getNguyenNhan());
				}
				
				if(benhForm.getChanDoan() == null || "".equals(benhForm.getChanDoan()) )
				
					benhForm.setChanDoan((String) session.getAttribute("chanDoan"));
				else 
				{
//					benhForm.setChanDoan(new String(benhForm.getChanDoan().getBytes("ISO-8859-1"),"UTF-8"));
					session.setAttribute("chanDoan", benhForm.getChanDoan());
				}
				
				if(benhForm.getBienChung() == null || "".equals(benhForm.getBienChung()) )
				
					benhForm.setBienChung((String) session.getAttribute("bienChung"));
				else 
				{
//					benhForm.setBienChung(new String(benhForm.getBienChung().getBytes("ISO-8859-1"),"UTF-8"));
					session.setAttribute("bienChung", benhForm.getBienChung());
				}
				
				if(benhForm.getDieuTri() == null || "".equals(benhForm.getDieuTri()) )
					benhForm.setDieuTri((String) session.getAttribute("dieuTri"));
				else 
				{
//					benhForm.setDieuTri(new String(benhForm.getDieuTri().getBytes("ISO-8859-1"),"UTF-8"));
					session.setAttribute("dieuTri", benhForm.getDieuTri());
				}
				
				if(benhForm.getCheDoDinhDuong() == null || "".equals(benhForm.getCheDoDinhDuong()) )
					benhForm.setCheDoDinhDuong((String) session.getAttribute("cheDoDinhDuong"));
				else 
				{
//					benhForm.setCheDoDinhDuong(new String(benhForm.getCheDoDinhDuong().getBytes("ISO-8859-1"),"UTF-8"));
					session.setAttribute("cheDoDinhDuong", benhForm.getCheDoDinhDuong());
				}
				
				
				if(benhForm.getMaLoaiBenh() == 0 )
				{
					benhForm.setMaLoaiBenh((int) session.getAttribute("maLoaiBenh")); 
				}
				else session.setAttribute("maLoaiBenh", benhForm.getMaLoaiBenh());
				
				
				 tenBenh = benhForm.getTenBenh();
				 nguyenNhan = benhForm.getNguyenNhan();
				 chanDoan = benhForm.getChanDoan();
				 bienChung = benhForm.getBienChung();
				 dieuTri = benhForm.getDieuTri();
				 cheDoDinhDuong = benhForm.getCheDoDinhDuong();
				 maLoaiBenh = benhForm.getMaLoaiBenh();
				 file = benhForm.getFile();
				 
				 session.setAttribute("kt", 1);
		}
		
		
		if("submit".equals(benhForm.getSubmit()))
		{
			ActionErrors actionErrors=new ActionErrors();
			
			if(tenBenh == null || "".equals(tenBenh))
				actionErrors.add("tenBenhError",new ActionMessage("error.notNull"));
			else if(benhBO.ktTenBenh(tenBenh)==0)
				actionErrors.add("tenBenhError",new ActionMessage("error.exists"));
			else if(tenBenh.length() >= 50)
					actionErrors.add("tenBenhError",new ActionMessage("error.ten"));
			
			if(maLoaiBenh == 0)
				actionErrors.add("maLoaiBenhError",new ActionMessage("error.notNull"));
			
			saveErrors(request, actionErrors);
			if(actionErrors.size()>0)
				return mapping.findForward("themBenh");
			else
			{
				String hinhAnh = "no_image.jpg";
				file = benhForm.getFile();
				if(file.getFileName()!=""){
					try {
						String chuoi = tenBenh+"_ava.jpg";
			            String path = getServlet().getServletContext().getRealPath("/")+"images"+"/"+chuoi;
	//		            String filePath = System.getProperty("java.io.tmpdir") + "/" + file.getFileName();
	//		            System.out.println(path);
			            outputStream = new FileOutputStream(new File(path));
			            outputStream.write(file.getFileData());
			            
			        } finally {
			            if (outputStream != null) {
			                outputStream.close();
			            }
			        }
					hinhAnh = file.getFileName();
				}
				
				
				System.out.println(hinhAnh);
				benhBO.themBenh(tenBenh,nguyenNhan,chanDoan,bienChung,dieuTri,cheDoDinhDuong,maLoaiBenh,trangThai);
				for(int i=0; i< benhForm.getListThuoc().size(); i++)
					benhBO.themBenhThuoc(tenBenh,benhForm.getListThuoc().get(i).getMaThuoc());
				for(int i=0; i< benhForm.getListTrieuChung().size(); i++)
					benhBO.themBenhTrieuChung(tenBenh,benhForm.getListTrieuChung().get(i).getMaTrieuChung());
				return mapping.findForward("themBenhXong");
			}
		}
		else if("changeThuoc".equals(benhForm.getChangeThuoc()))
		{
			return mapping.findForward("themBenhChangeThuoc");
		}
		else if("changeTrieuChung".equals(benhForm.getChangeTrieuChung()))
		{
			return mapping.findForward("themBenhChangeTrieuChung");
		}
		else
			return mapping.findForward("themBenh");
		
	}
	
}
