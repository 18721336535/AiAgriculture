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
import com.aiAgriculture.manage.domain.ControlActionAudit;
import com.aiAgriculture.manage.service.IControlActionAuditService;
import com.aiAgriculture.common.utils.poi.ExcelUtil;
import com.aiAgriculture.common.core.page.TableDataInfo;

/**
 * 控制操作审计Controller
 * 
 * @author aiagri
 * @date 2024-11-14
 */
@RestController
@RequestMapping("/manage/audit")
public class ControlActionAuditController extends BaseController
{
    @Autowired
    private IControlActionAuditService controlActionAuditService;

    /**
     * 查询控制操作审计列表
     */
    @PreAuthorize("@ss.hasPermi('manage:audit:list')")
    @GetMapping("/list")
    public TableDataInfo list(ControlActionAudit controlActionAudit)
    {
        startPage();
        List<ControlActionAudit> list = controlActionAuditService.selectControlActionAuditList(controlActionAudit);
        return getDataTable(list);
    }

    /**
     * 导出控制操作审计列表
     */
    @PreAuthorize("@ss.hasPermi('manage:audit:export')")
    @Log(title = "控制操作审计", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ControlActionAudit controlActionAudit)
    {
        List<ControlActionAudit> list = controlActionAuditService.selectControlActionAuditList(controlActionAudit);
        ExcelUtil<ControlActionAudit> util = new ExcelUtil<ControlActionAudit>(ControlActionAudit.class);
        util.exportExcel(response, list, "控制操作审计数据");
    }

    /**
     * 获取控制操作审计详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:audit:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(controlActionAuditService.selectControlActionAuditById(id));
    }

    /**
     * 新增控制操作审计
     */
    @PreAuthorize("@ss.hasPermi('manage:audit:add')")
    @Log(title = "控制操作审计", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ControlActionAudit controlActionAudit)
    {
        return toAjax(controlActionAuditService.insertControlActionAudit(controlActionAudit));
    }

    /**
     * 修改控制操作审计
     */
    @PreAuthorize("@ss.hasPermi('manage:audit:edit')")
    @Log(title = "控制操作审计", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ControlActionAudit controlActionAudit)
    {
        return toAjax(controlActionAuditService.updateControlActionAudit(controlActionAudit));
    }

    /**
     * 删除控制操作审计
     */
    @PreAuthorize("@ss.hasPermi('manage:audit:remove')")
    @Log(title = "控制操作审计", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(controlActionAuditService.deleteControlActionAuditByIds(ids));
    }
}
