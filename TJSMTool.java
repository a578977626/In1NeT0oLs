package com.byhealth.tcbjhome.api.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Map.Entry;

public class TJSMTool {

	public static void main(String[] args) {
	    //召唤师们
		
		//最特殊的两个
		String storongA = "小钟";
		String storongB = "小锴";
		
		//强的队伍
		ArrayList<String> strongReadyArray = new ArrayList<String>(Arrays.asList("刘亮", "小汤", "伟扬","耀林"));//发现相邻的永远不会重复
		//弱的队伍
		ArrayList<String> weakReadyArray = new ArrayList<String>(Arrays.asList("洁文", "唐炜",  "玉霞", "全胜"));//发现相邻的永远不会重复
		
		//最终结果
		HashMap<String,HashMap<String,Object>> resultTeam = new HashMap<String,HashMap<String,Object>>();
		
				
		List<String> teamA = new ArrayList<String>();
		teamA.add(storongA);
		teamA.add(strongReadyArray.get(0));
		teamA.add(strongReadyArray.get(1));
		teamA.add(weakReadyArray.get(2));
		teamA.add(weakReadyArray.get(3));
		
		List<String> teamB = new ArrayList<String>();
		teamB.add(storongA);
		teamB.add(strongReadyArray.get(1));
		teamB.add(strongReadyArray.get(2));
		teamB.add(weakReadyArray.get(0));
		teamB.add(weakReadyArray.get(3));
		
		List<String> teamC = new ArrayList<String>();
		teamC.add(storongA);
		teamC.add(strongReadyArray.get(2));
		teamC.add(strongReadyArray.get(3));
		teamC.add(weakReadyArray.get(0));
		teamC.add(weakReadyArray.get(1));
		
		List<String> teamD = new ArrayList<String>();
		teamD.add(storongA);
		teamD.add(strongReadyArray.get(0));
		teamD.add(strongReadyArray.get(3));
		teamD.add(weakReadyArray.get(1));
		teamD.add(weakReadyArray.get(2));
		
		List<String> teamE = new ArrayList<String>();
		teamE.add(storongA);
		teamE.add(strongReadyArray.get(2));
		teamE.add(strongReadyArray.get(3));
		teamE.add(weakReadyArray.get(2));
		teamE.add(weakReadyArray.get(3));
	    
	   //
		List<Object>  teamLIst = new ArrayList<Object>();
		teamLIst.add(teamA);
		teamLIst.add(teamB);
		teamLIst.add(teamC);
		teamLIst.add(teamD);
		teamLIst.add(teamE);
		   
		//两场对局   
//		HashMap<String, Object> tempTeam =   new HashMap<String,Object>();
	    
	    
	    
	    
	    
	    	
	    	for(int j = 0 ;j<teamLIst.size();j++){
	    		HashMap<String, Object> tempTeam =   new HashMap<String,Object>();
	    		tempTeam.put("TeamA", teamLIst.get(j));
	    		List<String> tempB = geneTeamRevse((List<String>) teamLIst.get(j), strongReadyArray, weakReadyArray);
	    		tempB.add(storongB);
	    		tempTeam.put("TeamB",tempB);
	    		resultTeam.put(String.valueOf(j+1), tempTeam);
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
    
    public static List<String> geneTeamRevse(List<String> team,ArrayList<String> strong,ArrayList<String> weak){
    	List<String> teamRes = new ArrayList<String>();
    	for(String temp : strong){
    		if(!team.contains(temp)){
    			teamRes.add(temp);
    		}
    	}
    	for(String temp : weak){
    		if(!team.contains(temp)){
    			teamRes.add(temp);
    		}
    	}
    	
		return teamRes;
    }

}
