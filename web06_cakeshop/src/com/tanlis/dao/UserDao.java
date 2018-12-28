package com.tanlis.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.tanlis.model.Order;
import com.tanlis.model.User;
import com.tanlis.utils.DBUtil;

public class UserDao {
	//添加用户
	public void addUser(User user) throws SQLException {
		QueryRunner r = new QueryRunner(DBUtil.getDataSource());
		String sql="insert into user(username,email,password,name,phone,address,isadmin,isvalidate) values(?,?,?,?,?,?,?,?)";
		r.update(sql,user.getUsername(),user.getEmail(),user.getPassword(),user.getName(),user.getPhone(),user.getAddress(),user.isIsadmin(),user.isIsvalidate());
	}
	//注册时 验证邮箱，用户名是否已存在
	public boolean isUsernameExist(String username) throws SQLException {
		QueryRunner r = new QueryRunner(DBUtil.getDataSource());
		String sql="select * from user where username=?";
		User u = r.query(sql, new BeanHandler<User>(User.class),username);
		if(u==null) {
			return false;
		}else {
			return true;
		}
		
	}
	//注册时 验证邮箱是否存在
	public boolean isEmailExist(String email) throws SQLException {
		QueryRunner r = new QueryRunner(DBUtil.getDataSource());
		String sql="select * from user where email=?";
		User u = r.query(sql, new BeanHandler<User>(User.class),email);
		if(u==null) {
			return false;
		}else {
			return true;
		}
		
	}
	//登陆 根据用户名和邮箱 验证
	public User selectByUsernamePassword(String username,String password) throws SQLException {
		QueryRunner r = new QueryRunner(DBUtil.getDataSource());
		String sql="select * from user where username=? and password=?";
		return r.query(sql, new BeanHandler<User>(User.class),username,password);
	}
	public User selectByEmailPassword(String email,String password) throws SQLException {
		QueryRunner r = new QueryRunner(DBUtil.getDataSource());
		String sql="select * from user where email=? and password=?";
		return r.query(sql, new BeanHandler<User>(User.class),email,password);
	}
	//根据id查询
	public User selectByID(int id) throws SQLException {
		QueryRunner r = new QueryRunner(DBUtil.getDataSource());
		String sql="select * from user where id=?";
		return r.query(sql, new BeanHandler<User>(User.class),id);
	}
	
	//修改用户地址
	public void updateUserAddress(User user) throws SQLException {
		QueryRunner r = new QueryRunner(DBUtil.getDataSource());
		String sql="update user set name= ?,phone= ?,address = ? where id = ?";
		r.update(sql, user.getName(),user.getPhone(),user.getAddress(),user.getId());
	}
	//修改用户密码
	public void updatePwd(User user) throws SQLException {
		QueryRunner r = new QueryRunner(DBUtil.getDataSource());
		String sql="update user set password= ? where id = ?";
		r.update(sql, user.getPassword(),user.getId());
	}
	//用户总数
	public int selectUserCount() throws SQLException {
		QueryRunner r=new QueryRunner(DBUtil.getDataSource());
		String sql="";
		sql="select count(*) from user";
		return r.query(sql, new ScalarHandler<Long>()).intValue();
	}
	//获取user列表
	public List selectUserList(int pageNo, int pageSize) throws SQLException {
		QueryRunner r=new QueryRunner(DBUtil.getDataSource());
		String sql="select * from user limit ?,?";
		return r.query(sql, new BeanListHandler<User>(User.class),(pageNo-1)*pageSize,pageSize);
	}
	//根据id删除
	public void delete(int id) throws SQLException {
		QueryRunner r = new QueryRunner(DBUtil.getDataSource());
		String sql="delete  from user where id=?";
		r.update(sql,id);
	}
	

	
}
