package com.sbi.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbi.entity.Audit;

public interface AuditRepo 
             extends JpaRepository<Audit,Serializable>{

}
