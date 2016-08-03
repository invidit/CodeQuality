package de.invidit.design.structural.bridge.external.sparkasse.v2;

import de.invidit.design.structural.bridge.model.Accounting;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Torsten Mingers
 * @since 03.08.2016
 */
public class AccountingJsonConverterTest {
    @Test
    public void convertToAccounting() throws Exception {
        AccountingJsonConverter sut = new AccountingJsonConverter();

        String accountData = createAccountDataAsJson();
        List<Accounting> accountings = sut.convertToAccounting(accountData);

        assertThat(accountings).hasSize(1);
        Accounting accounting = accountings.get(0);
        assertThat(accounting.getAbsender()).isEqualTo("Max Mustermann");
        assertThat(accounting.getEmpfaenger()).isEqualTo("Sparkasse V2");
        assertThat(accounting.getSollHabenKennzeichen()).isEqualTo('S');
        assertThat(accounting.getBetrag()).isEqualTo(447.25);
        assertThat(accounting.getText()).isEqualTo("Miete");
    }

    private String createAccountDataAsJson() {
        return "{ \"Absender\" : \"Max Mustermann\","
                + "\"Empfaenger\" : \"Sparkasse V2\","
                + "\"SollHabenKennzeichen\" : \"S\","
                + "\"Betrag\" : 447.25,"
                + "\"Text\" : \"Miete\" }";
    }
}