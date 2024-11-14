package com.aiAgriculture.manage.service;

import java.util.List;
import com.aiAgriculture.manage.domain.AgrEquipmentManagement;

/**
 * 设备管理Service接口
 * 
 * @author aiagr
 * @date 2024-11-14
 */
public interface IAgrEquipmentManagementService 
{
    /**
     * 查询设备管理
     * 
     * @param id 设备管理主键
     * @return 设备管理
     */
    public AgrEquipmentManagement selectAgrEquipmentManagementById(Long id);

    /**
     * 查询设备管理列表
     * 
     * @param agrEquipmentManagement 设备管理
     * @return 设备管理集合
     */
    public List<AgrEquipmentManagement> selectAgrEquipmentManagementList(AgrEquipmentManagement agrEquipmentManagement);

    /**
     * 新增设备管理
     * 
     * @param agrEquipmentManagement 设备管理
     * @return 结果
     */
    public int insertAgrEquipmentManagement(AgrEquipmentManagement agrEquipmentManagement);

    /**
     * 修改设备管理
     * 
     * @param agrEquipmentManagement 设备管理
     * @return 结果
     */
    public int updateAgrEquipmentManagement(AgrEquipmentManagement agrEquipmentManagement);

    /**
     * 批量删除设备管理
     * 
     * @param ids 需要删除的设备管理主键集合
     * @return 结果
     */
    public int deleteAgrEquipmentManagementByIds(Long[] ids);

    /**
     * 删除设备管理信息
     * 
     * @param id 设备管理主键
     * @return 结果
     */
    public int deleteAgrEquipmentManagementById(Long id);
}
