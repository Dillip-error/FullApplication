package com.sbi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbi.entity.Audit;
import com.sbi.repository.AuditRepo;

@Service
public class AuditServiceImpl implements IAuditService{
	
	@Autowired
	private AuditRepo repo;

	@Override
	public Integer saveAuditInfo(Audit audit) {
		Audit save = repo.save(audit);
		return save.getAId() ;
	}

	@Override
	public List<Audit> getAllAuditInfo() {
		return repo.findAll();
	}
	
	@Override
	public Optional<Audit> getOneAuditDetails(Integer id) {
		return repo.findById(id);
	}

	@Override
	public void deleteAuditByAid(Integer aId) {
		repo.deleteById(aId);
	}

	@Override
	public void updateAudit(Audit audit) {
		repo.save(audit);
	}
	
	@Override
	public boolean isAuditIdExit(Integer id) {
		return repo.existsById(id);
	}

}
