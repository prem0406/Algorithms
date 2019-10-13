import java.util.*;
class AnagramOccurence{
	public static void main(String[] args){
		String s1 = "forxxorfxdofr";
		String s2 = "for";
		int count = new AnagramOccurence().countOccurence(s1,s2);
		System.out.println("Number of Occurence : "+count);
	}
	
	public int countOccurence(String s1, String s2){
		int N = s1.length();
		int n = s2.length();
		int count = 0;
		for(int i=0; i <= N-n; i++)                //remember here <= is used to ensure s1.substring() excludes the upperbound
			if(findAnagram(s1.substring(i,i+n),s2))
				count+=1;
			
		return count;
	}
	
	public boolean findAnagram(String s1, String s2){
		char[] arr1 = s1.toCharArray();
		char[] arr2 = s2.toCharArray();
		//System.out.println(s1+"  "+s2);
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		if(Arrays.equals(arr1,arr2))
			return true;
		else
			return false;
	}
}