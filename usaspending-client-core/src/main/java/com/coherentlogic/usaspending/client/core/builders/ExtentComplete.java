package com.coherentlogic.usaspending.client.core.builders;

/**
 * The extent competed status of a contract. Values are:
 *
 * G = Not Competed under SAP
 * F = Competed under SAP
 * E = Follow On to Competed Action
 * NDO = Non-Competitive Delivery Order
 * D = Full and Open Competition after exclusion of sources
 * C = Not Competed
 * B = Not Available for Competition
 * A = Full and Open Competition
 * CDO = Competitive Delivery Order
 */
public enum ExtentComplete {

    /**
     * Not Competed under SAP
     */
    G,
    /**
     * Competed under SAP
     */
    F,
    /**
     * Follow On to Competed Action
     */
    E,
    /**
     * Non-Competitive Delivery Order
     */
    NDO,
    /**
     * Full and Open Competition after exclusion of sources
     */
    D,
    /**
     * Not Competed
     */
    C,
    /**
     * Not Available for Competition
     */
    B,
    /**
     * Full and Open Competition
     */
    A,
    /**
     * Competitive Delivery Order
     */
    CDO
}
