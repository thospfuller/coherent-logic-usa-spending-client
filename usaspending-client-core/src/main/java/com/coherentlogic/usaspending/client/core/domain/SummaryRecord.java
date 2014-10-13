package com.coherentlogic.usaspending.client.core.domain;

import static com.coherentlogic.usaspending.client.core.util.Constants.DATABASE;
import static com.coherentlogic.usaspending.client.core.util.Constants.DESCRIPTION;
import static com.coherentlogic.usaspending.client.core.util.Constants.DETAIL;
import static com.coherentlogic.usaspending.client.core.util.Constants.FISCAL_YEARS;
import static com.coherentlogic.usaspending.client.core.util.Constants.TOP_CONTRACTING_AGENCIES;
import static com.coherentlogic.usaspending.client.core.util.Constants.TOP_KNOWN_CONGRESSIONAL_DISTRICTS;
import static com.coherentlogic.usaspending.client.core.util.Constants.TOP_RECIPIENTS;
import static com.coherentlogic.usaspending.client.core.util.Constants.TOTALS;

import com.coherentlogic.coherent.data.model.core.domain.SerializableBean;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * 
 *
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class SummaryRecord extends SerializableBean {

    private static final long serialVersionUID = 3055447474210291474L;

    @XStreamAsAttribute
    @XStreamAlias(DETAIL)
    private String detail = null;

    @XStreamAsAttribute
    @XStreamAlias(DESCRIPTION)
    private String description = null;

    @XStreamAsAttribute
    @XStreamAlias(DATABASE)
    private String database = null;

    @XStreamAlias(TOTALS)
    private Totals totals = null;

    @XStreamAlias(TOP_KNOWN_CONGRESSIONAL_DISTRICTS)
    private TopKnownCongressionalDistricts topKnownCongressionalDistricts
        = null;

    @XStreamAlias(TOP_CONTRACTING_AGENCIES)
    private TopContractingAgencies topContractingAgencies = null;

    @XStreamAlias(TOP_RECIPIENTS)
    private TopRecipients topRecipients = null;

    @XStreamAlias(FISCAL_YEARS)
    private FiscalYears fiscalYears = null;

    public SummaryRecord() {
    }

    public Totals getTotals() {
        return totals;
    }

    public void setTotals(Totals totals) {
        this.totals = totals;
    }

    public TopKnownCongressionalDistricts getTopKnownCongressionalDistricts() {
        return topKnownCongressionalDistricts;
    }

    public void setTopKnownCongressionalDistricts(
            TopKnownCongressionalDistricts topKnownCongressionalDistricts) {
        this.topKnownCongressionalDistricts = topKnownCongressionalDistricts;
    }

    public TopContractingAgencies getTopContractingAgencies() {
        return topContractingAgencies;
    }

    public void setTopContractingAgencies(
            TopContractingAgencies topContractingAgencies) {
        this.topContractingAgencies = topContractingAgencies;
    }

    public TopRecipients getTopRecipients() {
        return topRecipients;
    }

    public void setTopRecipients(TopRecipients topRecipients) {
        this.topRecipients = topRecipients;
    }

    public FiscalYears getFiscalYears() {
        return fiscalYears;
    }

    public void setFiscalYears(FiscalYears fiscalYears) {
        this.fiscalYears = fiscalYears;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result
                + ((database == null) ? 0 : database.hashCode());
        result = prime * result
                + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((detail == null) ? 0 : detail.hashCode());
        result = prime * result
                + ((fiscalYears == null) ? 0 : fiscalYears.hashCode());
        result = prime
                * result
                + ((topContractingAgencies == null) ? 0
                        : topContractingAgencies.hashCode());
        result = prime
                * result
                + ((topKnownCongressionalDistricts == null) ? 0
                        : topKnownCongressionalDistricts.hashCode());
        result = prime * result
                + ((topRecipients == null) ? 0 : topRecipients.hashCode());
        result = prime * result + ((totals == null) ? 0 : totals.hashCode());
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
        SummaryRecord other = (SummaryRecord) obj;
        if (database == null) {
            if (other.database != null)
                return false;
        } else if (!database.equals(other.database))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (detail == null) {
            if (other.detail != null)
                return false;
        } else if (!detail.equals(other.detail))
            return false;
        if (fiscalYears == null) {
            if (other.fiscalYears != null)
                return false;
        } else if (!fiscalYears.equals(other.fiscalYears))
            return false;
        if (topContractingAgencies == null) {
            if (other.topContractingAgencies != null)
                return false;
        } else if (!topContractingAgencies.equals(other.topContractingAgencies))
            return false;
        if (topKnownCongressionalDistricts == null) {
            if (other.topKnownCongressionalDistricts != null)
                return false;
        } else if (!topKnownCongressionalDistricts
                .equals(other.topKnownCongressionalDistricts))
            return false;
        if (topRecipients == null) {
            if (other.topRecipients != null)
                return false;
        } else if (!topRecipients.equals(other.topRecipients))
            return false;
        if (totals == null) {
            if (other.totals != null)
                return false;
        } else if (!totals.equals(other.totals))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "SummaryRecord [detail=" + detail + ", description="
            + description + ", database=" + database + ", totals=" + totals
            + ", topKnownCongressionalDistricts="
            + topKnownCongressionalDistricts + ", topContractingAgencies="
            + topContractingAgencies + ", topRecipients=" + topRecipients
            + ", fiscalYears=" + fiscalYears + "]";
    }
}
