package practice.effectjvejava.item9;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TryWithResource {
	private static final int BUFFER_SIZE = 10;

	static void copy(String src, String dst) throws IOException {
		try (InputStream in = new FileInputStream(src);
			 OutputStream out = new FileOutputStream(dst)) {
			byte[] buf = new byte[BUFFER_SIZE];
			int n;
			while ((n = in.read(buf)) >= 0)
				out.write(buf, 0, n);
		}
	}
}
