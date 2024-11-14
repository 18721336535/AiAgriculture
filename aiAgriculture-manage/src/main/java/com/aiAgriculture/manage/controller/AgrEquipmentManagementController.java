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
import com.aiAgriculture.manage.domain.AgrEquipmentManagement;
import com.aiAgriculture.manage.service.IAgrEquipmentManagementService;
import com.aiAgriculture.common.utils.poi.ExcelUtil;
import com.aiAgriculture.common.core.page.TableDataInfo;

/**
 * 设备管理Controller
 * 
 * @author aiagr
 * @date 2024-11-14
 */
@RestController
@RequestMapping("/manage/eqpmanagement")
public class AgrEquipmentManagementController extends BaseController
{
    @Autowired
    private IAgrEquipmentManagementService agrEquipmentManagementService;

    /**
     * 查询设备管理列表
     */
    @PreAuthorize("@ss.hasPermi('manage:eqpmanagement:list')")
    @GetMapping("/list")
    public TableDataInfo list(AgrEquipmentManagement agrEquipmentManagement)
    {
        startPage();
        List<AgrEquipmentManagement> list = agrEquipmentManagementService.selectAgrEquipmentManagementList(agrEquipmentManagement);
        return getDataTable(list);
    }

    /**
     * 导出设备管理列表
     */
    @PreAuthorize("@ss.hasPermi('manage:eqpmanagement:export')")
    @Log(title = "设备管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AgrEquipmentManagement agrEquipmentManagement)
    {
        List<AgrEquipmentManagement> list = agrEquipmentManagementService.selectAgrEquipmentManagementList(agrEquipmentManagement);
        ExcelUtil<AgrEquipmentManagement> util = new ExcelUtil<AgrEquipmentManagement>(AgrEquipmentManagement.class);
        util.exportExcel(response, list, "设备管理数据");
    }

    /**
     * 获取设备管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:eqpmanagement:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(agrEquipmentManagementService.selectAgrEquipmentManagementById(id));
    }

    /**
     * 新增设备管理
     */
    @PreAuthorize("@ss.hasPermi('manage:eqpmanagement:add')")
    @Log(title = "设备管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AgrEquipmentManagement agrEquipmentManagement)
    {
        return toAjax(agrEquipmentManagementService.insertAgrEquipmentManagement(agrEquipmentManagement));
    }

    /**
     * 修改设备管理
     */
    @PreAuthorize("@ss.hasPermi('manage:eqpmanagement:edit')")
    @Log(title = "设备管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AgrEquipmentManagement agrEquipmentManagement)
    {
        return toAjax(agrEquipmentManagementService.updateAgrEquipmentManagement(agrEquipmentManagement));
    }

    /**
     * 删除设备管理
     */
    @PreAuthorize("@ss.hasPermi('manage:eqpmanagement:remove')")
    @Log(title = "设备管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(agrEquipmentManagementService.deleteAgrEquipmentManagementByIds(ids));
    }
}
