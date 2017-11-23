package com.byhealth.tcbjhome.api;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;

public class TcbjWZDevideTools {

	public static void main(String[] args) {
	    //召唤师们
	    ArrayList<String> partyReadyArray = new ArrayList<String>(Arrays.asList("小锴", "小汤", "小钟", "刘亮", "全胜", "唐炜", "伟扬", "玉霞", "洁文", "耀林"));
	    
	    HashMap<String,HashMap<String,Object>> resultTeam = new HashMap<String,HashMap<String,Object>>();
	    //j的值为局数
	    for (int j = 1; j < 6; j++) {
	    	ArrayList tempDevide = getDiffNO(10);
	    	HashMap<String, Object> tempTeam =   new HashMap<String,Object>();
	    	List<String> teamA = new ArrayList<String>();
	    	List<String> teamB = new ArrayList<String>();
	    	//5人一组
	    	for(int i = 0;i<tempDevide.size();i++){
	    		if(i<5){
	    			teamA.add(partyReadyArray.get((Integer)tempDevide.get(i)));
	    		}else{
	    			teamB.add(partyReadyArray.get((Integer)tempDevide.get(i)));
	    		}
	    	}
	    	tempTeam.put("TeamA", teamA);
	    	tempTeam.put("TeamB", teamB);
	    	
	    	resultTeam.put(String.valueOf(j), tempTeam);
		}
	    
	    
	    //遍历
	   for (Entry<String, HashMap<String, Object>> entry : resultTeam.entrySet()) {
		   System.out.println("第 " + entry.getKey()+"局：");
		   System.out.println("队伍A："+entry.getValue().get("TeamA").toString());
		   System.out.println("队伍B："+entry.getValue().get("TeamB").toString());
		  }
	    
	    
	    
	    
		
	}
	
	/**
     * 生成n个不同的随机数，且随机数区间为[0,10)
     * @param n
     * @return
     */
    public static ArrayList getDiffNO(int n){
        // 生成 [0-n) 个不重复的随机数
        // list 用来保存这些随机数
        ArrayList list = new ArrayList();
        Random rand = new Random();
        boolean[] bool = new boolean[n];
        int num = 0;
        for (int i = 0; i < n; i++) {
            do {
                // 如果产生的数相同继续循环
                num = rand.nextInt(n);
            } while (bool[num]);
            bool[num] = true;
            list.add(num);
        }
        return list;
    }

}
