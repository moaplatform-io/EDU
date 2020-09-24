package sm.q.impl.outerimpl;

import java.util.List;

import sm.q.Outer;

public class ScreeOut implements Outer {
	@Override
	public void print(List obj) throws Exception {
		for (int i = 0; i < obj.size(); i++) {
			System.out.println(obj.get(i));
		}
		
	}

}
