package com.coherentlogic.usaspending.client.core.domain;

import static com.coherentlogic.usaspending.client.core.util.Constants.DATA;
import static com.coherentlogic.usaspending.client.core.util.Constants.USA_SPENDING_SEARCH_RESULTS;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * A class which represents medium-level detail search results from
 * USASpending.gov.
 *
 * See <a href="https://www.usaspending.gov/fsrs/fsrs.php?fiscal_year=2009&stateCode=TX&detail=m&max_records=5000">here</a>
 * for an example of summary data.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@XStreamAlias(value=USA_SPENDING_SEARCH_RESULTS)
public class Medium extends USASpendingSearchResults
    implements DataSpecification<MediumData> {

    private static final long serialVersionUID = 7612919175433515047L;

    @XStreamAlias(DATA)
    private MediumData data = null;

    public Medium() {
    }

    @Override
    public MediumData getData() {
        return data;
    }

    @Override
    public void setData(MediumData data) {
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
        Medium other = (Medium) obj;
        if (data == null) {
            if (other.data != null)
                return false;
        } else if (!data.equals(other.data))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Medium [data=" + data + ", toString()=" + super.toString()
            + "]";
    }
}
