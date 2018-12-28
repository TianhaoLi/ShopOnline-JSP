package com.tanlis.service;

import java.sql.SQLException;
import java.util.List;

import com.tanlis.dao.UserDao;
import com.tanlis.model.Order;
import com.tanlis.model.OrderItem;
import com.tanlis.model.Page;
import com.tanlis.model.User;

public class UserService {
	private UserDao uDao=new UserDao();
	//注册服务
	public boolean register(User user) {
		try {
			
			if(uDao.isUsernameExist(user.getUsername())) {
				return false;
			}
			if(uDao.isEmailExist(user.getEmail())) {
				return false;
			}
			uDao.addUser(user);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	//登陆服务
	public User login(String ue,String password) {
		User user=null;
		try {
			user = uDao.selectByUsernamePassword(ue, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(user!=null) {
			return user;
		}
		try {
			user=uDao.selectByEmailPassword(ue, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(user!=null) {
			return user;
		}
		return null;	
	}
	//根据id查询信息
	public User selectByID(int id) {
		User u=null;
		try {
			u = uDao.selectByID(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
		
	}
	//更新地址服务
	public void updateUserAddress(User user) {
		try {
			uDao.updateUserAddress(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean delete(int id) {
		try {
			uDao.delete(id);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
	public void updatePwd(User user) {
		try {
			uDao.updatePwd(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Page getUserPage(int pageNo) {

		Page p=new Page();//新建一个分页对象
		
		p.setPageNo(pageNo);//设置第几页
		int pageSize=7;
		int totalCount=0;//总数
		try {
			totalCount=uDao.selectUserCount();//通过GoodsDao中的函数 查询该类型的总数
		} catch (SQLException e) {
			e.printStackTrace();
		}
		p.setPageSizeAndTotalCount(pageSize, totalCount);//通过总数 计算要分多少页
		
		List list=null;
		try {
			list=uDao.selectUserList(pageNo, pageSize); //查询数据 根据类型id ，页码。 返回该页的集合

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		p.setList(list);//为分页设置 返回的集合对象
		return p;
	}
}
