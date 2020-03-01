package cn.zelkova.zp.math;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class MyInvocationhandler implements InvocationHandler {

		private Object obj = null;

		public Object bind(Object obj) {
				this.obj = obj;
				return Proxy.newProxyInstance(
								this.obj.getClass().getClassLoader(),
								this.obj.getClass().getInterfaces(),
								this);
		}

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println(method.getName() + " 方法参数： " + Arrays.toString(args));
				Object ret = method.invoke(this.obj, args);
				System.out.println(method.getName() + " 结果是： " + ret);
				return ret;
		}
}
