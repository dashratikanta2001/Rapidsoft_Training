package com.blog.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.blog.services.RoleService;

@WebListener
public class RoleConfig implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.register(AppInitializer.class);
		context.refresh();
		RoleService roleService = context.getBean(RoleService.class);
		roleService.save(AppConstants.ROLE_ADMIN, "ROLE_ADMIN");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

	
//    private void createRoleIfNotExists(Integer roleId,String roleName, ServletContextEvent sce) {
//    	 WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
//    	 System.out.println("Context = = =  == "+context);
//    	 RoleDao roleService = context.getBean(RoleDao.class);
//    	 
//    	 System.out.println("ROle = = == = == = "+roleService);
//    	 
//        if (roleService.findByName(roleName) == null) {
//            
//            roleService.save(roleId, roleName);
//        }
//    }



}
