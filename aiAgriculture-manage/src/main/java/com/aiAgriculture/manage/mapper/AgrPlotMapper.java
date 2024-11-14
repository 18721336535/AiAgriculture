package com.aiAgriculture.manage.mapper;

import java.util.List;
import com.aiAgriculture.manage.domain.AgrPlot;

/**
 * 地块管理Mapper接口
 * 
 * @author aiagr
 * @date 2024-11-09
 */
public interface AgrPlotMapper 
{
    /**
     * 查询地块管理
     * 
     * @param id 地块管理主键
     * @return 地块管理
     */
    public AgrPlot selectAgrPlotById(Long id);

    /**
     * 查询地块管理列表
     * 
     * @param agrPlot 地块管理
     * @return 地块管理集合
     */
    public List<AgrPlot> selectAgrPlotList(AgrPlot agrPlot);

    /**
     * 新增地块管理
     * 
     * @param agrPlot 地块管理
     * @return 结果
     */
    public int insertAgrPlot(AgrPlot agrPlot);

    /**
     * 修改地块管理
     * 
     * @param agrPlot 地块管理
     * @return 结果
     */
    public int updateAgrPlot(AgrPlot agrPlot);

    /**
     * 删除地块管理
     * 
     * @param id 地块管理主键
     * @return 结果
     */
    public int deleteAgrPlotById(Long id);

    /**
     * 批量删除地块管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAgrPlotByIds(Long[] ids);
}
