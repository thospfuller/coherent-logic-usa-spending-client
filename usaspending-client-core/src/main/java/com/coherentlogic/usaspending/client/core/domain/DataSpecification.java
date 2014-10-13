package com.coherentlogic.usaspending.client.core.domain;

/**
 * The specification for data that is returned from requests for low, medium,
 * and summary-level detail from the USASpending.gov website.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 *
 * @param <D> The type of data.
 */
public interface DataSpecification<D> {

    D getData ();

    void setData (D d);
}
