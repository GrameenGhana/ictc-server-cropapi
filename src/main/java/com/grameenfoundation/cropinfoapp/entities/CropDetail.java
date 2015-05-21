/*
 * @Copyright Grameen Foundation
 */
package com.grameenfoundation.cropinfoapp.entities;

import com.grameenfoundation.cropinfoapp.basemodel.BaseEntity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author grameen
 */
@Entity
@Table(name = "crop_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CropDetail.findAll", query = "SELECT c FROM CropDetail c"),
    @NamedQuery(name = "CropDetail.findByCrop", query = "SELECT c FROM CropDetail c WHERE c.crop = :crop"),
    @NamedQuery(name = "CropDetail.findBySeason", query = "SELECT c FROM CropDetail c WHERE c.season = :season"),
    @NamedQuery(name = "CropDetail.findByStartDate", query = "SELECT c FROM CropDetail c WHERE c.startDate = :startDate"),
    @NamedQuery(name = "CropDetail.findByEndDate", query = "SELECT c FROM CropDetail c WHERE c.endDate = :endDate"),
    @NamedQuery(name = "CropDetail.findByActivity", query = "SELECT c FROM CropDetail c WHERE c.activity = :activity"),
    @NamedQuery(name = "CropDetail.findByRegion", query = "SELECT c FROM CropDetail c WHERE c.region = :region"),
    @NamedQuery(name = "CropDetail.findById", query = "SELECT c FROM CropDetail c WHERE c.id = :id"),
    })
public class CropDetail extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "crop")
    private String crop;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "season")
    private String season;
    @NotNull
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "activity")
    private String activity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "region")
    private String region;
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name="gen",strategy="increment")
    @GeneratedValue(generator="gen")
    @Basic(optional = false)
    @Column(name = "id",unique = true, nullable = false, precision = 15, scale = 0)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valid_until")
    //@Temporal(TemporalType.DATE)
    private Integer validUntil;
   

    public CropDetail() {
    }

    public CropDetail(Integer id) {
        this.id = id;
    }

   public CropDetail(Integer id, String crop, String season, Date startDate, Date endDate, String activity, String region, Date lastModified, Date createdDate,Integer validUntil) {
        this.id = id;
        this.crop = crop;
        this.season = season;
        this.startDate = startDate;
        this.endDate = endDate;
        this.activity = activity;
        this.region = region;
        this.validUntil = validUntil;
    }

    public String getCrop() {
        return crop;
    }

    public void setCrop(String crop) {
        this.crop = crop;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

   public Integer getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(Integer validUntil) {
        this.validUntil = validUntil;
    }
  
   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CropDetail)) {
            return false;
        }
        CropDetail other = (CropDetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.grameenfoundation.cropinfoapp.entities.CropDetail[ id=" + id + " ]";
    }
    
}
