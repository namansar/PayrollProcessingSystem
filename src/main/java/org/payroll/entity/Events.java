package org.payroll.entity;

public class Events {
    String Event; // EVENT = SALARY =100000
    String EventValue; // 10000
    String notes;
    public String getEventValue() {
        return EventValue;
    }
    public void setEventValue(String eventValue) {
        EventValue = eventValue;
    }

    public String getEvent() {
        return Event;
    }
    public void setEvent(String event) {
        Event = event;
    }
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
}
