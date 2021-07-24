package com.blueskyapp.BlueSkyProject.controller;

import com.blueskyapp.BlueSkyProject.model.Invoices;
import com.blueskyapp.BlueSkyProject.service.InvoicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/invoices")
public class InvoicesController {
    @Autowired
    InvoicesService invoicesService;
    
    @CrossOrigin(origins = "https://blueskyappv1.herokuapp.com/")
    @GetMapping("")
    public List<Invoices> list() {
        return invoicesService.listAllInvoices();
    }
    
    @CrossOrigin(origins = "https://blueskyappv1.herokuapp.com/")
    @GetMapping("/{invoicesId}")
    public ResponseEntity<Invoices> get(@PathVariable Integer invoiceId) {
        try {
        	Invoices invoices = invoicesService.getInvoices(invoiceId);
            return new ResponseEntity<Invoices>(invoices, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Invoices>(HttpStatus.NOT_FOUND);
        }
    }
    
    @CrossOrigin(origins = "https://blueskyappv1.herokuapp.com/")
    @PostMapping("/")
    public void add(@RequestBody Invoices invoices) {
    	invoicesService.saveInvoices(invoices);
    }
    
    @PutMapping("/{invoiceId}")
    public ResponseEntity<?> update(@RequestBody Invoices invoices, @PathVariable Integer invoiceId) {
        try {
        	Invoices existInvoices = invoicesService.getInvoices(invoiceId);
        	invoices.setInvoiceId(invoiceId);
        	invoicesService.saveInvoices(invoices);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{invoiceId}")
    public void delete(@PathVariable Integer invoiceId) {

    	invoicesService.deleteInvoices(invoiceId);
    }
}
