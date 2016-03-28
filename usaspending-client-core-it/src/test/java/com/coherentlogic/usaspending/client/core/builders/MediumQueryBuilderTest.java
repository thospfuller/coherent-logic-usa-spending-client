package com.coherentlogic.usaspending.client.core.builders;

import static com.coherentlogic.usaspending.client.core.builders.CompleteQueryBuilderTest.QUERY_BUILDER;
import static com.coherentlogic.usaspending.client.core.util.Constants.NULL;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.coherentlogic.usaspending.client.core.domain.Doc;
import com.coherentlogic.usaspending.client.core.domain.Medium;
import com.coherentlogic.usaspending.client.core.domain.Result;
import com.coherentlogic.usaspending.client.core.domain.SearchCriteria;
import com.coherentlogic.usaspending.client.core.domain.SearchCriterion;

/**
 * Integration test for the {@link QueryBuilder} class.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class MediumQueryBuilderTest {

    static final String USA_SPENDING_REST_TEMPLATE_ID =
        "usaSpendingRestTemplate";

    private final ApplicationContext context
        = new FileSystemXmlApplicationContext (
            "src/test/resources/spring/medium-application-context.xml");

    // https://www.usaspending.gov/fsrs/fsrs.php?fiscal_year=2010&detail=c

    private QueryBuilder queryBuilder = null;

    @Before
    public void setUp() throws Exception {
        queryBuilder = context.getBean (QUERY_BUILDER, QueryBuilder.class);
    }

    @After
    public void tearDown() throws Exception {
        queryBuilder = null;
    }

    /**
     *
     * @todo The assert expected should be "DOLLARS_OBLIGATED desc" -- not sure
     *  why we're not seeing the desc part.
     */
    private void reviewSearchCriteria (SearchCriteria searchCriteria) {
        for (SearchCriterion next : searchCriteria.getSearchCriterionList()) {
            if ("fiscal_year".equals(next.getField())) {
                assertEquals("2009", next.getValue());
            } else if ("sortby".equals(next.getField())) {
                assertEquals("DOLLARS_OBLIGATED", next.getValue());
            } else if ("records_from".equals(next.getField())) {
                assertEquals("0", next.getValue());
            } else if ("max_records".equals(next.getField())) {
                assertEquals("1000", next.getValue());
            }
        }
    }

    private void reviewResult (Result result) {

        long numFound = result.getNumFound();
        // These numbers change so we pick a bound and just assume the numFound
        // will be between these numbers (which means if this changes enough,
        // we'll need to change the boundary values).
        assertTrue("numFound: " + numFound,
            750000L < numFound && numFound < 950000L);

        assertEquals(1000L, result.getMaxRecords());

        List<Doc> docList = result.getDocList();

        assertEquals(1000, docList.size());

        reviewDocList (docList);
    }

    /**
     * This will work however it will only return 1000 records.
     *
     * https://www.usaspending.gov/fpds/fpds.php?fiscal_year=2009&stateCode=TX&
     * detail=c&max_records=5000
     *
     * @todo Finish this test by adding assertions to check against data returned from usaspending.gov.
     */
    @Test
    public void testMaxRecordsSetAbove1000 () {
        Medium medium =
            queryBuilder
                .fsrs()
                .setFiscalYear("2009")
                .setStateCode("TX")
                .setDetail(Detail.medium)
                .setMaxRecords(5000)
                .doGet(Medium.class);

//        SearchCriteria searchCriteria =
//            complete.getSearchCriteria();
//        Result result = complete.getResult();
//
//        reviewSearchCriteria (searchCriteria);
//        reviewResult(result);
    }

    /**
     * The docList is not always ordered.
     */
    private Doc findByPrimeAwardPIIDAndSubcontactorDUNSNumber (
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

    private void reviewDocList (List<Doc> docList) {
        Doc doc = findByPrimeAwardPIIDAndSubcontactorDUNSNumber (
            docList, "DEEE0000171", "054488510");

        assertEquals ("DEEE0000171", doc.getPrimeAwardPIID ());
        assertEquals (NULL, doc.getPrimeAwardIDVPIID ());
        assertEquals ("2012-08-09T04:00:00Z", doc.getPrimeAwardDateSubmitted ());
        assertEquals (NULL, doc.getPrimeAwardAmount ());
        assertEquals (NULL, doc.getPrimeAwardDateSigned ());
        assertEquals ("TAS::89 0331::TAS RECOVERY - EERE- WEATHERIZATION " +
            "ASSISTANCE PROGRAM - ENERGY EFFICIENCY AND RENEWABLE ENERGY, " +
            "RECOVERY ACT", doc.getPrimeAwardProgramTitle ());
        assertEquals (NULL, doc.getPrimeAwardProgramSourceAgency ());
        assertEquals (NULL, doc.getPrimeAwardProgramSourceAccount ());
        assertEquals (NULL, doc.getProgramSourceSubAccount ());
        assertEquals (NULL, doc.getPrimeAwardAgencyId ());

        assertEquals (NULL, doc.getPrimeAwardIDVAgencyId ());
        assertEquals (NULL, doc.getPrimeAwardContractingMajorAgency ());
        assertEquals (NULL, doc.getPrimeAwardFundingMajorAgencyName ());
        assertEquals ("054488510", doc.getSubcontactorDUNSNumber ());
        assertEquals ("NORTHEAST EMPLOYMENT & TRAINING ORGANIZATION INC",
            doc.getSubcontractorName ());
        assertEquals ("147 CITIZENS RD", doc.getSubcontractorStreet ());
        assertEquals ("DERBY", doc.getSubcontractorCity ());
        assertEquals ("VT", doc.getSubcontractorState ());

        assertEquals ("058290147", doc.getSubcontractorZipCode ());
        assertEquals ("VTAL", doc.getSubcontractorCongressionalDistrict ());
        assertEquals ("derby",
            doc.getSubcontractPrincipalPlaceCity ());
        assertEquals ("058550584", doc.getSubcontractPrincipalPlaceZip ());
        assertEquals ("VTAL", doc.getSubcontractPrincipalPlaceDistrict ());
        assertEquals ("3702208.00", doc.getSubcontractAmount ());
        assertEquals ("2009-08-21T04:00:00Z", doc.getSubcontractDate ());
        assertEquals (NULL, doc.getSubcontractPrincipalNAICSCode ());
        assertEquals (NULL, doc.getSubcontractPrincipalNAICSDescription ());
        assertEquals ("DEEE0000171", doc.getSubcontractNumber ());
        assertEquals ("Low income weatherization project",
            doc.getSubcontractProjectDescription ());
        assertEquals ("sg", doc.getSpendingType ());
        assertEquals ("2009", doc.getFiscalYear ());
        assertEquals (NULL, doc.getSubcontractFundingAgencyId ());
        assertEquals (NULL, doc.getSubcontractFundingAgencyName ());
    }
}
