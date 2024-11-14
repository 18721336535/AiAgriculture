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
import com.aiAgriculture.manage.domain.AgrCropManager;
import com.aiAgriculture.manage.service.IAgrCropManagerService;
import com.aiAgriculture.common.utils.poi.ExcelUtil;
import com.aiAgriculture.common.core.page.TableDataInfo;

/**
 * 人工管理Controller
 * 
 * @author aiagr
 * @date 2024-11-09
 */
@RestController
@RequestMapping("/manage/pmanager")
public class AgrCropManagerController extends BaseController
{
    @Autowired
    private IAgrCropManagerService agrCropManagerService;

    /**
     * 查询人工管理列表
     */
    @PreAuthorize("@ss.hasPermi('manage:pmanager:list')")
    @GetMapping("/list")
    public TableDataInfo list(AgrCropManager agrCropManager)
    {
        startPage();
        List<AgrCropManager> list = agrCropManagerService.selectAgrCropManagerList(agrCropManager);
        return getDataTable(list);
    }

    /**
     * 导出人工管理列表
     */
    @PreAuthorize("@ss.hasPermi('manage:pmanager:export')")
    @Log(title = "人工管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AgrCropManager agrCropManager)
    {
        List<AgrCropManager> list = agrCropManagerService.selectAgrCropManagerList(agrCropManager);
        ExcelUtil<AgrCropManager> util = new ExcelUtil<AgrCropManager>(AgrCropManager.class);
        util.exportExcel(response, list, "人工管理数据");
    }

    /**
     * 获取人工管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:pmanager:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(agrCropManagerService.selectAgrCropManagerById(id));
    }

    /**
     * 新增人工管理
     */
    @PreAuthorize("@ss.hasPermi('manage:pmanager:add')")
    @Log(title = "人工管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AgrCropManager agrCropManager)
    {
        return toAjax(agrCropManagerService.insertAgrCropManager(agrCropManager));
    }

    /**
     * 修改人工管理
     */
    @PreAuthorize("@ss.hasPermi('manage:pmanager:edit')")
    @Log(title = "人工管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AgrCropManager agrCropManager)
    {
        return toAjax(agrCropManagerService.updateAgrCropManager(agrCropManager));
    }

    /**
     * 删除人工管理
     */
    @PreAuthorize("@ss.hasPermi('manage:pmanager:remove')")
    @Log(title = "人工管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(agrCropManagerService.deleteAgrCropManagerByIds(ids));
    }
}
