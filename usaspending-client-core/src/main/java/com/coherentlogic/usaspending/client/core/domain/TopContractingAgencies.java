package com.coherentlogic.usaspending.client.core.domain;

import static com.coherentlogic.usaspending.client.core.util.Constants.AGENCY;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * A representation of a list of top contracting agencies that is returned when
 * requesting summary-level detail from the USASpending.gov web services.
 *
 * @see com.coherentlogic.usaspending.client.core.domain.SummaryRecord
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class TopContractingAgencies extends TopBean {

    private static final long serialVersionUID = -9024417125389725171L;

    @XStreamAlias(AGENCY)
    @XStreamImplicit
    private List<Agency> agencyList = null;

    public TopContractingAgencies() {
    }

    public List<Agency> getAgencyList() {
        return agencyList;
    }

    public void setAgencyList(List<Agency> agencyList) {
        this.agencyList = agencyList;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result
            + ((agencyList == null) ? 0 : agencyList.hashCode());
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
        TopContractingAgencies other = (TopContractingAgencies) obj;
        if (agencyList == null) {
            if (other.agencyList != null)
                return false;
        } else if (!agencyList.equals(other.agencyList))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "TopContractingAgencies [agencyList=" + agencyList
            + ", toString()=" + super.toString() + "]";
    }
}
