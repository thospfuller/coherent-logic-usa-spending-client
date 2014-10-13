package com.coherentlogic.usaspending.client.core.domain;

import static com.coherentlogic.usaspending.client.core.util.Constants.COMPILED_FROM_GOVERNMENT_DATA_LAST_RELEASED_ON;
import static com.coherentlogic.usaspending.client.core.util.Constants.DATABASE;
import static com.coherentlogic.usaspending.client.core.util.Constants.DESCRIPTION;

import com.coherentlogic.coherent.data.model.core.domain.SerializableBean;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 *
 *
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public abstract class AbstractData extends SerializableBean {

    private static final long serialVersionUID = -7930761111479551530L;

    @XStreamAlias(COMPILED_FROM_GOVERNMENT_DATA_LAST_RELEASED_ON)
    @XStreamAsAttribute
    private String compiledFromGovernmentDataLastReleasedOn = null;

    @XStreamAlias(DATABASE)
    @XStreamAsAttribute
    private String database = null;

    @XStreamAlias(DESCRIPTION)
    @XStreamAsAttribute
    private String description = null;

    public AbstractData() {
    }

    public String getCompiledFromGovernmentDataLastReleasedOn() {
        return compiledFromGovernmentDataLastReleasedOn;
    }

    public void setCompiledFromGovernmentDataLastReleasedOn(
        String compiledFromGovernmentDataLastReleasedOn) {
        this.compiledFromGovernmentDataLastReleasedOn =
            compiledFromGovernmentDataLastReleasedOn;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime
            * result
            + ((compiledFromGovernmentDataLastReleasedOn == null) ? 0
                : compiledFromGovernmentDataLastReleasedOn.hashCode());
        result = prime * result
            + ((database == null) ? 0 : database.hashCode());
        result = prime * result
            + ((description == null) ? 0 : description.hashCode());
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
        AbstractData other = (AbstractData) obj;
        if (compiledFromGovernmentDataLastReleasedOn == null) {
            if (other.compiledFromGovernmentDataLastReleasedOn != null)
                return false;
        } else if (!compiledFromGovernmentDataLastReleasedOn
                .equals(other.compiledFromGovernmentDataLastReleasedOn))
            return false;
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
        return true;
    }

    @Override
    public String toString() {
        return "AbstractData [compiledFromGovernmentDataLastReleasedOn="
            + compiledFromGovernmentDataLastReleasedOn + ", database="
            + database + ", description=" + description + ", toString()="
            + super.toString() + "]";
    }
}
