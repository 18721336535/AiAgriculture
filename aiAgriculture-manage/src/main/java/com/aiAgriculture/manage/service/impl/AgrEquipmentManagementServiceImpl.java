package com.aiAgriculture.manage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aiAgriculture.manage.mapper.AgrEquipmentManagementMapper;
import com.aiAgriculture.manage.domain.AgrEquipmentManagement;
import com.aiAgriculture.manage.service.IAgrEquipmentManagementService;

/**
 * 设备管理Service业务层处理
 * 
 * @author aiagr
 * @date 2024-11-14
 */
@Service
public class AgrEquipmentManagementServiceImpl implements IAgrEquipmentManagementService 
{
    @Autowired
    private AgrEquipmentManagementMapper agrEquipmentManagementMapper;

    /**
     * 查询设备管理
     * 
     * @param id 设备管理主键
     * @return 设备管理
     */
    @Override
    public AgrEquipmentManagement selectAgrEquipmentManagementById(Long id)
    {
        return agrEquipmentManagementMapper.selectAgrEquipmentManagementById(id);
    }

    /**
     * 查询设备管理列表
     * 
     * @param agrEquipmentManagement 设备管理
     * @return 设备管理
     */
    @Override
    public List<AgrEquipmentManagement> selectAgrEquipmentManagementList(AgrEquipmentManagement agrEquipmentManagement)
    {
        return agrEquipmentManagementMapper.selectAgrEquipmentManagementList(agrEquipmentManagement);
    }

    /**
     * 新增设备管理
     * 
     * @param agrEquipmentManagement 设备管理
     * @return 结果
     */
    @Override
    public int insertAgrEquipmentManagement(AgrEquipmentManagement agrEquipmentManagement)
    {
        return agrEquipmentManagementMapper.insertAgrEquipmentManagement(agrEquipmentManagement);
    }

    /**
     * 修改设备管理
     * 
     * @param agrEquipmentManagement 设备管理
     * @return 结果
     */
    @Override
    public int updateAgrEquipmentManagement(AgrEquipmentManagement agrEquipmentManagement)
    {
        return agrEquipmentManagementMapper.updateAgrEquipmentManagement(agrEquipmentManagement);
    }

    /**
     * 批量删除设备管理
     * 
     * @param ids 需要删除的设备管理主键
     * @return 结果
     */
    @Override
    public int deleteAgrEquipmentManagementByIds(Long[] ids)
    {
        return agrEquipmentManagementMapper.deleteAgrEquipmentManagementByIds(ids);
    }

    /**
     * 删除设备管理信息
     * 
     * @param id 设备管理主键
     * @return 结果
     */
    @Override
    public int deleteAgrEquipmentManagementById(Long id)
    {
        return agrEquipmentManagementMapper.deleteAgrEquipmentManagementById(id);
    }
}
