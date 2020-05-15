HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < magazine.length; i++){
            String now = magazine[i];
            if(map.containsKey(now))
                map.put(now, map.get(now) + 1);
            else
                map.put(now, 1);
        }

        for(int i = 0; i < note.length; i++){
            String now = note[i];
            if(map.containsKey(now)){
                if(map.get(now) > 1)
                    map.put(now, map.get(now) - 1);
                else
                    map.
            }
            else{
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
