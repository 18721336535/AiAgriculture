package com.aiAgriculture.manage.mapper;

import java.util.List;
import com.aiAgriculture.manage.domain.AgrCropVarieties;

/**
 * 品种管理Mapper接口
 * 
 * @author aiagr
 * @date 2024-11-09
 */
public interface AgrCropVarietiesMapper 
{
    /**
     * 查询品种管理
     * 
     * @param id 品种管理主键
     * @return 品种管理
     */
    public AgrCropVarieties selectAgrCropVarietiesById(Long id);

    /**
     * 查询品种管理列表
     * 
     * @param agrCropVarieties 品种管理
     * @return 品种管理集合
     */
    public List<AgrCropVarieties> selectAgrCropVarietiesList(AgrCropVarieties agrCropVarieties);

    /**
     * 新增品种管理
     * 
     * @param agrCropVarieties 品种管理
     * @return 结果
     */
    public int insertAgrCropVarieties(AgrCropVarieties agrCropVarieties);

    /**
     * 修改品种管理
     * 
     * @param agrCropVarieties 品种管理
     * @return 结果
     */
    public int updateAgrCropVarieties(AgrCropVarieties agrCropVarieties);

    /**
     * 删除品种管理
     * 
     * @param id 品种管理主键
     * @return 结果
     */
    public int deleteAgrCropVarietiesById(Long id);

    /**
     * 批量删除品种管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAgrCropVarietiesByIds(Long[] ids);
}
