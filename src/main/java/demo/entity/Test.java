package demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Test")
@Data
public class Test {

	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(nullable = false)
	    private int id;

	    @Column
	    private String test;
}
