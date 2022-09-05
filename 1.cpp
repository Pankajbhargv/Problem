vector<int> frequencySort(vector<int>& nums) {
        unordered_map<int,int> m;
        //key: element
        //value: freq -> compare
        
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
        vector<int> v;
         for(int i=1; i<m.size()+1; i++)
         {
             int value =  m.find(m[i])->second;
             v.push_back(value);                // pushed frequency in a vector
         }
        sort(v.begin(),v.end(),[](int a,int b){
            if(a>b)
            return true;
            else
            return false;                     //arrange freq in dec order
        });
        
        //now i want to print key in number of time freq
        //i tried this way:
        
         v for(int i= 0; i<v.size(); i++)
        {
            for(auto it=m.begin(); it!=m.end(); it++)
            {
                if(it->second==v[i])
                {
                    for(int i=0; i<it->second; it++)
                    {g.push_back(it->first);}
                }
            }
        }
            
        }
        return g;
    
       
       
     //  this part m doing something wrong 
       
