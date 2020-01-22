package com.learning.spring.entity;

import java.util.Arrays;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity {

	/**
	 * Helper function to dump an object as string.
	 * @return String.
	 */
	
	protected String convertObjectToString(){
		StringBuilder sb = new StringBuilder("[");
		Arrays.asList(this.getClass().getDeclaredFields())
		.forEach(elem -> {
			elem.setAccessible(true);
			try {
				sb.append(elem.getName() + " : " + elem.get(this) + ", ");
				
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		sb.append("]");
		return sb.toString();
	}

}
