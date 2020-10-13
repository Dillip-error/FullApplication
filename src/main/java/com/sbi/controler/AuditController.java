package com.sbi.controler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbi.entity.Audit;
import com.sbi.service.IAuditService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/audit")
@CrossOrigin(origins = "*")
@Api(value = "AuditRestController",description = "This Controller For HOA  Details")
public class AuditController {
	
	@Autowired
	private IAuditService service;
	
	
	//1. save one AuditDetails
		@PostMapping(value="/save", produces = {"application/json",
                                                                              "application/xml"},
                                                          consumes = {"application/json",
                                                                               "application/xml"})
		@ApiOperation(value = "Save Audit Status")
		
		public ResponseEntity<String> saveAuditData(
				@RequestBody Audit audit)
		{
			ResponseEntity<String> resp=null;
			try {
				//if Audit Id exist
				if(audit.getAId()!=null 
						&& service.isAuditIdExit(audit.getAId())
						)
				{
					resp = new ResponseEntity<String>(
							"Given Id '"+audit.getAId()+"' Data already exist",
							HttpStatus.BAD_REQUEST);

				} else { //Audit id not exist
					Integer id=service.saveAuditInfo(audit);
					resp = new ResponseEntity<String>(
							"Audit '"+id+"' created Successfully!",
							HttpStatus.OK //200
							//HttpStatus.CREATED //201
							);
				}

			} catch (Exception e) {
				resp = new ResponseEntity<String>(
						"Unable to Save Audit Details",
						HttpStatus.INTERNAL_SERVER_ERROR //Our App Got Exception
						);
				e.printStackTrace();
			}
			return resp;
		}

		//2. Get One Audit by Id
		@GetMapping("/one/{id}")
		public ResponseEntity<?> getOneAuditDetails(
				@PathVariable Integer aId)
		{
			ResponseEntity<?>  resp = null;
			try {
				//communicate with DB using ID with Serivce Layer
				Optional<Audit> opt = service.getOneAuditDetails(aId);
				
				if(opt.isPresent()) { //if Audit exist
					Audit audit = opt.get();
					resp = new ResponseEntity<Audit>(
							audit,
							HttpStatus.OK);
					
				} else { //if Audit not exist
					resp = new ResponseEntity<String>(
							"Audit '"+aId+"' Not exist!",
							HttpStatus.BAD_REQUEST);
				}
				
			} catch (Exception e) {
				resp = new ResponseEntity<String>(
						"Unable to fetch Audit Details", 
						HttpStatus.INTERNAL_SERVER_ERROR);
				e.printStackTrace();
			}
			
			return resp;
		}
		
		//3. Get All Audit Details
		@GetMapping("/all")
		@ApiOperation(value = "Get All Audit")
		@ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "not authorized!"), 
	            @ApiResponse(code = 403, message = "forbidden!!!"),
	            @ApiResponse(code = 404, message = "not found!!!") })
	 
		public ResponseEntity<?> getAllAuditDetails() {
			ResponseEntity<?> resp = null;
			try {
				
				List<Audit> list = service.getAllAuditInfo();
				resp = new ResponseEntity<List<Audit>>(list,HttpStatus.OK);
				
			} catch (Exception e) {
				resp = new ResponseEntity<String>(
						"Unable to fetch Audits", 
						HttpStatus.INTERNAL_SERVER_ERROR);
				e.printStackTrace();
			}
			return resp;
		}

		//4. update Audit
		@PutMapping("/modify")
		public ResponseEntity<String> updateAudit(
				@RequestBody Audit audit) 
		{
			ResponseEntity<String> resp = null;
			try {
				//if audit exist - then update
				if(audit.getAId()!=null 
						&& service.isAuditIdExit(audit.getAId())
						)
				{
					service.updateAudit(audit);
					resp = new ResponseEntity<String>(
							"Audit '"+audit.getAId()+"' Updated!",
							HttpStatus.OK);
					
				} else {
					//if Audit not exist - return error message
					resp = new ResponseEntity<String>(
							"Product '"+audit.getAId()+"' not exist!",
							HttpStatus.BAD_REQUEST);
				}
				
			} catch (Exception e) {
				resp = new ResponseEntity<String>(
						"Unable to update AuditDetails", 
						HttpStatus.INTERNAL_SERVER_ERROR);
				e.printStackTrace();
			}
			
			return resp;
		}
		

		//5. Delete one audit
		@DeleteMapping("/remove/{id}")
		public ResponseEntity<String> removeAudit(
				@PathVariable Integer id) 
		{ 
			ResponseEntity<String> resp  = null;
			try {
				//if Audit exist based on Id - DELETE call
				if(service.isAuditIdExit(id)) {
					service.deleteAuditByAid(id);;
					resp = new ResponseEntity<String>(
							"Audit '"+id+"' Deleted!",
							HttpStatus.OK);
				} else {
					//if given Audit id not exist
					resp = new ResponseEntity<String>(
							"Audit '"+id+"' not exist",
							//HttpStatus.NOT_FOUND
							HttpStatus.BAD_REQUEST
							);
				}
			} catch (Exception e) {
				resp = new ResponseEntity<String>(
						"Unable to Delete Audit", 
						HttpStatus.INTERNAL_SERVER_ERROR);
				e.printStackTrace();
			}
			
			return resp;
		}

}
