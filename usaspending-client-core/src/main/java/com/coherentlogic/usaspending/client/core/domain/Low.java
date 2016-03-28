package com.coherentlogic.usaspending.client.core.domain;

import static com.coherentlogic.usaspending.client.core.util.Constants.DATA;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * A representation of low-level detail search results from the USASpending.gov
 * website.
 *
 * See <a href="https://www.usaspending.gov/fsrs/fsrs.php?fiscal_year=2009&stateCode=TX&detail=l&max_records=5000">here</a>
 * for an example of low data.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@XStreamAlias("usaspendingSearchResults")
public class Low extends USASpendingSearchResults
    implements DataSpecification<LowData> {

    private static final long serialVersionUID = 8056093497727044377L;

    @XStreamAlias(DATA)
    private LowData data = null;

    public Low() {
    }

    @Override
    public LowData getData() {
        return data;
    }

    @Override
    public void setData(LowData data) {
        this.data = data;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((data == null) ? 0 : data.hashCode());
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
        Low other = (Low) obj;
        if (data == null) {
            if (other.data != null)
                return false;
        } else if (!data.equals(other.data))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Low [data=" + data + ", toString()=" + super.toString() + "]";
    }
}
