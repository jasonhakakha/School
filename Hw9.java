import java.io.*;
import java.util.*;
public class Hw9 {
	public static void main(String args[]) throws FileNotFoundException, IOException{
		File file = new File("src/times.dat");
		try(RandomAccessFile randomfile = new RandomAccessFile(file, "rw")){
			int count;
			if(randomfile.length() == 0)
				count = 1;
			else
				count = randomfile.readInt() + 1;
			randomfile.seek(0);
			randomfile.writeInt(count);
			System.out.println(count);
		}
	}
}
