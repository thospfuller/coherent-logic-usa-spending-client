package com.coherentlogic.usaspending.client.core.domain;

import static com.coherentlogic.usaspending.client.core.util.Constants.YEAR;

import java.math.BigDecimal;

import com.coherentlogic.coherent.data.model.core.domain.AbstractIdentityValueBean;
import com.coherentlogic.usaspending.client.core.converters.FiscalYearConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.basic.BigDecimalConverter;

/**
 * A class which represents a fiscal year as returned from USASpending.gov.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@XStreamConverter(FiscalYearConverter.class)
public class FiscalYear extends AbstractIdentityValueBean<BigDecimal> {

    private static final long serialVersionUID = -6490440401184446109L;

	/**
     * For example "2010".
     */
    @XStreamAlias(YEAR)
    @XStreamAsAttribute
    private String year = null;

    /**
     * For example "5056413250.30".
     */
    @XStreamConverter(BigDecimalConverter.class)
    private BigDecimal value = null;

    public FiscalYear() {
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public BigDecimal getValue() {
        return value;
    }

    @Override
    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        result = prime * result + ((year == null) ? 0 : year.hashCode());
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
        FiscalYear other = (FiscalYear) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        if (year == null) {
            if (other.year != null)
                return false;
        } else if (!year.equals(other.year))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "FiscalYear [year=" + year + ", value=" + value
            + ", toString()=" + super.toString() + "]";
    }
}
