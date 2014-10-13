package com.coherentlogic.usaspending.client.core.domain;

import static com.coherentlogic.usaspending.client.core.util.Constants.DATA;
import static com.coherentlogic.usaspending.client.core.util.Constants.RECORDS;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * A representation of low-level data which is returned from the USASpending.gov
 * website.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@XStreamAlias(DATA)
public class LowData extends AbstractData {

    private static final long serialVersionUID = -2339575959134774564L;

    @XStreamAlias(RECORDS)
    private Records<LowRecord> records = null;

    public LowData() {
    }

    public Records<LowRecord> getRecords() {
        return records;
    }

    public void setRecords(Records<LowRecord> records) {
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
        LowData other = (LowData) obj;
        if (records == null) {
            if (other.records != null)
                return false;
        } else if (!records.equals(other.records))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "LowData [records=" + records + ", toString()="
            + super.toString() + "]";
    }
}
