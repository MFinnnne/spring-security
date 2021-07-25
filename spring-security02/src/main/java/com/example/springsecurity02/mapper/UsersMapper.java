package com.example.springsecurity02.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.example.springsecurity02.model.Users;

/**
*  @author MFine
*  @date 2021/7/24 0:21
*  @version 1.0
**/
@Mapper
public interface UsersMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    Users findByUsername(@Param("username")String username);


}