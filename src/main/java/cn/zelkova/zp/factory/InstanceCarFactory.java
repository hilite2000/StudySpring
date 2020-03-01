package cn.zelkova.zp.factory;

import cn.zelkova.zp.entity.Car;

import java.util.HashMap;
import java.util.Map;

public class InstanceCarFactory {

		private Map<Long, Car> carMap;

		public InstanceCarFactory() {
				System.out.println("begin inst Car Factory init");

				carMap = new HashMap<>();
				carMap.put(1L, new Car(1L, "宝马"));
				carMap.put(2L, new Car(2L, "奔驰"));

				System.out.println("end inst Car Factory init");
		}

		public Car getCar(long id) {
				System.out.println("factory inst Car Factory getCar: " + id);
				return carMap.get(id);
		}
}
