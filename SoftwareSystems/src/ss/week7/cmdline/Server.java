
package ss.week7.cmdline;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Server.
 * 
 * @author Theo Ruys
 * @version 2005.02.21
 */
public class Server {
	private static final String USAGE = "usage: " + Server.class.getName() + " <name> <port>";

	/** Starts a Server-application. */
	public static void main(String[] args) {

		if (args.length != 2) {
			System.out.println(USAGE);
			System.exit(0);
		}

		String name = args[0];
		int port = 0;
		ServerSocket server = null;
		Socket client = null;

		// parse args[1] - the port
		try {
			port = Integer.parseInt(args[1]);
		} catch (NumberFormatException e) {
			System.out.println(USAGE);
			System.out.println("ERROR: port " + args[1] + " is not an integer");
			System.exit(0);
		}

		// try to open a Socket to the server
		try {
			server = new ServerSocket(port);
			client = server.accept();
		} catch (IOException e) {
			System.out.println("ERROR: could not create a socket on port " + port);
		}
		
		System.out.println("Client connected!");
		
        // create Peer object and start the two-way communication
        try {
            Peer serverPeer = new Peer(name, client);
            Thread streamInputHandler = new Thread(serverPeer);
            streamInputHandler.start();
            serverPeer.handleTerminalInput();
            System.out.println("Shutting down.");
            serverPeer.shutDown();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try {
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

} // end of class Server
