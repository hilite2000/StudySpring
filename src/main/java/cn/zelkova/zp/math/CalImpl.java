package cn.zelkova.zp.math;


import org.springframework.stereotype.Component;

@Component
public class CalImpl implements Cal {

		@Override
		public String toString() {
				return "CalImpl{}";
		}

		@Override
		public int add(int v1, int v2) {
				int ret = v1 + v2;
				return ret;
		}

		@Override
		public int sub(int v1, int v2) {
				int ret = v1 - v2;
				return ret;
		}

		@Override
		public int mul(int v1, int v2) {
				int ret = v1 * v2;
				return ret;
		}

		@Override
		public int div(int v1, int v2) {
				int ret = v1 / v2;
				return ret;
		}
}
