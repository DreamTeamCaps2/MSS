package action;

import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.TimKiemForm;
import model.bean.Benh;
import model.bean.Thuoc;
import model.bo.BenhBO;
import model.bo.ThuocBO;

public class TimKiemAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		BenhBO benhBO = new BenhBO();
		ThuocBO thuocBO = new ThuocBO();
		TimKiemForm timKiemForm =(TimKiemForm)form;
		String timKiem = timKiemForm.getTimKiem();
		String tam=timKiem;
		boolean macDinh = timKiemForm.isMacDinh();
		boolean luotXem = timKiemForm.isLuotXem();
		boolean abc = timKiemForm.isAbc();
		System.out.println(""+macDinh);
		System.out.println("luotXem"+luotXem);
		System.out.println("ABC"+abc);
		int maLoaiTimKiem= timKiemForm.getMaLoaiTimKiem();
		timKiem = new String(timKiem.getBytes("ISO-8859-1"),"UTF-8");


		if(timKiem.indexOf("'")!=-1){
			String t= ""+timKiem.charAt(timKiem.indexOf("'"));
			timKiem=timKiem.replaceAll(t, "''" );

		}

		//set lai tu khoa hien thi
		/*	String t="";
		StringTokenizer strTkn = new StringTokenizer(timKiem, "+");
		ArrayList<String> arrLis = new ArrayList<String>(timKiem.length());
		while(strTkn.hasMoreTokens())
			arrLis.add(strTkn.nextToken());
		for(int i=0;i<arrLis.size();i++){
			t=t+arrLis.get(i)+" ";
		}

		t = new String(t.getBytes("ISO-8859-1"),"UTF-8");*/
		//tim tat ca
		if(macDinh){
			if(maLoaiTimKiem==0){
				ArrayList<Benh> listBenh = benhBO.getListBenhTimKiem(timKiem);
				ArrayList<Thuoc> listThuoc = thuocBO.getListThuocTimKiem(timKiem);
				int soKetQua=listBenh.size()+listThuoc.size();

				timKiemForm.setListBenh(listBenh);
				timKiemForm.setListThuoc(listThuoc);
				timKiemForm.setTimKiem(tam);
				timKiemForm.setSoKetQua(soKetQua);;
				return mapping.findForward("timKiem");
			}
			else
				if(maLoaiTimKiem==1){
					ArrayList<Benh> listBenh = benhBO.getListBenhTimKiem(timKiem);
					int soKetQua=listBenh.size();

					timKiemForm.setListBenh(listBenh);
					timKiemForm.setTimKiem(tam);
					timKiemForm.setSoKetQua(soKetQua);;
					return mapping.findForward("timKiem");
				}
				else{
					ArrayList<Thuoc> listThuoc = thuocBO.getListThuocTimKiem(timKiem);
					int soKetQua=listThuoc.size();

					timKiemForm.setListThuoc(listThuoc);
					timKiemForm.setTimKiem(tam);
					timKiemForm.setSoKetQua(soKetQua);;
					return mapping.findForward("timKiem");

				}
		}
		else{
			//luot xem ,abc,tat ca

			if(maLoaiTimKiem==0){
				ArrayList<Benh> listBenh = benhBO.getListBenhTimKiemFilter(timKiem,luotXem,abc);
				ArrayList<Thuoc> listThuoc = thuocBO.getListThuocTimKiemFilter(timKiem,luotXem,abc);
				int soKetQua=listBenh.size()+listThuoc.size();

				timKiemForm.setListBenh(listBenh);
				timKiemForm.setListThuoc(listThuoc);
				timKiemForm.setTimKiem(tam);
				timKiemForm.setSoKetQua(soKetQua);;
				return mapping.findForward("timKiem");
			}
			else
				if(maLoaiTimKiem==1){
					ArrayList<Benh> listBenh = benhBO.getListBenhTimKiemFilter(timKiem,luotXem,abc);
					int soKetQua=listBenh.size();

					timKiemForm.setListBenh(listBenh);
					timKiemForm.setTimKiem(tam);
					timKiemForm.setSoKetQua(soKetQua);;
					return mapping.findForward("timKiem");
				}
				else{
					ArrayList<Thuoc> listThuoc = thuocBO.getListThuocTimKiemFilter(timKiem,luotXem,abc);
					int soKetQua=listThuoc.size();

					timKiemForm.setListThuoc(listThuoc);
					timKiemForm.setTimKiem(tam);
					timKiemForm.setSoKetQua(soKetQua);;
					return mapping.findForward("timKiem");

				}

		}
	}

}


