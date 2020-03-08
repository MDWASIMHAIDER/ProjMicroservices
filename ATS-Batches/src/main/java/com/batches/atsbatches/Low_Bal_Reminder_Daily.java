package com.batches.atsbatches;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.task.TaskExecutionProperties.Shutdown;
import org.springframework.stereotype.Component;

import com.batches.emailsender.EmailSender;
import com.batches.entity.BatchRunDetailsEntity;
import com.batches.entity.BatchRunSummaryEntity;
import com.batches.entity.TagMasterEntity;
import com.batches.entity.TagTransactionTriggerEntity;
import com.batches.entity.UserMasterEntity;
import com.batches.repository.BatchRunDetailRepository;
import com.batches.repository.BatchRunSummaryRepository;
import com.batches.repository.TagMasterRepository;
import com.batches.repository.TagTransactionTriggerRepository;
import com.batches.repository.UserMasterRepository;

@Component
public class Low_Bal_Reminder_Daily implements Batch{

	@Autowired
	private BatchRunDetailRepository batchRunDetailRepo; 
	@Autowired
	private TagTransactionTriggerRepository tagTriggerRepo;
	@Autowired
	private TagMasterRepository tagMasterRepo;
	@Autowired
	private UserMasterRepository userMasterRepo;
	@Autowired
	private BatchRunSummaryRepository summaryRepo;
	@Autowired
	private EmailSender emailSender;
	
	public void test() {
		preProcess();
		start();
		PostProcess();
		
	}
	
	private static Integer totalCount=0;
	private static Integer failureCount=0;
	private static Integer successCount=0;
	
	private static final String BATCH_NAME="lowBal Reminder Batch";
	
	Date date=new Date();
	java.sql.Date d= new java.sql.Date(date.getTime());  
	
	@Override
	public void start() {
		List<TagTransactionTriggerEntity> allPendingRecords = tagTriggerRepo.findAllPendingRecords("LOW BAL", "P","FAILED");
		totalCount=allPendingRecords.size();
		/*allPendingRecords.forEach(pendingRecords->{
			long startTime = System.currentTimeMillis();
			Integer tagId = pendingRecords.getTAG_ID();
			System.out.println(pendingRecords);
			System.out.println(tagId);
			//Integer findByTAG_ID=null;
			//try {
			Integer userId = tagMasterRepo.findById(tagId);
			//}catch(Exception e) {
			//	e.printStackTrace();
			//}
			  //System.out.println(findByTAG_ID);
			 Optional<UserMasterEntity> optional = userMasterRepo.findById(userId);
			 if(optional.isPresent()) {
				 UserMasterEntity userMasterEntity = optional.get();
				 String email_ID = userMasterEntity.getEMAIL_ID();
				 Long mobile_NUM = userMasterEntity.getMOBILE_NUM();
				 process(email_ID,mobile_NUM,pendingRecords.getTRG_ID());
			 }
			 long endTime = System.currentTimeMillis();
			 long duration = (endTime - startTime);
			 System.out.println(duration);
		});*/
			int count=40;
			ExecutorService eService=Executors.newFixedThreadPool(20);
			CompletionService pool=new ExecutorCompletionService(eService);
			allPendingRecords.forEach(pendingRecords->{
				pool.submit(new Callable<Object>() {
					public Object call() {
						long startTime = System.currentTimeMillis();
						Integer tagId = pendingRecords.getTAG_ID();

						Integer userId = tagMasterRepo.findById(tagId);
						 Optional<UserMasterEntity> optional = userMasterRepo.findById(userId);
						 if(optional.isPresent()) {
							 UserMasterEntity userMasterEntity = optional.get();
							 String email_ID = userMasterEntity.getEMAIL_ID();
							 Long mobile_NUM = userMasterEntity.getMOBILE_NUM();
							 process(email_ID,mobile_NUM,pendingRecords.getTRG_ID());
						 }
						 long endTime = System.currentTimeMillis();
						 long duration = (endTime - startTime);
						 System.out.println(duration);
					
						
						return null;
						
							
					}
					
				});
				
			});
				
		}
	

	@Override
	public void preProcess() {

		BatchRunDetailsEntity entity=new BatchRunDetailsEntity();
		entity.setBATCH_NAME(BATCH_NAME);
		entity.setRUN_STATUS("start");
		entity.setSTART_DT(date);
		entity.setCREATED_BY(BATCH_NAME);
		BatchRunDetailsEntity batchRunDetailsEntity = batchRunDetailRepo.save(entity);
		Integer run_ID = batchRunDetailsEntity.getRUN_ID();
		
	}

	@Override
	@Transactional
	public void process(String email,Long phone,Integer trgId) {
		try {
			emailSender.sendEmail(email);
			tagTriggerRepo.updateTagTxTriggerEntity("success","C",BATCH_NAME,trgId);
			successCount++;
		}
		catch(Exception e) {
			e.printStackTrace();
			failureCount++;
		}
		
		
	}

	@Override
	public void PostProcess() {
		String dtls="Total Record= "+ totalCount +"Success Record= "+ successCount +"Failure Record ="+ failureCount;
		BatchRunSummaryEntity entity=new BatchRunSummaryEntity();
		entity.setBATCH_NAME(BATCH_NAME);
		entity.setUPDATED_BY(BATCH_NAME);
		entity.setRUN_STATUS("Ended");
		entity.setSUMMARY_DTLS(dtls);
		summaryRepo.save(entity);
		
		
	}
	

	
}
