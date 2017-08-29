package system.core.enums;
public enum DataStateTypeEnum {
	ADD_SUCCESS("0","新增成功"),ADD_ERROR("1","新增失败"),
	SAVE_SUCCESS("0","新增成功"),SAVE_ERROR("1","新增失败"),
	DELETE_SUCCESS("0","新增成功"),DELETE_ERROR("1","新增失败"),
	START_SUCCESS("0","新增成功"),START_ERROR("1","新增失败");
	private String code;
	private String name;
	private DataStateTypeEnum(String code,String name){ 
		this.code = code;
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
