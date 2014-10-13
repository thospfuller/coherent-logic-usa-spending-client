/* This example, which is written in Groovy script, sends a request to the
 * following URI:
 *
 * http://...
 */

import com.coherentlogic.usaspending.client.core.domain.Summary
import com.coherentlogic.usaspending.client.core.builders.Detail

return queryBuilder
    .fsrs()
    .setFiscalYear("2000")
    .setStateCode("TX")
    .setDetail(Detail.summary)
    .setMaxRecords(500)
    .doGet(Summary.class);