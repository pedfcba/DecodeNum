/*****
翻译数字串，类似于电话号码翻译：给一个数字串，比如12259，映射到字母数组，比如，1 -> a， 2-> b，... ， 12 -> l ，... 26-> z。那么，12259 -> lyi 或 abbei 或 lbei 或 abyi。输入一个数字串，判断是否能转换成字符串，如果能，则打印所以有可能的转换成的字符串。
****/


package interview;

import java.util.HashMap;
import java.util.Map;

public class DecodeNum {

	private Map<Integer, Character> map;

	public DecodeNum()
	{
		map = new HashMap<Integer, Character>();
		init();
	}

	//��ʼ������-��ĸ��Ӧ��map����
	private void init()
	{
		char cha = 'a';
		for(int i = 1; i <= 26; i++, cha++)
			map.put(i, cha);
	}

	//��������
	public void decode(int num)
	{
		String s = "";
		int count = countNumd(num);
		System.out.println("��������֣�");
		System.out.println(num);
		System.out.println("�ɽ���Ϊ��");
		decoding(num, s, 0, count);
	}

	//numΪ��������֣�sΪ��ǰ�ѽ�����ַ�ccountΪ�����ѽ���λ��countΪ������λ��
	private void decoding(int num, String s, int ccount, int count) {
		// TODO Auto-generated method stub
		if(num == 0)
		{
			if(ccount == count)
			{
				reversOut(s);
			}
			return;
		}
		int temp = num;
		String ttemp = s;
		String htemp = s;
		//һλ�����
		int scount = ccount;
		//�λ�����
		int dcount = ccount;

		//��100������
		int hun = temp % 100;
		//��10������
		int ten = temp % 10;	

		//���һλ���ƶ�����100�������λ��ģ�����ĩλ����λ���ƶ�
		if(hun >= 10)
		{
			//ĩλ��Ϊ�㣬ȡĩλ���ƶ�һλ
			if(ten > 0)
			{
				htemp += map.get(ten);
				dcount++;
				decoding(temp/10, htemp, dcount, count);
			}
			//ĩλΪ0�������޷�ȡ���ƶ��λ
			else if (ten == 0)
			{
				dcount += 2;
				htemp += map.get(hun);
				decoding(temp/100, htemp, dcount, count);
			}
			//�λ��ɹ�����ĸ��
			if(hun <= 26)
			{
				scount += 2;
				ttemp += map.get(hun);
				decoding(temp/100, ttemp, scount, count);
			}
		}
		//��100������һλ��ֻ��ĩλ���м�¼�ͽ���
		else
		{
			//ȡ���ƶ�һλ
			if(temp/100 != 0)
			{
				dcount++;
				htemp += map.get(ten);
				decoding(temp/10, htemp, dcount, count);
			}
			htemp += map.get(ten);	
			dcount++;
			decoding(temp/10, htemp, dcount, count);
		}
	}

	//��ת�ַ�
	private void reversOut(String s) {
		// TODO Auto-generated method stub
		for(int i = s.length()-1; i >= 0; i--)
			System.out.print(s.charAt(i));
		System.out.println();
	}

	//��������λ��
	private int countNumd(int num) {
		// TODO Auto-generated method stub
		int count = 0;
		for(;num != 0;num /= 10)
			count++;
		return count;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DecodeNum dn = new DecodeNum();
		dn.decode(212);
	}

}
