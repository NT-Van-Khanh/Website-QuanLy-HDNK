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
	private String id;
	
	@Column(name="tenVT")
	private String name;
	
	@Column(name="flagVT")
	private boolean flagVT;

	@OneToMany(mappedBy="role", fetch=FetchType.EAGER)
	private Collection<AccountsEntity> accounts;

	
	
	public RolesEntity() {
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
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
