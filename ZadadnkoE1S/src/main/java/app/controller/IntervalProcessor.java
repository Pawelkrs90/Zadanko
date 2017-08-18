
package app.controller;

import app.model.Interval;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class IntervalProcessor {
    
    private List<Interval> intervalContainer;

    public IntervalProcessor() {
        
        intervalContainer = new ArrayList<>();
    }
    
    public void addNewInterval(int begin, int end){
       
        List<Interval> intervalsContainingNewRange = intervalContainer.stream()
                                                                      .filter(interval -> checkValuesAreInRange(begin, end, interval) == true)
                                                                      .collect(Collectors.toList());
     
        if(intervalsContainingNewRange.isEmpty()){
            intervalContainer.add(new Interval(begin, end));
        }
        else{
            intervalsContainingNewRange.set(0, mergeIntervalsRange(intervalsContainingNewRange.get(0), new Interval(begin, end)));
                 
            while(intervalsContainingNewRange.size()>1){
                intervalsContainingNewRange.set(0, mergeIntervalsRange(intervalsContainingNewRange.get(0), intervalsContainingNewRange.get(1)));
                intervalsContainingNewRange.remove(1);
            }

            List<Interval> notUsedIntervals = intervalContainer.stream()
                                                               .filter(interval -> checkValuesAreInRange(begin, end, interval)==false)
                                                               .collect(Collectors.toList());
            
            intervalContainer.clear();
            intervalContainer.addAll(intervalsContainingNewRange);
            intervalContainer.addAll(notUsedIntervals); 
        } 
    }
    
    public boolean checkValuesAreInRange(int begin, int end, Interval interval){ 
        
        int min = begin<end?begin:end;
        int max = begin>end?begin:end;
        
        if((min >= interval.getIntervalBegin() && min <= interval.getIntervalEnd()) 
            || (max >= interval.getIntervalBegin() && max <= interval.getIntervalEnd())){
            
            return true;
        }
        else if(interval.getIntervalBegin()> min && interval.getIntervalEnd() < max){
            return true;
        }
        else{   
            return false;
        } 
    }
    
    public Interval mergeIntervalsRange(Interval intervalA, Interval intervalB){   
        
        int newBegin = (intervalA.getIntervalBegin()<intervalB.getIntervalBegin())?intervalA.getIntervalBegin():intervalB.getIntervalBegin();
        int newEnd = (intervalA.getIntervalEnd()>intervalB.getIntervalEnd())?intervalA.getIntervalEnd():intervalB.getIntervalEnd();

        return new Interval(newBegin, newEnd);
    }
    
    
    @Override
    public String toString(){
        
        StringBuilder builder = new StringBuilder();
        builder.append("Ilość przedziałow: "+intervalContainer.size());
        intervalContainer.forEach(string -> builder.append(string.toString()));   
        
        return builder.toString();
    }
    
}
