package com.raccon.programmers.skill2.p1;

import java.util.*;

public class P1 {

    private Set<String> skillSet = new LinkedHashSet<>();
    private List<String> skillOrder = new ArrayList<>();

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        skillOrder = Arrays.asList(skill.split(""));
        skillSet.addAll(skillOrder);

        for(String tree : skill_trees){
            answer += checkSkillTree(tree);
        }

        return answer;
    }

    private int checkSkillTree(String tree){
        int order = 0;

        for(String str : tree.split("")){
            if(skillSet.contains(str)){
                if(!skillOrder.get(order++).equals(str)){
                    return 0;
                }
            }

            if(order == skillOrder.size()){
                break;
            }
        }

        return 1;
    }
}
