package com.aiAgriculture.manage.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aiAgriculture.common.annotation.Log;
import com.aiAgriculture.common.core.controller.BaseController;
import com.aiAgriculture.common.core.domain.AjaxResult;
import com.aiAgriculture.common.enums.BusinessType;
import com.aiAgriculture.manage.domain.AgrPlot;
import com.aiAgriculture.manage.service.IAgrPlotService;
import com.aiAgriculture.common.utils.poi.ExcelUtil;
import com.aiAgriculture.common.core.page.TableDataInfo;

/**
 * 地块管理Controller
 * 
 * @author aiagr
 * @date 2024-11-09
 */
@RestController
@RequestMapping("/manage/plot")
public class AgrPlotController extends BaseController
{
    @Autowired
    private IAgrPlotService agrPlotService;

    /**
     * 查询地块管理列表
     */
    @PreAuthorize("@ss.hasPermi('manage:plot:list')")
    @GetMapping("/list")
    public TableDataInfo list(AgrPlot agrPlot)
    {
        startPage();
        List<AgrPlot> list = agrPlotService.selectAgrPlotList(agrPlot);
        return getDataTable(list);
    }

    /**
     * 导出地块管理列表
     */
    @PreAuthorize("@ss.hasPermi('manage:plot:export')")
    @Log(title = "地块管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AgrPlot agrPlot)
    {
        List<AgrPlot> list = agrPlotService.selectAgrPlotList(agrPlot);
        ExcelUtil<AgrPlot> util = new ExcelUtil<AgrPlot>(AgrPlot.class);
        util.exportExcel(response, list, "地块管理数据");
    }

    /**
     * 获取地块管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:plot:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(agrPlotService.selectAgrPlotById(id));
    }

    /**
     * 新增地块管理
     */
    @PreAuthorize("@ss.hasPermi('manage:plot:add')")
    @Log(title = "地块管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AgrPlot agrPlot)
    {
        return toAjax(agrPlotService.insertAgrPlot(agrPlot));
    }

    /**
     * 修改地块管理
     */
    @PreAuthorize("@ss.hasPermi('manage:plot:edit')")
    @Log(title = "地块管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AgrPlot agrPlot)
    {
        return toAjax(agrPlotService.updateAgrPlot(agrPlot));
    }

    /**
     * 删除地块管理
     */
    @PreAuthorize("@ss.hasPermi('manage:plot:remove')")
    @Log(title = "地块管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(agrPlotService.deleteAgrPlotByIds(ids));
    }
}
