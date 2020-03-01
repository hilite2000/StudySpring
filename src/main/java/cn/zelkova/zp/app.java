package cn.zelkova.zp;

import cn.zelkova.zp.entity.Car;
import cn.zelkova.zp.entity.Student;
import cn.zelkova.zp.math.Cal;
import cn.zelkova.zp.math.CalImpl;
import cn.zelkova.zp.math.MyInvocationhandler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLOutput;


//@Configuration
//@EnableAspectJAutoProxy
public class app {

		public static void main(String[] args) {
//				Student st = new Student();
//				st.setId(11L);
//				st.setName("zjr");
//				st.setAge(13);
//				st.setAddress(new Address());
//				System.out.println(st);

				//读取配置文件myspring.xml
				//component-scan，启动了对包bean的扫描，spring AOP部分，就是通过这个开关打开注解方式的。
				//	通过这个开关，就可实现 配置文件和注解同时生效的效果
				ApplicationContext appCtx = new ClassPathXmlApplicationContext("myspring.xml");
				//如果用这个，需要给bean加上@Component 和 @Autowaired
				//ApplicationContext appCtx = new AnnotationConfigApplicationContext("cn.zelkova.zp");
				System.out.println("============================================================");

				testIoC(appCtx);

				testAOP(appCtx);

		}


		/**
		 * AOP 演示
		 */
		static void testAOP(ApplicationContext appCtx) {

				// 用java的动态代理实现横切
				Cal c = new CalImpl();
				System.out.println(c.add(2, 3));

				MyInvocationhandler handler = new MyInvocationhandler();
				Cal cHandler = (Cal) handler.bind(c);
				cHandler.add(2, 3);
				cHandler.sub(2, 3);
				cHandler.mul(2, 3);
				cHandler.div(220, 3);

				cHandler.toString();
				cHandler.hashCode();

				System.out.println("============ finished testAOP Invocation Handler ======");


				// Spring 实现的横切，bean信息是通过配置文件声明bean扫描而得到的
				Cal calProxy = (Cal) appCtx.getBean("calImpl");
				calProxy.add(10, 20);
				calProxy.sub(10, 20);
				calProxy.mul(10, 20);
				calProxy.div(1210, 20);
				try {
						calProxy.div(0, 0);
				} catch (Exception ex) {
						System.out.println("方法外捕获异常：" + ex.toString());
				}

				calProxy.toString();
				calProxy.hashCode();

				System.out.println("============ finished testAOP spring AOP ======");
		}


		/**
		 * 注入演示，bean信息都是从xml配置文件读取的
		 */
		static void testIoC(ApplicationContext appCtx) {
				Student st1 = (Student) appCtx.getBean("student1");
				System.out.println(st1);

				Student st2 = (Student) appCtx.getBean("student2");
				System.out.println(st2);

				Student stA = (Student) appCtx.getBean("student1");
				System.out.println(stA);

				Student stB = (Student) appCtx.getBean("student2");
				System.out.println(stA);

//				System.out.println("st1 == st2：" + (st1 == st2));
//				System.out.println("stA == stB：" + (stA == stB));
//				System.out.println("st1 == stA：" + (st1 == stA));
//				System.out.println("st2 == stA：" + (st2 == stA));
//				System.out.println("st1 == stB：" + (st1 == stB));
//				System.out.println("st2 == stB：" + (st2 == stB));

//				System.out.println(st.getAddress() == st1.getAddress());
//				System.out.println(st1.getAddress() == st2.getAddress());

				Car c1 = (Car) appCtx.getBean("car");
				System.out.println(c1);

				Car car2 = (Car) appCtx.getBean("car2");
				System.out.println(car2);

				System.out.println("============ finished testIoC ======");
		}

}

