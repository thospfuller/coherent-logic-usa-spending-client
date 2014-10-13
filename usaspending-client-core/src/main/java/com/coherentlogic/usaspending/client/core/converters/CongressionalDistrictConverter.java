package com.coherentlogic.usaspending.client.core.converters;

import static com.coherentlogic.coherent.data.model.core.util.Constants.ID;

import java.math.BigDecimal;

import com.coherentlogic.coherent.data.model.core.converters.AbstractConverter;
import com.coherentlogic.usaspending.client.core.domain.CongressionalDistrict;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;

/**
 * A converter for the CongressionalDistrict class.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class CongressionalDistrictConverter
    extends AbstractConverter {

    private static final String
        RANK = "rank",
        TOTAL_OBLIGATED_AMOUNT = "total_obligatedAmount";

    public CongressionalDistrictConverter () {
    }

    @Override
    public boolean canConvert(Class type) {
        return CongressionalDistrict.class.equals(type);
    }

    @Override
    public Object unmarshal(
        HierarchicalStreamReader reader,
        UnmarshallingContext context
    ) {
        CongressionalDistrict congressionalDistrict
            = new CongressionalDistrict ();

        String id = reader.getAttribute(ID);

        congressionalDistrict.setId(id);

        String totalObligatedAmount =
            reader.getAttribute(TOTAL_OBLIGATED_AMOUNT);

        congressionalDistrict.setTotaObligatedAmount(
            new BigDecimal (totalObligatedAmount));

        String rank = reader.getAttribute(RANK);

        congressionalDistrict.setRank(Long.valueOf (rank));

        String value = reader.getValue();

        congressionalDistrict.setValue(value);

        return congressionalDistrict;
    }
}
