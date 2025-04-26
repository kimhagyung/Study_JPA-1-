package jpa_basic.ex1_hello_jpa.hello_jpa;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Locker {

	@Id @GeneratedValue
	private Long id;
	
	private String name;
}
