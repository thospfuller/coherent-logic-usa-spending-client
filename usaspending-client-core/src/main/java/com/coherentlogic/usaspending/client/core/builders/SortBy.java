package com.coherentlogic.usaspending.client.core.builders;

import static com.coherentlogic.usaspending.client.core.util.Constants.BY_CFDA_PROGRAM;
import static com.coherentlogic.usaspending.client.core.util.Constants.BY_CONTRACTOR_OR_RECIPIENT_NAME;
import static com.coherentlogic.usaspending.client.core.util.Constants.BY_DATE_OF_AWARD;
import static com.coherentlogic.usaspending.client.core.util.Constants.BY_DOLLARS_OF_AWARDS_IN_DECENDING_ORDER;
import static com.coherentlogic.usaspending.client.core.util.Constants.BY_MAJOR_CONTRACTING_AGENCY;

/**
 * Determines how records are sorted.
 * 
 * Defaults to sort by dollars if not provided.
 * 
 * Sorting functionality is not available for the following level of details
 * (Summary, Low, and Medium) 
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public enum SortBy {

    byContractorOrRecipientName (BY_CONTRACTOR_OR_RECIPIENT_NAME),
    byDollarsOfAwardsInDecendingOrder (BY_DOLLARS_OF_AWARDS_IN_DECENDING_ORDER),
    byMajorContractingAgency (BY_MAJOR_CONTRACTING_AGENCY),
    byCFDAProgram (BY_CFDA_PROGRAM),
    byDateOfAward (BY_DATE_OF_AWARD);

    private final String value;

    SortBy (String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
