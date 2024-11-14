package com.aiAgriculture.manage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aiAgriculture.manage.mapper.AgrCropVarietiesMapper;
import com.aiAgriculture.manage.domain.AgrCropVarieties;
import com.aiAgriculture.manage.service.IAgrCropVarietiesService;

/**
 * 品种管理Service业务层处理
 * 
 * @author aiagr
 * @date 2024-11-09
 */
@Service
public class AgrCropVarietiesServiceImpl implements IAgrCropVarietiesService 
{
    @Autowired
    private AgrCropVarietiesMapper agrCropVarietiesMapper;

    /**
     * 查询品种管理
     * 
     * @param id 品种管理主键
     * @return 品种管理
     */
    @Override
    public AgrCropVarieties selectAgrCropVarietiesById(Long id)
    {
        return agrCropVarietiesMapper.selectAgrCropVarietiesById(id);
    }

    /**
     * 查询品种管理列表
     * 
     * @param agrCropVarieties 品种管理
     * @return 品种管理
     */
    @Override
    public List<AgrCropVarieties> selectAgrCropVarietiesList(AgrCropVarieties agrCropVarieties)
    {
        return agrCropVarietiesMapper.selectAgrCropVarietiesList(agrCropVarieties);
    }

    /**
     * 新增品种管理
     * 
     * @param agrCropVarieties 品种管理
     * @return 结果
     */
    @Override
    public int insertAgrCropVarieties(AgrCropVarieties agrCropVarieties)
    {
        return agrCropVarietiesMapper.insertAgrCropVarieties(agrCropVarieties);
    }

    /**
     * 修改品种管理
     * 
     * @param agrCropVarieties 品种管理
     * @return 结果
     */
    @Override
    public int updateAgrCropVarieties(AgrCropVarieties agrCropVarieties)
    {
        return agrCropVarietiesMapper.updateAgrCropVarieties(agrCropVarieties);
    }

    /**
     * 批量删除品种管理
     * 
     * @param ids 需要删除的品种管理主键
     * @return 结果
     */
    @Override
    public int deleteAgrCropVarietiesByIds(Long[] ids)
    {
        return agrCropVarietiesMapper.deleteAgrCropVarietiesByIds(ids);
    }

    /**
     * 删除品种管理信息
     * 
     * @param id 品种管理主键
     * @return 结果
     */
    @Override
    public int deleteAgrCropVarietiesById(Long id)
    {
        return agrCropVarietiesMapper.deleteAgrCropVarietiesById(id);
    }
}
