package simulation;

public class ScheduledEvent<S> implements Comparable<ScheduledEvent<S>> {

  private Event event;
  private double time;

  public ScheduledEvent(Event event, double time) {
    this.event = event;
    this.time = time;
  }

  public Event getEvent() {
    return event;
  }

  public double getTime() {
    return time;
  }

//  public void setEvent(Event event) {
//    this.event = event;
//  }
//
//  public void setTime(double time) {
//    this.time = time;
//  }

  @Override
  public int compareTo(ScheduledEvent<S> other) {
    return Double.compare(getTime(), other.getTime());
  }

}
