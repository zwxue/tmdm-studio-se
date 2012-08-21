package org.talend.mdm.repository.ui.navigator.sorter;

import org.talend.core.model.properties.Item;


public interface ISortOrder {
    int getOrder(Item item);
}
