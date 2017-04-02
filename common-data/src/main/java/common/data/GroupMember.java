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
@Table(name = "GROUPMEMBERS", schema="PUBLIC")
public class GroupMember implements Serializable {
	private static final long serialVersionUID = 1005000L;
    @Id
    @Column(name="G_NAME")
    private String name;
    @Column(name="U_NAME")
    private String member;
    
    GroupMember(){};
    
    public GroupMember(String group, String email){
    	this.name = group;
    	this.member = email;
    }
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMember() {
		return member;
	}
	public void setMember(String member) {
		this.member = member;
	}
}
