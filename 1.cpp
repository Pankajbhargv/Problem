vector<int> frequencySort(vector<int>& nums) {
        unordered_map<int,int> m;
        //key: element
        //value: freq -> compare
        
//         lets take eq of 
//         nums = [1,1,2,2,2,3]
//         output = [3,1,1,2,2,2]
        
        int freq;
        
        for(int i=0; i<nums.size(); i++)
        {
            if(m.find(nums[i])==m.end())
            {
                freq=1;
                m.insert({nums[i],freq});
            }
            else
            {
               freq = m.find(nums[i])->second;
                freq++;
                m.find(nums[i])->second=freq;     //fixed element with frquency
            }
        }
        
//         m map: key   value 
//                 1       2
//                 2       3
//                 3       1
        
        vector<int> v;
         for(int i=1; i<m.size()+1; i++)
         {
             int value =  m.find(m[i])->second;
             v.push_back(value);                // pushed frequency in a vector
                                                // v = 2,3,1 these are the value element of map
         }
        sort(v.begin(),v.end(),[](int a,int b){
            if(a>b)
            return true;
            else
            return false;                     //arrange freq in dec order
                                             // v= 3,2,1
        });
        
        //now i want to print key in number of time freq
        //i tried this way:
        
       for(int i= 0; i<v.size(); i++)
        {
            for(auto it=m.begin(); it!=m.end(); it++)
            {
                if(it->second==v[i])
                {
                    for(int i=0; i<it->second; it++)
                    {ge.push_back(it->first);}
                }
            }
        }
           return ge;                          // here I ruined (inc time complexity)                                                                         
        }
     
       
     //  this part m doing something wrong 
       

// ERROR:
// Line 340: Char 30: runtime error: member call on null pointer of type 'std::__detail::_Hash_node_value_base<std::pair<const int, int>>' (hashtable_policy.h)
//SUMMARY: UndefinedBehaviorSanitizer: undefined-behavior /usr/bin/../lib/gcc/x86_64-linux-gnu/9/../../../../include/c++/9/bits/hashtable_policy.h:349:30
