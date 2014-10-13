package com.coherentlogic.usaspending.client.core.domain;

import static com.coherentlogic.usaspending.client.core.util.Constants.DATABASE;
import static com.coherentlogic.usaspending.client.core.util.Constants.DESCRIPTION;
import static com.coherentlogic.usaspending.client.core.util.Constants.DETAIL;
import static com.coherentlogic.usaspending.client.core.util.Constants.RECORD;

import java.util.List;

import com.coherentlogic.coherent.data.model.core.domain.SerializableBean;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * A representation of multiple records which is returned from the
 * USASpending.gov website when requesting low and medium-level data.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class Records<R extends AbstractRecord> extends SerializableBean
    implements RecordsSpecification<R> {

    private static final long serialVersionUID = 5999561302699631159L;

    /**
     * For example "medium".
     */
    @XStreamAlias(DETAIL)
    private String detail = null;

    /**
     * For example "medium records for search".
     */
    @XStreamAlias(DESCRIPTION)
    private String description = null;

    /**
     * For example "FSRS".
     */
    @XStreamAlias(DATABASE)
    private String database = null;

    @XStreamAlias(RECORD)
    @XStreamImplicit
    private List<R> recordList = null;

    public Records() {
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    @Override
    public List<R> getRecordList() {
        return recordList;
    }

    @Override
    public void setRecordList(List<R> recordList) {
        this.recordList = recordList;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result
            + ((database == null) ? 0 : database.hashCode());
        result = prime * result
            + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((detail == null) ? 0 : detail.hashCode());
        result = prime * result
            + ((recordList == null) ? 0 : recordList.hashCode());
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
        Records other = (Records) obj;
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
        if (detail == null) {
            if (other.detail != null)
                return false;
        } else if (!detail.equals(other.detail))
            return false;
        if (recordList == null) {
            if (other.recordList != null)
                return false;
        } else if (!recordList.equals(other.recordList))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Records [detail=" + detail + ", description=" + description
            + ", database=" + database + ", recordList=" + recordList
            + ", toString()=" + super.toString() + "]";
    }
}
