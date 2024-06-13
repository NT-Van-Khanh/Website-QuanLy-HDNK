package qlhdnk.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="ThongBao")
public class NotificationsEntity {

		@Id
		@GeneratedValue
		@Column(name="maTB", nullable = false)
		private int idNotifi;
		
		@Column(name="tieuDe", nullable = false)
		private String nameNotifi;
		
		@Column(name="noiDung", nullable = false)
		private String content;
		
		@Temporal(TemporalType.TIMESTAMP)
		@DateTimeFormat(pattern="HH:mm:ss dd/MM/yyyy")
		@Column(name="thoiGian", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
		private Date timePost;
		
		@ManyToOne
		@JoinColumn(name="maHoatDong")
		private ActivitiesEntity activityNotifi;
		
		@ManyToOne
		@JoinColumn(name="maNguoiDang")
		private AccountsEntity posterNotifi;
		
		@Column(name="flagTB", nullable = false)
		private boolean flagTB;

		public NotificationsEntity() {
		}

		public int getIdNotifi() {
			return idNotifi;
		}

		public void setIdNotifi(int idNotifi) {
			this.idNotifi = idNotifi;
		}

		public String getNameNotifi() {
			return nameNotifi;
		}

		public void setNameNotifi(String nameNotifi) {
			this.nameNotifi = nameNotifi;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public Date getTimePost() {
			return timePost;
		}

		public void setTimePost(Date timePost) {
			this.timePost = timePost;
		}

		public ActivitiesEntity getActivityNotifi() {
			return activityNotifi;
		}

		public void setActivityNotifi(ActivitiesEntity activityNotifi) {
			this.activityNotifi = activityNotifi;
		}

		public AccountsEntity getPosterNotifi() {
			return posterNotifi;
		}

		public void setPosterNotifi(AccountsEntity posterNotifi) {
			this.posterNotifi = posterNotifi;
		}

		public boolean isFlagTB() {
			return flagTB;
		}

		public void setFlagTB(boolean flagTB) {
			this.flagTB = flagTB;
		}



		
}
