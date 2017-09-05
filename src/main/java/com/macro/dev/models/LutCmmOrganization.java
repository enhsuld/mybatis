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

	private long orgtype;
	
	private Long parentid;

	private String name;
	private String phone;
	private String dirname;
	private String fax;
	private String enybo;
	private String tnybo;
	private String web;
	private String email;
	private String regno;
	private String ndno;
	private String aimag;
	private String sum;
	private String bag;
	private String activity;

	private boolean isactive;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDirname() {
		return dirname;
	}

	public void setDirname(String dirname) {
		this.dirname = dirname;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEnybo() {
		return enybo;
	}

	public void setEnybo(String enybo) {
		this.enybo = enybo;
	}

	public String getTnybo() {
		return tnybo;
	}

	public void setTnybo(String tnybo) {
		this.tnybo = tnybo;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegno() {
		return regno;
	}

	public void setRegno(String regno) {
		this.regno = regno;
	}

	public String getNdno() {
		return ndno;
	}

	public void setNdno(String ndno) {
		this.ndno = ndno;
	}

	public String getAimag() {
		return aimag;
	}

	public void setAimag(String aimag) {
		this.aimag = aimag;
	}

	public String getSum() {
		return sum;
	}

	public void setSum(String sum) {
		this.sum = sum;
	}

	public String getBag() {
		return bag;
	}

	public void setBag(String bag) {
		this.bag = bag;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public boolean isIsactive() {
		return isactive;
	}

	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}
}