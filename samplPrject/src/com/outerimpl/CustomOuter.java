package com.outerimpl;

import java.util.List;

import sm.q.Outer;

public class CustomOuter implements Outer{

	@Override
	public void print(List obj) throws Exception {
		System.out.println(obj.get(0)+">>>");
	}

	@Override
	public void setFileName(String filename) throws Exception {
	}

}
