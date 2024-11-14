package com.aiAgriculture.manage.domain;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aiAgriculture.common.annotation.Excel;
import com.aiAgriculture.common.core.domain.BaseEntity;

/**
 * 设备组管理对象 agr_equipment_group
 * 
 * @author aiagr
 * @date 2024-11-14
 */
public class AgrEquipmentGroup extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 自增主键 */
    @Excel(name = "自增主键")
    private Long id;

    /** 设备组编号 */
    @Excel(name = "设备组编号")
    private String groupCode;

    /** 设备组名称 */
    @Excel(name = "设备组名称")
    private String groupName;

    /** 设备编号 */
    @Excel(name = "设备编号")
    private String equipmentCode;

    /** 设备管理信息 */
    private List<AgrEquipmentManagement> agrEquipmentManagementList;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setGroupCode(String groupCode) 
    {
        this.groupCode = groupCode;
    }

    public String getGroupCode() 
    {
        return groupCode;
    }
    public void setGroupName(String groupName) 
    {
        this.groupName = groupName;
    }

    public String getGroupName() 
    {
        return groupName;
    }
    public void setEquipmentCode(String equipmentCode) 
    {
        this.equipmentCode = equipmentCode;
    }

    public String getEquipmentCode() 
    {
        return equipmentCode;
    }

    public List<AgrEquipmentManagement> getAgrEquipmentManagementList()
    {
        return agrEquipmentManagementList;
    }

    public void setAgrEquipmentManagementList(List<AgrEquipmentManagement> agrEquipmentManagementList)
    {
        this.agrEquipmentManagementList = agrEquipmentManagementList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("groupCode", getGroupCode())
            .append("groupName", getGroupName())
            .append("equipmentCode", getEquipmentCode())
            .append("remark", getRemark())
            .append("agrEquipmentManagementList", getAgrEquipmentManagementList())
            .toString();
    }
}
