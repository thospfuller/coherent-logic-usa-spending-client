package com.coherentlogic.usaspending.client.core.converters;

import java.math.BigDecimal;

import com.coherentlogic.coherent.data.model.core.converters.AbstractConverter;
import com.coherentlogic.usaspending.client.core.domain.FiscalYear;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;

/**
 * A converter for the FiscalYear class.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class FiscalYearConverter extends AbstractConverter {

    static final String YEAR = "year";

    public FiscalYearConverter () {
    }

    @Override
    public boolean canConvert(Class type) {
        return FiscalYear.class.equals(type);
    }

    @Override
    public Object unmarshal(
        HierarchicalStreamReader reader,
        UnmarshallingContext context
    ) {
        FiscalYear fiscalYear = new FiscalYear ();

        String year = reader.getAttribute(YEAR);

        fiscalYear.setYear(year);

        String textValue = reader.getValue();

        BigDecimal value = new BigDecimal(textValue);

        fiscalYear.setValue(value);

        return fiscalYear;
    }
}
