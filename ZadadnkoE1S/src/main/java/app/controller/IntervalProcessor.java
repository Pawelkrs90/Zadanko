
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
       
        List<Interval> filteredList = intervalContainer.stream().filter(interval -> checkValuesAreInRange(begin, end, interval) == true)
                                                                .collect(Collectors.toList());
     
        if(filteredList.isEmpty()){
            intervalContainer.add(new Interval(begin, end));
        }
        else{
            List<Interval> notFilteredredList = intervalContainer.stream().filter(interval -> checkValuesAreInRange(begin, end, interval)==false)
                                                                          .collect(Collectors.toList());
        
            while(filteredList.size()>1){
                filteredList.set(0, mergeIntervalsRange(filteredList.get(0), filteredList.get(1)));
                filteredList.remove(1);
            }

            intervalContainer.clear();
            intervalContainer.addAll(filteredList);
            intervalContainer.addAll(notFilteredredList); 
        } 
   }
    
    
    public boolean checkValuesAreInRange(int begin, int end, Interval interval){   //czy chociaz jedno jest w zakresie
        
        if((begin >= interval.getIntervalBegin() && begin <= interval.getIntervalEnd()) 
            || (end >= interval.getIntervalBegin() && end <= interval.getIntervalEnd())){
            
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
