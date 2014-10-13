package com.coherentlogic.usaspending.client.core.domain;

import static com.coherentlogic.usaspending.client.core.util.Constants.RECIPIENT;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * A representation of a list of top recipients that is returned when requesting
 * summary-level detail from the USASpending.gov web services.
 *
 * @see com.coherentlogic.usaspending.client.core.domain.SummaryRecord
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class TopRecipients extends TopBean {

    private static final long serialVersionUID = -3558723191186223844L;

    @XStreamAlias(RECIPIENT)
    @XStreamImplicit
    private List<Recipient> recipientList = null;

    public TopRecipients() {
    }

    public List<Recipient> getRecipientList() {
        return recipientList;
    }

    public void setRecipientList(List<Recipient> recipientList) {
        this.recipientList = recipientList;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result
            + ((recipientList == null) ? 0 : recipientList.hashCode());
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
        TopRecipients other = (TopRecipients) obj;
        if (recipientList == null) {
            if (other.recipientList != null)
                return false;
        } else if (!recipientList.equals(other.recipientList))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "TopRecipients [recipientList=" + recipientList
            + ", toString()=" + super.toString() + "]";
    }
}
