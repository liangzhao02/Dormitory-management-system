package com.ling.entity;

import org.hibernate.validator.constraints.Length;
import com.ling.utils.Entity;


/**
 *
 * @author 596183363@qq.com
 * @time 2020-11-21 14:27:15
 */
public class Grade extends Entity{

	/**
	 *
	 */
	private Integer id;
	/**
	 *
	 */
	@Length(max = 100)
	private String name;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
