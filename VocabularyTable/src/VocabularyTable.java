import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class VocabularyTable {

	TreeSet<String> VocTable = new TreeSet<String>();// ����ȡһ���ļ��ĵ��ʷŵ��ʻ����

	public void readFile(File filePath) {
		try {
			FileReader fr = new FileReader(filePath);
			String voc = "";// ��ŵ���
			char[] c = new char[1];// ÿ�ζ�ȡһ����ĸ
			int b = 0;
			while ((b = fr.read(c)) != -1)// ÿ�ζ�ȡһ����ĸֱ�����
			{// ����ַ�Ϊ ���С��ո񡢵����š�˫���š����š���ŵȲ�����ĸ�� ��Ϊһ�����ʵĽ�������һ�����ʵĿ�ʼ
				if (c[0]<65||(c[0]>90&&c[0]<97)||c[0]>122||c[0]=='-') {
					VocTable.add(voc);
					voc="";

				} else {
					voc += String.valueOf(c).toLowerCase();//����ͳһת��ΪСд��ĸ
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
		System.out.println("�������һ���ļ��ļ�·��(��F:/1.txt)��");
		String filePath1=scan.next();
		File file1 = new File(filePath1);
		VocabularyTable vc1=new VocabularyTable();//��һ���ļ��ʻ��
		vc1.readFile(file1);
		
		System.out.println("������ڶ����ļ��ļ�·��(��F:/1.txt)��");
		String filePath2=scan.next();
		File file2 = new File(filePath2);
		VocabularyTable vc2=new VocabularyTable();//�ڶ����ļ��ʻ��
		vc2.readFile(file2);
		
		VocabularyTable vc3=new VocabularyTable();//�����ļ��ܵ��ļ��ʻ��
		vc3.VocTable.addAll(vc1.VocTable);
		vc3.VocTable.addAll(vc2.VocTable);
		
		VocabularyTable vc4=new VocabularyTable();//�����ļ��ʻ��Ľ���
		Iterator<String> t1=vc1.VocTable.iterator();
		while(t1.hasNext()){
			str=t1.next();
			if(vc2.VocTable.contains(str)){
				vc4.VocTable.add(str);
			}
		}
		
		
		//�����д���ļ�
		System.out.print("������������ļ���·��(��F:/1.txt):\n");
		String outFile=scan.next();
		File file = new File(outFile);
		if (!file.exists())
			file.createNewFile();
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("�����ļ������Ĵʻ��:\n");
		System.out.print("�����ļ������Ĵʻ��:\n");
		Iterator<String> t2=vc3.VocTable.iterator();
		while(t2.hasNext()){
			str=t2.next();
			bw.write(str+" ");
			System.out.print(str+" ");
		}
		bw.write("\n");
		System.out.println();
		bw.write("�����ļ������Ĵʻ��:\n");
		System.out.print("�����ļ������Ĵʻ��:\n");
		Iterator<String> t3=vc4.VocTable.iterator();
		while(t3.hasNext()){
			str=t3.next();
			bw.write(str+" ");
			System.out.print(str+" ");
		}
		bw.write("\n");
		System.out.println();
		bw.write("�ļ�һ������������:\n");
		System.out.print("�ļ�һ������������:\n");
		bw.write(String.valueOf(vc1.VocTable.size()));
		System.out.print(vc1.VocTable.size());
		
		bw.write("\n");
		System.out.println();
		bw.write("�ļ�һ�����ļ����������ĵ���ռ�ļ�һ���ʵİٷֱ�:\n");
		System.out.print("�ļ�һ�����ļ����������ĵ���ռ�ļ�һ���ʵİٷֱ�:\n");
		VocabularyTable vc5=new VocabularyTable();//�ļ�һ�����ļ����������ĵ��ʴʻ��
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
		bw.write("�ļ���������������:\n");
		System.out.print("�ļ���������������:\n");
		bw.write(String.valueOf(vc2.VocTable.size()));
		System.out.print(vc2.VocTable.size());
		
		bw.write("\n");
		System.out.println();
		bw.write("�ļ��������ļ�һ�������ĵ���ռ�ļ�һ���ʵİٷֱ�:\n");
		System.out.print("�ļ��������ļ�һ�������ĵ���ռ�ļ�һ���ʵİٷֱ�:\n");
		VocabularyTable vc6=new VocabularyTable();//�ļ��������ļ�һ�������ĵ��ʴʻ��
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
