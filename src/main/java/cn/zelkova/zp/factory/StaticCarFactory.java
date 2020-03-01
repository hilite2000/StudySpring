package cn.zelkova.zp.factory;

import cn.zelkova.zp.entity.Car;

import java.util.HashMap;
import java.util.Map;

public class StaticCarFactory {

		private static Map<Long, Car> carMap;

		static {
				System.out.println("begin Static Car Factory init");

				carMap = new HashMap<>();
				carMap.put(1L, new Car(1L, "宝马"));
				carMap.put(2L, new Car(2L, "奔驰"));

				System.out.println("end Static Car Factory init");
		}

		public static Car getCar(long id) {
				System.out.println("factory in Static Car Factory getCar: " + id);
				return carMap.get(id);
		}

}
