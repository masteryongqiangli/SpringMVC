package system.web.entity.menu;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="Sys_BaseMenu")
public class Sys_BaseMenu {
	private String menuID;
	private String menuName;
	private String menuUrl;
	private String parentMenuID;
	private Integer orderNum;
	private Integer state;
	@Id
	@Column(length=50)
	@GenericGenerator(name="systemUUID",strategy="uuid")
	@GeneratedValue(generator="systemUUID")
	public String getMenuID() {
		return menuID;
	}
	public void setMenuID(String menuID) {
		this.menuID = menuID;
	}
	@Column(length=50)
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	@Column(length=50)
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	@Column(length=50)
	public String getParentMenuID() {
		return parentMenuID;
	}
	public void setParentMenuID(String parentMenuID) {
		this.parentMenuID = parentMenuID;
	}
	@Column(length=50)
	public Integer getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	@Column(length=50)
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
}
