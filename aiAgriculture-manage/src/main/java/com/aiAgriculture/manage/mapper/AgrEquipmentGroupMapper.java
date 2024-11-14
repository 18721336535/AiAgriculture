package com.aiAgriculture.manage.mapper;

import java.util.List;
import com.aiAgriculture.manage.domain.AgrEquipmentGroup;
import com.aiAgriculture.manage.domain.AgrEquipmentManagement;

/**
 * 设备组管理Mapper接口
 * 
 * @author aiagr
 * @date 2024-11-14
 */
public interface AgrEquipmentGroupMapper 
{
    /**
     * 查询设备组管理
     * 
     * @param id 设备组管理主键
     * @return 设备组管理
     */
    public AgrEquipmentGroup selectAgrEquipmentGroupById(Long id);

    /**
     * 查询设备组管理列表
     * 
     * @param agrEquipmentGroup 设备组管理
     * @return 设备组管理集合
     */
    public List<AgrEquipmentGroup> selectAgrEquipmentGroupList(AgrEquipmentGroup agrEquipmentGroup);

    /**
     * 新增设备组管理
     * 
     * @param agrEquipmentGroup 设备组管理
     * @return 结果
     */
    public int insertAgrEquipmentGroup(AgrEquipmentGroup agrEquipmentGroup);

    /**
     * 修改设备组管理
     * 
     * @param agrEquipmentGroup 设备组管理
     * @return 结果
     */
    public int updateAgrEquipmentGroup(AgrEquipmentGroup agrEquipmentGroup);

    /**
     * 删除设备组管理
     * 
     * @param id 设备组管理主键
     * @return 结果
     */
    public int deleteAgrEquipmentGroupById(Long id);

    /**
     * 批量删除设备组管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAgrEquipmentGroupByIds(Long[] ids);

    /**
     * 批量删除设备管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAgrEquipmentManagementByEquipmentCodes(Long[] ids);
    
    /**
     * 批量新增设备管理
     * 
     * @param agrEquipmentManagementList 设备管理列表
     * @return 结果
     */
    public int batchAgrEquipmentManagement(List<AgrEquipmentGroup> agrEquipmentManagementList);
    

    /**
     * 通过设备组管理主键删除设备管理信息
     * 
     * @param id 设备组管理ID
     * @return 结果
     */
    public int deleteAgrEquipmentManagementByEquipmentCode(String id);
}
