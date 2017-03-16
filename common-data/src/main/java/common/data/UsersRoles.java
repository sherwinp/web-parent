package common.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="USERS_ROLES")
@IdClass(UserRoleId.class)
public class UsersRoles implements Serializable{
	@Id
	@Column(name = "MEMBER_ID", insertable = false, updatable = false)
	private Long member_id;
	@Id
	@Column(name = "ROLE_ID", insertable = false, updatable = false)
	private Long role_id;
	
	@Column
	private String role_name;
    
	@Column
    private String email;
    
	  @ManyToOne
	  @PrimaryKeyJoinColumn(name="MEMBERID", referencedColumnName="ID")
	  private Member member;
	  @ManyToOne
	  @PrimaryKeyJoinColumn(name="ROLEID", referencedColumnName="ID")
	  private Role role;
}

class UserRoleId implements Serializable {
	private Long member_id;
	private String role_name;
	private String email;
	UserRoleId(Long memberid, String roleName, String email) {
		this.role_name = roleName;
		this.email=email;
		this.member_id = memberid;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		Long result = 1L;
		result = prime * result	+ ((role_name == null) ? 0 : role_name.hashCode());
		result = prime * result + member_id;
		return result.intValue();
	}
 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRoleId other = (UserRoleId) obj;
		if (role_name == null) {
			if (other.role_name != null)
				return false;
		} else if (!role_name.equals(other.role_name))
			return false;
		if (member_id != other.member_id)
			return false;
		return true;
	}
}