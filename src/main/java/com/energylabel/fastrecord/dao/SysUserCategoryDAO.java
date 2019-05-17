package com.energylabel.fastrecord.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hitworth.framework.base.vo.SysUserCategoryVO;

public interface SysUserCategoryDAO {
  void batchInsertSysUserCategory(@Param("sysUserCategoryList") List<SysUserCategoryVO> sysUserCategoryList);
  List<SysUserCategoryVO> findSysUserCategoryByUserId(Integer userid);
  
}
