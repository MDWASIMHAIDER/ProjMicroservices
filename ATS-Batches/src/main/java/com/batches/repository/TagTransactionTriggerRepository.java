package com.batches.repository;

import java.io.Serializable;
import java.lang.annotation.Native;
import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.batches.entity.TagTransactionTriggerEntity;

@Repository
public interface TagTransactionTriggerRepository extends JpaRepository<TagTransactionTriggerEntity,Serializable>{
	
	//@Native("select *from TagTransactionTriggerEntity where TX_FAILURE_RSN=:failReason and REMINDER_MSG_SW=:reminderSw and TX_STATUS=:status")
	@Query(
			  value = "SELECT * from Tag_Transaction_Trigger_Entity where tx_failure_rsn='LOW BAL' and reminder_msg_sw='P'  and tx_status='FAILED'", 
			  nativeQuery = true)
	//@Query("select *from TagTransactionTriggerEntity where TX_FAILURE_RSN=:failReason and REMINDER_MSG_SW=:reminderSw and TX_STATUS=:status")
	public List<TagTransactionTriggerEntity> findAllPendingRecords(String failReason,String reminderSw,String status);
	
	@Modifying
	@Transactional
	@Query("update TagTransactionTriggerEntity set TX_STATUS=:txStatus,REMINDER_MSG_SW=:rmsgSw,UPDATED_BY=:updatedBy where TRG_ID=:trgId")
	public Integer updateTagTxTriggerEntity(String txStatus,String rmsgSw,String updatedBy ,Integer trgId );
}
