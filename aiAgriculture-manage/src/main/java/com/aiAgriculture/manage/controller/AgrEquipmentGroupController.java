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
import com.aiAgriculture.manage.domain.AgrEquipmentGroup;
import com.aiAgriculture.manage.service.IAgrEquipmentGroupService;
import com.aiAgriculture.common.utils.poi.ExcelUtil;
import com.aiAgriculture.common.core.page.TableDataInfo;

/**
 * 设备组管理Controller
 * 
 * @author aiagr
 * @date 2024-11-14
 */
@RestController
@RequestMapping("/manage/eqpgroup")
public class AgrEquipmentGroupController extends BaseController
{
    @Autowired
    private IAgrEquipmentGroupService agrEquipmentGroupService;

    /**
     * 查询设备组管理列表
     */
    @PreAuthorize("@ss.hasPermi('manage:eqpgroup:list')")
    @GetMapping("/list")
    public TableDataInfo list(AgrEquipmentGroup agrEquipmentGroup)
    {
        startPage();
        List<AgrEquipmentGroup> list = agrEquipmentGroupService.selectAgrEquipmentGroupList(agrEquipmentGroup);
        return getDataTable(list);
    }

    /**
     * 导出设备组管理列表
     */
    @PreAuthorize("@ss.hasPermi('manage:eqpgroup:export')")
    @Log(title = "设备组管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AgrEquipmentGroup agrEquipmentGroup)
    {
        List<AgrEquipmentGroup> list = agrEquipmentGroupService.selectAgrEquipmentGroupList(agrEquipmentGroup);
        ExcelUtil<AgrEquipmentGroup> util = new ExcelUtil<AgrEquipmentGroup>(AgrEquipmentGroup.class);
        util.exportExcel(response, list, "设备组管理数据");
    }

    /**
     * 获取设备组管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:eqpgroup:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(agrEquipmentGroupService.selectAgrEquipmentGroupById(id));
    }

    /**
     * 新增设备组管理
     */
    @PreAuthorize("@ss.hasPermi('manage:eqpgroup:add')")
    @Log(title = "设备组管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AgrEquipmentGroup agrEquipmentGroup)
    {
        return toAjax(agrEquipmentGroupService.insertAgrEquipmentGroup(agrEquipmentGroup));
    }

    /**
     * 修改设备组管理
     */
    @PreAuthorize("@ss.hasPermi('manage:eqpgroup:edit')")
    @Log(title = "设备组管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AgrEquipmentGroup agrEquipmentGroup)
    {
        return toAjax(agrEquipmentGroupService.updateAgrEquipmentGroup(agrEquipmentGroup));
    }

    /**
     * 删除设备组管理
     */
    @PreAuthorize("@ss.hasPermi('manage:eqpgroup:remove')")
    @Log(title = "设备组管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(agrEquipmentGroupService.deleteAgrEquipmentGroupByIds(ids));
    }
}
