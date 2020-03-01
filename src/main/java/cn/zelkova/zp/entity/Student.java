package cn.zelkova.zp.entity;

/**
 * 学生信息类
 */
public class Student {

		private Long id;
		private String name;
		private Integer age;
		private Address address;
		private Car car;

		public Student() {
				System.out.println("Student ctor");
		}

		// region  ============  getter and setter

		public Long getId() {
				return id;
		}

		public void setId(Long id) {
				this.id = id;
		}

		public String getName() {
				return name;
		}

		public void setName(String name) {
				this.name = name;
		}

		public Integer getAge() {
				return age;
		}

		public void setAge(Integer age) {
				this.age = age;
		}

		public Address getAddress() {
				return address;
		}

		public void setAddress(Address address) {
				this.address = address;
		}

		public Car getCar() {
				return car;
		}

		public void setCar(Car car) {
				this.car = car;
		}

		// endregion


		@Override
		public String toString() {
				return "Student{" +
								"id=" + id +
								", name='" + name + '\'' +
								", age=" + age +
								", address=" + address +
								", car=" + car +
								'}';
		}
}
