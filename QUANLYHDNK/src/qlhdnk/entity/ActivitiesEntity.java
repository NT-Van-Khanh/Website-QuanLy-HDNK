package qlhdnk.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="HoatDong")
public class ActivitiesEntity {
	
	@Id
	@GeneratedValue
	@Column(name="maHD", nullable = false)
	private int idActivity;
	
	@Column(name="tenHD", nullable = false)
	private String nameActivity;
	
	@Column(name="noiDung", nullable = false)
	private String contentActivity;
	
	@ManyToOne
	@JoinColumn(name="maTheLoai", nullable = false)
	private TitlesEntity title;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern="HH:mm dd/MM/yyyy")
	@Column(name="ngayDang", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date postTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern="HH:mm dd/MM/yyyy")
	@Column(name="ngayBD", nullable = false)
	private Date startTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern="HH:mm dd/MM/yyyy")
	@Column(name="ngayKT", nullable = false)
	private Date endTime;

	@Column(name="soLuongDK",nullable = true)
	private Integer quantity;
	
	@Column(name="diaDiem")
	private String address;
	
	@Column(name="anh")
	private byte[] avatar;
	
	@ManyToOne
	@JoinColumn(name="maNguoiDang")
	private AccountsEntity posterActi;
	
	@Column(name="flagHD", nullable = false)
	private boolean flagHD;
	
	@OneToMany(mappedBy = "activityNotifi",fetch = FetchType.EAGER )
	private Collection<NotificationsEntity> notifications;
	
	@OneToMany(mappedBy = "activityRegis",fetch = FetchType.EAGER)
	private Collection<RegistersEntity> registers;
	
	@Transient
	private String pictureBase64;
	
	@Transient
	private long quantityAvailable;
	
	
	public long getQuantityAvailable() {
		return quantityAvailable;
	}

	public void setQuantityAvailable(long quantityAvailable) {
		this.quantityAvailable = quantityAvailable;
	}

	public String getPictureBase64() {
		return pictureBase64;
	}

	public void setPictureBase64(String pictureBase64) {
		this.pictureBase64 = pictureBase64;
	}

	public ActivitiesEntity(){
	}

	public int getIdActivity() {
		return idActivity;
	}

	public void setIdActivity(int idActivity) {
		this.idActivity = idActivity;
	}

	public String getNameActivity() {
		return nameActivity;
	}

	public void setNameActivity(String nameActivity) {
		this.nameActivity = nameActivity;
	}

	public String getContentActivity() {
		return contentActivity;
	}

	public void setContentActivity(String contentActivity) {
		this.contentActivity = contentActivity;
	}

	public TitlesEntity getTitle() {
		return title;
	}

	public void setTitle(TitlesEntity title) {
		this.title = title;
	}

	public Date getPostTime() {
		return postTime;
	}

	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public byte[] getAvatar() {
		return avatar;
	}

	public void setAvatar(byte[] avatar) {
		this.avatar = avatar;
	}

	public AccountsEntity getPosterActi() {
		return posterActi;
	}

	public void setPosterActi(AccountsEntity posterActi) {
		this.posterActi = posterActi;
	}

	public boolean isFlagHD() {
		return flagHD;
	}

	public void setFlagHD(boolean flagHD) {
		this.flagHD = flagHD;
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

}
