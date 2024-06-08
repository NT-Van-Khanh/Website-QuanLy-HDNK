package qlhdnk.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="VaiTro")
public class RolesEntity {
	
	@Id
	@Column(name="maVT")
	private String idRole;
	
	@Column(name="tenVT")
	private String nameRole;
	
	@Column(name="flagVT")
	private boolean flagVT;

	@OneToMany(mappedBy="role", fetch=FetchType.EAGER)
	private Collection<AccountsEntity> accounts;

	
	
	public RolesEntity() {
	}

	public String getIdRole() {
		return idRole;
	}

	public void setIdRole(String idRole) {
		this.idRole = idRole;
	}

	public String getNameRole() {
		return nameRole;
	}

	public void setNameRole(String nameRole) {
		this.nameRole = nameRole;
	}

	public boolean isFlagVT() {
		return flagVT;
	}

	public void setFlagVT(boolean flagVT) {
		this.flagVT = flagVT;
	}

	public Collection<AccountsEntity> getAccounts() {
		return accounts;
	}

	public void setAccounts(Collection<AccountsEntity> accounts) {
		this.accounts = accounts;
	}
	
	
}
