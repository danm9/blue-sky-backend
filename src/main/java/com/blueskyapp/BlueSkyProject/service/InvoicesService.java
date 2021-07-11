package com.blueskyapp.BlueSkyProject.service;

import com.blueskyapp.BlueSkyProject.model.Invoices;
import com.blueskyapp.BlueSkyProject.repository.InvoicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.transaction.Transactional;
@Service
@Transactional
public class InvoicesService {
    @Autowired
    private InvoicesRepository invoicesRepository;
    public List<Invoices> listAllInvoices() {
        return invoicesRepository.findAll();
    }

    public void saveInvoices(Invoices invoices) {
    	invoicesRepository.save(invoices);
    }

    public Invoices getInvoices(Integer invoiceId) {
        return invoicesRepository.findById(invoiceId).get();
    }

    public void deleteInvoices(Integer invoiceId) {
    	invoicesRepository.deleteById(invoiceId);
    }
}
