package com.coherentlogic.usaspending.client.core.domain;

import java.util.List;

import com.coherentlogic.coherent.data.model.core.domain.SerializableBean;

import static com.coherentlogic.usaspending.client.core.util.Constants.*;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * 
 *
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class FiscalYears extends SerializableBean {

    private static final long serialVersionUID = -460454107530455325L;

    @XStreamAlias(DESCRIPTION)
    @XStreamAsAttribute
    private String description = null;

    @XStreamAlias(FISCAL_YEAR)
    @XStreamImplicit
    private List<FiscalYear> fiscalYearList = null;

    public FiscalYears() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<FiscalYear> getFiscalYearList() {
        return fiscalYearList;
    }

    public void setFiscalYearList(List<FiscalYear> fiscalYearList) {
        this.fiscalYearList = fiscalYearList;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result
            + ((description == null) ? 0 : description.hashCode());
        result = prime * result
            + ((fiscalYearList == null) ? 0 : fiscalYearList.hashCode());
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
        FiscalYears other = (FiscalYears) obj;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (fiscalYearList == null) {
            if (other.fiscalYearList != null)
                return false;
        } else if (!fiscalYearList.equals(other.fiscalYearList))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "FiscalYears [description=" + description + ", fiscalYearList="
            + fiscalYearList + ", toString()=" + super.toString() + "]";
    }
}
