package com.example.springsecurity02.service;
import java.util.List;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.springsecurity02.mapper.UsersMapper;
import com.example.springsecurity02.model.Users;
/**
*  @author MFine
*  @date 2021/7/24 0:21
*  @version 1.0
**/
    
@Service
public class UsersService{

    @Resource
    private UsersMapper usersMapper;

    
    public int deleteByPrimaryKey(Long id) {
        return usersMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(Users record) {
        return usersMapper.insert(record);
    }

    
    public int insertSelective(Users record) {
        return usersMapper.insertSelective(record);
    }

    
    public Users selectByPrimaryKey(Long id) {
        return usersMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(Users record) {
        return usersMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Users record) {
        return usersMapper.updateByPrimaryKey(record);
    }

	public Users findByUsername(String username){
		 return usersMapper.findByUsername(username);
	}




}
