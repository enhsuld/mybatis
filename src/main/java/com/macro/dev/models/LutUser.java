package com.macro.dev.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;
import javax.persistence.*;
@Entity
@Table(name="lut_user")
@NamedQuery(name="LutUser.findAll", query="SELECT l FROM LutUser l")
public class LutUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String givenname;
    private String familyname;
    private String email;
    private boolean isactive;
    private String mobile;

    private long organizationid;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="organizationid", nullable = true,insertable=false,updatable=false)
    private LutCmmOrganization lutCmmOrganization;

   /* //bi-directional many-to-one association to LnkUserrole
    @OneToMany(mappedBy="lutUser",fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<LnkUserrole> lnkUserroles;*/

    @JsonIgnore
    private String password;
    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private List<LutRole> lutRoles;

    public LutUser() {}

    public LutUser(String username, String password,Long orgid, List<LutRole> lutRoles) {
        this.username = username;
        this.password = password;
        this.lutRoles = lutRoles;
        this.organizationid = orgid;
    }

    public long getOrganizationid() {
        return organizationid;
    }

    public void setOrganizationid(long organizationid) {
        this.organizationid = organizationid;
    }

    public LutCmmOrganization getLutCmmOrganization() {
        return lutCmmOrganization;
    }

    public void setLutCmmOrganization(LutCmmOrganization lutCmmOrganization) {
        this.lutCmmOrganization = lutCmmOrganization;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFamilyname() {
        return familyname;
    }

    public void setFamilyname(String familyname) {
        this.familyname = familyname;
    }

    public String getGivenname() {
        return givenname;
    }

    public void setGivenname(String givenname) {
        this.givenname = givenname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isIsactive() {
        return isactive;
    }

    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<LutRole> getLutRoles() {
        return lutRoles;
    }

    public void setLutRoles(List<LutRole> lutRoles) {
        this.lutRoles = lutRoles;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
