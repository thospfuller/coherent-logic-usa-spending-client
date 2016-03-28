package com.coherentlogic.usaspending.client.core.util;


/**
 * A class which contains various constants that are used in this project.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class Constants {

    public static final String
        SUMMARY = "s",
        LOW = "l",
        MEDIUM = "m",
        BASIC = "b",
        COMPLETE = "c",
        FOR_PROFIT = "f",
        GOVERNMENT = "g",
        HIGHER_EDUCATION = "h",
        INDIVIDUALS = "i",
        NON_PROFITS = "n",
        OTHER = "o",
        BY_CONTRACTOR_OR_RECIPIENT_NAME = "r",
        BY_DOLLARS_OF_AWARDS_IN_DECENDING_ORDER = "f",
        BY_MAJOR_CONTRACTING_AGENCY = "g",
        BY_CFDA_PROGRAM = "p",
        BY_DATE_OF_AWARD = "d",
        DETAIL = "detail",
        SORT_BY = "sortBy",
        MAX_RECORDS = "max_records",
        RECORDS_FROM = "records_from",
        FISCAL_YEAR = "fiscal_year",
        FIRST_YEAR_RANGE = "first_year_range",
        LAST_YEAR_RANGE = "last_year_range",
        COMPANY_NAME = "company_name",
        CITY = "city",
        STATE = "state",
        ZIP_CODE = "ZIPCode",
        VENDOR_COUNTRY_CODE = "vendorCountryCode",
        VENDOR_CD = "vendor_cd",
        POP_CD = "pop_cd",
        STATE_CODE = "stateCode",
        PLACE_OF_PERFORMANCE_ZIP_CODE = "placeOfPerformanceZIPCode",
        PLACE_OF_PERFORMANCE_COUNTRY_CODE = "placeOfPerformanceCountryCode",
        MOD_AGENCY = "mod_agency",
        MAJ_AGENCY_CAT = "maj_agency_cat",
        RECIP_CAT_TYPE = "recip_cat_type",
        PSC_CAT = "psc_cat",
        PSC_SUB = "psc_sub",
        DESCRIPTION_OF_CONTRACT_REQUIREMENT =
            "descriptionOfContractRequirement",
        PIID = "PIID",
        EXTENT_COMPLETE = "extent_compete",
        DUNS_NUMBER = "duns_number",
        PROGRAM_SOURCE_AGENCY_CODE = "program_source_agency_code",
        PROGRAM_SOURCE_ACCOUNT_CODE = "program_source_account_code",
        PROGRAM_SOURCE_DESC = "program_source_desc",
        BUSN_INDCTR = "busn_indctr",
        PROGSRC_ACNT_CODE = "progsrc_acnt_code",
        PROGSRC_AGEN_CODE = "progsrc_agen_code",
        FEDERAL_AWARD_ID = "federal_award_id",
        CFDA_PROGRAM_NUM = "cfda_program_num",
        PROJECT_DESCRIPTION = "project_description",
        AGENCY_CODE = "agency_code",
        PRINCIPAL_PLACE_CC = "principal_place_cc",
        PRINCIPAL_PLACE_STATE_CODE = "principal_place_state_code",
        RECIPIENT_CD = "recipient_cd",
        RECIPIENT_COUNTRY_NAME = "recipient_country_name",
        RECIPIENT_ZIP = "recipient_zip",
        RECIPIENT_STATE_CODE = "recipient_state_code",
        RECIPIENT_CITY_NAME = "recipient_city_name",
        RECIPIENT_OF_ASSISTANCE = "recipient_of_assistance",
        SPENDING_TYPE = "spending_type",
        PRIME_AWARD_PROGRAM_SOURCE_ACCOUNT_CODE = "prime_award_program_source_account_code",
        PRIME_AWARD_PROGRAM_SOURCE_AGENCY_CODE = "prime_award_program_source_agency_code",
        SUBAWARDEE_DUNS_NUMBER= "subawardee_duns_number",
        PRIME_ORDER_NUMBER = "prime_order_number",
        PRIME_AWARD_NUMBER = "prime_award_number",
        SUBAWARD_PROJECT_DESCRIPTION = "subaward_project_description",
        SUBAWARDEE_POP_ZIP = "subawardee_pop_zip",
        SUBAWARDEE_POP_STATE = "subawardee_pop_state",
        SUBAWARDEE_POP_CD = "subawardee_pop_cd",
        SUBAWARDEE_CD = "subawardee_cd",
        SUBAWARDEE_POP_COUNTRY = "subawardee_pop_country",
        SUBAWARDEE_COUNTRY = "subawardee_country",
        SUBAWARDEE_ZIP = "subawardee_zip",
        SUBAWARDEE_STATE_CODE = "subawardee_state_code",
        SUBAWARDEE_CITY_NAME = "subawardee_city_name",
        SUBAWARDEE_NAME = "subawardee_name",
        
        /**
         * R equates to funds provided by Recovery Act.
         *
         * @see {@link QueryBuilder#setBusnIndctrToR}
         */
        R = "r";

    public static final int MAX_RECORDS_MAX_VALUE = 1000;

    public static final String
        // Do not change usaspendingSearchResults to usaSpendingSearchResults as
        // the S needs to stay small.
        USA_SPENDING_SEARCH_RESULTS = "usaspendingSearchResults",
        COMPLETE_SEARCH_RESULTS = "completeSearchResults",
        SEARCH_CRITERIA_TBL = "searchCriteria",
        SEARCH_CRITERIA = "search_criteria";

    public static final String SEARCH_CRITERION = "search_criterion",
        SEARCH_CRITERION_TBL = "searchCriterion",
        FIELD = "field",
        VALUE = "value";

    public static final String SEARCH_CRITERION_LIST_PROPERTY =
        "searchCriterionList";

    public static final String RESULT = "result", DOC = "doc";

    /**
     * This is used for testing purposes only.
     */
    public static final String NULL = "";

    public static final String
        COMPILED_FROM_GOVERNMENT_DATA_LAST_RELEASED_ON =
            "compiled_from_government_data_last_released_on",
        DATABASE = "database",
        DESCRIPTION = "description",
        NAME_ADD = "name_add",
        OBLIGATED_AMOUNT = "obligatedAmount",
        NAME = "name",
        ID = "id",
        RANK = "rank",
        TOTAL_OBLIGATED_AMOUNT = "total_obligatedAmount",
        PRIME_AWARD_PIID = "PrimeAwardPIID",
        PRIME_AWARD_IDVPIID = "PrimeAwardIDVPIID",
        PRIME_AWARD_DATE_SUBMITTED = "PrimeAwardDateSubmitted",
        PRIME_AWARD_AMOUNT = "PrimeAwardAmount",
        PRIME_AWARD_DATE_SIGNED = "PrimeAwardDateSigned",
        PRIME_AWARD_PROGRAM_TITLE = "PrimeAwardProgramTitle",
        PRIME_AWARD_PROGRAM_SOURCE_AGENCY = "PrimeAwardProgramSourceAgency",
        PRIME_AWARD_PROGRAM_SOURCE_ACCOUNT = "PrimeAwardProgramSourceAccount",
        PROGRAM_SOURCE_SUB_ACCOUNT = "ProgramSourceSubAccount",
        PRIME_AWARD_AGENCY_ID = "PrimeAwardAgencyId",
        PRIME_AWARD_IDV_AGENCY_ID = "PrimeAwardIDVAgencyId",
        PRIME_AWARD_CONTRACTING_MAJORITY_AGENCY =
            "PrimeAwardContractingMajorAgency",
        PRIME_AWARD_FUNDING_MAJOR_AGENCY_NAME =
            "PrimeAwardFundingMajorAgencyName",
        PRIME_AWARD_FEDERAL_AWARD_ID = "PrimeAwardFederalAwardId",
        SUBCONTRACTOR_DUNS_NUMBER = "SubcontactorDUNSNumber",
        SUBCONTRACTOR_NAME = "SubcontractorName",
        SUBCONTRACTOR_STREET = "SubcontractorStreet",
        SUBCONTRACTOR_CITY = "SubcontractorCity",
        SUBCONTRACTOR_STATE = "SubcontractorState",
        SUBCONTRACTOR_ZIP_CODE = "SubcontractorZipCode",
        SUBCONTRACTOR_CONGRESSIONAL_DISTRICT =
            "SubcontractorCongressionalDistrict",
        SUBCONTRACTOR_PRINCIPAL_PLACE_CITY = "SubcontractPrincipalPlaceCity",
        SUBCONTRACTOR_PRINCIPAL_PLACE_ZIP = "SubcontractPrincipalPlaceZip",
        SUBCONTRACTOR_PRINCIPAL_PLACE_DISTRICT =
            "SubcontractPrincipalPlaceDistrict",
        SUBCONTRACTOR_PRINCIPAL_PLACE_AMOUNT = "SubcontractAmount",
        SUBCONTRACT_DATE = "SubcontractDate",
        SUBCONTRACT_PRINCIPAL_NAICS_CODE = "SubcontractPrincipalNAICSCode",
        SUBCONTRACT_PRINCIPAL_NAICS_DESCRIPTION = "SubcontractPrincipalNAICSDescription",
        SUBCONTRACT_NUMBER = "SubcontractNumber",
        SUBCONTRACT_PROJECT_DESCRIPTION = "SubcontractProjectDescription",
        SUBCONTRACT_FUNDING_AGENCY_ID = "SubcontractFundingAgencyId",
        SUBCONTRACT_FUNDING_AGENCY_NAME = "SubcontractFundingAgencyName",
        YEAR = "year",
        DATA = "data",
        RECORDS = "records",
        RECORD = "record",
        RECIPIENT = "recipient",
        RANKED_BY = "ranked_by",
        MAXIMUM_SHOWN = "maximum_shown",
        NUM_FOUND = "numFound",
        TOTALS = "totals",
        TOP_KNOWN_CONGRESSIONAL_DISTRICTS = "top_known_congressional_districts",
        TOP_CONTRACTING_AGENCIES = "top_contracting_agencies",
        TOP_RECIPIENTS = "top_recipients",
        FISCAL_YEARS = "fiscal_years",
        AGENCY = "agency",
        CONGRESSIONAL_DISTRICT = "congressional_district",
        PERCENT_OF_FISCAL_YEAR = "percent_of_fiscal_year",
        NUMBER_OF_CONTRACTORS = "number_of_contractors",
        NUMBER_OF_TRANSACTIONS = "number_of_transactions";

    public static final String ASST_CAT_TYPE = "asst_cat_type";

}