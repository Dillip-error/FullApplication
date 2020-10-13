package com.sbi.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
	private Integer aId;
	@Column(name = "AUDITNAME")
	private String auditName;
	@Column(name = "AUDITORNAME")
	private String auditorName;
	@Column(name = "AUDITORPASSWORD")
	private String auditorPassword;
	@Column(name = "AUDITBRANCH")
	private String auditBranch;
	@Column(name = "AUDITSTARTDATE")
	private Date auditStartDate;
	@Column(name = "AUDITENDDATE")
	private Date auditEndDate;
	@Column(name = "BANKNAME")
	@ElementCollection
	private List<String> bankName;
	@Column(name = "AUDITDESCRIPTION")
	private String auditDescription;
	@Column(name = "AUDITRADIO")
	private String auditRadio;
	

}
