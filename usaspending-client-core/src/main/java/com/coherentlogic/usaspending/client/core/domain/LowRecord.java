package com.coherentlogic.usaspending.client.core.domain;

import static com.coherentlogic.usaspending.client.core.util.Constants.RECORD;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * A representation of a single low-level record which is returned from the
 * USASpending.gov website when requesting low-level data.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@XStreamAlias(RECORD)
public class LowRecord extends AbstractRecord {

    private static final long serialVersionUID = 5936855881232423454L;

    static final String DUNS_NO = "duns_no";

    @XStreamAlias(DUNS_NO)
    private String duns = null;

    @Override
    public String getDunsNumber() {
        return duns;
    }

    @Override
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
        LowRecord other = (LowRecord) obj;
        if (duns == null) {
            if (other.duns != null)
                return false;
        } else if (!duns.equals(other.duns))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "LowRecord [duns=" + duns + ", toString()=" + super.toString()
            + "]";
    }
}
