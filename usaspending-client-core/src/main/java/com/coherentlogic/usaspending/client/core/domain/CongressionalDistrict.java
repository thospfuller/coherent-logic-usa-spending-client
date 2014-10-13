package com.coherentlogic.usaspending.client.core.domain;

import static com.coherentlogic.usaspending.client.core.util.Constants.RANK;
import static com.coherentlogic.usaspending.client.core.util.Constants.TOTAL_OBLIGATED_AMOUNT;

import java.math.BigDecimal;

import com.coherentlogic.coherent.data.model.core.domain.AbstractIdentityValueBean;
import com.coherentlogic.usaspending.client.core.converters.CongressionalDistrictConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.basic.StringConverter;

/**
 * A representation of a congressional district that is returned when requesting
 * summary-level detail from the USASpending.gov web services.
 *
 * @see com.coherentlogic.usaspending.client.core.domain.SummaryRecord
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@XStreamConverter(CongressionalDistrictConverter.class)
public class CongressionalDistrict extends AbstractIdentityValueBean<String> {

    private static final long serialVersionUID = 2825652054468194444L;

	/**
     * For example "5".
     */
    @XStreamAlias(RANK)
    @XStreamAsAttribute
    private Long rank = null;

    /**
     * For example "502126241.73".
     */
    @XStreamAlias(TOTAL_OBLIGATED_AMOUNT)
    @XStreamAsAttribute
    private BigDecimal totaObligatedAmount = null;

    @XStreamConverter(StringConverter.class)
    private String value = null;

    public Long getRank() {
        return rank;
    }

    public void setRank(Long rank) {
        this.rank = rank;
    }

    public BigDecimal getTotaObligatedAmount() {
        return totaObligatedAmount;
    }

    public void setTotaObligatedAmount(BigDecimal totaObligatedAmount) {
        this.totaObligatedAmount = totaObligatedAmount;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((rank == null) ? 0 : rank.hashCode());
        result = prime
                * result
                + ((totaObligatedAmount == null) ? 0 : totaObligatedAmount
                        .hashCode());
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        CongressionalDistrict other = (CongressionalDistrict) obj;
        if (rank == null) {
            if (other.rank != null)
                return false;
        } else if (!rank.equals(other.rank))
            return false;
        if (totaObligatedAmount == null) {
            if (other.totaObligatedAmount != null)
                return false;
        } else if (!totaObligatedAmount.equals(other.totaObligatedAmount))
            return false;
        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "CongressionalDistrict [rank=" + rank + ", totaObligatedAmount="
            + totaObligatedAmount + ", getValue()=" + getValue()
            + ", toString()=" + super.toString() + ", getId()=" + getId()
            + ", getPrimaryKey()=" + getPrimaryKey()
            + ", getVetoableChangeSupport()=" + getVetoableChangeSupport()
            + ", getPropertyChangeSupport()=" + getPropertyChangeSupport()
            + ", getClass()=" + getClass() + "]";
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
