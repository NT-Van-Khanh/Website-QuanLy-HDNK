package qlhdnk.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="TaiKhoan")
public class AccountsEntity {

	@Id

	@Column(name="maTK")
	private String userId;
	
	@Column(name="tenTK")
    private String userName;
	
	@Column(name="matKhau")

	private String password;

	@Column(name="gioiTinh")
    private String gender;

	@Column(name="email")
    private String email;

	@Column(name="sdt")
    private String phoneNumber;

	@Column(name="diaChi")
    private String address;

	@ManyToOne
	@JoinColumn(name="maVaiTro")
    private RolesEntity role;//donVi 

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern="HH:mm:ss dd/MM/yyyy")
	@Column(name="ngayTao")
    private Date accountCreationDate;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(name="ngaySinh")
    private Date Birthday;

	
	@Column(name="anhTK")


    private byte[] avatar;

	@Column(name="flagTK")
	private boolean flagTK;


	@OneToMany(mappedBy = "posterNotifi",fetch = FetchType.EAGER)
	private Collection<NotificationsEntity> notifications;

	@OneToMany(mappedBy = "registrant",fetch = FetchType.EAGER)
	private Collection<RegistersEntity> registers;

	@OneToMany(mappedBy = "posterActi",fetch =FetchType.EAGER)
	private Collection<ActivitiesEntity> activities;

	public AccountsEntity() {
	}

	public String getUserId(){
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public RolesEntity getRole() {
		return role;
	}

	public void setRole(RolesEntity role) {
		this.role = role;
	}

	public Date getAccountCreationDate() {
		return accountCreationDate;
	}

	public void setAccountCreationDate(Date accountCreationDate) {
		this.accountCreationDate = accountCreationDate;
	}

	public Date getBirthday() {
		return Birthday;
	}

	public void setBirthday(Date birthday) {
		Birthday = birthday;
	}

	public byte[] getAvatar() {
		return avatar;
	}

	public void setAvatar(byte[] avatar) {
		this.avatar = avatar;
	}

	public boolean isFlagTK() {
		return flagTK;
	}

	public void setFlagTK(boolean flagTK) {
		this.flagTK = flagTK;
	}

	public Collection<NotificationsEntity> getNotifications() {
		return notifications;
	}

	public void setNotifications(Collection<NotificationsEntity> notifications) {
		this.notifications = notifications;
	}

	public Collection<RegistersEntity> getRegisters() {
		return registers;
	}

	public void setRegisters(Collection<RegistersEntity> registers) {
		this.registers = registers;
	}

	public Collection<ActivitiesEntity> getActivities() {
		return activities;
	}

	public void setActivities(Collection<ActivitiesEntity> activities) {
		this.activities = activities;
	}


}