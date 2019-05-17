package cn.springmvc.test;
 
import java.sql.Timestamp;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hitworth.framework.base.model.User;
import com.hitworth.framework.base.service.UserService;
 
 
 
public class UserTest {
 
/*private UserService userService;
     
    @Before
    public void before(){                                                                    
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:config/spring.xml"});
        userService = (UserService) context.getBean("userService");
    }
     
    @Test
    public void addUser(){
        User user = new User();
        user.setDisplayName("张三");
        user.setInsertTime(new Timestamp(System.currentTimeMillis()) );
        user.setEmail("123@11.com");
        user.setLoginName("test"+(new Random().nextInt(10) + 1));
        user.setPassword("test"+(new Random().nextInt(10) + 1));
        user.setState(1);
        user.setTryTimes(3);
        user.setType("ca");
        userService.insertUser(user);
    }*/
}