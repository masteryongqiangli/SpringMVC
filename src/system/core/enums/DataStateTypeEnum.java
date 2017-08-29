package system.core.enums;
public enum DataStateTypeEnum {
	ADD_SUCCESS("0","�����ɹ�"),ADD_ERROR("1","����ʧ��"),
	SAVE_SUCCESS("0","�����ɹ�"),SAVE_ERROR("1","����ʧ��"),
	DELETE_SUCCESS("0","�����ɹ�"),DELETE_ERROR("1","����ʧ��"),
	START_SUCCESS("0","�����ɹ�"),START_ERROR("1","����ʧ��");
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
