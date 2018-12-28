package com.tanlis.listener;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.sun.xml.internal.ws.api.pipe.Tube;
import com.tanlis.model.Type;
import com.tanlis.service.TypeService;

/**
 * Application Lifecycle Listener implementation class ApplicationListener
 *
 */
@WebListener
public class ApplicationListener implements ServletContextListener {

	private TypeService tService=new TypeService();
	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    //监听，每个页面都要用到的 自动获取商品分类 列表
    public void contextInitialized(ServletContextEvent arg0)  { 
         List<Type> list=tService.selectAll();
//         for(Type o:list) {
//        	 System.out.println(o.getName());
//         }
         arg0.getServletContext().setAttribute("TypeList", list);//监听 向所有页面发送一个TpeList用于保存 系列类
    }
	
}
