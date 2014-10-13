package com.coherentlogic.usaspending.client.core.domain;

import static com.coherentlogic.usaspending.client.core.util.Constants.NAME_ADD;
import static com.coherentlogic.usaspending.client.core.util.Constants.OBLIGATED_AMOUNT;

import java.math.BigDecimal;

import com.coherentlogic.coherent.data.model.core.domain.SerializableBean;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 
 *
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public abstract class AbstractRecord extends SerializableBean {

    private static final long serialVersionUID = 6771907243181900849L;

    @XStreamAlias(NAME_ADD)
    private String nameAdd = null;

    @XStreamAlias(OBLIGATED_AMOUNT)
    private BigDecimal obligatedAmount = null;

    public AbstractRecord() {
    }

    public String getNameAdd() {
        return nameAdd;
    }

    public void setNameAdd(String nameAdd) {
        this.nameAdd = nameAdd;
    }

    public abstract String getDunsNumber();

    public abstract void setDunsNumber(String dunsNumber);

    public BigDecimal getObligatedAmount() {
        return obligatedAmount;
    }

    public void setObligatedAmount(BigDecimal obligatedAmount) {
        this.obligatedAmount = obligatedAmount;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((nameAdd == null) ? 0 : nameAdd.hashCode());
        result = prime * result
            + ((obligatedAmount == null) ? 0 : obligatedAmount.hashCode());
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
        AbstractRecord other = (AbstractRecord) obj;
        if (nameAdd == null) {
            if (other.nameAdd != null)
                return false;
        } else if (!nameAdd.equals(other.nameAdd))
            return false;
        if (obligatedAmount == null) {
            if (other.obligatedAmount != null)
                return false;
        } else if (!obligatedAmount.equals(other.obligatedAmount))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "AbstractRecord [nameAdd=" + nameAdd + ", obligatedAmount="
            + obligatedAmount + ", toString()=" + super.toString() + "]";
    }
}
