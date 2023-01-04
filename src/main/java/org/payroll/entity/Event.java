package org.payroll.entity;

public class Event {
    String eventEmpId;
    String Event;
    String EventValue;
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
    public String getEventEmpId() {
        return eventEmpId;
    }
    public void setEventEmpId(String eventEmpId) {
        this.eventEmpId = eventEmpId;
    }
}
