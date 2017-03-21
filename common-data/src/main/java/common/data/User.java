package common.data;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USERS", schema="PUBLIC")
public class User implements Serializable {
	private static final long serialVersionUID = 1000000L;
    @Id
    @Column(name="U_NAME")
    private String name;
    @Column(name="U_PASSWORD")
    private String password;
    @Column(name="U_DESCRIPTION")
    private String description;
}