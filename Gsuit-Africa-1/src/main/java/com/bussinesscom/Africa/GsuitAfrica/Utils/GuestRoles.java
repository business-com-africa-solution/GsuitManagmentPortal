package com.bussinesscom.Africa.GsuitAfrica.Utils;

import com.bussinesscom.Africa.GsuitAfrica.Entity.RoleAccess;

public class GuestRoles {

	public static RoleAccess getRoleAccessGuest() {

		RoleAccess rolesAcesses = new RoleAccess();	
		rolesAcesses.setSignature(false);
		rolesAcesses.setCreateSignature(false);
		rolesAcesses.setUpdateSignature(false);
		rolesAcesses.setDeleteSignature(false);
		rolesAcesses.setMaildelegation(false);
		rolesAcesses.setCreateMailDelegation(false);
		rolesAcesses.setUpdateMailDelegation(false);
		rolesAcesses.setDeleteMailDelegation(false);
		rolesAcesses.setDriveAnalysis(false);
		rolesAcesses.setCreateDriveAnalysis(false);
		rolesAcesses.setUpdateDriveAnalysis(false);
		rolesAcesses.setDeleteDriveAnalysis(false);
		rolesAcesses.setCalenderApointment(false);
		rolesAcesses.setCreateCalenderApointment(false);
		rolesAcesses.setUpdateCalenderApointment(false);
		rolesAcesses.setDeleteCalenderApointment(false);
		rolesAcesses.setEmailAnalysis(false);
		rolesAcesses.setCreateEmailAnalysis(false);
		rolesAcesses.setUpdateEmailAnalysis(false);
		rolesAcesses.setDeleteEmailAnalysis(false);
		rolesAcesses.setUserManegment(false);
		rolesAcesses.setCreateUserManagment(false);
		rolesAcesses.setUpdateUserManagment(false);
		rolesAcesses.setDeleteUserManagment(false);
		rolesAcesses.setHr(false);
		rolesAcesses.setCreateHr(false);
		rolesAcesses.setUpdateHr(false);
		rolesAcesses.setDeleteHr(false);
		rolesAcesses.setBilling(false);
		rolesAcesses.setCreateBilling(false);
		rolesAcesses.setUpdateBilling(false);
		rolesAcesses.setDeleteBilling(false);
		
		
		return rolesAcesses;
		

	}
}
