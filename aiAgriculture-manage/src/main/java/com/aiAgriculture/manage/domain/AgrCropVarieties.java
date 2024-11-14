package com.aiAgriculture.manage.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aiAgriculture.common.annotation.Excel;
import com.aiAgriculture.common.core.domain.BaseEntity;

/**
 * 品种管理对象 agr_crop_varieties
 * 
 * @author aiagr
 * @date 2024-11-09
 */
public class AgrCropVarieties extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 自增主键 */
    @Excel(name = "自增主键")
    private Long id;

    /** 品种编号 */
    @Excel(name = "品种编号")
    private String varietyCode;

    /** 品种名称 */
    @Excel(name = "品种名称")
    private String varietyName;

    /** 种子公司 */
    @Excel(name = "种子公司")
    private String seedCompany;

    /** 生产时间 */
    @Excel(name = "生产时间")
    private String productionTime;

    /** 种子单价 */
    @Excel(name = "种子单价")
    private String seedPrice;

    /** 价格单位 */
    @Excel(name = "价格单位")
    private String priceUnit;

    /** 品种说明 */
    @Excel(name = "品种说明")
    private String varietyDescription;

    /** 创建时间 */
    private Date createdAt;

    /** 创建人 */
    private String createdBy;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updatedAt;

    /** 更新人 */
    @Excel(name = "更新人")
    private String updatedBy;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setVarietyCode(String varietyCode) 
    {
        this.varietyCode = varietyCode;
    }

    public String getVarietyCode() 
    {
        return varietyCode;
    }
    public void setVarietyName(String varietyName) 
    {
        this.varietyName = varietyName;
    }

    public String getVarietyName() 
    {
        return varietyName;
    }
    public void setSeedCompany(String seedCompany) 
    {
        this.seedCompany = seedCompany;
    }

    public String getSeedCompany() 
    {
        return seedCompany;
    }
    public void setProductionTime(String productionTime) 
    {
        this.productionTime = productionTime;
    }

    public String getProductionTime() 
    {
        return productionTime;
    }
    public void setSeedPrice(String seedPrice) 
    {
        this.seedPrice = seedPrice;
    }

    public String getSeedPrice() 
    {
        return seedPrice;
    }
    public void setPriceUnit(String priceUnit) 
    {
        this.priceUnit = priceUnit;
    }

    public String getPriceUnit() 
    {
        return priceUnit;
    }
    public void setVarietyDescription(String varietyDescription) 
    {
        this.varietyDescription = varietyDescription;
    }

    public String getVarietyDescription() 
    {
        return varietyDescription;
    }
    public void setCreatedAt(Date createdAt) 
    {
        this.createdAt = createdAt;
    }

    public Date getCreatedAt() 
    {
        return createdAt;
    }
    public void setCreatedBy(String createdBy) 
    {
        this.createdBy = createdBy;
    }

    public String getCreatedBy() 
    {
        return createdBy;
    }
    public void setUpdatedAt(Date updatedAt) 
    {
        this.updatedAt = updatedAt;
    }

    public Date getUpdatedAt() 
    {
        return updatedAt;
    }
    public void setUpdatedBy(String updatedBy) 
    {
        this.updatedBy = updatedBy;
    }

    public String getUpdatedBy() 
    {
        return updatedBy;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("varietyCode", getVarietyCode())
            .append("varietyName", getVarietyName())
            .append("seedCompany", getSeedCompany())
            .append("productionTime", getProductionTime())
            .append("seedPrice", getSeedPrice())
            .append("priceUnit", getPriceUnit())
            .append("varietyDescription", getVarietyDescription())
            .append("remark", getRemark())
            .append("createdAt", getCreatedAt())
            .append("createdBy", getCreatedBy())
            .append("updatedAt", getUpdatedAt())
            .append("updatedBy", getUpdatedBy())
            .toString();
    }
}
