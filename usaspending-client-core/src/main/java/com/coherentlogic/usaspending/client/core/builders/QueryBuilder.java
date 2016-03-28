package com.coherentlogic.usaspending.client.core.builders;

import static com.coherentlogic.usaspending.client.core.util.Constants.AGENCY_CODE;
import static com.coherentlogic.usaspending.client.core.util.Constants.ASST_CAT_TYPE;
import static com.coherentlogic.usaspending.client.core.util.Constants.BUSN_INDCTR;
import static com.coherentlogic.usaspending.client.core.util.Constants.CFDA_PROGRAM_NUM;
import static com.coherentlogic.usaspending.client.core.util.Constants.CITY;
import static com.coherentlogic.usaspending.client.core.util.Constants.COMPANY_NAME;
import static com.coherentlogic.usaspending.client.core.util.Constants.DESCRIPTION_OF_CONTRACT_REQUIREMENT;
import static com.coherentlogic.usaspending.client.core.util.Constants.DETAIL;
import static com.coherentlogic.usaspending.client.core.util.Constants.DUNS_NUMBER;
import static com.coherentlogic.usaspending.client.core.util.Constants.EXTENT_COMPLETE;
import static com.coherentlogic.usaspending.client.core.util.Constants.FEDERAL_AWARD_ID;
import static com.coherentlogic.usaspending.client.core.util.Constants.FIRST_YEAR_RANGE;
import static com.coherentlogic.usaspending.client.core.util.Constants.FISCAL_YEAR;
import static com.coherentlogic.usaspending.client.core.util.Constants.LAST_YEAR_RANGE;
import static com.coherentlogic.usaspending.client.core.util.Constants.MAJ_AGENCY_CAT;
import static com.coherentlogic.usaspending.client.core.util.Constants.MAX_RECORDS;
import static com.coherentlogic.usaspending.client.core.util.Constants.MAX_RECORDS_MAX_VALUE;
import static com.coherentlogic.usaspending.client.core.util.Constants.MOD_AGENCY;
import static com.coherentlogic.usaspending.client.core.util.Constants.PIID;
import static com.coherentlogic.usaspending.client.core.util.Constants.PLACE_OF_PERFORMANCE_COUNTRY_CODE;
import static com.coherentlogic.usaspending.client.core.util.Constants.PLACE_OF_PERFORMANCE_ZIP_CODE;
import static com.coherentlogic.usaspending.client.core.util.Constants.POP_CD;
import static com.coherentlogic.usaspending.client.core.util.Constants.PRIME_AWARD_NUMBER;
import static com.coherentlogic.usaspending.client.core.util.Constants.PRIME_AWARD_PROGRAM_SOURCE_ACCOUNT_CODE;
import static com.coherentlogic.usaspending.client.core.util.Constants.PRIME_AWARD_PROGRAM_SOURCE_AGENCY_CODE;
import static com.coherentlogic.usaspending.client.core.util.Constants.PRIME_ORDER_NUMBER;
import static com.coherentlogic.usaspending.client.core.util.Constants.PRINCIPAL_PLACE_CC;
import static com.coherentlogic.usaspending.client.core.util.Constants.PRINCIPAL_PLACE_STATE_CODE;
import static com.coherentlogic.usaspending.client.core.util.Constants.PROGRAM_SOURCE_ACCOUNT_CODE;
import static com.coherentlogic.usaspending.client.core.util.Constants.PROGRAM_SOURCE_AGENCY_CODE;
import static com.coherentlogic.usaspending.client.core.util.Constants.PROGRAM_SOURCE_DESC;
import static com.coherentlogic.usaspending.client.core.util.Constants.PROGSRC_ACNT_CODE;
import static com.coherentlogic.usaspending.client.core.util.Constants.PROGSRC_AGEN_CODE;
import static com.coherentlogic.usaspending.client.core.util.Constants.PROJECT_DESCRIPTION;
import static com.coherentlogic.usaspending.client.core.util.Constants.PSC_CAT;
import static com.coherentlogic.usaspending.client.core.util.Constants.PSC_SUB;
import static com.coherentlogic.usaspending.client.core.util.Constants.R;
import static com.coherentlogic.usaspending.client.core.util.Constants.RECIPIENT_CD;
import static com.coherentlogic.usaspending.client.core.util.Constants.RECIPIENT_CITY_NAME;
import static com.coherentlogic.usaspending.client.core.util.Constants.RECIPIENT_COUNTRY_NAME;
import static com.coherentlogic.usaspending.client.core.util.Constants.RECIPIENT_OF_ASSISTANCE;
import static com.coherentlogic.usaspending.client.core.util.Constants.RECIPIENT_STATE_CODE;
import static com.coherentlogic.usaspending.client.core.util.Constants.RECIPIENT_ZIP;
import static com.coherentlogic.usaspending.client.core.util.Constants.RECIP_CAT_TYPE;
import static com.coherentlogic.usaspending.client.core.util.Constants.RECORDS_FROM;
import static com.coherentlogic.usaspending.client.core.util.Constants.SORT_BY;
import static com.coherentlogic.usaspending.client.core.util.Constants.SPENDING_TYPE;
import static com.coherentlogic.usaspending.client.core.util.Constants.STATE;
import static com.coherentlogic.usaspending.client.core.util.Constants.STATE_CODE;
import static com.coherentlogic.usaspending.client.core.util.Constants.SUBAWARDEE_CD;
import static com.coherentlogic.usaspending.client.core.util.Constants.SUBAWARDEE_CITY_NAME;
import static com.coherentlogic.usaspending.client.core.util.Constants.SUBAWARDEE_COUNTRY;
import static com.coherentlogic.usaspending.client.core.util.Constants.SUBAWARDEE_DUNS_NUMBER;
import static com.coherentlogic.usaspending.client.core.util.Constants.SUBAWARDEE_NAME;
import static com.coherentlogic.usaspending.client.core.util.Constants.SUBAWARDEE_POP_CD;
import static com.coherentlogic.usaspending.client.core.util.Constants.SUBAWARDEE_POP_COUNTRY;
import static com.coherentlogic.usaspending.client.core.util.Constants.SUBAWARDEE_POP_STATE;
import static com.coherentlogic.usaspending.client.core.util.Constants.SUBAWARDEE_POP_ZIP;
import static com.coherentlogic.usaspending.client.core.util.Constants.SUBAWARDEE_STATE_CODE;
import static com.coherentlogic.usaspending.client.core.util.Constants.SUBAWARDEE_ZIP;
import static com.coherentlogic.usaspending.client.core.util.Constants.SUBAWARD_PROJECT_DESCRIPTION;
import static com.coherentlogic.usaspending.client.core.util.Constants.VENDOR_CD;
import static com.coherentlogic.usaspending.client.core.util.Constants.VENDOR_COUNTRY_CODE;
import static com.coherentlogic.usaspending.client.core.util.Constants.ZIP_CODE;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ws.rs.core.UriBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import com.coherentlogic.coherent.data.model.core.builders.rest.AbstractRESTQueryBuilder;
import com.coherentlogic.coherent.data.model.core.cache.CacheServiceProviderSpecification;
import com.coherentlogic.usaspending.client.core.exceptions.InvalidFormatException;
import com.coherentlogic.usaspending.client.core.exceptions.ValueOutOfBoundsException;

/**
 * Builder class for working with the USASpending.gov web services.
 *
 * The base URI is as follows:
 *
 * http://www.usaspending.gov
 *
 * Methods in this class allow the developer to extend the base URI as well as
 * to set parameter name/value pairs.
 *
 * @see <a href="http://www.usaspending.gov/data">USASpending.gov</a>
 *
 * @todo Note that methods that don't check for a format will throw an NPE when
 *  called with a null arg juxtaposed with a method that checks for a specific
 *  format, which throws IllegalArgumentException when null is passed. This is
 *  inconsistent and should be made uniform for all scenarios. Same applies to
 *  enum params.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class QueryBuilder extends AbstractRESTQueryBuilder {

    public static final String USA_SPENDING_URL = "https://www.usaspending.gov/",
        FAADS_PATH = "/faads/faads.php",
        FPDS_PATH = "/fpds/fpds.php",
        FSRS_PATH = "/fsrs/fsrs.php";

    private static final Logger log = LoggerFactory
        .getLogger(QueryBuilder.class);

    static {
        log.warn("***********************************************************");
        log.warn("*** Welcome to the Coherent Logic USA Spending Client   ***");
        log.warn("***              version 1.0.1-RELEASE.                 ***");
        log.warn("***********************************************************");
    }

    private static final String YEAR_FORMAT = "\\d\\d\\d\\d",
        TWO_LETTER_FORMAT = "[a-zA-Z0-9]{2}",
        FOUR_LETTER_FORMAT = "[a-zA-Z0-9]{4}";

    private static final Pattern yearFormatPattern =
        Pattern.compile(YEAR_FORMAT),
        twoLetterPattern = Pattern.compile(TWO_LETTER_FORMAT),
        fourLetterPattern = Pattern.compile(FOUR_LETTER_FORMAT);

    public QueryBuilder(
        RestTemplate restTemplate,
        String uri,
        CacheServiceProviderSpecification<String, Object>
            cacheServiceProviderSpecification
    ) {
        super(restTemplate, uri, cacheServiceProviderSpecification);
    }

    public QueryBuilder(
        RestTemplate restTemplate,
        CacheServiceProviderSpecification<String, Object> cacheServiceProviderSpecification
    ) {
        super(restTemplate, USA_SPENDING_URL, cacheServiceProviderSpecification);
    }

    public QueryBuilder(RestTemplate restTemplate) {
        super(restTemplate, USA_SPENDING_URL);
    }

    public QueryBuilder(
        RestTemplate restTemplate,
        String uri
    ) {
        super(restTemplate, uri);
    }

    public QueryBuilder(
        RestTemplate restTemplate,
        UriBuilder uriBuilder
    ) {
        super(restTemplate, uriBuilder);
    }

    /**
     * Method checks that the year conforms to the expected format and throws an
     * exception if it doesn't.
     *
     * @param year The actual year value.
     *
     * @throws InvalidFormatException if the year is not in the format YYYY.
     */
    static void checkYearFormat (String year) {

        boolean matches = false;

        Matcher matcher = null;

        if (year != null) {
            matcher = yearFormatPattern.matcher(year);

            if (matcher.matches())
                matches = true;
        }

        if (!matches)
            throw new InvalidFormatException ("The year '" + year + "' does " +
                "not conform to the expected format YYYY -- for " +
                "example '1992'.");
    }

    /**
     *
     */
    static void assertStringHasCompliantFormat (
        Pattern pattern, String parameterName, String parameterValue) {

        boolean matches = false;

        Matcher matcher = null;

        if (parameterValue != null) {
            matcher = pattern.matcher(parameterValue);

            if (matcher.matches())
                matches = true;
        } else
            throw new NullPointerException (
                "The parameter named '" + parameterName + "' is null.");

        if (!matches)
            throw new InvalidFormatException (
                "The parameter named '" + parameterName + "' " +
                "contains the text '" + parameterValue + "', which does not " +
                "conform to the expected format.");
    }

    /**
     *
     */
    static void assertStringHasTwoLetters (
        String parameterName, String parameterValue) {
        assertStringHasCompliantFormat (
            twoLetterPattern, parameterName, parameterValue);
    }

    /**
     *
     */
    static void assertStringHasFourLetters (
        String parameterName, String parameterValue) {
        assertStringHasCompliantFormat (
            fourLetterPattern, parameterName, parameterValue);
    }

    /**
     * Method adds /fpds/fpds.php to the base uri.
     */
    public QueryBuilder fpds () {
        extendPathWith(FPDS_PATH);
        return this;
    }

    /**
     * Method adds /faads/faads.php to the base uri.
     */
    public QueryBuilder faads () {
        extendPathWith(FAADS_PATH);
        return this;
    }

    /**
     * Method adds /fsrs/fsrs.php to the base uri.
     */
    public QueryBuilder fsrs () {
        extendPathWith(FSRS_PATH);
        return this;
    }

    /**
     * Method converts the enumeration into a String.
     *
     * @throws NullPointerException if the enumeration is null.
     */
    static String toString (Enum<?> enumeration) {

        String result = null;

        if (enumeration != null)
            result = enumeration.toString();
        else throw new NullPointerException("The enumeration reference was " +
            "null.");

        return result;
    }

    /**
     * Controls which type of output -- which "level of detail" -- you get.
     *
     * Defaults to b (basic) if not set.
     */
    public QueryBuilder setDetail (Detail detail) {

        addParameter(DETAIL, toString (detail));

        return this;
    }

    /**
     * Determines how records are sorted.
     *
     * Defaults to sort by dollars if not provided.
     *
     * Sorting functionality is not available for the following level of details
     * (Summary, Low, and Medium)
     */
    public QueryBuilder setSortBy (SortBy sortBy) {

        addParameter(SORT_BY, toString (sortBy));

        return this;
    }

    /**
     * The type of spending for the award. Valid values are:
     * c = Contracts
     * g = Grants
     *
     * Defaults to both if not provided.
     */
    public QueryBuilder setSpendingType (SpendingType spendingType) {

        addParameter(SPENDING_TYPE, toString (spendingType));

        return this;
    }

    /**
     * Allows you to set the maximum number of records retrieved to fewer than
     * 1000.
     *
     * Note that setting maxRecords to a value greater than 1000 will result in
     * only 1000 records being returned.
     *
     * Setting maxRecords to 0 will return 0 records.
     *
     * Setting maxRecords to -100, for example, will return in the following:
     *
     * Catchable fatal error: Argument 1 passed to DOMDocument::importNode()
     * must be an instance of DOMNode, null given in /usr/usas/mainsite/html/api
     * /fpds_api_complete.php on line 34
     *
     * <a href="http://www.usaspending.gov/fpds/fpds.php?fiscal_year=2009
     *  &stateCode=TX&detail=c&max_records=5000">Example</a>
     */
    public QueryBuilder setMaxRecords (int maxRecords) {

        String message = "The maxRecords value should be between 0 and " +
                MAX_RECORDS + " however the value was actually " + maxRecords;

        if (0 <= maxRecords && maxRecords <= MAX_RECORDS_MAX_VALUE)
            addParameter(MAX_RECORDS, "" + maxRecords);
        // Below will work, though only 1000 records will be returned.
        else if (MAX_RECORDS_MAX_VALUE <= maxRecords) {
            log.warn(message);
            addParameter(MAX_RECORDS, Integer.toString(maxRecords));
        } else // maxRecords <= 0, which is illegal.
            throw new ValueOutOfBoundsException("The maxRecords value should " +
                "be between 0 and " + MAX_RECORDS + " however the value was " +
                "actually " + maxRecords);

        return this;
    }

    /**
     * Allows you to set the starting position of the records to be retrieved.
     *
     * @see <a href="http://www.usaspending.gov/api/fpds_api_complete.php?
     *  fiscal_year=2009&pop_state=TX&Contracts=c&sortby=DOLLARS_OBLIGATED%2B
     *  desc&records_from=2000&max_records=500&sortby=DOLLARS_OBLIGATED+desc">
     *  Example</a>
     */
    public QueryBuilder setRecordsFrom (int recordsFrom) {

        if (recordsFrom < 0)
            throw new ValueOutOfBoundsException("The value of the recordsFrom" +
                " variable is invalid (recordsFrom: " + ").");

        addParameter(RECORDS_FROM, Integer.toString(recordsFrom));

        return this;
    }

    /**
     * Specifies a single year; defaults to all years.
     *
     * @see <a href="www.usaspending.gov/api/fpds_api_complete.php?
     *  fiscal_year=2009&pop_state=TX&Contracts=c&sortby=DOLLARS_OBLIGATED%2B
     *  desc&records_from=2000&max_records=500&sortby=DOLLARS_OBLIGATED+desc"/>
     *  Example</a>
     */
    public QueryBuilder setFiscalYear (String fiscalYear) {

        checkYearFormat (fiscalYear);

        addParameter(FISCAL_YEAR, "" + fiscalYear);

        return this;
    }

    /**
     * Specifies the first year in a range of years; if used, must be used with
     * last_year_range and without fiscal_year (note that the framework does
     * not check for this and if the values are not set correctly the server
     * will fail the request).
     */
    public QueryBuilder setFirstYearRange(String firstYearRange) {

        checkYearFormat (firstYearRange);

        addParameter(FIRST_YEAR_RANGE, "" + firstYearRange);

        return this;
    }

    /**
     * Specifies the last year in a range of years; if used, must be used with
     * first_year_range and without fiscal_year (note that the framework does
     * not check for this and if the values are not set correctly the server
     * will fail the request).
     */
    public QueryBuilder setLastYearRange (String lastYearRange) {

        checkYearFormat (lastYearRange);

        addParameter(LAST_YEAR_RANGE, lastYearRange);

        return this;
    }

    /**
     * The name of a recipient of assistance.
     */
    public QueryBuilder setRecipientOfAssistance (
        String recipientOfAssistance) {

        addParameter(RECIPIENT_OF_ASSISTANCE, recipientOfAssistance);

        return this;
    }

    /**
     * The city in the address of a recipient.
     */
    public QueryBuilder setRecipientCityName (
        String recipientCityName) {

        addParameter(RECIPIENT_CITY_NAME, recipientCityName);

        return this;
    }

    /**
     * The FIPS state code for the state in the address of a recipient. See
     * <a href="javascript:apiMore_window('FIPS')">here</a> for list.
     */
    public QueryBuilder setRecipientStateCode (
        String recipientStateCode) {

        addParameter(RECIPIENT_STATE_CODE, recipientStateCode);

        return this;
    }

    /**
     * The ZIP code in the address of a recipient.
     */
    public QueryBuilder setRecipientZIP (
        String recipientZIP) {

        addParameter(RECIPIENT_ZIP, recipientZIP);

        return this;
    }

    /**
     * The county in which a recipient is located.
     */
    public QueryBuilder setRecipientCountryName (
        String recipientCountryName) {

        addParameter(RECIPIENT_COUNTRY_NAME, recipientCountryName);

        return this;
    }

    /**
     * The Congressional District in which the recipient is located, formatted
     * with four characters. See <a href="http://www.usaspending.gov/customcode/
     * apidocsmore_popup.php?printnav=0#CDS">here</a> for list.
     */
    public QueryBuilder setRecipientCD (
        String recipientCD) {

        addParameter(RECIPIENT_CD, recipientCD);

        return this;
    }

    /**
     * The FIPS state code for the state of the place of performance. See
     * <a href="http://www.usaspending.gov/customcode/apidocsmore_popup.php?
     * printnav=0#FIPS">here</a> for list.
     */
    public QueryBuilder setPrincipalPlaceStateCode (
        String principalPlaceStateCode) {

        addParameter(PRINCIPAL_PLACE_STATE_CODE, principalPlaceStateCode);

        return this;
    }

    /**
     * The city or county of the place of performance.
     */
    public QueryBuilder setPrincipalPlaceCC (
        String principalPlaceCC) {

        addParameter(PRINCIPAL_PLACE_CC, principalPlaceCC);

        return this;
    }

    /**
     * The 4-character code for a specific governmental agency providing
     * assistance. See <a href="http://www.usaspending.gov/customcode/
     * apidocsmore_popup.php?printnav=0#FAADS_AGENCY">here</a> for list.
     */
    public QueryBuilder setAgencyCode (
        String agencyCode) {

        addParameter(AGENCY_CODE, agencyCode);

        return this;
    }

    /**
     * The name of a a contractor or contractor parent company.
     */
    public QueryBuilder setCompanyName (String companyName) {

        addParameter(COMPANY_NAME, companyName);

        return this;
    }

    /**
     * The city within a contractor's address.
     */
    public QueryBuilder setCity (String city) {

        addParameter(CITY, city);

        return this;
    }

    /**
     * The state abbreviation within a contractor's address.
     */
    public QueryBuilder setState (String state) {

        addParameter(STATE, state);

        return this;
    }

    /**
     * The ZIP code within a contractor's address.
     */
    public QueryBuilder setZIPCode (String zipCode) {

        addParameter(ZIP_CODE, zipCode);

        return this;
    }

    /**
     * The two-letter country code for the country in a contractor's address.
     *
     * @see <a href="http://www.usaspending.gov/customcode/apidocsmore_popup.php
     *  ?printnav=0#COUNTRIES">Countries</a>
     * @see http://www.usaspending.gov/data
     */
    public QueryBuilder setVendorCountryCode (String vendorCountryCode) {

        assertStringHasTwoLetters (VENDOR_COUNTRY_CODE, vendorCountryCode);

        addParameter(VENDOR_COUNTRY_CODE, vendorCountryCode);

        return this;
    }

    /**
     * The two-letter country code for the country in a contractor's address.
     *
     * @see <a href="http://www.usaspending.gov/customcode/apidocsmore_popup.php
     *  ?printnav=0#COUNTRIES">Countries</a>
     * @see http://www.usaspending.gov/data
     */
    public QueryBuilder setVendorCountryCode (CountryCode countryCode) {
        return this.setVendorCountryCode(toString (countryCode));
    }

    /**
     * The 4-character Congressional District within which a contractor is
     * located.
     *
     * @see <a href="http://www.usaspending.gov/customcode/apidocsmore_popup.php
     *  ?printnav=0#CDS">Here</a>
     *
     * @todo This method throws InvalidFormatException when null is passed,
     *  however we should endeavour to make this uniform as other methods throw
     *  an NPE when null is passed in.
     */
    public QueryBuilder setVendorCD (String vendorCD) {

        assertStringHasFourLetters(VENDOR_CD, vendorCD);

        addParameter(VENDOR_CD, vendorCD);

        return this;
    }

    /**
     * The Congressional District of the place of performance. See <a
     * href="http://www.usaspending.gov/customcode/apidocsmore_popup.php?
     * printnav=0#CDS">here</a> for list.
     */
    public QueryBuilder setPopCD (String popCD) {

        assertStringHasFourLetters(POP_CD, popCD);

        addParameter(POP_CD, popCD);

        return this;
    }

    /**
     * The state abbreviation of the state of the place of performance.
     *
     * @todo Should we check for the state code being two letters?
     */
    public QueryBuilder setStateCode (String stateCode) {

        addParameter(STATE_CODE, stateCode);

        return this;
    }

    /**
     * The name of a subcontractor or subcontractor parent company.
     */
    public QueryBuilder setSubawardeeName (String subawardeeName) {

        addParameter(SUBAWARDEE_NAME, subawardeeName);

        return this;
    }

    /**
     * The city within a subcontractor's address.
     */
    public QueryBuilder setSubawardeeCityName (String subawardeeCityName) {

        addParameter(SUBAWARDEE_CITY_NAME, subawardeeCityName);

        return this;
    }

    /**
     * The state abbreviation within a subcontractor's address.
     */
    public QueryBuilder setSubawardeeStateCode (String subawardeeStateCode) {

        addParameter(SUBAWARDEE_STATE_CODE, subawardeeStateCode);

        return this;
    }

    /**
     * The ZIP code within a subcontractor's address.
     */
    public QueryBuilder setSubawardeeZIP (String subawardeeZIP) {

        addParameter(SUBAWARDEE_ZIP, subawardeeZIP);

        return this;
    }

    /**
     * The two-letter country code for the country in a subcontractor's address.
     * See <a href="http://www.usaspending.gov/customcode/apidocsmore_popup.php?
     * printnav=0#COUNTRIES">here</a> for list.
     */
    public QueryBuilder setSubawardeeCountry (String subawardeeCountry) {

        assertStringHasTwoLetters(SUBAWARDEE_COUNTRY, subawardeeCountry);

        addParameter(SUBAWARDEE_COUNTRY, subawardeeCountry);

        return this;
    }

    /**
     * The 4-character Congressional District within which a subcontractor is
     * located. See <a href="http://www.usaspending.gov/customcode/
     * apidocsmore_popup.php?printnav=0#CDS">here</a> for list.
     */
    public QueryBuilder setSubawardeeCD (String subawardeeCD) {

        assertStringHasFourLetters(SUBAWARDEE_CD, subawardeeCD);

        addParameter(SUBAWARDEE_CD, subawardeeCD);

        return this;
    }

    /**
     * The Congressional District of the place of performance. See <a
     * href="http://www.usaspending.gov/customcode/apidocsmore_popup.php?
     * printnav=0#CDS">here</a> for list.
     */
    public QueryBuilder setSubawardeePopCD (String subawardeePopCD) {

        assertStringHasFourLetters(SUBAWARDEE_POP_CD, subawardeePopCD);

        addParameter(SUBAWARDEE_POP_CD, subawardeePopCD);

        return this;
    }

    /**
     * The state abbreviation of the state of the place of performance.
     *
     * @todo Is this a state abbreviation? If yes then we should check for only
     *  two letters.
     */
    public QueryBuilder setSubawardeePopState (String subawardeePopState) {

        assertStringHasTwoLetters(SUBAWARDEE_POP_STATE, subawardeePopState);

        addParameter(SUBAWARDEE_POP_STATE, subawardeePopState);

        return this;
    }

    /**
     * The ZIP code of the place of performance.
     */
    public QueryBuilder setSubawardeePopZIP (String subawardeePopZIP) {

        addParameter(SUBAWARDEE_POP_ZIP, subawardeePopZIP);

        return this;
    }

    /**
     * The two-letter country code for the place of performance country.
     * See <a href="http://www.usaspending.gov/customcode/apidocsmore_popup.php?
     * printnav=0#COUNTRIES">here</a> for list.
     */
    public QueryBuilder setSubawardeePopCountry (String subawardeePopCountry) {

        assertStringHasTwoLetters(SUBAWARDEE_POP_COUNTRY, subawardeePopCountry);

        addParameter(SUBAWARDEE_POP_COUNTRY, subawardeePopCountry);

        return this;
    }

    /**
     * Free text search within the text that describes what the contract is for.
     */
    public QueryBuilder setSubawardProjectDescription (
        String subawardProjectDescription) {

        addParameter(SUBAWARD_PROJECT_DESCRIPTION,
            subawardProjectDescription);

        return this;
    }

    /**
     * Applicable for both Contracts and Grants. Enter Procurement Instrument
     * Identifier (PIID) for Contracts, for grants enter Federal Award
     * Identification Number (FAIN).
     *
     * @todo Is this an actual number or does this contain letters? 
     */
    public QueryBuilder setPrimeAwardNumber (
        String primeAwardNumber) {

        addParameter(PRIME_AWARD_NUMBER,
            primeAwardNumber);

        return this;
    }

    /**
     * Applicable for only Contracts data. Enter IDV Procurement Instrument
     * Identifier (IDV PIID).
     *
     * @todo Is this an actual number or does this contain letters?
     */
    public QueryBuilder setPrimeOrderNumber (
        String primeOrderNumber) {

        addParameter(PRIME_ORDER_NUMBER,
            primeOrderNumber);

        return this;
    }

    /**
     * The subcontractor duns number.
     *
     * @todo See if there's a format for the DUNS number and if this exists, add
     *  some checks to ensure the subawardeeDunsNumber conforms to this format.
     */
    public QueryBuilder setSubawardeeDunsNumber (
        String subawardeeDunsNumber) {

        addParameter(SUBAWARDEE_DUNS_NUMBER,
            subawardeeDunsNumber);

        return this;
    }

    /**
     * The program source agency code.
     *
     * @todo Determine if this actually a number and, if it is, check the format
     *  of calls to this method (also overload this method so an actual number
     *  can be passed in).
     */
    public QueryBuilder setPrimeAwardProgramSourceAgencyCode (
        String primeAwardProgramSourceAgencyCode) {

        addParameter(PRIME_AWARD_PROGRAM_SOURCE_AGENCY_CODE,
            primeAwardProgramSourceAgencyCode);

        return this;
    }

    /**
     * The program source account code.
     *
     * @todo Determine if this actually a number and, if it is, check the format
     *  of calls to this method (also overload this method so an actual number
     *  can be passed in).
     */
    public QueryBuilder setPrimeAwardProgramSourceAccountCode (
        String primeAwardProgramSourceAccountCode) {

        addParameter(PRIME_AWARD_PROGRAM_SOURCE_ACCOUNT_CODE,
            primeAwardProgramSourceAccountCode);

        return this;
    }

    /**
     * The ZIP code of the place of performance.
     *
     * @todo Should we check the format of the ZIP code?
     */
    public QueryBuilder setPlaceOfPerformanceZIPCode (
        String placeOfPerformanceZIPCode) {

        addParameter(PLACE_OF_PERFORMANCE_ZIP_CODE, placeOfPerformanceZIPCode);

        return this;
    }

    /**
     * The two-letter country code for the place of performance country. See
     * here for list.
     *
     * @todo Should we check the format of the country code?
     */
    public QueryBuilder setPlaceOfPerformanceCountryCode (
        String placeOfPerformanceCountryCode) {

        assertStringHasTwoLetters (PLACE_OF_PERFORMANCE_COUNTRY_CODE,
            placeOfPerformanceCountryCode);

        addParameter(PLACE_OF_PERFORMANCE_COUNTRY_CODE,
            placeOfPerformanceCountryCode);

        return this;
    }

    /**
     * The 4-digit code for a specific governmental agency issuing contracts.
     * See <a href="http://www.usaspending.gov/customcode/apidocsmore_popup.php?
     * printnav=0#FPDS_AGENCY">here</a> for list.
     */
    public QueryBuilder setModAgency (String modAgency) {

        // Note that the modAgency param may consist of both letters and
        // numbers.

        assertStringHasFourLetters(MOD_AGENCY, modAgency);

        addParameter(MOD_AGENCY, modAgency);

        return this;
    }

    /**
     * The 2-character code for a major governmental agency issuing contracts.
     * See <a href="http://www.usaspending.gov/customcode/apidocsmore_popup.php?
     * printnav=0#FPDS_MAJAGENCY">here</a> for list.
     *
     * @todo Must check that this is two digits only!
     */
    public QueryBuilder setMajAgencyCat (String majAgencyCat) {

        // Note that the majAgencyCat param may consist of both letters and
        // numbers.

        assertStringHasTwoLetters(MAJ_AGENCY_CAT, majAgencyCat);

        addParameter(MAJ_AGENCY_CAT, majAgencyCat);

        return this;
    }

    /**
     * The type of recipient. Valid values are:
     * f = For Profits
     * g = Government
     * h = Higher Education
     * i = Individuals
     * n = Nonprofits
     * o = Other
     */
    public QueryBuilder setRecipCatType (String recipCatType) {

        addParameter(RECIP_CAT_TYPE, recipCatType);

        return this;
    }

    /**
     * The type of recipient. Valid values are:
     * f = For Profits
     * g = Government
     * h = Higher Education
     * i = Individuals
     * n = Nonprofits
     * o = Other
     */
    public QueryBuilder setRecipCatType (RecipCatType recipCatType) {
        return setRecipCatType (toString (recipCatType));
    }

    /**
     * The type of assistance provided. Valid values are:
     *
     * d = Direct Payments (both specified and unrestricted)
     * g = Grants and Cooperative Agreements
     * i = Insurance
     * l = Loans (both direct and guaranteed)
     * o = Other
     *
     * @todo Review the unit tests for this method as this throws two different
     *  exceptions depending on the string or enum being null, and this should
     *  instead be uniform (ie one exception only).
     */
    public QueryBuilder setAsstCatType (String asstCatType) {
        addParameter (ASST_CAT_TYPE, asstCatType);

        return this;
    }

    /**
     * The type of assistance provided. Valid values are:
     *
     * d = Direct Payments (both specified and unrestricted)
     * g = Grants and Cooperative Agreements
     * i = Insurance
     * l = Loans (both direct and guaranteed)
     * o = Other
     */
    public QueryBuilder setAsstCatType (AsstCatType asstCatType) {
        return setAsstCatType (toString (asstCatType));
    }

    /**
     * A free text search on a description of the project.
     */
    public QueryBuilder setProjectDescription (String projectDescription) {
        addParameter (PROJECT_DESCRIPTION, projectDescription);

        return this;
    }

    /**
     * An ID for the governmental program. See <a href="http://www.usaspending.
     * gov/customcode/apidocsmore_popup.php?printnav=0#CFDA">here</a> for list.
     *
     * @todo Determine the type for cfdaProgramNum -- is this actually a number?
     *  If it is, overload this method so the user can submit a number.
     */
    public QueryBuilder setCFDAProgramNum (String cfdaProgramNum) {
        addParameter (CFDA_PROGRAM_NUM, cfdaProgramNum);

        return this;
    }

    /**
     * A Federal ID for the award.
     */
    public QueryBuilder setFederalAwardId (String federalAwardId) {
        addParameter (FEDERAL_AWARD_ID, federalAwardId);

        return this;
    }

    /**
     * The 2-character code for a major product or service category.
     * See <a href="http://www.usaspending.gov/customcode/apidocsmore_popup.php?
     * printnav=0#PSCCAT">here</a> for list.
     *
     * @todo Must check that this is two digits only!
     */
    public QueryBuilder setPSCCat (String pscCat) {

        assertStringHasTwoLetters (PSC_CAT, pscCat);

        addParameter(PSC_CAT, pscCat);

        return this;
    }

    /**
     * The 4-character code for a product or service. See here for list.
     */
    public QueryBuilder setPSCSub (String pscSub) {

        assertStringHasFourLetters(PSC_SUB, pscSub);

        addParameter(PSC_SUB, pscSub);

        return this;
    }

    /**
     * Free text search within the text that describes what the contract is for.
     */
    public QueryBuilder setDescriptionOfContractRequirement (
        String descriptionOfContractRequirement) {

        addParameter(DESCRIPTION_OF_CONTRACT_REQUIREMENT,
            descriptionOfContractRequirement);

        return this;
    }

    /**
     * A Federal ID number for the contract.
     */
    public QueryBuilder setPIID (String piId) {

        addParameter(PIID, piId);

        return this;
    }

    /**
     * The extent competed status of a contract. Values are:
     *
     * G = Not Competed under SAP
     * F = Competed under SAP
     * E = Follow On to Competed Action
     * NDO = Non-Competitive Delivery Order
     * D = Full and Open Competition after exclusion of sources
     * C = Not Competed
     * B = Not Available for Competition
     * A = Full and Open Competition
     * CDO = Competitive Delivery Order
     */
    public QueryBuilder setExtentCompete (ExtentComplete extentComplete) {
        return setExtentCompete(toString (extentComplete));
    }

    /**
     * The extent competed status of a contract. Values are:
     *
     * G = Not Competed under SAP
     * F = Competed under SAP
     * E = Follow On to Competed Action
     * NDO = Non-Competitive Delivery Order
     * D = Full and Open Competition after exclusion of sources
     * C = Not Competed
     * B = Not Available for Competition
     * A = Full and Open Competition
     * CDO = Competitive Delivery Order
     */
    public QueryBuilder setExtentCompete (String extentComplete) {

        addParameter(EXTENT_COMPLETE, extentComplete);

        return this;
    }

    /**
     * The contractor duns number.
     *
     * @todo Determine if it makes sense to enforce a duns number format?
     */
    public QueryBuilder setDUNSNumber (String dunsNumber) {

        addParameter(DUNS_NUMBER, dunsNumber);

        return this;
    }

    /**
     * The program source agency code.
     */
    public QueryBuilder setProgsrcAgenCode (String progsrcAgenCode) {

        addParameter(PROGSRC_AGEN_CODE, progsrcAgenCode);

        return this;
    }

    /**
     * The program source account code.
     */
    public QueryBuilder setProgsrcAcntCode (String progsrcAcntCode) {

        addParameter(PROGSRC_ACNT_CODE, progsrcAcntCode);

        return this;
    }

    /**
     * The program source agency code.
     */
    public QueryBuilder setProgramSourceAgencyCode (
        String programSourceAgencyCode) {

        addParameter(PROGRAM_SOURCE_AGENCY_CODE, programSourceAgencyCode);

        return this;
    }

    /**
     * The program source account code.
     */
    public QueryBuilder setProgramSourceAccountCode (
        String programSourceAccountCode) {

        addParameter(PROGRAM_SOURCE_ACCOUNT_CODE, programSourceAccountCode);

        return this;
    }

    /**
     * Full text search of program source description.
     */
    public QueryBuilder setProgramSourceDesc (String programSourceDesc) {

        addParameter(PROGRAM_SOURCE_DESC, programSourceDesc);

        return this;
    }

    /**
     * Assigns "r" as the Business Fund Indicator (where "r" equates to funds
     * provided by Recovery Act).
     */
    public QueryBuilder setBusnIndctrToR() {
        return setBusnIndctr (R);
    }

    /**
     * Determines the Business Fund Indicator.
     *
     * Note that the only currently valid value is "r", which equates to funds
     * provided by Recovery Act.
     */
    public QueryBuilder setBusnIndctr(String busnIndctr) {

        addParameter(BUSN_INDCTR, busnIndctr);

        return this;
    }
}
