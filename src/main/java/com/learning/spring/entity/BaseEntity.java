package com.learning.spring.entity;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity implements Serializable {

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
				// @TODO: Fix the issue for iterables.
				/*if(elem.getType().)
				{
					
				}
				else*/
					sb.append(elem.getName() + " : " + elem.get(this)  + ", ");
				
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
