package ticks;

import simulation.Simulation;

public class Ticks extends Simulation<Ticks> {

  private final double simLength;

  public Ticks(double simLength) {
    this.simLength = simLength;
  }

  @Override
  public Ticks getState() {
    return this;
  }

  @Override
  protected boolean stop() {
    return this.getCurrentTime() >= simLength;
  }

  public static void main(String[] args) {

    Ticks t = new Ticks(Integer.parseInt(args[0]));

    t.schedule(new Tick(), 1);
    t.simulate();
  }

}
