package qlhdnk.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="LoaiHoatDong")
public class TitlesEntity {
	@Id
	@Column(name="maLHD")
	private String idTitle;
	
	@Column(name="tenLHD")
	private String nameTitle;
	
	@Column(name="flagLHD")
	private boolean flagLHD;

	@OneToMany(mappedBy="title", fetch=FetchType.EAGER)
	private Collection<ActivitiesEntity> activities;

	public TitlesEntity() {
	}

	public String getIdTitle() {
		return idTitle;
	}

	public void setIdTitle(String idTitle) {
		this.idTitle = idTitle;
	}

	public String getNameTitle() {
		return nameTitle;
	}

	public void setNameTitle(String nameTitle) {
		this.nameTitle = nameTitle;
	}

	public boolean isFlagLHD() {
		return flagLHD;
	}

	public void setFlagLHD(boolean flagLHD) {
		this.flagLHD = flagLHD;
	}

	public Collection<ActivitiesEntity> getActivities() {
		return activities;
	}

	public void setActivities(Collection<ActivitiesEntity> activities) {
		this.activities = activities;
	}

	
	
}
