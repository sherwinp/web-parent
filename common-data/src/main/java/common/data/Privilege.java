package common.data;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;

@Entity
public class Privilege {
	   @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;
	 
	    private String name;
	 
	    @ManyToMany(mappedBy = "privileges")
	    private Collection<Role> roles;
}