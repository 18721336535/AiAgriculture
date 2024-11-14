package com.aiAgriculture.manage.service;

import java.util.List;
import com.aiAgriculture.manage.domain.AgrEquipmentGroup;

/**
 * 设备组管理Service接口
 * 
 * @author aiagr
 * @date 2024-11-14
 */
public interface IAgrEquipmentGroupService 
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
     * 批量删除设备组管理
     * 
     * @param ids 需要删除的设备组管理主键集合
     * @return 结果
     */
    public int deleteAgrEquipmentGroupByIds(Long[] ids);

    /**
     * 删除设备组管理信息
     * 
     * @param id 设备组管理主键
     * @return 结果
     */
    public int deleteAgrEquipmentGroupById(Long id);
}
