
package org.xhome.annotation.DO;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xhome.annotation.intefaceDO.TestA;
/*
 * 关于注释的学习
 * 我们为了让注释在运行期有效必须使用Policy.RUNTIME
 * 注释可以让我们少写一部分配置文件
 * 并且代码可阅读性会增强，但是我们必须利用反射去将注释转化为具体的代码，设置对象相应的值
 */
public class UserDO {
	private static Logger logger=LoggerFactory.getLogger(UserDO.class);
	public Integer age;
	@TestA(value=11)
	public UserDO(){
	}
   

	public void a(){
		Map map=new HashMap();
	}
	
	public void b(Integer a){
		
	}
	
	public static void main(String args[]){
		try {
			Class cls=Class.forName("org.xhome.annotation.DO.UserDO");
			Method[] methods=cls.getMethods();
			for(Method method:methods){
				boolean has=method.isAnnotationPresent(TestA.class);
				logger.info("has :{}",has);
			}
//			Annotation[] annotations=cls.getClass().getMethods()[0].getAnnotations();
//			for(Annotation annotation:annotations){
//				TestA testA=(TestA)annotation;
//				System.out.println("value :"+testA.value());
//			}
//			Annotation[] annotations = user.getClass().getAnnotations();  
//	        for (Annotation annotation : annotations) {  
//	        	TestA testA = (TestA)annotation;
//	            System.out.println(" value= \""+testA.value());  
//	        }  
			Constructor[] cons=cls.getConstructors();
			for(int i=0;i<cons.length;i++){
				 boolean hasAnnotation = cons[i].isAnnotationPresent(TestA.class); 
				 logger.info("is hava:"+hasAnnotation);
				TestA annotation=(TestA) cons[i].getAnnotation(TestA.class);
				Integer value=annotation.value();
				System.out.println("value :"+value);
				//user.age=value;
			}
//			logger.info("value is {}",user.age);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
		}
		
	}
}
