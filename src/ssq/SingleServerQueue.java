package ssq;

import java.util.Random;
import simulation.Simulation;

public class SingleServerQueue extends Simulation<SingleServerQueue> {

  public static final double SERVICE_TIME = 0.25;

  private int queueLength;
  private final Random random  = new Random();
  private final double simLength;
  private double totalWeightedLengths;
  private double previousTime;

  public SingleServerQueue(long seed, double simLength) {
    this.queueLength = 0;
    random.setSeed(seed);
    this.simLength = simLength;
    this.totalWeightedLengths = 0;
    this.previousTime = 0;
  }

  protected int getQueueLength() {
    return queueLength;
  }

  protected void increaseQueue() {
    totalWeightedLengths += (getCurrentTime() - previousTime) * getQueueLength();
    previousTime = getCurrentTime();
    this.queueLength++;
  }

  protected void decreaseQueue() {
    totalWeightedLengths += (getCurrentTime() - previousTime) * getQueueLength();
    previousTime = getCurrentTime();
    this.queueLength--;
  }

  protected double getInterArrivalTime() {
    return random.nextDouble();
  }

  @Override
  protected boolean stop() {
    return this.getCurrentTime() > simLength;
  }

  @Override
  public SingleServerQueue getState() {
    return this;
  }

  public static void main(String[] args) {

    long seed = Long.parseLong(args[0]);
    double simLength = Double.parseDouble(args[1]);

    SingleServerQueue ssq = new SingleServerQueue(seed, simLength);
    ssq.schedule(new Arrive(), ssq.getInterArrivalTime());
    ssq.simulate();

    ssq.totalWeightedLengths += (ssq.simLength - ssq.getCurrentTime()) * ssq.getQueueLength();
    double meanQueueLength = ssq.totalWeightedLengths / simLength;

    System.out.println("SIMULATION COMPLETE - the mean queue length was " + meanQueueLength);
  }

}
