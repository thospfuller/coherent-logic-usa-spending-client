package com.coherentlogic.usaspending.client.core.domain;

import static com.coherentlogic.usaspending.client.core.util.Constants.ID;
import static com.coherentlogic.usaspending.client.core.util.Constants.NAME;
import static com.coherentlogic.usaspending.client.core.util.Constants.RANK;

import java.math.BigDecimal;

import com.coherentlogic.coherent.data.model.core.domain.AbstractIdentityValueBean;
import com.coherentlogic.usaspending.client.core.converters.AgencyConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.basic.BigDecimalConverter;
import com.thoughtworks.xstream.converters.basic.StringConverter;

/**
 * A single agency which is returned when requesting top-level detail from the
 * USASpending.gov web services.
 *
 * @see com.coherentlogic.usaspending.client.core.domain.TopContractingAgencies
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@XStreamConverter(AgencyConverter.class)
public class Agency extends AbstractIdentityValueBean<BigDecimal> {

    private static final long serialVersionUID = 972161352706453901L;

	/**
     * For example "1".
     */
    @XStreamAlias(RANK)
    private Long rank = null;

    /**
     * For example "2100".
     */
    @XStreamAlias(ID)
    @XStreamConverter(StringConverter.class)
    private String id = null;

    /**
     * For example "DEPT OF THE ARMY".
     */
    @XStreamAlias(NAME)
    private String name = null;

    /**
     * For example "393785292.15".
     */
    @XStreamConverter(BigDecimalConverter.class)
    private BigDecimal value = null;

    public Agency() {
    }

    public Long getRank() {
        return rank;
    }

    public void setRank(Long rank) {
        this.rank = rank;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((rank == null) ? 0 : rank.hashCode());
        result = prime * result + ((value == null) ? 0 : value.hashCode());
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
        Agency other = (Agency) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (rank == null) {
            if (other.rank != null)
                return false;
        } else if (!rank.equals(other.rank))
            return false;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Agency [rank=" + rank + ", id=" + id + ", name=" + name
            + ", value=" + value + ", toString()=" + super.toString() + "]";
    }
}
