import DB.LiftRideDao;
import Models.LiftRide;
import java.util.concurrent.ConcurrentHashMap;

public class ConsumerThread implements Runnable{
	private final ConcurrentHashMap<String,String> map;
	private final String message;
	private final LiftRideDao liftRideDao;


	public ConsumerThread(LiftRideDao liftRideDao, ConcurrentHashMap<String,String> map, String message) {
		this.map = map;
		this.message = message;
		this.liftRideDao = liftRideDao;
	}

	@Override
	public void run() {
		System.out.println(message);
		String[] info = message.split("/");
		String skierID = info[7];
		map.put(skierID, message);
		liftRideDao.createLiftRide(
			new LiftRide(
				Integer.parseInt(info[7]),
				Integer.parseInt(info[1]),
				Integer.parseInt(info[3]),
				Integer.parseInt(info[5]),
				Integer.parseInt(info[9]),
				Integer.parseInt(info[11])));
	}
}
