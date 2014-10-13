package com.coherentlogic.usaspending.client.core.domain;

/**
 * A representation of a multiple medium-level records which are returned from
 * the USASpending.gov website when requesting medium-level data.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class MediumRecords extends Records<MediumRecord> {

    private static final long serialVersionUID = -8338542298023752328L;

    public MediumRecords() {
    }

    @Override
    public String toString() {
        return "MediumRecords [toString()=" + super.toString() + "]";
    }
}
