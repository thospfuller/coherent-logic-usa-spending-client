package com.coherentlogic.usaspending.client.core.domain;

import static com.coherentlogic.usaspending.client.core.util.Constants.FISCAL_YEAR;
import static com.coherentlogic.usaspending.client.core.util.Constants.NUMBER_OF_CONTRACTORS;
import static com.coherentlogic.usaspending.client.core.util.Constants.NUMBER_OF_TRANSACTIONS;
import static com.coherentlogic.usaspending.client.core.util.Constants.PERCENT_OF_FISCAL_YEAR;

import java.math.BigDecimal;

import com.coherentlogic.coherent.data.model.core.domain.SerializableBean;
import com.coherentlogic.usaspending.client.core.util.Constants;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 
 *
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class Totals extends SerializableBean {

    private static final long serialVersionUID = -3848536953373558702L;

    /**
     * The "O" is not capitalized in the {@link Constants} class.
     */
    static final String TOTAL_OBLIGATED_AMOUNT = "total_ObligatedAmount";

    /**
     * For example "2010".
     *
     * @todo Should this be of type int?
     */
    @XStreamAlias(FISCAL_YEAR)
    private String fiscalYear = null;

    /**
     * For example "5219702949.30".
     */
    @XStreamAlias(TOTAL_OBLIGATED_AMOUNT)
    private BigDecimal totalObligatedAmount = null;

    /**
     * For example "100.00%".
     */
    @XStreamAlias(PERCENT_OF_FISCAL_YEAR)
    private String percentOfFiscalYear = null;

    /**
     * For example "3227".
     */
    @XStreamAlias(NUMBER_OF_CONTRACTORS)
    private Long numberOfContractors = null;

    /**
     * For example "7494".
     */
    @XStreamAlias(NUMBER_OF_TRANSACTIONS)
    private Long numberOfTransactions = null;

    public Totals() {
    }

    public String getFiscalYear() {
        return fiscalYear;
    }

    public void setFiscalYear(String fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

    public BigDecimal getTotalObligatedAmount() {
        return totalObligatedAmount;
    }

    public void setTotalObligatedAmount(BigDecimal totalObligatedAmount) {
        this.totalObligatedAmount = totalObligatedAmount;
    }

    public String getPercentOfFiscalYear() {
        return percentOfFiscalYear;
    }

    public void setPercentOfFiscalYear(String percentOfFiscalYear) {
        this.percentOfFiscalYear = percentOfFiscalYear;
    }

    public Long getNumberOfContractors() {
        return numberOfContractors;
    }

    public void setNumberOfContractors(Long numberOfContractors) {
        this.numberOfContractors = numberOfContractors;
    }

    public Long getNumberOfTransactions() {
        return numberOfTransactions;
    }

    public void setNumberOfTransactions(Long numberOfTransactions) {
        this.numberOfTransactions = numberOfTransactions;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result
                + ((fiscalYear == null) ? 0 : fiscalYear.hashCode());
        result = prime
                * result
                + ((numberOfContractors == null) ? 0 : numberOfContractors
                        .hashCode());
        result = prime
                * result
                + ((numberOfTransactions == null) ? 0 : numberOfTransactions
                        .hashCode());
        result = prime
                * result
                + ((percentOfFiscalYear == null) ? 0 : percentOfFiscalYear
                        .hashCode());
        result = prime
                * result
                + ((totalObligatedAmount == null) ? 0 : totalObligatedAmount
                        .hashCode());
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
        Totals other = (Totals) obj;
        if (fiscalYear == null) {
            if (other.fiscalYear != null)
                return false;
        } else if (!fiscalYear.equals(other.fiscalYear))
            return false;
        if (numberOfContractors == null) {
            if (other.numberOfContractors != null)
                return false;
        } else if (!numberOfContractors.equals(other.numberOfContractors))
            return false;
        if (numberOfTransactions == null) {
            if (other.numberOfTransactions != null)
                return false;
        } else if (!numberOfTransactions.equals(other.numberOfTransactions))
            return false;
        if (percentOfFiscalYear == null) {
            if (other.percentOfFiscalYear != null)
                return false;
        } else if (!percentOfFiscalYear.equals(other.percentOfFiscalYear))
            return false;
        if (totalObligatedAmount == null) {
            if (other.totalObligatedAmount != null)
                return false;
        } else if (!totalObligatedAmount.equals(other.totalObligatedAmount))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Totals [fiscalYear=" + fiscalYear + ", totalObligatedAmount="
            + totalObligatedAmount + ", percentOfFiscalYear="
            + percentOfFiscalYear + ", numberOfContractors="
            + numberOfContractors + ", numberOfTransactions="
            + numberOfTransactions + ", toString()=" + super.toString()
            + "]";
    }
}
