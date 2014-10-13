package com.coherentlogic.usaspending.client.core.builders;

/**
 * The type of spending for the award. Valid values are:
 *
 * c = Contracts
 * g = Grants
 *
 * Defaults to both if not provided.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public enum SpendingType {

    /**
     * Contracts
     */
    c,

    /**
     * Grants
     */
    g;
}
