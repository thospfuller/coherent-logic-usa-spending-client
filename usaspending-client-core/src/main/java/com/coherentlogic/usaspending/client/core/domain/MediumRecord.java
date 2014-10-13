package com.coherentlogic.usaspending.client.core.domain;

import static com.coherentlogic.usaspending.client.core.util.Constants.RECORD;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * A representation of a single medium-level record which is returned from the
 * USASpending.gov website when requesting medium-level data.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@XStreamAlias(RECORD)
public class MediumRecord extends AbstractRecord {

    private static final long serialVersionUID = -7567594855386126461L;

    static final String DUNS = "duns";

    @XStreamAlias(DUNS)
    private String duns = null;

    public String getDunsNumber() {
        return duns;
    }

    public void setDunsNumber(String duns) {
        this.duns = duns;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((duns == null) ? 0 : duns.hashCode());
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
        MediumRecord other = (MediumRecord) obj;
        if (duns == null) {
            if (other.duns != null)
                return false;
        } else if (!duns.equals(other.duns))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "MediumRecord [duns=" + duns + ", toString()="
            + super.toString() + "]";
    }
}
