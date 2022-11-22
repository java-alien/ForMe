package assignments;

import java.util.Arrays;

public class Assignment4 
{
	@SuppressWarnings("unused")
	private static String countVowelsConsonantsAndSpecialCharacters(String string)
	{
		string=string.replace(" ","");
		int vowelCount=0,
			consonantCount=0,
			specialCharactersCount=0,
			codePoint=0;
		for(int t=0;t<string.length();t++)
		{
			if("aeiouAEIUO".contains(""+string.charAt(t)))
				vowelCount++;
			else if(65<=string.codePointAt(t) && string.codePointAt(t)<=90 || 97<=string.codePointAt(t) && string.codePointAt(t)<=122)
				consonantCount++;
			else
				specialCharactersCount++;
		}
		return "Count of vowels, special characters and consonants are as follows :\nVowels - "+vowelCount+"\nConsonants - "+consonantCount+"\nSpecial Characters - "+specialCharactersCount;
	}
	
	private static String verifyPalindrome(String string)
	{
		string=string.toLowerCase();
		boolean flag=true;
		for(int t=0;t<=string.length()/2;t++)
		{
			if(!(string.charAt(t)==string.charAt(string.length()-1-t)))
			{
				flag=false;
				break;
			}
		}
		return flag ? "Given string is a palindrome" : "Given string is not a plaindrome";
	}
	
	private static void  findDuplicateCharacters(String string) 
	{
		string=string.replace(" ","");
		String tempString="",
			   duplicates="";
		for(int t=0;t<string.length();t++)
			if(tempString.contains(""+string.charAt(t)) && duplicates.contains(""+string.charAt(t)))
				duplicates+=string.charAt(t);
		System.out.println(duplicates);
		System.out.println(duplicates=="" ? "There's no duplicate in the given string" : "Duplicates in the given string : "+Arrays.toString(tempString.split("")));
	}
	
    private static String removeDuplicates(String string)
    {
        String tempString="";
        for(int t=0;t<string.length();t++)
            if(!tempString.contains(""+string.charAt(t)))
                tempString+=string.charAt(t);
        return tempString.equals(string) ? "Given string doesn't have any duplicate characters" :"String without duplicates : "+tempString;
    }

    private static String findDuplicates(String string)
    {
        String tempString="",
               duplicates="";
        for(int t=0;t<string.length();t++)
            if(!tempString.contains(""+string.charAt(t)))
                tempString+=string.charAt(t);
            else
                duplicates+=string.charAt(t);
        return duplicates=="" ? "Given string don't have any duplicates." :"Duplicate characters in the string are : "+Arrays.toString(findDuplicates("karthikeyan").split(""));
    }

    private static String findMaximumOccuringCharacters(String string)
    {
        string=string.toLowerCase();
        String tempString = "",
               stringIndex="";
        int index;
        for(int t=0;t<string.length();t++)
            if(tempString.contains(""+string.charAt(t)))
            {
                index=tempString.indexOf(string.charAt(t));
               // System.out.println("***"+stringIndex.substring(index,index+1)+"\n"+(Integer.parseInt(stringIndex.substring(index,index+1))+1)+"***");
                System.out.println("--------"+(Integer.parseInt(stringIndex.substring(index,index+1))+1));
                stringIndex=stringIndex.replace(stringIndex.substring(index,index+1),""+(Integer.parseInt(stringIndex.substring(index,index+1))+1));
            }
            else
            {
                tempString+=string.charAt(t);
                stringIndex+=1;
            }
        return tempString+"\n"+stringIndex;
    }

    private static char[] sortArray(char c[])
    {
        char cc;
        for(int t1=0;t1<c.length;t1++)
            for(int t2=t1+1;t2<c.length;t2++)
                if((int)c[t1]>(int)c[t2])
                {
                    cc=c[t1];
                    c[t1]=c[t2];
                    c[t2]=cc;
                }
        return c;
    }
    private static String verifyAnagramString(String string1,String string2)
    {
        boolean flag=true;
        if(string1.length()==string2.length())
        {
            char[] c1 = sortArray(string1.toCharArray()),
                   c2 = sortArray(string2.toCharArray());
            for(int t=0;t<c1.length;t++)
                if(!(c1[t]==c2[t]))
                {
                    flag=false;
                    break;
                }
        }
        else
            flag=false;
        return flag? "Give strings are Anagram strings" : "Given strings are not Anagram strings";
    }

    private static String verifyStringUniqueCharacters(String string)
    {
        string=string.toLowerCase();
        String tempString="";
        for(String ss:string.split(""))
            if (tempString.contains(ss))
                break;
            else
                tempString +=ss;
        return string.equals(tempString) ? "Given string contains all unique characters" : "Given string does not have unique characters";
    }

    private static String verifyPangramString(String string)
    {
        boolean flag=true;
        for(String s:"abcdefghijklmnopqrstuvwxyz".split(""))
            if(!string.contains(s))
            {
                flag=false;
                break;
            }
        return flag ? "Given string is Pangram":"Given string is not Pangram";
    }
	
	public static void main(String[] args)
	{
		//2.WAP to print Duplicates characters from the String.
		findDuplicateCharacters("Amarendar Singh is going to have his");
		//3.WAP to check if “2552” is palindrome or not
		System.out.println(verifyPalindrome("205676502"));
		//4.WAP to count the number of consonants, vowels, special characters in a String.
		System.out.println(countVowelsConsonantsAndSpecialCharacters("Amarendar Singh is going to have his first ceremony #$&*"));
		System.out.println(removeDuplicates("malayalam"));
	    System.out.println(findDuplicates("kiran"));
	    System.out.println(verifyStringUniqueCharacters("Sales"));
	    System.out.println(verifyAnagramString("amar","rama"));
	    System.out.println(verifyPangramString("The quick brown fox jumps over the lazy dog"));
	    System.out.println(findMaximumOccuringCharacters("Malayalam"));
	}
}