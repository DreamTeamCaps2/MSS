package action;

import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import form.BaiVietForm;
import model.bean.BaiViet;
import model.bo.BaiVietBO;

public class QuanLy_BaiViet_SuaAction extends Action{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
	
		BaiVietForm baiVietForm = (BaiVietForm)form;
		BaiVietBO baiVietBO = new BaiVietBO();
        FileOutputStream outputStream = null;
        FormFile file = null;
		
		int maBaiViet = baiVietForm.getMaBaiViet();
		
		if("OK".equals(baiVietForm.getSubmit())){
			
			maBaiViet = baiVietForm.getMaBaiViet();
			String tieuDe = baiVietForm.getTieuDe();
			String hinhAnh = baiVietForm.getHinhAnh();
			String noiDung = baiVietForm.getNoiDung();
			String tomTat = baiVietForm.getTomTat();
			
			try {
				 
			 	file = baiVietForm.getFile();
			 	String path = getServlet().getServletContext().getRealPath("/")+"images"+"/"+file.getFileName();
//	            String filePath = System.getProperty("java.io.tmpdir") + "/" + file.getFileName();
	            System.out.println(path);
//	            System.out.println(filePath);
	            outputStream = new FileOutputStream(new File(path));
	            outputStream.write(file.getFileData());
	            
	        } finally {
	            if (outputStream != null) {
	                outputStream.close();
	            }
	        }
			hinhAnh = file.getFileName();
			
			System.out.println(maBaiViet);
			baiVietBO.suaBaiViet(maBaiViet,tieuDe,tomTat,hinhAnh,noiDung);
			
			return mapping.findForward("suaBaiVietXong");
		}
		else{
			BaiViet baiViet = baiVietBO.getBaiViet(maBaiViet);
			baiVietForm.setMaBaiViet(maBaiViet);
			baiVietForm.setTieuDe(baiViet.getTieuDe());
			baiVietForm.setTomTat(baiViet.getTomTat());
			baiVietForm.setHinhAnh(baiViet.getHinhAnh());
			baiVietForm.setNoiDung(baiViet.getNoiDung());
			
			return mapping.findForward("suaBaiViet");
		}
	}

}
