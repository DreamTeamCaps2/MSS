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

import common.StringProcess;
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
		String anhBia="";
		
		if("OK".equals(baiVietForm.getSubmit())){
			
			maBaiViet = baiVietForm.getMaBaiViet();
			String tieuDe = baiVietForm.getTieuDe();
			String hinhAnh = baiVietForm.getHinhAnh();
			String noiDung = baiVietForm.getNoiDung();
			String tomTat = baiVietForm.getTomTat();
			
			file = baiVietForm.getFile();
			if(file.getFileName()!=""){
				StringProcess process = new StringProcess();
				hinhAnh = process.makeSlug(tieuDe)+".jpg";
				try {
		            String path = getServlet().getServletContext().getRealPath("/")+"images"+"/" + hinhAnh;
		            System.out.println(path);
		            //outputStream = new FileOutputStream(new File("F:/gitgit/MSS/WebContent/images/"+file.getFileName()));
		            outputStream = new FileOutputStream(new File(path));
		            outputStream.write(file.getFileData());
		            
		        } finally {
		            if (outputStream != null) {
		                outputStream.close();
		            }
		        }
			}
			else
				hinhAnh = (String)request.getSession().getAttribute("anhBia");
			
			System.out.println("hinh: "+ hinhAnh);
			
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
			
			anhBia = baiViet.getHinhAnh();
			
			request.getSession().setAttribute("anhBia", anhBia);
			return mapping.findForward("suaBaiViet");
		}
	}

}
