package lm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import model.Hash;

public class csvWriter {
	File file;
	String prefix;
	String from;
	String to;
	Boolean title;

	public csvWriter(File file, String prefix, String from, String to, Boolean title) {
		this.file = file;
		this.prefix = prefix;
		this.from = from;
		this.to = to;
		this.title = title;
	}

	public void writeToFile() throws NoSuchAlgorithmException, UnsupportedEncodingException {

		try (PrintWriter writer = new PrintWriter(file)) {

			StringBuilder sb = new StringBuilder();

			if (title) {

				sb.append("id");
				sb.append(',');
				sb.append("numer");
				sb.append(',');
				sb.append("hash");
				sb.append('\n');

			}

			Hash hash = new Hash();
			for (int x = 0; x < Integer.parseInt(to) - Integer.parseInt(from) + 1; x++) {

				String temp = prefix + String.format("%0" + to.length() + "d", Integer.parseInt(from) + x);

				sb.append(x + 1);
				sb.append(',');
				sb.append(temp);
				sb.append(',');
				sb.append(hash.getHash(temp));
				sb.append('\n');

			}

			writer.write(sb.toString());

			System.out.println("done!");

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}

}
