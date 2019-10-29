package com.example.SmartziWeb.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.SmartziWeb.model.dto.UserDto;


@Service
public interface UserService {
	


	//public List<AgreementType> getAgreementType(Integer agreementCode );

//	public SuccessResponse addAgreementType(AgreementType argType);

//	public void deleteAgreementType(String id);

//	public AgreementType updateAgreementType(AgreementType agrType, String id);
	


	public ResponseEntity userRegister(UserDto argType);
	
	

	public ResponseEntity getUsersLogin(String Email,String Password);

//	AgreementType updateAgreementType(AgreementType argType, int id, int version);

//	boolean checkWhetherAgreementIsexists(String agreementId,String product, String subType,
//			String typeOfDocument, LocalDate effetiveDate, String agreementText);
}
