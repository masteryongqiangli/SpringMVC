package system.core.enums;

public enum ValidTypeEnum {
	USER_EXIST("0","用户已存在");
	private String code;
	private String name;
	private ValidTypeEnum(String name,String code){
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
