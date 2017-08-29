package system.web.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@SuppressWarnings("serial")
@Entity
@Table(name="Sys_BaseRoleUser")
public class Sys_BaseRoleUser implements Serializable{
	private String id;
	private String roleId;
	private String baseUserId;
	@Id
	@GenericGenerator(name="systemUUID",strategy="uuid")
	@GeneratedValue(generator="systemUUID")
	@Column(length=50)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Column(length=50)
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	@Column(length=50)
	public String getBaseUserId() {
		return baseUserId;
	}
	public void setBaseUserId(String baseUserId) {
		this.baseUserId = baseUserId;
	}
	
}
