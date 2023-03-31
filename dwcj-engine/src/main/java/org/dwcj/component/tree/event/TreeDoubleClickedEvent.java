package org.dwcj.component.tree.event;

import org.dwcj.component.tree.TreeView;
import org.dwcj.interfaces.ComponentEvent;

public class TreeDoubleClickedEvent implements ComponentEvent {
    private final TreeView control;

    public TreeDoubleClickedEvent(TreeView cTree) {
        this.control = cTree;
    }

    @Override
    public TreeView getControl() {
        return control;
    }

    public String toString() { return "Event: TreeDoubleClicked"; }
}
