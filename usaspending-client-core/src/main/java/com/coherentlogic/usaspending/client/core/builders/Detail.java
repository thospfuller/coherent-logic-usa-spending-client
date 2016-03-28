package com.coherentlogic.usaspending.client.core.builders;

import static com.coherentlogic.usaspending.client.core.util.Constants.BASIC;
import static com.coherentlogic.usaspending.client.core.util.Constants.COMPLETE;
import static com.coherentlogic.usaspending.client.core.util.Constants.LOW;
import static com.coherentlogic.usaspending.client.core.util.Constants.MEDIUM;
import static com.coherentlogic.usaspending.client.core.util.Constants.SUMMARY;

/**
 * Enumeration of detail options available in this framework.
 *
 * @see https://www.usaspending.gov/data#
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public enum Detail {

    /**
     * Summary
     *
     * The output XML for this level of detail includes general information such
     * as the totals, the extent of competition, top 5 products or services
     * sold, top 5 purchasing agencies, top 10 contractors etc.
     *
     * @see <a href="https://www.usaspending.gov/fpds/fpds.php?fiscal_year=2009&
     *  stateCode=TX&detail=s&max_records=10">XML Example</a>
     * @see <a href="https://www.usaspending.gov/schemas/fpds_summary.xsd">XML
     *  Schema Definition</a>
     */
    summary (SUMMARY),

    /**
     * Low (list of contractors)
     *
     * The output XML for this level of detail includes a list of contractors
     * with contractor names, parent company names and total amounts for each
     * contractor.
     *
     * @see <a href="https://www.usaspending.gov/fpds/fpds.php?fiscal_year=2009&
     *  stateCode=TX&detail=l&max_records=10">XML Example</a>
     * @see <a href="https://www.usaspending.gov/schemas/
     *  fpds_listofrecipients.xsd">XML Schema Definition</a>
     */
    low (LOW),

    /**
     * Medium (contractor profiles)
     *
     * The output XML for this level of detail includes a list of the same
     * contractors as for the low level of details but provides significantly
     * more data for each contractor.
     *
     * @see <a href="https://www.usaspending.gov/fpds/fpds.php?fiscal_year=2009&
     *  stateCode=TX&detail=m&max_records=10">XML Example</a>
     * @see <a href="https://www.usaspending.gov/schemas/
     *  fpds_listofrecipients.xsd">XML Schema Definition</a>
     */
    medium (MEDIUM),

    /**
     * Basic
     *
     * The output XML for this level of detail includes a list of individual
     * transactions. As with the low level of detail, there is only a few fields
     * for each transaction (amount,major agency, date and product/service etc).
     *
     * @see <a href="https://www.usaspending.gov/fpds/fpds.php?fiscal_year=2009&
     *  stateCode=TX&detail=b&max_records=10">XML Example</a>
     * @see <a href="https://www.usaspending.gov/schemas/PrimeBasicContracts.xsd"
     *  >XML Schema Definition</a>
     */
    basic (BASIC),

    /**
     * Complete (all information)
     *
     * The output XML for this level of detail includes ALL the information
     * available for the given search criteria.
     *
     * Important: this level of detail outputs a very large XML document that
     * might take a while to download, it is advisable to use a lesser level of
     * detail if possible.
     *
     * @see <a href="https://www.usaspending.gov/fpds/fpds.php?fiscal_year=2009&
     *  stateCode=TX&detail=c&max_records=10">XML Example</a>
     * @see <a href="https://www.usaspending.gov/schemas/fpds_complete.xsd">XML
     *  Schema Definition</a>
     */
    complete (COMPLETE);

    private final String value;

    Detail (String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
