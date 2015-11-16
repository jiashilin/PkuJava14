import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class VocabularyTable {

	TreeSet<String> VocTable = new TreeSet<String>();// 将读取一个文件的单词放到词汇表中

	public void readFile(File filePath) {
		try {
			FileReader fr = new FileReader(filePath);
			String voc = "";// 存放单词
			char[] c = new char[1];// 每次读取一个字母
			int b = 0;
			while ((b = fr.read(c)) != -1)// 每次读取一个字母直到最后
			{// 如果字符为 换行、空格、单引号、双引号、逗号、句号等不是字母的 则为一个单词的结束及另一个单词的开始
				if (c[0]<65||(c[0]>90&&c[0]<97)||c[0]>122||c[0]=='-') {
					VocTable.add(voc);
					voc="";

				} else {
					voc += String.valueOf(c).toLowerCase();//将其统一转化为小写字母
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String str="";
		Scanner scan=new Scanner(System.in);
		System.out.println("请输入第一个文件文件路径(如F:/1.txt)：");
		String filePath1=scan.next();
		File file1 = new File(filePath1);
		VocabularyTable vc1=new VocabularyTable();//第一个文件词汇表
		vc1.readFile(file1);
		
		System.out.println("请输入第二个文件文件路径(如F:/1.txt)：");
		String filePath2=scan.next();
		File file2 = new File(filePath2);
		VocabularyTable vc2=new VocabularyTable();//第二个文件词汇表
		vc2.readFile(file2);
		
		VocabularyTable vc3=new VocabularyTable();//两个文件总的文件词汇表
		vc3.VocTable.addAll(vc1.VocTable);
		vc3.VocTable.addAll(vc2.VocTable);
		
		VocabularyTable vc4=new VocabularyTable();//两个文件词汇表的交集
		Iterator<String> t1=vc1.VocTable.iterator();
		while(t1.hasNext()){
			str=t1.next();
			if(vc2.VocTable.contains(str)){
				vc4.VocTable.add(str);
			}
		}
		
		
		//将结果写入文件
		System.out.print("请输入结果输出文件的路径(如F:/1.txt):\n");
		String outFile=scan.next();
		File file = new File(outFile);
		if (!file.exists())
			file.createNewFile();
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("两个文件并集的词汇表:\n");
		System.out.print("两个文件并集的词汇表:\n");
		Iterator<String> t2=vc3.VocTable.iterator();
		while(t2.hasNext()){
			str=t2.next();
			bw.write(str+" ");
			System.out.print(str+" ");
		}
		bw.write("\n");
		System.out.println();
		bw.write("两个文件交集的词汇表:\n");
		System.out.print("两个文件交集的词汇表:\n");
		Iterator<String> t3=vc4.VocTable.iterator();
		while(t3.hasNext()){
			str=t3.next();
			bw.write(str+" ");
			System.out.print(str+" ");
		}
		bw.write("\n");
		System.out.println();
		bw.write("文件一包含单词总数:\n");
		System.out.print("文件一包含单词总数:\n");
		bw.write(String.valueOf(vc1.VocTable.size()));
		System.out.print(vc1.VocTable.size());
		
		bw.write("\n");
		System.out.println();
		bw.write("文件一包含文件二不包含的单词占文件一单词的百分比:\n");
		System.out.print("文件一包含文件二不包含的单词占文件一单词的百分比:\n");
		VocabularyTable vc5=new VocabularyTable();//文件一包含文件二不包含的单词词汇表
		Iterator<String> t5=vc1.VocTable.iterator();
		while(t5.hasNext()){
			str=t5.next();
			if(!vc2.VocTable.contains(str)){
				vc5.VocTable.add(str);
			}
		}
		bw.write(String.valueOf(((float)vc5.VocTable.size()/(float)vc1.VocTable.size())*100)+"%");
		System.out.print(((float)vc5.VocTable.size()/(float)vc1.VocTable.size())*100+"%");
		
		//System.out.println(vc5.VocTable.size());
		//System.out.println(vc1.VocTable);
		//System.out.println(vc2.VocTable);
		//System.out.println(vc5.VocTable);
		
		bw.write("\n");
		System.out.println();
		bw.write("文件二包含单词总数:\n");
		System.out.print("文件二包含单词总数:\n");
		bw.write(String.valueOf(vc2.VocTable.size()));
		System.out.print(vc2.VocTable.size());
		
		bw.write("\n");
		System.out.println();
		bw.write("文件二包含文件一不包含的单词占文件一单词的百分比:\n");
		System.out.print("文件二包含文件一不包含的单词占文件一单词的百分比:\n");
		VocabularyTable vc6=new VocabularyTable();//文件二包含文件一不包含的单词词汇表
		Iterator<String> t6=vc2.VocTable.iterator();
		while(t6.hasNext()){
			str=t6.next();
			if(!vc1.VocTable.contains(str)){
				vc6.VocTable.add(str);
			}
		}
		bw.write(String.valueOf(((float)vc6.VocTable.size()/(float)vc2.VocTable.size())*100)+"%");
		System.out.print(((float)vc6.VocTable.size()/(float)vc2.VocTable.size())*100+"%");
		
		bw.close();
		fw.close();
	}

}
