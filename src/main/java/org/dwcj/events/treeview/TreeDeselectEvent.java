package org.dwcj.events.treeview;

import org.dwcj.controls.TreeView;
import org.dwcj.events.IDwcEvent;

public class TreeDeselectEvent implements IDwcEvent {
    private final TreeView control;

    public TreeDeselectEvent(TreeView cTree) {
        this.control = cTree;
    }

    @Override
    public TreeView getControl() {
        return control;
    }

    public String toString() { return "Event: TreeDeselected"; }
}