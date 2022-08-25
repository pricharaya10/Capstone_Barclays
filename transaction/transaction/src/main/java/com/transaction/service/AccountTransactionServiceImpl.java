package com.transaction.service;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.logging.Logger;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import com.transaction.entity.AccountTransaction;

public class AccountTransactionServiceImpl {
	
	private static final Logger log = getLogger(CsvExportService.class);

    private AccountRepository accountRepository;


    public void CsvExportService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    private static Logger getLogger(Class<CsvExportService> class1) {
		// TODO Auto-generated method stub
		return null;
	}

	public void writeEmployeesToCsv(Writer writer) {
			

        List<AccountTransaction> accounts = accountRepository.findAll();
        
        try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
            
        	for (AccountTransaction account : accounts) {
                System.out.println(account);
        		csvPrinter.printRecord(account.getSequenceId(), account.getTransactionRef(), account.getDate(), account.getTime(), account.getAmount(),account.getType(),account.getDescription(),account.getBillRefNumber());
            }
        
        } catch (IOException e) {
        	System.out.println("Unable to Download CSV");
            e.printStackTrace();
        }
    }

}