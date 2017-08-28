package me.ele.arch.SpringBootDemo.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class Properties {
	
	@Value("{$name}")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
