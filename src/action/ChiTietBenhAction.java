package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.BenhForm;
import form.BenhForm;
import model.bean.Benh;
import model.bean.LuotXem;
import model.bean.Thuoc;
import model.bo.BenhBO;
import model.bo.ThuocBO;

public class ChiTietBenhAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		BenhBO benhBO =  new BenhBO();
		ThuocBO thuocBO = new ThuocBO();
		BenhForm benhForm = (BenhForm)form;
		int ma = benhForm.getMa();
		Benh benh = new Benh();
		System.out.println(ma);
		benh = benhBO.getBenhAuto(ma);

		int maLoaiBenh= benh.getMaLoaiBenh();
		
		ArrayList<Benh> listBenh = new ArrayList<Benh>();
		listBenh= benhBO.getListBenhLienQuan(maLoaiBenh);
		benhForm.setListBenh(listBenh);
		benhForm.setSoLuongBenh(listBenh.size());
		
		for(int i=0;i<listBenh.size();i++){
			System.out.println(listBenh.get(i).getHinhAnh());
		}
		
		ArrayList<Thuoc> listThuoc = new ArrayList<Thuoc>();
		listThuoc=thuocBO.getListThuocLienQuanBenh(ma);
		benhForm.setListThuoc(listThuoc);
		
		benhForm.setTenBenh(benh.getTenBenh());
		benhForm.setHinhAnh(benh.getHinhAnh());
		benhForm.setLuotXem(benh.getLuotXem());
		benhForm.setChanDoan(benh.getChanDoan());
		benhForm.setCheDoDinhDuong(benh.getCheDoDinhDuong());
		benhForm.setDieuTri(benh.getDieuTri());
		benhForm.setDinhNghia(benh.getDinhNghia());
		benhForm.setBienChung(benh.getBienChung());
		benhForm.setNguyenNhan(benh.getNguyenNhan());
		benhForm.setSoLuongThuoc(listThuoc.size());
		benhForm.setLuotXem(benh.getLuotXem());
		//set list  xem nhieu 
		ArrayList<Benh> listBenhXemNhieu = new ArrayList<Benh>();
		listBenhXemNhieu = benhBO.getListBenhXemNhieu();
		benhForm.setListBenhXemNhieu(listBenhXemNhieu);
		
		ArrayList<Thuoc> listThuocXemNhieu = new ArrayList<Thuoc>();
		listThuocXemNhieu = thuocBO.getListThuocXemNhieu();
		benhForm.setListThuocXemNhieu(listThuocXemNhieu);
		
		
		
		//xu ly luot xem
		LuotXem luotXem = new LuotXem();
		luotXem.setLanDau(true);
		luotXem.setMa(ma);
		luotXem.setLuotXem(benh.getLuotXem());
		int tam=0;
		for(int i=0;i<BenhForm.getListLuotXem().size();i++){
			if(ma==BenhForm.getListLuotXem().get(i).getMa()){
				ArrayList<LuotXem> t= BenhForm.getListLuotXem();
				LuotXem luotXemTam=t.get(i);
				luotXemTam.setLanDau(false);
				t.set(i,luotXemTam );
				BenhForm.setListLuotXem(t);
				tam=1;
			}
			
		}
		if(tam==0){
			BenhForm.getListLuotXem().add(luotXem);
		}
		
		for(int i=0;i<BenhForm.getListLuotXem().size();i++){
			ArrayList<LuotXem> t =BenhForm.getListLuotXem();
			if(ma==t.get(i).getMa()){
				if(t.get(i).isLanDau()){
					benhBO.capNhatLuotXem(t.get(i).getMa(),BenhForm.getListLuotXem().get(i).getLuotXem() );
					LuotXem luotXemLanDau =t.get(i);
					luotXemLanDau.setThoiGianVao(request.getSession().getLastAccessedTime());
					t.set(i,luotXemLanDau);
					BenhForm.setListLuotXem(t);
				}
				else{
					long thoiGianVao=t.get(i).getThoiGianVao();
					long thoiGianBayGio = request.getSession().getLastAccessedTime();
					System.out.println(thoiGianBayGio-thoiGianVao);
					if(thoiGianBayGio-thoiGianVao>10000){
						benhBO.capNhatLuotXem(t.get(i).getMa(),BenhForm.getListLuotXem().get(i).getLuotXem()+1 );
						LuotXem luotXemLanDau =t.get(i);
						luotXemLanDau.setThoiGianVao(thoiGianBayGio);
						t.set(i,luotXemLanDau);
						BenhForm.setListLuotXem(t);
						
					}
				}
			}
			
		}
		return mapping.findForward("chiTietBenh");
	}

}
