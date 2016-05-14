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
import model.dao.GetJSONDAO;

public class CapNhatAction extends Action{

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		BaiVietForm baiVietForm = (BaiVietForm)form;
        FileOutputStream outputStream = null;
        FormFile file = null;
        
		if("Update".equals(baiVietForm.getSubmit())){
			GetJSONDAO json = new GetJSONDAO();
			json.updateJSON();
		}
		if("Upload".equals(baiVietForm.getSubmit())){
			file = baiVietForm.getFile();
			if(file.getFileName()!=""){
				String tenFile = "MSS.apk";
				try {
		            String path = getServlet().getServletContext().getRealPath("/")+"android"+"/" + tenFile;
		            System.out.println(path);
		            //outputStream = new FileOutputStream(new File("F:/gitgit/MSS/WebContent/images/"+chuoi));
		            outputStream = new FileOutputStream(new File(path));
		            outputStream.write(file.getFileData());
		            
		        } finally {
		            if (outputStream != null) {
		                outputStream.close();
		            }
		        }
			}
		}
		
		return mapping.findForward("capNhat");
	
	}
}
