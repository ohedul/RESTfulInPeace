package rokomari.project.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name = "role_id")
	private long roleId;
	
	@Column(name = "name")
	private String name;
	
	
	public Role() {
	}
	public long getId() {
		return roleId;
	}
	public void setId(long id) {
		this.roleId = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	

}
