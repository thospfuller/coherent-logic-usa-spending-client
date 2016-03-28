package com.coherentlogic.usaspending.client.core.domain;

import static com.coherentlogic.usaspending.client.core.util.Constants.DOC;
import static com.coherentlogic.usaspending.client.core.util.Constants.PRIME_AWARD_AGENCY_ID;
import static com.coherentlogic.usaspending.client.core.util.Constants.PRIME_AWARD_AMOUNT;
import static com.coherentlogic.usaspending.client.core.util.Constants.PRIME_AWARD_CONTRACTING_MAJORITY_AGENCY;
import static com.coherentlogic.usaspending.client.core.util.Constants.PRIME_AWARD_DATE_SIGNED;
import static com.coherentlogic.usaspending.client.core.util.Constants.PRIME_AWARD_DATE_SUBMITTED;
import static com.coherentlogic.usaspending.client.core.util.Constants.PRIME_AWARD_FEDERAL_AWARD_ID;
import static com.coherentlogic.usaspending.client.core.util.Constants.PRIME_AWARD_FUNDING_MAJOR_AGENCY_NAME;
import static com.coherentlogic.usaspending.client.core.util.Constants.PRIME_AWARD_IDVPIID;
import static com.coherentlogic.usaspending.client.core.util.Constants.PRIME_AWARD_IDV_AGENCY_ID;
import static com.coherentlogic.usaspending.client.core.util.Constants.PRIME_AWARD_PIID;
import static com.coherentlogic.usaspending.client.core.util.Constants.PRIME_AWARD_PROGRAM_SOURCE_ACCOUNT;
import static com.coherentlogic.usaspending.client.core.util.Constants.PRIME_AWARD_PROGRAM_SOURCE_AGENCY;
import static com.coherentlogic.usaspending.client.core.util.Constants.PRIME_AWARD_PROGRAM_TITLE;
import static com.coherentlogic.usaspending.client.core.util.Constants.PROGRAM_SOURCE_SUB_ACCOUNT;
import static com.coherentlogic.usaspending.client.core.util.Constants.SUBCONTRACTOR_CITY;
import static com.coherentlogic.usaspending.client.core.util.Constants.SUBCONTRACTOR_CONGRESSIONAL_DISTRICT;
import static com.coherentlogic.usaspending.client.core.util.Constants.SUBCONTRACTOR_DUNS_NUMBER;
import static com.coherentlogic.usaspending.client.core.util.Constants.SUBCONTRACTOR_NAME;
import static com.coherentlogic.usaspending.client.core.util.Constants.SUBCONTRACTOR_PRINCIPAL_PLACE_AMOUNT;
import static com.coherentlogic.usaspending.client.core.util.Constants.SUBCONTRACTOR_PRINCIPAL_PLACE_CITY;
import static com.coherentlogic.usaspending.client.core.util.Constants.SUBCONTRACTOR_PRINCIPAL_PLACE_DISTRICT;
import static com.coherentlogic.usaspending.client.core.util.Constants.SUBCONTRACTOR_PRINCIPAL_PLACE_ZIP;
import static com.coherentlogic.usaspending.client.core.util.Constants.SUBCONTRACTOR_STATE;
import static com.coherentlogic.usaspending.client.core.util.Constants.SUBCONTRACTOR_STREET;
import static com.coherentlogic.usaspending.client.core.util.Constants.SUBCONTRACTOR_ZIP_CODE;
import static com.coherentlogic.usaspending.client.core.util.Constants.SUBCONTRACT_DATE;
import static com.coherentlogic.usaspending.client.core.util.Constants.SUBCONTRACT_FUNDING_AGENCY_ID;
import static com.coherentlogic.usaspending.client.core.util.Constants.SUBCONTRACT_FUNDING_AGENCY_NAME;
import static com.coherentlogic.usaspending.client.core.util.Constants.SUBCONTRACT_NUMBER;
import static com.coherentlogic.usaspending.client.core.util.Constants.SUBCONTRACT_PRINCIPAL_NAICS_CODE;
import static com.coherentlogic.usaspending.client.core.util.Constants.SUBCONTRACT_PRINCIPAL_NAICS_DESCRIPTION;
import static com.coherentlogic.usaspending.client.core.util.Constants.SUBCONTRACT_PROJECT_DESCRIPTION;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.coherentlogic.coherent.data.model.core.domain.SerializableBean;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@Entity
@Table(name=DOC)
@XStreamAlias(DOC)
public class Doc extends SerializableBean {

    private static final long serialVersionUID = -191313039079141306L;

    /**
     * Note that these properties should not be moved to the Constants class as
     * those property *values* differ from what we have here.
     */
    static final String
        SPENDING_TYPE = "SpendingType",
        FISCAL_YEAR = "FiscalYear";

    /**
     * NNX10AB70G
     */
    @XStreamAlias(PRIME_AWARD_PIID)
    private String primeAwardPIID = null;

    /**
     * SPRPA111G001Y
     */
    @XStreamAlias(PRIME_AWARD_IDVPIID)
    private String primeAwardIDVPIID = null;

    /**
     * 2012-07-28T04:00:00Z
     *
     * @todo Should this be a Date?
     */
    @XStreamAlias(PRIME_AWARD_DATE_SUBMITTED)
    private String primeAwardDateSubmitted = null;

    /**
     * Example needed
     */
    @XStreamAlias(PRIME_AWARD_AMOUNT)
    private String primeAwardAmount = null;

    /**
     * Example needed
     *
     * @todo We need a date converter.
     */
    @XStreamAlias(PRIME_AWARD_DATE_SIGNED)
    private String primeAwardDateSigned = null;

    /**
     * A PRIMARY GOAL OF THE U.S. DEPARTMENT OF AGRICULTURE (USDA) IS TO EXPAND
     * MARKETS FOR U.S. AGRICULTURAL PRODUCTS AND SUPPORT GLOBAL ECONOMIC
     * DEVELOPME
     */
    @XStreamAlias(PRIME_AWARD_PROGRAM_TITLE)
    private String primeAwardProgramTitle = null;

    /**
     * 97
     */
    @XStreamAlias(PRIME_AWARD_PROGRAM_SOURCE_AGENCY)
    private String primeAwardProgramSourceAgency = null;

    /**
     * 4930
     */
    @XStreamAlias(PRIME_AWARD_PROGRAM_SOURCE_ACCOUNT)
    private String primeAwardProgramSourceAccount = null;

    /**
     * 002
     */
    @XStreamAlias(PROGRAM_SOURCE_SUB_ACCOUNT)
    private String programSourceSubAccount = null;

    /**
     * Example needed
     */
    @XStreamAlias(PRIME_AWARD_AGENCY_ID)
    private String primeAwardAgencyId = null;

    /**
     * Example needed
     */
    @XStreamAlias(PRIME_AWARD_IDV_AGENCY_ID)
    private String primeAwardIDVAgencyId = null;

    /**
     * DEPT OF THE ARMY
     */
    @XStreamAlias(PRIME_AWARD_CONTRACTING_MAJORITY_AGENCY)
    private String primeAwardContractingMajorAgency = null;

    /**
     * DEPT OF THE ARMY
     */
    @XStreamAlias(PRIME_AWARD_FUNDING_MAJOR_AGENCY_NAME)
    private String primeAwardFundingMajorAgencyName = null;

    @XStreamAlias(PRIME_AWARD_FEDERAL_AWARD_ID)
    private String primeAwardFederalAwardId = null;

    /**
     * 807284971
     */
    @XStreamAlias(SUBCONTRACTOR_DUNS_NUMBER)
    private String subcontactorDUNSNumber = null;

    /**
     * ADNET SYSTEMS, INC.
     */
    @XStreamAlias(SUBCONTRACTOR_NAME)
    private String subcontractorName = null;

    /**
     * 164 ROLLINS AVE STE 303
     */
    @XStreamAlias(SUBCONTRACTOR_STREET)
    private String subcontractorStreet = null;

    /**
     * ROCKVILLE
     */
    @XStreamAlias(SUBCONTRACTOR_CITY)
    private String subcontractorCity = null;

    /**
     * MD
     */
    @XStreamAlias(SUBCONTRACTOR_STATE)
    private String subcontractorState = null;

    /**
     * 208524038
     */
    @XStreamAlias(SUBCONTRACTOR_ZIP_CODE)
    private String subcontractorZipCode = null;

    /**
     * MD08
     */
    @XStreamAlias(SUBCONTRACTOR_CONGRESSIONAL_DISTRICT)
    private String subcontractorCongressionalDistrict = null;

    /**
     * GREENBELT
     */
    @XStreamAlias(SUBCONTRACTOR_PRINCIPAL_PLACE_CITY)
    private String subcontractPrincipalPlaceCity = null;

    /**
     * 207712400
     */
    @XStreamAlias(SUBCONTRACTOR_PRINCIPAL_PLACE_ZIP)
    private String subcontractPrincipalPlaceZip = null;

    /**
     * MD05
     */
    @XStreamAlias(SUBCONTRACTOR_PRINCIPAL_PLACE_DISTRICT)
    private String subcontractPrincipalPlaceDistrict = null;

    /**
     * 153000.00
     */
    @XStreamAlias(SUBCONTRACTOR_PRINCIPAL_PLACE_AMOUNT)
    private String subcontractAmount = null;

    /**
     * 2010-03-03T05:00:00Z
     */
    @XStreamAlias(SUBCONTRACT_DATE)
    private String subcontractDate = null;

    /**
     * 336411
     */
    @XStreamAlias(SUBCONTRACT_PRINCIPAL_NAICS_CODE)
    private String subcontractPrincipalNAICSCode = null;

    /**
     * AIRCRAFT MANUFACTURING
     */
    @XStreamAlias(SUBCONTRACT_PRINCIPAL_NAICS_DESCRIPTION)
    private String subcontractPrincipalNAICSDescription = null;

    /**
     * NNX10AB70G
     */
    @XStreamAlias(SUBCONTRACT_NUMBER)
    private String subcontractNumber = null;

    /**
     * Project: Improving World Agricultural Supply and Demand Estimates...
     */
    @XStreamAlias(SUBCONTRACT_PROJECT_DESCRIPTION)
    private String subcontractProjectDescription = null;

    /**
     * Note that this cannot be converted into a SpendingType enum as it is not
     * clear what all the possible values are.
     *
     * sg
     */
    @XStreamAlias(SPENDING_TYPE)
    private String spendingType = null;

    /**
     * 2010
     */
    @XStreamAlias(FISCAL_YEAR)
    private String fiscalYear = null;

    /**
     * 2100
     */
    @XStreamAlias(SUBCONTRACT_FUNDING_AGENCY_ID)
    private String subcontractFundingAgencyId = null;

    /**
     * DEPT OF THE ARMY
     */
    @XStreamAlias(SUBCONTRACT_FUNDING_AGENCY_NAME)
    private String subcontractFundingAgencyName = null;

    public Doc () {
    }

    public String getPrimeAwardPIID() {
        return primeAwardPIID;
    }

    public void setPrimeAwardPIID(String primeAwardPIID) {
        this.primeAwardPIID = primeAwardPIID;
    }

    public String getPrimeAwardIDVPIID() {
        return primeAwardIDVPIID;
    }

    public void setPrimeAwardIDVPIID(String primeAwardIDVPIID) {
        this.primeAwardIDVPIID = primeAwardIDVPIID;
    }

    public String getPrimeAwardDateSubmitted() {
        return primeAwardDateSubmitted;
    }

    public void setPrimeAwardDateSubmitted(String primeAwardDateSubmitted) {
        this.primeAwardDateSubmitted = primeAwardDateSubmitted;
    }

    public String getPrimeAwardAmount() {
        return primeAwardAmount;
    }

    public void setPrimeAwardAmount(String primeAwardAmount) {
        this.primeAwardAmount = primeAwardAmount;
    }

    public String getPrimeAwardDateSigned() {
        return primeAwardDateSigned;
    }

    public void setPrimeAwardDateSigned(String primeAwardDateSigned) {
        this.primeAwardDateSigned = primeAwardDateSigned;
    }

    public String getPrimeAwardProgramTitle() {
        return primeAwardProgramTitle;
    }

    public void setPrimeAwardProgramTitle(String primeAwardProgramTitle) {
        this.primeAwardProgramTitle = primeAwardProgramTitle;
    }

    public String getPrimeAwardProgramSourceAgency() {
        return primeAwardProgramSourceAgency;
    }

    public void setPrimeAwardProgramSourceAgency(
        String primeAwardProgramSourceAgency) {
        this.primeAwardProgramSourceAgency = primeAwardProgramSourceAgency;
    }

    public String getPrimeAwardProgramSourceAccount() {
        return primeAwardProgramSourceAccount;
    }

    public void setPrimeAwardProgramSourceAccount(
        String primeAwardProgramSourceAccount) {
        this.primeAwardProgramSourceAccount = primeAwardProgramSourceAccount;
    }

    public String getProgramSourceSubAccount() {
        return programSourceSubAccount;
    }

    public void setProgramSourceSubAccount(String programSourceSubAccount) {
        this.programSourceSubAccount = programSourceSubAccount;
    }

    public String getPrimeAwardAgencyId() {
        return primeAwardAgencyId;
    }

    public void setPrimeAwardAgencyId(String primeAwardAgencyId) {
        this.primeAwardAgencyId = primeAwardAgencyId;
    }

    public String getPrimeAwardIDVAgencyId() {
        return primeAwardIDVAgencyId;
    }

    public void setPrimeAwardIDVAgencyId(String primeAwardIDVAgencyId) {
        this.primeAwardIDVAgencyId = primeAwardIDVAgencyId;
    }

    public String getPrimeAwardContractingMajorAgency() {
        return primeAwardContractingMajorAgency;
    }

    public void setPrimeAwardContractingMajorAgency(
        String primeAwardContractingMajorAgency) {
        this.primeAwardContractingMajorAgency =
            primeAwardContractingMajorAgency;
    }

    public String getPrimeAwardFundingMajorAgencyName() {
        return primeAwardFundingMajorAgencyName;
    }

    public void setPrimeAwardFundingMajorAgencyName(
        String primeAwardFundingMajorAgencyName) {
        this.primeAwardFundingMajorAgencyName =
            primeAwardFundingMajorAgencyName;
    }

    public String getSubcontactorDUNSNumber() {
        return subcontactorDUNSNumber;
    }

    public void setSubcontactorDUNSNumber(String subcontactorDUNSNumber) {
        this.subcontactorDUNSNumber = subcontactorDUNSNumber;
    }

    public String getSubcontractorName() {
        return subcontractorName;
    }

    public void setSubcontractorName(String subcontractorName) {
        this.subcontractorName = subcontractorName;
    }

    public String getSubcontractorStreet() {
        return subcontractorStreet;
    }

    public void setSubcontractorStreet(String subcontractorStreet) {
        this.subcontractorStreet = subcontractorStreet;
    }

    public String getSubcontractorCity() {
        return subcontractorCity;
    }

    public void setSubcontractorCity(String subcontractorCity) {
        this.subcontractorCity = subcontractorCity;
    }

    public String getSubcontractorState() {
        return subcontractorState;
    }

    public void setSubcontractorState(String subcontractorState) {
        this.subcontractorState = subcontractorState;
    }

    public String getSubcontractorZipCode() {
        return subcontractorZipCode;
    }

    public void setSubcontractorZipCode(String subcontractorZipCode) {
        this.subcontractorZipCode = subcontractorZipCode;
    }

    public String getSubcontractorCongressionalDistrict() {
        return subcontractorCongressionalDistrict;
    }

    public void setSubcontractorCongressionalDistrict(
        String subcontractorCongressionalDistrict) {
        this.subcontractorCongressionalDistrict =
            subcontractorCongressionalDistrict;
    }

    public String getSubcontractPrincipalPlaceCity() {
        return subcontractPrincipalPlaceCity;
    }

    public void setSubcontractPrincipalPlaceCity(
        String subcontractPrincipalPlaceCity) {
        this.subcontractPrincipalPlaceCity = subcontractPrincipalPlaceCity;
    }

    public String getSubcontractPrincipalPlaceZip() {
        return subcontractPrincipalPlaceZip;
    }

    public void setSubcontractPrincipalPlaceZip(
        String subcontractPrincipalPlaceZip) {
        this.subcontractPrincipalPlaceZip = subcontractPrincipalPlaceZip;
    }

    public String getSubcontractPrincipalPlaceDistrict() {
        return subcontractPrincipalPlaceDistrict;
    }

    public void setSubcontractPrincipalPlaceDistrict(
        String subcontractPrincipalPlaceDistrict) {
        this.subcontractPrincipalPlaceDistrict =
            subcontractPrincipalPlaceDistrict;
    }

    /**
     * @todo Should this be a BigDecimal?
     */
    public String getSubcontractAmount() {
        return subcontractAmount;
    }

    public void setSubcontractAmount(String subcontractAmount) {
        this.subcontractAmount = subcontractAmount;
    }

    /**
     * @todo Should this be a Date?
     */
    public String getSubcontractDate() {
        return subcontractDate;
    }

    public void setSubcontractDate(String subcontractDate) {
        this.subcontractDate = subcontractDate;
    }

    public String getSubcontractPrincipalNAICSCode() {
        return subcontractPrincipalNAICSCode;
    }

    public void setSubcontractPrincipalNAICSCode(
        String subcontractPrincipalNAICSCode) {
        this.subcontractPrincipalNAICSCode = subcontractPrincipalNAICSCode;
    }

    public String getSubcontractPrincipalNAICSDescription() {
        return subcontractPrincipalNAICSDescription;
    }

    public void setSubcontractPrincipalNAICSDescription(
        String subcontractPrincipalNAICSDescription) {
        this.subcontractPrincipalNAICSDescription =
            subcontractPrincipalNAICSDescription;
    }

    public String getSubcontractNumber() {
        return subcontractNumber;
    }

    public void setSubcontractNumber(String subcontractNumber) {
        this.subcontractNumber = subcontractNumber;
    }

    public String getSubcontractProjectDescription() {
        return subcontractProjectDescription;
    }

    public void setSubcontractProjectDescription(
            String subcontractProjectDescription) {
        this.subcontractProjectDescription = subcontractProjectDescription;
    }

    public String getSpendingType() {
        return spendingType;
    }

    public void setSpendingType(String spendingType) {
        this.spendingType = spendingType;
    }

    public String getFiscalYear() {
        return fiscalYear;
    }

    public void setFiscalYear(String fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

    public String getSubcontractFundingAgencyId() {
        return subcontractFundingAgencyId;
    }

    public void setSubcontractFundingAgencyId(
        String subcontractFundingAgencyId) {
        this.subcontractFundingAgencyId = subcontractFundingAgencyId;
    }

    public String getSubcontractFundingAgencyName() {
        return subcontractFundingAgencyName;
    }

    public void setSubcontractFundingAgencyName(
        String subcontractFundingAgencyName) {
        this.subcontractFundingAgencyName = subcontractFundingAgencyName;
    }

    public String getPrimeAwardFederalAwardId() {
        return primeAwardFederalAwardId;
    }

    public void setPrimeAwardFederalAwardId(String primeAwardFederalAwardId) {
        this.primeAwardFederalAwardId = primeAwardFederalAwardId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((fiscalYear == null) ? 0 : fiscalYear.hashCode());
        result = prime * result + ((primeAwardAgencyId == null) ? 0 : primeAwardAgencyId.hashCode());
        result = prime * result + ((primeAwardAmount == null) ? 0 : primeAwardAmount.hashCode());
        result = prime * result
                + ((primeAwardContractingMajorAgency == null) ? 0 : primeAwardContractingMajorAgency.hashCode());
        result = prime * result + ((primeAwardDateSigned == null) ? 0 : primeAwardDateSigned.hashCode());
        result = prime * result + ((primeAwardDateSubmitted == null) ? 0 : primeAwardDateSubmitted.hashCode());
        result = prime * result + ((primeAwardFederalAwardId == null) ? 0 : primeAwardFederalAwardId.hashCode());
        result = prime * result
                + ((primeAwardFundingMajorAgencyName == null) ? 0 : primeAwardFundingMajorAgencyName.hashCode());
        result = prime * result + ((primeAwardIDVAgencyId == null) ? 0 : primeAwardIDVAgencyId.hashCode());
        result = prime * result + ((primeAwardIDVPIID == null) ? 0 : primeAwardIDVPIID.hashCode());
        result = prime * result + ((primeAwardPIID == null) ? 0 : primeAwardPIID.hashCode());
        result = prime * result
                + ((primeAwardProgramSourceAccount == null) ? 0 : primeAwardProgramSourceAccount.hashCode());
        result = prime * result
                + ((primeAwardProgramSourceAgency == null) ? 0 : primeAwardProgramSourceAgency.hashCode());
        result = prime * result + ((primeAwardProgramTitle == null) ? 0 : primeAwardProgramTitle.hashCode());
        result = prime * result + ((programSourceSubAccount == null) ? 0 : programSourceSubAccount.hashCode());
        result = prime * result + ((spendingType == null) ? 0 : spendingType.hashCode());
        result = prime * result + ((subcontactorDUNSNumber == null) ? 0 : subcontactorDUNSNumber.hashCode());
        result = prime * result + ((subcontractAmount == null) ? 0 : subcontractAmount.hashCode());
        result = prime * result + ((subcontractDate == null) ? 0 : subcontractDate.hashCode());
        result = prime * result + ((subcontractFundingAgencyId == null) ? 0 : subcontractFundingAgencyId.hashCode());
        result = prime * result
                + ((subcontractFundingAgencyName == null) ? 0 : subcontractFundingAgencyName.hashCode());
        result = prime * result + ((subcontractNumber == null) ? 0 : subcontractNumber.hashCode());
        result = prime * result
                + ((subcontractPrincipalNAICSCode == null) ? 0 : subcontractPrincipalNAICSCode.hashCode());
        result = prime * result + ((subcontractPrincipalNAICSDescription == null) ? 0
                : subcontractPrincipalNAICSDescription.hashCode());
        result = prime * result
                + ((subcontractPrincipalPlaceCity == null) ? 0 : subcontractPrincipalPlaceCity.hashCode());
        result = prime * result
                + ((subcontractPrincipalPlaceDistrict == null) ? 0 : subcontractPrincipalPlaceDistrict.hashCode());
        result = prime * result
                + ((subcontractPrincipalPlaceZip == null) ? 0 : subcontractPrincipalPlaceZip.hashCode());
        result = prime * result
                + ((subcontractProjectDescription == null) ? 0 : subcontractProjectDescription.hashCode());
        result = prime * result + ((subcontractorCity == null) ? 0 : subcontractorCity.hashCode());
        result = prime * result
                + ((subcontractorCongressionalDistrict == null) ? 0 : subcontractorCongressionalDistrict.hashCode());
        result = prime * result + ((subcontractorName == null) ? 0 : subcontractorName.hashCode());
        result = prime * result + ((subcontractorState == null) ? 0 : subcontractorState.hashCode());
        result = prime * result + ((subcontractorStreet == null) ? 0 : subcontractorStreet.hashCode());
        result = prime * result + ((subcontractorZipCode == null) ? 0 : subcontractorZipCode.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Doc other = (Doc) obj;
        if (fiscalYear == null) {
            if (other.fiscalYear != null)
                return false;
        } else if (!fiscalYear.equals(other.fiscalYear))
            return false;
        if (primeAwardAgencyId == null) {
            if (other.primeAwardAgencyId != null)
                return false;
        } else if (!primeAwardAgencyId.equals(other.primeAwardAgencyId))
            return false;
        if (primeAwardAmount == null) {
            if (other.primeAwardAmount != null)
                return false;
        } else if (!primeAwardAmount.equals(other.primeAwardAmount))
            return false;
        if (primeAwardContractingMajorAgency == null) {
            if (other.primeAwardContractingMajorAgency != null)
                return false;
        } else if (!primeAwardContractingMajorAgency.equals(other.primeAwardContractingMajorAgency))
            return false;
        if (primeAwardDateSigned == null) {
            if (other.primeAwardDateSigned != null)
                return false;
        } else if (!primeAwardDateSigned.equals(other.primeAwardDateSigned))
            return false;
        if (primeAwardDateSubmitted == null) {
            if (other.primeAwardDateSubmitted != null)
                return false;
        } else if (!primeAwardDateSubmitted.equals(other.primeAwardDateSubmitted))
            return false;
        if (primeAwardFederalAwardId == null) {
            if (other.primeAwardFederalAwardId != null)
                return false;
        } else if (!primeAwardFederalAwardId.equals(other.primeAwardFederalAwardId))
            return false;
        if (primeAwardFundingMajorAgencyName == null) {
            if (other.primeAwardFundingMajorAgencyName != null)
                return false;
        } else if (!primeAwardFundingMajorAgencyName.equals(other.primeAwardFundingMajorAgencyName))
            return false;
        if (primeAwardIDVAgencyId == null) {
            if (other.primeAwardIDVAgencyId != null)
                return false;
        } else if (!primeAwardIDVAgencyId.equals(other.primeAwardIDVAgencyId))
            return false;
        if (primeAwardIDVPIID == null) {
            if (other.primeAwardIDVPIID != null)
                return false;
        } else if (!primeAwardIDVPIID.equals(other.primeAwardIDVPIID))
            return false;
        if (primeAwardPIID == null) {
            if (other.primeAwardPIID != null)
                return false;
        } else if (!primeAwardPIID.equals(other.primeAwardPIID))
            return false;
        if (primeAwardProgramSourceAccount == null) {
            if (other.primeAwardProgramSourceAccount != null)
                return false;
        } else if (!primeAwardProgramSourceAccount.equals(other.primeAwardProgramSourceAccount))
            return false;
        if (primeAwardProgramSourceAgency == null) {
            if (other.primeAwardProgramSourceAgency != null)
                return false;
        } else if (!primeAwardProgramSourceAgency.equals(other.primeAwardProgramSourceAgency))
            return false;
        if (primeAwardProgramTitle == null) {
            if (other.primeAwardProgramTitle != null)
                return false;
        } else if (!primeAwardProgramTitle.equals(other.primeAwardProgramTitle))
            return false;
        if (programSourceSubAccount == null) {
            if (other.programSourceSubAccount != null)
                return false;
        } else if (!programSourceSubAccount.equals(other.programSourceSubAccount))
            return false;
        if (spendingType == null) {
            if (other.spendingType != null)
                return false;
        } else if (!spendingType.equals(other.spendingType))
            return false;
        if (subcontactorDUNSNumber == null) {
            if (other.subcontactorDUNSNumber != null)
                return false;
        } else if (!subcontactorDUNSNumber.equals(other.subcontactorDUNSNumber))
            return false;
        if (subcontractAmount == null) {
            if (other.subcontractAmount != null)
                return false;
        } else if (!subcontractAmount.equals(other.subcontractAmount))
            return false;
        if (subcontractDate == null) {
            if (other.subcontractDate != null)
                return false;
        } else if (!subcontractDate.equals(other.subcontractDate))
            return false;
        if (subcontractFundingAgencyId == null) {
            if (other.subcontractFundingAgencyId != null)
                return false;
        } else if (!subcontractFundingAgencyId.equals(other.subcontractFundingAgencyId))
            return false;
        if (subcontractFundingAgencyName == null) {
            if (other.subcontractFundingAgencyName != null)
                return false;
        } else if (!subcontractFundingAgencyName.equals(other.subcontractFundingAgencyName))
            return false;
        if (subcontractNumber == null) {
            if (other.subcontractNumber != null)
                return false;
        } else if (!subcontractNumber.equals(other.subcontractNumber))
            return false;
        if (subcontractPrincipalNAICSCode == null) {
            if (other.subcontractPrincipalNAICSCode != null)
                return false;
        } else if (!subcontractPrincipalNAICSCode.equals(other.subcontractPrincipalNAICSCode))
            return false;
        if (subcontractPrincipalNAICSDescription == null) {
            if (other.subcontractPrincipalNAICSDescription != null)
                return false;
        } else if (!subcontractPrincipalNAICSDescription.equals(other.subcontractPrincipalNAICSDescription))
            return false;
        if (subcontractPrincipalPlaceCity == null) {
            if (other.subcontractPrincipalPlaceCity != null)
                return false;
        } else if (!subcontractPrincipalPlaceCity.equals(other.subcontractPrincipalPlaceCity))
            return false;
        if (subcontractPrincipalPlaceDistrict == null) {
            if (other.subcontractPrincipalPlaceDistrict != null)
                return false;
        } else if (!subcontractPrincipalPlaceDistrict.equals(other.subcontractPrincipalPlaceDistrict))
            return false;
        if (subcontractPrincipalPlaceZip == null) {
            if (other.subcontractPrincipalPlaceZip != null)
                return false;
        } else if (!subcontractPrincipalPlaceZip.equals(other.subcontractPrincipalPlaceZip))
            return false;
        if (subcontractProjectDescription == null) {
            if (other.subcontractProjectDescription != null)
                return false;
        } else if (!subcontractProjectDescription.equals(other.subcontractProjectDescription))
            return false;
        if (subcontractorCity == null) {
            if (other.subcontractorCity != null)
                return false;
        } else if (!subcontractorCity.equals(other.subcontractorCity))
            return false;
        if (subcontractorCongressionalDistrict == null) {
            if (other.subcontractorCongressionalDistrict != null)
                return false;
        } else if (!subcontractorCongressionalDistrict.equals(other.subcontractorCongressionalDistrict))
            return false;
        if (subcontractorName == null) {
            if (other.subcontractorName != null)
                return false;
        } else if (!subcontractorName.equals(other.subcontractorName))
            return false;
        if (subcontractorState == null) {
            if (other.subcontractorState != null)
                return false;
        } else if (!subcontractorState.equals(other.subcontractorState))
            return false;
        if (subcontractorStreet == null) {
            if (other.subcontractorStreet != null)
                return false;
        } else if (!subcontractorStreet.equals(other.subcontractorStreet))
            return false;
        if (subcontractorZipCode == null) {
            if (other.subcontractorZipCode != null)
                return false;
        } else if (!subcontractorZipCode.equals(other.subcontractorZipCode))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Doc [primeAwardPIID=" + primeAwardPIID + ", primeAwardIDVPIID=" + primeAwardIDVPIID
            + ", primeAwardDateSubmitted=" + primeAwardDateSubmitted + ", primeAwardAmount=" + primeAwardAmount
            + ", primeAwardDateSigned=" + primeAwardDateSigned + ", primeAwardProgramTitle="
            + primeAwardProgramTitle + ", primeAwardProgramSourceAgency=" + primeAwardProgramSourceAgency
            + ", primeAwardProgramSourceAccount=" + primeAwardProgramSourceAccount + ", programSourceSubAccount="
            + programSourceSubAccount + ", primeAwardAgencyId=" + primeAwardAgencyId + ", primeAwardIDVAgencyId="
            + primeAwardIDVAgencyId + ", primeAwardContractingMajorAgency=" + primeAwardContractingMajorAgency
            + ", primeAwardFundingMajorAgencyName=" + primeAwardFundingMajorAgencyName
            + ", primeAwardFederalAwardId=" + primeAwardFederalAwardId + ", subcontactorDUNSNumber="
            + subcontactorDUNSNumber + ", subcontractorName=" + subcontractorName + ", subcontractorStreet="
            + subcontractorStreet + ", subcontractorCity=" + subcontractorCity + ", subcontractorState="
            + subcontractorState + ", subcontractorZipCode=" + subcontractorZipCode
            + ", subcontractorCongressionalDistrict=" + subcontractorCongressionalDistrict
            + ", subcontractPrincipalPlaceCity=" + subcontractPrincipalPlaceCity + ", subcontractPrincipalPlaceZip="
            + subcontractPrincipalPlaceZip + ", subcontractPrincipalPlaceDistrict="
            + subcontractPrincipalPlaceDistrict + ", subcontractAmount=" + subcontractAmount + ", subcontractDate="
            + subcontractDate + ", subcontractPrincipalNAICSCode=" + subcontractPrincipalNAICSCode
            + ", subcontractPrincipalNAICSDescription=" + subcontractPrincipalNAICSDescription
            + ", subcontractNumber=" + subcontractNumber + ", subcontractProjectDescription="
            + subcontractProjectDescription + ", spendingType=" + spendingType + ", fiscalYear=" + fiscalYear
            + ", subcontractFundingAgencyId=" + subcontractFundingAgencyId + ", subcontractFundingAgencyName="
            + subcontractFundingAgencyName + "]";
    }
}
