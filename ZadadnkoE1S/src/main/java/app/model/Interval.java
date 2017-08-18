
package app.model;

public class Interval {
    
    private int intervalBegin;
    private int intervalEnd;
    
    public Interval(int begin, int end){
        this.intervalBegin = begin;
        this.intervalEnd = end;
    }

    public int getIntervalBegin() {
        return intervalBegin;
    }

    public void setIntervalBegin(int intervalBegin) {
        this.intervalBegin = intervalBegin;
    }

    public int getIntervalEnd() {
        return intervalEnd;
    }

    public void setIntervalEnd(int intervalEnd) {
        this.intervalEnd = intervalEnd;
    }
    
    @Override
    public String toString(){
        return " <"+this.intervalBegin+", "+this.intervalEnd+">";
    }
}
