package ticks;

import simulation.Event;

class Tick implements Event<Ticks> {

  @Override
  public void invoke(Ticks ticks) {
    System.out.println("Tick at: " + ticks.getCurrentTime());
    ticks.schedule(new Tick(), 1);
  }

}
