package org.dwcj.events;

import org.dwcj.controls.AbstractDwcControl;
import org.dwcj.controls.Button;

public class ButtonPushEvent implements IDwcEvent {
    private final Button control;

    public ButtonPushEvent(Button cButton) {
        this.control = cButton;
    }

    @Override
    public Button getControl() {
        return control;
    }
}
