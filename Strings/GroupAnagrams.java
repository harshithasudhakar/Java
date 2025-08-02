class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        List<List<String>> result = new ArrayList<List<String>>();

        for(String s : strs){
            char[] convert = s.toCharArray();
            Arrays.sort(convert);
            String sorted = new String(convert);

            if(map.containsKey(sorted)){
                map.get(sorted).add(s);
            }
            else{
                map.put(sorted, new ArrayList<>(List.of(s)));
            }
        }

        for(List<String> innerList: map.values()){
            result.add(innerList);
        }

        return result;
    }
}
