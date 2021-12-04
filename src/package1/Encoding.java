package package1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Encoding 
{
	private String encode(String s) {
		String s1 = "",s2 = "";
		while(s.contains("["))
		{
			for(int i=0;i<s.length();i++)
			{
				if(s.charAt(i)==']')
				{
					int j = i-1;
					s1 = "";
					while(s.charAt(j)!='[')
					{
						s1 = s1 + s.charAt(j);
						j--;
					}
					StringBuilder sb = new StringBuilder(s1);
					s1 = sb.reverse().toString();
					int n = Integer.parseInt(String.valueOf(s.charAt(j-1)));
					s2 = "";
					for(int k=1;k<=n;k++)
					{
						s2 = s2+s1;
					}
					
					s = s.substring(0,j-1) + s2 + s.substring(i+1);
				}
			}
		}
		System.out.println(s);
		return s;
	}
	
	@Test
	public void testCase1()
	{
		Assert.assertEquals(encode("3[a]2[bc]"), "aaabcbc");
	}
	
	@Test
	public void testCase2()
	{
		Assert.assertEquals(encode("a1[b]1[cc]"), "abcc");
	}
	
	@Test
	public void testCase3()
	{
		Assert.assertEquals(encode("2[a]"), "aa");
	}

	@Test
	public void testCase4()
	{
		Assert.assertEquals(encode("3[a2[b]]"), "abbabbabb");
	}

}
