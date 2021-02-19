/**
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */

import javax.swing.*;
import java.util.*;
import java.io.*;

public class ScoreHistoryFile {

	private static String SCOREHISTORY_DAT = "SCOREHISTORY.DAT";

	public static void addScore(String nick, String date, String score)
		throws IOException, FileNotFoundException {

		String data = nick + "\t" + date + "\t" + score + "\n";

		RandomAccessFile out = new RandomAccessFile(SCOREHISTORY_DAT, "rw");
		out.skipBytes((int) out.length());
		out.writeBytes(data);
		out.close();
	}

	public static Vector getScores(String nick)
		throws IOException, FileNotFoundException {
		Vector scores = new Vector();

		BufferedReader in =
			new BufferedReader(new FileReader(SCOREHISTORY_DAT));
		String data;
		while ((data = in.readLine()) != null) {
			// File format is nick\tfname\te-mail
			String[] scoredata = data.split("\t");
			//"Nick: scoredata[0] Date: scoredata[1] Score: scoredata[2]
			if (nick.equals(scoredata[0])) {
				scores.add(new Score(scoredata[0], scoredata[1], scoredata[2]));
			}
		}
		return scores;
	}

	public static int highestScore(String nick) throws IOException, FileNotFoundException{
		Vector scores = new Vector();

		BufferedReader in =
				new BufferedReader(new FileReader(SCOREHISTORY_DAT));
		String data;
		while ((data = in.readLine()) != null) {
			// File format is nick\tfname\te-mail
			String[] scoredata = data.split("\t");
			//"Nick: scoredata[0] Date: scoredata[1] Score: scoredata[2]
			if (nick.equals(scoredata[0])) {
				scores.add(Integer.parseInt(scoredata[2]));
			}
		}
		int obj = (int) Collections.max(scores);
		return obj;
	}
	public static int lowestScore(String nick) throws IOException, FileNotFoundException{
		Vector scores = new Vector();

		BufferedReader in =
				new BufferedReader(new FileReader(SCOREHISTORY_DAT));
		String data;
		while ((data = in.readLine()) != null) {
			// File format is nick\tfname\te-mail
			String[] scoredata = data.split("\t");
			//"Nick: scoredata[0] Date: scoredata[1] Score: scoredata[2]
			if (nick.equals(scoredata[0])) {
				scores.add(Integer.parseInt(scoredata[2]));
			}
		}
		int obj = (int) Collections.min(scores);
		return obj;
	}
	public static int highestOverallScore() throws IOException, FileNotFoundException{
		Vector scores = new Vector();
		int maxVal=0;
		String[] temp;
		BufferedReader in =
				new BufferedReader(new FileReader(SCOREHISTORY_DAT));
		String data;
		while ((data = in.readLine()) != null) {
			// File format is nick\tfname\te-mail
			String[] scoredata = data.split("\t");
			//"Nick: scoredata[0] Date: scoredata[1] Score: scoredata[2]
			if (maxVal < Integer.parseInt(scoredata[2])) {
				maxVal = Integer.parseInt(scoredata[2]);
				temp = scoredata;
			}
		}
		return maxVal;
	}
	public static int lowestOverallScore() throws IOException, FileNotFoundException{
		Vector scores = new Vector();
		int minVal=1000;
		String[] temp;
		BufferedReader in =
				new BufferedReader(new FileReader(SCOREHISTORY_DAT));
		String data;
		while ((data = in.readLine()) != null) {
			// File format is nick\tfname\te-mail
			String[] scoredata = data.split("\t");
			//"Nick: scoredata[0] Date: scoredata[1] Score: scoredata[2]
			if (minVal > Integer.parseInt(scoredata[2])) {
				minVal = Integer.parseInt(scoredata[2]);
				temp = scoredata;
			}
		}
		return minVal;
	}
	public static Vector last5Games(String nick) throws IOException, FileNotFoundException{
		Vector scores = new Vector();

		BufferedReader in = new BufferedReader(new FileReader(SCOREHISTORY_DAT));
		String data;
		while ((data = in.readLine()) != null) {
			// File format is nick\tfname\te-mail
			String[] scoredata = data.split("\t");
			//"Nick: scoredata[0] Date: scoredata[1] Score: scoredata[2]
			if (nick.equals(scoredata[0])) {
				scores.add(new Score(scoredata[0], scoredata[1], scoredata[2]));
			}
		}
		Vector finScores = new Vector();
		int maxEntries=0;
		if( scores.size()>=5){
			maxEntries = 5;
		}
		else{
			maxEntries = scores.size();
		}
		System.out.println(scores.size());
		System.out.println(scores);
		System.out.println(maxEntries);

		for(int i=0;i<maxEntries;i++){
			finScores.add(scores.get(scores.size()-i-1));
		}
		return finScores;
	}
}
