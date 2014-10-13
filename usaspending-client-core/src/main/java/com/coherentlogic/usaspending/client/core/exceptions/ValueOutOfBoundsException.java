package com.coherentlogic.usaspending.client.core.exceptions;

import org.springframework.core.NestedRuntimeException;

/**
 * An exception that is thrown when a value is out-of-bounds -- for example
 * consider a range of 0 <= x <= 100 -- if x is 1005 then this exception will
 * be thrown.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class ValueOutOfBoundsException extends NestedRuntimeException {

    private static final long serialVersionUID = 3243067434086531638L;

    public ValueOutOfBoundsException(String msg) {
        super(msg);
    }

    public ValueOutOfBoundsException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
