package model;

public class error {
private int code;
private String description;

public error(int code, String description) {
	super();
	this.code = code;
	this.description = description;
}

public int getCode() {
	return code;
}

public void setId(int code) {
	this.code = code;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}



}
