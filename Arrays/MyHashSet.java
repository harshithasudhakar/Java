class MyHashSet { // Design a  HashSet without a HashSet

    List<Integer> set;
    
    public MyHashSet() {
        set = new ArrayList<>();
    }
    
    public void add(int key) {
        for(int i = 0; i<set.size(); i++){
            if(key == set.get(i)){
                return;
            }
        }

        set.add(key);
    }
    
    public void remove(int key) {
        
        if(set.size() == 0){
            return;
        }

        set.remove(Integer.valueOf(key));
    }
    
    public boolean contains(int key) {
        for(int i = 0; i<set.size(); i++){
            if(key == set.get(i)){
                return true;
            }
        }

        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
