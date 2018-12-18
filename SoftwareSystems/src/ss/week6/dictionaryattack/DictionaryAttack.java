package ss.week6.dictionaryattack;

import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class DictionaryAttack {
	private Map<String, String> passwordMap;
	private Map<String, String> hashDictionary;

	public DictionaryAttack() {
		passwordMap = new HashMap<String, String>();
		hashDictionary = new HashMap<String, String>();
	}
	
	/**
	 * Reads a password file. Each line of the password file has the form: username:
	 * encodedpassword
	 * 
	 * After calling this method, the passwordMap class variable should be filled
	 * withthe content of the file. The key for the map should be the username, and
	 * the password hash should be the content.
	 * 
	 * @param filename
	 * @throws IOException 
	 */
	public void readPasswords(String filename) throws IOException {
		FileReader file = new FileReader(filename);
		Scanner scan = new Scanner(file);

		while (scan.hasNextLine()) {
			String[] parts = scan.nextLine().split(": ");
			passwordMap.put(parts[0], parts[1]);
		}

		scan.close();
		file.close();
	}

	/**
	 * Given a password, return the MD5 hash of a password. The resulting hash (or
	 * sometimes called digest) should be hex-encoded in a String.
	 * 
	 * @param password
	 * @return
	 */
	public String getPasswordHash(String password) {
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			byte[] hash = digest.digest(password.getBytes());
			StringBuffer buffer = new StringBuffer();
			for (byte b : hash) {
				buffer.append(String.format("%02x", b & 0xff));
			}
			return buffer.toString();
		} catch (NoSuchAlgorithmException e) {
			// This exception should not be thrown, as "MD5" is a valid algorithm.
		    // But it might not be so in the future.
			return "";
		}
	}

	/**
	 * Checks the password for the user the password list. If the user does not
	 * exist, returns false.
	 * 
	 * @param user
	 * @param password
	 * @return whether the password for that user was correct.
	 */
	public boolean checkPassword(String user, String password) {
		boolean result = false;
		
		if (passwordMap.containsKey(user)) {
			result = passwordMap.get(user).equals(getPasswordHash(password));
		}
		
		return result;
	}

	/**
	 * Reads a dictionary from file (one line per word) and use it to add entries to
	 * a dictionary that maps password hashes (hex-encoded) to the original
	 * password.
	 * 
	 * @param filename filename of the dictionary.
	 */
	public void addToHashDictionary(String filename) throws IOException {
		FileReader file = new FileReader(filename);
		Scanner scan = new Scanner(file);

		while (scan.hasNextLine()) {
			String pass = scan.nextLine();
		    hashDictionary.put(getPasswordHash(pass), pass);
		}

		scan.close();
		file.close();
	}

	/**
	 * Do the dictionary attack.
	 */
	public void doDictionaryAttack() {
		int passwordsFound = 0;
		
		for (Entry<String, String> userPass : passwordMap.entrySet()) {
			String password = hashDictionary.get(userPass.getValue());
			
			if (password != null) {
				System.out.printf("%s: %s\n", userPass.getKey(), password);
				passwordsFound++;
			}
		}
		
		System.out.printf("Found %x out of %x passwords.\n", passwordsFound, passwordMap.size());
	}

	public static void main(String[] args) {
		DictionaryAttack da = new DictionaryAttack();
		try {
			da.addToHashDictionary("src/ss/week6/test/MostCommonPasswords.txt");
			da.addToHashDictionary("src/ss/week6/test/LinuxWords.txt");
			da.readPasswords("src/ss/week6/test/LeakedPasswords.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		da.doDictionaryAttack();
	}

}
