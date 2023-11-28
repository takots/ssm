package com.example.mybatis.mapper;

import com.example.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {
    /**
     * id查詢員工信息
     * @param empId
     * @return
     */
    Emp getEmpByEmpId(@Param("empId") Integer empId);

    /**
     * 獲取員工以及對應的部門信息
     * @return
     */
    Emp getEmpAndDeptByEmpId(@Param("empId") Integer empId);

    /**
     * 分步查詢1，獲取員工以及對應的部門信息
     * @param empId
     * @return
     */
    Emp getEmpAndDeptByStepOne(@Param("empId") Integer empId);

    /**
     * 分布查詢2: 查詢部門中的員工信息
     * @param deptId
     * @return
     */
    List<Emp> getDeptAndByStepTwo(@Param("deptId") Integer deptId);

}
