package com.coderskitchen.macdi.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SingleCount {
	private String word;
	private Integer count;

	public String getWord() {
		return word;
	}

	public void setWord(final String word) {
		this.word = word;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(final Integer count) {
		this.count = count;
	}
}
