package com.macro.dev.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the lut_menu database table.
 * 
 */
@Entity
@Table(name="lut_cmm_organization")
@NamedQuery(name="LutCmmOrganization.findAll", query="SELECT l FROM LutCmmOrganization l")
public class LutCmmOrganization implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String orgname;
	
	private long orgtype;
	
	private Long parentid;

	//bi-directional many-to-one association to LutMenu
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="parentid", nullable = true,insertable=false,updatable=false)
	private LutCmmOrganization lutCmmOrganization;

	//bi-directional many-to-one association to LutMenu
	@OneToMany(mappedBy="lutCmmOrganization")
	@JsonBackReference
	private List<LutCmmOrganization> lutCmmOrganizations;

	public LutCmmOrganization() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getParentid() {
		return parentid;
	}

	public void setParentid(Long parentid) {
		this.parentid = parentid;
	}

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	public long getOrgtype() {
		return orgtype;
	}

	public void setOrgtype(long orgtype) {
		this.orgtype = orgtype;
	}

	public LutCmmOrganization getLutCmmOrganization() {
		return lutCmmOrganization;
	}

	public void setLutCmmOrganization(LutCmmOrganization lutCmmOrganization) {
		this.lutCmmOrganization = lutCmmOrganization;
	}

	public List<LutCmmOrganization> getLutCmmOrganizations() {
		return lutCmmOrganizations;
	}

	public void setLutCmmOrganizations(List<LutCmmOrganization> lutCmmOrganizations) {
		this.lutCmmOrganizations = lutCmmOrganizations;
	}

}