package net.yorksolutions.jsontestremake;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cache {

	@Id
			@GeneratedValue(strategy = GenerationType.SEQUENCE)
	Long id;

	String md5Input;
	String md5Output;

}
