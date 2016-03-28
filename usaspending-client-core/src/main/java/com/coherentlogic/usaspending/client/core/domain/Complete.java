package com.coherentlogic.usaspending.client.core.domain;

import static com.coherentlogic.usaspending.client.core.util.Constants.COMPLETE_SEARCH_RESULTS;
import static com.coherentlogic.usaspending.client.core.util.Constants.RESULT;
import static com.coherentlogic.usaspending.client.core.util.Constants.USA_SPENDING_SEARCH_RESULTS;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * A class which represents complete-level detail search results from
 * USASpending.gov.
 *
 * See <a href="https://www.usaspending.gov/fsrs/fsrs.php?fiscal_year=2009&stateCode=TX&detail=c&max_records=5000">here</a>
 * for an example of complete data.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@Entity
@Table(name=COMPLETE_SEARCH_RESULTS)
@XStreamAlias(USA_SPENDING_SEARCH_RESULTS)
public class Complete extends USASpendingSearchResults {

    private static final long serialVersionUID = 686869156811442565L;

    @XStreamAlias(RESULT)
    private Result result = null;

    public Complete() {
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
        Complete other = (Complete) obj;
        if (result == null) {
            if (other.result != null)
                return false;
        } else if (!result.equals(other.result))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Complete [result=" + result + ", toString()="
            + super.toString() + "]";
    }
}
