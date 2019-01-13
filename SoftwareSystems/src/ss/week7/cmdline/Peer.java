package ss.week7.cmdline;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Peer for a simple client-server application
 * 
 * @author Theo Ruys
 * @version 2005.02.21
 */
public class Peer implements Runnable {
	public static final String EXIT = "exit";

	protected String name;
	protected Socket sock;
	protected BufferedReader in;
	protected BufferedWriter out;
	private AtomicBoolean otherSideClosed = new AtomicBoolean(false);

	/*
	 * @ requires (nameArg != null) && (sockArg != null);
	 */
	/**
	 * Constructor. creates a peer object based in the given parameters.
	 * 
	 * @param nameArg name of the Peer-proces
	 * @param sockArg Socket of the Peer-proces
	 */
	public Peer(String nameArg, Socket sockArg) throws IOException {
		name = nameArg;
		sock = sockArg;

		in = new BufferedReader(new InputStreamReader(sockArg.getInputStream()));
		out = new BufferedWriter(new OutputStreamWriter(sockArg.getOutputStream()));
	}

	/**
	 * Reads strings of the stream of the socket-connection and writes the
	 * characters to the default output.
	 */
	public void run() {
		System.out.println("Starting output.");
		
		while (true) {
			
			try {
				String line = in.readLine();
				
				if (line == null) {
					otherSideClosed.set(true);
					break;
				}
				
				System.out.println(line);
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}
		}
	}

	/**
	 * Reads a string from the console and sends this string over the
	 * socket-connection to the Peer process. On Peer.EXIT the method ends
	 */
	public void handleTerminalInput() {
		BufferedReader terminal = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Starting input.");
		
		while (!otherSideClosed.get()) {
			String line;
			try {
				line = terminal.readLine();
				
				if ("EXIT".equals(line)) {
					break;
				}
				
				System.out.println(getName() + ": " + line);
				out.write(getName() + ": " + line + "\n");
				
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Goodbye!");
		
	}

	/**
	 * Closes the connection, the sockets will be terminated
	 */
	public void shutDown() {
		try {
			sock.close();
			out.close();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/** returns name of the peer object */
	public String getName() {
		return name;
	}

	/** read a line from the default input */
	static public String readString(String tekst) {
		System.out.print(tekst);
		String antw = null;
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			antw = in.readLine();
		} catch (IOException e) {
		}

		return (antw == null) ? "" : antw;
	}
}
