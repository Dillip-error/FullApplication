package com.sbi.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "AUDIT_MASTER")
public class Audit {
	@Id
	@GeneratedValue
	@Column(name = "AID")
	private Integer eId;
	
	@Column(name = "FULLNAME")
	private String fullName;
	
	@Column(name = "EMAIL")
    private String email; 
	
	@Column(name = "MOBILENO")
    private Long mobile;
	
	@Column(name = "CITY")
    private String city;

	@Column(name = "GENDER")
    private String gender;
	
	@Column(name = "DEPARTMENT")
    private String department;
    
//	@Temporal(TemporalType.DATE)
//	@Column(name = "HIREDATE")
//    private Date hireDate;
	
	@Column(name = "HIREDATE")
	private String hireDate;
	
	@Column(name = "ISPERMANENT")
    private Boolean isPermanent;
	
	
	
	
	
	
	
	
	
	
	
	
	
//	private String auditName;
//	@Column(name = "AUDITORNAME")
//	private String auditorName;
//	@Column(name = "AUDITORPASSWORD")
//	private String auditorPassword;
//	@Column(name = "AUDITBRANCH")
//	private String auditBranch;
//	@Column(name = "AUDITSTARTDATE")
//	private Date auditStartDate;
//	@Column(name = "AUDITENDDATE")
//	private Date auditEndDate;
//	@Column(name = "BANKNAME")
//	@ElementCollection
//	private List<String> bankName;
//	@Column(name = "AUDITDESCRIPTION")
//	private String auditDescription;
//	@Column(name = "AUDITRADIO")
//	private String auditRadio;
	

}
