package com.example.mybatis.mapper;

import com.example.mybatis.pojo.Dept;
import com.example.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {
    /**
     * 分步查詢2，獲取員工以及對應的部門信息
     * @param deptId
     * @return
     */
    Dept getEmpAndDeptByStepTwo(@Param("deptId") Integer deptId);

    /**
     * 查詢部門中的員工信息
     * @param deptId
     * @return
     */
    Dept getDeptAndEmpByDeptId(@Param("deptId") Integer deptId);

    /**
     * 分布查詢1: 查詢部門中的員工信息
     * @param deptId
     * @return
     */
    Dept getDeptAndEmpByStepOne(@Param("deptId") Integer deptId);
}
