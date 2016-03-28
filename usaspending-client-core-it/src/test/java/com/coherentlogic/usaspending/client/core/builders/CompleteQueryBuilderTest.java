package com.coherentlogic.usaspending.client.core.builders;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.client.RestTemplate;

import com.coherentlogic.usaspending.client.core.domain.Complete;
import com.coherentlogic.usaspending.client.core.domain.Doc;
import com.coherentlogic.usaspending.client.core.domain.Result;
import com.coherentlogic.usaspending.client.core.domain.SearchCriteria;
import com.coherentlogic.usaspending.client.core.domain.SearchCriterion;

/**
 * Integration test for the {@link QueryBuilder} class.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class CompleteQueryBuilderTest {

    static final String USA_SPENDING_REST_TEMPLATE_ID =
        "usaSpendingRestTemplate";

    private final ApplicationContext context
        = new FileSystemXmlApplicationContext (
            "src/test/resources/spring/complete-application-context.xml");

    /* http://www.usaspending.gov/fsrs/fsrs.php?fiscal_year=2010&detail=c
     */

    private QueryBuilder queryBuilder = null;

    private RestTemplate restTemplate = null;

    @Before
    public void setUp() throws Exception {

        restTemplate = (RestTemplate) context.getBean (
            USA_SPENDING_REST_TEMPLATE_ID);

        queryBuilder = new QueryBuilder(restTemplate);
    }

    @After
    public void tearDown() throws Exception {
        restTemplate = null;
        queryBuilder = null;
    }

    /**
     *
     * @todo The assert expected should be "DOLLARS_OBLIGATED desc" -- not sure
     *  why we're not seeing the desc part.
     */
    private void reviewSearchCriteria (SearchCriteria searchCriteria) {

        List<SearchCriterion> searchCriteriaList =
            searchCriteria.getSearchCriterionList();

        assertEquals(6, searchCriteriaList.size());

        for (SearchCriterion next : searchCriteria.getSearchCriterionList()) {
            if ("fiscal_year".equals(next.getField())) {
                assertEquals("2009", next.getValue());
            } else if ("sortby".equals(next.getField())) {
                assertEquals("OBLIGATED_AMOUNT desc", next.getValue());
            } else if ("records_from".equals(next.getField())) {
                assertEquals("0", next.getValue());
            } else if ("max_records".equals(next.getField())) {
                assertEquals("1500", next.getValue());
            }
        }
    }

    private void reviewResult (Result result) {

        long numFound = result.getNumFound();
        // These numbers change so we pick a bound and just assume the numFound
        // will be between these numbers (which means if this changes enough,
        // we'll need to change the boundary values).
        assertTrue("numFound: " + numFound,
            1000L < numFound && numFound < 9950000L);

        assertEquals(1500L, result.getMaxRecords());

        List<Doc> docList = result.getDocList();

        assertEquals(1500, docList.size());

        reviewDocList (docList, "SP070003D1380", "364124651");
    }

    /**
     * This will work however it will only return 1000 records.
     *
     * http://www.usaspending.gov/fpds/fpds.php?fiscal_year=2009&stateCode=TX&
     * detail=c&max_records=5000
     */
    @Test
//    @Ignore("Success with this test is unpredictable.")
    public void testMaxRecordsSetAbove1000 () {
        Complete complete =
            queryBuilder
                .fsrs()
                .setFiscalYear("2009")
                .setStateCode("TX")
                .setDetail(Detail.complete)
                .setMaxRecords(1500)
                .doGet(Complete.class);

        SearchCriteria searchCriteria =
            complete.getSearchCriteria();
        Result result = complete.getResult();

        reviewSearchCriteria (searchCriteria);
        reviewResult(result);
    }

    /**
     * The docList is not always ordered.
     */
    static Doc findByPrimeAwardPIIDAndSubcontactorDUNSNumber (
        List<Doc> docList,
        String primeAwardPIID,
        String subcontactorDUNSNumber
    ) {

        Doc result = null;

        for (Doc next : docList)
            if (primeAwardPIID.equals(next.getPrimeAwardPIID ())
                &&
                subcontactorDUNSNumber.equals(next.getSubcontactorDUNSNumber ())
            ) {
                result = next;
                break;
            }

        return result;
    }

    /* The doc list can change so if this starts to fail then first see if the previous doc is still available in the
     * docList and, if it's not there then just pick a new one and test against that.
     */
    static void reviewDocList (List<Doc> docList, String primeAwardPIID, String subcontactorDUNSNumber) {
        Doc doc = findByPrimeAwardPIIDAndSubcontactorDUNSNumber (
            docList, primeAwardPIID, subcontactorDUNSNumber);

        assertNotNull(doc);

        assertEquals (primeAwardPIID, doc.getPrimeAwardPIID ());
        assertNotNull (doc.getPrimeAwardIDVPIID ());
        assertNotNull (doc.getPrimeAwardDateSubmitted ());
        assertNotNull (doc.getPrimeAwardAmount ());
        assertNotNull (doc.getPrimeAwardDateSigned ());
        assertNotNull (doc.getPrimeAwardProgramTitle ());
        assertNotNull (doc.getPrimeAwardProgramSourceAgency ());
        assertNotNull (doc.getPrimeAwardProgramSourceAccount ());
        assertNull (doc.getProgramSourceSubAccount ());
        assertNotNull (doc.getPrimeAwardAgencyId ());

        assertNotNull (doc.getPrimeAwardIDVAgencyId ());
        assertNotNull (doc.getPrimeAwardContractingMajorAgency ());
        assertNotNull (doc.getPrimeAwardFundingMajorAgencyName ());
        assertNotNull (doc.getSubcontactorDUNSNumber ());
        assertNotNull (doc.getSubcontractorName ());
        assertNotNull (doc.getSubcontractorStreet ());
        assertNotNull (doc.getSubcontractorCity ());
        assertNotNull (doc.getSubcontractorState ());

        assertNotNull (doc.getSubcontractorZipCode ());
        assertNotNull (doc.getSubcontractorCongressionalDistrict ());
        assertNotNull (doc.getSubcontractPrincipalPlaceCity ());
        assertNotNull (doc.getSubcontractPrincipalPlaceZip ());
        assertNotNull (doc.getSubcontractPrincipalPlaceDistrict ());
        assertNotNull (doc.getSubcontractAmount ());
        assertNotNull (doc.getSubcontractDate ());
        assertNotNull (doc.getSubcontractPrincipalNAICSCode ());
        assertNotNull (doc.getSubcontractPrincipalNAICSDescription ());
        assertNotNull (doc.getSubcontractNumber ());
        assertNotNull (doc.getSubcontractProjectDescription ());

        /**
         * See the note on the Doc spendingType property as this should not be
         * an enum.
         */
        assertNotNull (doc.getSpendingType ());

        assertNotNull (doc.getFiscalYear ());
        assertNotNull (doc.getSubcontractFundingAgencyId ());
        assertNotNull (doc.getSubcontractFundingAgencyName ());
    }
}
