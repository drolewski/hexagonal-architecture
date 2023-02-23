package com.drolewski.hexagonarc.application.events.invoices.issued;

import com.drolewski.hexagonarc.application.events.Event;
import com.drolewski.hexagonarc.application.events.EventName;
import com.drolewski.hexagonarc.domain.model.aggregate.Invoice;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Getter
@ToString
@NoArgsConstructor
public final class InvoiceIssuedEvent extends Event implements Serializable {
    private String invoiceId;

    public InvoiceIssuedEvent(final Invoice invoice) {
        super(EventName.INVOICE_ISSUED);
        this.invoiceId = invoice.getId();
    }

}
