package com.aiAgriculture.manage.service;

import java.util.List;
import com.aiAgriculture.manage.domain.ControlActionAudit;

/**
 * 控制操作审计Service接口
 * 
 * @author aiagri
 * @date 2024-11-14
 */
public interface IControlActionAuditService 
{
    /**
     * 查询控制操作审计
     * 
     * @param id 控制操作审计主键
     * @return 控制操作审计
     */
    public ControlActionAudit selectControlActionAuditById(Long id);

    /**
     * 查询控制操作审计列表
     * 
     * @param controlActionAudit 控制操作审计
     * @return 控制操作审计集合
     */
    public List<ControlActionAudit> selectControlActionAuditList(ControlActionAudit controlActionAudit);

    /**
     * 新增控制操作审计
     * 
     * @param controlActionAudit 控制操作审计
     * @return 结果
     */
    public int insertControlActionAudit(ControlActionAudit controlActionAudit);

    /**
     * 修改控制操作审计
     * 
     * @param controlActionAudit 控制操作审计
     * @return 结果
     */
    public int updateControlActionAudit(ControlActionAudit controlActionAudit);

    /**
     * 批量删除控制操作审计
     * 
     * @param ids 需要删除的控制操作审计主键集合
     * @return 结果
     */
    public int deleteControlActionAuditByIds(Long[] ids);

    /**
     * 删除控制操作审计信息
     * 
     * @param id 控制操作审计主键
     * @return 结果
     */
    public int deleteControlActionAuditById(Long id);
}
