package com.aiAgriculture.manage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.aiAgriculture.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.aiAgriculture.manage.domain.AgrEquipmentManagement;
import com.aiAgriculture.manage.mapper.AgrEquipmentGroupMapper;
import com.aiAgriculture.manage.domain.AgrEquipmentGroup;
import com.aiAgriculture.manage.service.IAgrEquipmentGroupService;

/**
 * 设备组管理Service业务层处理
 * 
 * @author aiagr
 * @date 2024-11-14
 */
@Service
public class AgrEquipmentGroupServiceImpl implements IAgrEquipmentGroupService 
{
    @Autowired
    private AgrEquipmentGroupMapper agrEquipmentGroupMapper;

    /**
     * 查询设备组管理
     * 
     * @param id 设备组管理主键
     * @return 设备组管理
     */
    @Override
    public AgrEquipmentGroup selectAgrEquipmentGroupById(Long id)
    {
        return agrEquipmentGroupMapper.selectAgrEquipmentGroupById(id);
    }

    /**
     * 查询设备组管理列表
     * 
     * @param agrEquipmentGroup 设备组管理
     * @return 设备组管理
     */
    @Override
    public List<AgrEquipmentGroup> selectAgrEquipmentGroupList(AgrEquipmentGroup agrEquipmentGroup)
    {
        return agrEquipmentGroupMapper.selectAgrEquipmentGroupList(agrEquipmentGroup);
    }

    /**
     * 新增设备组管理
     * 
     * @param agrEquipmentGroup 设备组管理
     * @return 结果
     */
    @Transactional
    @Override
    public int insertAgrEquipmentGroup(AgrEquipmentGroup agrEquipmentGroup)
    {
        int rows = agrEquipmentGroupMapper.insertAgrEquipmentGroup(agrEquipmentGroup);
        insertAgrEquipmentManagement(agrEquipmentGroup);
        return rows;
    }

    /**
     * 修改设备组管理
     * 
     * @param agrEquipmentGroup 设备组管理
     * @return 结果
     */
    @Transactional
    @Override
    public int updateAgrEquipmentGroup(AgrEquipmentGroup agrEquipmentGroup)
    {
//        agrEquipmentGroupMapper.deleteAgrEquipmentManagementByEquipmentCode(agrEquipmentGroup.getEquipmentCode());
//        insertAgrEquipmentManagement(agrEquipmentGroup);
        return agrEquipmentGroupMapper.updateAgrEquipmentGroup(agrEquipmentGroup);
    }

    /**
     * 批量删除设备组管理
     * 
     * @param ids 需要删除的设备组管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteAgrEquipmentGroupByIds(Long[] ids)
    {
        agrEquipmentGroupMapper.deleteAgrEquipmentManagementByEquipmentCodes(ids);
        return agrEquipmentGroupMapper.deleteAgrEquipmentGroupByIds(ids);
    }

    /**
     * 删除设备组管理信息
     * 
     * @param id 设备组管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteAgrEquipmentGroupById(Long id)
    {
//        agrEquipmentGroupMapper.deleteAgrEquipmentManagementByEquipmentCode(id);
        return agrEquipmentGroupMapper.deleteAgrEquipmentGroupById(id);
    }

    /**
     * 新增设备管理信息
     * 
     * @param agrEquipmentGroup 设备组管理对象
     */
    public void insertAgrEquipmentManagement(AgrEquipmentGroup agrEquipmentGroup)
    {
        List<AgrEquipmentManagement> agrEquipmentManagementList = agrEquipmentGroup.getAgrEquipmentManagementList();
        if (StringUtils.isNotNull(agrEquipmentManagementList))
        {
            List<AgrEquipmentGroup> list = new ArrayList<>();
            for (AgrEquipmentManagement agrEquipmentManagement : agrEquipmentManagementList)
            {
                AgrEquipmentGroup agrEquipmentGroupCopy = new AgrEquipmentGroup();
                agrEquipmentGroupCopy.setId(agrEquipmentGroup.getId());
                agrEquipmentGroupCopy.setGroupCode(agrEquipmentGroup.getGroupCode());
                agrEquipmentGroupCopy.setGroupName(agrEquipmentGroup.getGroupName());
                agrEquipmentGroupCopy.setEquipmentCode(agrEquipmentManagement.getEquipmentCode());
                agrEquipmentGroupCopy.setRemark(agrEquipmentManagement.getRemark());

                list.add(agrEquipmentGroupCopy);
            }
            if (list.size() > 0)
            {
                agrEquipmentGroupMapper.batchAgrEquipmentManagement(list);
            }
        }
    }
}
