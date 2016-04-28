package action;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.TaiKhoanForm;
import model.bean.TaiKhoan;
import model.bo.BaiVietBO;
import model.bo.TaiKhoanBO;
import model.bo.ThuocBO;

public class ThongTinTaiKhoanChiTietAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		
		TaiKhoanBO taiKhoanBO = new TaiKhoanBO();
		ThuocBO thuocBO = new ThuocBO();
		BaiVietBO baiVietBO = new BaiVietBO();
		
		TaiKhoanForm taiKhoanForm = (TaiKhoanForm) form;
		HttpSession session1 = request.getSession();
		
		response.setContentType("text/text;charset=utf-8");
		response.setHeader("cache-control", "no-cache");
		response.setHeader("Content-Type", "application/json");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");			   
	   
	   
		PrintWriter printWriter = response.getWriter();
		
//		TaiKhoan taiKhoan = (TaiKhoan)session1.getAttribute("taiKhoan");
//		String tenDangNhap = (String)session1.getAttribute("tenDangNhap");
		String maTKDN = (String)session1.getAttribute("maTKDN");
		
		if(maTKDN!=null){
			if(request.getParameter("rating")!=null){
				String rating = request.getParameter("rating");
				String maTKPhu = request.getParameter("tkkhach");
				System.out.println("Danh Gia:" + rating);
				System.out.println("Ten Dang Nhap:" +maTKDN);
				System.out.println("Ten Dang Nhap Khach:" +maTKPhu);
				
				String datetime = getDate();
				
				String diemRate = baiVietBO.getRate(maTKDN, maTKPhu);
				if(diemRate!="")
					baiVietBO.updateRate(maTKDN, maTKPhu, rating, datetime);
				else
					baiVietBO.addRate(maTKDN, maTKPhu, rating, datetime);
			}
			
			if(request.getParameter("marked")!=null){
				String marked = request.getParameter("marked");
				String maTKPhu = request.getParameter("tkkhach");
				System.out.println("Danh Dau:" + marked);
				System.out.println("Ten Dang Nhap:" +maTKDN);
				System.out.println("Ten Dang Nhap Khach:" +maTKPhu);
				
				if(baiVietBO.getMark(maTKDN, maTKPhu)){
					System.out.println("Huy Danh Dau");
					baiVietBO.removeMark(maTKDN, maTKPhu);
				}
				else
					baiVietBO.addMark(maTKDN, maTKPhu);
			}
			
			if(request.getParameter("report")!=null){
				String report = request.getParameter("report");
				String maDangNhapKhach = request.getParameter("tkkhach");
				System.out.println("To Cao:" + report);
				System.out.println("Ten Dang Nhap:" +maTKDN);
				System.out.println("Ten Dang Nhap Khach:" +maDangNhapKhach);
				
				String datetime = getDate();
				
				baiVietBO.addReport(maTKDN, maDangNhapKhach, datetime);
			}
			
			if(request.getParameter("comment")!=null){
				String comment = request.getParameter("comment");
				String maDangNhapKhach = request.getParameter("tkkhach");
				System.out.println("Binh Luan:" + comment);
				System.out.println("Ten Dang Nhap:" +maTKDN);
				System.out.println("Ten Dang Nhap Khach:" +maDangNhapKhach);
				
				String datetime = getDate();
				
				baiVietBO.addComment(maTKDN, maDangNhapKhach, comment, datetime);
				   
				DateFormat dateFormat = new SimpleDateFormat("MMM d yyyy H:mma");
				Date date = new Date();
				datetime = dateFormat.format(date);
				System.out.println("DATE FORMAT: "+ datetime);
				
				printWriter.write(datetime);
				printWriter.flush();
				return null;
			}
		}
		else{
			request.setAttribute("maTKDN", false);
		}
		
		String tenDangNhap1 = taiKhoanForm.getTenDangNhap();
		TaiKhoan taiKhoan = taiKhoanBO.getThongTinTaiKhoan(tenDangNhap1, "");
		session1.setAttribute("taiKhoan1", taiKhoan);
		
		taiKhoanForm.setMaTK(taiKhoan.getMaTK());
		taiKhoanForm.setTenDangNhap(taiKhoan.getTenDangNhap());
		taiKhoanForm.setDiaChi(taiKhoan.getDiaChi());
		taiKhoanForm.setMatKhau(taiKhoan.getMatKhau());
		taiKhoanForm.setSDT(taiKhoan.getSDT());
		taiKhoanForm.setMaLoai(taiKhoan.getMaLoai());
		taiKhoanForm.setCmnd(taiKhoan.getCmnd());
		taiKhoanForm.setEmail(taiKhoan.getEmail());
		taiKhoanForm.setTenNhaThuoc(taiKhoan.getTenNhaThuoc());
		taiKhoanForm.setTenPhongKham(taiKhoan.getTenPhongKham());
		taiKhoanForm.setMoTa(taiKhoan.getMoTa());
		taiKhoanForm.setThoiGian(taiKhoan.getThoiGian());
		taiKhoanForm.setLoaiTK(taiKhoan.getLoaiTK());
		//taiKhoanForm.setAnhDaiDien(taiKhoan.getAnhDaiDien());
		
		String maTKPhu = taiKhoan.getMaTK();
		
		taiKhoanForm.setListThuocCuaHang(thuocBO.getThuocCuaHang(maTKPhu));
		
		taiKhoanForm.setListBinhLuan(baiVietBO.getListComment(maTKPhu));
		
		String diemRate = baiVietBO.getRate(maTKDN, maTKPhu);
		String rateTB = baiVietBO.getRateTB(maTKPhu);
		if(rateTB=="")
			rateTB = "0";
		request.setAttribute("rating", rateTB);
		
		if(baiVietBO.getMark(maTKDN, maTKPhu)){
			request.setAttribute("checkMark", true);
		}
		
		if(baiVietBO.getReport(maTKDN, maTKPhu)){
			request.setAttribute("checkReport", true);
		}
		
		baiVietBO.getListComment(maTKPhu);
		
		return mapping.findForward("thongTinTKChiTiet");
	}
	
	public String getDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		Date date = new Date();
		String datetime = dateFormat.format(date);
		System.out.println(datetime);
		return datetime;
	}
}
