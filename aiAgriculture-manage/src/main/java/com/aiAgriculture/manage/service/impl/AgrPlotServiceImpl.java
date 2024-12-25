package com.aiAgriculture.manage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aiAgriculture.manage.mapper.AgrPlotMapper;
import com.aiAgriculture.manage.domain.AgrPlot;
import com.aiAgriculture.manage.service.IAgrPlotService;

/**
 * 地块管理Service业务层处理
 * 
 * @author aiagr
 * @date 2024-12-09
 */
@Service
public class AgrPlotServiceImpl implements IAgrPlotService 
{
    @Autowired
    private AgrPlotMapper agrPlotMapper;

    /**
     * 查询地块管理
     * 
     * @param id 地块管理主键
     * @return 地块管理
     */
    @Override
    public AgrPlot selectAgrPlotById(Long id)
    {
        return agrPlotMapper.selectAgrPlotById(id);
    }

    /**
     * 查询地块管理列表
     * 
     * @param agrPlot 地块管理
     * @return 地块管理
     */
    @Override
    public List<AgrPlot> selectAgrPlotList(AgrPlot agrPlot)
    {
        return agrPlotMapper.selectAgrPlotList(agrPlot);
    }

    /**
     * 新增地块管理
     * 
     * @param agrPlot 地块管理
     * @return 结果
     */
    @Override
    public int insertAgrPlot(AgrPlot agrPlot)
    {
        return agrPlotMapper.insertAgrPlot(agrPlot);
    }

    /**
     * 修改地块管理
     * 
     * @param agrPlot 地块管理
     * @return 结果
     */
    @Override
    public int updateAgrPlot(AgrPlot agrPlot)
    {
        return agrPlotMapper.updateAgrPlot(agrPlot);
    }

    /**
     * 批量删除地块管理
     * 
     * @param ids 需要删除的地块管理主键
     * @return 结果
     */
    @Override
    public int deleteAgrPlotByIds(Long[] ids)
    {
        return agrPlotMapper.deleteAgrPlotByIds(ids);
    }

    /**
     * 删除地块管理信息
     * 
     * @param id 地块管理主键
     * @return 结果
     */
    @Override
    public int deleteAgrPlotById(Long id)
    {
        return agrPlotMapper.deleteAgrPlotById(id);
    }
}
