package com.tanlis.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.tanlis.dao.OrderDao;
import com.tanlis.model.Order;
import com.tanlis.model.OrderItem;
import com.tanlis.model.Page;
import com.tanlis.utils.DBUtil;

public class OrderService {
	private OrderDao oDao=new OrderDao(); 
	
	public void addOrder(Order order) {
		Connection con=null;
		try {
			con=DBUtil.getConnection();
			con.setAutoCommit(false);
			
			oDao.insertOrder(con, order);
			int id=oDao.getLastInsertId(con);
			order.setId(id);
			for(OrderItem item:order.getItemMap().values()) {
				oDao.insertOrderItem(con, item);
			}
			
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public List<Order> selectAll(int userid){
		List<Order> list=null;
		try {
			list=oDao.selectAll(userid);//找到所有的订单
			for(Order o:list) {//遍历订单编号
				List<OrderItem> l=oDao.selectAllItem(o.getId());//每个单号的里面 查询所有的item 并保存到list里面
				o.setItemList(l); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public Page getOrderPage(int status,int pageNo) {
		Page p=new Page();//新建一个分页对象
		
		p.setPageNo(pageNo);//设置第几页
		int pageSize=10;
		int totalCount=0;//总数
		try {
			totalCount=oDao.getOrderCount(status);//通过GoodsDao中的函数 查询该类型的总数
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p.setPageSizeAndTotalCount(pageSize, totalCount);//通过总数 计算要分多少页
		
		List list=null;
		try {
			list=oDao.selectOrderList(status, pageNo, pageSize); //查询数据 根据类型id ，页码。 返回该页的集合
			for(Order o:(List<Order>)list) {//遍历订单编号
				List<OrderItem> l=oDao.selectAllItem(o.getId());//每个单号的里面 查询所有的item 并保存到list里面
				o.setItemList(l); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		p.setList(list);//为分页设置 返回的集合对象
		return p;
		}
	
	public void updateStatus(int id, int status) {
		try {
			oDao.updateStatus(id, status);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void delete(int id) {
		Connection con=null;
		try { 
			con=DBUtil.getDataSource().getConnection();
			con.setAutoCommit(false);
			
			oDao.deleteOrderItem(con, id);
			oDao.deleteOrder(con, id);
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			if(con!=null) {
			try { 
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		}
		
	}
}

