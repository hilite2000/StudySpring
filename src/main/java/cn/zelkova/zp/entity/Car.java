package cn.zelkova.zp.entity;

public class Car {
		private long id;
		private String name;

		//region ==============   ctor
		public Car() {
				System.out.println("Car ctor");
		}

		public Car(long id, String name) {
				this.id = id;
				this.name = name;

				System.out.println("Car ctor: " + id + " " + name);
		}
		//endregion

		//region ===========  getter and setter
		public long getId() {
				return id;
		}

		public void setId(long id) {
				this.id = id;
		}

		public String getName() {
				return name;
		}

		public void setName(String name) {
				this.name = name;
		}


		//endregion


		@Override
		public String toString() {
				return "Car{" +
								"id=" + id +
								", name='" + name + '\'' +
								'}';
		}
}
