package action;

import java.io.PrintWriter;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.TaiKhoanForm;
import model.bo.NguoiDungBO;
import model.bo.TaiKhoanBO;

public class QuenMatKhauAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/text;charset=utf-8");
		
		TaiKhoanForm taiKhoanForm = (TaiKhoanForm)form;
		TaiKhoanBO taiKhoanBO = new TaiKhoanBO();
		NguoiDungBO nguoiDungBO = new NguoiDungBO();
		
		System.out.println(taiKhoanForm.getSubmit());
		System.out.println(taiKhoanForm.getEmail());
		
		response.setContentType("text/text;charset=utf-8");
		response.setHeader("cache-control", "no-cache");
		response.setHeader("Content-Type", "application/json");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
		
		PrintWriter printWriter = response.getWriter();
		
		if("OK".equals(taiKhoanForm.getSubmit())){
            
			String login = "assasindark9194@gmail.com";
            String password = "DUC9101994";
            String to = taiKhoanForm.getEmail();
            String subject = "Yêu cầu đặt lại mật khẩu tại Tracuuyduoc.vn";
            String token = getSaltString();
			
			Properties props = new Properties();
            props.setProperty("mail.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.auth", "true");
            props.setProperty("mail.smtp.starttls.enable", "true");
            
			String matk = taiKhoanBO.updateToken(to, token);
            
            Authenticator auth = new SMTPAuthenticator(login, password);

            Session session = Session.getInstance(props,auth);	
            
            MimeMessage msg = new MimeMessage(session);
            msg.setSubject(subject,"utf-8");
            msg.setFrom(new InternetAddress("DarkAssasin"));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            
            String link = "http://192.168.1.7:8080/MSS/mat-khau.do?maTK="+matk+"&token="+token;
            
            MimeMultipart content = new MimeMultipart("related");
            
            // HTML part
            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setText("<html><head>"
              + "<title>ĐẶT LẠI MẬT KHẨU</title>"
              + "</head>\n"
              + "<body><div><b>Chào bạn!</b></div>"
              + "<br>"
              + "<div>Bạn cần phải bấm vào liên kết bên dưới. Hành động này sẽ tạo ra một mật khẩu mới và sẽ email đến cho bạn</div>\n"
              + "<div>Link: <a href=\""+ link+ "\">"+link+"</a></div>\n"
              + "<br>"
              + "<div>Cảm ơn!</div>\n"
              + "<div>Tracuuyduoc.vn</div>\n", 
              "utf-8", "html");
            content.addBodyPart(textPart);
            
            msg.setContent(content);
            Transport.send(msg);
			return mapping.findForward("quenMatKhauThanhCong");
		}
		else{
			if(taiKhoanForm.getEmail()!=null){
				if(nguoiDungBO.emailExist(taiKhoanForm.getEmail())==false){
					System.out.println("Ton Tai");
					printWriter.write("true");
				}
				else{
					System.out.println("ko ton tai");
					printWriter.write("false");
				}
				printWriter.flush();
				
				return null;
			}
		}
		return mapping.findForward("quenMatKhau");
	}
	private class SMTPAuthenticator extends Authenticator {

        private PasswordAuthentication authentication;

        public SMTPAuthenticator(String login, String password) {
            authentication = new PasswordAuthentication(login, password);
        }

        protected PasswordAuthentication getPasswordAuthentication() {
            return authentication;
        }
    }
	public String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
}
