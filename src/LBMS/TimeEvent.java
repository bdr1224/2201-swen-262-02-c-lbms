package LBMS;

import java.util.Date;

public class TimeEvent {
    private int hour;
    private Date date;
    
    public TimeEvent(int hour, Date date) {
        this.hour = hour;
        this.date = date;
    }
    
    public int getHour() { return this.hour; }
    public Date getDate() { return this.date; }
    
    public void ffwdTime(int hours) {
        while (hours > 0) {
            this.hour = (++this.hour) % 24;
            if (this.hour == 0) {
                this.ffwdDate(1);
            }
            hours--;
        }
        
    }
    
    /**
     * Fast forward the set date by a certain number of days
     * @param days Number of days you want to advance time by
     */
    public void ffwdDate(int days) {
        this.date = new Date(date.getTime() + (86400000 * days));
    }
}
