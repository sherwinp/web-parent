package common.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table(name = "USERS", schema="PUBLIC")
@SecondaryTable(name = "GROUPMEMBERS",  schema="PUBLIC", pkJoinColumns={@PrimaryKeyJoinColumn(name = "U_NAME")})
public class Membership {
    @Id
    @Column(name="U_NAME")
    private String uname;

    @Column(name="U_DESCRIPTION")
    private String description;
    
    @Column(name="G_NAME", table="GROUPMEMBERS", insertable=false, updatable=false)
    private String gname;
    @Column(name="U_NAME", table="GROUPMEMBERS", insertable=false, updatable=false)
    private String member;
}
