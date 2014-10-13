package com.coherentlogic.usaspending.client.core.converters;

import java.math.BigDecimal;

import com.coherentlogic.coherent.data.model.core.converters.AbstractConverter;
import com.coherentlogic.usaspending.client.core.domain.Agency;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;

/**
 * A converter for the Agency class.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class AgencyConverter extends AbstractConverter {

    public static final String ID = "id", NAME = "name", RANK = "rank";

    @Override
    public Object unmarshal(
        HierarchicalStreamReader reader,
        UnmarshallingContext context
    ) {
        String id = reader.getAttribute(ID);

        String name = reader.getAttribute(NAME);

        String rankText = reader.getAttribute(RANK);
        Long rank = Long.valueOf(rankText);

        String valueText = reader.getValue();
        BigDecimal value = new BigDecimal (valueText);

        Agency agency = new Agency ();

        agency.setId(id);
        agency.setName(name);
        agency.setRank(rank);
        agency.setValue(value);

        return agency;
    }

    @Override
    public boolean canConvert(Class type) {
        return Agency.class.equals(type);
    }
}
