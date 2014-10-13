package com.coherentlogic.usaspending.client.core.builders;

import static com.coherentlogic.usaspending.client.core.util.Constants.FOR_PROFIT;
import static com.coherentlogic.usaspending.client.core.util.Constants.GOVERNMENT;
import static com.coherentlogic.usaspending.client.core.util.Constants.HIGHER_EDUCATION;
import static com.coherentlogic.usaspending.client.core.util.Constants.INDIVIDUALS;
import static com.coherentlogic.usaspending.client.core.util.Constants.NON_PROFITS;
import static com.coherentlogic.usaspending.client.core.util.Constants.OTHER;

/**
 * The type of recipient.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public enum RecipCatType {

    forProfits (FOR_PROFIT),
    government (GOVERNMENT),
    higherEducation (HIGHER_EDUCATION),
    individuals (INDIVIDUALS),
    nonprofits (NON_PROFITS),
    other (OTHER);

    private final String value;

    RecipCatType (String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
