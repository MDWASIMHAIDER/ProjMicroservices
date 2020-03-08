package com.batches.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.stereotype.Service;

import com.batches.entity.TagTransactionTriggerEntity;
import com.batches.entity.UserMasterEntity;

@Service
public class Low_Bal_Reminder_Service {

	/*@Override
	public void start() {
		List<TagTransactionTriggerEntity> allPendingRecords = tagTriggerRepo.findAllPendingRecords("LOW BAL", "P","FAILED");
		totalCount=allPendingRecords.size();
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
			
	}*/
}
