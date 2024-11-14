package com.aiAgriculture.manage.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aiAgriculture.common.annotation.Excel;
import com.aiAgriculture.common.core.domain.BaseEntity;

/**
 * 种植管理对象 agr_planting
 * 
 * @author aiagr
 * @date 2024-11-09
 */
public class AgrPlanting extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 自增主键 */
    @Excel(name = "自增主键")
    private Long id;

    /** 种植编号 */
    @Excel(name = "种植编号")
    private String plantingCode;

    /** 品种编号 */
    @Excel(name = "品种编号")
    private String varietyCode;

    /** 品种名称 */
    @Excel(name = "品种名称")
    private String varietyName;

    /** 地块编号 */
    @Excel(name = "地块编号")
    private String plotCode;

    /** 地块名 */
    @Excel(name = "地块名")
    private String plotName;

    /** 地块面积 */
    @Excel(name = "地块面积")
    private BigDecimal plotArea;

    /** 设备组 */
    @Excel(name = "设备组")
    private String groupCode;

    /** 管理员 */
    @Excel(name = "管理员")
    private String managerCode;

    /** 当前状态 */
    @Excel(name = "当前状态")
    private String currentStatus;

    /** 产量kg */
    @Excel(name = "产量kg")
    private Long productionAmount;

    /** 创建时间 */
    private Date createdAt;

    /** 创建人 */
    private String createdBy;

    /** 更新时间 */
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
    public void setPlantingCode(String plantingCode) 
    {
        this.plantingCode = plantingCode;
    }

    public String getPlantingCode() 
    {
        return plantingCode;
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
    public void setPlotCode(String plotCode) 
    {
        this.plotCode = plotCode;
    }

    public String getPlotCode() 
    {
        return plotCode;
    }
    public void setPlotName(String plotName) 
    {
        this.plotName = plotName;
    }

    public String getPlotName() 
    {
        return plotName;
    }
    public void setPlotArea(BigDecimal plotArea) 
    {
        this.plotArea = plotArea;
    }

    public BigDecimal getPlotArea() 
    {
        return plotArea;
    }
    public void setGroupCode(String groupCode) 
    {
        this.groupCode = groupCode;
    }

    public String getGroupCode() 
    {
        return groupCode;
    }
    public void setManagerCode(String managerCode) 
    {
        this.managerCode = managerCode;
    }

    public String getManagerCode() 
    {
        return managerCode;
    }
    public void setCurrentStatus(String currentStatus) 
    {
        this.currentStatus = currentStatus;
    }

    public String getCurrentStatus() 
    {
        return currentStatus;
    }
    public void setProductionAmount(Long productionAmount) 
    {
        this.productionAmount = productionAmount;
    }

    public Long getProductionAmount() 
    {
        return productionAmount;
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
            .append("plantingCode", getPlantingCode())
            .append("varietyCode", getVarietyCode())
            .append("varietyName", getVarietyName())
            .append("plotCode", getPlotCode())
            .append("plotName", getPlotName())
            .append("plotArea", getPlotArea())
            .append("groupCode", getGroupCode())
            .append("managerCode", getManagerCode())
            .append("currentStatus", getCurrentStatus())
            .append("productionAmount", getProductionAmount())
            .append("remark", getRemark())
            .append("createdAt", getCreatedAt())
            .append("createdBy", getCreatedBy())
            .append("updatedAt", getUpdatedAt())
            .append("updatedBy", getUpdatedBy())
            .toString();
    }
}
