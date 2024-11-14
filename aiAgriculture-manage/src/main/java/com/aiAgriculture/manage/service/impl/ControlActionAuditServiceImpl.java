package com.aiAgriculture.manage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aiAgriculture.manage.mapper.ControlActionAuditMapper;
import com.aiAgriculture.manage.domain.ControlActionAudit;
import com.aiAgriculture.manage.service.IControlActionAuditService;

/**
 * 控制操作审计Service业务层处理
 * 
 * @author aiagri
 * @date 2024-11-14
 */
@Service
public class ControlActionAuditServiceImpl implements IControlActionAuditService 
{
    @Autowired
    private ControlActionAuditMapper controlActionAuditMapper;

    /**
     * 查询控制操作审计
     * 
     * @param id 控制操作审计主键
     * @return 控制操作审计
     */
    @Override
    public ControlActionAudit selectControlActionAuditById(Long id)
    {
        return controlActionAuditMapper.selectControlActionAuditById(id);
    }

    /**
     * 查询控制操作审计列表
     * 
     * @param controlActionAudit 控制操作审计
     * @return 控制操作审计
     */
    @Override
    public List<ControlActionAudit> selectControlActionAuditList(ControlActionAudit controlActionAudit)
    {
        return controlActionAuditMapper.selectControlActionAuditList(controlActionAudit);
    }

    /**
     * 新增控制操作审计
     * 
     * @param controlActionAudit 控制操作审计
     * @return 结果
     */
    @Override
    public int insertControlActionAudit(ControlActionAudit controlActionAudit)
    {
        return controlActionAuditMapper.insertControlActionAudit(controlActionAudit);
    }

    /**
     * 修改控制操作审计
     * 
     * @param controlActionAudit 控制操作审计
     * @return 结果
     */
    @Override
    public int updateControlActionAudit(ControlActionAudit controlActionAudit)
    {
        return controlActionAuditMapper.updateControlActionAudit(controlActionAudit);
    }

    /**
     * 批量删除控制操作审计
     * 
     * @param ids 需要删除的控制操作审计主键
     * @return 结果
     */
    @Override
    public int deleteControlActionAuditByIds(Long[] ids)
    {
        return controlActionAuditMapper.deleteControlActionAuditByIds(ids);
    }

    /**
     * 删除控制操作审计信息
     * 
     * @param id 控制操作审计主键
     * @return 结果
     */
    @Override
    public int deleteControlActionAuditById(Long id)
    {
        return controlActionAuditMapper.deleteControlActionAuditById(id);
    }
}
