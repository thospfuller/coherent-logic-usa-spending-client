package com.coherentlogic.usaspending.client.core.domain;

import static com.coherentlogic.usaspending.client.core.util.Constants.DOC;
import static com.coherentlogic.usaspending.client.core.util.Constants.MAX_RECORDS;
import static com.coherentlogic.usaspending.client.core.util.Constants.NUM_FOUND;
import static com.coherentlogic.usaspending.client.core.util.Constants.RESULT;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.coherentlogic.coherent.data.model.core.domain.SerializableBean;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * A representation of resultant data which is returned from the
 * USASpending.gov website when a call is made to any web service requesting
 * complete details.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@Entity
@Table(name=RESULT)
@XStreamAlias(RESULT)
public class Result extends SerializableBean {

    private static final long serialVersionUID = -8930117075059178351L;

    @XStreamAlias(NUM_FOUND)
    @XStreamAsAttribute
    private long numFound = 0;

    @XStreamAlias(MAX_RECORDS)
    @XStreamAsAttribute
    private long maxRecords = 0;

    @XStreamAlias(DOC)
    @XStreamImplicit
    private List<Doc> docList = null;

    public Result () {
    }

    public long getNumFound() {
        return numFound;
    }

    public void setNumFound(long numFound) {
        this.numFound = numFound;
    }

    public long getMaxRecords() {
        return maxRecords;
    }

    public void setMaxRecords(long maxRecords) {
        this.maxRecords = maxRecords;
    }

    public List<Doc> getDocList() {
        return docList;
    }

    public void setDocList(List<Doc> docList) {
        this.docList = docList;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((docList == null) ? 0 : docList.hashCode());
        result = prime * result + (int) (maxRecords ^ (maxRecords >>> 32));
        result = prime * result + (int) (numFound ^ (numFound >>> 32));
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
        Result other = (Result) obj;
        if (docList == null) {
            if (other.docList != null)
                return false;
        } else if (!docList.equals(other.docList))
            return false;
        if (maxRecords != other.maxRecords)
            return false;
        if (numFound != other.numFound)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Result [numFound=" + numFound + ", maxRecords=" + maxRecords
            + ", docList=" + docList + ", toString()=" + super.toString()
            + "]";
    }
}
