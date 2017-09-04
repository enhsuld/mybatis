package com.macro.dev.models;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="lut_role")
@NamedQuery(name="LutRole.findAll", query="SELECT l FROM LutRole l")
public class LutRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String name;
    private int accessid;
    public LutRole() {}

/*    //bi-directional many-to-one association to LnkUserrole
    @OneToMany(mappedBy="lutRole")
    private List<LnkUserrole> lnkUserroles;*/

    public LutRole(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAccessid() {
        return accessid;
    }

    public void setAccessid(int accessid) {
        this.accessid = accessid;
    }

}
