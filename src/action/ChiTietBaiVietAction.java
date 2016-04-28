package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.BaiVietForm;
import model.bean.BaiViet;
import model.bean.LuotXem;
import model.bo.BaiVietBO;

public class ChiTietBaiVietAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
	
		BaiVietForm baiVietForm = (BaiVietForm)form;
		BaiVietBO baiVietBO = new BaiVietBO();
		
		int maBaiViet = baiVietForm.getMaBaiViet();
		
		BaiViet baiViet = baiVietBO.getBaiViet(maBaiViet);
		baiVietForm.setTieuDe(baiViet.getTieuDe());
		baiVietForm.setTomTat(baiViet.getTomTat());
		baiVietForm.setHinhAnh(baiViet.getHinhAnh());
		baiVietForm.setNoiDung(baiViet.getNoiDung());
		
		//Lượt xem
		LuotXem luotXem = new LuotXem();
		luotXem.setLanDau(true);
		luotXem.setMa(maBaiViet);
		luotXem.setLuotXem(baiViet.getLuotXem());
		int tam=0;
		
		for(int i=0;i<BaiVietForm.getListLuotXem().size();i++){
			if(maBaiViet==BaiVietForm.getListLuotXem().get(i).getMa()){
				ArrayList<LuotXem> t= BaiVietForm.getListLuotXem();
				LuotXem luotXemTam=t.get(i);
				luotXemTam.setLanDau(false);
				t.set(i,luotXemTam );
				BaiVietForm.setListLuotXem(t);
				tam=1;
			}
		}
		if(tam==0){
			BaiVietForm.getListLuotXem().add(luotXem);
		}
		
		for(int i=0;i<BaiVietForm.getListLuotXem().size();i++){
			ArrayList<LuotXem> t =BaiVietForm.getListLuotXem();
			if(maBaiViet==t.get(i).getMa()){
				if(t.get(i).isLanDau()){
					baiVietBO.capNhatLuotXem(t.get(i).getMa(),BaiVietForm.getListLuotXem().get(i).getLuotXem() );
					LuotXem luotXemLanDau =t.get(i);
					luotXemLanDau.setThoiGianVao(request.getSession().getLastAccessedTime());
					t.set(i,luotXemLanDau);
					BaiVietForm.setListLuotXem(t);
				}
				else{
					long thoiGianVao=t.get(i).getThoiGianVao();
					long thoiGianBayGio = request.getSession().getLastAccessedTime();
					System.out.println(thoiGianBayGio-thoiGianVao);
					if(thoiGianBayGio-thoiGianVao>10000){
						baiVietBO.capNhatLuotXem(t.get(i).getMa(),BaiVietForm.getListLuotXem().get(i).getLuotXem()+1 );
						LuotXem luotXemLanDau =t.get(i);
						luotXemLanDau.setThoiGianVao(thoiGianBayGio);
						t.set(i,luotXemLanDau);
					
						BaiVietForm.setListLuotXem(t);
						
					}
				}
			}
			
		}
		
		
		return mapping.findForward("chiTietBaiViet");
	}
	
}
