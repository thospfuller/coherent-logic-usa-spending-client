package com.coherentlogic.usaspending.client.core.domain;

import static com.coherentlogic.usaspending.client.core.util.Constants.RECORDS;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * A representation of medium-level data which is returned from the
 * USASpending.gov website.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class MediumData extends AbstractData {

    private static final long serialVersionUID = -7340090744212104029L;

    @XStreamAlias(RECORDS)
    private Records<MediumRecord> records = null;

    public MediumData() {
    }

    public Records<MediumRecord> getRecords() {
        return records;
    }

    public void setRecords(Records<MediumRecord> records) {
        this.records = records;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((records == null) ? 0 : records.hashCode());
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
        MediumData other = (MediumData) obj;
        if (records == null) {
            if (other.records != null)
                return false;
        } else if (!records.equals(other.records))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "MediumData [records=" + records + ", toString()="
            + super.toString() + "]";
    }
}
