package com.tarun;

// just for practice, writing pseudo code and functions

import java.util.*;
import java.util.Map.Entry;

public class Tmp {

    public tmp() {

    }

    public static void main(String[] args) {

        tmp obj = new tmp();

        HashSet<Integer> hs = new HashSet<Integer>();
        obj.HashSetFn(hs, 1);

        ArrayList<String> aList = new ArrayList<String>();
        obj.ArrayListFn(aList);

        // scanner input
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        int n = Integer.parseInt(s); // no of elements
        s = input.nextLine(); // n numbers/strings separated by spaces, n = s.length();

        String sArray[] = s.split(" ");
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(sArray[i]);
        }

    }

    // writing functions below to get space for new ones,
    // its like a stack,if i write functions above, it would be difficult to find main


    public void StringFn(String string){

        String str = "abc xyz sup femme homme choco";

        int index = 4;
        int beginIndex = 3;
        int endIndex = 7;

        char ch = str.charAt(index);

        str.substring(beginIndex); // returns string
        str.substring(beginIndex, endIndex); // returns string/charSequence
        str.subSequence(beginIndex, endIndex); // same as substring fn

        char[] cArray = str.toCharArray();

        str.concat("concatfn");
        String str2 = "aaa".concat("bb");
        String s3 = new StringBuilder(str).append(str2).toString(); // aonther way to concat


        str.compareTo("anotherString");
        str.compareTo(str2); // returns 0 if strings are equal, -ve int if str is lexiographically less than str2, +ve if it is greater
        String anObject = str2;
        str.equals(anObject); // true/false
        String anotherString = str2;
        str.equalsIgnoreCase(anotherString); //   true/false


        str.toLowerCase(); // returns string converted to lower case
        str.toUpperCase();

        int fromIndex = 3;

        str.indexOf(str2, fromIndex);
        str.indexOf(ch, fromIndex);
        str.indexOf(str);
        str.indexOf(ch);
        str.lastIndexOf(str);
        str.lastIndexOf(str, fromIndex);
        str.lastIndexOf(ch, fromIndex);
        str.lastIndexOf(ch);


        String target = "aa";
        String replacement= "bb";

        str.replace(target, replacement);

        char oldChar = 'a';
        char newChar = 'b';
        String  regex = "|";
        replacement = "-";

        str.replace(oldChar, newChar);
        str.replaceAll(regex, replacement);

        str.isEmpty();
        str.length();
        str.trim() ;
        str.strip();


        String[] sArray = str.split(" ");

        String tmp = Integer.toString(7);

        String x = String.valueOf(index);
        int y = Integer.parseInt(x);


        StringBuffer sBuffer = new StringBuffer();

        StringBuffer sBuffer2 = new StringBuffer(str);

        int start =0;
        int end = 5;

        sBuffer.append(str);
        sBuffer.append(ch);
        sBuffer.append(s3, start, end);
        sBuffer.append(sBuffer2);


        sBuffer.replace(start, end, str);
        sBuffer.reverse();
        sBuffer.toString();
        sBuffer.capacity();
        sBuffer.charAt(index);
        sBuffer.deleteCharAt(index);
        sBuffer.delete(start, end);
        sBuffer.deleteCharAt(index);

        // functions are sbuilder and sbuffer are same

        StringBuilder sBuilder = new StringBuilder();

        StringBuilder sBuilder2 = new StringBuilder(str);

        sBuilder.append(str);
        sBuilder.append(ch);
        sBuilder.append(s3, start, end);
        sBuilder.append(sBuilder2);


        sBuilder.replace(start, end, str);
        sBuilder.reverse();
        sBuilder.toString();
        sBuilder.capacity();
        sBuilder.charAt(index);
        sBuilder.deleteCharAt(index);
        sBuilder.delete(start, end);
        sBuilder.deleteCharAt(index);


    }

    public void HashMapFn() {

        HashMap<Integer, String> hm = new HashMap<Integer, String>();

        hm.put(1, "value");
        hm.get(1);
        hm.remove(1);
        hm.isEmpty();
        hm.containsKey(1);
        hm.containsValue("avl");
        hm.clear();
        hm.size();
        System.out.println(hm); // will print like this : [1=value, 2=avl]

        // for each loop
        for(Map.Entry<Integer, String> entry : hm.entrySet()){
            entry.getKey();
            entry.getValue();
        }


    }


    // hashset inbuilt functions, writing for practice

    public void HashSetFn(HashSet<Integer> hs, int x) {
        if (!hs.contains(x))
            System.out.println("already exisits");

        hs.add(x);
        hs.remove(x);

        Iterator it = hs.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
            it.remove(); // to remove element after printing
        }

    }

    public void ArrayListFn(ArrayList<String> arr) {
        arr.add("aa");
        arr.add(1, "vv");

        int index = 1;
        String data = "yo";

        arr.get(index);
        arr.remove(index);
        arr.remove(data); // removes 1st occurance of data

        System.out.println(arr); // prints all elements

        arr.indexOf(data);
        arr.lastIndexOf(data);

        arr.clear(); // remove all

        ArrayList<String> arr2 = new ArrayList<>();
        arr2 =  (ArrayList<String>)arr.clone();

    }





}
