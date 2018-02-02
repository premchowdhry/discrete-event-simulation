package ssq;

import static ssq.SingleServerQueue.SERVICE_TIME;

import simulation.Event;

public class Depart implements Event<SingleServerQueue> {

  @Override
  public void invoke(SingleServerQueue ssq) {

    ssq.decreaseQueue();

    if (ssq.getQueueLength() != 0) {
      ssq.schedule(new Depart(), SERVICE_TIME);
    }

    System.out.println("Departure at " + ssq.getCurrentTime()
        + ", new population = " + ssq.getQueueLength());
  }

}
