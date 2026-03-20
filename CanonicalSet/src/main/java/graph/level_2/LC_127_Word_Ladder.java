package graph.level_2;

import java.util.*;

public class LC_127_Word_Ladder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //If begin and end are same then return
        if(beginWord.equals(endWord)) return 1;

        //Put all the wordList to dictionary for O(1) op
        Set<String> dictionary=new HashSet<>();
        for(String s: wordList)
            dictionary.add(s);

        //if the endWord not present then return
        if(!wordList.contains(endWord)) return 0;

        //Maintain 2 sets from each end for quick finding
        Set<String> beginSet=new HashSet<>();
        Set<String> endSet=new HashSet<>();

        int level=1; //because at least 1 transformation required

        //add the initial words to both sets
        beginSet.add(beginWord);
        endSet.add(endWord);

        while(!beginSet.isEmpty() && !endSet.isEmpty()){ //if 1 of them is empty then there is no meaning to proceed
            //start from the smaller set
            if(beginSet.size()>endSet.size()){
                Set<String> temp=beginSet;
                beginSet=endSet;
                endSet=temp;
            }
            Set<String> nextSet=new HashSet<>(); //Contains Strings for next level
            for(String word:beginSet){ //start from all words from the smallest set
                for(String nxt: getNextWords(word)){
                    if(endSet.contains(nxt)) return level+1; //Match found;
                    if(dictionary.contains(nxt)){ //if the word present in dictionary then remove it
                        nextSet.add(nxt);
                        dictionary.remove(nxt);
                    }
                }
            }
            beginSet=nextSet; //assigning back to either og sets
            level++; //move to next level
        }
        return 0; //if the target not matched from both ends
    }

    private List<String> getNextWords(String word){
        List<String> result=new ArrayList<>();
        char[] temp=word.toCharArray();
        for(int i=0;i<temp.length;i++){
            char og=temp[i];
            for(char c='a';c<='z';c++){
                if(c==og) continue;
                temp[i]=c;
                result.add(new String(temp));
            }
            temp[i]=og; //replace back with og character for further creation of new word (backtracking)
        }
        return result;
    }
}
