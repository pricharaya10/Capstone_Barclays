package com.transaction.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;

import com.transaction.entity.Bill;
import com.transaction.entity.Master_bill;

public interface BillService extends JpaRepository<Bill,Long>{
	
	
	@Query("select p from Bill p where p.status = ?1")
    List<Bill> getPendingBill(String status);
	
	@Query("select p from Bill p where p.billerCode = ?1")
    List<Bill> getSelectedBiller(long billerCode);
	
	@Modifying
	@Transactional
	@Query("update Bill p set p.status='PAID' where billSequenceId=?1")
	void changeBillStatus(long billSequenceId);
	
	int x=50;
	@Modifying
	@Transactional
	@Query(value="insert into Account_Transaction(sequence_id,amount,bill_ref_number,date,description,time,transaction_ref,type) values (?2,(select amount from Bill where bill_sequence_id=?1),1234,'12/02/22','Mobile','12:03:05',1234567,'Debit')",nativeQuery = true)
	void update_account_transaction(long billSequenceId,int x);
	
	@Query("select b from Bill b where due_date='25/10/22' or due_date='26/10/22' or due_date='27/10/22'")
	List<Bill> autoPay();
	
	
}
