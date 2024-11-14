package com.aiAgriculture.manage.service;

import java.util.List;
import com.aiAgriculture.manage.domain.AgrPlanting;

/**
 * 种植管理Service接口
 * 
 * @author aiagr
 * @date 2024-11-09
 */
public interface IAgrPlantingService 
{
    /**
     * 查询种植管理
     * 
     * @param id 种植管理主键
     * @return 种植管理
     */
    public AgrPlanting selectAgrPlantingById(Long id);

    /**
     * 查询种植管理列表
     * 
     * @param agrPlanting 种植管理
     * @return 种植管理集合
     */
    public List<AgrPlanting> selectAgrPlantingList(AgrPlanting agrPlanting);

    /**
     * 新增种植管理
     * 
     * @param agrPlanting 种植管理
     * @return 结果
     */
    public int insertAgrPlanting(AgrPlanting agrPlanting);

    /**
     * 修改种植管理
     * 
     * @param agrPlanting 种植管理
     * @return 结果
     */
    public int updateAgrPlanting(AgrPlanting agrPlanting);

    /**
     * 批量删除种植管理
     * 
     * @param ids 需要删除的种植管理主键集合
     * @return 结果
     */
    public int deleteAgrPlantingByIds(Long[] ids);

    /**
     * 删除种植管理信息
     * 
     * @param id 种植管理主键
     * @return 结果
     */
    public int deleteAgrPlantingById(Long id);
}
