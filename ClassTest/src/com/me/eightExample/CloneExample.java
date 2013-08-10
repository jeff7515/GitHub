package com.me.eightExample;

public class CloneExample implements Cloneable {

	@Override
	public CloneExample clone() {
		
		CloneExample cloneExample = null;
		try {
			cloneExample = (CloneExample) super.clone();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return cloneExample;
	}

}
