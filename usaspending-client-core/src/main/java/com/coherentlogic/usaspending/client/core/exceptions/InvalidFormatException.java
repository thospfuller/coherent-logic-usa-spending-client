package com.coherentlogic.usaspending.client.core.exceptions;

import org.springframework.core.NestedRuntimeException;

/**
 * An exception that is thrown when the value of some string does not conform to
 * the expected format.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class InvalidFormatException extends NestedRuntimeException {

    private static final long serialVersionUID = -564640672209084173L;

    public InvalidFormatException(String msg) {
        super(msg);
    }

    public InvalidFormatException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
