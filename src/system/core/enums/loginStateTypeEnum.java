package system.core.enums;

public enum loginStateTypeEnum {
	NOT_USER("0","用户不存在"),PASSWORD_ERRON("1","密码错误"),LOGIN_SUCCESS("200","登录成功");
	
	private String code;
	private String msg;
	
	private loginStateTypeEnum(String code,String msg){
		this.code = code;
		this.msg = msg;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
