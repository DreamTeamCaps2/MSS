package action;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DangNhapForm;
import form.ThongBaoForm;
import model.bean.TaiKhoan;
import model.bean.ThongBao;
import model.bo.BaiVietBO;
import model.bo.BenhBO;
import model.bo.NguoiDungBO;
import model.bo.PhanQuyenBO;
import model.bo.TaiKhoanBO;
import model.bo.ThongBaoBO;
import model.bo.ThuocBO;

public class DangNhapAction extends Action {
	
	public static String encryptMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		DangNhapForm dangNhapForm = (DangNhapForm) form;

		String tenDangNhap = "";
		String matKhau = "";
		
		PhanQuyenBO phanQuyenBO = new PhanQuyenBO();
		NguoiDungBO nguoiDungBO = new NguoiDungBO();
		ThongBaoBO thongBaoBO = new ThongBaoBO();
		HttpSession session1 = request.getSession();	
		
		ThongBaoForm thongBaoForm = new ThongBaoForm();
		ThuocBO thuocBO = new ThuocBO();
		TaiKhoanBO taiKhoanBO = new TaiKhoanBO();
		BaiVietBO baiVietBO = new BaiVietBO();
		BenhBO benhBO = new BenhBO();
		
		
		
		ThongBaoForm form1 = (ThongBaoForm)session1.getAttribute("thongBaoForm");
		DangNhapForm form2 = (DangNhapForm)session1.getAttribute("dangNhapForm");
		
		thongBaoForm.setListLoaiThuoc(thuocBO.getListLoaiThuoc());
		thongBaoForm.setListNhomThuoc(thongBaoBO.getListNhomThuoc());
		thongBaoForm.setListLoaiBenh(thongBaoBO.getListLoaiBenh());
		thongBaoForm.setSoLuongLoaiThuoc(thuocBO.getListLoaiThuoc().size());
		thongBaoForm.setSoLuongNhomThuoc(thongBaoBO.soLuongNhomThuoc());
		thongBaoForm.setSoLuongLoaiBenh(thongBaoBO.getListLoaiBenh().size());
		thongBaoForm.setListND(taiKhoanBO.getListNguoiDung());
		thongBaoForm.setListBaiViet(baiVietBO.getListBaiViet());
		thongBaoForm.setListBenhXemNhieu(benhBO.getListBenhXemNhieu());
		thongBaoForm.setListThuocXemNhieu(thuocBO.getListThuocXemNhieu());
		thongBaoForm.setListBaiVietXemNhieu(baiVietBO.getListBaiVietXemNhieu());
		
		if(form1!=null){
			thongBaoForm.setSoLuong(form1.getSoLuong());
			thongBaoForm.setSoQuyen(form1.getSoQuyen());
			thongBaoForm.setListThongBao(form1.getListThongBao());
		}
		
		session1.setAttribute("thongBaoForm", thongBaoForm);
		
		Cookie cookie = null;
		Cookie[] cookies = null;
		cookies = request.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				cookie = cookies[i];
				if(cookie.getName().equals("tenDangNhap")){
					tenDangNhap = cookie.getValue();
				}
				else if(cookie.getName().equals("matKhau")){
					matKhau = encryptMD5(tenDangNhap + cookie.getValue());
				}	
			}
		} else {
			System.out.println("<h2>No cookies founds</h2>");
		}
		
		System.out.println("DangNhapACtion: "+ tenDangNhap);
		System.out.println("DangNhapACtion: "+ matKhau);
		
		if("OK".equals(dangNhapForm.getSubmit())){
			System.out.println("DANGNHAP");
			
			tenDangNhap = dangNhapForm.getTenDangNhap();
			matKhau = dangNhapForm.getMatKhau();
			matKhau = encryptMD5(tenDangNhap + matKhau);

			System.out.println("TKDN= "+ tenDangNhap + " "+ matKhau);
			if(nguoiDungBO.checkLogin(tenDangNhap, matKhau)){
				TaiKhoan taiKhoan = taiKhoanBO.getThongTinTaiKhoan(tenDangNhap, "");
				System.out.println(taiKhoan.getTrangThai());
				if(taiKhoan.getTrangThai().equals("1")){
					session1.setAttribute("taiKhoan", taiKhoan);
					session1.setAttribute("tenDangNhap", tenDangNhap);
					session1.setAttribute("maTKDN", taiKhoan.getMaTK());
					session1.setAttribute("kiemtra", 2);
					
					if(taiKhoan.getLoaiTK()!=null){
						
						ArrayList<Integer> arr = new ArrayList<Integer>();
						
						arr = phanQuyenBO.getListQuyen(Integer.parseInt(taiKhoan.getMaTK()));
						if(arr.size()>0)
							session1.setAttribute("quanLy", 1);
						for(int i=0;i<arr.size();i++)
						{
							if(arr.get(i)==1)
								dangNhapForm.setBenh(1);
							if(arr.get(i)==2)
								dangNhapForm.setThuoc(1);
							if(arr.get(i)==3)
								dangNhapForm.setTrieuChung(1);
							if(arr.get(i)==4)
								dangNhapForm.setPhanQuyen(1);
							if(arr.get(i)==5)
								dangNhapForm.setDangBai(1);
						}
						
						ArrayList<ThongBao> listGopY = thongBaoBO.getListThongBaoGopY(taiKhoan.getMaTK(),0,0);
						thongBaoForm.setSoLuong(listGopY.size());
						thongBaoForm.setSoQuyen(arr.size());
						thongBaoForm.setListThongBao(listGopY);
					}
				
					session1.setAttribute("dangNhapForm", dangNhapForm);
					session1.setAttribute("thongBaoForm", thongBaoForm);
					return mapping.findForward("dangNhapThanhCong");
				}
				else{
					session1.setAttribute("kiemtra", 3);
					return mapping.findForward("dangNhapThatBai");
				}
			}
			else{
				session1.setAttribute("kiemtra", 1);
				return mapping.findForward("dangNhapThatBai");
			}
		}
		else if(tenDangNhap!=null && cookies != null && tenDangNhap!="" && form2==null){
			System.out.println("VÀO SESSION");
			System.out.println("TKDN= "+ tenDangNhap + " "+ matKhau);
			if(nguoiDungBO.checkLogin(tenDangNhap, matKhau)){
				TaiKhoan taiKhoan = taiKhoanBO.getThongTinTaiKhoan(tenDangNhap, "");
				System.out.println(taiKhoan.getTrangThai());
				if(taiKhoan.getTrangThai().equals("1")){
					session1.setAttribute("taiKhoan", taiKhoan);
					session1.setAttribute("tenDangNhap", tenDangNhap);
					session1.setAttribute("maTKDN", taiKhoan.getMaTK());
					session1.setAttribute("kiemtra", 2);
					
					if(taiKhoan.getLoaiTK()!=null){
						
						ArrayList<Integer> arr = new ArrayList<Integer>();
						
						arr = phanQuyenBO.getListQuyen(Integer.parseInt(taiKhoan.getMaTK()));
						if(arr.size()>0)
							session1.setAttribute("quanLy", 1);
						for(int i=0;i<arr.size();i++)
						{
							if(arr.get(i)==1)
								dangNhapForm.setBenh(1);
							if(arr.get(i)==2)
								dangNhapForm.setThuoc(1);
							if(arr.get(i)==3)
								dangNhapForm.setTrieuChung(1);
							if(arr.get(i)==4)
								dangNhapForm.setPhanQuyen(1);
							if(arr.get(i)==5)
								dangNhapForm.setDangBai(1);
						}
						
						ArrayList<ThongBao> listGopY = thongBaoBO.getListThongBaoGopY(taiKhoan.getMaTK(),0,0);
						thongBaoForm.setSoLuong(listGopY.size());
						thongBaoForm.setSoQuyen(arr.size());
						thongBaoForm.setListThongBao(listGopY);
					}
				
					session1.setAttribute("dangNhapForm", dangNhapForm);
					session1.setAttribute("thongBaoForm", thongBaoForm);
					return mapping.findForward("dangNhapThanhCong");
				}
				else{
					session1.setAttribute("kiemtra", 3);
					return mapping.findForward("dangNhapThatBai");
				}
			}
			else{
				session1.setAttribute("kiemtra", 1);
				return mapping.findForward("dangNhapThatBai");
			}
		}
		else{
			System.out.println("TRANGCHU");
			return mapping.findForward("trangChu");
		}
	}
}
