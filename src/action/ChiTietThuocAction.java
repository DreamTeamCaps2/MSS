package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.ThuocForm;
import model.bean.LuotXem;
import model.bean.Thuoc;
import model.bo.ThuocBO;

public class ChiTietThuocAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ThuocBO thuocBO =  new ThuocBO();
		ThuocForm thuocForm= (ThuocForm)form;
		int ma =thuocForm.getMa();
		//lay thong tin ve thuoc
		Thuoc thuoc = new Thuoc();
		
		thuoc= thuocBO.getThuoc(ma);
		System.out.println(thuoc.getBaoQuan());
		String tenThuoc=thuoc.getTenThuoc();
		
		
		thuocForm.setTenThuoc(tenThuoc);
		thuocForm.setTenKhoaHoc(thuoc.getTenKhoaHoc());
		thuocForm.setCongThuc(thuoc.getCongThuc());
		thuocForm.setDieuChe(thuoc.getDieuChe());
		thuocForm.setTinhChat(thuoc.getTinhChat());
		thuocForm.setTacDung(thuoc.getTacDung());
		thuocForm.setChiDinh(thuoc.getChiDinh());
		thuocForm.setBaoQuan(thuoc.getBaoQuan());
		thuocForm.setThanTrong(thuoc.getThanTrong());
		thuocForm.setDDH(thuoc.getDDH());
		thuocForm.setMaNhomThuoc(thuoc.getMaNhomThuoc());
		thuocForm.setHinhAnh(thuoc.getHinhAnh());
		thuocForm.setLuotXem(thuoc.getLuotXem());
		thuocForm.setTenNhomThuoc(thuoc.getTenNhomThuoc());
		thuocForm.setTenLoaiThuoc(thuoc.getTenLoaiThuoc());
		thuocForm.setMaLoaiThuoc(thuoc.getMaLoaiThuoc());
		
		// Xu ly Luot Xem
		LuotXem luotXem = new LuotXem();
		luotXem.setLanDau(true);
		luotXem.setMa(ma);
		luotXem.setLuotXem(thuoc.getLuotXem());
		int tam=0;
		for(int i=0;i<ThuocForm.getListLuotXem().size();i++){
			if(ma==ThuocForm.getListLuotXem().get(i).getMa()){
				ArrayList<LuotXem> t= ThuocForm.getListLuotXem();
				LuotXem luotXemTam=t.get(i);
				luotXemTam.setLanDau(false);
				t.set(i,luotXemTam );
				ThuocForm.setListLuotXem(t);
				tam=1;
			}
			
		}
		if(tam==0){
			ThuocForm.getListLuotXem().add(luotXem);
		}
		
		for(int i=0;i<ThuocForm.getListLuotXem().size();i++){
			ArrayList<LuotXem> t =ThuocForm.getListLuotXem();
			if(ma==t.get(i).getMa()){
				if(t.get(i).isLanDau()){
					thuocBO.capNhatLuotXem(t.get(i).getMa(),ThuocForm.getListLuotXem().get(i).getLuotXem() );
					LuotXem luotXemLanDau =t.get(i);
					luotXemLanDau.setThoiGianVao(request.getSession().getLastAccessedTime());
					t.set(i,luotXemLanDau);
					ThuocForm.setListLuotXem(t);
				}
				else{
					long thoiGianVao=t.get(i).getThoiGianVao();
					long thoiGianBayGio = request.getSession().getLastAccessedTime();
					System.out.println(thoiGianBayGio-thoiGianVao);
					if(thoiGianBayGio-thoiGianVao>10000){
						thuocBO.capNhatLuotXem(t.get(i).getMa(),ThuocForm.getListLuotXem().get(i).getLuotXem()+1 );
						LuotXem luotXemLanDau =t.get(i);
						luotXemLanDau.setThoiGianVao(thoiGianBayGio);
						t.set(i,luotXemLanDau);
						ThuocForm.setListLuotXem(t);
						
					}
				}
			}
			
		}
		
		return mapping.findForward("chiTietThuoc");
	}
}
