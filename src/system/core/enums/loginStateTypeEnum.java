package system.core.enums;

public enum loginStateTypeEnum {
	NOT_USER("0","�û�������"),PASSWORD_ERRON("1","�������"),LOGIN_SUCCESS("200","��¼�ɹ�");
	
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
