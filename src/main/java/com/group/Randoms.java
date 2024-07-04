package com.group;

import java.util.List;

public class Randoms {
	RandomNumber random = new RandomNumberImpl();

	public <T>T choice(List<T> options){
		if(options.isEmpty()) {
			return null;
		}
		int index = random.nextInt() % options.size();
		return options.get(index);
	}

}
