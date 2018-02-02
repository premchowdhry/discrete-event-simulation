package simulation;

import java.util.PriorityQueue;
import java.util.Queue;

public abstract class Simulation<S> {

  private Queue<ScheduledEvent> diary = new PriorityQueue<>();
  private double currentTime;

  public double getCurrentTime() {
    return currentTime;
  }

  private void setCurrentTime(double newTime) {
    this.currentTime = newTime;
  }

  protected abstract boolean stop();

  public void schedule(Event event, double offset) {
    ScheduledEvent s = new ScheduledEvent(event, currentTime + offset);
    diary.add(s);
  }

  public abstract S getState();

  public void simulate() {
    while(!diary.isEmpty()) {
      ScheduledEvent s = diary.poll();
      setCurrentTime(s.getTime());
      if (!stop()) {
        s.getEvent().invoke(getState());
      }
      else break;
    }
  }

}
