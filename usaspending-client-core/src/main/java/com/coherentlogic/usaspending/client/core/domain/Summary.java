package com.coherentlogic.usaspending.client.core.domain;

import static com.coherentlogic.usaspending.client.core.util.Constants.COMPILED_FROM_GOVERNMENT_DATA_LAST_RELEASED_ON;
import static com.coherentlogic.usaspending.client.core.util.Constants.DATA;
import static com.coherentlogic.usaspending.client.core.util.Constants.DATABASE;
import static com.coherentlogic.usaspending.client.core.util.Constants.DESCRIPTION;
import static com.coherentlogic.usaspending.client.core.util.Constants.USA_SPENDING_SEARCH_RESULTS;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * A class which represents summarised search results from USASpending.gov.
 *
 * See <a href="https://www.usaspending.gov/fsrs/fsrs.php?fiscal_year=2009&stateCode=TX&detail=s&max_records=5000">here</a>
 * for an example of summary data.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@XStreamAlias(USA_SPENDING_SEARCH_RESULTS)
public class Summary extends USASpendingSearchResults
    implements DataSpecification<SummaryData> {

    private static final long serialVersionUID = 1323409730421582436L;

    @XStreamAlias(COMPILED_FROM_GOVERNMENT_DATA_LAST_RELEASED_ON)
    @XStreamAsAttribute
    private String compiledFromGovernmentDataLastReleasedOn = null;

    @XStreamAlias(DATABASE)
    @XStreamAsAttribute
    private String database = null;

    @XStreamAlias(DESCRIPTION)
    @XStreamAsAttribute
    private String description = null;

    @XStreamAlias(DATA)
    private SummaryData data = null;

    public Summary() {
    }

    public String getCompiledFromGovernmentDataLastReleasedOn() {
        return compiledFromGovernmentDataLastReleasedOn;
    }

    public void setCompiledFromGovernmentDataLastReleasedOn(
        String compiledFromGovernmentDataLastReleasedOn) {
        this.compiledFromGovernmentDataLastReleasedOn =
            compiledFromGovernmentDataLastReleasedOn;
    }

    @Override
    public SummaryData getData() {
        return data;
    }

    @Override
    public void setData(SummaryData data) {
        this.data = data;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime
            * result
            + ((compiledFromGovernmentDataLastReleasedOn == null) ? 0
                : compiledFromGovernmentDataLastReleasedOn.hashCode());
        result = prime * result + ((data == null) ? 0 : data.hashCode());
        result = prime * result
            + ((database == null) ? 0 : database.hashCode());
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
        Summary other = (Summary) obj;
        if (compiledFromGovernmentDataLastReleasedOn == null) {
            if (other.compiledFromGovernmentDataLastReleasedOn != null)
                return false;
        } else if (!compiledFromGovernmentDataLastReleasedOn
                .equals(other.compiledFromGovernmentDataLastReleasedOn))
            return false;
        if (data == null) {
            if (other.data != null)
                return false;
        } else if (!data.equals(other.data))
            return false;
        if (database == null) {
            if (other.database != null)
                return false;
        } else if (!database.equals(other.database))
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
        return "Summary [compiledFromGovernmentDataLastReleasedOn="
            + compiledFromGovernmentDataLastReleasedOn + ", database="
            + database + ", description=" + description + ", data=" + data
            + ", toString()=" + super.toString() + "]";
    }
}
