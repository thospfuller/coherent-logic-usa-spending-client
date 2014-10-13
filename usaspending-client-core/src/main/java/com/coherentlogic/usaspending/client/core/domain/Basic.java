package com.coherentlogic.usaspending.client.core.domain;

import static com.coherentlogic.usaspending.client.core.util.Constants.USA_SPENDING_SEARCH_RESULTS;
import static com.coherentlogic.usaspending.client.core.util.Constants.RESULT;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * A class which represents basic search results from USASpending.gov.
 *
 * See <a href="http://www.usaspending.gov/fsrs/fsrs.php?fiscal_year=2009&stateCode=TX&detail=b&max_records=5000">here</a>
 * for an example of basic data.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@XStreamAlias(value=USA_SPENDING_SEARCH_RESULTS)
public class Basic extends USASpendingSearchResults {

    private static final long serialVersionUID = 221172081231681125L;

    @XStreamAlias(RESULT)
    private Result result = null;

    public Basic() {
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result
            + ((this.result == null) ? 0 : this.result.hashCode());
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
        Basic other = (Basic) obj;
        if (result == null) {
            if (other.result != null)
                return false;
        } else if (!result.equals(other.result))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Basic [result=" + result + ", toString()=" + super.toString()
            + "]";
    }
}
