package org.dwcj.component.htmlcontainer.event;

import org.dwcj.component.htmlcontainer.HtmlContainer;
import org.dwcj.interfaces.ComponentEvent;

public class HtmlContainerScriptLoadedEvent implements ComponentEvent {
    
    private final HtmlContainer control;

    public HtmlContainerScriptLoadedEvent(HtmlContainer cHtmlContainer) {
        this.control = cHtmlContainer;
    }

    @Override
    public HtmlContainer getControl() {
        return control;
    }

    public String getUrl(){
        return this.control.getUrl();
    }

    public String toString() {
        return "Event: HtmlContainer Script Loaded";
    }

}
