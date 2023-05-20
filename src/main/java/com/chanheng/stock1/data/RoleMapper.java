package com.chanheng.stock1.data;

import com.chanheng.stock1.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoleMapper {
    @Select("SELECT * FROM roles")
    List<Role> selectRole();
}
