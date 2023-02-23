package com.drolewski.hexagonarc.infrastructure.invoices.repository;

import com.drolewski.hexagonarc.domain.model.aggregate.Invoice;
import com.drolewski.hexagonarc.domain.model.ports.InvoiceRepository;
import org.springframework.stereotype.Component;

@Component
public class MongoInvoiceRepository implements InvoiceRepository {
    @Override
    public void save(final Invoice invoice) {
        System.out.println("save invoice in database");
    }
}
