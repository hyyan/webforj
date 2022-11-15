package org.dwcj.controls;

import com.basis.bbj.proxies.sysgui.BBjControl;
import com.basis.bbj.proxies.sysgui.BBjRadioButton;
import com.basis.bbj.proxies.sysgui.BBjWindow;
import com.basis.startup.type.BBjException;
import org.dwcj.bridge.PanelAccessor;
import org.dwcj.panels.AbstractDwcjPanel;

import org.dwcj.events.RadioButtonCheckEvent;
import org.dwcj.events.sinks.RadioButtonCheckEventSink;

import java.util.function.Consumer;


public final class RadioButton extends AbstractDwcControl implements IReadOnly, IFocusable, ITabTraversable {

    private BBjRadioButton bbjRadioButton;

    
    public static enum Expanse{
        LARGE, MEDIUM, SMALL, XLARGE, XSMALL
    }
    
    public static enum HorizontalTextPosition{
        RIGHT(4), LEFT(2), CENTER(0), LEADING(10), TRAILING(11);
        
        public final Integer position;
        
        private HorizontalTextPosition(Integer position){
            this.position = position;
        }
    }
    
    private Consumer<RadioButtonCheckEvent> callback;
    private Boolean selected = false;
    private HorizontalTextPosition horizontalTextPosition = HorizontalTextPosition.RIGHT;

    public RadioButton(){
        this.readOnly = false;
        this.focusable = true;
        this.tabTraversable = true;
    }

    @Override
    protected void create(AbstractDwcjPanel p) {
        try {
            BBjWindow w = PanelAccessor.getDefault().getBBjWindow(p);
            //todo: honor visibility flag, if set before adding the control to the form, so it's created invisibly right away
            ctrl = w.addRadioButton(w.getAvailableControlID(), BASISNUMBER_1, BASISNUMBER_1, BASISNUMBER_1, BASISNUMBER_1, "");
            bbjRadioButton = (BBjRadioButton) ctrl;
            catchUp();
        } catch (Exception e)  {
            e.printStackTrace();
        }
    }

    /**
     * register an event callback for a checkOn or checkOff event
     *
     * @param callback A method to receive the onCheck event
     * @return
     */
    public RadioButton onCheck(Consumer<RadioButtonCheckEvent> callback) {
        this.callback = callback;
        new RadioButtonCheckEventSink(this, callback);
        return this;
    }

    public Integer getButtonID() {
        try {
            return bbjRadioButton.getID();
        } catch (BBjException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public RadioButtonGroup getRadioButtonGroup() {
        try {
            BBjControl bbjGroup = (BBjControl) bbjRadioButton.getRadioGroup();
            int id = bbjGroup.getID();
            return RadioButtonGroup.getGroupByID(id);
        } catch (BBjException e) {
            e.printStackTrace();
            return null;
        }
    }


    public HorizontalTextPosition getHorizontalTextPosition(){
        if(this.ctrl != null){
            return this.horizontalTextPosition;
        }
        return HorizontalTextPosition.RIGHT;
    }


    public RadioButton setHorizontalTextPosition(HorizontalTextPosition position) {
        //todo: why could an exception be thrown?
        if(this.ctrl != null){
            try {
                bbjRadioButton.setHorizontalTextPosition(position.position);
            } catch (BBjException e) {
                e.printStackTrace();
            }
        }
        this.horizontalTextPosition = position;
        return this;
    }


    public Boolean isSelected() {
        if(this.ctrl != null){
            try {
                return bbjRadioButton.isSelected();
            } catch (BBjException e) {
                e.printStackTrace();
            }
        }
        return false;
    }


    public RadioButton setSelected(boolean selected) {
        if(this.ctrl != null){
            try {
                bbjRadioButton.setSelected(selected);
            } catch (BBjException e) {
                e.printStackTrace();
            }
        }
        return this;
    }




    @Override
    public Boolean isReadOnly() {
        try {
            return bbjRadioButton.isEditable();
        } catch (BBjException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public RadioButton setReadOnly(Boolean editable) {
        try {
            bbjRadioButton.setEditable(editable);
        } catch (BBjException e) {
            e.printStackTrace();
        }
        return this;
    }

    @Override
    public Boolean isFocusable(){
        if(this.ctrl != null){
            try{
                bbjRadioButton.isFocusable();
            } catch(BBjException e){
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public RadioButton setFocusable(Boolean focusable){
        if(this.ctrl != null) {
            try{
                bbjRadioButton.setFocusable(focusable);
            } catch (BBjException e){
                e.printStackTrace();
            }
        }
        this.focusable = focusable;
        return this;
    }

    @Override
    public Boolean isTabTraversable(){
        if(this.ctrl != null){
            try{
                bbjRadioButton.isTabTraversable();
            } catch (BBjException e){
                e.printStackTrace();
            }
        }
        return true;
    }

    @Override
    public RadioButton setTabTraversable(Boolean traverse){
        if(this.ctrl != null){
            try{
                bbjRadioButton.setTabTraversable(traverse);
            } catch (BBjException e){
                e.printStackTrace();
            }
        }
        this.tabTraversable = traverse;
        return this;
    }




    public RadioButton setText(String text) {
        super.setControlText(text);
        return this;
    }

    public RadioButton setVisible(Boolean visible){
        super.setControlVisible(visible);
        return this;
    }
    
    public RadioButton setEnabled(Boolean enabled) {
        super.setControlEnabled(enabled);
        return this;
    }

    public RadioButton setTooltipText(String text) {
        super.setControlTooltipText(text);
        return this;
    }

    public RadioButton setAttribute(String attribute, String value){
        super.setControlAttribute(attribute, value);
        return this;
    }

    public RadioButton setID(String id){
        super.setControlID(id);
        return this;
    }

    public RadioButton setStyle(String property, String value) {
        super.setControlStyle(property, value);
        return this;
    }
    
    public RadioButton addClass(String selector) {
        super.addControlCssClass(selector);
        return this;
    }

    public RadioButton removeClass(String selector) {
        super.removeControlCssClass(selector);
        return this;
    }





    public RadioButton setExpanse(Expanse expanse) {
        super.setControlExpanse(expanse);
        return this;
    }


    @Override
    @SuppressWarnings("java:S3776") // tolerate cognitive complexity for now, it's just a batch list of checks
    protected void catchUp() throws IllegalAccessException {
        if (this.caughtUp) throw new IllegalAccessException("catchUp cannot be called twice");

        super.catchUp();
        
        if(this.selected != false){
            this.setSelected(this.selected);
        } 
        if(this.callback != null){
            this.onCheck(this.callback);
        }
        
        if(this.horizontalTextPosition != HorizontalTextPosition.RIGHT){
            try{
                bbjRadioButton.setHorizontalTextPosition(horizontalTextPosition.position);
            } catch(BBjException e){
                e.printStackTrace();
            }
            this.setHorizontalTextPosition(this.horizontalTextPosition);
        }

        if(this.readOnly != false){
            this.setReadOnly(true);
        }

        if(this.focusable != true){
            this.setFocusable(this.focusable);
        }

        if(this.tabTraversable != true){
            this.setTabTraversable(this.tabTraversable);
        }

    }

}
