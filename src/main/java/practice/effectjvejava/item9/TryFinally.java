package practice.effectjvejava.item9;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TryFinally {
	private static final int BUFFER_SIZE = 10;

	static String firstLineOfFile(String path) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(path));
		try {
			return br.readLine();
		} finally {
			br.close();
		}
	}

	static void copy(String src, String dst) throws IOException {
		InputStream in = new FileInputStream(src);
		try {
			OutputStream out = new FileOutputStream(dst);
			try {
				byte[] buf = new byte[BUFFER_SIZE];
				int n;
				while ((n = in.read(buf)) >= 0)
					out.write(buf, 0, n);
			} finally {
				out.close();
			}
		} finally {
			in.close();
		}
	}
}
