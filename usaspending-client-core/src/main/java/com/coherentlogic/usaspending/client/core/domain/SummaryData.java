package com.coherentlogic.usaspending.client.core.domain;

import static com.coherentlogic.usaspending.client.core.util.Constants.RECORD;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * A representation of summary-level data which is returned from the
 * USASpending.gov website.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class SummaryData extends AbstractData {

    private static final long serialVersionUID = 9065430643063690459L;

    @XStreamAlias(RECORD)
    private SummaryRecord summaryRecord = null;

    public SummaryData() {
    }

    public SummaryRecord getRecord() {
        return summaryRecord;
    }

    public void setRecord(SummaryRecord summaryRecord) {
        this.summaryRecord = summaryRecord;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result
            + ((summaryRecord == null) ? 0 : summaryRecord.hashCode());
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
        SummaryData other = (SummaryData) obj;
        if (summaryRecord == null) {
            if (other.summaryRecord != null)
                return false;
        } else if (!summaryRecord.equals(other.summaryRecord))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "SummaryData [summaryRecord=" + summaryRecord + ", toString()="
            + super.toString() + "]";
    }
}
