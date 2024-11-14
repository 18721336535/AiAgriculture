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
import com.aiAgriculture.manage.domain.AgrCropVarieties;
import com.aiAgriculture.manage.service.IAgrCropVarietiesService;
import com.aiAgriculture.common.utils.poi.ExcelUtil;
import com.aiAgriculture.common.core.page.TableDataInfo;

/**
 * 品种管理Controller
 * 
 * @author aiagr
 * @date 2024-11-09
 */
@RestController
@RequestMapping("/manage/varieties")
public class AgrCropVarietiesController extends BaseController
{
    @Autowired
    private IAgrCropVarietiesService agrCropVarietiesService;

    /**
     * 查询品种管理列表
     */
    @PreAuthorize("@ss.hasPermi('manage:varieties:list')")
    @GetMapping("/list")
    public TableDataInfo list(AgrCropVarieties agrCropVarieties)
    {
        startPage();
        List<AgrCropVarieties> list = agrCropVarietiesService.selectAgrCropVarietiesList(agrCropVarieties);
        return getDataTable(list);
    }

    /**
     * 导出品种管理列表
     */
    @PreAuthorize("@ss.hasPermi('manage:varieties:export')")
    @Log(title = "品种管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AgrCropVarieties agrCropVarieties)
    {
        List<AgrCropVarieties> list = agrCropVarietiesService.selectAgrCropVarietiesList(agrCropVarieties);
        ExcelUtil<AgrCropVarieties> util = new ExcelUtil<AgrCropVarieties>(AgrCropVarieties.class);
        util.exportExcel(response, list, "品种管理数据");
    }

    /**
     * 获取品种管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:varieties:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(agrCropVarietiesService.selectAgrCropVarietiesById(id));
    }

    /**
     * 新增品种管理
     */
    @PreAuthorize("@ss.hasPermi('manage:varieties:add')")
    @Log(title = "品种管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AgrCropVarieties agrCropVarieties)
    {
        return toAjax(agrCropVarietiesService.insertAgrCropVarieties(agrCropVarieties));
    }

    /**
     * 修改品种管理
     */
    @PreAuthorize("@ss.hasPermi('manage:varieties:edit')")
    @Log(title = "品种管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AgrCropVarieties agrCropVarieties)
    {
        return toAjax(agrCropVarietiesService.updateAgrCropVarieties(agrCropVarieties));
    }

    /**
     * 删除品种管理
     */
    @PreAuthorize("@ss.hasPermi('manage:varieties:remove')")
    @Log(title = "品种管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(agrCropVarietiesService.deleteAgrCropVarietiesByIds(ids));
    }
}
