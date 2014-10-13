package com.coherentlogic.usaspending.client.core.domain;

import java.util.List;

/**
 * The specification for records which are returned from low and medium-level
 * search results from the USASpending.gov website.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 *
 * @param <R> The record type.
 */
public interface RecordsSpecification<R extends AbstractRecord> {

    List<R> getRecordList ();

    void setRecordList (List<R> record);
}
