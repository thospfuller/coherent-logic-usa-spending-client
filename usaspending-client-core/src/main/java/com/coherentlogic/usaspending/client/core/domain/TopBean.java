package com.coherentlogic.usaspending.client.core.domain;

import static com.coherentlogic.usaspending.client.core.util.Constants.MAXIMUM_SHOWN;
import static com.coherentlogic.usaspending.client.core.util.Constants.RANKED_BY;

import com.coherentlogic.coherent.data.model.core.domain.SerializableBean;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * A base class that contains common top-level data that is returned when
 * requesting top-level detail from the USASpending.gov web services.
 *
 * @see com.coherentlogic.usaspending.client.core.domain.SummaryRecord
 * @see com.coherentlogic.usaspending.client.core.domain.TopContractingAgencies
 * @see com.coherentlogic.usaspending.client.core.domain.TopKnownCongressionalDistricts
 * @see com.coherentlogic.usaspending.client.core.domain.TopRecipients
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class TopBean extends SerializableBean {

    private static final long serialVersionUID = 7561027121068616206L;

    @XStreamAlias(RANKED_BY)
    @XStreamAsAttribute
    private String rankedBy = null;

    /**
     * Should this be an int?
     */
    @XStreamAlias(MAXIMUM_SHOWN)
    @XStreamAsAttribute
    private Long maximumShown = null;

    public TopBean() {
    }

    public String getRankedBy() {
        return rankedBy;
    }

    public void setRankedBy(String rankedBy) {
        this.rankedBy = rankedBy;
    }

    public Long getMaximumShown() {
        return maximumShown;
    }

    public void setMaximumShown(Long maximumShown) {
        this.maximumShown = maximumShown;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result
            + ((maximumShown == null) ? 0 : maximumShown.hashCode());
        result = prime * result
            + ((rankedBy == null) ? 0 : rankedBy.hashCode());
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
        TopBean other = (TopBean) obj;
        if (maximumShown == null) {
            if (other.maximumShown != null)
                return false;
        } else if (!maximumShown.equals(other.maximumShown))
            return false;
        if (rankedBy == null) {
            if (other.rankedBy != null)
                return false;
        } else if (!rankedBy.equals(other.rankedBy))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "TopBean [rankedBy=" + rankedBy + ", maximumShown="
            + maximumShown + ", toString()=" + super.toString() + "]";
    }
}
