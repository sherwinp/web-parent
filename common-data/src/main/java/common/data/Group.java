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
@Table(name = "GROUPS", schema="PUBLIC")
public class Group implements Serializable {
	private static final long serialVersionUID = 1005000L;
    @Id
    @Column(name="G_NAME")
    private String name;
    @Column(name="G_DESCRIPTION")
    private String description;
}