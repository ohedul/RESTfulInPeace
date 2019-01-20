package rokomari.project.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private long user_id;
	
	@Column(name ="f_name")
	private String first_name;
	
	@Column(name ="l_name")
	private String last_name;
	
	@Column(name = "e-mail")
	private String email;
	
	@Column(name = "mobile")
	private long mobile;
	
	@Column(name = "password")
	private String password;
	 @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	 @JoinTable(name = "user_role")
	private Set<Role> roles;
	 
	 
	public Users() {
		
	}
	public Users(Users user) {
		this.first_name = user.getFirst_name();
		this.email = user.email;
		this.password = user.getPassword();
		this.user_id = user.getUser_id();
		this.roles = user.getRoles();
		
	}
	
	
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	 
	 

}
