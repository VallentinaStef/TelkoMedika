package model;

public class QueueManager {
	private int availableQueue;

    public QueueManager(int totalQueue) {
        this.availableQueue = totalQueue;
    }

    public boolean isQueueAvailable() {
        return availableQueue > 0;
    }

    public boolean takeQueue() {
        if (availableQueue > 0) {
            availableQueue--;
            return true;
        }
        return false;
    }

    public int getRemainingQueue() {
        return availableQueue;
    }

	public void returnQueue() {
		availableQueue++;
		
	}

}
