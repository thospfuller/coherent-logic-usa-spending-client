package com.coherentlogic.usaspending.client.core.builders;

import static com.coherentlogic.usaspending.client.core.builders.CompleteQueryBuilderTest.QUERY_BUILDER;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.client.RestTemplate;

import com.coherentlogic.usaspending.client.core.domain.Agency;
import com.coherentlogic.usaspending.client.core.domain.CongressionalDistrict;
import com.coherentlogic.usaspending.client.core.domain.FiscalYear;
import com.coherentlogic.usaspending.client.core.domain.FiscalYears;
import com.coherentlogic.usaspending.client.core.domain.Recipient;
import com.coherentlogic.usaspending.client.core.domain.SearchCriteria;
import com.coherentlogic.usaspending.client.core.domain.SearchCriterion;
import com.coherentlogic.usaspending.client.core.domain.Summary;
import com.coherentlogic.usaspending.client.core.domain.SummaryData;
import com.coherentlogic.usaspending.client.core.domain.SummaryRecord;
import com.coherentlogic.usaspending.client.core.domain.TopContractingAgencies;
import com.coherentlogic.usaspending.client.core.domain.TopKnownCongressionalDistricts;
import com.coherentlogic.usaspending.client.core.domain.TopRecipients;
import com.coherentlogic.usaspending.client.core.domain.Totals;

/**
 * Integration test for the {@link QueryBuilder} class.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class SummaryQueryBuilderTest {

    static final String USA_SPENDING_REST_TEMPLATE_ID =
        "usaSpendingRestTemplate";

    private final ApplicationContext context
        = new FileSystemXmlApplicationContext (
            "src/test/resources/spring/summary-application-context.xml");

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
                assertEquals("DOLLARS_OBLIGATED desc", next.getValue());
            }
        }
    }

    /**
     * This will work however it will only return 1000 records.
     *
     * https://www.usaspending.gov/fsrs/fsrs.php?fiscal_year=2009&stateCode=TX&detail=s&max_records=5000
     */
    @Test
    @Ignore("The usaspending.gov website returns the following for this query (not that switching to 'l', ie. 'low' "
        + "does return data): <result numFound=\"No data found.  The FSRS summary level of detail will be available "
        + "soon.\"/>")
    public void testFSRSSummary () {
        Summary summary =
            queryBuilder
                .fsrs()
                .setFiscalYear("2009")
                .setStateCode("TX")
                .setDetail(Detail.summary)
                .setMaxRecords(1500)
                .doGet(Summary.class);

        SearchCriteria searchCriteria =
            summary.getSearchCriteria();

        reviewSearchCriteria(searchCriteria);

        SummaryData data = summary.getData();

        reviewSummaryData(data);

        SummaryRecord record = data.getRecord();

        reviewRecord (record);
    }

    private void reviewSummaryData (SummaryData data) {

        String database = data.getDatabase();

        assertEquals("FSRS", database);

        String compiledFromGovernmentDataLastReleasedOn =
            data.getCompiledFromGovernmentDataLastReleasedOn();

        assertEquals("TBD", compiledFromGovernmentDataLastReleasedOn);

        String description = data.getDescription();

        assertEquals("U.S. Federal contracts", description);
    }

    private void reviewRecord (SummaryRecord record) {
        String detail = record.getDetail ();

        assertEquals("summary", detail);

        String description = record.getDescription();

        assertEquals ("summary record for search", description);

        String database = record.getDatabase();

        assertEquals("FSRS", database);

        Totals totals = record.getTotals();

        reviewTotals (totals);

        TopKnownCongressionalDistricts topKnownCongressionalDistricts =
            record.getTopKnownCongressionalDistricts();

        TopContractingAgencies topContractingAgencies
            = record.getTopContractingAgencies();

        TopRecipients topRecipients = record.getTopRecipients();

        FiscalYears fiscalYears = record.getFiscalYears();

        reviewTopKnownCongressionalDistricts (topKnownCongressionalDistricts);
        reviewTopContractingAgencies(topContractingAgencies);
        reviewTopRecipients (topRecipients);
        reviewFiscalYears (fiscalYears);
    }

    private void reviewTotals (Totals totals) {

        String fiscalYear = totals.getFiscalYear();

        assertEquals("2009", fiscalYear);

        BigDecimal totalObligatedAmount = totals.getTotalObligatedAmount();

        // Value changes so checking for null should suffice.
        assertNotNull(totalObligatedAmount);

        String percentOfFiscalYear = totals.getPercentOfFiscalYear();

        assertNotNull(percentOfFiscalYear);

        Long numberOfContractors = totals.getNumberOfContractors();

        assertNotNull(numberOfContractors);

        Long numberOfTransactions = totals.getNumberOfTransactions();

        // This should be a non-null value and we're setting the range just to
        // ensure the test passes, if the value goes above or below 1500 or 2500
        // then we'll need to adjust these numbers below accordingly.
        assertTrue(
            Long.valueOf(1500L) <= numberOfTransactions
            &&
            numberOfTransactions <= Long.valueOf(2500L));
    }

    private void reviewTopKnownCongressionalDistricts (
        TopKnownCongressionalDistricts topKnownCongressionalDistricts) {

        String description = topKnownCongressionalDistricts.getDescription();

        assertEquals ("Top congressional districts where work is performed",
            description);

        String rankedBy = topKnownCongressionalDistricts.getRankedBy();

        assertEquals ("total obligated amount in dollars",
            rankedBy);

        Long maximumShown = topKnownCongressionalDistricts.getMaximumShown();

        assertEquals (Long.valueOf(5L), maximumShown);

        List<CongressionalDistrict> congressionalDistrictList =
            topKnownCongressionalDistricts.getCongressionalDistrictList();

        assertEquals (10, congressionalDistrictList.size());

        reviewCongressionalDistrict (congressionalDistrictList);
    }

    private void reviewCongressionalDistrict (
        List<CongressionalDistrict> congressionalDistrictList) {

        // We'll pick a CongressionalDistrict randomly so in this case #3 looks
        // like as good a candidate as any other. Note that if the values for #3
        // change in any way, this test will need to be modified accordingly.

        CongressionalDistrict congressionalDistrict =
            congressionalDistrictList.get(3);

        String value = congressionalDistrict.getValue();

        assertNotNull (value);

        Long rank = congressionalDistrict.getRank();

        assertEquals(Long.valueOf(4L), rank);

        BigDecimal totaObligatedAmount =
            congressionalDistrict.getTotaObligatedAmount();

        assertEquals(new BigDecimal ("33169826.09"), totaObligatedAmount);
    }

    private void reviewTopContractingAgencies (
        TopContractingAgencies topContractingAgencies) {

        Long expectedMaximumShown = Long.valueOf(10L);
        Long actualMaximumShown = topContractingAgencies.getMaximumShown();

        assertEquals(expectedMaximumShown, actualMaximumShown);

        String expectedRankedBy = "total obligated amount in dollars";
        String actualRankedBy = topContractingAgencies.getRankedBy();

        assertEquals(expectedRankedBy, actualRankedBy);

        List<Agency> agencyList = topContractingAgencies.getAgencyList();

        assertNotNull (agencyList);

        int expectedSize = 10;
        int actualSize = agencyList.size();

        assertEquals(expectedSize, actualSize);

        Agency agency = agencyList.get(3);

        reviewAgency (agency);
    }

    private void reviewAgency (Agency agency) {

        Long expectedRank = 4L;
        Long actualRank = agency.getRank();

        assertEquals(expectedRank, actualRank);

        String expectedId = "5700";
        String actualId = agency.getId();

        assertEquals(expectedId, actualId);

        String expectedName = "DEPT OF THE AIR FORCE";
        String actualName = agency.getName();

        assertEquals(expectedName, actualName);

        BigDecimal expectedValue = new BigDecimal ("18700027.15");
        BigDecimal actualValue = agency.getValue();

        assertEquals(expectedValue, actualValue);
    }

    private void reviewTopRecipients (TopRecipients topRecipients) {

        List<Recipient> recipientList = topRecipients.getRecipientList();

        reviewRecipient (recipientList);
    }

    private void reviewRecipient (List<Recipient> recipientList) {

        assertEquals(10, recipientList.size());
    }

    private void reviewFiscalYears (FiscalYears fiscalYears) {

        List<FiscalYear> fiscalYearList = fiscalYears.getFiscalYearList();

        assertEquals(1, fiscalYearList.size());

        String expected = "total Federal obligated amount in dollars by year";

        String actual = fiscalYears.getDescription();

        assertEquals (expected, actual);

        reviewFiscalYear (fiscalYearList);
    }

    private void reviewFiscalYear (List<FiscalYear> fiscalYearList) {

        FiscalYear fiscalYear = fiscalYearList.get(0);

        String expectedYear = "2009";

        String actualYear = fiscalYear.getYear();

        assertEquals (expectedYear, actualYear);

//        BigDecimal expectedValue = new BigDecimal("1322937962.54");

        BigDecimal actualValue = fiscalYear.getValue();

        assertNotNull(actualValue);
    }
}
