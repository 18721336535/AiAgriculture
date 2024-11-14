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
import com.aiAgriculture.manage.domain.AgrPlanting;
import com.aiAgriculture.manage.service.IAgrPlantingService;
import com.aiAgriculture.common.utils.poi.ExcelUtil;
import com.aiAgriculture.common.core.page.TableDataInfo;

/**
 * 种植管理Controller
 * 
 * @author aiagr
 * @date 2024-11-09
 */
@RestController
@RequestMapping("/manage/planting")
public class AgrPlantingController extends BaseController
{
    @Autowired
    private IAgrPlantingService agrPlantingService;

    /**
     * 查询种植管理列表
     */
    @PreAuthorize("@ss.hasPermi('manage:planting:list')")
    @GetMapping("/list")
    public TableDataInfo list(AgrPlanting agrPlanting)
    {
        startPage();
        List<AgrPlanting> list = agrPlantingService.selectAgrPlantingList(agrPlanting);
        return getDataTable(list);
    }

    /**
     * 导出种植管理列表
     */
    @PreAuthorize("@ss.hasPermi('manage:planting:export')")
    @Log(title = "种植管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AgrPlanting agrPlanting)
    {
        List<AgrPlanting> list = agrPlantingService.selectAgrPlantingList(agrPlanting);
        ExcelUtil<AgrPlanting> util = new ExcelUtil<AgrPlanting>(AgrPlanting.class);
        util.exportExcel(response, list, "种植管理数据");
    }

    /**
     * 获取种植管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:planting:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(agrPlantingService.selectAgrPlantingById(id));
    }

    /**
     * 新增种植管理
     */
    @PreAuthorize("@ss.hasPermi('manage:planting:add')")
    @Log(title = "种植管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AgrPlanting agrPlanting)
    {
        return toAjax(agrPlantingService.insertAgrPlanting(agrPlanting));
    }

    /**
     * 修改种植管理
     */
    @PreAuthorize("@ss.hasPermi('manage:planting:edit')")
    @Log(title = "种植管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AgrPlanting agrPlanting)
    {
        return toAjax(agrPlantingService.updateAgrPlanting(agrPlanting));
    }

    /**
     * 删除种植管理
     */
    @PreAuthorize("@ss.hasPermi('manage:planting:remove')")
    @Log(title = "种植管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(agrPlantingService.deleteAgrPlantingByIds(ids));
    }
}
