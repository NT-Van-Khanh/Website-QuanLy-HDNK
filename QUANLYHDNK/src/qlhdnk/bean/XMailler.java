package qlhdnk.bean;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service("mailer")
public class XMailler {
	@Autowired
	JavaMailSender mailer;
	
	public void send (String to, String subject, String body) {
		
		try {
			MimeMessage mail= mailer.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mail,true,"utf-8");
			helper.setFrom("n21dccn043@student.ptithcm.edu.vn","QUAN LY HOAT DONG NGOAI KHOA");
			helper.setTo(to);
			helper.setReplyTo("n21dccn043@student.ptithcm.edu.vn","QUAN LY HOAT DONG NGOAI KHOA");
			helper.setSubject(subject);
			helper.setText(body,true);
			mailer.send(mail);
	
		}catch(Exception e) {
			throw new RuntimeException(e);
		}	
	}

}
