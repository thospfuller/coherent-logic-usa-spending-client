package com.coherentlogic.usaspending.client.core.domain;

import static com.coherentlogic.usaspending.client.core.util.Constants.CONGRESSIONAL_DISTRICT;
import static com.coherentlogic.usaspending.client.core.util.Constants.DESCRIPTION;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * A representation of a top-known congressional district that is returned when
 * requesting summary-level detail from the USASpending.gov web services.
 *
 * @see com.coherentlogic.usaspending.client.core.domain.SummaryRecord
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class TopKnownCongressionalDistricts extends TopBean {

    private static final long serialVersionUID = 4818794854128989900L;

    @XStreamAlias(DESCRIPTION)
    @XStreamAsAttribute
    private String description = null;

    @XStreamAlias(CONGRESSIONAL_DISTRICT)
    @XStreamImplicit
    private List<CongressionalDistrict> congressionalDistrictList = null;

    public TopKnownCongressionalDistricts() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<CongressionalDistrict> getCongressionalDistrictList() {
        return congressionalDistrictList;
    }

    public void setCongressionalDistrictList(
        List<CongressionalDistrict> congressionalDistrictList) {
        this.congressionalDistrictList = congressionalDistrictList;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime
            * result
            + ((congressionalDistrictList == null) ? 0
                : congressionalDistrictList.hashCode());
        result = prime * result
            + ((description == null) ? 0 : description.hashCode());
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
        TopKnownCongressionalDistricts other = (TopKnownCongressionalDistricts) obj;
        if (congressionalDistrictList == null) {
            if (other.congressionalDistrictList != null)
                return false;
        } else if (!congressionalDistrictList
                .equals(other.congressionalDistrictList))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "TopKnownCongressionalDistricts [description=" + description
            + ", congressionalDistrictList=" + congressionalDistrictList
            + ", toString()=" + super.toString() + "]";
    }
}
