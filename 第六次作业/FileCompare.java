import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class FileCompare {
	public static void main(String[] args) throws IOException {
		FileCompare c = new FileCompare();
		c.compareFile();
	}

	public void compareFile() {
		File file = new File("F:/1.txt");
		File file2 = new File("F:/2.txt");
		Set fileTextSet = new HashSet();
		Set file2TextSet = new HashSet();
		List fileTextList = new ArrayList();
		List fileTextList2 = new ArrayList();
		Set commonWord = new HashSet();
		try {
			getText(file, fileTextSet);
			getText(file2, file2TextSet);
			getText(file, fileTextList);
			getText(file2, fileTextList2);
			sumSet(fileTextSet, file2TextSet);
			commonSet(fileTextSet, file2TextSet);
			System.out.println("file1:" + fileTextList.size());
			System.out.println("file2:" + fileTextList2.size());
			commonWord = commonSet2(fileTextSet, file2TextSet);
			System.out.println("单词属于第一个文件不属于第二个文件占第一个文件百分比："+percent(commonWord,fileTextList)*100+"%");
			System.out.println("单词属于第二个文件不属于第一个文件占第一个文件百分比："+percent(commonWord,fileTextList2)*100+"%");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private float percent(Set textSet,List textList){
		float n=0;
		float n2=0;
		for (Iterator iterator = textList.iterator(); iterator.hasNext();) {
			String word = (String) iterator.next();
			if (!textSet.contains(word)) {
				n2++;
			}
		}
		n=n2/(float)textList.size();
		return n;	
	}
	private void commonSet(Set textSet, Set textSet2) {
		int numOfCommon = 0;
		Set commonWord = new HashSet();
		for (Iterator iterator = textSet.iterator(); iterator.hasNext();) {
			String word = (String) iterator.next();
			if (textSet2.contains(word)) {
				numOfCommon++;
				commonWord.add(word);
			}
		}
		System.out.println("Common: " + numOfCommon);
		for (Iterator iterator = commonWord.iterator(); iterator.hasNext();) {
			String word = (String) iterator.next();
			System.out.println(word);
		}
	}
	private Set commonSet2(Set textSet, Set textSet2) {
		int numOfCommon = 0;
		Set commonWord = new HashSet();
		for (Iterator iterator = textSet.iterator(); iterator.hasNext();) {
			String word = (String) iterator.next();
			if (textSet2.contains(word)) {
				numOfCommon++;
				commonWord.add(word);
			}
		}
		return commonWord;
	}
	private void sumSet(Set textSet, Set textSet2) {
		int numOfSum = 0;
		Set sumWord = new HashSet();
		for (Iterator iterator = textSet.iterator(); iterator.hasNext();) {
			String word = (String) iterator.next();
			if (!sumWord.contains(word)) {
				numOfSum++;
				sumWord.add(word);
			}
		}
		for (Iterator iterator = textSet2.iterator(); iterator.hasNext();) {
			String word = (String) iterator.next();
			if (!sumWord.contains(word)) {
				numOfSum++;
				sumWord.add(word);
			}
		}
		System.out.println("Sum: " + numOfSum);
		for (Iterator iterator = sumWord.iterator(); iterator.hasNext();) {
			String word = (String) iterator.next();
			System.out.println(word);
		}
	}

	private void getText(File file, Set textSet) throws IOException {
		BufferedReader br = null;
		InputStream is = null;
		try {
			is = new FileInputStream(file);
			br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			String lineStr = null;
			while ((lineStr = br.readLine()) != null) {
				String text = lineStr.substring(lineStr.indexOf(""));
				textSet.add(text);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				br.close();
			}
			if (is != null) {
				is.close();
			}
		}
	}

	private void getText(File file, List textList) throws IOException {
		BufferedReader br = null;
		InputStream is = null;
		try {
			is = new FileInputStream(file);
			br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			String lineStr = null;
			while ((lineStr = br.readLine()) != null) {
				String text = lineStr.substring(lineStr.indexOf(""));// 按照需求切分
				textList.add(text);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				br.close();
			}
			if (is != null) {
				is.close();
			}
		}
	}
}