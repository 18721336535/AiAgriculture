package com.aiAgriculture.manage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aiAgriculture.manage.mapper.AgrCropManagerMapper;
import com.aiAgriculture.manage.domain.AgrCropManager;
import com.aiAgriculture.manage.service.IAgrCropManagerService;

/**
 * 人工管理Service业务层处理
 * 
 * @author aiagr
 * @date 2024-11-09
 */
@Service
public class AgrCropManagerServiceImpl implements IAgrCropManagerService 
{
    @Autowired
    private AgrCropManagerMapper agrCropManagerMapper;

    /**
     * 查询人工管理
     * 
     * @param id 人工管理主键
     * @return 人工管理
     */
    @Override
    public AgrCropManager selectAgrCropManagerById(Long id)
    {
        return agrCropManagerMapper.selectAgrCropManagerById(id);
    }

    /**
     * 查询人工管理列表
     * 
     * @param agrCropManager 人工管理
     * @return 人工管理
     */
    @Override
    public List<AgrCropManager> selectAgrCropManagerList(AgrCropManager agrCropManager)
    {
        return agrCropManagerMapper.selectAgrCropManagerList(agrCropManager);
    }

    /**
     * 新增人工管理
     * 
     * @param agrCropManager 人工管理
     * @return 结果
     */
    @Override
    public int insertAgrCropManager(AgrCropManager agrCropManager)
    {
        return agrCropManagerMapper.insertAgrCropManager(agrCropManager);
    }

    /**
     * 修改人工管理
     * 
     * @param agrCropManager 人工管理
     * @return 结果
     */
    @Override
    public int updateAgrCropManager(AgrCropManager agrCropManager)
    {
        return agrCropManagerMapper.updateAgrCropManager(agrCropManager);
    }

    /**
     * 批量删除人工管理
     * 
     * @param ids 需要删除的人工管理主键
     * @return 结果
     */
    @Override
    public int deleteAgrCropManagerByIds(Long[] ids)
    {
        return agrCropManagerMapper.deleteAgrCropManagerByIds(ids);
    }

    /**
     * 删除人工管理信息
     * 
     * @param id 人工管理主键
     * @return 结果
     */
    @Override
    public int deleteAgrCropManagerById(Long id)
    {
        return agrCropManagerMapper.deleteAgrCropManagerById(id);
    }
}
