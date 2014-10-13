package com.coherentlogic.usaspending.client.core.domain;

import static com.coherentlogic.usaspending.client.core.util.Constants.FIELD;
import static com.coherentlogic.usaspending.client.core.util.Constants.SEARCH_CRITERION;
import static com.coherentlogic.usaspending.client.core.util.Constants.SEARCH_CRITERION_TBL;
import static com.coherentlogic.usaspending.client.core.util.Constants.VALUE;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.coherentlogic.coherent.data.model.core.domain.SerializableBean;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@Entity
@Table(name=SEARCH_CRITERION_TBL)
@XStreamAlias(SEARCH_CRITERION)
public class SearchCriterion extends SerializableBean {

    private static final long serialVersionUID = 7892763880943720395L;

    @XStreamAlias(FIELD)
    @XStreamAsAttribute
    private String field = null;

    @XStreamAlias(VALUE)
    @XStreamAsAttribute
    private String value = null;

    public SearchCriterion() {
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((field == null) ? 0 : field.hashCode());
        result = prime * result + ((value == null) ? 0 : value.hashCode());
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
        SearchCriterion other = (SearchCriterion) obj;
        if (field == null) {
            if (other.field != null)
                return false;
        } else if (!field.equals(other.field))
            return false;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "SearchCriterion [field=" + field + ", value=" + value
            + ", toString()=" + super.toString() + "]";
    }
}
