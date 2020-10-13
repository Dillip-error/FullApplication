package com.sbi.service;

import java.util.List;
import java.util.Optional;

import com.sbi.entity.Audit;


public interface IAuditService {
	
	public Integer saveAuditInfo(Audit audit);
	public List<Audit> getAllAuditInfo();
	public void deleteAuditByAid(Integer aId);
	public void updateAudit(Audit audit);
	public boolean isAuditIdExit(Integer id);
	public Optional<Audit> getOneAuditDetails(Integer id);

}
