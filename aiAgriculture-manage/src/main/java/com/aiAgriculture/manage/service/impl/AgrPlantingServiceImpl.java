package com.aiAgriculture.manage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aiAgriculture.manage.mapper.AgrPlantingMapper;
import com.aiAgriculture.manage.domain.AgrPlanting;
import com.aiAgriculture.manage.service.IAgrPlantingService;

/**
 * 种植管理Service业务层处理
 * 
 * @author aiagr
 * @date 2024-11-09
 */
@Service
public class AgrPlantingServiceImpl implements IAgrPlantingService 
{
    @Autowired
    private AgrPlantingMapper agrPlantingMapper;

    /**
     * 查询种植管理
     * 
     * @param id 种植管理主键
     * @return 种植管理
     */
    @Override
    public AgrPlanting selectAgrPlantingById(Long id)
    {
        return agrPlantingMapper.selectAgrPlantingById(id);
    }

    /**
     * 查询种植管理列表
     * 
     * @param agrPlanting 种植管理
     * @return 种植管理
     */
    @Override
    public List<AgrPlanting> selectAgrPlantingList(AgrPlanting agrPlanting)
    {
        return agrPlantingMapper.selectAgrPlantingList(agrPlanting);
    }

    /**
     * 新增种植管理
     * 
     * @param agrPlanting 种植管理
     * @return 结果
     */
    @Override
    public int insertAgrPlanting(AgrPlanting agrPlanting)
    {
        return agrPlantingMapper.insertAgrPlanting(agrPlanting);
    }

    /**
     * 修改种植管理
     * 
     * @param agrPlanting 种植管理
     * @return 结果
     */
    @Override
    public int updateAgrPlanting(AgrPlanting agrPlanting)
    {
        return agrPlantingMapper.updateAgrPlanting(agrPlanting);
    }

    /**
     * 批量删除种植管理
     * 
     * @param ids 需要删除的种植管理主键
     * @return 结果
     */
    @Override
    public int deleteAgrPlantingByIds(Long[] ids)
    {
        return agrPlantingMapper.deleteAgrPlantingByIds(ids);
    }

    /**
     * 删除种植管理信息
     * 
     * @param id 种植管理主键
     * @return 结果
     */
    @Override
    public int deleteAgrPlantingById(Long id)
    {
        return agrPlantingMapper.deleteAgrPlantingById(id);
    }
}
