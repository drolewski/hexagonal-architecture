package com.drolewski.hexagonarc.domain.model.aggregate;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class InvoiceItemTest {

    @Test
    void should_calculate_amount() {
        // given
        // when
        final var invoiceItem = new InvoiceItem("description", BigDecimal.ONE, BigDecimal.TEN);
        // then
        assertThat(invoiceItem.amount()).isEqualTo(BigDecimal.TEN.multiply(BigDecimal.ONE));
    }

}