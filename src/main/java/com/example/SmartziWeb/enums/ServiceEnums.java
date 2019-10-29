package com.example.SmartziWeb.enums;

import java.util.HashMap;
import java.util.Map;

public enum ServiceEnums {
	
	NO_DATA(1000, "Content Null"),
	NO_FOREIGN_ID(1001, "Foreign Key Null"),
	NO_ID(1002, "Entity Id is Empty"),
	INVALID_INPUT(1050, "Unsuitable Data");
//	FAILED(1002, "Transaction is Failed"),
//	EXCEPTION(1003, "Exception thrown in Operation. Please contact support");
	
	private Integer code;	
	private String message;
	
	/**
     * A mapping between the integer code and its corresponding text to facilitate lookup by code.
     */
	private static Map<Integer, ServiceEnums> valueToTextMapping;
	
	private ServiceEnums(Integer code, String message) {
		this.message = message;
		this.code = code;
	}
	
    public static ServiceEnums getCustomerException(Integer i){
        if(valueToTextMapping == null){
            initMapping();
        }
        return valueToTextMapping.get(i);
    }

    private static void initMapping(){
        valueToTextMapping = new HashMap<>();
        for(ServiceEnums s : values()){
            valueToTextMapping.put(s.code, s);
        }
    }

	
	public String getTxnTypes() {
		return message;
	}

	public Integer getCode() {
		return code;
	}

}
