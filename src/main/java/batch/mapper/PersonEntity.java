package batch.mapper;

public class PersonEntity {
	private String number;
	private String name;
	private String third;
	private String idNum;
	private String dateBegin;
	private String dateEnd;
	private String pc;
	public void setNumber(String number) {
		this.number = number;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setThird(String third) {
		this.third = third;
	}
	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}
	public void setDateBegin(String dateBegin) {
		this.dateBegin = dateBegin;
	}
	public void setDateEnd(String dateEnd) {
		this.dateEnd = dateEnd;
	}
	public void setPc(String pc) {
		this.pc = pc;
	}
	public String getNumber() {
		return number;
	}
	public String getName() {
		return name;
	}
	public String getThird() {
		return third;
	}
	public String getIdNum() {
		return idNum;
	}
	public String getDateBegin() {
		return dateBegin;
	}
	public String getDateEnd() {
		return dateEnd;
	}
	public String getPc() {
		return pc;
	}
	@Override
	public String toString() {
		return "PersonEntity [number=" + number + ", name=" + name + ", idNum=" + idNum + "]";
	}
	
}
