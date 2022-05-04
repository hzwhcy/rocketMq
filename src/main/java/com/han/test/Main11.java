package com.han.test;

import java.util.*;

/*
{
  "people":[
    {
      "firstName": "Brett",
      "lastName":"McLaughlin"
    }
    {
      "firstName": "Jason",
      "lastName": "Hunter"
    }
  ]
}

 */
public class Main11 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        String s;
        HashMap<Character, Integer> map = new HashMap<>();
        while(scanner.hasNextLine()){
            s = scanner.nextLine();
            if(s.equals("")){
                break;
            }
            list.add(s);
        }
        for (String s1 : list) {
            int n = s1.length();
            for(int i = 0; i < n; i++){
                if(s1.charAt(i) == '{'){
                    map.put('{',map.getOrDefault('{',0) + 1);
                }else if(s1.charAt(i) == '}'){
                    map.put('}',map.getOrDefault('}',0) + 1);
                }else if(s1.charAt(i) == '"'){
                    map.put('"',map.getOrDefault('"',0) + 1);
                }else if(s1.charAt(i) == ','){
                    map.put(',',map.getOrDefault(',',0) + 1);
                }else if(s1.charAt(i) == '['){
                    map.put('[',map.getOrDefault('[',0) + 1);
                }else if(s1.charAt(i) == ']'){
                    map.put(']',map.getOrDefault(']',0) + 1);
                }else if(s1.charAt(i) == ':'){
                    map.put(':',map.getOrDefault(':',0) + 1);
                }
            }
            if(map.containsKey('"') && map.get('"') % 2 == 1){
                set.add(3);
            }
        }

        if(map.get('{') != map.get('}')){
            set.add(2);
        }
        if(map.get('[') != map.get(']')){
            set.add(1);
        }
//        if(map.get('"') % 2 == 1){
//            list1.add(3);
//        }
        if(map.get(':') - map.get(',') != 2){
            set.add(4);
        }
        if(set.size() == 0){
            set.add(0);
        }
        ArrayList<Integer> integers = new ArrayList<>();
        for(Integer in : set){
            integers.add(in);
        }
        Collections.sort(integers);
        for (Integer integer : integers) {
            System.out.print(integer);
        }
    }
}
