package com.aiAgriculture.manage.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aiAgriculture.common.annotation.Excel;
import com.aiAgriculture.common.core.domain.BaseEntity;

/**
 * 设备管理对象 agr_equipment_management
 * 
 * @author aiagr
 * @date 2024-11-14
 */
public class AgrEquipmentManagement extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 自增主键 */
    @Excel(name = "自增主键")
    private Long id;

    /** 设备编号 */
    @Excel(name = "设备编号")
    private String equipmentCode;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String equipmentName;

    /** 设备型号 */
    @Excel(name = "设备型号")
    private String equipmentModel;

    /** 设备用途 */
    @Excel(name = "设备用途")
    private String equipmentPurpose;

    /** 设备价格 */
    @Excel(name = "设备价格")
    private BigDecimal equipmentPrice;

    /** 生产公司 */
    @Excel(name = "生产公司")
    private String equipmentCompany;

    /** 当前状态 */
    @Excel(name = "当前状态")
    private String equipmentStatus;

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
    public void setEquipmentCode(String equipmentCode) 
    {
        this.equipmentCode = equipmentCode;
    }

    public String getEquipmentCode() 
    {
        return equipmentCode;
    }
    public void setEquipmentName(String equipmentName) 
    {
        this.equipmentName = equipmentName;
    }

    public String getEquipmentName() 
    {
        return equipmentName;
    }
    public void setEquipmentModel(String equipmentModel) 
    {
        this.equipmentModel = equipmentModel;
    }

    public String getEquipmentModel() 
    {
        return equipmentModel;
    }
    public void setEquipmentPurpose(String equipmentPurpose) 
    {
        this.equipmentPurpose = equipmentPurpose;
    }

    public String getEquipmentPurpose() 
    {
        return equipmentPurpose;
    }
    public void setEquipmentPrice(BigDecimal equipmentPrice) 
    {
        this.equipmentPrice = equipmentPrice;
    }

    public BigDecimal getEquipmentPrice() 
    {
        return equipmentPrice;
    }
    public void setEquipmentCompany(String equipmentCompany) 
    {
        this.equipmentCompany = equipmentCompany;
    }

    public String getEquipmentCompany() 
    {
        return equipmentCompany;
    }
    public void setEquipmentStatus(String equipmentStatus) 
    {
        this.equipmentStatus = equipmentStatus;
    }

    public String getEquipmentStatus() 
    {
        return equipmentStatus;
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
            .append("equipmentCode", getEquipmentCode())
            .append("equipmentName", getEquipmentName())
            .append("equipmentModel", getEquipmentModel())
            .append("equipmentPurpose", getEquipmentPurpose())
            .append("equipmentPrice", getEquipmentPrice())
            .append("equipmentCompany", getEquipmentCompany())
            .append("equipmentStatus", getEquipmentStatus())
            .append("remark", getRemark())
            .append("createdAt", getCreatedAt())
            .append("createdBy", getCreatedBy())
            .append("updatedAt", getUpdatedAt())
            .append("updatedBy", getUpdatedBy())
            .toString();
    }
}
