package com.aiAgriculture.manage.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aiAgriculture.common.annotation.Excel;
import com.aiAgriculture.common.core.domain.BaseEntity;

/**
 * 控制操作审计对象 control_action_audit
 * 
 * @author aiagri
 * @date 2024-11-14
 */
public class ControlActionAudit extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 操作ID */
    private Long id;

    /** 操作行为 */
    @Excel(name = "操作行为")
    private String actionName;

    /** 操作时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "操作时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date actionTime;

    /** 操作人 */
    @Excel(name = "操作人")
    private String operator;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setActionName(String actionName) 
    {
        this.actionName = actionName;
    }

    public String getActionName() 
    {
        return actionName;
    }
    public void setActionTime(Date actionTime) 
    {
        this.actionTime = actionTime;
    }

    public Date getActionTime() 
    {
        return actionTime;
    }
    public void setOperator(String operator) 
    {
        this.operator = operator;
    }

    public String getOperator() 
    {
        return operator;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("actionName", getActionName())
            .append("actionTime", getActionTime())
            .append("operator", getOperator())
            .toString();
    }
}
