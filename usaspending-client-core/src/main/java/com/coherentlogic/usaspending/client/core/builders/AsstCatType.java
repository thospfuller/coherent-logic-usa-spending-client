package com.coherentlogic.usaspending.client.core.builders;

/**
 * The type of assistance provided. Valid values are:
 *
 * d = Direct Payments (both specified and unrestricted)
 * g = Grants and Cooperative Agreements
 * i = Insurance
 * l = Loans (both direct and guaranteed)
 * o = Other
 *
 * @todo Change these single character strings to actual words.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public enum AsstCatType {

    /**
     * Direct Payments (both specified and unrestricted)
     */
    d,

    /**
     * Grants and Cooperative Agreements
     */
    g,

    /**
     * Insurance
     */
    i,

    /**
     * Loans (both direct and guaranteed)
     */
    l,

    /**
     * Other
     */
    o;
}
