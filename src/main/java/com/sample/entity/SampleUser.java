/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author k0712
 */
@Entity
@Table(name = "sample_user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SampleUser.findAll", query = "SELECT s FROM SampleUser s")})
public class SampleUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id")
    private Integer userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gender")
    private int gender;
    @Size(max = 255)
    @Column(name = "nic")
    private String nic;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId",fetch = FetchType.LAZY)
    private List<SampleContact> sampleContactCollection;

    public SampleUser() {
    }

    public SampleUser(Integer userId) {
        this.userId = userId;
    }

    public SampleUser(Integer userId, String username, String password, int gender) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.gender = gender;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    @XmlTransient
    public List<SampleContact> getSampleContactCollection() {
        return sampleContactCollection;
    }

    public void setSampleContactCollection(List<SampleContact> sampleContactCollection) {
        this.sampleContactCollection = sampleContactCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SampleUser)) {
            return false;
        }
        SampleUser other = (SampleUser) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sample.entity.SampleUser[ userId=" + userId + " ]";
    }
    
}
