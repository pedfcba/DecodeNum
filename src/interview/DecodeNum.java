/*****
缈昏瘧鏁板瓧涓诧紝绫讳技浜庣數璇濆彿鐮佺炕璇戯細缁欎竴涓暟瀛椾覆锛屾瘮濡�2259锛屾槧灏勫埌瀛楁瘝鏁扮粍锛屾瘮濡傦紝1 -> a锛�2-> b锛�.. 锛�12 -> l 锛�.. 26-> z銆傞偅涔堬紝12259 -> lyi 鎴�abbei 鎴�lbei 鎴�abyi銆傝緭鍏ヤ竴涓暟瀛椾覆锛屽垽鏂槸鍚﹁兘杞崲鎴愬瓧绗︿覆锛屽鏋滆兘锛屽垯鎵撳嵃鎵�互鏈夊彲鑳界殑杞崲鎴愮殑瀛楃涓层�
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

	//鍒濆鍖栨暟瀛�瀛楁瘝瀵瑰簲鐨刴ap瀹瑰櫒
	private void init()
	{
		char cha = 'a';
		for(int i = 1; i <= 26; i++, cha++)
			map.put(i, cha);
	}

	//瑙ｇ爜鏁板瓧
	public void decode(int num)
	{
		String s = "";
		int count = countNumd(num);
		System.out.println("寰呰В鐮佹暟瀛楋細");
		System.out.println(num);
		System.out.println("鍙В鐮佷负锛");
		decoding(num, s, 0, count);
	}

	//num涓哄緟瑙ｇ爜鏁板瓧锛宻涓哄綋鍓嶅凡瑙ｇ爜鐨勫瓧绗︿覆锛宑count涓烘暟瀛楀凡瑙ｇ爜浣嶆暟锛宑ount涓烘暟瀛楁�浣嶆暟
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
		//涓�綅鏁拌鏁�
		int scount = ccount;
		//涓や綅鏁拌鏁�
		int dcount = ccount;

		//涓�00鐨勪綑鏁�
		int hun = temp % 100;
		//涓�0鐨勪綑鏁�
		int ten = temp % 10;	

		//閽堝涓�綅鏁扮Щ鍔紝涓�00鐩镐綑鏄袱浣嶆暟鐨勶紝瑙ｇ爜鏈綅鍜岄浣嶅苟绉诲姩
		if(hun >= 10)
		{
			//鏈綅涓嶄负闆讹紝鍙栨湯浣嶏紝绉诲姩涓�綅
			if(ten > 0)
			{
				htemp += map.get(ten);
				dcount++;
				decoding(temp/10, htemp, dcount, count);
			}
			//鏈綅涓�鐨勬暣鏁帮紝鏃犳硶鍙栨暟锛岀Щ鍔ㄤ袱浣�
			else if (ten == 0)
			{
				dcount += 2;
				htemp += map.get(hun);
				decoding(temp/100, htemp, dcount, count);
			}
			//涓や綅鏁板彲鏋勬垚瀛楁瘝鐨�
			if(hun <= 26)
			{
				scount += 2;
				ttemp += map.get(hun);
				decoding(temp/100, ttemp, scount, count);
			}
		}
		//涓�00鐩镐綑鏄竴浣嶆暟锛屽彧瀵规湯浣嶈繘琛岃褰曞拰瑙ｇ爜
		else
		{
			if(hun == 0)
			{
				System.out.println("瀛樺湪鏃犳硶杞崲鐨勬暟");
				return;
			}
				
			//鍙栨暟锛岀Щ鍔ㄤ竴浣�
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

	//鍙嶈浆瀛楃涓�
	private void reversOut(String s) {
		// TODO Auto-generated method stub
		for(int i = s.length()-1; i >= 0; i--)
			System.out.print(s.charAt(i));
		System.out.println();
	}

	//璁＄畻鏁板瓧浣嶆暟
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
