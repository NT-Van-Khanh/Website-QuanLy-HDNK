package qlhdnk.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="MaXacNhan")
public class VerificationsEntity {
	@Id
	@Column(name="email", nullable = false)
	private String email;
	
	@Column(name="codeXacNhan", nullable = false)
	private String vertificationCode;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern="HH:mm:ss dd-MM-yyyy")
	@Column(name="thoiHan", nullable = false)
	private Date expiryTime;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getVertificationCode() {
		return vertificationCode;
	}

	public void setVertificationCode(String vertificationCode) {
		this.vertificationCode = vertificationCode;
	}



	public Date getExpiryTime() {
		return expiryTime;
	}

	public void setExpiryTime(Date expiryTime) {
		this.expiryTime = expiryTime;
	}

	public VerificationsEntity() {
	}

	public VerificationsEntity(String email, String vertificationCode, Date expiryTime) {
		this.email = email;
		this.vertificationCode = vertificationCode;
		this.expiryTime = expiryTime;
	}

	
    
    
}
