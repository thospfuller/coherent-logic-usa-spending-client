package com.coherentlogic.usaspending.client.core.domain;

import static com.coherentlogic.usaspending.client.core.util.Constants.SEARCH_CRITERIA;
import static com.coherentlogic.usaspending.client.core.util.Constants.SEARCH_CRITERIA_TBL;
import static com.coherentlogic.usaspending.client.core.util.Constants.SEARCH_CRITERION_LIST_PROPERTY;

import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.coherentlogic.coherent.data.model.core.domain.SerializableBean;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * 
 *
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@Entity
@Table(name=SEARCH_CRITERIA_TBL)
@XStreamAlias(SEARCH_CRITERIA)
public class SearchCriteria extends SerializableBean {

    private static final long serialVersionUID = 6882143400284479685L;

    @XStreamImplicit
    private List<SearchCriterion> searchCriterionList = null;

    public SearchCriteria() {
    }

    @OneToMany(cascade=CascadeType.ALL)
    public List<SearchCriterion> getSearchCriterionList() {
        return searchCriterionList;
    }

    public void setSearchCriterionList(
        List<SearchCriterion> searchCriterionList) {
        List<SearchCriterion> oldValue = this.searchCriterionList;

        this.searchCriterionList = searchCriterionList;

        firePropertyChange(
            SEARCH_CRITERION_LIST_PROPERTY,
            oldValue,
            searchCriterionList
        );
    }

    public Iterator<SearchCriterion> iterator () {
        return searchCriterionList.iterator();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime
            * result
            + ((searchCriterionList == null) ? 0 : searchCriterionList
                .hashCode());
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
        SearchCriteria other = (SearchCriteria) obj;
        if (searchCriterionList == null) {
            if (other.searchCriterionList != null)
                return false;
        } else if (!searchCriterionList.equals(other.searchCriterionList))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "SearchCriteria [searchCriterionList=" + searchCriterionList
            + ", toString()=" + super.toString() + "]";
    }
}
