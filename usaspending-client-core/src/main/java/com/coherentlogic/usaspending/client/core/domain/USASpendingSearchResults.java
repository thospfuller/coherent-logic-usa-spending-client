package com.coherentlogic.usaspending.client.core.domain;

import static com.coherentlogic.usaspending.client.core.util.Constants.SEARCH_CRITERIA;

import com.coherentlogic.coherent.data.model.core.domain.SerializableBean;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * The base class for USASpending.gov search results, which include: Basic,
 * Summary, Low, Medium, and Complete.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class USASpendingSearchResults extends SerializableBean {

    private static final long serialVersionUID = 8036829835122206796L;

    @XStreamAlias(SEARCH_CRITERIA)
    private SearchCriteria searchCriteria = null;

    public USASpendingSearchResults() {
    }

    public SearchCriteria getSearchCriteria() {
        return searchCriteria;
    }

    public void setSearchCriteria(SearchCriteria searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result
            + ((searchCriteria == null) ? 0 : searchCriteria.hashCode());
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
        USASpendingSearchResults other = (USASpendingSearchResults) obj;
        if (searchCriteria == null) {
            if (other.searchCriteria != null)
                return false;
        } else if (!searchCriteria.equals(other.searchCriteria))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "USASpendingSearchResults [searchCriteria=" + searchCriteria
            + ", toString()=" + super.toString() + "]";
    }
}
