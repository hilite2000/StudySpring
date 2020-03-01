package cn.zelkova.zp.entity;


/**
 * 地址信息
 */
public class Address {
		private Long id;
		private String street = "无家可归";
		private Long timestamp = System.currentTimeMillis();

		//region ==============  getter and setter
		public Address() {
				System.out.println("Address ctor");
		}

		public Long getId() {
				return id;
		}

		public void setId(Long id) {
				this.id = id;
		}

		public String getStreet() {
				return street;
		}

		public void setStreet(String street) {
				this.street = street;
		}

		public Long getTimestamp() {
				return timestamp;
		}
		//endregion

		@Override
		public String toString() {
				return "Address{" +
								"id=" + id +
								", street='" + street + '\'' +
								", timestamp=" + timestamp +
								'}';
		}


}
