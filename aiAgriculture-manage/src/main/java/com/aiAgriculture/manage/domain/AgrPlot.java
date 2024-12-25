package com.aiAgriculture.manage.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aiAgriculture.common.annotation.Excel;
import com.aiAgriculture.common.core.domain.BaseEntity;

/**
 * 地块管理对象 agr_plot
 * 
 * @author aiagr
 * @date 2024-12-09
 */
public class AgrPlot extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 自增主键 */
    @Excel(name = "自增主键")
    private Long id;

    /** 地块编号 */
    @Excel(name = "地块编号")
    private String plotCode;

    /** 地块面积 */
    @Excel(name = "地块面积")
    private String plotArea;

    /** 地块名称 */
    @Excel(name = "地块名称")
    private String plotName;

    /** 地块地址 */
    @Excel(name = "地块地址")
    private String plotAddress;

    /** 地形地势 */
    @Excel(name = "地形地势")
    private String terrain;

    /** 土壤类型 */
    @Excel(name = "土壤类型")
    private String soilType;

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
    public void setPlotCode(String plotCode) 
    {
        this.plotCode = plotCode;
    }

    public String getPlotCode() 
    {
        return plotCode;
    }
    public void setPlotArea(String plotArea) 
    {
        this.plotArea = plotArea;
    }

    public String getPlotArea() 
    {
        return plotArea;
    }
    public void setPlotName(String plotName) 
    {
        this.plotName = plotName;
    }

    public String getPlotName() 
    {
        return plotName;
    }
    public void setPlotAddress(String plotAddress) 
    {
        this.plotAddress = plotAddress;
    }

    public String getPlotAddress() 
    {
        return plotAddress;
    }
    public void setTerrain(String terrain) 
    {
        this.terrain = terrain;
    }

    public String getTerrain() 
    {
        return terrain;
    }
    public void setSoilType(String soilType) 
    {
        this.soilType = soilType;
    }

    public String getSoilType() 
    {
        return soilType;
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
            .append("plotCode", getPlotCode())
            .append("plotArea", getPlotArea())
            .append("plotName", getPlotName())
            .append("plotAddress", getPlotAddress())
            .append("terrain", getTerrain())
            .append("soilType", getSoilType())
            .append("remark", getRemark())
            .append("createdAt", getCreatedAt())
            .append("createdBy", getCreatedBy())
            .append("updatedAt", getUpdatedAt())
            .append("updatedBy", getUpdatedBy())
            .toString();
    }
}
