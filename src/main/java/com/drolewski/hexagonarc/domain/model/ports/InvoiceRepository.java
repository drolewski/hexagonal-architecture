package com.drolewski.hexagonarc.domain.model.ports;

import com.drolewski.hexagonarc.domain.model.aggregate.Invoice;

public interface InvoiceRepository {
    void save(final Invoice invoice);
}
