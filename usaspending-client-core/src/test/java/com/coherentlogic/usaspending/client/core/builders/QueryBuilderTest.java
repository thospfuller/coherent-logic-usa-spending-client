package com.coherentlogic.usaspending.client.core.builders;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.coherentlogic.usaspending.client.core.exceptions.InvalidFormatException;
import com.coherentlogic.usaspending.client.core.exceptions.ValueOutOfBoundsException;
import com.coherentlogic.usaspending.client.core.util.Constants;

/**
 * Unit test for the {@link QueryBuilder} class.
 *
 * @todo Note that methods that don't check for a format will throw an NPE when
 *  called with a null arg juxtaposed with a method that checks for a specific
 *  format, which throws IllegalArgumentException when null is passed. This is
 *  inconsistent and should be made uniform for all scenarios. Same applies to
 *  enum params.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class QueryBuilderTest {

    public static final String DEFAULT_URI = "http://www.usaspending.gov",
        DEFAULT_STRING = "fubar";

    private QueryBuilder queryBuilder = null;

    @Before
    public void setUp() throws Exception {
        queryBuilder = new QueryBuilder (null, DEFAULT_URI);
    }

    @After
    public void tearDown() throws Exception {
        queryBuilder = null;
    }

    @Test(expected=NullPointerException.class)
    public void testToString () {
        QueryBuilder.toString (null);
    }

    @Test
    public void testToString1 () {

        String expected = Constants.BY_MAJOR_CONTRACTING_AGENCY;

        String actual = QueryBuilder.toString (SortBy.byMajorContractingAgency);

        assertEquals(expected, actual);
    }

    @Test (expected=InvalidFormatException.class)
    public void checkYearFormat1 () {
        QueryBuilder.checkYearFormat(null);
    }

    @Test (expected=InvalidFormatException.class)
    public void checkYearFormat2 () {
        QueryBuilder.checkYearFormat("");
    }

    @Test (expected=InvalidFormatException.class)
    public void checkYearFormat3 () {
        QueryBuilder.checkYearFormat("12s4");
    }

    @Test (expected=InvalidFormatException.class)
    public void checkYearFormat4 () {
        QueryBuilder.checkYearFormat("123");
    }

    @Test
    public void checkYearFormat5 () {
        QueryBuilder.checkYearFormat("1234");
    }

    @Test
    public void testFaads () {

        String expected = DEFAULT_URI + QueryBuilder.FAADS_PATH;

        String actual = queryBuilder.faads().getEscapedURI();

        assertEquals(expected, actual);
    }

    @Test
    public void testFpds () {

        String expected = DEFAULT_URI + QueryBuilder.FPDS_PATH;

        String actual = queryBuilder.fpds().getEscapedURI();

        assertEquals(expected, actual);
    }

    @Test
    public void testFsrs () {

        String expected = DEFAULT_URI + QueryBuilder.FSRS_PATH;

        String actual = queryBuilder.fsrs().getEscapedURI();

        assertEquals(expected, actual);
    }

    @Test
    public void testSetDetail () {

        String expected = DEFAULT_URI + QueryBuilder.FSRS_PATH + "?detail=c";

        String actual = queryBuilder
            .fsrs()
            .setDetail(Detail.complete)
            .getEscapedURI();

        assertEquals(expected, actual);
    }

    @Test
    public void testSetMaxRecords1 () {

        String expected = DEFAULT_URI + QueryBuilder.FSRS_PATH +
            "?max_records=222";

        String actual = queryBuilder
            .fsrs()
            .setMaxRecords(222)
            .getEscapedURI();

        assertEquals(expected, actual);
    }

    /**
     * This test should work and a warning message should be logged.
     */
    @Test
    public void testSetMaxRecords2 () {

        String expected = DEFAULT_URI + QueryBuilder.FSRS_PATH +
            "?max_records=2222";

        String actual = queryBuilder
            .fsrs()
            .setMaxRecords(2222)
            .getEscapedURI();

        assertEquals(expected, actual);
    }

    /**
     * This test should work and a warning message should be logged.
     */
    @Test (expected=ValueOutOfBoundsException.class)
    public void testSetMaxRecords3 () {
        queryBuilder
            .fsrs()
            .setMaxRecords(-2222);
    }

    public void testSetRecordsFrom () {
        String expected = DEFAULT_URI + QueryBuilder.FSRS_PATH +
            "?records_from=10";

        String actual = queryBuilder
            .fsrs()
            .setRecordsFrom(0).getEscapedURI();

        assertEquals(expected, actual);
    }

    @Test (expected=ValueOutOfBoundsException.class)
    public void testRecordsFrom1 () {
        queryBuilder
            .fsrs()
            .setRecordsFrom(-1);
    }

    @Test (expected=InvalidFormatException.class)
    public void setFiscalYear1 () {
        queryBuilder.setFiscalYear(null);
    }

    @Test (expected=InvalidFormatException.class)
    public void setFiscalYear2 () {
        queryBuilder.setFiscalYear("");
    }

    @Test (expected=InvalidFormatException.class)
    public void setFiscalYear3 () {
        queryBuilder.setFiscalYear("12s4");
    }

    @Test (expected=InvalidFormatException.class)
    public void setFiscalYear4 () {
        queryBuilder.setFiscalYear("123");
    }

    @Test
    public void setFiscalYear5 () {
        queryBuilder.setFiscalYear("1234");
    }

    public void testSetFiscalYear6 () {
        String expected = DEFAULT_URI + QueryBuilder.FSRS_PATH +
            "?fiscal_year=2012";

        String actual = queryBuilder
            .fsrs()
            .setFiscalYear("2013").getEscapedURI();

        assertEquals(expected, actual);
    }

    @Test (expected=InvalidFormatException.class)
    public void setFirstYearRange1 () {
        queryBuilder.setFirstYearRange(null);
    }

    @Test (expected=InvalidFormatException.class)
    public void setFirstYearRange2 () {
        queryBuilder.setFirstYearRange("");
    }

    @Test (expected=InvalidFormatException.class)
    public void setFirstYearRange3 () {
        queryBuilder.setFirstYearRange("12s4");
    }

    @Test (expected=InvalidFormatException.class)
    public void setFirstYearRange4 () {
        queryBuilder.setFirstYearRange("123");
    }

    @Test
    public void setFirstYearRange5 () {
        queryBuilder.setFirstYearRange("1234");
    }

    @Test
    public void testSetFirstYearRange6 () {
        String expected = DEFAULT_URI + QueryBuilder.FSRS_PATH +
            "?first_year_range=2013";

        String actual = queryBuilder
            .fsrs()
            .setFirstYearRange("2013").getEscapedURI();

        assertEquals(expected, actual);
    }

    @Test
    public void testCompanyName () {
        String expected = DEFAULT_URI + QueryBuilder.FSRS_PATH +
            "?company_name=fubar";

        String actual = queryBuilder
            .fsrs()
            .setCompanyName("fubar").getEscapedURI();

        assertEquals(expected, actual);
    }

    @Test (expected=NullPointerException.class)
    public void testCompanyName1 () {
        queryBuilder
            .fsrs()
            .setCompanyName(null).getEscapedURI();
    }

    @Test
    public void testCity () {
        String expected = DEFAULT_URI + QueryBuilder.FSRS_PATH +
            "?city=Chicago";

        String actual = queryBuilder
            .fsrs()
            .setCity("Chicago").getEscapedURI();

        assertEquals(expected, actual);
    }

    @Test (expected=NullPointerException.class)
    public void testCity1 () {
        queryBuilder
            .fsrs()
            .setCity(null).getEscapedURI();
    }

    @Test
    public void testState () {
        String expected = DEFAULT_URI + QueryBuilder.FSRS_PATH +
            "?state=IL";

        String actual = queryBuilder
            .fsrs()
            .setState("IL").getEscapedURI();

        assertEquals(expected, actual);
    }

    @Test (expected=NullPointerException.class)
    public void testState1 () {
        queryBuilder
            .fsrs()
            .setState(null).getEscapedURI();
    }

    @Test
    public void testZIPCode () {
        String expected = DEFAULT_URI + QueryBuilder.FSRS_PATH +
            "?ZIPCode=60652-5257";

        String actual = queryBuilder
            .fsrs()
            .setZIPCode("60652-5257").getEscapedURI();

        assertEquals(expected, actual);
    }

    @Test (expected=NullPointerException.class)
    public void testZIPCode1 () {
        queryBuilder
            .fsrs()
            .setZIPCode(null).getEscapedURI();
    }

    @Test
    public void testVendorCountryCode () {
        String expected = DEFAULT_URI + QueryBuilder.FSRS_PATH +
            "?vendorCountryCode=UK";

        String actual = queryBuilder
            .fsrs()
            .setVendorCountryCode("UK").getEscapedURI();

        assertEquals(expected, actual);
    }

    @Test (expected=NullPointerException.class)
    public void testVendorCountryCode1 () {
        queryBuilder
            .fsrs()
            .setVendorCountryCode((String)null).getEscapedURI();
    }

    @Test
    public void testVendorCountryCode3 () {
        String expected = DEFAULT_URI + QueryBuilder.FSRS_PATH +
            "?vendorCountryCode=ZI";

        String actual = queryBuilder
            .fsrs()
            .setVendorCountryCode(CountryCode.Zimbabwe).getEscapedURI();

        assertEquals(expected, actual);
    }

    @Test (expected=NullPointerException.class)
    public void testVendorCountryCode4 () {
        queryBuilder
            .fsrs()
            .setVendorCountryCode((CountryCode)null).getEscapedURI();
    }

    @Test (expected=InvalidFormatException.class)
    public void testAssertStringHasTwoLetters1 () {
        QueryBuilder.assertStringHasTwoLetters(DEFAULT_STRING, "m");
    }

    @Test (expected=InvalidFormatException.class)
    public void testAssertStringHasTwoLetters2 () {
        QueryBuilder.assertStringHasTwoLetters(DEFAULT_STRING, "mmm");
    }

    @Test
    public void testAssertStringHasTwoLetters3 () {
        QueryBuilder.assertStringHasTwoLetters(DEFAULT_STRING, "zi");
    }

    @Test
    public void testAssertStringHasTwoLetters4 () {
        QueryBuilder.assertStringHasTwoLetters(DEFAULT_STRING, "UK");
    }

    @Test
    public void testAssertStringHasTwoLetters5 () {
        QueryBuilder.assertStringHasTwoLetters(DEFAULT_STRING, "U9");
    }

    @Test (expected=InvalidFormatException.class)
    public void testAssertStringHasFourLetters1 () {
        QueryBuilder.assertStringHasFourLetters(DEFAULT_STRING, "mmm");
    }

    @Test (expected=InvalidFormatException.class)
    public void testAssertStringHasFourLetters2 () {
        QueryBuilder.assertStringHasFourLetters(DEFAULT_STRING, "mmmmm");
    }

    @Test
    public void testAssertStringHasFourLetters3 () {
        QueryBuilder.assertStringHasFourLetters(DEFAULT_STRING, "xyxy");
    }

    @Test
    public void testAssertStringHasFourLetters4 () {
        QueryBuilder.assertStringHasFourLetters(DEFAULT_STRING, "XYXY");
    }

    @Test
    public void testAssertStringHasFourLetters5 () {
        QueryBuilder.assertStringHasFourLetters(DEFAULT_STRING, "AK00");
    }

//    @Test (expected=InvalidFormatException.class)
//    public void testAssertStringHasFourLetters1 () {
//        QueryBuilder.assertStringHasFourLetters(DEFAULT_STRING, "mm#4");
//    }
//
//    @Test (expected=InvalidFormatException.class)
//    public void testCheckVendorCDFormat2 () {
//        QueryBuilder.assertStringHasFourLetters(DEFAULT_STRING, "mm1");
//    }
//
//    @Test (expected=InvalidFormatException.class)
//    public void testCheckVendorCDFormat3 () {
//        QueryBuilder.assertStringHasFourLetters(DEFAULT_STRING, "mm123");
//    }
//
//    @Test (expected=InvalidFormatException.class)
//    public void testCheckVendorCDFormat4 () {
//        QueryBuilder.assertStringHasFourLetters(DEFAULT_STRING, null);
//    }

    @Test (expected=NullPointerException.class)
    public void testSetVendorCDString1() {
        queryBuilder
            .fsrs()
            .setVendorCD((String)null);
    }

    @Test
    public void testSetAgencyCode1() {
        String uri = queryBuilder
            .setAgencyCode(DEFAULT_STRING)
            .getEscapedURI();

        assertEquals("http://www.usaspending.gov?agency_code=fubar", uri);
    }

    @Test(expected=NullPointerException.class)
    public void testSetAgencyCode2() {
        queryBuilder.setAgencyCode(null);
    }

    @Test
    public void testSetAsstCatType1() {
        String uri = queryBuilder
            .setAsstCatType(AsstCatType.l)
            .getEscapedURI();

        assertEquals("http://www.usaspending.gov?asst_cat_type=l", uri);
    }

    @Test(expected=NullPointerException.class)
    public void testSetAsstCatType2() {
        queryBuilder.setAsstCatType((String) null);
    }

    @Test(expected=NullPointerException.class)
    public void testSetAsstCatType3() {
        queryBuilder.setAsstCatType((AsstCatType) null);
    }

    @Test
    public void testSetAsstCatType4() {
        String uri = queryBuilder
            .setAsstCatType(DEFAULT_STRING)
            .getEscapedURI();

        assertEquals(
            "http://www.usaspending.gov?asst_cat_type=fubar", uri);
    }

    @Test
    public void testSetBusnIndctr1() {
        String uri = queryBuilder
            .setBusnIndctr(DEFAULT_STRING)
            .getEscapedURI();

        assertEquals("http://www.usaspending.gov?busn_indctr=fubar", uri);
    }

    @Test(expected=NullPointerException.class)
    public void testSetBusnIndctr2() {
        queryBuilder.setBusnIndctr((String) null);
    }

    @Test
    public void testSetCFDAProgramNum1() {
        String uri = queryBuilder
            .setCFDAProgramNum(DEFAULT_STRING)
            .getEscapedURI();

        assertEquals("http://www.usaspending.gov?cfda_program_num=fubar", uri);
    }

    @Test(expected=NullPointerException.class)
    public void testSetCFDAProgramNum2() {
        queryBuilder.setCFDAProgramNum((String) null);
    }

    @Test
    public void testSetCity1() {
        String uri = queryBuilder
            .setCity(DEFAULT_STRING)
            .getEscapedURI();

        assertEquals("http://www.usaspending.gov?city=fubar", uri);
    }

    @Test(expected=NullPointerException.class)
    public void testSetCity2() {
        queryBuilder.setCity(null);
    }

    @Test
    public void testSetState1() {
        String uri = queryBuilder
            .setState(DEFAULT_STRING)
            .getEscapedURI();

        assertEquals("http://www.usaspending.gov?state=fubar", uri);
    }

    @Test(expected=NullPointerException.class)
    public void testSetState2() {
        queryBuilder.setState(null);
    }

    @Test
    public void testSetZIPCode1() {
        String uri = queryBuilder
            .setZIPCode(DEFAULT_STRING)
            .getEscapedURI();

        assertEquals("http://www.usaspending.gov?ZIPCode=fubar", uri);
    }

    @Test(expected=NullPointerException.class)
    public void testSetZIPCode2() {
        queryBuilder.setZIPCode(null);
    }

    @Test
    public void testSeVendorCD1() {

        String vendorCD = "abcd";

        String uri = queryBuilder
            .setVendorCD(vendorCD)
            .getEscapedURI();

        assertEquals("http://www.usaspending.gov?vendor_cd=abcd", uri);
    }

    @Test(expected=InvalidFormatException.class)
    public void testSetVendorCD2() {
        queryBuilder.setVendorCD("abc");
    }

    @Test(expected=InvalidFormatException.class)
    public void testSetVendorCD3() {
        queryBuilder.setVendorCD("abcde");
    }

    @Test(expected=NullPointerException.class)
    public void testSetVendorCD4() {
        queryBuilder.setVendorCD(null);
    }

    @Test
    public void testSetPopCD1() {

        String popCD = "abcd";

        String uri = queryBuilder
            .setPopCD(popCD)
            .getEscapedURI();

        assertEquals("http://www.usaspending.gov?pop_cd=abcd", uri);
    }

    @Test(expected=InvalidFormatException.class)
    public void testSetPopCD2() {
        queryBuilder.setPopCD("abc");
    }

    @Test(expected=InvalidFormatException.class)
    public void testSetPopCD3() {
        queryBuilder.setPopCD("abcde");
    }

    @Test(expected=NullPointerException.class)
    public void testSetPopCD4() {
        queryBuilder.setPopCD(null);
    }

    @Test
    public void testSetStateCode1() {

        String stateCode = "IL";

        String uri = queryBuilder
            .setStateCode(stateCode)
            .getEscapedURI();

        assertEquals("http://www.usaspending.gov?stateCode=IL", uri);
    }

    @Test(expected=NullPointerException.class)
    public void testSetStateCode2() {
        queryBuilder.setStateCode(null);
    }

    @Test
    public void testSetSubawardeeName1() {

        String value = DEFAULT_STRING;

        String uri = queryBuilder
            .setSubawardeeName(value)
            .getEscapedURI();

        assertEquals("http://www.usaspending.gov?subawardee_name=fubar", uri);
    }

    @Test(expected=NullPointerException.class)
    public void testSetSubawardeeName2() {
        queryBuilder.setSubawardeeName(null);
    }

    @Test
    public void testSetSubawardeeCityName1() {

        String value = DEFAULT_STRING;

        String uri = queryBuilder
            .setSubawardeeCityName(value)
            .getEscapedURI();

        assertEquals(
            "http://www.usaspending.gov?subawardee_city_name=fubar", uri);
    }

    @Test(expected=NullPointerException.class)
    public void testSetSubawardeeCityName2() {
        queryBuilder.setSubawardeeCityName(null);
    }

    @Test
    public void testSetSubawardeeStateCode1() {
        String uri = queryBuilder
            .setSubawardeeStateCode(DEFAULT_STRING)
            .getEscapedURI();

        assertEquals(
            "http://www.usaspending.gov?subawardee_state_code=fubar", uri);
    }

    @Test(expected=NullPointerException.class)
    public void testSetSubawardeeStateCode2() {
        queryBuilder.setSubawardeeStateCode(null);
    }

    @Test
    public void testSetSubawardeeZIP1() {
        String uri = queryBuilder
            .setSubawardeeZIP(DEFAULT_STRING)
            .getEscapedURI();

        assertEquals(
            "http://www.usaspending.gov?subawardee_zip=fubar", uri);
    }

    @Test(expected=NullPointerException.class)
    public void testSetSubawardeeZIP2() {
        queryBuilder.setSubawardeeZIP(null);
    }

    @Test
    public void testSetSubawardeeCountry1() {
        String uri = queryBuilder
            .setSubawardeeCountry("US")
            .getEscapedURI();

        assertEquals(
            "http://www.usaspending.gov?subawardee_country=US", uri);
    }

    @Test(expected=InvalidFormatException.class)
    public void testSetSubawardeeCountry2() {
        queryBuilder.setSubawardeeCountry("a");
    }

    @Test(expected=InvalidFormatException.class)
    public void testSetSubawardeeCountry3() {
        queryBuilder.setSubawardeeCountry("abc");
    }

    /**
     * @todo This is another method that needs to throw a better (probably NPE)
     *  exception when the value passed in is null.
     */
    @Test(expected=NullPointerException.class)
    public void testSetSubawardeeCountry4() {
        queryBuilder.setSubawardeeCountry(null);
    }

    @Test
    public void testSetSubawardeeCD1() {
        String uri = queryBuilder
            .setSubawardeeCD("AK00")
            .getEscapedURI();

        assertEquals(
            "http://www.usaspending.gov?subawardee_cd=AK00", uri);
    }

    @Test(expected=InvalidFormatException.class)
    public void testSetSubawardeeCD2() {
        queryBuilder.setSubawardeeCD("abc");
    }

    @Test(expected=InvalidFormatException.class)
    public void testSetSubawardeeCD3() {
        queryBuilder.setSubawardeeCD("abcde");
    }

    /**
     * @todo This is another method that needs to throw a better (probably NPE)
     *  exception when the value passed in is null.
     */
    @Test(expected=NullPointerException.class)
    public void testSetSubawardeeCD4() {
        queryBuilder.setSubawardeeCD(null);
    }

    @Test
    public void testSetSubawardeePopCD1() {
        String uri = queryBuilder
            .setSubawardeePopCD("AK00")
            .getEscapedURI();

        assertEquals(
            "http://www.usaspending.gov?subawardee_pop_cd=AK00", uri);
    }

    @Test(expected=InvalidFormatException.class)
    public void testSetSubawardeePopCD2() {
        queryBuilder.setSubawardeePopCD("abc");
    }

    @Test(expected=InvalidFormatException.class)
    public void testSetSubawardeePopCD3() {
        queryBuilder.setSubawardeePopCD("abcde");
    }

    /**
     * @todo This is another method that needs to throw a better (probably NPE)
     *  exception when the value passed in is null.
     */
    @Test(expected=NullPointerException.class)
    public void testSetSubawardeePopCD4() {
        queryBuilder.setSubawardeePopCD(null);
    }

    @Test
    public void testSetSubawardeePopState1() {
        String uri = queryBuilder
            .setSubawardeePopState("AK")
            .getEscapedURI();

        assertEquals(
            "http://www.usaspending.gov?subawardee_pop_state=AK", uri);
    }

    @Test(expected=InvalidFormatException.class)
    public void testSetSubawardeePopState2() {
        queryBuilder.setSubawardeePopState("abc");
    }

    @Test(expected=InvalidFormatException.class)
    public void testSetSubawardeePopState3() {
        queryBuilder.setSubawardeePopState("abcde");
    }

    /**
     * @todo This is another method that needs to throw a better (probably NPE)
     *  exception when the value passed in is null.
     */
    @Test(expected=NullPointerException.class)
    public void testSetSubawardeePopState4() {
        queryBuilder.setSubawardeePopState(null);
    }

    @Test
    public void testSetSubawardeePopZIP1() {
        String uri = queryBuilder
            .setSubawardeePopZIP("60652")
            .getEscapedURI();

        assertEquals(
                "http://www.usaspending.gov?subawardee_pop_zip=60652", uri);
    }

    /**
     * @todo This is another method that needs to throw a better (probably NPE)
     *  exception when the value passed in is null.
     */
    @Test(expected=NullPointerException.class)
    public void testSetSubawardeePopZIP2() {
        queryBuilder.setSubawardeePopZIP(null);
    }

    @Test
    public void testSetSubawardeePopCountry1() {
        String uri = queryBuilder
            .setSubawardeePopCountry("ZZ")
            .getEscapedURI();

        assertEquals(
            "http://www.usaspending.gov?subawardee_pop_country=ZZ", uri);
    }

    @Test(expected=InvalidFormatException.class)
    public void testSetSubawardeePopCountry2() {
        queryBuilder.setSubawardeePopCountry("a");
    }

    @Test(expected=InvalidFormatException.class)
    public void testSetSubawardeePopCountry3() {
        queryBuilder.setSubawardeePopCountry("abc");
    }

    /**
     * @todo This is another method that needs to throw a better (probably NPE)
     *  exception when the value passed in is null.
     */
    @Test(expected=NullPointerException.class)
    public void testSetSubawardeePopCountry4() {
        queryBuilder.setSubawardeePopCountry(null);
    }

    @Test
    public void testSetSubawardProjectDescription1() {
        String uri = queryBuilder
            .setSubawardProjectDescription("foo bar baz boo")
            .getEscapedURI();

        assertEquals(
            "http://www.usaspending.gov?subaward_project_description=" +
            "foo+bar+baz+boo", uri);
    }

    /**
     * @todo This is another method that needs to throw a better (probably NPE)
     *  exception when the value passed in is null.
     */
    @Test(expected=NullPointerException.class)
    public void testSetSubawardProjectDescription2() {
        queryBuilder.setSubawardProjectDescription(null);
    }

    @Test
    public void testSetPrimeAwardNumber1() {
        String uri = queryBuilder
            .setPrimeAwardNumber("12345")
            .getEscapedURI();

        assertEquals(
            "http://www.usaspending.gov?prime_award_number=" +
            "12345", uri);
    }

    /**
     * @todo This is another method that needs to throw a better (probably NPE)
     *  exception when the value passed in is null.
     */
    @Test(expected=NullPointerException.class)
    public void testSetPrimeAwardNumber2() {
        queryBuilder.setPrimeAwardNumber(null);
    }

    @Test
    public void testSetPrimeOrderNumber1() {
        String uri = queryBuilder
            .setPrimeOrderNumber("12345")
            .getEscapedURI();

        assertEquals(
            "http://www.usaspending.gov?prime_order_number=" +
            "12345", uri);
    }

    /**
     * @todo This is another method that needs to throw a better (probably NPE)
     *  exception when the value passed in is null.
     */
    @Test(expected=NullPointerException.class)
    public void testSetPrimeOrderNumber2() {
        queryBuilder.setPrimeOrderNumber(null);
    }

    @Test
    public void testSetSubawardeeDunsNumber1() {
        String uri = queryBuilder
            .setSubawardeeDunsNumber("12345")
            .getEscapedURI();

        assertEquals(
            "http://www.usaspending.gov?subawardee_duns_number=" +
            "12345", uri);
    }

    /**
     * @todo This is another method that needs to throw a better (probably NPE)
     *  exception when the value passed in is null.
     */
    @Test(expected=NullPointerException.class)
    public void testSetSubawardeeDunsNumber2() {
        queryBuilder.setSubawardeeDunsNumber(null);
    }

    @Test
    public void testSetPrimeAwardProgramSourceAgencyCode1() {
        String uri = queryBuilder
            .setPrimeAwardProgramSourceAgencyCode("12345")
            .getEscapedURI();

        assertEquals(
            "http://www.usaspending.gov?prime_award_program_source_agency_code=" +
            "12345", uri);
    }

    /**
     * @todo This is another method that needs to throw a better (probably NPE)
     *  exception when the value passed in is null.
     */
    @Test(expected=NullPointerException.class)
    public void testSetPrimeAwardProgramSourceAgencyCode2() {
        queryBuilder.setPrimeAwardProgramSourceAgencyCode(null);
    }

    @Test
    public void testSetPrimeAwardProgramSourceAccountCode1() {
        String uri = queryBuilder
            .setPrimeAwardProgramSourceAccountCode("12345")
            .getEscapedURI();

        assertEquals(
            "http://www.usaspending.gov?" +
            "prime_award_program_source_account_code=12345", uri);
    }

    /**
     * @todo This is another method that needs to throw a better (probably NPE)
     *  exception when the value passed in is null.
     */
    @Test(expected=NullPointerException.class)
    public void testSetPrimeAwardProgramSourceAccountCode2() {
        queryBuilder.setPrimeAwardProgramSourceAccountCode(null);
    }

    @Test
    public void testSetPlaceOfPerformanceZIPCode1() {
        String uri = queryBuilder
            .setPlaceOfPerformanceZIPCode("12345")
            .getEscapedURI();

        assertEquals(
            "http://www.usaspending.gov?placeOfPerformanceZIPCode=" +
            "12345", uri);
    }

    /**
     * @todo This is another method that needs to throw a better (probably NPE)
     *  exception when the value passed in is null.
     */
    @Test(expected=NullPointerException.class)
    public void testSetPlaceOfPerformanceZIPCode2() {
        queryBuilder.setPlaceOfPerformanceZIPCode(null);
    }

    @Test
    public void testSetPlaceOfPerformanceCountryCode1() {
        String uri = queryBuilder
            .setPlaceOfPerformanceCountryCode("XY")
            .getEscapedURI();

        assertEquals(
            "http://www.usaspending.gov?placeOfPerformanceCountryCode=XY", uri);
    }

    @Test(expected=InvalidFormatException.class)
    public void testSetPlaceOfPerformanceCountryCode2() {
        queryBuilder.setPlaceOfPerformanceCountryCode("abc");
    }

    @Test(expected=InvalidFormatException.class)
    public void testSetPlaceOfPerformanceCountryCode3() {
        queryBuilder.setPlaceOfPerformanceCountryCode("abcde");
    }

    /**
     * @todo This is another method that needs to throw a better (probably NPE)
     *  exception when the value passed in is null.
     */
    @Test(expected=NullPointerException.class)
    public void testSetPlaceOfPerformanceCountryCode4() {
        queryBuilder.setPlaceOfPerformanceCountryCode(null);
    }

    @Test
    public void testSetModAgency1() {
        String uri = queryBuilder
            .setModAgency("XXYY")
            .getEscapedURI();

        assertEquals(
            "http://www.usaspending.gov?mod_agency=XXYY", uri);
    }

    @Test(expected=InvalidFormatException.class)
    public void testSetModAgency2() {
        queryBuilder.setModAgency("abc");
    }

    @Test(expected=InvalidFormatException.class)
    public void testSetModAgency3() {
        queryBuilder.setModAgency("abcde");
    }

    /**
     * @todo This is another method that needs to throw a better (probably NPE)
     *  exception when the value passed in is null.
     */
    @Test(expected=NullPointerException.class)
    public void testSetModAgency4() {
        queryBuilder.setModAgency(null);
    }

    @Test
    public void testSetMajAgencyCat1() {
        String uri = queryBuilder
            .setMajAgencyCat("XY")
            .getEscapedURI();

        assertEquals(
            "http://www.usaspending.gov?maj_agency_cat=XY", uri);
    }

    @Test(expected=InvalidFormatException.class)
    public void testSetMajAgencyCat2() {
        queryBuilder.setMajAgencyCat("X");
    }

    @Test(expected=InvalidFormatException.class)
    public void testSetMajAgencyCat3() {
        queryBuilder.setMajAgencyCat("XY1");
    }

    /**
     * @todo This is another method that needs to throw a better (probably NPE)
     *  exception when the value passed in is null.
     */
    @Test(expected=NullPointerException.class)
    public void testSetMajAgencyCat4() {
        queryBuilder.setMajAgencyCat(null);
    }

    @Test
    public void testSetRecipCatTypeString1() {
        String uri = queryBuilder
            .setRecipCatType(DEFAULT_STRING)
            .getEscapedURI();

        assertEquals(
            "http://www.usaspending.gov?recip_cat_type=fubar", uri);
    }

    /**
     * @todo This is another method that needs to throw a better (probably NPE)
     *  exception when the value passed in is null.
     */
    @Test(expected=NullPointerException.class)
    public void testSetRecipCatTypeString2() {
        queryBuilder.setRecipCatType((String) null);
    }

    @Test
    public void testSetRecipCatTypeEnum1() {
        String uri = queryBuilder
            .setRecipCatType(RecipCatType.nonprofits)
            .getEscapedURI();

        assertEquals(
            "http://www.usaspending.gov?recip_cat_type=n", uri);
    }

    /**
     * @todo This is another method that needs to throw a better (probably NPE)
     *  exception when the value passed in is null.
     */
    @Test(expected=NullPointerException.class)
    public void testSetRecipCatType2() {
        queryBuilder.setRecipCatType((RecipCatType) null);
    }

    @Test
    public void testSetProjectDescription1() {
        String uri = queryBuilder
            .setProjectDescription(DEFAULT_STRING)
            .getEscapedURI();

        assertEquals(
            "http://www.usaspending.gov?project_description=fubar", uri);
    }

    /**
     * @todo This is another method that needs to throw a better (probably NPE)
     *  exception when the value passed in is null.
     */
    @Test(expected=NullPointerException.class)
    public void testSetProjectDescription4() {
        queryBuilder.setProjectDescription(null);
    }

    @Test
    public void testSetFederalAwardId1() {
        String uri = queryBuilder
            .setFederalAwardId(DEFAULT_STRING)
            .getEscapedURI();

        assertEquals(
            "http://www.usaspending.gov?federal_award_id=fubar", uri);
    }

    /**
     * @todo This is another method that needs to throw a better (probably NPE)
     *  exception when the value passed in is null.
     */
    @Test(expected=NullPointerException.class)
    public void testSetFederalAwardId2() {
        queryBuilder.setFederalAwardId(null);
    }

    @Test
    public void testSetPSCCat1() {
        String uri = queryBuilder
            .setPSCCat("XY")
            .getEscapedURI();

        assertEquals(
            "http://www.usaspending.gov?psc_cat=XY", uri);
    }

    /**
     * @todo This is another method that needs to throw a better (probably NPE)
     *  exception when the value passed in is null.
     */
    @Test(expected=NullPointerException.class)
    public void testSetPSCCat2() {
        queryBuilder.setPSCCat(null);
    }

    @Test(expected=InvalidFormatException.class)
    public void testSetPSCCat3() {
        queryBuilder.setPSCCat("a");
    }

    @Test(expected=InvalidFormatException.class)
    public void testSetPSCCat4() {
        queryBuilder.setPSCCat("abc");
    }

    @Test
    public void testSetPSCSub1() {
        String uri = queryBuilder
            .setPSCSub("WXYZ")
            .getEscapedURI();

        assertEquals(
            "http://www.usaspending.gov?psc_sub=WXYZ", uri);
    }

    /**
     * @todo This is another method that needs to throw a better (probably NPE)
     *  exception when the value passed in is null.
     */
    @Test(expected=NullPointerException.class)
    public void testSetPSCSub2() {
        queryBuilder.setPSCSub(null);
    }

    @Test(expected=InvalidFormatException.class)
    public void testSetPSCSub3() {
        queryBuilder.setPSCSub("abc");
    }

    @Test(expected=InvalidFormatException.class)
    public void testSetPSCSub4() {
        queryBuilder.setPSCSub("abcde");
    }

    @Test
    public void testSetDescriptionOfContractRequirement1() {
        String uri = queryBuilder
            .setDescriptionOfContractRequirement(DEFAULT_STRING)
            .getEscapedURI();

        assertEquals(
            "http://www.usaspending.gov?descriptionOfContractRequirement=fubar",
            uri);
    }

    /**
     * @todo This is another method that needs to throw a better (probably NPE)
     *  exception when the value passed in is null.
     */
    @Test(expected=NullPointerException.class)
    public void testSetDescriptionOfContractRequirement2() {
        queryBuilder.setDescriptionOfContractRequirement(null);
    }

    @Test
    public void testSetPIID1() {
        String uri = queryBuilder
            .setPIID(DEFAULT_STRING)
            .getEscapedURI();

        assertEquals(
            "http://www.usaspending.gov?PIID=fubar", uri);
    }

    /**
     * @todo This is another method that needs to throw a better (probably NPE)
     *  exception when the value passed in is null.
     */
    @Test(expected=NullPointerException.class)
    public void testSetPIID2() {
        queryBuilder.setPIID(null);
    }

    @Test
    public void testSetExtentCompete1() {
        String uri = queryBuilder
            .setExtentCompete(DEFAULT_STRING)
            .getEscapedURI();

        assertEquals(
            "http://www.usaspending.gov?extent_compete=fubar", uri);
    }

    /**
     * @todo This is another method that needs to throw a better (probably NPE)
     *  exception when the value passed in is null.
     */
    @Test(expected=NullPointerException.class)
    public void testSetExtentCompete2() {
        queryBuilder.setExtentCompete((String) null);
    }

    @Test
    public void testSetExtentCompete3() {
        String uri = queryBuilder
            .setExtentCompete(ExtentComplete.CDO)
            .getEscapedURI();

        assertEquals(
            "http://www.usaspending.gov?extent_compete=CDO", uri);
    }

    /**
     * @todo This is another method that needs to throw a better (probably NPE)
     *  exception when the value passed in is null.
     */
    @Test(expected=NullPointerException.class)
    public void testSetExtentCompete4() {
        queryBuilder.setExtentCompete((ExtentComplete) null);
    }

    @Test
    public void testSetDUNSNumber1() {
        String uri = queryBuilder
            .setDUNSNumber(DEFAULT_STRING)
            .getEscapedURI();

        assertEquals(
            "http://www.usaspending.gov?duns_number=fubar", uri);
    }

    /**
     * @todo This is another method that needs to throw a better (probably NPE)
     *  exception when the value passed in is null.
     */
    @Test(expected=NullPointerException.class)
    public void testSetDUNSNumber2() {
        queryBuilder.setDUNSNumber((String) null);
    }

    @Test
    public void testSetProgsrcAgenCode1() {
        String uri = queryBuilder
            .setProgsrcAgenCode(DEFAULT_STRING)
            .getEscapedURI();

        assertEquals(
            "http://www.usaspending.gov?progsrc_agen_code=fubar", uri);
    }

    /**
     * @todo This is another method that needs to throw a better (probably NPE)
     *  exception when the value passed in is null.
     */
    @Test(expected=NullPointerException.class)
    public void testSetProgsrcAgenCode2() {
        queryBuilder.setProgsrcAgenCode((String) null);
    }

    @Test
    public void testSetProgsrcAcntCode1() {
        String uri = queryBuilder
            .setProgsrcAcntCode(DEFAULT_STRING)
            .getEscapedURI();

        assertEquals(
            "http://www.usaspending.gov?progsrc_acnt_code=fubar", uri);
    }

    /**
     * @todo This is another method that needs to throw a better (probably NPE)
     *  exception when the value passed in is null.
     */
    @Test(expected=NullPointerException.class)
    public void testSetProgsrcAcntCode2() {
        queryBuilder.setProgsrcAcntCode((String) null);
    }

    @Test
    public void testSetProgramSourceAgencyCode1() {
        String uri = queryBuilder
            .setProgramSourceAgencyCode(DEFAULT_STRING)
            .getEscapedURI();

        assertEquals(
            "http://www.usaspending.gov?program_source_agency_code=fubar", uri);
    }

    /**
     * @todo This is another method that needs to throw a better (probably NPE)
     *  exception when the value passed in is null.
     */
    @Test(expected=NullPointerException.class)
    public void testSetProgramSourceAgencyCode2() {
        queryBuilder.setProgramSourceAgencyCode((String) null);
    }

    @Test
    public void testSetProgramSourceAccountCode1() {
        String uri = queryBuilder
            .setProgramSourceAccountCode(DEFAULT_STRING)
            .getEscapedURI();

        assertEquals(
            "http://www.usaspending.gov?program_source_account_code=fubar", uri);
    }

    /**
     * @todo This is another method that needs to throw a better (probably NPE)
     *  exception when the value passed in is null.
     */
    @Test(expected=NullPointerException.class)
    public void testSetProgramSourceAccountCode2() {
        queryBuilder.setProgramSourceAccountCode((String) null);
    }

    @Test
    public void testSetProgramSourceDesc1() {
        String uri = queryBuilder
            .setProgramSourceDesc(DEFAULT_STRING)
            .getEscapedURI();

        assertEquals(
            "http://www.usaspending.gov?program_source_desc=fubar", uri);
    }

    /**
     * @todo This is another method that needs to throw a better (probably NPE)
     *  exception when the value passed in is null.
     */
    @Test(expected=NullPointerException.class)
    public void testSetProgramSourceDesc2() {
        queryBuilder.setProgramSourceDesc((String) null);
    }

    @Test
    public void testSetBusnIndctrToR1() {
        String uri = queryBuilder
            .setBusnIndctrToR()
            .getEscapedURI();

        assertEquals(
            "http://www.usaspending.gov?busn_indctr=r", uri);
    }
}
