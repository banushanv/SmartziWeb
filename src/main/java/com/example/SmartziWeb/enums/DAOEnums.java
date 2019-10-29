package com.example.SmartziWeb.enums;

import java.util.HashMap;
import java.util.Map;

public enum DAOEnums {
	
	NO_DATA(1012,"No Entity Exists"),
	ALREADY_EXIST(1013,"Entity Already Exists"),
	FAILED(1002, "Transaction is Failed"),
	EXCEPTION(1015, "Exception thrown in Operation. Please contact support");
	
	private Integer code;	
	private String message;
	
	/**
     * A mapping between the integer code and its corresponding text to facilitate lookup by code.
     */
	private static Map<Integer, DAOEnums> valueToTextMapping;
	
	private DAOEnums(Integer code, String message) {
		this.message = message;
		this.code = code;
	}
	
    public static DAOEnums getCustomerException(Integer i){
        if(valueToTextMapping == null){
            initMapping();
        }
        return valueToTextMapping.get(i);
    }

    private static void initMapping(){
        valueToTextMapping = new HashMap<>();
        for(DAOEnums s : values()){
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
