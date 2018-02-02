package ssq;

import static ssq.SingleServerQueue.SERVICE_TIME;

import simulation.Event;

public class Arrive implements Event<SingleServerQueue> {

  @Override
  public void invoke(SingleServerQueue ssq) {

    if (ssq.getQueueLength() == 0) {
      ssq.schedule(new Depart(), SERVICE_TIME);
    }

    ssq.schedule(new Arrive(), ssq.getInterArrivalTime());
    ssq.increaseQueue();

    System.out.println("Arrival at " + ssq.getCurrentTime()
        + ", new population = " + ssq.getQueueLength());
  }

}
