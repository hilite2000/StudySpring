package cn.zelkova.zp.math;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggerAspect {

		@Before("execution(public int cn.zelkova.zp.math.CalImpl.*(..))")
		public void before(JoinPoint jp) {
				String name = jp.getSignature().getName();
				String args = Arrays.toString(jp.getArgs());
				System.out.println("【LoggerAspect】" + name + " 方法参数： " + args);
		}

		@After("execution(public int cn.zelkova.zp.math.CalImpl.*(..))")
		public void after(JoinPoint jp) {
				String name = jp.getSignature().getName();
				System.out.println("【LoggerAspect】" + name + " 执行完成");
		}

		@AfterReturning(value = "execution(public int cn.zelkova.zp.math.CalImpl.*(..))", returning = "result")
		public void afterReturning(JoinPoint jp, int result) {
				String name = jp.getSignature().getName();
				System.out.println("【LoggerAspect】" + name + " 执行返回值：" + result);
		}


		@AfterThrowing(value = "execution(public int cn.zelkova.zp.math.CalImpl.*(..))",throwing = "ex")
		public void afterReturning(JoinPoint jp, Exception ex) {
				String name = jp.getSignature().getName();
				System.out.println("【LoggerAspect】" + name + " 发生异常：" + ex.toString());
		}

}
