package com.aiAgriculture.manage.service;

import java.util.List;
import com.aiAgriculture.manage.domain.AgrCropManager;

/**
 * 人工管理Service接口
 * 
 * @author aiagr
 * @date 2024-11-09
 */
public interface IAgrCropManagerService 
{
    /**
     * 查询人工管理
     * 
     * @param id 人工管理主键
     * @return 人工管理
     */
    public AgrCropManager selectAgrCropManagerById(Long id);

    /**
     * 查询人工管理列表
     * 
     * @param agrCropManager 人工管理
     * @return 人工管理集合
     */
    public List<AgrCropManager> selectAgrCropManagerList(AgrCropManager agrCropManager);

    /**
     * 新增人工管理
     * 
     * @param agrCropManager 人工管理
     * @return 结果
     */
    public int insertAgrCropManager(AgrCropManager agrCropManager);

    /**
     * 修改人工管理
     * 
     * @param agrCropManager 人工管理
     * @return 结果
     */
    public int updateAgrCropManager(AgrCropManager agrCropManager);

    /**
     * 批量删除人工管理
     * 
     * @param ids 需要删除的人工管理主键集合
     * @return 结果
     */
    public int deleteAgrCropManagerByIds(Long[] ids);

    /**
     * 删除人工管理信息
     * 
     * @param id 人工管理主键
     * @return 结果
     */
    public int deleteAgrCropManagerById(Long id);
}
