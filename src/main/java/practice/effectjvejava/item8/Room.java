package practice.effectjvejava.item8;

import java.lang.ref.Cleaner;

public class Room implements AutoCloseable{

	public static void main(String[] args) throws Exception {
		Room room = new Room(10);

		room.close();
	}

	private static final Cleaner cleaner = Cleaner.create();

	private final Cleaner.Cleanable cleanable;

	private final ResourceCleaner resourceCleaner;

	public Room(final int numJunkFiles) {
		this.resourceCleaner = new ResourceCleaner(numJunkFiles);
		cleanable = cleaner.register(this, resourceCleaner); // Runnable 객체를 등록
	}

	// Cleanable은 별도의 쓰레드로 clean을 함.
	// SampleResource을 참조하면 순환참조가 되어버림.
	// 서로를 계속 참조하기 때문에 gc에의해 수거되지 않는다.
	// 정적클래스가 아니면 자동으로 바깥객체의 참조를 가짐.
	private static class ResourceCleaner implements Runnable {
		int numJunkPiles; // clean할 대상

		public ResourceCleaner(final int numJunkPiles) {
			this.numJunkPiles = numJunkPiles;
		}

		@Override
		public void run() { // 1. close를 호출할 때, 2. cleaner(안전망)
			System.out.println("방청소");
			numJunkPiles = 0;
		}
	}

	@Override
	public void close() throws Exception {
		cleanable.clean();
	}
}
