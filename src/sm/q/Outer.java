package sm.q;

import java.util.List;

public interface Outer {
	public static class OuterMeter{
		public static final int File=1;
		public static final int Screen=2;
	}
	void print(List obj)throws Exception;
}
